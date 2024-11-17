package tp.gestionbibliotheque;

import java.io.*;

public class LectureFichierBinaire {
    public static void main(String[] args) {
        String inputFile = "src/kindi.png";
        String outputFile = "copie_image.png";

        // Lecture et affichage du fichier binaire
        try (FileInputStream fis = new FileInputStream(inputFile)) {
            System.out.println("Contenu du fichier binaire (en octets) :");
            int byteData;
            while ((byteData = fis.read()) != -1) {
                System.out.print(byteData + " ");
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        // Copie du fichier binaire
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Fichier copié avec succès vers " + outputFile);
        } catch (IOException e) {
            System.err.println("Erreur lors de la copie du fichier : " + e.getMessage());
        }
    }
}