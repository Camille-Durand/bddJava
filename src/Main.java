import com.adresse.model.Utilisateur;
import com.adresse.model.ManagerUtilisateur;

import java.sql.SQLException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws SQLException {
        Utilisateur user = new Utilisateur("newtest", "newtest", "test@new.com", "1234");

        /*

        //test si le compte exist
        if(Objects.equals(user.getEmail(), ManagerUtilisateur.findByMail(user).getEmail())){
            System.out.println("Le compte existe déja");
        }
        else{
            //ajouter le compte en BDD
            System.out.println(ManagerUtilisateur.create(user));
        }

         */

        ManagerUtilisateur.update(user);
    }
}