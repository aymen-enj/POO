package tp.gestionbibliotheque;

import java.io.*;

public class LectureTexte {
    public static void main(String[] args) {
        String inputFile = "livres.txt";
        String outputFile = "sortie.txt";

        // Lecture du fichier texte
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            System.out.println("Contenu du fichier texte :");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier texte : " + e.getMessage());
        }

        // Écriture dans un fichier texte
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Contenu écrit dans le fichier " + outputFile);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }
}