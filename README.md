# bddJava
CDA: exercices BDD en Java

### Méthodes disponibles:
- create(): permet de créer un utilisateur et de l'envoyer dans la BDD
- update(): permet de modifier le nom et le prénom d'un utilisateur
- delete(): permet de supprimer **définitivement** un utilisateur
- findByMail(): permet de trouver un utilisateur grâce à son adresse mail *(couplée à la méthode "create()" elle permet de vérifier si un compte existe déjà pour éviter la création de doublons)*
- findAll(): permet d'afficher la liste de tous les utilisateurs
