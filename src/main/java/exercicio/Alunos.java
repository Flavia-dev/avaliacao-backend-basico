package exercicio;

public class Alunos {
	
	private String nome;
	private String matricula;
	private int idade;
	
	
	public String getNome() {
		return nome;
	}


	public String getMatricula() {
		return matricula;
	}


	public int getIdade() {
		return idade;
	}


	public Alunos(String nome, String matricula, int idade) {
		this.nome = nome;
		this.matricula = matricula;
		this.idade = idade;
	}
	
	@Override
	public boolean equals(Object obj) {
		 if (obj instanceof Alunos) {
			 Alunos outro = (Alunos) obj;
		      return this.nome.equals(outro.getNome()) && this.matricula.equals(outro.getMatricula());
		    }else {
		      return false;
		    }
		    
		  }

}
