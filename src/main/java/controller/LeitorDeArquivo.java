package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import models.Cidadao;

public class LeitorDeArquivo {
	private List<Cidadao> cidadaos = new ArrayList<Cidadao>();
	private String linha;

	public List<Cidadao> lerTxt(String caminhoArquivo, String separador)
			throws IOException, FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(caminhoArquivo), "UTF-8"))) {

			br.readLine();
			while ((linha = br.readLine()) != null) {

				String[] colunas = linha.split(separador);
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
		}

		return cidadaos;

	}
}
