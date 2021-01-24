# Projet obligatoire

## Description 
Nous nous proposons de réaliser un annuaire en ligne qui pourra être consulté par le personnel d’un centre hospitalier via un navigateur Internet. L'accès à ce site sera protégé par un système de login/password connu par le personnel. Par ailleurs, un module d'administration, également protégé par un système de login/password connu par l'administrateur/webmaster de l'annuaire, permettra d'ajouter, de modifier ou de supprimer les informations contenues dans la base de données de
l'annuaire.

## Fonctionnalités
Les possibilités de recherche porteront sur les champs suivants de la base de données :
- les noms ou les premières lettres des noms,
- les services,
- les unités,
- les pôles,
- la localisation par bâtiment et de son étage.
Il faudra prévoir que le personnel inscrit dans l’annuaire puisse appartenir à plusieurs services, salles, unités ou bâtiments.

Les fichiers excel contenant les données sont joints dans le dossier du projet.

Du point de vue de la personne ou de l'administrateur consultant l'annuaire, la recherche se fait à l'aide de menus déroulants.

Une liste correspondante au personnel est alors affichée, en cliquant sur une ligne de la liste nous accéderons à la fiche de la personne. Cette liste est affichée par ordre alphabétique. Comme nous pouvons le voir sur la figure ci-jointe, une table regroupe de gauche à droite, la première lettre du nom de la personne, la civilité, le prénom, le nom, l’unité et la fonction. L’administrateur dispose en
outre de boutons, « modifier », « supprimer » ou « ajouter ».

Dès qu'un champ est modifié une recherche adaptée est lancée dans l'annuaire pour la mise à jour de
la liste du personnel.

L'administrateur du site est chargé de la mise a jour de la base de données via le module
d'administration; il peut donc ajouter, modifier ou supprimer des enregistrements.

Dans le cadre de ce projet les tables principales portent les noms :
- administrateur,
- personnel,
- fonction,
- unite,
- pole,
- batiment.

La table « personnel » doit contenir les champs suivants :
- un identifiant unique,
- la civilité le nom et le prénom,
- les numéros de téléphone fixe et portable,
- le numéro de fax,
- l’émail,
- l’URL d’un blog éventuel,
- la photo.
Les tables annexes à la table « personnel » permettent de gérer l’attribution de plusieurs fonctions,
unites, pôles et bâtiments, elles portent les noms :
- personnel_fonction,
- personnel_unite,
- personnel_pole,
- personnel_batiment.

Les tables « fonction », « unite », « pole » et « batiment » sont constituées par les champs :
- code : codé en majuscule et unique,
- définition : représentant la définition du champ code.