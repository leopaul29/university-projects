//Fraction.h


#include <iostream>
#include <string>

class Fraction
{
private:
	int m_num;
	int m_den;
	void reduire();
public:
	//Constructeur
	Fraction();
	Fraction(int n, int d);
	Fraction(int n);

	//Constructeur de copie
	Fraction(Fraction& f);

	//Accesseur
	int getNum();
	int getDen() {return m_den;} //inline

	//toString
	char* toString();

	//Surcharge des op�rateurs avec nouvelle fraction
	Fraction operator + (Fraction& f);
	Fraction operator - (Fraction& f);
	Fraction operator * (Fraction& f);
	Fraction operator / (Fraction& f);

	//Surcharge des op�rateurs sur la premiere fraction
	Fraction operator += (Fraction f);
	Fraction operator -= (Fraction f);
	Fraction operator *= (Fraction f);
	Fraction operator /= (Fraction f);

	//Surcharge des op�rateurs de comparaison
	Fraction operator == (Fraction f);
	Fraction operator >= (Fraction f);
	Fraction operator <= (Fraction f);
	Fraction operator != (Fraction f);

};