package GestionDeStock;

import java.util.*;
import java.util.List;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.table.DefaultTableModel;

public class StockPanel extends JPanel {
    private StockManager<Produit> stockManager;
    private JTable table;
    private DefaultTableModel tableModel;

    public StockPanel() {
        stockManager = new StockManager<>();
        setLayout(new BorderLayout());

        String[] columnNames = {"Nom", "Prix", "Quantité"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        JButton addButton = new JButton("Ajouter");
        JButton removeButton = new JButton("Supprimer");
        JButton searchButton = new JButton("Rechercher");
        JButton sortButton = new JButton("Trier");
        JButton quitButton = new JButton("Quitter");

        buttonsPanel.add(addButton);
        buttonsPanel.add(removeButton);
        buttonsPanel.add(searchButton);
        buttonsPanel.add(sortButton);
        buttonsPanel.add(quitButton);
        add(buttonsPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouterProduit();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supprimerProduit();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rechercherProduit();
            }
        });

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trierProduits();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    private void ajouterProduit() {
        String nom = JOptionPane.showInputDialog("Nom du produit :");
        double prix = Double.parseDouble(JOptionPane.showInputDialog("Prix :"));
        int quantite = Integer.parseInt(JOptionPane.showInputDialog("Quantité :"));
        Produit produit = new Produit(nom, prix, quantite);
        stockManager.ajouterProduit(produit);
        updateTable();
    }

    private void supprimerProduit() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            stockManager.supprimerProduit(stockManager.getProduits().get(selectedRow));
            updateTable();
        }
    }

    private void rechercherProduit() {
        String nom = JOptionPane.showInputDialog("Nom à rechercher :");
        List<Produit> resultats = stockManager.rechercherProduits(nom);
        tableModel.setRowCount(0);
        for (Produit p : resultats) {
            tableModel.addRow(new Object[]{p.getNom(), p.getPrix(), p.getQuantite()});
        }
    }

    private void trierProduits() {
        stockManager.trierProduits();
        updateTable();
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (Produit p : stockManager.getProduits()) {
            tableModel.addRow(new Object[]{p.getNom(), p.getPrix(), p.getQuantite()});
        }
    }
}

