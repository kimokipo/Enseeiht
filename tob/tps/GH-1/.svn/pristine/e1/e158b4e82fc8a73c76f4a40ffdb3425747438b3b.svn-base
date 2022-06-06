package Jeu;

import Jeu.Modeles.ModeleFichePersonnage;
import Jeu.Vues.MenuListVue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MenuSelectionSwing {

    private JFrame fenetre;

    private MenuListVue menuListe;
    private JButton btnAjouter;
    private JButton btnSauvegarder;

    private List<ModeleFichePersonnage> listModel;

    public MenuSelectionSwing() {
        this.fenetre = new JFrame("Menu Principale");

        configurerVues();
        configurerActions();

        this.fenetre.pack();
        this.fenetre.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.fenetre.setLocation(dim.width/2-this.fenetre.getSize().width/2, dim.height/2-this.fenetre.getSize().height/2);
    }

    private void configurerVues() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        listModel = new ArrayList<>();
        listModel.add(new ModeleFichePersonnage("Nouveau joueur", ""));
        menuListe = new MenuListVue(listModel);

        panel.add(menuListe);
        panel.add(Box.createVerticalStrut(10));

        Container ctr = new Container();
        ctr.setLayout(new BoxLayout(ctr, BoxLayout.LINE_AXIS));

        btnAjouter = new JButton("Ajouter");
        btnSauvegarder = new JButton("Sauvegarder");
        ctr.add(Box.createHorizontalGlue());
        ctr.add(btnAjouter);
        ctr.add(Box.createHorizontalGlue());
        ctr.add(btnSauvegarder);
        ctr.add(Box.createHorizontalGlue());
        ctr.setMaximumSize(new Dimension(100000, btnAjouter.getMaximumSize().height));
        panel.add(ctr);
        panel.add(Box.createVerticalStrut(10));

        fenetre.setContentPane(panel);
        //fenetre.setPreferredSize(new Dimension(400, 500));
    }

    private void configurerActions() {
        btnAjouter.addActionListener(e -> {
            listModel.add(new ModeleFichePersonnage("Nouveau joueur", ""));
            menuListe.majElements();
        });

        btnSauvegarder.addActionListener(e -> System.out.println("Non implémentée"));
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
