<!DOCTYPE html PUBLIC "//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transistional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<script type="text/javascript" src="./jc.js"></script>
</head>
<body>

	<?php
	
		
		//initialisation de $ajouter
		if (isset($_POST["ajouter"]))
			$Ajouter = $_POST["ajouter"];
		else
			$Ajouter ="";
			
		//initialisation de $supprimer
		if (isset($_POST["supprimer"]))
			$Supprimer = $_POST["supprimer"];
		else
			$Supprimer ="";
		
		//initialisation de $supprimer
		if (isset($_POST["supprimer"]))
			$Supprimer = $_POST["supprimer"];
		else
			$Supprimer ="";
	
		//initialisation de $civilite
		if (isset($_POST["civilite"]))
			$Civilite = $_POST["civilite"];
		else
			$Civilite ="";
		
		//initialisation de $prenom
		if (isset($_POST["prenom"]))
			$Prenom = $_POST["prenom"];
		else
			$Prenom ="";
		
		//initialisation de $nom
		if (isset($_POST["nom"]))
			$Nom = $_POST["nom"];
		else
			$Nom ="";
			
		//initialisation de $phoneFixe
		if (isset($_POST["phoneFixe"]))
			$PhoneFixe = $_POST["phoneFixe"];
		else
			$PhoneFixe ="";
		
		//initialisation de $phonePort
		if (isset($_POST["phonePort"]))
			$PhonePort = $_POST["phonePort"];
		else
			$PhonePort ="";
		
		//initialisation de $fax
		if (isset($_POST["fax"]))
			$Fax = $_POST["fax"];
		else
			$Fax ="";
			
		//initialisation de $email
		if (isset($_POST["email"]))
			$Email = $_POST["email"];
		else
			$Email ="";
			
		//initialisation de $blog
		if (isset($_POST["blog"]))
			$Blog = $_POST["blog"];
		else
			$Blog ="";
		
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
		
																		//Fonction Rechercher
		function Rechercher (){
		
				$Resultat ="";
				$WHERE ="";
				
				global $Nom, $Fonction, $Pole, $Unite ,$Batiment;
				
				//on construit le WHERE de la requete selon les valeurs	
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
				
				//on fait notre requete
				$sql = mysql_query ("SELECT DISTINCT personnel.Nom,personnel.civilite, personnel.Prenom, unite.nomUnite , fonction.nomFonction
									FROM  (((personnel INNER JOIN unite ON (personnel.codeUnite = unite.code)) 
									INNER JOIN fonction ON (personnel.codeFonction = fonction.code)) 
									INNER JOIN pole ON (personnel.codePole = pole.code)) 
									INNER JOIN batiment ON (personnel.codeBatiment = batiment.code)"
									.$WHERE
									."ORDER BY personnel.Nom, personnel.Prenom ;") or die(mysql_error()) ;
									
				
				while ( $row = mysql_fetch_array($sql))
				{
					//on recupere les valeur et on les range dans 'Resultat' de façon a les recuperer pour les mettre dans le tableau
					$Resultat .= $row['Nom']{0}.'*';
					$Resultat .= $row['civilite'].'*';
					$Resultat .= $row["Prenom"].'*';
					$Resultat .= $row['Nom'].'*';
					$Resultat .= $row["nomUnite"].'*';
					$Resultat .= $row["nomFonction"].'*';
					$Resultat .= "+";
					
				}
				
				return $Resultat;
		}
			
																		//Fonction Ajouter
		function Ajouter (){
		
				$Resultat ="";
				$WHERE ="";
				
				global $Civilite, $Prenom, $Nom, $PhoneFixe, $PhonePort, $Fax, $Email, $Blog, $Fonction, $Pole, $Unite ,$Batiment;
				
				//On recupere le code du Batiment
				$sql = mysql_query ("SELECT batiment.code
									 FROM batiment
									 WHERE batiment.nomBatiment =\"".$Batiment."\" ") or die(mysql_error()) ;
				while ( $row = mysql_fetch_array($sql))
					$Batiment = $row["code"];
				
				//On recupere le code du pole
				$sql = mysql_query ("SELECT pole.code
									 FROM pole
									 WHERE pole.nomPole =\"".$Pole."\" ") or die(mysql_error()) ;
				while ( $row = mysql_fetch_array($sql))
					$Pole = $row["code"];
					
				
				//On recupere le code de l'unite
				$sql = mysql_query ("SELECT unite.code
									 FROM unite
									 WHERE unite.nomUnite =\"".$Unite."\" ") or die(mysql_error()) ;
				while ( $row = mysql_fetch_array($sql))
					$Unite = $row["code"];
				
				//On recupere le code de "Fonction"
				$sql = mysql_query ("SELECT fonction.code
									 FROM fonction
									 WHERE fonction.nomFonction =\"".$Fonction."\" ") or die(mysql_error()) ;
				while ( $row = mysql_fetch_array($sql))
					$Fonction = $row["code"];
				
				
				$sql = mysql_query ("INSERT INTO  `leopaul`.`personnel` (
`ID` , `civilite` , `Nom` , `Prenom` , `PhoneFixe` , `PhonePort` , `Fax` , `email` , `Blog` , `codeBatiment` , `codeFonction` , `codePole` , `codeUnite`)
VALUES (NULL ,  '".$Civilite."',  '".$Nom."',  '".$Prenom."',  '".$PhoneFixe."',  '".$PhonePort."',  '".$Fax."',  '".$Email."',  '".$Blog."',  '".$Batiment."',
  '".$Fonction."',  '".$Pole."',  '".$Unite."' );") or die(mysql_error()) ;
				
				mysql_close($connect);
				header("Location: FormGestionBase.php");
				
		}
		
																			//Fonction Supprimer
		function Supprimer (){
		
				$Resultat ="";
				$WHERE ="";
				
				global $Civilite, $Prenom, $Nom, $PhoneFixe, $PhonePort, $Fax, $Email, $Blog, $Fonction, $Pole, $Unite ,$Batiment;
				
				//On recupere le code du Batiment
				$sql = mysql_query ("SELECT batiment.code
									 FROM batiment
									 WHERE batiment.nomBatiment =\"".$Batiment."\" ") or die(mysql_error()) ;
				while ( $row = mysql_fetch_array($sql))
					$Batiment = $row["code"];
				
				//On recupere le code du pole
				$sql = mysql_query ("SELECT pole.code
									 FROM pole
									 WHERE pole.nomPole =\"".$Pole."\" ") or die(mysql_error()) ;
				while ( $row = mysql_fetch_array($sql))
					$Pole = $row["code"];
					
				
				//On recupere le code de l'unite
				$sql = mysql_query ("SELECT unite.code
									 FROM unite
									 WHERE unite.nomUnite =\"".$Unite."\" ") or die(mysql_error()) ;
				while ( $row = mysql_fetch_array($sql))
					$Unite = $row["code"];
				
				//On recupere le code de "Fonction"
				$sql = mysql_query ("SELECT fonction.code
									 FROM fonction
									 WHERE fonction.nomFonction =\"".$Fonction."\" ") or die(mysql_error()) ;
				while ( $row = mysql_fetch_array($sql))
					$Fonction = $row["code"];
				
				
				$sql = mysql_query ("DELETE FROM `personnel` 
WHERE personnel.civilite = '".$Civilite."' AND personnel.Prenom = '".$Prenom."' AND personnel.Nom = '".$Nom."' AND personnel.PhoneFixe = '".$PhoneFixe."'
AND  personnel.PhonePort = '".$PhonePort."' AND personnel.Fax = '".$Fax."' AND personnel.email = '".$Email."' AND personnel.Blog = '".$Blog."'
AND personnel.codeBatiment = '".$Batiment."' AND personnel.codeFonction = '".$Fonction."' AND personnel.codePole = '".$Pole."' AND 
personnel.codeUnite = '".$Unite."';") or die(mysql_error()) ;

			mysql_close($connect);
			header("Location: FormGestionBase.php");
									

		}
		
		//															Fonction RechercherToutLesNom
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
		
		//															Fonction  RechercherTouteLesFonction
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
		
		//															Fonction  RechercherTouteLesPole
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
		
		//															Fonction  RechercherTouteLesUnite
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
		
		//															Fonction  RechercherTouteLesBatiment
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
		
		
		if ( $Civilite != "" && $Prenom != "" && $Nom != "" && $Fonction != "" && $Pole != "" && $Unite != "" && $Batiment != "")
		{
			if($Ajouter == "Ajouter")
				Ajouter ();
				
			if($Supprimer =="Supprimer")
				Supprimer ();
		}
		//else
			//echo "<center><font color=\"red\"> Un des champs comportant une étoile est vide...</font></center> ";
		
	?>
			<form action="FormGestionBase.php" method="post"  name="form1">

				<table align="center">
					<!--Champs de la fiche du personnel-->
					<tr><td><font color="red">*</font> Civilité :</td>
						<td>
							<select  name="civilite" size="1" id ="civilite"  />
								<option  value="Mr"  >Mr</option>	
								<option  value="Mme"  >Mme</option>	
							</select>
						</td>
					</tr>
					
					<tr><td><font color="red">*</font>nom:</td>
						<td>
							<input type="text" name="nom" maxlength="20" id ="nom" onChange="verifierChaine (this)" />
						</td>
					</tr>
					
					<tr><td><font color="red">*</font>prenom:</td>
						<td>
							<input type="text" name="prenom" maxlength="20" id ="prenom" onChange="verifierChaine (this)" />
						</td>
					</tr>
					
					<tr><td>tel fixe:</td>
						<td>
							<input type="text" name="phoneFixe" maxlength="10" id ="phoneFixe" onChange="TesteSiNombre (this)" />
						</td>
					</tr>
					
					<tr><td>tel Port:</td>
						<td>
							<input type="text" name="phonePort" maxlength="10" id ="phonePort" onChange="TesteSiNombre (this)" />
						</td>
					</tr>
					
					<tr><td>fax:</td>
						<td>
							<input type="text" name="fax" maxlength="10" id ="fax" onChange="TesteSiNombre (this)" />
						</td>
					</tr>
					
					<tr><td>email:</td>
						<td>
							<input type="text" name="email" maxlength="50" id ="email" onChange="Mail_Valide (this)" />
						</td>
					</tr>
					
					<tr><td>blog:</td>
						<td>
							<input type="text" name="blog" maxlength="50" id ="blog"  />
						</td>
					</tr>
					
					<tr><td><font color="red">*</font>Fonction :</td>
						<td>
						<select name="fonction" size="1" id ="fonction"  />
							<option  value="" selected="selected" width="50" >---------</option>
						</select>
						</td>
					</tr>
					
					<?php echo "<script>   affichageSelecteur(document.getElementById('fonction'),\"".RechercherTouteLesFonction ()."\");  </script>"; ?>
					
					<tr><td><font color="red">*</font>Pôle :</td>
						<td>
							<select  name="pole" size="1" id="pole"  />
								<option  value="" selected="selected" >---------</option>
							</select>
						
						</td>
					</tr>
					
					<?php echo "<script> affichageSelecteur(document.getElementById('pole'),\"".RechercherToutLesPole()."\");  </script>"; ?>
					
					<tr><td><font color="red">*</font>Unité :</td>
						<td>
							<select name="unite" size="1" id = "unite"  />
								<option  value="" selected="selected" >---------</option>
							</select>
						</td>
					</tr>
					<?php echo "<script> affichageSelecteur(document.getElementById('unite'),\"".RechercherTouteLesUnite()."\");  </script>"; ?>
					
					<tr><td><font color="red">*</font>Batiment :</td>
						<td>
							<select name="batiment" size="1" id="batiment"  />
								<option  value="" selected="selected" >---------</option>
							</select>
						</td>
					</tr>
					<?php echo "<script> affichageSelecteur(document.getElementById('batiment'),\"".RechercherToutLesBatiment()."\");  </script>"; ?>
					
				</table>

				</br>
				<!--Validation ou reinitialisation du formulaire-->
				<table align="center"><tr>
					<td><input type= "submit" value="Ajouter" name="ajouter" /></td>
					<td><input type= "submit" value="Supprimer" name="supprimer" /></td>
					<td><input type= "reset" value="Réinitialiser"/></td></tr>
				</table>
			 
			 
			 </br>
				
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