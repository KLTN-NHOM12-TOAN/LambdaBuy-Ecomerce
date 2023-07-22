package com.example.kltn.SpringAPILambdaBuy.service;

import com.example.kltn.SpringAPILambdaBuy.common.request.profile.CreateProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.profile.UpdateProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProfileResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.ProfileEntity;

public interface ProfileService {
	ProfileEntity findById(String id);
	ProfileResponseDto update(UpdateProfileDto updateProfileDto);
	ProfileEntity save(ProfileEntity profile);
	ProfileResponseDto create(CreateProfileDto createProfileDto);
}
