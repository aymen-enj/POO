package GestionDeStock;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Gestion de Stock");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        StockPanel stockPanel = new StockPanel();
        add(stockPanel);
    }
}
