package br.com.teste.dto;

import java.util.Date;

import lombok.Data;
@Data
public class PostoDTO {
	private Long id;
	private String nomePosto;
	private String endereco;
	private String cidade;
	private String nomeFantasia;	   
	private Date dataCadastro;
}
