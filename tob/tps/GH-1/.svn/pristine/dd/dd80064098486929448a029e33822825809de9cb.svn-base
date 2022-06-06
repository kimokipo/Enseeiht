package Jeu;

import Jeu.Interfaces.Capacite;
import Jeu.Modeles.ModeleFichePersonnage;
import Jeu.Vues.TexteActionVue;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Programmation de l'interface du maitre du jeu avec une interface graphique
 * Swing.
 *
 *
 * @author Kamal Hammi
 * @version $Version: 1.0 $
 */

public class MaitreJeuSwing {

    // Choix de rÃ©alisation :
    // ----------------------
    //

    private final ModeleFichePersonnage modele; // le modÃ¨le du maitre de jeu.

    // Les Ã©lÃ©ments de la vue (IHM)
    // ----------------------------

    /** FenÃªtre principale */
    private final JFrame fenetre;

    private final Map<Capacite, JTextField> tfCapaciteMap;

    /** Bouton pour Modifier l'image du joueur */
    private final JButton boutonModifierImage = new JButton("Modifier");

    private final JButton boutonSauvegarder = new JButton("Sauvegarder");

    private final JButton boutonReset = new JButton("Réinitialiser");

    private final JTextField nomTexte = new JTextField(6);
    private final JTextField roleTexte = new JTextField(6);
    private final JProgressBar vieValeur = new JProgressBar(0, 100);
    /** Image du jouer */
    private final JLabel labelImage = new JLabel();

    private TexteActionVue capacite;
    private TexteActionVue ajouterInventaire;
    private TexteActionVue supprimerInventaire;

    private final Container contenu21 = new Container();
    private final Container contenu22 = new Container();
    /*
     * private final JButton boutonPlus = new JButton(" + "); private final JButton
     * boutonMoins = new JButton(" - ");
     */
    // Le constructeur
    // ---------------

    /** Construire l'interface du maitre du jeu */
    public MaitreJeuSwing(ModeleFichePersonnage modele) {
        // Initialiser le modÃ¨le
        this.modele = modele;
        this.tfCapaciteMap = new HashMap<>();

        // Construire la vue (prÃ©sentation)
        // DÃ©finir la fenÃªtre principale
        this.fenetre = new JFrame("Joueur");
        this.fenetre.setLocation(100, 200);

        configurerVues();
        configurerActions();
        majVues();

        // afficher la fenÃªtre
        this.fenetre.pack();
        this.fenetre.setVisible(true);
    }

