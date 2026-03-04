package com.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.domain.BoardComment;
import com.project.service.BoardCommentService;

@RestController
@RequestMapping("/comments")
public class BoardCommentController {

    @Autowired
    private BoardCommentService service;

    // 댓글 등록
    @PostMapping
    public ResponseEntity<String> register(@RequestBody BoardComment comment) throws Exception {
        if (service.register(comment) != 0) {
            return ResponseEntity.ok("SUCCESS");
        }
        return ResponseEntity.internalServerError().body("FAILED");
    }

    // 댓글 조회
    @GetMapping("/{boardNo}")
    public ResponseEntity<List<BoardComment>> list(@PathVariable Long boardNo) throws Exception {
        return ResponseEntity.ok(service.listByBoardNo(boardNo));
    }

    // 댓글 삭제
    @DeleteMapping("/{commentNo}")
    public ResponseEntity<String> remove(@PathVariable Long commentNo) throws Exception {
        if (service.remove(commentNo) != 0) {
            return ResponseEntity.ok("SUCCESS");
        }
        return ResponseEntity.internalServerError().body("FAILED");
    }
}