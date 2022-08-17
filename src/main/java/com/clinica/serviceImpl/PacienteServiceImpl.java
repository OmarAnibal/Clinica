package com.clinica.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.model.Paciente;
import com.clinica.repo.IGenericRepo;
import com.clinica.repo.IPacienteRepo;
import com.clinica.service.IPacienteService;

@Service
public class PacienteServiceImpl extends CRUDImpl<Paciente, Integer>  implements IPacienteService{

	@Autowired
	private IPacienteRepo repo;

	@Override
	protected IGenericRepo<Paciente, Integer> getRepo() {
		return repo;
	}
	


}
