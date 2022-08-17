package com.clinica.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.model.Medico;
import com.clinica.repo.IGenericRepo;
import com.clinica.repo.IMedicoRepo;
import com.clinica.service.IMedicoService;
import com.clinica.service.IPacienteService;

@Service
public class MedicoServiceImpl extends CRUDImpl<Medico, Integer> implements IMedicoService{
	
	@Autowired
	private IMedicoRepo repo;
 
	@Override
	protected IGenericRepo<Medico, Integer> getRepo() {
		return repo;
	}
}
