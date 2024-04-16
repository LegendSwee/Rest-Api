package com.enviro.assessment.grad001.fortuneadeniyi.restapiapplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.enviro.assessment.grad001.fortuneadeniyi.restapiapplication.service.FileService;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class UploadController {
	
	// Logger for logging messages
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
    
  

    @Autowired
    private FileService fileService;
	// Handler method for uploading files
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Process the uploaded file
            fileService.uploadFile(file);
         
            // Log successful file upload
            logger.info("File uploaded successfully: {}", file.getOriginalFilename());
            // Return success response
            return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully.");
        } catch (Exception e) {
            // Log error if file upload fails
            logger.error("Error uploading file: {}", e.getMessage());
            // Return error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file.");
        }
    }
}
