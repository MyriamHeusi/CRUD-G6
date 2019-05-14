package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.Usuario;
import br.com.senac.service.UsuarioService;
import br.com.senac.servico.exception.ObjectNotFoundException;

@Controller
@RequestMapping("/usuario") // view
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;	
	
	@GetMapping("/listarUsuario")//anotacao URL
	public ModelAndView listaUsuarios() {
		ModelAndView mv = new ModelAndView("usuario/paginaUsuarios");//nome do arquvo Html
		mv.addObject("usuarios",usuarioService.listaUsuario());
		return mv;
		
	}
	
	@GetMapping("/adicionarUsuario")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("usuario/paginaAdicionarUsuario");
		mv.addObject("usuario", new Usuario());
		mv.addObject("usuarios",usuarioService.listaUsuario());
		return mv;
	}
		
	@PostMapping("/salvarUsuario")
	public ModelAndView inserir(Usuario usuario) {
		usuarioService.inserir(usuario);
		return listaUsuarios();
	}
	
	@GetMapping("excluirUsuario/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id){
		usuarioService.excluir(id);
		return listaUsuarios();
	}
	
	@GetMapping("alterarUsuario/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id){
		ModelAndView mv = new ModelAndView ("usuario/paginaAlterar");
		mv.addObject("usuario", usuarioService.buscar(id));
		return mv;
		
	}
	@PostMapping("/alterarUsuario")
	public ModelAndView alterar (Usuario usuario) throws ObjectNotFoundException{
		usuarioService.alterar(usuario);
		return listaUsuarios();
	}
//	
	
}
