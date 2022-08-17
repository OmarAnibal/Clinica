package com.clinica.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dto.ConsultaListaExamenDTO;
import com.clinica.model.Consulta;
import com.clinica.model.Especialidad;
import com.clinica.model.Examen;
import com.clinica.repo.IConsultaExamenRepo;
import com.clinica.repo.IConsultaRepo;
import com.clinica.repo.IEspecialidadRepo;
import com.clinica.repo.IExamenRepo;
import com.clinica.repo.IGenericRepo;
import com.clinica.service.IConsultaService;
import com.clinica.service.IEspecialidadService;
import com.clinica.service.IExamenService;


@Service
public class ConsultaServiceImpl extends CRUDImpl<Consulta, Integer> implements IConsultaService{
	
	@Autowired
	private IConsultaRepo repo;
	
	@Autowired
	private IConsultaExamenRepo ceRepo; 
	
	@Override
	protected IGenericRepo<Consulta, Integer> getRepo() {
		return repo;
	}

	@Transactional
	@Override
	public Consulta registrarTransaccional(ConsultaListaExamenDTO dto) {
		//INSERTAR CONSULTA -> OBTENER PK
		//INSERTER DETALLE CONSULTA <- USANDO LA PK PREVIA
		
		dto.getConsulta().getDetalleConsulta().forEach(det -> det.setConsulta(dto.getConsulta()));
		
		repo.save(dto.getConsulta());
				
		//INSERTO OBJ Y SU LLAVE PRIMARIA ESTA EN 0
		//DESPUES INS OBJ , SU LLAVE PRIMARIA SE ESTABLECE
		
		dto.getLstExamen().forEach(ex -> ceRepo.registrar(dto.getConsulta().getIdConsulta(), ex.getIdExamen()));
		
		return dto.getConsulta();
		
		/*List<DetalleConsulta> listaDetalle = consulta.getDetalleConsulta();
		for(DetalleConsulta det : listaDetalle) {
			det.setConsulta(consulta);
		}*/
		
	}
}