package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.Optional;

import com.example.kltn.SpringAPILambdaBuy.entities.ConfirmationTokenEntity;

public interface ConfirmationTokenService {
	void saveConfirmationToken(ConfirmationTokenEntity token);
	ConfirmationTokenEntity getToken(String token);
	void setConfirmedDate(String token);
}
