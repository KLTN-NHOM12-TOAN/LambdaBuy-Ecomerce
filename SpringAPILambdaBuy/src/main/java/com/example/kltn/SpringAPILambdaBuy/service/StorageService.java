package com.example.kltn.SpringAPILambdaBuy.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.kltn.SpringAPILambdaBuy.common.request.image.UploadImageDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ImageResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.ImageEntity;

public interface StorageService {
	byte[] downloadImage(String fileName);
	ImageEntity findById(String id);
	ImageEntity uploadImage(UploadImageDto uploadImageDto) throws IOException;

}
