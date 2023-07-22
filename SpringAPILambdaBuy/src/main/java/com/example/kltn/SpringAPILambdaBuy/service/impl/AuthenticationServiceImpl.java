package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.common.data.ConstantGlobal;
import com.example.kltn.SpringAPILambdaBuy.common.interfaces.MailSender;
import com.example.kltn.SpringAPILambdaBuy.common.request.authen.LoginDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.authen.RegisterDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProfileResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.ConfirmationTokenEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.ProfileEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.UserRole;
import com.example.kltn.SpringAPILambdaBuy.security.PasswordEncoder;
import com.example.kltn.SpringAPILambdaBuy.service.AuthenticationService;
import com.example.kltn.SpringAPILambdaBuy.service.ConfirmationTokenService;
import com.example.kltn.SpringAPILambdaBuy.service.ProfileService;
import com.example.kltn.SpringAPILambdaBuy.service.UserService;
import com.example.kltn.SpringAPILambdaBuy.validator.EmailValidator;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ConfirmationTokenService confirmationTokenService;
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private EmailValidator emailValidator;
	
	@Autowired
	private MailSender mailSender;
	
	List<UserResponseDto> listUserDto = new ArrayList<>();
	
	
	@Override
	public ResponseCommon<?> seedAdmin() {
		List<RegisterDto> listAdmin = ConstantGlobal.listAdmin;
		List<UserResponseDto> listUserDto = new ArrayList();
		for (RegisterDto registerDto : listAdmin) {
			ProfileEntity profile = new ProfileEntity(registerDto.getFirstName(), registerDto.getLastName());
			ProfileEntity createProfile = profileService.save(profile);
			
			String encodePassword = bCryptPasswordEncoder.encode(registerDto.getPassword());
			UserEntity createUser = new UserEntity(registerDto.getUsername(), registerDto.getEmail(), encodePassword, true, UserRole.ADMIN, new Date(), registerDto.getFirstName() + " " + registerDto.getLastName(), new ProfileEntity());
			createUser.setProfile(createProfile);
			userService.saveUser(createUser);
			createProfile.setUser(createUser);
			profileService.save(createProfile);
			ProfileResponseDto profileDto = new ProfileResponseDto(profile.getId(), profile.getPhoneNumber(), profile.getAddress(), profile.getAvatar(), profile.getFirstName(), profile.getLastName(), profile.getCreatedDate(), profile.getCreatedBy(), profile.getUpdatedDate(), profile.getUpdatedBy());
			UserResponseDto userDto = new UserResponseDto(createUser.getId(), createUser.getEmail(), createUser.getUsername(), createUser.getPassword(), createUser.getRole(),  createUser.getCreatedDate(), createUser.getCreatedBy(), createUser.getUpdatedDate(), createUser.getUpdatedBy(), profileDto);
			listUserDto.add(userDto);
		}
		return new ResponseCommon<>(200, true, "SEED_ADMIN_SUCCESS", listUserDto);
	}
	
	@Override
	public ResponseCommon<?> register(RegisterDto registerDto) {
		if(!registerDto.getPassword().equals(registerDto.getRePassword())) {
			return new ResponseCommon<>(400, false, "PASSWORD_NOT_EQUAL");
		}
		boolean isValidEmail = emailValidator.test(registerDto.getEmail());
		if(!isValidEmail) {
			throw new IllegalStateException("Email not valid");
		}
		UserEntity userMail = userService.findByEmail(registerDto.getEmail());
		if(userMail != null) {
			return new ResponseCommon<>(400, false, "EMAIL_EXIST");
		}
		UserEntity userName = userService.findByUsername(registerDto.getUsername());
		if(userName != null) {
			return new ResponseCommon<>(400, false, "USERNAME_EXIST");
		}
		
		ProfileEntity profile = new ProfileEntity(registerDto.getFirstName(), registerDto.getLastName());
		ProfileEntity createProfile = profileService.save(profile);
		
		String encodePassword = bCryptPasswordEncoder.encode(registerDto.getPassword());
		UserEntity createUser = new UserEntity(registerDto.getUsername(), registerDto.getEmail(), encodePassword, UserRole.CUSTOMER, new Date(), registerDto.getFirstName() + " " + registerDto.getLastName(), new ProfileEntity());
		createUser.setProfile(createProfile);
		userService.saveUser(createUser);
		createProfile.setUser(createUser);
		profileService.save(createProfile);
		
//		CartItemEntity cart = new CartItemEntity(0, createUser, null);
//		cartService.save(cart);
		
		createUser.setProfile(null);
		//createUser.setAdmin(null); 
		
		// Send confirmation token
		String token = UUID.randomUUID().toString();
		ConfirmationTokenEntity createToken = new ConfirmationTokenEntity(token, LocalDateTime.now(), LocalDateTime.now().plusDays(1), createUser);
		confirmationTokenService.saveConfirmationToken(createToken);
		
		// Send mail
		String link = "http://localhost:8080/authentication/register/confirm/" + createToken.getTokenCode();

		mailSender.send(registerDto.getEmail(), buildEmail(
					registerDto.getFirstName() + " " + registerDto.getLastName()
					, link));
		
		ProfileResponseDto profileDto = new ProfileResponseDto(profile.getId(), profile.getPhoneNumber(), profile.getAddress(), profile.getAvatar(), profile.getFirstName(), profile.getLastName(), profile.getCreatedDate(), profile.getCreatedBy(), profile.getUpdatedDate(), profile.getUpdatedBy());
		UserResponseDto userDto = new UserResponseDto(createUser.getId(), createUser.getEmail(), createUser.getUsername(), createUser.getPassword(), createUser.getRole(),  createUser.getCreatedDate(), createUser.getCreatedBy(), createUser.getUpdatedDate(), createUser.getUpdatedBy(), profileDto);
		return new ResponseCommon<>(200, true, "REGISTER_SUCCESS", userDto);
	}
	
	@Override
	public ResponseCommon<?> login(LoginDto loginDto) {
		UserEntity userName = userService.findByUsername(loginDto.getUsername());
		if(userName != null) {
			if(userName.isEnabled() == true) {
				if(bCryptPasswordEncoder.matches(loginDto.getPassword(), userName.getPassword())) {
					ProfileEntity profile = userName.getProfile();
					if(profile != null) {
						ProfileResponseDto profileDto = new ProfileResponseDto(profile.getId(), profile.getPhoneNumber(), profile.getAddress(), profile.getAvatar(), profile.getFirstName(), profile.getLastName(), profile.getCreatedDate(), profile.getCreatedBy(), profile.getUpdatedDate(), profile.getUpdatedBy());
						UserResponseDto userDto = new UserResponseDto(userName.getId(), userName.getEmail(), userName.getUsername(), userName.getPassword(), userName.getRole(), userName.isEnabled(), userName.isLocked(), userName.getCreatedDate(), userName.getCreatedBy(), userName.getUpdatedDate(), userName.getUpdatedBy(), profileDto);
						return new ResponseCommon<>(200, true, "LOGIN_USER_SUCCESS", userDto);
					}
					
					return new ResponseCommon<>(200, true, "LOGIN_ADMIN_SUCCESS");
				} else {
					return new ResponseCommon<>(400, false, "USERNAME_OR_PASSWORD_NOT_TRUE");
				}
			} else {
				return new ResponseCommon<>(400, false, "ACCOUNT_NOT_ACTIVE");
			}
			
		}
		UserEntity userEmail = userService.findByEmail(loginDto.getEmail());
		if(userEmail != null) {
			if(userEmail.isEnabled() == true) {
				if(bCryptPasswordEncoder.matches(loginDto.getPassword(), userEmail.getPassword())) {
					UserResponseDto userDto = new UserResponseDto(userEmail.getId(), userEmail.getEmail(), userEmail.getUsername(), userEmail.getPassword(), userEmail.getRole(), userEmail.getCreatedDate(), userEmail.getCreatedBy(), userEmail.getUpdatedDate(), userEmail.getUpdatedBy());
					return new ResponseCommon<>(200, true, "LOGIN_SUCCESS", userDto);
				} else {
					return new ResponseCommon<>(400, false, "EMAIL_OR_PASSWORD_NOT_TRUE");
				}
			} else {
				return new ResponseCommon<>(400, false, "ACCOUNT_NOT_ACTIVE");
			}
		}
		return new ResponseCommon<>(400, false, "USER_NOT_EXIST");
	}
	
	@Transactional
	public ResponseCommon<?> confirmToken(String token) {
		ConfirmationTokenEntity confirmationTokenEntity = confirmationTokenService.getToken(token);
		if(confirmationTokenEntity.getConfirmDate() != null) {
			throw new IllegalStateException("EMAIL_ALREADY_CONFIRMED");
		}
		LocalDateTime expiredDate = confirmationTokenEntity.getExpiresDate();
		if(expiredDate.isBefore(LocalDateTime.now())) {
			throw new IllegalStateException("TOKEN_EXPIRED");
//			return new ResponseCommon<>(400, false, "TOKEN_EXPIRED");
		}
		confirmationTokenService.setConfirmedDate(token);
		activeUser(confirmationTokenEntity.getUser().getEmail());
		
		return new ResponseCommon<>(200, true, "CONFIRM_SUCCESS");
	}


	@Override
	public void activeUser(String email) {
		try {
			UserEntity user = userService.findByEmail(email);
			user.setEnabled(true);
			userService.saveUser(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private String buildEmail(String name, String link) {
		return "<html>\r\n"
				+ "      <head>\r\n"
				+ "          <meta charset=\"UTF-8\">\r\n"
				+ "          <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "          <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "          <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\">\r\n"
				+ "          <title>XÁC THỰC TÀI KHOẢN</title>\r\n"
				+ "      </head>\r\n"
				+ "      <body style=\" font-family: Arial, Helvetica, sans-serif;color: #212529;\">\r\n"
				+ "          <header class=\"container-fluid\" style=\"background-color: #F5F5F5; text-align: center;\">\r\n"
				+ "              <img src=\"https://scontent-sin6-4.xx.fbcdn.net/v/t39.30808-6/316105261_1778997539132061_2741219512235649128_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=730e14&_nc_ohc=skAXEakeaykAX8timFQ&_nc_ht=scontent-sin6-4.xx&oh=00_AfC_NDrMRpiyIaQKjxdLnlg9SHHPgeS6FO6KbFxH1WgNng&oe=6383C10A\" alt=\"logo\">\r\n"
				+ "          </header>\r\n"
				+ "          <main style=\"color: #212529;\">\r\n"
				+ "              <br />\r\n"
				+ "              <div style=\"padding-bottom:20px\">\r\n"
				+ "                  <div style=\"color: #212529;text-align: center; font-weight: bold; font-size: 28px; \">\r\n"
				+ "                      XÁC NHẬN KÍCH HOẠT TÀI KHOẢN\r\n"
				+ "                  </div>\r\n"
				+ "                  <br>\r\n"
				+ "                  <div style=\"color: #212529;width: 600px; margin: auto; text-align: justify; font-size: 16px;\">\r\n"
				+ "                      Xin chào: <p style=\"display: inline; font-weight: bold\">" + name + "</p> <br><br>\r\n"
				+ "                      Anh/Chị đã đăng ký tài khoản thành công. Vui lòng nhấn nút <p style=\"display: inline; font-weight: bold;\">\"Xác nhận\"</p> để được kích hoạt tài khoản. <br> <br>\r\n"
				+ "                      Nếu Anh/Chị có thắc mắc hãy liên hệ ngay Hotline (+84) 8 1949 0540 để được hỗ trợ nhanh nhất. <br><br>\r\n"
				+ "                      Thân mến, chúc Anh/Chị một ngày tốt lành <br>\r\n"
				+ "                      <p style=\"display: inline; font-weight: bold;\">LambdaBuy</p>\r\n"
				+ "                      <hr style=\"margin-top: 30px;margin-bottom: 40px;\"/>\r\n"
				+ "                  </div>\r\n"
				+ "                  <div  style=\"text-align: center;margin-top: 20px;margin-bottom: 20px;\">\r\n"
				+ "                      <a style=\"border-radius: 5px;font-weight: 600;padding: 18px;background-color: #212529;font-size:18px;color: #fff;text-decoration: none;cursor: pointer;\" href=\"" + link + "\">Xác nhận</a>\r\n"
				+ "                  </div>\r\n"
				+ "              </div>\r\n"
				+ "          </main>\r\n"
				+ "          <div class=\"container-fluid\" style=\"background-color: #F5F5F5; text-align: center;padding:20px\">\r\n"
				+ "            \r\n"
				+ "              (+84) 8 1949 0540 <br>\r\n"
				+ "              contact.lambdabuy@gmail.com <br>\r\n"
				+ "              VP: 600/7 Quang Trung, Phường 11, Gò Vấp <br>\r\n"
				+ "              Trụ sở: 12 Nguyễn Văn Bảo, Phường 4, Gò Vấp, Thành phố Hồ Chí Minh <br><br>\r\n"
				+ "              Copyright @ 2022 LambdaBuy All rights reserved <br>\r\n"
				+ "              Contact email: lvtoan.it2000@gmail.com <br>\r\n"
				+ "          </div>\r\n"
				+ "        </body>\r\n"
				+ "      </html>";
	}
}
