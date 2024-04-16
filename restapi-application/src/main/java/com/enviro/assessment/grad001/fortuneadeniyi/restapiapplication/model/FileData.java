package com.enviro.assessment.grad001.fortuneadeniyi.restapiapplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;



@Entity
@Data
public class FileData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String fileName;
	
	@Column(nullable = false)
	private String fileType;
	
	@Lob
	@Column(nullable = false)
	private byte[] fileData;
	
	public FileData() {
        // Default constructor
    }

    public FileData(String fileName,String fileType, byte[] fileData) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileData = fileData;
    }
	
	
}
