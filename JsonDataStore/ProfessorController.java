package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	
	@GetMapping("/getProfById/{id}")
	public Optional<Professor> getPro(@PathVariable("id") Long id){
		return professorService.findById(id);
	}
	
	@GetMapping("/getProfessorsList")
	public List<Professor> getPro(){
		return professorService.findProfessorsList();
	}
	
	


}
