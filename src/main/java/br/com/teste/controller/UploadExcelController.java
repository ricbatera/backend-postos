package br.com.teste.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.teste.dto.PostoDTO;
import br.com.teste.model.Posto;
import br.com.teste.service.ConverteExcel;
import br.com.teste.service.PostoService;

@CrossOrigin
@RestController
@RequestMapping("/upload")
public class UploadExcelController {
	
	@Autowired
	private ConverteExcel criaLista;
	
	@Autowired
	private PostoService service;
	
	@PostMapping
	public void upload(@RequestParam MultipartFile planilha) {
		try {
			byte[] bytes = planilha.getBytes();
			Path caminho = Paths.get("src/main/resources/valecard.xlsx");
			Files.write(caminho, bytes);
			List<Posto> postos = criaLista.importarPostos();
			service.salvarPostos(postos);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@GetMapping
	public List<PostoDTO> listar(){
		return service.listarTodos();
	}

}
