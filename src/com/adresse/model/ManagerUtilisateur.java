package com.adresse.model;

import java.sql.*;
import java.util.Scanner;

public class ManagerUtilisateur {
    private static final Connection connexion = Database.getConnexion();
    public static Utilisateur create(Utilisateur user) throws SQLException {
        Utilisateur userAdd = new Utilisateur();
        try {
            // Connexion BDD
            Statement smt = connexion.createStatement();

            // Prépa requête
            String req = "INSERT INTO users(name,firstname,email,password) VALUE(?,?,?,?)";
            PreparedStatement preparedStatement = connexion.prepareStatement(req);

            //Bind paramètres
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getFirstname());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getPassword());

            //Exe requête
            int row = preparedStatement.executeUpdate();
            if(row > 0){ //Requête == good :)
                userAdd.setName(user.getName());
                userAdd.setFirstname(user.getFirstname());
                userAdd.setEmail(user.getEmail());
                userAdd.setPassword(user.getPassword());
            }

            // Récup enregistrement


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userAdd;
    }

    public static Utilisateur update(Utilisateur user) throws SQLException {
        Utilisateur userUpdate = new Utilisateur();

        try {
            // Connexion BDD
            Statement smt = connexion.createStatement();

            // Prépa requête
            String req = "UPDATE users SET name = ?, firstname = ? WHERE email = ?";
            PreparedStatement preparedStatement = connexion.prepareStatement(req);

            //Bind paramètres
            Scanner scannerName = new Scanner(System.in);
            System.out.print("Nom: ");
            String newName = scannerName.nextLine();
            preparedStatement.setString(1,newName);

            Scanner scannerFirstName = new Scanner(System.in);
            System.out.print("Prénom: ");
            String newFirstName = scannerFirstName.nextLine();
            preparedStatement.setString(2,newFirstName);

            preparedStatement.setString(3,user.getEmail());

            //Exe requête
            int row = preparedStatement.executeUpdate();
            if(row > 0){ //Requête == good good :)
                userUpdate.setName(user.getName());
                userUpdate.setFirstname(user.getFirstname());
                userUpdate.setEmail(user.getEmail());
            }

            System.out.println("Le nom et le prénom de l'utilisateur ont été modifié avec succès :)");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userUpdate;
    }

    public static Utilisateur findByMail(Utilisateur user) throws SQLException {
        Utilisateur userRecup = new Utilisateur();
        try {
            Statement smt = connexion.createStatement();

            String req = "SELECT id, name, firstname, email, password FROM users WHERE email = ?";

            PreparedStatement preparedStatement = connexion.prepareStatement(req);

            preparedStatement.setString(1,user.getEmail());

            ResultSet response = preparedStatement.executeQuery();

            while(response.next()){
                userRecup.setId(response.getInt(1));
                userRecup.setName(response.getString("name"));
                userRecup.setFirstname(response.getString("firstname"));
                userRecup.setEmail(response.getString("email"));
                userRecup.setPassword(response.getString("password"));
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return userRecup;
    }
}
