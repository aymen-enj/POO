package GestionDeStock;

import java.util.*;

class StockManager<T extends Comparable<T>> {
    private List<T> produits;

    public StockManager() {
        this.produits = new ArrayList<>();
    }

    public void ajouterProduit(T produit) {
        produits.add(produit);
    }

    public void supprimerProduit(T produit) {
        produits.remove(produit);
    }

    public List<T> getProduits() {
        return new ArrayList<>(produits);
    }

    public List<T> rechercherProduits(String nom) {
        List<T> resultats = new ArrayList<>();
        for (T produit : produits) {
            if (produit.toString().contains(nom)) {
                resultats.add(produit);
            }
        }
        return resultats;
    }

    public void trierProduits() {
        Collections.sort(produits);
    }
}