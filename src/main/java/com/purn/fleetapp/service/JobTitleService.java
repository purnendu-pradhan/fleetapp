package com.purn.fleetapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purn.fleetapp.model.JobTitle;
import com.purn.fleetapp.repositories.JobTitleRepository;

@Service
public class JobTitleService {

	@Autowired
	private JobTitleRepository titleRepository;
	
	public List<JobTitle> getJobTitles() {
		return titleRepository.findAll();
	}

	public void save(JobTitle jobTitle) {
		titleRepository.save(jobTitle);
	}

	public Optional<JobTitle> findById(int id) {
		return titleRepository.findById(id);
	}

	public void delete(int id) {
		titleRepository.deleteById(id);
	}
}
