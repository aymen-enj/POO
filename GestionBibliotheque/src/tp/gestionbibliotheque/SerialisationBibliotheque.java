package tp.gestionbibliotheque;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerialisationBibliotheque {
    public static void main(String[] args) {
        List<Livre> bibliotheque = new ArrayList<>();
        bibliotheque.add(new Livre("1984", "George Orwell", 1949));
        bibliotheque.add(new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 1943));
        bibliotheque.add(new Livre("L'Étranger", "Albert Camus", 1942));

        String fichier = "bibliotheque.ser";

        // Sérialisation de la liste
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(bibliotheque);
            System.out.println("Bibliothèque sérialisée dans le fichier " + fichier);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sérialisation : " + e.getMessage());
        }
    }
}
