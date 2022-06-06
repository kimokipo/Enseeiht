package Jeu.Vues;

import Jeu.FichePersonnageSwing;
import Jeu.Modeles.ModeleFichePersonnage;
import Jeu.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItemVue extends JPanel {
    private final ModeleFichePersonnage modele;

    private JButton btnAppercue;
    private JButton btnModifier;
    private JButton btnSupprimer;

    public MenuItemVue(ModeleFichePersonnage modele, ActionListener onModifier, ActionListener onSupprimer) {
        this.modele = modele;

        configurerVues();

        btnModifier.addActionListener(onModifier);
        btnSupprimer.addActionListener(onSupprimer);
        btnAppercue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FichePersonnageSwing(modele);
            }
        });
    }

    private void configurerVues() {
        JLabel lblTitre = new JLabel(modele.getNom());
        lblTitre.setIcon(Utils.resizeImageIcon(modele.getImage(), Utils.DIMENSION_ICON, Utils.DIMENSION_ICON));
        btnAppercue = new JButton();
        btnAppercue.setIcon(Utils.resizeImageIcon(new ImageIcon("ressources/icon_open.png"), 16, 16));
        btnAppercue.setPreferredSize(new Dimension(32, 32));
        btnModifier = new JButton();
        btnModifier.setIcon(Utils.resizeImageIcon(new ImageIcon("ressources/icon_edit.png"), 16, 16));
        btnModifier.setPreferredSize(new Dimension(32, 32));
        btnSupprimer = new JButton();
        btnSupprimer.setIcon(Utils.resizeImageIcon(new ImageIcon("ressources/icon_trash.png"), 16, 16));
        btnSupprimer.setPreferredSize(new Dimension(32, 32));

        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        add(lblTitre);
        add(Box.createHorizontalGlue());
        add(btnAppercue);
        add(Box.createRigidArea(new Dimension(5, 1)));
        add(btnModifier);
        add(Box.createRigidArea(new Dimension(5, 1)));
        add(btnSupprimer);
    }
}