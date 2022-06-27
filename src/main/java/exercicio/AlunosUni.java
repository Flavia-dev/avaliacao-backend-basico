package exercicio;

public class AlunosUni {
	
	private String nome;
	private String matricula;
	private int classe;
	
	
//	public AlunosUni(String nome, String matricula, int classe) {
//		this.nome = nome;
//		this.matricula = matricula;
//		this.classe = classe;
//	}
	
	
	public AlunosUni(String nome, String matricula, int classe) {
		this.nome = nome;
		this.matricula = matricula;
		this.classe = classe;
	}


	public String getNome() {
		return nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public int getClasse() {
		return classe;
	}
	@Override
	public boolean equals(Object obj) {
		 if (obj instanceof AlunosUni) {
			 AlunosUni outro = (AlunosUni) obj;
		      return this.nome.equals(outro.getNome()) && this.matricula.equals(outro.getMatricula()) && this.classe == outro.getClasse();
		    }else {
		      return false;
		    }
		    
		  }
}



