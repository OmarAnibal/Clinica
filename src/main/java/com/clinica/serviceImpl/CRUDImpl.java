package com.clinica.serviceImpl;

import java.util.List;

import com.clinica.repo.IGenericRepo;
import com.clinica.service.ICrudService;

public abstract class CRUDImpl<T,ID>  implements ICrudService<T, ID> {

	protected abstract  IGenericRepo<T,ID> getRepo();
	
	@Override
	public T registrar(T t) {
		return getRepo().save(t);
	}

	@Override
	public T modificar(T t) {
		return getRepo().save(t);
	}

	@Override
	public List<T> listar() {
		return getRepo().findAll();
	}

	@Override
	public T listarPorId(ID id) {
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public void eliminar(ID id) {
		getRepo().deleteById(id);
		
	}

}
