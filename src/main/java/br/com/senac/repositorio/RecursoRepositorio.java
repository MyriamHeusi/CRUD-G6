package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.senac.dominio.Recurso;
import br.com.senac.dominio.Usuario;

public interface RecursoRepositorio  extends JpaRepository<Recurso, Integer> {
	


}
