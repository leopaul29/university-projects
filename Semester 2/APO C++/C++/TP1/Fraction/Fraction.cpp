//Fraction.cpp

#include "Fraction.h"
#include "Servitudes.h"
#include <iostream>
#include <string>
using namespace std;
//Constructeur par defaut
Fraction :: Fraction()
{
	m_num = 0;
	m_den = 1;
}

//Constructeur 1
Fraction :: Fraction(int n, int d)
{
	m_num = n;
	m_den = d;
	reduire();
}

//Constructeur 2
Fraction :: Fraction(int n)
{
	m_num = n;
	m_den = 1;
}

//Constructeur de copie
Fraction :: Fraction(Fraction& f)
{
	this->m_num = f.m_num;
	this->m_den = f.m_den;
}

//Accesseur
int Fraction :: getNum() {return m_num;}

//Reduire
void Fraction :: reduire()
{
	int signe, pgcd;
	// Traiter le cas particulier d'une fraction nulle
    //	
	if (m_num == 0)
		return ;
		
    // Determiner le signe du resultat
    //
    if (m_num>0)
       if (m_den>0) signe= 1;
       else signe= -1;
    else if (m_den>0) signe= -1;
         else signe= 1;

	// Calculer le PGCD des deux membres
    //
    pgcd = PGCD(abs(this->m_num), abs(this->m_den));
			 
    // Diviser chaque membre par le PGCD
    //
      
   	this->m_num = abs(this->m_num) / pgcd;
   	this->m_den = abs(this->m_den) / pgcd;
     	
   	if ( signe == -1)
   	{
   		this->m_num *= -1;
   	}
}


//toString
char* Fraction :: toString() {

      // Traiter le cas particulier d'une fraction nulle
      //
	 char* resultat;
	 

	if (this->m_num==0) 
		resultat = "0";
	else if (this->m_den==1)
	{
		resultat = (char*) malloc(sizeof(int));
		sprintf(resultat,"%d", m_num);
	} 
	else
	{
		resultat = (char*) malloc( 2*sizeof(int) + sizeof(char));
		sprintf(resultat,"%d/%d", m_num,m_den);
	}

	  return resultat;
}

/*
//Surchage des opérateurs avec nouvelle fraction
//
//Surcharge opérateur + (f3 = f1 + f2)
Fraction Fraction :: operator + (Fraction& f)
{
	Fraction resultat;
	resultat.m_num = this->m_num*f.m_den + this->m_den*f.m_num;
	resultat.m_den = this->m_den*f.m_den;
	return resultat;
}

//Surcharge opérateur - (f3 = f1 - f2)
Fraction Fraction :: operator - (Fraction& f)
{
	Fraction resultat;
	resultat.m_num = this->m_num*f.m_den - this->m_den*f.m_num;
	resultat.m_den = this->m_den*f.m_den;
	return resultat;
}

//Surcharge opérateur * (f3 = f1 * f2)
Fraction Fraction :: operator - (Fraction& f)
{
	Fraction resultat;
	resultat.m_num = this->m_num*f.m_num;
	resultat.m_den = this->m_den*f.m_den;
	return resultat;
}

//Surcharge opérateur / (f3 = f1 / f2)
Fraction Fraction :: operator - (Fraction& f)
{
	Fraction resultat;
	resultat.m_num = this->m_num/f.m_den;
	resultat.m_den = this->m_den/f.m_den;
	return resultat;
}

//Surcharge des opérateur avec la premiere fraction
//
//Surcharge opérateur += (f1 = f1 + f2)
Fraction Fraction :: operator += (Fraction f)
{
	this->m_num = this->m_num*f.m_den + this->m_den*f.m_num;
	this->m_den = this->m_den*f.m_den;
	return f;
}

//Surcharge opérateur -= (f1 = f1 - f2)
Fraction Fraction :: operator -= (Fraction f)
{
	this->m_num = this->m_num*f.m_den - this->m_den*f.m_num;
	this->m_den = this->m_den*f.m_den;
	return f;
}

//Surcharge opérateur *= (f1 = f1 * f2)
Fraction Fraction :: operator -= (Fraction f)
{
	this->m_num = this->m_num*f.m_num;
	this->m_den = this->m_den*f.m_den;
	return f;
}

//Surcharge opérateur /= (f1 = f1 / f2)
Fraction Fraction :: operator -= (Fraction f)
{
	this->m_num = this->m_num*f.m_den;
	this->m_den = this->m_den*f.m_num;
	return f;
}
*/
//Surcharge d'opérateur de comparaison
//
//Surcharge opérateur ==
bool Fraction :: operator == (Fraction f)
{
	if((this->m_num == f.m_num) && (this->m_den == f.m_den)) return true; else return false;
}

//Surcharge opérateur >=
bool Fraction :: operator >= (Fraction f)
{
	Fraction Num1 = this->m_num*f.m_den;
	Fraction Num2 = this->m_den*f.m_num;
	if(Num1 >= Num2) return true; else return false;
}

//Surcharge opérateur <=
bool Fraction  :: operator <= (Fraction f)
{
	Fraction Num1 = this->m_num*f.m_den;
	Fraction Num2 = this->m_den*f.m_num;
	if(Num1 <= Num2) return true; else return false;
}
//Surcharge opérateur !=
bool Fraction  :: operator != (Fraction f)
{
	if((this->m_num != f.m_num) && (this->m_den != f.m_den)) return true; else return false;
}