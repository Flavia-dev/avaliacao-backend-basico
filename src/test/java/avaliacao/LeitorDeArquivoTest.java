package avaliacao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import controller.LeitorDeArquivo;
import models.Cidadao;

public class LeitorDeArquivoTest {

	@Test
	public void lerUmArquivoComVariasLinhas() throws IOException {
		LeitorDeArquivo leitor = new LeitorDeArquivo();
		List<Cidadao> cidadaos = new ArrayList<Cidadao>();

		Scanner in = new Scanner(new FileReader("nlinhas.txt"));
		in.nextLine();
		while (in.hasNextLine()) {
			String line = in.nextLine();
			String[] colunas = line.split("\\|");
			Cidadao dados = new Cidadao();
			try {
				dados.setNome(colunas[0].trim());
				dados.setIdade(colunas[1].trim());
				dados.setMunicipio(colunas[2].trim());
				dados.setEstado(colunas[3].trim());
				cidadaos.add(dados);
			} catch (Exception e) {
				System.out.println("Erro : " + e);
			}

		}
		List<Cidadao> lerVariasLinhas = leitor.lerTxt("nlinhas.txt", "\\|");
		assertEquals(cidadaos.hashCode(), lerVariasLinhas.hashCode());
	}

	@Test
	public void lerUmArquivoVazio() throws IOException {
		List<Cidadao> cidadaos = new ArrayList<>();
		LeitorDeArquivo leitor = new LeitorDeArquivo();
		List<Cidadao> lerVazio = leitor.lerTxt("vazio.txt", "\\|");
		assertEquals(cidadaos, lerVazio);

	}

	@Test
	public void lerUmArquivoDeUmaLinha() throws IOException {
		LeitorDeArquivo leitor = new LeitorDeArquivo();

		List<Cidadao> lerUmaLinha = leitor.lerTxt("umalinha.txt", "\\|");
		assertEquals(1, lerUmaLinha.size());

		assertEquals("Antonio Carlos", lerUmaLinha.get(0).getNome());
		assertEquals("43", lerUmaLinha.get(0).getIdade());
		assertEquals("São Tomé das Letras", lerUmaLinha.get(0).getMunicipio());
		assertEquals("MG", lerUmaLinha.get(0).getEstado());

	}

	@Test
	public void lerUmArquivoInexistente() throws IOException {
		LeitorDeArquivo leitor = new LeitorDeArquivo();
		assertThrows(IOException.class, () -> leitor.lerTxt("texto.txt", "\\|"));

	}

}






