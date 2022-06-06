package Jeu.Vues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TexteActionVue extends Container {

    private JTextField tfInput;
    private JButton btnOk;

    public TexteActionVue(String titre, ActionListener action) {
        configurerVues(titre, action);
    }

    private void configurerVues(String titre, ActionListener actionListener) {
        tfInput = new JTextField();
        btnOk = new JButton("OK");
        btnOk.addActionListener(actionListener);
        tfInput.addActionListener(actionListener);

        setLayout(new GridLayout(1, 2));
        add(new JLabel(titre));
        Container innerCtr = new Container();
        innerCtr.setLayout(new BoxLayout(innerCtr, BoxLayout.LINE_AXIS));
        innerCtr.add(tfInput);
        innerCtr.add(btnOk);
        add(innerCtr);
    }

    public String getTexte() {
        return tfInput.getText();
    }
}
