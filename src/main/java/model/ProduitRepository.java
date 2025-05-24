package model;

import java.util.ArrayList;

public class ProduitRepository {
    private static final ArrayList<Produit> produits = new ArrayList<>();

    public static void addProduit(Produit produit) {
        if (!produits.contains(produit)) {
            produits.add(produit);
        }
    }

    public static ArrayList<Produit> getAllProduits() {
        return new ArrayList<>(produits);
    }

    public static void removeProduit(Produit produit) {
        produits.remove(produit);
    }
}
