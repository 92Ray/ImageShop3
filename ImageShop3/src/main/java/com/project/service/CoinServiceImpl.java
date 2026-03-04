package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.ChargeCoin;
import com.project.domain.Member;
import com.project.domain.PayCoin;
import com.project.mapper.CoinMapper;

@Service
public class CoinServiceImpl implements CoinService {
	@Autowired
	private CoinMapper mapper;

	@Override
	public int charge(ChargeCoin chargeCoin) throws Exception {
		// 1. 해당 사용자 코인 충전 진행
		mapper.charge(chargeCoin);

		// 2. 코인충전 내역서 생성
		return mapper.create(chargeCoin);

	}

	@Override
	public List<ChargeCoin> list(int userNo) throws Exception {
		return mapper.list(userNo);
	}

	// 회원 코인 차감(지불)
	public int pay(PayCoin payCoin) throws Exception{
		return mapper.pay(payCoin);
	}

	// 구매 내역 등록
	public int createPayHistory(PayCoin payCoin) throws Exception{
		return mapper.createPayHistory(payCoin);
	}

	public List<PayCoin> listPayHistory(Member member) throws Exception {
		return mapper.listPayHistory(member);
	}

}
