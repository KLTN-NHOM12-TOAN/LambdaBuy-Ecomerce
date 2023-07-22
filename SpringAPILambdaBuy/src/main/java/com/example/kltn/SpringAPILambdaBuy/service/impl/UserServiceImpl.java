package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.common.request.profile.UpdateProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.CreateUserDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.CreateUserProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.UpdateUserDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.UpdateUserProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProfileResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.ProfileEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.UserRole;
import com.example.kltn.SpringAPILambdaBuy.repository.UserRepository;
import com.example.kltn.SpringAPILambdaBuy.service.ProfileService;
import com.example.kltn.SpringAPILambdaBuy.service.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Value("${app.jwt.secret}")
    private String SECRET_KEY;
	
	@Override
	public String getUsernameFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
		return claims.getSubject();

	}
	
	@Override
	public String currentUsername() {
		Authentication auth = SecurityContextHolder.getContext()
						.getAuthentication();
		if(!(auth instanceof AnonymousAuthenticationToken)) {
			UserEntity userDetails = (UserEntity) auth.getPrincipal();
			
			String currentUsername = userDetails.getEmail();
			return currentUsername;
		}
		return null;
	}
	
	@Override
	public UserEntity findById(String id) {
		if(id == null) {
			return null;
		}
		return userRepository.findById(id).isPresent()
				? userRepository.findById(id).get()
				: null;
	}
	
	@Override
	public UserEntity findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public UserEntity findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(UserEntity user) {
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public UserResponseDto createUser(CreateUserDto createUserDto) {
		String encodePassword = bCryptPasswordEncoder.encode(createUserDto.getPassword());
		UserEntity user = new UserEntity(createUserDto.getUsername(), createUserDto.getEmail(), encodePassword, UserRole.CUSTOMER, new Date(), null);
		if(user != null) {
			UserEntity createUser = userRepository.save(user);
			UserResponseDto userDto = new UserResponseDto(createUser.getId(), createUser.getEmail(), createUser.getUsername(), createUser.getPassword(), UserRole.CUSTOMER, new Date(), createUser.getCreatedBy(), null);
			return userDto;
		}
		return null;
	}
	
	@Override
	public UserResponseDto createUserProfile(CreateUserProfileDto createUserProfileDto) {
		if(!isAccountExist(createUserProfileDto.getUsername(), createUserProfileDto.getEmail())) {
			ProfileEntity profile = new ProfileEntity(createUserProfileDto.getPhoneNumber(), createUserProfileDto.getAddress(), createUserProfileDto.getAvatar(), createUserProfileDto.getFirstName(), createUserProfileDto.getLastName(), new Date(), "admin", new UserEntity());
			ProfileEntity createProfile = profileService.save(profile);
			
			String encodePassword = bCryptPasswordEncoder.encode(createUserProfileDto.getPassword());
			UserEntity createUser = new UserEntity(createUserProfileDto.getUsername(), createUserProfileDto.getEmail(), encodePassword, true, UserRole.CUSTOMER, new Date(), "admin", new ProfileEntity());
			createUser.setProfile(createProfile);
			saveUser(createUser);
			createProfile.setUser(createUser);
			profileService.save(createProfile);
			ProfileResponseDto profileDto = new ProfileResponseDto(profile.getId(), profile.getPhoneNumber(), profile.getAddress(), profile.getAvatar(), profile.getFirstName(), profile.getLastName(), profile.getCreatedDate(), profile.getCreatedBy(), profile.getUpdatedDate(), profile.getUpdatedBy());
			UserResponseDto userDto = new UserResponseDto(createUser.getId(), createUser.getEmail(), createUser.getUsername(), createUser.getPassword(), createUser.getRole(),  createUser.getCreatedDate(), createUser.getCreatedBy(), createUser.getUpdatedDate(), createUser.getUpdatedBy(), profileDto);
			return userDto;
		}
		return null;
	}

	@Override
	public UserResponseDto updateUser(UpdateUserDto updateUserDto) {
		UserEntity user = userRepository.findById(updateUserDto.getId()).isPresent()
				? userRepository.findById(updateUserDto.getId()).get()
				: null;
		if(user != null) {
			user.setUsername(updateUserDto.getUsername());
			user.setEmail(updateUserDto.getEmail());
			user.setUpdatedDate(new Date());
			UserEntity updateUser = userRepository.save(user);
			
			ProfileEntity profile = user.getProfile();
			ProfileResponseDto profileDto = new ProfileResponseDto(profile.getId(), profile.getPhoneNumber(), profile.getAddress(), profile.getAvatar(), profile.getFirstName(), profile.getLastName(), profile.getCreatedDate(), profile.getCreatedBy(), profile.getUpdatedDate(), profile.getUpdatedBy());
			UserResponseDto userDto = new UserResponseDto(updateUser.getId(), updateUser.getEmail(), updateUser.getUsername(), updateUser.getPassword(), updateUser.getRole(), updateUser.getCreatedDate(), updateUser.getCreatedBy(), updateUser.getUpdatedDate(), updateUser.getUpdatedBy(), profileDto);

			return userDto;
		}
		return null;
	}
	
//	@Override
//	public UserResponseDto updateUserAndProfile(UpdateUserProfileDto updateUserProfileDto) {
////		UpdateProfileDto profileDto = updateUserProfileDto.getProfile();
////		ProfileEntity profile = profileService.update(profileDto);
//		
//		UserEntity user = userRepository.findById(updateUserProfileDto.getId()).isPresent()
//				? userRepository.findById(updateUserProfileDto.getId()).get()
//				: null;
//		
//		if(user != null) {
//			ProfileEntity profileEntity = user.getProfile();
//			UpdateProfileDto profileDto = new UpdateProfileDto(profileEntity.getId(), profileEntity.getPhoneNumber(), profileEntity.getAddress(), profileEntity.getAvatar(), profileEntity.getFirstName(), profileEntity.getLastName(), profileEntity.getUser(), profileEntity.getCart(), profileEntity.getListOrder());
//			UpdateUserDto updateUserDto = new UpdateUserDto(updateUserProfileDto.getId(), updateUserProfileDto.getUsername(), updateUserProfileDto.getEmail(), updateUserProfileDto.getPassword(), updateUserProfileDto.getIsLocked(), updateUserProfileDto.getIsEnabled(), updateUserProfileDto.getCreatedDate(), updateUserProfileDto.getCreatedBy(), updateUserProfileDto.getUpdatedDate(), updateUserProfileDto.getUpdatedBy());
//			UserResponseDto userResponseDto = updateUser(updateUserDto);
//			
//			return userResponseDto;
//		}
//		return null;
//	}
	
	@Override
	public UserEntity getUser(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public ResponseCommon<List<UserResponseDto>> getUsers() {
		List<UserEntity> listUser = userRepository.findAll();
		List<UserResponseDto> listUserDto = new ArrayList<>();
		for (UserEntity userEntity : listUser) {
			if(userEntity.getRole() == UserRole.CUSTOMER) {
				ProfileEntity profile = userEntity.getProfile();
				ProfileResponseDto profileDto = new ProfileResponseDto(profile.getId(), profile.getPhoneNumber(), profile.getAddress(), profile.getAvatar(), profile.getFirstName(), profile.getLastName());
				UserResponseDto userDto = new UserResponseDto(userEntity.getId(), userEntity.getEmail(), userEntity.getUsername(), userEntity.getPassword(), userEntity.getRole(), userEntity.isEnabled(), userEntity.isLocked(), userEntity.getCreatedDate(), userEntity.getCreatedBy(), userEntity.getUpdatedDate(), userEntity.getUpdatedBy(), profileDto);
				listUserDto.add(userDto);
			}
		}
		return new ResponseCommon<>(200, true, "FIND_ALL_USER_SUCCESS", listUserDto);
	}

	

	@Override
	public ResponseCommon<?> deleteUser(String id) {
		UserEntity user = userRepository.getById(id);
		if(user != null) {
			user.setLocked(true);
			saveUser(user);
			return new ResponseCommon<>(200, true, "DELETE_USER_SUCCESS");
		}
		return new ResponseCommon<>(400, false, "USER_NOT_EXIST");
	}
	
	public boolean isAccountExist(String username, String email) {
		List<UserEntity> list = userRepository.findAll();
		for (UserEntity userEntity : list) {
			if(userEntity.getUsername().equalsIgnoreCase(username) || userEntity.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public UserEntity getCurrentLoggedInUser(Authentication authentication) {
		if(authentication == null) return null;
		
		UserEntity userEntity = null;
		Object principal = authentication.getPrincipal();
		
		if(principal instanceof UserDetailService) {
//			userEntity = ((UserDetailService) principal).get
		}
		return null;
	}

	@Override
	public String isUserPresent(UserEntity user) {
		UserEntity theUser = userRepository.getUserByEmailAndUsername(user.getEmail(), user.getUsername());
		return theUser != null 
					? theUser.getId()
					: null;
	}

	@Override
	public UserEntity save(UserEntity user) {
		return userRepository.save(user);
	}

	@Override
	public String getAccessToken() {
		// TODO Auto-generated method stub
		return null;
	}

}
