package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import models.Cidadao;

public class CidadaoDAO {

	public CidadaoDAO(Connection connection) {

	};

	public CidadaoDAO() {

	};

	public void salvar(List<Cidadao> cidadaos) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection con = factory.recuperarConexao();
		
		for (Cidadao cidadao : cidadaos) {

			try (PreparedStatement stm = con.prepareStatement("INSERT INTO LOGRADOUROS(municipio, estado) VALUES(?,?)",
					Statement.RETURN_GENERATED_KEYS))

			{
				stm.setString(1, cidadao.getMunicipio());
				stm.setString(2, cidadao.getEstado());
				stm.execute();
				ResultSet rst = stm.getGeneratedKeys();
				while (rst.next()) {
					Integer id = rst.getInt(1);
					int id_logradouro = id;
					try (PreparedStatement stm1 = con
							.prepareStatement("INSERT INTO PESSOAS(nome, idade,id_logradouro) VALUES(?,?,?)")) {

						String nome = cidadao.getNome();
						String idade = cidadao.getIdade();
						stm1.setString(1, nome);
						stm1.setString(2, idade);
						stm1.setString(3, Integer.toString(id_logradouro));
						stm1.execute();
					}
				}
			}
		}

	}

	public List<Cidadao> buscarSomenteOsDaRegiaoSudeste() throws SQLException {

		List<Cidadao> cidadaos = new ArrayList<Cidadao>();		
		String sql = "SELECT P.NOME,P.IDADE, L.MUNICIPIO, L.ESTADO FROM PESSOAS P INNER JOIN LOGRADOUROS L ON L.ID = P.ID_LOGRADOURO "
				+ "WHERE L.ESTADO='SP' OR L.ESTADO='RJ' OR L.ESTADO='MG' OR L.ESTADO='ES'";

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Cidadao cidadao = new Cidadao(rst.getString(1), rst.getString(2), rst.getString(3),
							rst.getString(4));
					cidadaos.add(cidadao);

				}
			}
		}

		return cidadaos;
	}

	public List<Cidadao> buscarSomenteOsMaioresDe30() throws SQLException {

		List<Cidadao> cidadaos = new ArrayList<Cidadao>();
		String sql = "SELECT P.NOME,P.IDADE, L.MUNICIPIO, L.ESTADO FROM PESSOAS P INNER JOIN LOGRADOUROS L ON L.ID = P.ID_LOGRADOURO ";

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Cidadao cidadao = new Cidadao(rst.getString(1), rst.getString(2), rst.getString(3),
							rst.getString(4));
					cidadaos.add(cidadao);
				}

				return cidadaos.stream().filter(p -> Integer.parseInt(p.getIdade()) >= (30))
						.collect(Collectors.toList());

			}
		}

	}
}