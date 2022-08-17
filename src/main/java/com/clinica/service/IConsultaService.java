package com.clinica.service;

import com.clinica.dto.ConsultaListaExamenDTO;
import com.clinica.model.Consulta;

public interface IConsultaService extends ICrudService<Consulta, Integer> {

	Consulta registrarTransaccional(ConsultaListaExamenDTO dto);
}
