package br.com.senac.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.dominio.OrdemServico;
import br.com.senac.dominio.Recurso;
import br.com.senac.dominio.Usuario;
import br.com.senac.repositorio.OrdemServicoRepositorio;
import br.com.senac.repositorio.RecursoRepositorio;
import br.com.senac.repositorio.UsuarioRepositorio;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	OrdemServicoRepositorio ordemServicoRepositorio;
	
	@Autowired
	RecursoRepositorio recursoRepositorio;
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Usuario usuario1 = new Usuario();
		usuario1.setNome("Myriam");
		usuario1.setSobrenome("Martins");
		usuario1.setTelefone("22255465");	
		usuario1.setSenha("123");
		usuario1.setStatus("status");
		
		usuarioRepositorio.save(usuario1);
		
		Usuario usuarioGravado = usuarioRepositorio.findByNome("Myriam");
		
		 OrdemServico ordemservico1 = new OrdemServico();
		 ordemservico1.setDataDeAbertura(null);
		 ordemservico1.setDataDeFechamento(null);
		 ordemservico1.setDescricao("Descricao da ordem");
		 ordemservico1.setLatitudeFotografica("22.9035");
		 ordemservico1.setLongitudeFotografica("-43° 12' 27");
		 ordemservico1.setRegistroFotografico("foto");
		 ordemservico1.setContratista("Nome");
		 ordemservico1.setStatus("status da ordem");
		 
		 ordemServicoRepositorio.save(ordemservico1);
		 
		Recurso material1=new Recurso();
		material1.setNome("material 1"); 
		material1.setTipo("tipo do material");
		
		 recursoRepositorio.save(material1);
		
	}
	

}
