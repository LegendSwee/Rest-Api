package com.enviro.assessment.grad001.fortuneadeniyi.restapiapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.enviro.assessment.grad001.fortuneadeniyi.restapiapplication.model.FileData;
import com.enviro.assessment.grad001.fortuneadeniyi.restapiapplication.repository.FileRepository;



@Service
public class FileService {

	private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    // Method to handle file upload
    public void uploadFile(MultipartFile file) {
        try {
            // Extract file information
            String fileName = file.getOriginalFilename();
            String fileType = file.getContentType();
            byte[] fileData = file.getBytes();

            // Create FileData object
            FileData fileDataObject = new FileData(fileName, fileType, fileData);

            // Save FileData to database
            fileRepository.save(fileDataObject);
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload file: " + e.getMessage());
        }
    }
    // sMethod to handle data processing
    public void processData(Long id) {
        // Implement data processing logic based on file ID
        // This is just a placeholder
        System.out.println("Processing data for file ID: " + id);
    }
        public String getResultsById(Long id) {
            
            return "results for file id" + id;
    }
}
