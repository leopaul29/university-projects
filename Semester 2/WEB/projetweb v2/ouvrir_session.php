<!DOCTYPE html PUBLIC "//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transistional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	
</head>
<body>
	
	<?php
		function Sauvegarde ()
		{
				$file = fopen("text.txt", "a+");
				
				if($file == 0)
				echo "le fichier ne c'est pas ouvert. ";
				
				fwrite($file,$_POST["id"]." ".$_POST["mdp"]."\r\n");
				fclose($file);
				
		}
		
		function idMdpExiste ($nomFile) //renvoi 0 si il existe
		{
			$file = fopen($nomFile, "a+");
			
			if($file == 0)
			{
				echo "le fichier ne c'est pas ouvert... ";
			}
			
			$ligne = fgets($file);
			$chaine = $_POST["id"]." ".$_POST["mdp"]."\r\n"; // $chaine contient la chaine qu'on cherche
			
			while($ligne)
			{
				if($chaine == $ligne) //tq il y a des lignes
					return false;
					
				$ligne = fgets($file); // on recup la prochaine ligne
			}
			
			return true;
			
		}
		
		if($_POST["connection"] == "personnel")
		{
			if($_POST["id"] == "" || $_POST["mdp"]=="")
				header("Location: idmdp_incomplete.html");
			
			else if(idMdpExiste('personnel.txt'))
				header("Location: idmdp_incorrect.html");
			else
				header("Location: index2.php");
		}
		else
		{
			if($_POST["id"] == "" || $_POST["mdp"]=="")
				header("Location: idmdp_incomplete.html");
			
			else if(idMdpExiste('admin.txt'))
				header("Location: idmdp_incorrect.html");
			else
				header("Location: indexAdmin.php");
		}
		
		?>
		
	
	
	

</body>
</html>