    private void configurerVues() {
        final JLabel nom = new JLabel("Nom");
        final JLabel role = new JLabel("Role");
        final JLabel vie = new JLabel("Vie");
        final JLabel capacites = new JLabel("Capacités");
        final JLabel inventaire = new JLabel("Inventaire");

        JPanel contenuPrincipale = new JPanel();
        contenuPrincipale.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.fenetre.setContentPane(contenuPrincipale);

        Container contenuHaut = new Container();
        Container contenuBas = new Container();

        contenuPrincipale.setLayout(new BoxLayout(contenuPrincipale, BoxLayout.PAGE_AXIS));

        contenuPrincipale.add(contenuHaut);
        contenuPrincipale.add(Box.createRigidArea(new Dimension(1, 30)));
        contenuPrincipale.add(contenuBas);

        GridLayout gl = new GridLayout(1, 2);
        gl.setHgap(20);
        contenuHaut.setLayout(gl);

        Container contenu1 = new Container();
        Container contenu2 = new Container();

        contenuHaut.add(contenu1);
        contenuHaut.add(contenu2);

        contenu1.setLayout(new BoxLayout(contenu1, BoxLayout.PAGE_AXIS));
        contenu2.setLayout(new BoxLayout(contenu2, BoxLayout.PAGE_AXIS));

        Container contenuImage = new Container();
        contenuImage.setLayout(new FlowLayout());
        contenuImage.add(boutonModifierImage);

        // Afficher une image par défaut.
        labelImage.setIcon(modele.getImage());
        labelImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenu1.add(labelImage);
        contenu1.add(contenuImage);
        contenu1.add(Box.createVerticalStrut(10));

        Container contenu11 = new Container();
        Container contenu12 = new Container();

        contenu1.add(contenu11);
        contenu1.add(contenu12);

        contenu11.setLayout(new GridLayout(1, 2));
        contenu12.setLayout(new GridLayout(1, 2));

        contenu11.add(nom);
        contenu11.add(nomTexte);
        contenu12.add(role);
        contenu12.add(roleTexte);

        Container contenuFiche = new Container();
        contenuFiche.setLayout(new FlowLayout());
        // contenuFiche.add(boutonImprimerFiche);
        contenu1.add(contenuFiche);

        // Container contenuVie = new Container();
        // contenuVie.setLayout(new GridLayout(1, 2));

        contenu2.add(vie);
        vie.setAlignmentX(Component.CENTER_ALIGNMENT);
        vieValeur.setValue(50);
        vieValeur.setStringPainted(true);
        // contenuVie.add(vieValeur);

        contenu2.add(Box.createVerticalStrut(10));
        contenu2.add(vieValeur);

        Border blackline = BorderFactory.createLineBorder(Color.black);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBorder(blackline);
        capacite = new TexteActionVue("Ajouter une capacité", e -> modifierCapacites());
        panel.add(capacite);
        panel.add(contenu21);

        capacites.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenu2.add(capacites);
        // contenu2.add(contenu21);
        contenu2.add(panel);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBorder(blackline);
        ajouterInventaire = new TexteActionVue("Ajouter à l'inventaire", e -> modifierInventaire());
        // supprimerInventaire = new TexteActionVue("Supprimer de l'inventaire", e ->
        // modifierInventaire(false));
        panel.add(ajouterInventaire);
        // panel.add(supprimerInventaire);
        panel.add(contenu22);

        inventaire.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenu2.add(inventaire);
        contenu2.add(panel);

        // ContenuBas
        Container contenuBas1 = new Container();

        contenuBas.setLayout(new BoxLayout(contenuBas, BoxLayout.PAGE_AXIS));
        contenuBas.add(contenuBas1);

        Container contenuBas2 = new Container();
        contenuBas.add(contenuBas2);

        // contenuBas2.setLayout (new GridLayout(1,2));
        contenuBas2.setLayout(new FlowLayout());
        contenuBas2.add(boutonReset);
        contenuBas2.add(boutonSauvegarder);
        contenuBas1.setLayout(new BoxLayout(contenuBas1, BoxLayout.PAGE_AXIS));

        /*
         * capacite = new TexteActionVue("Ajouter une capacité", e ->
         * modifierCapacites()); ajouterInventaire = new
         * TexteActionVue("Ajouter à l'inventaire", e -> modifierInventaire(true));
         * supprimerInventaire = new TexteActionVue("Supprimer de l'inventaire", e ->
         * modifierInventaire(false)); contenuBas1.add(capacite);
         * contenuBas1.add(ajouterInventaire); contenuBas1.add(supprimerInventaire);
         */
    }

