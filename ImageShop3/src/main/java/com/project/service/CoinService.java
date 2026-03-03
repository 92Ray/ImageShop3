package com.project.service;

import java.util.List;

import com.project.domain.ChargeCoin;

public interface CoinService {
	// 코인 충전 처리 
	public int charge(ChargeCoin chargeCoin) throws Exception; 
	// 충전 내역 페이지 
	public List<ChargeCoin> list(int userNo) throws Exception;

}
