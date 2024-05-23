package main;

import java.io.IOException;
import java.util.Scanner;
import view.Sistema;
import model.Museu;

public class Principal {
    private static final String FILENAME = "museu.dat";

    public static void main(String[] args) {
        Museu museu = null;

        try {
            museu = Museu.carregarDados(FILENAME);
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nenhum dado encontrado, iniciando novo museu.");
            museu = new Museu();
        }

        Sistema.setMuseu(museu);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                Sistema.menu();
                int opcao = scanner.nextInt();
                scanner.nextLine();
                Sistema.opcoesMenu(opcao);

                if (opcao == 0) {
                    museu.salvarDados(FILENAME);
                    System.out.println("Dados salvos com sucesso!");
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }
}

