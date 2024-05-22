import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class GerenciamentoDeObrasDeArte {
    private static Museu museu = new Museu();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        carregarDados();
        exibirMenu();
        salvarDados();
    }

    private static void exibirMenu() {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Obra de Arte");
            System.out.println("2. Listar Obras de Arte");
            System.out.println("3. Buscar Obra por Título");
            System.out.println("4. Atualizar Obra de Arte");
            System.out.println("5. Excluir Obra de Arte");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarObra();
                    break;
                case 2:
                    listarObras();
                    break;
                case 3:
                    buscarObra();
                    break;
                case 4:
                    atualizarObra();
                    break;
                case 5:
                    excluirObra();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarObra() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Artista: ");
        String artista = scanner.nextLine();
        System.out.print("Ano de Criação: ");
        int anoDeCriacao = Integer.parseInt(scanner.nextLine());
        System.out.print("Tipo de Obra: ");
        String tipoDeObra = scanner.nextLine();
        System.out.print("Localização: ");
        String localizacao = scanner.nextLine();

        ObraDeArte obra = new ObraDeArte(titulo, artista, anoDeCriacao, tipoDeObra, localizacao);
        museu.adicionarObra(obra);
        System.out.println("Obra de arte cadastrada com sucesso!");
    }

    private static void listarObras() {
        List<ObraDeArte> obras = museu.listarObras();
        if (obras.isEmpty()) {
            System.out.println("Nenhuma obra cadastrada.");
        } else {
            for (ObraDeArte obra : obras) {
                System.out.println(obra);
            }
        }
    }

    private static void buscarObra() {
        System.out.print("Título da Obra: ");
        String titulo = scanner.nextLine();
        ObraDeArte obra = museu.buscarObraPorTitulo(titulo);
        if (obra != null) {
            System.out.println(obra);
        } else {
            System.out.println("Obra não encontrada.");
        }
    }

    private static void atualizarObra() {
        System.out.print("Título da Obra a ser atualizada: ");
        String titulo = scanner.nextLine();
        ObraDeArte obraExistente = museu.buscarObraPorTitulo(titulo);
        if (obraExistente != null) {
            System.out.print("Novo Título: ");
            String novoTitulo = scanner.nextLine();
            System.out.print("Novo Artista: ");
            String novoArtista = scanner.nextLine();
            System.out.print("Novo Ano de Criação: ");
            int novoAno = Integer.parseInt(scanner.nextLine());
            System.out.print("Novo Tipo de Obra: ");
            String novoTipo = scanner.nextLine();
            System.out.print("Nova Localização: ");
            String novaLocalizacao = scanner.nextLine();

            ObraDeArte novaObra = new ObraDeArte(novoTitulo, novoArtista, novoAno, novoTipo, novaLocalizacao);
            museu.atualizarObra(titulo, novaObra);
            System.out.println("Obra de arte atualizada com sucesso!");
        } else {
            System.out.println("Obra não encontrada.");
        }
    }

    private static void excluirObra() {
        System.out.print("Título da Obra a ser excluída: ");
        String titulo = scanner.nextLine();
        if (museu.excluirObra(titulo)) {
            System.out.println("Obra de arte excluída com sucesso!");
        } else {
            System.out.println("Obra não encontrada.");
        }
    }

    private static void salvarDados() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("obras.txt"));
            List<ObraDeArte> obras = museu.listarObras();
            for (ObraDeArte obra : obras) {
                writer.write(obra.getTitulo() + "," + obra.getArtista() + "," + obra.getAnoDeCriacao() + "," +
                             obra.getTipoDeObra() + "," + obra.getLocalizacao());
                writer.newLine();
            }
            writer.close();
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private static void carregarDados() {
        List<ObraDeArte> obras = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("obras.txt"));
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 5) {
                    String titulo = dados[0];
                    String artista = dados[1];
                    int anoDeCriacao = Integer.parseInt(dados[2]);
                    String tipoDeObra = dados[3];
                    String localizacao = dados[4];
                    ObraDeArte obra = new ObraDeArte(titulo, artista, anoDeCriacao, tipoDeObra, localizacao);
                    obras.add(obra);
                }
            }
            reader.close();
            System.out.println("Dados carregados com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao formatar número: " + e.getMessage());
        }

        for (ObraDeArte obra : obras) {
            museu.adicionarObra(obra);
        }
    }
}
