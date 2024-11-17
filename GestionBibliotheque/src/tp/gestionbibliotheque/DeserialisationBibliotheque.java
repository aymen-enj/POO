package tp.gestionbibliotheque;

import java.io.*;
import java.util.List;

public class DeserialisationBibliotheque {
    public static void main(String[] args) {
        String fichier = "bibliotheque.ser";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            List<Livre> bibliotheque = (List<Livre>) ois.readObject();
            System.out.println("Biblioth�que d�s�rialis�e :");
            for (Livre livre : bibliotheque) {
                System.out.println(livre);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur lors de la d�s�rialisation : " + e.getMessage());
        }
    }
}
