import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PersistenciaDeDados {

    public static void salvarObras(List<ObraDeArte> obras, String arquivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo));
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
}
