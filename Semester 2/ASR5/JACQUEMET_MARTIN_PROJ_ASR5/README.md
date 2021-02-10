# Compte rendu ¨C Projet ASR5

## Fonctionalité : 

/!\ NE FONCTIONNE QUE SUR INTERNET EXPLORER ET FIREFOX

### Log (date / info clients) :
On crée un dossier LOG contenant un fichier log.txt si le dossier et le fichier n'existe pas .
On stock la date et l'heure de connexion du client et son adresse ip .

### Formulaire :
Si c'est une requête GET, on envoie l'index.html contenant le formulaire.
Le formulaire renvoie une requête POST qui est traité pour isoler les champs et récupérer les valeurs du formulaire.
Si c'est un page qui existe, on est redirigé dessus sinon on renvoi un 404 not found.

### Commande réseau :
La commande ping fonctionne si le serveur est lancé sous windows, si le serveur est lancé sous linux, il faut rajouté "-c 5" dans la commande du ping .
Le tracert fonctionne de même  si le serveur est lancé sous windows.

### Information du client :
Adresse IP et OS

### Plusieurs pages accessible :
infoServeur.html permet d'executer la commande ipconfig pour avoir les données réseau du serveur (machine local).


Ce qui n'a pas été implémenté :
- Requête pour le  favicon
- Info du client (navigateur web)
- Serveur rôle de proxy.
