package com.adresse.model;

import com.adresse.model.Utilisateur;
import com.adresse.model.ManagerUtilisateur;
import org.springframework.security.crypto.bcrypt.BCrypt;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Locale;

public class UserForm extends JDialog{
    private JLabel jlName; // ok
    private JTextField tfName; // ok
    private JLabel jlFirstname; // ok
    private JTextField tfFirstname; // ok
    private JLabel jlEmail; // ok
    private JTextField tfEmail; // ok
    private JLabel jlPassword; // ok
    private JPasswordField pfPassword; // ok
    private JButton btValid; // ok
    private JButton btCancel; // ok
    private JPanel jpMain; // ok
    private JLabel jlVerify; // ok
    private JPasswordField pfVerify; // ok

    public UserForm(JDialog parent){
        super(parent);
        setTitle("Ajouter un compte utilisateur");
        setContentPane(jpMain);
        setMaximumSize(new Dimension(800,600));
        setMinimumSize(new Dimension(800,600));
        setVisible(true);        //écouteur événement bt valider
        btValid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createUser();
            }
        });
        btCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelUser();
            }
        });
    }

    public void createUser() {
        String name = tfName.getText();
        String firstname = tfFirstname.getText();
        String email = tfEmail.getText();
        String password = String.valueOf(pfPassword.getPassword());
        String verify = String.valueOf(pfVerify.getPassword());

        if(!name.isEmpty() && !firstname.isEmpty() && !email.isEmpty() && !password.isEmpty()){
            if(password.equals(verify)){
                password = BCrypt.hashpw(password, BCrypt.gensalt());
                Utilisateur user = new Utilisateur(name,firstname,email,password);

                System.out.println(user);
                try {
                    ManagerUtilisateur.create(user);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                JOptionPane.showMessageDialog(null,
                        "Compte utilisateur créé avec succès et envoyé dans la BDD :)",
                        "Compte créé",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Les 2 mots de passe ne correspondent pas",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Veuillez remplir tous les champs",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cancelUser(){
        tfName.setText("");
        tfFirstname.setText("");
        tfEmail.setText("");
        pfPassword.setText("");
        pfVerify.setText("");
        dispose();
        JOptionPane.showMessageDialog(null,
                "Création de compte utilisateur annulée",
                "Création de compte annulée",
                JOptionPane.INFORMATION_MESSAGE);
    }
}