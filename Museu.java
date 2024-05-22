import java.util.ArrayList;
import java.util.List;

public class Museu {
    private List<ObraDeArte> obrasDeArte;

    public Museu() {
        obrasDeArte = new ArrayList<>();
    }

    public void adicionarObra(ObraDeArte obra) {
        obrasDeArte.add(obra);
    }

    public List<ObraDeArte> listarObras() {
        return obrasDeArte;
    }

    public ObraDeArte buscarObraPorTitulo(String titulo) {
        for (ObraDeArte obra : obrasDeArte) {
            if (obra.getTitulo().equalsIgnoreCase(titulo)) {
                return obra;
            }
        }
        return null;
    }

    public boolean atualizarObra(String titulo, ObraDeArte novaObra) {
        for (int i = 0; i < obrasDeArte.size(); i++) {
            if (obrasDeArte.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                obrasDeArte.set(i, novaObra);
                return true;
            }
        }
        return false;
    }

    public boolean excluirObra(String titulo) {
        return obrasDeArte.removeIf(obra -> obra.getTitulo().equalsIgnoreCase(titulo));
    }

    public List<ObraDeArte> buscarObrasPorArtista(String artista) {
        List<ObraDeArte> resultado = new ArrayList<>();
        for (ObraDeArte obra : obrasDeArte) {
            if (obra.getArtista().equalsIgnoreCase(artista)) {
                resultado.add(obra);
            }
        }
        return resultado;
    }

    public List<ObraDeArte> buscarObrasPorAno(int ano) {
        List<ObraDeArte> resultado = new ArrayList<>();
        for (ObraDeArte obra : obrasDeArte) {
            if (obra.getAnoDeCriacao() == ano) {
                resultado.add(obra);
            }
        }
        return resultado;
    }

    public List<ObraDeArte> buscarObrasPorTipo(String tipo) {
        List<ObraDeArte> resultado = new ArrayList<>();
        for (ObraDeArte obra : obrasDeArte) {
            if (obra.getTipoDeObra().equalsIgnoreCase(tipo)) {
                resultado.add(obra);
            }
        }
        return resultado;
    }

}
