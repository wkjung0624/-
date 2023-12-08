package com.p2pcenter.lendingmachine.bank.controller.dto;

import lombok.Data;

@Data
public class FrnrCurrency_IDT {
	private String authKey;
	private String searchDate;
	private String data;

	public String toQueryString() {
		StringBuffer queryString = new StringBuffer();

		queryString.append("?authkey=").append(this.getAuthKey());
		queryString.append("&searchdate=").append(this.getSearchDate());
		queryString.append("&data=").append(this.getData());

		return queryString.toString();
	}
}


//	authkey		String(필수)	인증키			OpenAPI 신청시 발급된 인증키
//	searchdate	String		검색요청날짜		ex) 2015-01-01, 20150101, (DEFAULT)현재일
//	data		String(필수)	검색요청API타입	AP01 : 환율, AP02 : 대출금리, AP03 : 국제금리
