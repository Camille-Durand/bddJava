package com.adresse.model;

import javax.swing.*;
import java.awt.*;

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

    public UserForm(JDialog parent){
        super(parent);
        setTitle("Ajouter un compte utilisateur");
        setContentPane(jpMain);
        setMaximumSize(new Dimension(800,600));
        setMinimumSize(new Dimension(800,600));
        setVisible(true);
    }
}