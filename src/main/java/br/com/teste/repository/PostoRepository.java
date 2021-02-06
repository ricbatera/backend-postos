package br.com.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.teste.model.Posto;

public interface PostoRepository extends JpaRepository<Posto, Long>{
	@Query(value = "SELECT * FROM posto WHERE cidade like ?1%", nativeQuery = true)
	public List<Posto> buscaPorCidade(String cidade);
}
