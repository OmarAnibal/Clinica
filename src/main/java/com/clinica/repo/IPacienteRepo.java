package com.clinica.repo;

import org.springframework.stereotype.Repository;

import com.clinica.model.Paciente;

@Repository
public interface IPacienteRepo extends IGenericRepo<Paciente, Integer> {
 
}
