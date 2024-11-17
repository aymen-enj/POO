package tp.gestionbibliotheque;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerialisationBibliotheque {
    public static void main(String[] args) {
        List<Livre> bibliotheque = new ArrayList<>();
        bibliotheque.add(new Livre("1984", "George Orwell", 1949));
        bibliotheque.add(new Livre("Le Petit Prince", "Antoine de Saint-Exup�ry", 1943));
        bibliotheque.add(new Livre("L'�tranger", "Albert Camus", 1942));

        String fichier = "bibliotheque.ser";

        // S�rialisation de la liste
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(bibliotheque);
            System.out.println("Biblioth�que s�rialis�e dans le fichier " + fichier);
        } catch (IOException e) {
            System.err.println("Erreur lors de la s�rialisation : " + e.getMessage());
        }
    }
}
