package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.senac.dominio.Usuario;
import br.com.senac.repositorio.UsuarioRepositorio;
import br.com.senac.servico.exception.ObjectNotFoundException;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositorio repoUsu;
	
	public Usuario buscar(Integer id) throws ObjectNotFoundException {
		Optional<Usuario> objUsuario = repoUsu.findById(id);
		return objUsuario.orElseThrow(()-> new ObjectNotFoundException("Usuario não encontrado! id: " + id +", Tipo: "+Usuario.class.getName()));
	}
	
	public Usuario inserir(Usuario usuario) {
		usuario.setId(null);
		return repoUsu.save(usuario);
	}
	public Usuario alterar(Usuario objUsuario) throws ObjectNotFoundException{
		Usuario objUsuarioEncontrado = buscar(objUsuario.getId());
		objUsuarioEncontrado.setNome(objUsuario.getNome());
		objUsuarioEncontrado.setTelefone(objUsuario.getTelefone());
		objUsuarioEncontrado.setSobrenome(objUsuario.getSobrenome());
		objUsuarioEncontrado.setStatus(objUsuario.getStatus());
		objUsuarioEncontrado.setSenha(objUsuario.getSenha());
		return repoUsu.save(objUsuarioEncontrado);
		
}

public void excluir(Integer id) {
	repoUsu.deleteById(id);
	
}

public List< Usuario> listaUsuario(){
	return repoUsu.findAll();
}
}