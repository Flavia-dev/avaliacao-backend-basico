package exercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio {

	public static void main(String[] args) {

		Alunos aluno1 = new Alunos("Marina", "J45", 16);
		Alunos aluno2 = new Alunos("Paulo", "J58", 17);
		Alunos aluno3 = new Alunos("Miguel", "J26", 14);

		List<Alunos> listaAlunos = new ArrayList<>();
		listaAlunos.add(aluno1);
		listaAlunos.add(aluno2);
		listaAlunos.add(aluno3);

		AlunosUni alunoUni1 = new AlunosUni("Carolina", "J2110", 32);
		AlunosUni alunoUni2 = new AlunosUni("Ana Paula", "J2215", 25);
		AlunosUni alunoUni3 = new AlunosUni("Thiago", "J2105", 33);

		List<AlunosUni> listaAlunosUni = new ArrayList<AlunosUni>();
		listaAlunosUni.add(alunoUni1);
		listaAlunosUni.add(alunoUni2);
		listaAlunosUni.add(alunoUni3);

		System.out.println("Digite o nome e a matricula do aluno que deseja buscar");

		try (Scanner s = new Scanner(System.in)) {

			String nomeDigitado = s.nextLine();
			String matriculaDigitada = s.nextLine();

			Alunos alunoDigitado = new Alunos(nomeDigitado, matriculaDigitada, 0);
			if (listaAlunos.contains(alunoDigitado)) {
				System.out.println("Aluno encontrado");

			} else {
				System.out.println("Aluno digitado não se encontra na lista de Alunos");
			}

			System.out.println("Digite o nome,  matricula e classe do aluno que deseja buscar");

			nomeDigitado = s.nextLine();
			matriculaDigitada = s.nextLine();
			int classeDigitada = Integer.parseInt(s.nextLine());

			AlunosUni novoAlunoDigitado = new AlunosUni(nomeDigitado, matriculaDigitada, classeDigitada);

			if (listaAlunosUni.contains(novoAlunoDigitado)) {
				System.out.println("Aluno universitario encontrado");
			} else {
				System.out.println("Aluno digitado não se encontra na lista de Alunos Universitarios");
			}

		}
	}

}