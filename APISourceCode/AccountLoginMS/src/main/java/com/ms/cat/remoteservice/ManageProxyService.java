package com.ms.cat.remoteservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;


import com.ms.cat.dto.ManageProxyDTO;
import com.ms.cat.model.ManageProxyRepsonse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class ManageProxyService {


	@Bean
	@LoadBalanced
	public RestTemplate createRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;
	

	public ManageProxyRepsonse addProxyDef(@RequestHeader("Authorization") String authorizationToken,@RequestBody ManageProxyDTO product) {
		
		return new ManageProxyRepsonse();
	}

	public ManageProxyDTO updateProxyDef(@RequestHeader("Authorization") String authorizationToken,@RequestBody ManageProxyDTO product) throws NODataFoundException
	{
		return new ManageProxyDTO();
	}

	public List<ManageProxyDTO> getProxyDef(@RequestHeader("Authorization") String authorizationToken)
	{
		String url = "http://" + "manageproxyms" + "/proxydef/getProxyDef";
		System.out.println("Calling :" + url);
		ManageProxyDTO manageProxyDTO = null;
		HttpEntity<ManageProxyDTO> dRequest = new HttpEntity<ManageProxyDTO>(manageProxyDTO);
		List<ManageProxyDTO> dResponse = (List<ManageProxyDTO>) restTemplate
				.postForEntity(url, dRequest, ManageProxyDTO.class).getBody();
		return dResponse;
	}

	public  ManageProxyDTO getProxyDefById(@RequestHeader("Authorization") String authorizationToken,@PathVariable int id) throws NODataFoundException
	{
		ManageProxyDTO manageProxyDTO = new ManageProxyDTO("",String.valueOf(id),"");
		HttpEntity<ManageProxyDTO> dRequest = new HttpEntity<ManageProxyDTO>(manageProxyDTO);
		ManageProxyDTO dResponse = restTemplate
				.postForEntity("http://discountms/caldisc", dRequest, ManageProxyDTO.class).getBody();
		return dResponse;
	}

	public String deleteProxyDef(@RequestHeader("Authorization") String authorizationToken,@PathVariable String name) throws NODataFoundException
	{
		return "";
	}

	


	/*
	@HystrixCommand(fallbackMethod = "discountFallback")
	public ProductDTO calculateDiscountv3(Product p) {
		DiscountRequest discountRequest = createDiscountRequest(p);
		HttpEntity<DiscountRequest> dRequest = new HttpEntity<DiscountRequest>(discountRequest);
		DiscountResponse dResponse = restTemplate
				.postForEntity("http://discountms/caldisc", dRequest, DiscountResponse.class).getBody();
		return ceateProductResponseDTO(dResponse, p);

	}*/

	



}
