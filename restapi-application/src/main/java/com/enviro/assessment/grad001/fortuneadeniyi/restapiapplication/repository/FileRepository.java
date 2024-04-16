package com.enviro.assessment.grad001.fortuneadeniyi.restapiapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enviro.assessment.grad001.fortuneadeniyi.restapiapplication.model.FileData;



public interface FileRepository extends JpaRepository<FileData,Long> {
	
	
}
