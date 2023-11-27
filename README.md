# epharmaSphere
## Table de matière 
- [Structure du Code](#structure-du-code)
- [Description du Projet](#description-du-projet)
## Structure du code

## Description du projet

### Introduction

Cette page web constitue notre projet pour la matière JEE. Malgré toutes les difficultés rencontrées, nous avons réussi à créer un site web fonctionnel à partir de zéro. Nous avons entamé notre parcours en commençant par la partie frontend. Ensuite, après avoir coordonné nos travaux, nous sommes passés à la partie backend en utilisant Spring Boot, ce qui a nécessité un travail plus conséquent, marqué par des échecs répétés, une multitude de problèmes et d'épreuves. Cependant, grâce aux efforts constants de tous les membres du groupe, nous avons finalement pu mener à bien notre projet dans les délais impartis.

Notre objectif est de servir d'intermédiaire entre le patient et le pharmacien. Ce dernier pourra recevoir l'ordonnance de son patient et l'envoyer via un service de livraison. De plus, il pourra également communiquer avec son patient à l'aide d'une messagerie intégrée.

### Index

En complément, l'architecture de notre site débute par une page d'accueil, nommée "index", conçue avec un design moderne. Cette page offre une expérience utilisateur intuitive, mettant en avant deux boutons distincts, l'un dédié aux patients et l'autre aux pharmaciens. En cliquant sur l'un de ces deux boutons, l'utilisateur est dirigé vers la section correspondante en fonction de son identité.

Cette approche de conception vise à offrir dès le départ une navigation claire et une expérience utilisateur optimale. L'esthétique moderne de la page d'accueil contribue à créer une première impression positive, tandis que la distinction entre les boutons patient et pharmacie simplifie le parcours de l'utilisateur en le dirigeant vers la partie du site la plus pertinente pour ses besoins.

![Image](/images/index.html.png)

### Login

Après s'être authentifié, l'utilisateur sera dirigé vers l'une des deux pages en fonction de son type d'utilisateur. En cas de patient, il sera automatiquement redirigé vers la page d'accueil "homepagepatient". Cette page offre la possibilité de sélectionner une pharmacie à partir de notre base de données et de lui envoyer un message. De plus, le patient peut ajouter un fichier, tel qu'une ordonnance. Le message sera alors envoyé au pharmacien, qui pourra l'examiner dans son tableau de bord.

Cette approche vise à simplifier l'expérience utilisateur tout en facilitant la communication entre le patient et le pharmacien. En offrant un moyen convivial de sélectionner une pharmacie et d'envoyer des informations cruciales telles qu'une ordonnance, notre plateforme vise à rendre le processus aussi efficace et transparent que possible pour toutes les parties concernées.

![Image](/images/signinpatient.png) 

### Sign up

L'utilisateur sera redirigé vers une page d'inscription où il sera invité à remplir quelques données et créer un mot de passe. D'autre part, s'il s'agit d'une pharmacie, il sera invité à fournir quelques données supplémentaires telles que son adresse et le nom de la pharmacie. Ces informations seront ensuite stockées dans la base de données pour garantir sa prochaine connexion. De plus, en haut de la page, un bouton permettra de rediriger directement le client vers la page de connexion s'il a déjà créé un compte.

![Image](images/signuppatient.png) 

### Homepage patient


Après s'être authentifié, l'utilisateur sera dirigé vers l'une des deux pages en fonction de son type d'utilisateur. Dans le cas d'un patient, il sera automatiquement redirigé vers la page d'accueil "homepagepatient". Cette page offre la possibilité de sélectionner une pharmacie à partir de notre base de données et de lui envoyer un message, tout en ajoutant un fichier tel qu'une ordonnance. Le message sera alors transmis au pharmacien, qui pourra le consulter dans son tableau de bord.

Cette approche vise à personnaliser l'expérience de l'utilisateur en fonction de son rôle, facilitant ainsi le processus d'interaction entre le patient et le pharmacien. La fonctionnalité d'envoi de messages et de fichiers, telle qu'une ordonnance, vise à rendre la communication fluide et efficace au sein de notre plateforme.

![image](/images/homepagepatient.png)

### Dashboard patient

De plus, sur la page "homepagepatient", il y aura un bouton permettant de rediriger le patient vers sa page de tableau de bord. Cette dernière comporte la section "profil", offrant la possibilité au patient de modifier les informations de son profil en cas d'erreur ou pour toute autre raison. En outre, cette page inclut la section "messages", regroupant tous les messages reçus de la part des pharmacies.

Cette fonctionnalité vise à fournir au patient un accès direct à son tableau de bord, où il peut gérer son profil et interagir efficacement avec les messages provenant des pharmacies. En centralisant ces fonctionnalités sur une seule page, nous cherchons à simplifier et à améliorer l'expérience globale de l'utilisateur.

![Image](images/dashboardpatient.png)

### Dashboard pharmacy


D'autre part, après l'authentification, si l'utilisateur est un pharmacien, il sera directement redirigé vers la page "pharmadashboard", qui est le tableau de bord du pharmacien. Cette page comporte la section "profil", contenant les informations remplies par l'utilisateur et pouvant être modifiées à l'aide du bouton "edit". De plus, la page inclut également la section "messages", où le pharmacien peut envoyer des messages aux patients et répondre à leurs messages.

Cette fonctionnalité vise à fournir au pharmacien un accès rapide à son tableau de bord, où il peut gérer son profil, communiquer avec les patients via des messages et répondre efficacement à leurs demandes. En centralisant ces fonctionnalités sur une seule page, nous cherchons à simplifier et à optimiser l'expérience globale du pharmacien au sein de notre plateforme.

![image](images/pharmacydashboard.png)

### Conclusion

En conclusion, notre projet JEE représente l'aboutissement de nombreux efforts et défis surmontés par notre équipe. De la conception initiale à la mise en œuvre, nous avons créé une plateforme fonctionnelle visant à faciliter la communication entre patients et pharmaciens.

Du côté du patient, notre page d'accueil "homepagepatient" offre une expérience conviviale, permettant de sélectionner une pharmacie, d'envoyer des messages et même d'ajouter des fichiers tels que des ordonnances. Le tableau de bord du patient offre un accès rapide à la gestion du profil et à la gestion des messages reçus des pharmacies.

Pour les pharmaciens, la page "pharmadashboard" constitue un tableau de bord complet, intégrant la gestion du profil et la messagerie bidirectionnelle avec les patients. Cette approche vise à simplifier et à optimiser les interactions dans le domaine de la santé, en mettant l'accent sur la communication transparente et la gestion efficace des informations.

Malgré les défis rencontrés lors du développement, notre équipe a réussi à créer une plateforme fonctionnelle qui agit comme un lien essentiel entre les professionnels de la santé et les patients. Nous sommes fiers de notre réalisation et sommes convaincus que notre projet contribuera à améliorer l'efficacité et la qualité des soins de santé.

