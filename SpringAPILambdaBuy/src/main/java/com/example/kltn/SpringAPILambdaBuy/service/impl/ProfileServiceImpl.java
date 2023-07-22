package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.kltn.SpringAPILambdaBuy.common.request.profile.CreateProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.profile.UpdateProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProfileResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.ProfileEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.ProfileRepository;
import com.example.kltn.SpringAPILambdaBuy.service.ProfileService;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	@Override
	public ProfileEntity findById(String id) {
		return profileRepository.findById(id).isPresent()
				? profileRepository.findById(id).get()
				: null;
	}

	@Override
	public ProfileResponseDto update(UpdateProfileDto updateProfileDto) {
		ProfileEntity profile = profileRepository.findById(updateProfileDto.getId()).isPresent()
									? profileRepository.findById(updateProfileDto.getId()).get()
									: null;
		if(profile != null) {
			profile.setId(updateProfileDto.getId());
			profile.setFirstName(updateProfileDto.getFirstName());
			profile.setLastName(updateProfileDto.getLastName());
			profile.setAddress(updateProfileDto.getAddress());
			profile.setAvatar(updateProfileDto.getAvatar());
			profile.setPhoneNumber(updateProfileDto.getPhoneNumber());
			profile.setUpdatedDate(new Date());
			ProfileEntity updateProfile = profileRepository.save(profile);
			ProfileResponseDto profileDto = new ProfileResponseDto(updateProfile.getId(), updateProfile.getPhoneNumber(), updateProfile.getAddress(), updateProfile.getAvatar(), updateProfile.getFirstName(), updateProfile.getLastName(), updateProfile.getCreatedDate(), updateProfile.getCreatedBy(), new Date(), updateProfile.getFirstName() + updateProfile.getLastName());
			
			return profileDto;
		}
		return null;
	}
	
	@Override
	public ProfileEntity save(ProfileEntity profile) {
		return profileRepository.save(profile);
	}

	@Override
	public ProfileResponseDto create(CreateProfileDto createProfileDto) {
		ProfileEntity profile = new ProfileEntity();
		profile.setAvatar(createProfileDto.getAvatar());
		profile.setFirstName(createProfileDto.getFirstName());
		profile.setLastName(createProfileDto.getLastName());
		profile.setPhoneNumber(createProfileDto.getPhoneNumber());
		profile.setAddress(createProfileDto.getAddress());
		
		ProfileEntity createProfile = profileRepository.save(profile);
		ProfileResponseDto profileDto = new ProfileResponseDto(createProfile.getId(), createProfile.getPhoneNumber(), createProfile.getAddress(), createProfile.getAvatar(), createProfile.getFirstName(), createProfile.getLastName(), new Date(), createProfile.getFirstName() + " " + createProfile.getLastName(), null, null);
				
		return profileDto;
	}
}
