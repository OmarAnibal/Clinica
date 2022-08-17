package com.clinica.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.model.Especialidad;
import com.clinica.model.Examen;
import com.clinica.repo.IEspecialidadRepo;
import com.clinica.repo.IExamenRepo;
import com.clinica.repo.IGenericRepo;
import com.clinica.service.IEspecialidadService;
import com.clinica.service.IExamenService;


@Service
public class EspecialidadServiceImpl extends CRUDImpl<Especialidad, Integer> implements IEspecialidadService{
	
	@Autowired
	private IEspecialidadRepo repo;
 
	@Override
	protected IGenericRepo<Especialidad, Integer> getRepo() {
		return repo;
	}
}
