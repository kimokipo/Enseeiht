package Jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public final class Utils {

    public static final int DIMENSION_IMAGE = 128;
    public static final int DIMENSION_ICON = 32;
    public static final ImageIcon DEFAULT_ICON = Utils.loadImage(new File("ressources/dauphin-bebou.jpg"));

    private static final String RESOURCES_PATH = System.getProperty("java.io.tmpdir")
            + "Jeu-De-Role";
    private static final File RESOURCES_DIR = new File(RESOURCES_PATH);

    private Utils() {
    }

    //region Sauvegarde de carte

    /** Sauvegarder une carte du jeu sous forme d'image jpg.
     * @param parent    La fenêtre principale du programme.
     * @param panel     La fenêtre de la carte dont on veut sauvegarder.
     * @return true si la sauvegarde s'est terminée correctement.
     */
    public static Boolean sauvegarderCarte(JFrame parent, Container panel) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Choisir l'emplacement de sauvegarde");
        FileNameExtensionFilter filter =
                new FileNameExtensionFilter("Image (jpg seulement)", "jpg");
        chooser.setFileFilter(filter);

        if (chooser.showSaveDialog(parent) != JFileChooser.APPROVE_OPTION) {
            return false;
        }

        File dest = chooser.getSelectedFile();
        BufferedImage panelImg = convertirPanel(panel);
        try {
            ImageIO.write(panelImg, "jpg", dest);
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    private static BufferedImage convertirPanel(Container panel) {
        BufferedImage img = new BufferedImage(
                panel.getWidth(),
                panel.getHeight(),
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();
        panel.paint(g);
        g.dispose();
        return img;
    }
    //endregion

    //region Telechargement d'image

    /** Affiche une fenêtre pour sélectionner une image et la
     * transforme en ImageIcon.
     * @param parent    La fenêtre principale du programme.
     * @return  l'ImageIcon du choix de l'utilisateur,
     * ou null si une erreur s'est produite.
     */
    public static ImageIcon telechargerImage(JFrame parent) {
        File file = chooseFile(parent);
        if (file == null) {
            return null;
        }

        return loadImage(file);
    }

    private static File chooseFile(JFrame parent) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter =
                new FileNameExtensionFilter("Images", "png", "jpg", "jpeg", "gif");
        chooser.setFileFilter(filter);
        if (chooser.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }

        return null;
    }

    public static ImageIcon loadImage(File file) {
        Image image = new ImageIcon(file.getAbsolutePath()).getImage();
        Image resImage = image.getScaledInstance(DIMENSION_IMAGE, DIMENSION_IMAGE, Image.SCALE_SMOOTH);
        return new ImageIcon(resImage);
    }

    public static ImageIcon resizeImageIcon(ImageIcon image, int width, int height) {
        Image resImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resImage);
    }
    //endregion

    //region Sauvegarde du jeu
    private static Boolean saveImage(File file, int id) {
        RESOURCES_DIR.mkdirs();

        String nom = id + ".img";
        Path dest = RESOURCES_DIR.toPath().resolve(nom);
        try {
            Files.copy(file.toPath(), dest, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    private static ImageIcon loadImage(int id) {
        String nom = id + ".img";
        Path src = Paths.get(RESOURCES_PATH).resolve(nom);
        return loadImage(src.toFile());
    }
    //endregion
}