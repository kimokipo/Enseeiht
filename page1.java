import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class page1 extends JFrame {

    private JPanel contentPane;
    private JPasswordField passwordField;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    page1 frame = new page1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public page1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 938, 683);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 369, 305, 45);
        contentPane.add(passwordField);
        
        textField = new JTextField();
        textField.setBounds(100, 274, 305, 45);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("SUBMIT");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(278, 475, 127, 22);
        contentPane.add(btnNewButton);
        
        JTextArea txtrPass = new JTextArea();
        txtrPass.setBackground(SystemColor.control);
        txtrPass.setText("Pass");
        txtrPass.setBounds(100, 341, 127, 22);
        contentPane.add(txtrPass);
        
        JTextArea txtrLogin = new JTextArea();
        txtrLogin.setBackground(SystemColor.control);
        txtrLogin.setText("Login");
        txtrLogin.setBounds(100, 241, 105, 22);
        contentPane.add(txtrLogin);
        
        JLabel lblNewLabel = new JLabel("Connexion");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        lblNewLabel.setBounds(100, 173, 148, 74);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("TeamManager");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(282, 226, 105, 37);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("PAGE DE CONNEXION");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 32));
        lblNewLabel_2.setBounds(526, 136, 368, 45);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("IMAGE");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 50));
        lblNewLabel_3.setBounds(536, 192, 368, 248);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("TEAM EXPERIENCE LALACHANTE");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_4.setBounds(587, 430, 286, 55);
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("TeamManager");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_5.setBounds(95, 75, 110, 31);
        contentPane.add(lblNewLabel_5);
    }
}