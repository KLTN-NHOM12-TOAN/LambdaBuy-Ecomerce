package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.entities.ConfirmationTokenEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.ConfirmationTokenRepository;
import com.example.kltn.SpringAPILambdaBuy.service.ConfirmationTokenService;

@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {
	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;
	
	@Override
	public void saveConfirmationToken(ConfirmationTokenEntity token) {
		confirmationTokenRepository.save(token);
	}

	@Override
	public ConfirmationTokenEntity getToken(String token_code) {
		ConfirmationTokenEntity confirmationTokenEntity = confirmationTokenRepository.findByToken(token_code);
		return confirmationTokenEntity;
	}

	@Override
	public void setConfirmedDate(String token) {
		try {
			ConfirmationTokenEntity confirmationTokenEntity = getToken(token);
			confirmationTokenEntity.setConfirmDate(LocalDateTime.now());
			saveConfirmationToken(confirmationTokenEntity);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
