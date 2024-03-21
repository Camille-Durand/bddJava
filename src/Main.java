import com.adresse.model.Utilisateur;
import com.adresse.model.ManagerUtilisateur;

import java.sql.SQLException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws SQLException {
        /*
        Utilisateur user = new Utilisateur("Test", "Testing", "Test@ing.com", "1234");

        // Vérification compte existant
        if(Objects.equals(user.getEmail(), ManagerUtilisateur.findByMail(user).getEmail())){
            System.out.println("Le compte existe déja");
        }
        else{
            // Création nouveau compte
            System.out.println(ManagerUtilisateur.create(user));
        }

        // Update compte existant
        ManagerUtilisateur.update(user);

         */

        System.out.println(ManagerUtilisateur.findAll());

    }
}