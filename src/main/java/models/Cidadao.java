package models;

import java.util.Objects;

public class Cidadao {
	

	private String municipio;
	private String estado;
	private String idade;
	private String nome;

	public Cidadao(String nome, String idade, String municipio, String estado) {

		this.municipio = municipio;
		this.estado = estado;
		this.idade = idade;
		this.nome = nome;
	}

	public Cidadao() {

	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public String getEstado() {
		return estado;
	}

	public String getIdade() {
		return idade;
	}

	public String getNome() {
		return nome;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {

		return "Cidadao [Nome= " + this.nome + " Idade= " + this.idade + "  Municipio= " + this.municipio + "  Estado: "
		+ this.estado + " ]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(estado, idade, municipio, nome);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidadao other = (Cidadao) obj;
		return Objects.equals(estado, other.estado) && Objects.equals(idade, other.idade)
				&& Objects.equals(municipio, other.municipio) && Objects.equals(nome, other.nome);
	}

}
