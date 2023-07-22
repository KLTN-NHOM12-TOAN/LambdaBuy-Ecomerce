package com.example.kltn.SpringAPILambdaBuy.controller;

import java.net.URI;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.kltn.SpringAPILambdaBuy.common.request.authen.RegisterDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.CreateUserDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.CreateUserProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.UpdateUserDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.UpdateUserProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProfileResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.ProfileEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;
import com.example.kltn.SpringAPILambdaBuy.service.UserService;
import com.example.kltn.SpringAPILambdaBuy.utils.JwtTokenUtil;

@RestController
@RequestMapping("")
public class UserController {
	private static final String APPLICATION_JSON_VALUE = "application/json";
	@Autowired
	private UserService userService;
	@PostMapping("/getCurrentUser")
	public ResponseEntity<ResponseCommon<?>> getCurrentUser(@RequestBody String token) {
		String username = userService.getUsernameFromToken(token).split(",")[1];
		UserEntity user = new UserEntity();
		if(null != username) {
			user = userService.findByEmail(username);
			ProfileEntity profile = user.getProfile();
			ProfileResponseDto profileDto = new ProfileResponseDto(profile.getId(), profile.getPhoneNumber(), profile.getAddress(), profile.getAvatar(), profile.getFirstName(), profile.getLastName());
			UserResponseDto userDto = new UserResponseDto(user.getId(), user.getEmail(), user.getUsername(), user.getPassword(), user.getRole(), user.isEnabled(), user.isLocked(), user.getCreatedDate(), user.getCreatedBy(), user.getUpdatedDate(), user.getUpdatedBy(), profileDto);
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "GET_CURRENT_USER_SUCCESS", userDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "GET_CURRENT_USER_FAIL", null));
	}
	
	@GetMapping("/users")
	public ResponseEntity<ResponseCommon<List<UserResponseDto>>> getUsers() {
		return ResponseEntity.ok().body(userService.getUsers());
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<ResponseCommon<UserResponseDto>> getUserById(@PathVariable("id") String id){
		UserEntity user = userService.findById(id);
		if(user != null) {
			ProfileEntity profile = user.getProfile();
			ProfileResponseDto profileDto = new ProfileResponseDto(profile.getId(), profile.getPhoneNumber(), profile.getAddress(), profile.getAvatar(), profile.getFirstName(), profile.getLastName());
			UserResponseDto userDto = new UserResponseDto(user.getId(), user.getEmail(), user.getUsername(), user.getPassword(), user.getRole(), user.getCreatedDate(), user.getCreatedBy(), user.getUpdatedDate(), user.getUpdatedBy(), profileDto);
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "SUCCESS", userDto));
		}
		return ResponseEntity.ok().body(new ResponseCommon<>(400, false, "USER_NOT_FOUND"));
	}
	
	@GetMapping("/user/name/{username}")
	public ResponseEntity<ResponseCommon<UserResponseDto>> getUserByUsername(@PathVariable("username") String username){
		UserEntity user = userService.findByUsername(username);
		if(user != null) {
			ProfileEntity profile = user.getProfile();
			ProfileResponseDto profileDto = new ProfileResponseDto(profile.getId(), profile.getPhoneNumber(), profile.getAddress(), profile.getAvatar(), profile.getFirstName(), profile.getLastName());
			UserResponseDto userDto = new UserResponseDto(user.getId(), user.getEmail(), user.getUsername(), user.getPassword(), user.getRole(), user.getCreatedDate(), user.getCreatedBy(), user.getUpdatedDate(), user.getUpdatedBy(), profileDto);
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "SUCCESS", userDto));
		}
		return ResponseEntity.ok().body(new ResponseCommon<>(400, false, "USER_NOT_FOUND"));
	}
	
	@GetMapping("/user/email/{email}")
	public ResponseEntity<ResponseCommon<UserResponseDto>> getUserByEmail(@PathVariable("email") String email){
		UserEntity user = userService.findByEmail(email);
		if(user != null) {
			ProfileEntity profile = user.getProfile();
			ProfileResponseDto profileDto = new ProfileResponseDto(profile.getId(), profile.getPhoneNumber(), profile.getAddress(), profile.getAvatar(), profile.getFirstName(), profile.getLastName());
			UserResponseDto userDto = new UserResponseDto(user.getId(), user.getEmail(), user.getUsername(), user.getPassword(), user.getRole(), user.getCreatedDate(), user.getCreatedBy(), user.getUpdatedDate(), user.getUpdatedBy(), profileDto);
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "SUCCESS", userDto));
		}
		return ResponseEntity.ok().body(new ResponseCommon<>(400, false, "USER_NOT_FOUND"));
	}
	
	@PostMapping("/user/save")
	public ResponseEntity<ResponseCommon<?>> saveUser(@RequestBody UserEntity user) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
		userService.saveUser(user);
		return ResponseEntity.created(uri).body(new ResponseCommon<>(200, true, "SAVE_USER_SUCCESS"));
	}
	
	@PostMapping("/user/create")
	public ResponseEntity<ResponseCommon<?>> createUser(@RequestBody CreateUserDto createUserDto) {
		UserResponseDto responseUser = userService.createUser(createUserDto);
		if(responseUser != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "CREATE_USER_SUCCESS", responseUser));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "CREATE_USER_FAIL"));
	}
	
	@PostMapping("/user/create-user-profile")
	public ResponseEntity<UserResponseDto> createUserProfile(CreateUserProfileDto createUserProfileDto) {
		UserResponseDto responseUser = userService.createUserProfile(createUserProfileDto);
		if(responseUser != null) {
			return ResponseEntity.ok().body(responseUser);
		}
		return ResponseEntity.badRequest().body(null);
	}
	
	@PostMapping("/user/update")
	public ResponseEntity<ResponseCommon<?>> updateUser(@RequestBody UpdateUserDto updateUserDto) {
		UserResponseDto responseUser = userService.updateUser(updateUserDto);
		if(responseUser != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "UPDATE_USER_SUCCESS", responseUser));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "UPDATE_USER_FAIL"));
	}

	@GetMapping("/user/delete/{id}")
	public ResponseEntity<ResponseCommon<?>> deleteUser(@PathVariable("id") String id){
		return new ResponseEntity<ResponseCommon<?>>(userService.deleteUser(id), HttpStatus.OK);
	} 
}
