function show_props(obj, obj_name) {
			// cette fonction parcourt les propri�t�s et m�thodes d�un objet et affiche leur nom
			var result= "", i= "";
			for ( i in obj)
			result += obj_name + "." + i + "<br />";
			return result;
		}