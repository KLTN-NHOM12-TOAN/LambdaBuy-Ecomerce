package com.example.kltn.SpringAPILambdaBuy.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.example.kltn.SpringAPILambdaBuy.common.request.image.UploadImageDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ImageResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.ImageEntity;
import com.example.kltn.SpringAPILambdaBuy.service.StorageService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/image")
public class StorageController {
	@Autowired
	private StorageService storageService;
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadImage(@RequestBody UploadImageDto uploadImageDto) throws IOException {
		ImageEntity image = storageService.uploadImage(uploadImageDto);
		if(image != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "UPLOAD_IMAGE_SUCCESS", image));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "UPLOAD_IMAGE_FAIL"));
	}

	@GetMapping("/name/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName){
		byte[] imageData = storageService.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id){
		ImageEntity image = storageService.findById(id);
		if(image != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_IMAGE_SUCCESS", image));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "IMAGE_NOT_FOUND", image));
	}
//	@PostMapping("/upload-multi")
//	public ResponseEntity<?> uploadMultiImage(@RequestParam("images") MultipartFile[] files) {
//		try {
//			System.out.println("File list: ");
//			for (MultipartFile file : files) {
//				storageService.uploadImage(file);
//			}
//			return new ResponseEntity<>(HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//	}
}
