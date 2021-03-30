package br.com.teste.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.dto.PostoDTO;
import br.com.teste.mapper.PostoMapper;
import br.com.teste.model.Posto;
import br.com.teste.repository.PostoRepository;

@Service
public class PostoService {
	@Autowired
	private PostoRepository repo;
	
	@Autowired
	private PostoMapper mapper;
	
	public void salvarPostos (List<Posto> postos) {
		repo.deleteAll();
		repo.saveAll(postos);
	}
	
	public List<PostoDTO> listarTodos(){
		return repo.findAll()
				.stream()
				.map(post -> mapper.modelToDTO(post))
				.collect(Collectors.toList());
	}
	
	public List<Posto> buscaPorCidade(String cidade){
		return repo.buscaPorCidade(cidade);
	}
	
	public void deletar() {
		repo.deleteAll();
	}

}
