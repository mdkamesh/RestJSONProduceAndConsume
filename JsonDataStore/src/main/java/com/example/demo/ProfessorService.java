package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorInt professorInt;
	
	 public Optional<Professor> findById(Long id) {
	        return professorInt.findById(id);
	    }
	 
	 public List<Professor> findProfessorsList(){
		 return professorInt.findAll();
	 }

	 
}
