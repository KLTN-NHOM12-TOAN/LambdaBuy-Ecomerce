package com.example.kltn.SpringAPILambdaBuy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kltn.SpringAPILambdaBuy.common.request.authen.LoginDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.authen.RegisterDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.AuthResponse;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;
import com.example.kltn.SpringAPILambdaBuy.service.AuthenticationService;
import com.example.kltn.SpringAPILambdaBuy.service.UserService;
import com.example.kltn.SpringAPILambdaBuy.utils.JwtTokenUtil;

@RestController
@RequestMapping("/authentication/")
public class AuthenticationController {
	private static final String APPLICATION_JSON_VALUE = "application/json";
	
	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@GetMapping("/register/confirm/{token_code}")
	public ResponseEntity<ResponseCommon<?>> confirm (@PathVariable("token_code") String token_code){
		return new ResponseEntity<ResponseCommon<?>>(authenticationService.confirmToken(token_code), HttpStatus.OK);
	}
	
	@PostMapping("/seed-admin")
	public ResponseEntity<ResponseCommon<?>> seedAdmin (){
		return new ResponseEntity<ResponseCommon<?>>(authenticationService.seedAdmin(), HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<ResponseCommon<?>> register (@RequestBody RegisterDto registerDto){
		return new ResponseEntity<ResponseCommon<?>>(authenticationService.register(registerDto), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login (@RequestBody LoginDto loginDto) {
		try {
			Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())	
			);
			
			UserEntity user = (UserEntity) authentication.getPrincipal();
			String accessToken = jwtTokenUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getEmail(), accessToken);
//            authenticationService.login(loginDto);
            return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "LOGIN_SUCCESS", response));
		} catch (BadCredentialsException e) {
			
			return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "UNAUTHORIZED", null));
		}
	}
}
