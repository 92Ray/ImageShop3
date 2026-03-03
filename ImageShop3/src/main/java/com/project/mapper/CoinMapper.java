package com.project.mapper;

import java.util.List;

import com.project.domain.ChargeCoin;

public interface CoinMapper {
	
	// 충전 내역 등록 
	public int create(ChargeCoin chargeCoin) throws Exception; 

	// 코인 충전 
	public int charge(ChargeCoin chargeCoin) throws Exception;
	
	// 충전 내역 조회 
	public List<ChargeCoin> list(int userNo) throws Exception;
}
