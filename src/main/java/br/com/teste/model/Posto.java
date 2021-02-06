package br.com.teste.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class Posto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nomePosto;
	private String endereco;
	private String cidade;
	private String nomeFantasia;
	@Temporal(TemporalType.TIMESTAMP)     
	private Date dataCadastro;
	
	public Posto() {	
	}

	public Posto(Long id, String nomePosto, String endereco, String cidade, String nomeFantasia, Date dataCadastro) {
		super();
		this.id = id;
		this.nomePosto = nomePosto;
		this.endereco = endereco;
		this.cidade = cidade;
		this.nomeFantasia = nomeFantasia;
		this.dataCadastro = dataCadastro;
	}
	
}
