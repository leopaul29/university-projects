<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<script type="text/javascript" src="./jc.js"></script>
</head>
<body>

	<?php
		
		//initialisation de $nom
		if (isset($_POST["nom"]))
			$Nom = $_POST["nom"];
		else
			$Nom ="";
		
		//initialisation de $Fonction
		if (isset($_POST["fonction"]))
			$Fonction = $_POST["fonction"];
		else
			$Fonction ="";
		
		//initialisation de $Pole
		if (isset($_POST["pole"])) 
			$Pole =  $_POST["pole"];
		else
			$Pole = "";
	
		//initialisation de $Unite
		if (isset($_POST["unite"])) 
			$Unite =  $_POST["unite"];
		else
			$Unite = "";
			
		//initialisation de $Batiment
		if (isset($_POST["batiment"])) 
			$Batiment =  $_POST["batiment"];
		else
			$Batiment = "";
	
				//	On se connecte a la base de donne 
		try
		{
			$connect = mysql_connect('localhost','ls200202','ls200202');
				if (!$connect) {
				die('Connexion impossible: ' . mysql_error());
				}
			mysql_select_db('leopaul',$connect);
		}
		catch(Exception $e)
		{
			echo $e."</br>"."Impossible de se connecter à la base de donnée";
		}
		
		
			mysql_select_db('leopaul',$connect);
			
																		//Fonction Rechercher
		function Rechercher (){
		
				$Resultat ="";
				$WHERE ="";
				
				global $Nom, $Fonction, $Pole, $Unite ,$Batiment;
				
					
				if ($Nom != "")
					$WHERE .=" WHERE `Nom`=\"".$Nom."\" ";
				
				if ($Fonction != "" )
				{	
					if($WHERE == "")
						$WHERE .=" WHERE fonction.nomFonction =\"".$Fonction."\" ";
					else
						$WHERE .=" AND fonction.nomFonction =\"".$Fonction."\" ";
				}
				
				if ($Pole != "" )
				{	
					if($WHERE == "")
						$WHERE .=" WHERE pole.nomPole =\"".$Pole."\" ";
					else
						$WHERE .=" AND pole.nomPole =\"".$Pole."\" ";
				}
				
				if ($Unite != "" )
				{	
					if($WHERE == "")
						$WHERE .=" WHERE unite.nomUnite =\"".$Unite."\" ";
					else
						$WHERE .=" AND unite.nomUnite =\"".$Unite."\" ";
				}
				
				if ($Batiment != "" )
				{	
					if($WHERE == "")
						$WHERE .=" WHERE batiment.nomBatiment =\"".$Batiment."\" ";
					else
						$WHERE .=" AND batiment.nomBatiment =\"".$Batiment."\" ";
				}
				
				
				$sql = mysql_query ("SELECT DISTINCT personnel.Nom,personnel.civilite, personnel.Prenom, unite.nomUnite , fonction.nomFonction
									FROM  (((personnel INNER JOIN unite ON (personnel.codeUnite = unite.code)) 
									INNER JOIN fonction ON (personnel.codeFonction = fonction.code)) 
									INNER JOIN pole ON (personnel.codePole = pole.code)) 
									INNER JOIN batiment ON (personnel.codeBatiment = batiment.code)"
									.$WHERE
									."ORDER BY personnel.Nom, personnel.Prenom ;") or die(mysql_error()) ;
									
				
				while ( $row = mysql_fetch_array($sql))
				{
					$Resultat .= "<input type=\"button\" value=\"Afficher\" onClick = \"fenetrePersonne (\'".RecherchePersonne($row['civilite'],$row['Nom'], $row['Prenom'])."\')\" />	".$row['Nom']{0}.'*';
					$Resultat .= $row['civilite'].'*';
					$Resultat .= $row["Prenom"].'*';
					$Resultat .= $row['Nom'].'*';
					$Resultat .= $row["nomUnite"].'*';
					$Resultat .= $row["nomFonction"].'*';
					$Resultat .= "+";
					
				}
				
				return $Resultat;
		}
		
		function RecherchePersonne ($personneCivilite, $personneNom, $personnePrenom)
		{
				$phoneFixe = "";
				$phonePort = "";
				$fax = "";
				$email = "";
				$blog = "";
				$batiment = "";
				$fonction = "";
				$pole = "";
				$unite = "";
				
				
				$sql = mysql_query ("SELECT DISTINCT personnel.PhoneFixe, personnel.PhonePort, personnel.Fax, personnel.email ,personnel.Blog
									, batiment.nomBatiment, fonction.nomFonction, pole.nomPole, unite.nomUnite
									FROM  (((personnel INNER JOIN unite ON (personnel.codeUnite = unite.code)) 
									INNER JOIN fonction ON (personnel.codeFonction = fonction.code)) 
									INNER JOIN pole ON (personnel.codePole = pole.code)) 
									INNER JOIN batiment ON (personnel.codeBatiment = batiment.code)
									WHERE personnel.Nom = '".$personneNom."' AND personnel.Prenom = '".$personnePrenom."'
									AND personnel.civilite = '".$personneCivilite."'; ") or die(mysql_error()) ;
				while ( $row = mysql_fetch_array($sql))
				{
					if($row["PhoneFixe"] != ""){
						if (strpos($phoneFixe, $row["PhoneFixe"]) == false)
							$phoneFixe .= $row["PhoneFixe"]."&";
					}
					
					if($row["PhonePort"] != ""){
						if (strpos($phonePort, $row["PhonePort"]) == false)
							$phonePort .= $row["PhonePort"]."&";
					}
					
					if($row["Fax"] != ""){
						if (strpos($fax, $row["Fax"]) == false)
							$fax .= $row["Fax"]."&";
					}
					
					if($row["email"] != ""){
						if (strpos($email, $row["email"]) == false)
							$email .= $row["email"]."&";
					}
					
					if($row["Blog"] != ""){
						if (strpos($blog, $row["Blog"]) == false)
							$blog .= $row["Blog"]."&";
					}
					
					if($row["nomBatiment"] != ""){
						if (strpos($batiment, $row["nomBatiment"]) == false)
							$batiment .= $row["nomBatiment"]."&";
					}
					if($row["nomFonction"] != ""){
						if (strpos($fonction, $row["nomFonction"]) == false)
							$fonction .= $row["nomFonction"]."&";
					}
					if($row["nomPole"] != ""){
						if (strpos($pole, $row["nomPole"]) == false)
							$pole .= $row["nomPole"]."&";
					}	
					if($row["nomUnite"] != ""){
						if (strpos($unite, $row["nomUnite"]) == false)
							$unite .= $row["nomUnite"]."&";
					}
				}

			//echo $phoneFixe." ".$phonePort." ".$fax." ".$email." ".$blog." ".$batiment." ".$fonction." ".$pole." ".$unite . "</br>";
				
			return $personneCivilite."$".$personneNom."$".$personnePrenom."$".$phoneFixe."$".$phonePort."$".$fax."$".$email."$".$blog."$".$batiment."$".$fonction."$".$pole."$".$unite;
			//si les variables possedent plusieurs valeurs celle-ci sont separes par des des '&'
			//et les variables sont séparés par des '$'
			//Attention a respecter cette ordre pour la recuperation des valeur
		}
		
		function RechercherToutLesNom ()
		{
			 $Resultat = "";
				
				$sql = mysql_query ("SELECT DISTINCT personnel.Nom
									FROM  personnel
									ORDER BY personnel.Nom ;") or die(mysql_error()) ;
				
				while ( $row = mysql_fetch_array($sql))
				{
					$Resultat .= $row['Nom'].'*';
				}
				
				return $Resultat;
		}
		
		function RechercherTouteLesFonction ()
		{
			 $Resultat = "";
				
				$sql = mysql_query ("SELECT DISTINCT fonction.nomFonction
									FROM  fonction
									ORDER BY fonction.nomFonction ;") or die(mysql_error()) ;
				
				while ( $row = mysql_fetch_array($sql))
				{
					$Resultat .= $row['nomFonction'].'*';
				}
				
				return $Resultat;
		}
		
		function RechercherToutLesPole ()
		{
			 $Resultat = "";
				
				$sql = mysql_query ("SELECT DISTINCT pole.nomPole
									FROM  pole
									ORDER BY pole.nomPole;") or die(mysql_error()) ;
				
				while ( $row = mysql_fetch_array($sql))
				{
					$Resultat .= $row['nomPole'].'*';
				}
				
				return $Resultat;
		}
		
		function RechercherTouteLesUnite ()
		{
			 $Resultat = "";
				
				$sql = mysql_query ("SELECT DISTINCT unite.nomUnite
									FROM  unite
									ORDER BY unite.nomUnite;") or die(mysql_error()) ;
				
				while ( $row = mysql_fetch_array($sql))
				{
					$Resultat .= $row['nomUnite'].'*';
				}
				
				return $Resultat;
		}
		
		function RechercherToutLesBatiment ()
		{
			 $Resultat = "";
				
				$sql = mysql_query ("SELECT DISTINCT batiment.nomBatiment
									FROM  batiment
									ORDER BY batiment.nomBatiment;") or die(mysql_error()) ;
				
				while ( $row = mysql_fetch_array($sql))
				{
					$Resultat .= $row['nomBatiment'].'*';
				}
				
				return $Resultat;
		}
		
	?>
			<form action="FormPerso.php" method="post"  name="form1">

				<table align="center">
					<!--Champs de la fiche du personnel-->
					<tr><td>Nom :</td>
						<td>
						<select name="nom" size="1" id ="nom"  />	
								 <option  value="" selected="selected" >---------</option>	
						</select>
						</td>
					</tr>
					
					<?php	
						//echo RechercherToutLesNom();
						echo "<script>   affichageSelecteur(document.getElementById('nom'),'".RechercherToutLesNom()."');  </script>"; ?>
						
						
					<tr><td>Fonction :</td>
						<td>
						<select name="fonction" size="1" id ="fonction"  />
							<option  value="" selected="selected" width="50" >---------</option>
						</select>
						</td>
					</tr>
					
					<?php echo "<script>   affichageSelecteur(document.getElementById('fonction'),\"".RechercherTouteLesFonction ()."\");  </script>"; ?>
					
					<tr><td>Pôle :</td>
						<td>
							<select  name="pole" size="1" id="pole"  />
								<option  value="" selected="selected" >---------</option>
							</select>
						
						</td>
					</tr>
					
					<?php echo "<script>   affichageSelecteur(document.getElementById('pole'),\"".RechercherToutLesPole()."\");  </script>"; ?>
					
					<tr><td>Unité :</td>
						<td>
							<select name="unite" size="1" id = "unite"  />
								<option  value="" selected="selected" >---------</option>
							</select>
						</td>
					</tr>
					<?php echo "<script>   affichageSelecteur(document.getElementById('unite'),\"".RechercherTouteLesUnite()."\");  </script>"; ?>
					
					<tr><td>Batiment :</td>
						<td>
							<select name="batiment" size="1" id="batiment"  />
								<option  value="" selected="selected" >---------</option>
							</select>
						</td>
					</tr>
					<?php echo "<script>   affichageSelecteur(document.getElementById('batiment'),\"".RechercherToutLesBatiment()."\");  </script>"; ?>
					
				</table>
				
										
				<!--Validation ou reinitialisation du formulaire-->
				<table align="center"><tr>
					<td><input type= "submit" value="Soumettre"/></td>
					<td><input type= "reset" value="Réinitialiser"/></td></tr>
				</table>
							
				<hr  width="350" size="2" align="center"/></br>
				
				<div id = "tableRecherche" >
					<table align="center" BORDER=1>
							<tr >
								<td height="50" width="200"> 		</td>
								<td height="50" width="200">Civilité 	</td>
								<td height="50" width="200">Prénom		</td>
								<td height="50" width="200">Nom 		</td>
								<td height="50" width="200">Unité 		</td>
								<td height="50" width="200">Fonction 	</td>
							</tr>
					
					</table>
				</div>
				
				<?php	
						//echo Rechercher();
						echo "<script>   affichageDuTableau('".Rechercher()."');  </script>";
				?>
					
				<hr  width="350" size="2" align="center"/>

			</form>
			
			<?php mysql_close($connect);  ?>
			


</body>
</html>