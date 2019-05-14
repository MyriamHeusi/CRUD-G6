package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.senac.dominio.Recurso;
import br.com.senac.repositorio.RecursoRepositorio;
import br.com.senac.servico.exception.ObjectNotFoundException;


@Service
public class RecursoService {
	
	@Autowired
	private RecursoRepositorio repoRec;
	
	public Recurso buscar(Integer id) throws ObjectNotFoundException {
		Optional<Recurso> objRecurso= repoRec.findById(id);
		return objRecurso.orElseThrow(()-> new ObjectNotFoundException("Recurso não encontrado! id: " + id +", Tipo: "+Recurso.class.getName()));
}
	
	public Recurso inserir(Recurso recurso) {
		recurso.setId(null);
		return repoRec.save(recurso);
	}
	
	public Recurso alterar(Recurso objRecurso) throws ObjectNotFoundException{
		Recurso objRecursoEncontrado = buscar(objRecurso.getId());
		objRecursoEncontrado.setNome(objRecurso.getNome());
		objRecursoEncontrado.setTipo(objRecurso.getTipo());
		
		return repoRec.save(objRecursoEncontrado);
		
	}
	public void excluir(Integer id) {
		repoRec.deleteById(id);
		
	}
	
	public List<Recurso> listaRecurso(){
		return repoRec.findAll();
	}
	
}
