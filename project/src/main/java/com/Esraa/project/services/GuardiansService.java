package com.Esraa.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Esraa.project.models.Guardians;
import com.Esraa.project.repositories.GuardiansRepo;

@Service
public class GuardiansService {

	@Autowired
	 GuardiansRepo guardiansRepo;
	
	public Guardians findGuardianBy(Long id) {
		Optional<Guardians> optionalExpense = guardiansRepo.findById(id);
		if(optionalExpense.isPresent()) {
	        return optionalExpense.get();
	    } else {
	        return null;
	    }
	}
	
	public List<Guardians> findGuardians() {
		return guardiansRepo.findAll();
		}
	
	public void creatGuardian(Guardians g) {
		guardiansRepo.save(g);
	}
	
}