    private void configurerActions() {
        // Construire le contrÃ´leur (gestion des Ã©vÃ©nements)
        this.boutonModifierImage.addActionListener(e -> modifierImage());
        this.boutonReset.addActionListener(e -> reinitialiser());
        //this.boutonCreerFiche.addActionListener(e -> creerFiche());

        this.vieValeur.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                double pourcentage = ((double) e.getX()) / vieValeur.getWidth();
                vieValeur.setValue((int) (pourcentage * 100));
            }
        });

        this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // Quelques rÃ©actions aux interactions de l'utilisateur
    // ----------------------------------------------------

    /*public void creerFiche() {
        if (nomTexte.getText().length() > 0) {
            ModeleFichePersonnage modeleFiche = new ModeleFichePersonnage(nomTexte.getText(), roleTexte.getText(),
                    image, String.valueOf(vieValeur.getValue()), modele.getInventaire());
            for (Map.Entry<String, JTextField> e : modele.getCapacites().entrySet()) {
                modeleFiche.ajouterCapacite(e.getKey(), e.getValue().getText());
            }
            for (Map.Entry<ModeleFichePersonnage, FichePersonnageSwing> e : listModeleFichesSwing.entrySet()) {
                if (e.getKey().estEgale(modeleFiche) | e.getKey().getNom().equals(nomTexte.getText())) {
                    e.getValue().getfenetre().setVisible(false);
                    break;
                }
            }
            listModeleFichesSwing.put(modeleFiche, new FichePersonnageSwing(modeleFiche));
        }
    }*/

    public void majVues() {
        contenu22.removeAll();
        contenu21.removeAll();
        nomTexte.setText(modele.getNom());
        roleTexte.setText(modele.getRole());
        vieValeur.setValue(modele.getVie());
        labelImage.setIcon(modele.getImage());
        majCapacites();
        majInventaire();
    }

    public void reinitialiser() {
        modele.reinitialiser();
        majVues();
    }

    /** Modifier l’image du joueur. */
    public void modifierImage() {
        ImageIcon nouvelleImage = Utils.telechargerImage(this.fenetre);
        if (nouvelleImage == null)
            return;

        modele.setImage(nouvelleImage);
        labelImage.setIcon(modele.getImage());
    }

    public void modifierCapacites() {
        if(capacite.getTexte().equals(""))
            return;

        if(modele.getCapacites().stream().anyMatch(x -> x.getNom().equals(capacite.getTexte())))
            return;

        tfCapaciteMap.put(modele.ajouterCapacite(capacite.getTexte()), new JTextField());
        majCapacites();
    }

    public void majCapacites() {
        contenu21.removeAll();
        contenu21.setLayout(new GridLayout(modele.getCapacites().size(), 2));
        for (Capacite c : modele.getCapacites()) {
            contenu21.add(new JLabel(c.getNom()));
            if (!tfCapaciteMap.containsKey(c)) {
                tfCapaciteMap.put(c, new JTextField());
                tfCapaciteMap.get(c).setText(c.getValeur());
            }

            contenu21.add(tfCapaciteMap.get(c));
        }
        contenu21.revalidate();
    }

    public void modifierInventaire() { // (boolean ajouter)
        String text = ajouterInventaire.getTexte();
        if (text != null) {
            if (!ajouterInventaire.getTexte().equals("")) {// && ajouter
                modele.getInventaire().ajouter(text);
            }
            /*
             * if (!supprimerInventaire.getTexte().equals("") && !ajouter){
             * modele.supprimerInventaire(supprimerInventaire.getTexte()); text =
             * supprimerInventaire.getTexte(); }
             */
            majInventaire();
        }
    }

    public void majInventaire() {
        contenu22.removeAll();
        contenu22.setLayout(new GridLayout(modele.getInventaire().getMap().size(), 3));
        for (Map.Entry<String, Integer> e : modele.getInventaire().getMap().entrySet()) {
            String valeur = (e.getValue()).toString();
            contenu22.add(new JLabel(valeur + "x " + e.getKey()));
            JButton boutonPlus = new JButton(" + ");
            JButton boutonMoins = new JButton(" - ");
            boutonPlus.addActionListener(k -> modifierInventaireEx(true, e.getKey()));
            boutonMoins.addActionListener(k -> modifierInventaireEx(false, e.getKey()));
            contenu22.add(boutonPlus);
            contenu22.add(boutonMoins);
        }
        contenu22.revalidate();
    }

    public void setOnSaveAction(ActionListener actionListener) {
        boutonSauvegarder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.setNom(nomTexte.getText());
                modele.setRole(roleTexte.getText());
                modele.setVie(vieValeur.getValue());
                for(Capacite c : tfCapaciteMap.keySet()) {
                    c.setValeur(tfCapaciteMap.get(c).getText());
                }
                actionListener.actionPerformed(e);
            }
        });
    }

    public void modifierInventaireEx(boolean ajouter, String texte) {
        if (!texte.equals("") && ajouter) {
            modele.getInventaire().ajouter(texte);
        }
        if (!texte.equals("") && !ajouter) {
            modele.getInventaire().supprimer(texte);
        }
        contenu22.removeAll();
        contenu22.setLayout(new GridLayout(modele.getInventaire().getMap().size(), 3));
        for (Map.Entry<String, Integer> e : modele.getInventaire().getMap().entrySet()) {
            if (e.getValue() > 0) {
                String valeur = (e.getValue()).toString();
                contenu22.add(new JLabel(valeur + "x " + e.getKey()));
                JButton boutonPlus = new JButton(" + ");
                JButton boutonMoins = new JButton(" - ");
                boutonPlus.addActionListener(k -> modifierInventaireEx(true, e.getKey()));
                boutonMoins.addActionListener(k -> modifierInventaireEx(false, e.getKey()));
                contenu22.add(boutonPlus);
                contenu22.add(boutonMoins);
            }
        }
        contenu22.revalidate();
    }
}
