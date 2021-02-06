package br.com.teste.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import br.com.teste.model.Posto;
import lombok.Cleanup;

@Service
public class ConverteExcel {

	public List<Posto> importarPostos() throws FileNotFoundException {
		List<Posto> postos = new ArrayList<>();
		try {
			@Cleanup //lendo o arquivo excel
			FileInputStream planilha = new FileInputStream("src/main/resources/valecard.xlsx");
			Workbook workbook = new XSSFWorkbook(planilha);
			
			Sheet sheet = workbook.getSheetAt(0);
			
			List<Row> linhas =(List<Row>) toList(sheet.iterator());
			linhas.remove(0);
			
			linhas.forEach(linha->{
				List<Cell> celulas = (List<Cell>) toList(linha.cellIterator());
				Posto posto = Posto.builder()
						.cidade(celulas.get(3).getStringCellValue())
						.endereco(celulas.get(2).getStringCellValue())
						.nomePosto(celulas.get(1).getStringCellValue())
						.nomeFantasia(celulas.get(0).getStringCellValue())
						.dataCadastro(new java.sql.Date(System.currentTimeMillis()))
						.build();
				
				postos.add(posto);
			});
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return postos;
	}
	
	public List<?> toList(Iterator<?> iterator){
		return IteratorUtils.toList(iterator);
	}
	
	public void imprimir(List<Posto> postos) {
		postos.forEach(System.out::println);
	}
}
