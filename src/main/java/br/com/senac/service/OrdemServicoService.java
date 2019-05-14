package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.senac.dominio.OrdemServico;
import br.com.senac.repositorio.OrdemServicoRepositorio;
import br.com.senac.servico.exception.ObjectNotFoundException;


@Service
public class OrdemServicoService {
	
	@Autowired
	private OrdemServicoRepositorio repoOs;
	
	public OrdemServico buscar(Long id) throws ObjectNotFoundException {
		Optional<OrdemServico> objOrdemServico = repoOs.findById(id);
		return objOrdemServico.orElseThrow(()-> new ObjectNotFoundException("OrdemServico não encontrado! id: " + id +", Tipo: "+OrdemServico.class.getName()));
	}	
	
	
		public OrdemServico inserir(OrdemServico OrdemServico) {
			OrdemServico.setId(null);
			return repoOs.save(OrdemServico);
		}
		
		public OrdemServico alterar(OrdemServico objOrdemServico) throws ObjectNotFoundException{
			OrdemServico objOrdemServicoEncontrado = buscar(objOrdemServico.getId());
			objOrdemServicoEncontrado.setUsuario(objOrdemServico.getUsuario());
			objOrdemServicoEncontrado.setDataDeAbertura(objOrdemServico.getDataDeAbertura());
			objOrdemServicoEncontrado.setDataDeFechamento(objOrdemServico.getDataDeFechamento());
			objOrdemServicoEncontrado.setDescricao(objOrdemServico.getDescricao());
			objOrdemServicoEncontrado.setRegistroFotografico(objOrdemServico.getRegistroFotografico());
			objOrdemServicoEncontrado.setLatitudeFotografica(objOrdemServico.getLatitudeFotografica());
			objOrdemServicoEncontrado.setLongitudeFotografica(objOrdemServico.getLongitudeFotografica());
			objOrdemServicoEncontrado.setContratista(objOrdemServico.getContratista());
			objOrdemServicoEncontrado.setStatus(objOrdemServico.getStatus());
			
			return repoOs.save(objOrdemServicoEncontrado);
			}
		
		public void excluir(Long id) {
			repoOs.deleteById(id);
		}
		
		public List<OrdemServico> listaOrdemServico(){
			return repoOs.findAll();
		}
	}
