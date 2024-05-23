package controller;

import java.util.List;
import java.util.Scanner;

import model.Museu;
import model.ObraDeArte;

public class GerenciadorDeObrasDeArte {
    private Museu museu;
    private Scanner scanner;

    public GerenciadorDeObrasDeArte(Museu museu, Scanner scanner) {
        this.museu = museu;
        this.scanner = scanner;
    }

    public void cadastrarObra() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Artista: ");
        String artista = scanner.nextLine();
        System.out.print("Ano de criação: ");
        int anoDeCriacao = Integer.parseInt(scanner.nextLine());
        System.out.print("Tipo de obra: ");
        String tipoDeObra = scanner.nextLine();
        System.out.print("Localização: ");
        String localizacao = scanner.nextLine();

        ObraDeArte obra = new ObraDeArte(titulo, artista, anoDeCriacao, tipoDeObra, localizacao);
        museu.adicionarObra(obra);
        System.out.println("Obra cadastrada com sucesso!");
    }

    public void listarObras() {
        List<ObraDeArte> obras = museu.listarObras();
        if (obras.isEmpty()) {
            System.out.println("Nenhuma obra cadastrada.");
        } else {
            for (ObraDeArte obra : obras) {
                System.out.println(obra);
            }
        }
    }

    public void buscarObra() {
        System.out.print("Título da obra: ");
        String titulo = scanner.nextLine();
        ObraDeArte obra = museu.buscarObraPorTitulo(titulo);
        if (obra != null) {
            System.out.println(obra);
        } else {
            System.out.println("Obra não encontrada.");
        }
    }

    public void atualizarObra() {
        System.out.print("Título da obra a ser atualizada: ");
        String titulo = scanner.nextLine();
        ObraDeArte obraExistente = museu.buscarObraPorTitulo(titulo);
        if (obraExistente != null) {
            System.out.print("Novo título: ");
            String novoTitulo = scanner.nextLine();
            System.out.print("Novo artista: ");
            String novoArtista = scanner.nextLine();
            System.out.print("Novo ano de criação: ");
            int novoAno = Integer.parseInt(scanner.nextLine());
            System.out.print("Novo tipo de obra: ");
            String novoTipo = scanner.nextLine();
            System.out.print("Nova localização: ");
            String novaLocalizacao = scanner.nextLine();

            ObraDeArte novaObra = new ObraDeArte(novoTitulo, novoArtista, novoAno, novoTipo, novaLocalizacao);
            museu.atualizarObra(titulo, novaObra);
            System.out.println("Obra atualizada com sucesso!");
        } else {
            System.out.println("Obra não encontrada.");
        }
    }

    public void excluirObra() {
        System.out.print("Título da obra a ser excluída: ");
        String titulo = scanner.nextLine();
        if (museu.excluirObra(titulo)) {
            System.out.println("Obra excluída com sucesso!");
        } else {
            System.out.println("Obra não encontrada.");
        }
    }

    public void buscarObrasPorArtista() {
        System.out.print("Nome do artista: ");
        String artista = scanner.nextLine();
        List<ObraDeArte> obras = museu.buscarObrasPorArtista(artista);
        if (obras.isEmpty()) {
            System.out.println("Nenhuma obra encontrada para o artista: " + artista);
        } else {
            for (ObraDeArte obra : obras) {
                System.out.println(obra);
            }
        }
    }

    public void buscarObrasPorAno() {
        System.out.print("Ano de criação: ");
        int ano = Integer.parseInt(scanner.nextLine());
        List<ObraDeArte> obras = museu.buscarObrasPorAno(ano);
        if (obras.isEmpty()) {
            System.out.println("Nenhuma obra encontrada para o ano: " + ano);
        } else {
            for (ObraDeArte obra : obras) {
                System.out.println(obra);
            }
        }
    }

    public void buscarObrasPorTipo() {
        System.out.print("Tipo de obra: ");
        String tipo = scanner.nextLine();
        List<ObraDeArte> obras = museu.buscarObrasPorTipo(tipo);
        if (obras.isEmpty()) {
            System.out.println("Nenhuma obra encontrada para o tipo: " + tipo);
        } else {
            for (ObraDeArte obra : obras) {
                System.out.println(obra);
            }
        }
    }
}
