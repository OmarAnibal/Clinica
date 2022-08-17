package com.clinica.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.model.Examen;
import com.clinica.repo.IExamenRepo;
import com.clinica.repo.IGenericRepo;
import com.clinica.service.IExamenService;


@Service
public class ExamenServiceImpl extends CRUDImpl<Examen, Integer> implements IExamenService{
	
	@Autowired
	private IExamenRepo repo;
 
	@Override
	protected IGenericRepo<Examen, Integer> getRepo() {
		return repo;
	}
}
