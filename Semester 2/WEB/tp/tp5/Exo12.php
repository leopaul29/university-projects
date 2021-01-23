<html>
	<head>
		<title>Ma deuxième page en php</title>
	</head>
	<body>
		<?php //1.2
			echo "<h1>Ma deuxième page en PHP !</h1>";
			echo "<h3>Afficher un message de bienvenue et la date d'aujourd'hui</h3>";
			$heure = date("H:i");//heure:minutes
			
			//tableau des jours et mois
			$jour = array("Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"); 
			$mois = array("","Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"); 
			
			//construction de la date
			$datefr = $jour[date("w")]." ".date("d")." ".$mois[date("n")]." ".date("Y"); 
			
			//affichage du 1er message et la date
			echo "Hello PHP, nous sommes le ". $datefr ."</br>"; 
			
			//condition, si il est avant midi=Bon matin, sinon Bonne après midi
			if ($heure<=12) {echo "Bon matin";
			} else {echo "Bonne après midi";
			}echo ", il est $heure</br></br></br>";
			
			phpinfo();//afficher les variables d’environnement de PHP
		?>
		
		<?php //1.3
			echo"<h4>afficher les variables d’environnement SERVER_ADDR,HTTP_HOST,REMOTE_ADDR,HTTP_USER_AGENT</h4>";
			
			//tableau
			$variable = array(
						"SERVER_ADDR" => array(
											"SERVER_ADDR :  ",
											$_SERVER['SERVER_ADDR'],
											),
						"HTTP_HOST" => array(
											"HTTP_HOST  :  ",
											$_SERVER['HTTP_HOST'],
											),
						"REMOTE_ADDR" => array(
											"REMOTE_ADDR  :  ",
											$_SERVER['REMOTE_ADDR'],
											),
						"HTTP_USER_AGENT" => array(
											"HTTP_USER_AGENT  :  ",
											$_SERVER['HTTP_USER_AGENT'],
											)
						);
			echo $variable['SERVER_ADDR'][0];
			echo $variable['SERVER_ADDR'][1]."</br>";
			echo $variable['HTTP_HOST'][0];
			echo $variable['HTTP_HOST'][1]."</br>";
			echo $variable['REMOTE_ADDR'][0];
			echo $variable['REMOTE_ADDR'][1]."</br>";
			echo $variable['HTTP_USER_AGENT'][0];
			echo $variable['HTTP_USER_AGENT'][1]."</br>";
			echo "</br></br></br>";
		?>

		<?php //1.4
			echo "<h4>Afficher une table asscociative avec '(\$tab as \$key => \$valeur)'</h4>";
			
			$voiture = array(
							'Renault' => 'Twingo',
							'Renault' => 'Clio',
							'Renault' => 'Megane',
							'Renault' => 'Laguna');

						// Cette boucle affiche toutes les clés
						// dont la valeur vaut "apple"
						while ($Renault_name = current($array)) {
							if ($fruit_name == 'Megane') {
								echo key($array).'<br />';
							}
							next($array);
						}

			
			/*//« Renault » : « Twingo », « Clio »,« Megane », « Laguna ».
			$voiture = array("Renault"=>"Twingo", "Renault"=>"Clio", "Renault"=>"Megane", "Renault"=>"Laguna");
			echo $voiture['Renault'];
			//echo ($voiture as $Renault => $Twingo)*/
		?>
	</body>
</html>









