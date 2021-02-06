package br.com.teste.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.teste.dto.PostoDTO;
import br.com.teste.model.Posto;


@Component
public class PostoMapper {
	
	@Autowired
    private ModelMapper modelMapper;
	
	public PostoDTO modelToDTO(Posto posto) {
		return modelMapper.map(posto, PostoDTO.class);
	}
	
}
