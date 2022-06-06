package Jeu.Vues;

import Jeu.MaitreJeuSwing;
import Jeu.Modeles.ModeleFichePersonnage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuListVue extends JScrollPane {
    private List<ModeleFichePersonnage> modeles;
    private JPanel panel;

    public MenuListVue(List<ModeleFichePersonnage> modeles) {
        this.modeles = modeles;

        configurerVues();
    }

    private void configurerVues() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        setViewportView(panel);

        majElements();

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setPreferredSize(new Dimension(300, 350));
    }

    public void majElements() {
        panel.removeAll();
        for (ModeleFichePersonnage modele : modeles) {
            panel.add(new MenuItemVue(modele, e -> onModifyPressed(modele), e -> onDeletePressed(modele)));
        }

        panel.repaint();
        panel.revalidate();
    }

    private void onModifyPressed(ModeleFichePersonnage modele) {
        MaitreJeuSwing f = new MaitreJeuSwing(modele);
        f.setOnSaveAction(e -> majElements());
    }

    private void onDeletePressed(ModeleFichePersonnage modele) {
        modeles.remove(modele);
        majElements();
    }
}
