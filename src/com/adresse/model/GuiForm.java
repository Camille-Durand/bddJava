package com.adresse.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class GuiForm extends JDialog{

    private JFrame jfMain;
    private JPanel container;
    private JLabel jlInfo;
    private JButton btnModify;
    private JButton btnDelete;

    public GuiForm(){
        JFrame guy = new JFrame();
        guy.setTitle("Liste des utilisateurs");
        guy.setMaximumSize(new Dimension(800,600));
        guy.setMinimumSize(new Dimension(800,600));
        try {
            for(int i = 0; i < ManagerUtilisateur.findAll().size(); i++){
                jlInfo.setText(ManagerUtilisateur.findAll().get(i).getName() + " " + ManagerUtilisateur.findAll().get(i).getFirstname());

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        pack();
        setVisible(true);


        btnModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ManagerUtilisateur.update(user);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ManagerUtilisateur.delete(user);
            }
        });
    }
}
