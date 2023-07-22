package com.kltn.nhom12.LambdaBuyDesktop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.example.kltn.SpringAPILambdaBuy.common.request.authen.LoginDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.UserRole;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kltn.nhom12.LambdaBuyDesktop.service.AuthenticationDesktopService;
import com.kltn.nhom12.LambdaBuyDesktop.service.UserDesktopService;

@SpringBootApplication
//@EnableCaching
public class LambdaBuyDesktopApplication {
	public static UserDesktopService userWebService = new UserDesktopService();
	public static AuthenticationDesktopService authenticationWebService = new AuthenticationDesktopService();
	
	public static void main(String[] args) {
		SpringApplication.run(LambdaBuyDesktopApplication.class, args);
	
//		List<UserResponseDto> list = userWebService.getAllUser();
//		System.out.println(list);
//		List<UserResponseDto> list = userWebService.getAllUser();
//		if(!list.isEmpty()) {
//			for (UserResponseDto userResponseDto : list) {
//				System.out.println("aaaaaaaa: " +userResponseDto);
//				System.out.println(userResponseDto.getId());
//			}
//		}else {
//			System.out.println("Aaaaaaaaaaaa: ");
//		}
//		
//		
//		UserResponseDto userId = userWebService.getUserById("74346d70-d551-4075-bf8a-dc57e847c882");
//		if(userId != null) {
//			System.out.println("Aaaaaaaaaaaa: " +userId.getUsername() + " - " + userId.getEmail() + "-" + userId.getCreatedDate());
//		} else {
//			System.out.println("Aaaaaaaaaaaa: ");
//		}
		
//		UserResponseDto user = userWebService.getUserByUsername("vantoan");
//		System.out.println(user.getUsername() + " - " + user.getEmail());
//		
//		UserResponseDto userMail = userWebService.getUserByEmail("vantoan10c2@gmail.com");
//		System.out.println(userMail.getUsername() + " - " + userMail.getEmail());
		
//		RegisterDto register = new RegisterDto("Toan", "Le", "lvtoan.it2000@gmail.com", "lvtoan", "123123", "123123");
//		System.out.println(authenticationWebService.register(register));
//		LoginDto login = new LoginDto();
//		login.setEmail("vantoan10c2@gmail.com");
//		login.setPassword("123123");
//		System.out.println(((UserResponseDto) authenticationWebService.login(login)).getRole());;
//		UserEntity createUser = new UserEntity("lvtoancv", "lvtoan.cv@gmail.com", "123123", UserRole.CUSTOMER, new Date(), "Toan cv");
//		System.out.println(userWebService.saveUser(createUser));
//		System.out.println(userWebService.deteleUserById("74346d70-d551-4075-bf8a-dc57e847c882"));
		
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
