<html>
	<head>
		<title>Ma premi�re page en php</title>
	</head>
	<body>
		<?php
			echo "<h1>Ma premi�re page en PHP !</h1>";
			echo "<h3>Afficher un message de bienvenue et la date d'aujourd'hui</h3>";
			$jour = array("Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"); 
			$mois = array("","Janvier","F�vrier","Mars","Avril","Mai","Juin","Juillet","Ao�t","Septembre","Octobre","Novembre","D�cembre"); 
			$datefr = $jour[date("w")]." ".date("d")." ".$mois[date("n")]." ".date("Y"); 
			echo "Hello PHP, nous sommes le ". $datefr ; 
		?>
	</body>
</html>