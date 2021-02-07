package br.com.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.model.Posto;
import br.com.teste.service.PostoService;

@CrossOrigin
@RestController
@RequestMapping("/postos")
public class PostoController {
	
	@Autowired
	private PostoService service;
	
	@GetMapping("{cidade}")
	public List<Posto> buscarPostosPorCidade(@PathVariable String cidade){
		System.out.println("Ricardo" + cidade);
		return service.buscaPorCidade(cidade);
	}

}
