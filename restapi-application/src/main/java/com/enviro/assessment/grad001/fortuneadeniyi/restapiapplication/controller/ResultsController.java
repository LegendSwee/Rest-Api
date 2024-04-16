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
public class ResultsController {
	
	// Logger for logging messages
    private static final Logger logger = LoggerFactory.getLogger(ResultsController.class);
	
	@Autowired
    private FileService fileService;

	// Endpoint for data processing
    @GetMapping("/process/{id}")
    public ResponseEntity<String> processData(@PathVariable Long id) {
        try {
            fileService.processData(id)
;
            return ResponseEntity.ok("Data processed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process data: " + e.getMessage());
        }
    }
	// Handler method for retrieving results
    @GetMapping("/results/{id}")
    public ResponseEntity<String> getResult(@PathVariable Long id) {
        try {
            String result = fileService.getResultsById(id)
;
            return ResponseEntity.ok("Processed result for file ID " + id + ": " + result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve result: " + e.getMessage());
        }
    }

}
