package view;

import java.util.Scanner;
import controller.GerenciadorDeObrasDeArte;
import model.Museu;

public class Sistema {
    private static Museu museu;
    private static Scanner scanner = new Scanner(System.in);
    private static GerenciadorDeObrasDeArte gerenciador;

    public static void setMuseu(Museu m) {
        museu = m;
        gerenciador = new GerenciadorDeObrasDeArte(museu, scanner);
    }

    public static void menu() {
        System.out.println("\n===== MENU =====\n\n" +
                           "< 1 > Cadastrar Obra de Arte\n" +
                           "< 2 > Listar Obras de Arte\n" +
                           "< 3 > Buscar Obra por Título\n" +
                           "< 4 > Atualizar Obra de Arte\n" +
                           "< 5 > Excluir Obra de Arte\n" +
                           "< 6 > Buscar Obras por Artista\n" +
                           "< 7 > Buscar Obras por Ano de Criação\n" +
                           "< 8 > Buscar Obras por Tipo\n" +
                           "< 0 > Sair\n\n" +
                           "Selecione uma opção: ");
    }

    public static void opcoesMenu(int opcao) {
        switch (opcao) {
            case 1:
                gerenciador.cadastrarObra();
                break;
            case 2:
                gerenciador.listarObras();
                break;
            case 3:
                gerenciador.buscarObra();
                break;
            case 4:
                gerenciador.atualizarObra();
                break;
            case 5:
                gerenciador.excluirObra();
                break;
            case 6:
                gerenciador.buscarObrasPorArtista();
                break;
            case 7:
                gerenciador.buscarObrasPorAno();
                break;
            case 8:
                gerenciador.buscarObrasPorTipo();
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
}
