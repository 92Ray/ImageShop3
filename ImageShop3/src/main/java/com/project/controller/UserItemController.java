package com.project.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.commom.security.domain.CustomUser;
import com.project.domain.Item;
import com.project.domain.Member;
import com.project.service.MemberService;
import com.project.service.UserItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/useritem")
public class UserItemController {
	@Autowired
	private UserItemService service;

	// 업무로직을 처리할 서비스 객체를 필드로 선언한다.
	// 회원정보 관리서비스
	@Autowired
	private MemberService memberService;

	// 사용자 구매 비즈니스 서비스
	@Autowired
	private UserItemService userItemService;

	// 메시지를 처리할 MessageSource를 필드로 선언한다.
	@Autowired
	private MessageSource messageSource;

	@Value("${upload.path}")
	private String uploadPath;

	// 상품 구매 요청을 처리한다.
	@PostMapping("/buy")
	@PreAuthorize("hasRole('ROLE_MEMBER', 'ROLE_ADMIN')")
	public String buy(Item item, RedirectAttributes rttr, Authentication authentication) throws Exception {
		// 인증된 사용자정보를 가져오고, 
		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		Member member = customUser.getMember();
		int userNo = member.getUserNo();
		member.setCoin(memberService.getCoin(userNo));

		Item item = itemService.read(itemId);
		userItemService.register(member, item);
		String message = messageSource.getMessage("item.purchaseComplete", null, Locale.KOREAN);
		rttr.addFlashAttribute("msg", message);

		return "redirect:/item/success";
	}

	// 상품 구매 성공 페이지를 표시한다.
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String success() throws Exception {
		return "item/success";
	}

	// 상품 등록 페이지
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String registerForm(Model model) {
		model.addAttribute(new Item());

		return "item/register";
	}

	// 상품 등록 처리
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String register(Item item, RedirectAttributes rttr) throws Exception {
		MultipartFile pictureFile = item.getPicture();
		MultipartFile previewFile = item.getPreview();

		String createdPictureFilename = uploadFile(pictureFile.getOriginalFilename(), pictureFile.getBytes());
		String createdPreviewFilename = uploadFile(previewFile.getOriginalFilename(), previewFile.getBytes());

		item.setPictureUrl(createdPictureFilename);
		item.setPreviewUrl(createdPreviewFilename);

		itemService.register(item);

		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/item/list";
	}

}
