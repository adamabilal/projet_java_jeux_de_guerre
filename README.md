# l2s4-projet-2021

Vous devez *forker* ce projet dans votre espace de travail Gitlab (bouton `Fork`) et vidéo sur le [portail](https://www.fil.univ-lille1.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)

Une fois cela réalisé supprimer ces premières lignes et remplissez les noms des membres de votre équipe.

# Equipe

- Aissatou Ibrahima DIALLO
- Adama TRAORE
- Pascal Sébastien AGBA

# Sujet

[Le sujet 2021](https://www.fil.univ-lille1.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)

# Livrables

## Livrable 1
![alt text](/livrable1.png)

### Atteinte des objectifs
On a modélisé les personnages:
- une classe abstraite Personnage qui regroupe les attributs et méthodes communes aux classes Ouvrier et Armée

- la classe Ouvrier qui hérite des attributs et méthodes de Peronnage et qui contient des méthodes unique à un Ouvrier
- la classe Armee qui hérite des attributs et méthodes de Peronnage et qui contient des méthodes unique à une Armée
- un enum Ressource qui enumère toutes les ressources(sable,blé,bois,roche)


### Difficultés restant à résoudre
- comment modéliser Armée énnemie et Armée alliée(resolue)
- la méthode gainOr à revoir (résolue)
- les ressources à revoir ou à compléter (résolue pas necessaire pour les personnages)
- on sait pas trop comment gérer la méthode Attaquer(armee)

## Livrable 2
![alt text](/livrable2.png)

### Atteinte des objectifs
- modélisation de plateau
- modélisation de tuile
- un enum Nature qui enumère la nature des tuile (fôret,montagne,plaine,désert,océan)
- la classe Tuile qui regroupe l'ensemble des méthodes et attributs d'une tuile qui va constituer le plateau
### Difficultés restant à résoudre

## Livrable 3
![alt text](/livrable3.png)

### Atteinte des objectifs
Modélisation des actions
### Difficultés restant à résoudre

## Livrable 4
![alt text](/uml.png)

### Atteinte des objectifs

- Modélisation des Joueurs
- Création de la classe Jeu  qui régroupe l'ensemble des méthodes communes aux deux jeux
- Création de la classe Guerre qui correspond aux jeu de guerre
- Création du jar exécutable
- Création du Makefile
- Création du répertoire test

### Difficultés restant à résoudre
Nourrir les armées
# Journal de bord

## Semaine 1
On a eu du mal à comprendre comment modéliser les personnages

## Semaine 2
On a pu modéliser les personnages 
## Semaine 3
Implémentation du code des fonctions de personnage
On a créé toutes les fonctions qui sont dans le diagramme uml
- la méthode gainOr à revoir 
- les ressources à revoir ou à compléter
- on sait pas trop comment gérer la méthode Attaquer(armee)

## Semaine 4
- rajouter une méthode convertir dans Ouvrier pour convertir la production de ouvrier en quantité d'or
- modélisation du plateau
## Semaine 5
- comment avoir un paramètre facultatif?
## Semaine 6
On pense qu'un personnage n'a pas forcement besoin de ressources.
## Semaine 7
comment placer tuile adjacente dans tuile alors tuile adjacente concerne les plateaux?
methode rencontrer armée?

## Semaine 8
Implémentation du code de plateau
On a eu du mal avec la méthode initialisation du plateau.

## Semaine 9
on a combiné la méthode produire et récolter parce qu'on peut ajouter la ressource produite directement dans la liste des ressources du joueur

## Semaine 10
Implémentation de Joueur on l'a mis en abstract.
On créé une classe JoueurArmee qui hérite de Joueur
 - pour que Joueur puisse être réutilisé pour d'autres jeux qui n'ont pas forcement besoin de tout ce qui se trouve dans JoueurArmee.
## Semaine 11
Modélisation de Jeu 
- Dans Jeu on a mit toute les méthodes qui peuvent être éventuellement commune à tous les jeux similaires
- On a créé une classe Guerre qui correspond au Jeu de guerre.
- On a du mal avec le déroulement de jeu.
## Semaine 12
- Génération des commentaires de toutes les méthodes non commentées
- Mise à jour des livrables
## execution du projet 
- Pour la création des  classes: dans un terminal se placer sur le dossier l2s4-projet-2021  et taper la commande
	# make cls
-Pour créer la documentation dans un terminal se placer à la racine du projet l2s4-projet-2021 et taper la commande
	# make doc
## Pour exécuter le jeu de guerre dans un terminal 
	- se placer sur le dossier l2s4-projet-2021/cls et taper la commande
		jar cvmf ../manifest-ex ../jar/guerre.jar jeu/*.class personnage/*.class joueur/*.class plateau/*.class action/*.class plateau/tuile/util/*.class personnage/util/*.class plateau/tuile/*.class io/*.class
	- puis taper cd ../
		make guerre

