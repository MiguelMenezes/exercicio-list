package applicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionario;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);

		List<Funcionario> listaDeFuncionarios = new ArrayList<>();

		System.out.println("[----------APP FAKE RH----------]");
		System.out.println();
		System.out.print("Quantos funcion�rios deseja cadastrar: ");

		int numDeFuncionarios = teclado.nextInt();

		for (int i = 1; i <= numDeFuncionarios; i++) {
			System.out.println();
			System.out.println("Funcion�rio #" + i + ":");
			System.out.print("ID: ");
			int id = teclado.nextInt();
			int cont = 3;

			while (existeId(listaDeFuncionarios, id)) {

				System.out.println("J� existe um cadastro com o ID informado! " + cont + " tentativa(s) restante(s)");
				System.out.println("Informe outro ID");
				id = teclado.nextInt();
				cont -= 1;
				if (cont <= 0) {
					System.out.println("Tentativas excedidas! Encerrando sistema...");
					System.exit(0);
				}
			}

			teclado.nextLine();
			System.out.print("Nome: ");
			String nome = teclado.nextLine();
			System.out.print("Sal�rio: ");
			double salario = teclado.nextDouble();
			listaDeFuncionarios.add(new Funcionario(id, nome, salario));

		}
		System.out.println();
		System.out.println("_________________________________________________________________________");
		System.out.println();
		System.out.println("[----------LISTA DE FUNCION�RIOS----------]:");
		System.out.println();

		for (Funcionario f : listaDeFuncionarios) {
			System.out.println(f);
		}

		System.out.println();

		System.out.print("Digite o ID do funcion�rio a receber o aumento de sal�rio: ");
		int idAumento = teclado.nextInt();

		Integer posicao = posicaoDoId(listaDeFuncionarios, idAumento);

		if (posicao == null) {
			System.out.println("ID informada n�o existe!");
		} else {
			System.out.println("Informe o percentual de aumento salarial: ");
			double percent = teclado.nextDouble();
			listaDeFuncionarios.get(posicao).aumentarSalario(percent);
		}

		System.out.println();
		System.out.println("------------------------------------------------------------------------");
		System.out.println();
		System.out.println("[__________LISTA DE FUNCION�RIOS__________]:");

		for (Funcionario func : listaDeFuncionarios) {
			System.out.println(func);
		}

		teclado.close();
	}

	public static Integer posicaoDoId(List<Funcionario> listaDeFuncionarios, int id) {

		for (int i = 0; i < listaDeFuncionarios.size(); i++) {
			if (listaDeFuncionarios.get(i).getId() == id) {
				return i;
			}
		}
		return null;

	}

	public static boolean existeId(List<Funcionario> listaFuncionario, int id) {
		Funcionario f = listaFuncionario.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return f != null;
	}

}
