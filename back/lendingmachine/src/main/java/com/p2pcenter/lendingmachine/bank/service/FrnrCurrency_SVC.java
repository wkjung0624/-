package com.p2pcenter.lendingmachine.bank.service;

import com.p2pcenter.lendingmachine.bank.controller.dto.FrnrCurrency_IDT;
import com.p2pcenter.lendingmachine.common.user.controller.dto.UserInfoInq_GRID_ODT;
import com.p2pcenter.lendingmachine.common.user.controller.dto.UserInfoInq_IDT;
import com.p2pcenter.lendingmachine.common.user.controller.dto.UserInfoInq_ODT;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class FrnrCurrency_SVC {

	private final String KREXIM_APIKEY = "DpMkM9lxo0PjRxM4KQZEgY0MTXYYQv4X";
	private final String KREXIM_URL    = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";

	public String getNoticeExchangeRate(FrnrCurrency_IDT input) throws IOException, InterruptedException {
		HttpClient httpClient = HttpClient.newHttpClient();

		input.setAuthKey(KREXIM_APIKEY);
		input.setData("AP01");				// AP01 : 환율

		HttpRequest request = HttpRequest.newBuilder()
			.GET()
			.uri(URI.create("https://www.koreaexim.go.kr/site/program/financial/exchangeJSON"+input.toQueryString()))
			.build();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		String responseBody = response.body();

		System.out.println("호출함"+responseBody);

		return responseBody;
	}
}