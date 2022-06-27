package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import controller.LeitorDeArquivo;
import dao.CidadaoDAO;
import models.Cidadao;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {

		LeitorDeArquivo leitor = new LeitorDeArquivo();
		CidadaoDAO dao = new CidadaoDAO();

		List<Cidadao> cidadaos = leitor.lerTxt("nlinhas.txt", "\\|");
		dao.salvar(cidadaos);

		System.out.println("Cidadãos da região sudeste:");
		dao.buscarSomenteOsDaRegiaoSudeste().forEach(System.out::println);

		System.out.println("Cidadãos maiores de 30:");
		dao.buscarSomenteOsMaioresDe30().forEach(System.out::println);

	}

};
