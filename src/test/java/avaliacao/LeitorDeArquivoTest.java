package avaliacao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import controller.LeitorDeArquivo;
import models.Cidadao;

public class LeitorDeArquivoTest {

	@Test
	public void lerUmArquivoComVariasLinhas() throws IOException {
		LeitorDeArquivo leitor = new LeitorDeArquivo();
		List<Cidadao> lerVariasLinhas = leitor.lerTxt("nlinhas.txt", "\\|");

		List<Cidadao> cidadaosEsperados = new ArrayList<Cidadao>();

		cidadaosEsperados.add(new Cidadao("Antonio Carlos", "43", "São Tomé das Letras", "MG"));
		cidadaosEsperados.add(new Cidadao("Cláudia Pereira", "20", "Aparecida", "SP"));
		cidadaosEsperados.add(new Cidadao("José dos Santos", "30", "Manaus", "AM"));
		lerVariasLinhas.containsAll(cidadaosEsperados);

		assertEquals(cidadaosEsperados, lerVariasLinhas);

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
