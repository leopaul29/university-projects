

	
	function affichageDuTableau (chaine)
	{
		 var valeur = ""; //le code html
		 var lettre =''; // un caractere
		 var mot=""; //une valeur de la base
		 var celluleTab = ""; // une cellule du tableau
		 var lettreNom =''; // lettre du nom
		
		valeur += "<table align=\"center\" ><tr ><td height=\"50\" width=\"200\"></td> <td height=\"50\" width=\"200\">Civilité</td> <td height=\"50\" width=\"200\">Prénom </td> <td height=\"50\" width=\"200\" >Nom </td> <td height=\"50\" width=\"200\">Unité </td><td height=\"50\" width=\"200\">Fonction</td></tr>";
		
		for ( i=0; i < chaine.length ; i++)
		{
			lettre = chaine.charAt(i);

			if(lettre == '+')
			{
				valeur+="<tr>";
				valeur+=celluleTab;
				valeur+="</tr>";
				mot="";
				celluleTab="";
			}
			else if (lettre == '*')
			{
				celluleTab += "<td height=\"50\" width=\"200\">"+mot+"</td>";
				mot = "";
				
			}
			else
				mot += lettre;
		}
		
		valeur += "</table>";
		
		document.getElementById('tableRecherche').innerHTML = valeur;
	}
	
	
	function affichageSelecteur (id , chaine)
	{
		var lettre ='';
		var mot ="";
		
		for ( i =0 ; i < chaine.length; i++)
		{
			lettre = chaine.charAt(i);
			
			if( lettre == '*')
			{
				addOption(id,mot,mot);
				mot="";
			}
			else
				mot+=lettre;
		}

	}
	
	
	function addOption(selectbox,text,value)
	{
		selectbox.options[selectbox.length] = new Option(text, value);
	}
	
	
	
	//si les variables possedent plusieurs valeurs celle-ci sont separes par des des '&'
	//et les variables sont séparés par des '$'
	//Attention a respecter cette ordre pour la recuperation des valeur
	function fenetrePersonne (valeur)
	{
			var civilite="", nom="", prenom="", phoneFixe = "", phonePort = "";
			var fax = "", email = "", blog = "", batiment = "", fonction = "", pole = "", unite = "";
			var nb=0;
			
			
			for( i=0; i<valeur.length ;i++)
			{
				switch (nb) {
				case 0://civilite
				
					if (valeur.charAt(i) == '&')
						civilite += " / ";
					else if (valeur.charAt(i) == '$')
						nb++;
					else
						civilite += valeur.charAt(i);
					break;
				
				case 1://nom
					if (valeur.charAt(i) == '&')
						nom += " / ";
					else if (valeur.charAt(i) == '$')
						nb++;
					else
						nom += valeur.charAt(i);
					break;
				
				case 2://prenom
					if (valeur.charAt(i) == '&')
						prenom += " / ";
					else if (valeur.charAt(i) == '$')
						nb++;
					else
						prenom += valeur.charAt(i);
					break;
				
				case 3://fixe
					if (valeur.charAt(i) == '&')
						phoneFixe += " / ";
					else if (valeur.charAt(i) == '$')
						nb++;
					else
						phoneFixe += valeur.charAt(i);
					break;
				
				case 4://port
					if (valeur.charAt(i) == '&')
						phonePort += " / ";
					else if (valeur.charAt(i) == '$')
						nb++;
					else
						phonePort += valeur.charAt(i);
					break;
				
				case 5://fax
					if (valeur.charAt(i) == '&')
						fax += " / ";
					else if (valeur.charAt(i) == '$')
						nb++;
					else
						fax += valeur.charAt(i);
					break;
				case 6://mail
					if (valeur.charAt(i) == '&')
						email += " / ";
					else if (valeur.charAt(i) == '$')
						nb++;
					else
						email += valeur.charAt(i);
					break;
				
				case 7://blog
					if (valeur.charAt(i) == '&')
						blog += " / ";
					else if (valeur.charAt(i) == '$')
						nb++;
					else
						blog += valeur.charAt(i);
					break;
				
				case 8://batiment
					if (valeur.charAt(i) == '&')
						batiment += " / ";
					else if (valeur.charAt(i) == '$')
						nb++;
					else
						batiment += valeur.charAt(i);
					break;
				
				case 9://fct
					if (valeur.charAt(i) == '&')
						fonction += " / ";
					else if (valeur.charAt(i) == '$')
						nb++;
					else
						fonction += valeur.charAt(i);
					break;
				
				case 10://pole
					if (valeur.charAt(i) == '&')
						pole += " / ";
					else if (valeur.charAt(i) == '$')
						nb++;
					else
						pole += valeur.charAt(i);
					break;
				
				case 11://unite
					if (valeur.charAt(i) == '&')
						unite += " / ";
					else if (valeur.charAt(i) == '$')
						nb++;
					else
						unite += valeur.charAt(i);
					break;
				}
			}

				fenetre = window.open('fichePersonnel.html','_blank',
				'toolbar=0,location=0,directories=0,status=0,scrollbars=1,resizable=1,copyhistory=0,menuBar=0,width=700,height=300 left=10 top=10');
				fenetre.document.write("<body style=\"background:#6699CC\" ><h1>Fiche Personnel de "+civilite+" "+nom+" "+prenom+"</h1>"+
				"</br><font color=\"red\">PhoneFixe: </font>"+phoneFixe+
				"</br><font color=\"red\">PhonePort: </font>"+phonePort+
				"</br><font color=\"red\">Fax: </font>"+fax+
				"</br><font color=\"red\">Email: </font>"+email+
				"</br><font color=\"red\">Blog: </font>"+blog+
				"</br><font color=\"red\">Batiment: </font>"+batiment+
				"</br><font color=\"red\">Fonction: </font>"+fonction+
				"</br><font color=\"red\">Pole: </font>"+pole+
				"</br><font color=\"red\">Unite: </font>"+unite+
				"</body>");

	}
	
	
		function TesteSiNombre (nb)
		{
			 var num = nb.value;   
	
			 // Le champs est vide   
			 if ( num == "" ){   
			 // alert ( "Le champs est vide !" );    
			 return false;   
			 } 
			 else{  
					var chiffres = new String(num);    
				 // Enlever tous les charactères sauf les chiffres   
				 chiffres = chiffres.replace(/[^0-9]/g, '');   
				 // Nombre de chiffres   
				 compteur = chiffres.length;   
					
				 if (chiffres.length != 10){   
				  alert("Vous devez entrer un numéro à 10 chiffres..."); 
				  nb.value="";
				 return false;   
				 }   
			} 
		}
		
		
		function Mail_Valide (valeur)
		{
			var reg = new RegExp('^[a-z0-9]+([_|\.|-]{1}[a-z0-9]+)*@[a-z0-9]+([_|\.|-]{1}[a-z0-9]+)*[\.]{1}[a-z]{2,6}$', 'i');
			//un mail est valide si il commence par un caractere ou un chiffre
			//puis qu il y a n foi ( 0 ou plus) :  un _ \ ou - 1 fois suivi d'un caractere
			//suivi d'un @
			//un caractere
			//puis qu il y a n foi ( 0 ou plus) :  un _ \ ou - 1 fois suivi d'un caractere
			// suivi d un point et enfin de 2 à 5 caractère
			
			if(valeur.value=="")
				return false;
				
				if(reg.test(valeur.value))
				{
					//alert("le mail est valide :"+ valeur.value );
					return(true);
				}
				else
				{
					alert("le mail n'est pas valide: "+valeur.value);
					valeur.value="";
					return(false);
				}
		
		}
		
		function verifierChaine (valeur)
		{
			var reg = new RegExp('^[A-Za-z][A-Za-z]*[A-Za-z]$','i');
			
			if(valeur.value=="")
				return false;
			
			if(reg.test(valeur.value))
				{
					//alert("le champ est valide :"+ valeur.value );
					return(true);
				}
				else
				{
					alert("le champ n'est pas valide: "+valeur.value);
					valeur.value="";
				}	
		}
		
	
	
	