<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Annuaire d'un Centre Hospitalier</title>
<style type="text/css">
	body {
		font-size:medium;
		font-family:calibri;
		color:noir;
		text-align:left;
	}
	
	.menu {
		background-color:black;
		color:white;
		font-weight:bold;
		font-style:italic;
	}
	
	.fond {
		min-width:500;
	}
	
	a:link,a:visited {
		display:block;
		text-decoration:none;
		color:white;
	}
	
	a:hover,a:active {
		color:#6699CC;
	}
</style>

<script language="JavaScript">
	function goForward()
	{
		history.forward();
	}
	
	function goBack()
	{
		history.back();
	}
	
	
	function afficher () {
		var heure = new Date().getHours();  
		// gestion du singulier-pluriel
		// concaténation de "heures" si 'lheure courante est supérieure à 1
		// sinon concaténation de "heure"
		if (heure>1) { heure = heure+" heures "; }
		else { heure = heure +" heure "; }
		// concaténation des minutes dans la variable "heure"
		heure = heure +new Date().getMinutes();
		// maintenant les secondes !
		heure = heure+" et "+new Date().getSeconds()+" secondes";
		// affichage de l'heure dans le formulaire
		document.horloge.ici.value=heure;
		setTimeout("afficher()",1000);
	}
			
</script>
		
<?php
function AfficheDate()
	{
		$jour = array("Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"); 
		$mois = array("","Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"); 
		$datefr = $jour[date("w")]." ".date("d")." ".$mois[date("n")]." ".date("Y"); 
		echo "Bienvenue, nous sommes le ".$datefr ;
	}
?>
</head>
	
<body bgcolor="#6699CC" OnLoad="afficher()">

<table class="fond" width="75%" height="100%" align="center" bgcolor="#FFFFFF"><tr><td>

<table class="menu" width="100%" align="center"><tr>
	<td align="left" width="100">
		<input type="button" value="Préc" id="precedent" onClick="goBack()" />
		<input type="button" value="Suiv" id="suivant" onClick="goForward()" /></td>
	<td align="center"><a href="laccueil.html" target="Display">Accueil</a></td>
	<td align="center"><a href="FormPerso.php" target="Display">Recherche</a></td>
	<td align="center">Gestion</td>
	<td align="center"><?php AfficheDate(); ?></td>
	<td align="center"><a href="index.html">Deconnexion</a></td>
</tr></table>

</td></tr>
<tr><td><iframe width="100%" height="700" name="Display" src="laccueil.html" frameborder="0"></iframe>
</td></tr></table>
</body>
</html>