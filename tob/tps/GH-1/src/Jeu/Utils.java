package Jeu;

import Jeu.Modeles.ModeleFichePersonnage;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class Utils {

    public static final int DIMENSION_IMAGE = 128;
    public static final int DIMENSION_ICON = 32;
    public static final ImageIcon DEFAULT_ICON = Utils.loadImage(new File("ressources/dauphin-bebou.jpg"));

    private static final String RESOURCES_PATH = new File(System.getProperty("java.io.tmpdir") , "Jeu-De-Role").getPath();
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

    public static void sauvegarderJeu(JFrame parent, List<ModeleFichePersonnage> modeles) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Choisir l'emplacement de sauvegarde");
        FileNameExtensionFilter filter =
                new FileNameExtensionFilter("Fichier jeu", "jeu");
        chooser.setFileFilter(filter);

        if (chooser.showSaveDialog(parent) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File dest = chooser.getSelectedFile();

        try {
            deleteDir(RESOURCES_DIR);
            RESOURCES_DIR.mkdirs();
            for(int i = 0; i < modeles.size(); i++) {
                sauvegarderFiche(modeles.get(i), i+1);
            }

            pack(RESOURCES_PATH, dest.getPath());
            JOptionPane.showMessageDialog(null, "Jeu sauvegardé avec succès");
        } catch (IOException e) {
            setClipboard(e.toString());
            JOptionPane.showMessageDialog(null, "Une erreur est survenue lors de la sauvegarde du Jeu.\n" +
                    "Le message d'erreur est copié en presse-papiers.");
        }

    }

    private static void sauvegarderFiche(ModeleFichePersonnage modele, int id) throws IOException {
        FileOutputStream myFileOutStream
                = new FileOutputStream(new File(RESOURCES_PATH, id+".fiche"));

        ObjectOutputStream myObjectOutStream
                = new ObjectOutputStream(myFileOutStream);

        myObjectOutStream.writeObject(modele);

        // closing FileOutputStream and
        // ObjectOutputStream
        myObjectOutStream.close();
        myFileOutStream.close();

        File imgDir = new File(RESOURCES_PATH, "img");
        imgDir.mkdirs();

        ImageIO.write(toBufferedImage(modele.getImage().getImage()), "jpg",
                new File(imgDir, id+".jpg"));
    }

    private static BufferedImage toBufferedImage(Image img){
        int width = img.getWidth(null);
        int height = img.getHeight(null);
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        g.drawImage(img, 0,0, null);
        g.dispose();
        return bi;
    }

    private static void pack(String sourceDirPath, String zipFilePath) throws IOException {
        File dest = new File(zipFilePath);
        if(dest.exists() && dest.isFile()) {
            dest.delete();
        }
        Path p = Files.createFile(dest.toPath());
        try (ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(p))) {
            Path pp = Paths.get(sourceDirPath);
            Files.walk(pp)
                    .filter(path -> !Files.isDirectory(path))
                    .forEach(path -> {
                        ZipEntry zipEntry = new ZipEntry(pp.relativize(path).toString());
                        try {
                            zs.putNextEntry(zipEntry);
                            Files.copy(path, zs);
                            zs.closeEntry();
                        } catch (IOException e) {
                            System.err.println(e);
                        }
                    });
        }
    }

    private static void setClipboard(String s) {
        StringSelection selection = new StringSelection(s);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

    private static void deleteDir(File file) {
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                if (! Files.isSymbolicLink(f.toPath())) {
                    deleteDir(f);
                }
            }
        }
        file.delete();
    }
    //endregion

    //region Chargement du jeu

    public static List<ModeleFichePersonnage> chargerJeu(JFrame parent) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter =
                new FileNameExtensionFilter("Fichiers jeu", "jeu");
        chooser.setFileFilter(filter);
        if (chooser.showOpenDialog(parent) != JFileChooser.APPROVE_OPTION) {
            return null;
        }

        File src = chooser.getSelectedFile();
        try {
            List<ModeleFichePersonnage> modeleList = new ArrayList<>();

            deleteDir(RESOURCES_DIR);
            unzip(src.getPath(), RESOURCES_PATH);

            File[] dirList = RESOURCES_DIR.listFiles(File::isFile);
            if(dirList == null) {
                return modeleList;
            }
            for(int i = 1; i <= dirList.length; i++) {
                modeleList.add(chargerModele(i));
            }

            return modeleList;
        } catch (IOException e) {
            setClipboard(e.toString());
            JOptionPane.showMessageDialog(null, "Une erreur est survenue lors de l'ouverture du Jeu.\n" +
                    "Le message d'erreur est copié en presse-papiers.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ModeleFichePersonnage chargerModele(int id) throws IOException, ClassNotFoundException {
        ModeleFichePersonnage f;

        FileInputStream fileInput = new FileInputStream(new File(RESOURCES_PATH, id+".fiche"));

        ObjectInputStream objectInput
                = new ObjectInputStream(fileInput);

        f = (ModeleFichePersonnage)objectInput.readObject();

        objectInput.close();
        fileInput.close();

        File imgDir = new File(RESOURCES_PATH, "img");
        BufferedImage b = ImageIO.read(new File(imgDir, id+".jpg"));
        f.setImage(new ImageIcon(b));

        return f;
    }

    private static void unzip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipIn.getNextEntry();
        // iterates over entries in the zip file
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                // if the entry is a file, extracts it
                extractFile(zipIn, filePath);
            } else {
                // if the entry is a directory, make the directory
                File dir = new File(filePath);
                dir.mkdirs();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
    }

    private static final int BUFFER_SIZE = 4096;
    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        File file = new File(filePath);
        file.getParentFile().mkdirs();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }

    //endregion
}