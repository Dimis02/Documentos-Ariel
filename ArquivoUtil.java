package util;

import model.Documento;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtils {
    private static final String FILE_NAME = "documentos.txt";

    public static void salvarDocumento(Documento doc) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(doc.getTitulo() + ";" + doc.getAutor() + ";" + doc.getDataCriacao());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Documento> carregarDocumentos() {
        List<Documento> documentos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                documentos.add(new Documento(partes[0], partes[1], partes[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return documentos;
    }

    public static void excluirDocumento(String titulo) {
        List<Documento> documentos = carregarDocumentos();
        documentos.removeIf(doc -> doc.getTitulo().equals(titulo));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Documento doc : documentos) {
                writer.write(doc.getTitulo() + ";" + doc.getAutor() + ";" + doc.getDataCriacao());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
