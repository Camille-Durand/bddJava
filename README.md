# bddJava
CDA: exercices BDD en Java

## Méthodes disponibles
### Database.java
- getConnexion(): permet la connexion à la BDD

### ManagerUtilisateur.java:
- create(): permet de créer un utilisateur et de l'envoyer dans la BDD
- update(): permet de modifier le nom et le prénom d'un utilisateur
- delete(): permet de supprimer **définitivement** un utilisateur
- findByMail(): permet de trouver un utilisateur grâce à son adresse mail *(couplée à la méthode "create()" elle permet de vérifier si un compte existe déjà pour éviter la création de doublons)*
- findAll(): permet d'afficher la liste de tous les utilisateurs

### Utilisateur.java
- toString(): permet de renvoyer le nom et le prénom de l'utilisateur dans une chaîne de caractères

### UserForm.java
- createUSer(): permet grâce à un formulaire de créé un utilisateur si tous les champs sont remplis
- cancelUser(): permet d'annuler la création d'un utilisateur, fermant le formulaire au passage
