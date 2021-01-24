/**
 * @version 1.00 23 Mars 2001
 * Inspir� par la classe Reflectiontest.java de
 * Cay S. Horstmann & Gary Cornell, publi�e dans le livre Core Java, Sun Press
 */

package utils;
import java.lang.reflect.*;
import java.io.*;
import java.util.Scanner;


public class Analyseur
{
	private String m_nom;			// nom classe ou m�thode
	private Class m_cl;				// objet Class
	private Method m_method;		// objet Method
	private Constructor <?> m_constructor; 	// objet Constructor

	private Object m_obj;			// objet support
	private Class<?>[] m_typeParam;	// types des param�tres de la m�thode
	private Object[] m_valParam;	// tableau des valeurs des param�tres

	public Class getClasse() { return m_cl;}
	public Method getMethode() { return m_method;}

  // constructeur pour l'analyse d'une classe
  public Analyseur(String nomClasse) throws ClassNotFoundException
  {
    // Instanciation des donn�es
    m_nom = nomClasse;
    // R�cup�ration d'un objet de type Class correspondant au nom
    m_cl = Class.forName(m_nom);
    // attributs non utilis�s
    m_method = null;
    m_obj=null;
    m_typeParam = null;
    m_valParam = null;
  }

  // constructeur pour l'analyse d'une m�thode (ou d'un constructeur)
  public Analyseur(String nomClasse, String nomMethode, Class<?> ...typeParam) throws ClassNotFoundException, NoSuchMethodException,SecurityException
  {
    // Instanciation des donn�es
    m_nom = nomMethode;
    // R�cup�ration d'un objet de type Class correspondant au nom
    m_cl = Class.forName(nomClasse);

    // initialisation liste types param�tres
    if (typeParam.length==0)
    {
    	Class<?> noparams[] = {};
    	m_typeParam = noparams;
    }
    else m_typeParam = typeParam;

    // on r�cup�re dans str le nom de la classe
    Scanner s = new Scanner(nomClasse);
    s.useDelimiter("[.]");
    String str= new String();
    while (s.hasNext()) str = s.next();

    // test m�thode ou constructor
    if (str.equals(nomMethode))
    {
	    // R�cup�ration d'un objet de type Constructor correspondant au nom et aux types des param�tres
	    m_constructor = m_cl.getDeclaredConstructor(m_typeParam);
	    m_method = null;
    }
    else
    {
	    // R�cup�ration d'un objet de type Method correspondant au nom et aux types des param�tres
	    m_method = m_cl.getDeclaredMethod(m_nom, m_typeParam);
	    m_constructor = null;
    }
    // attributs non utilis�s
    m_obj = null;
    m_valParam = null;
  }

  public void afficheClasse() throws ClassNotFoundException, NoSuchMethodException,SecurityException
  {
    afficheEnTeteClasse();

    System.out.println();
    afficheAttributs();

    System.out.println();
    afficheConstructeurs();

    System.out.println();
    afficheMethodes();

    // L'accolade fermante de fin de classe !
    System.out.println("}");
  }

  /** Cette m�thode affiche par ex "implements Titi, Tutu {" */
  private void afficheInterfaces()
  {
	// Affichage des interfaces que la classe implemente
	Class[] interfaces = m_cl.getInterfaces();
	if (interfaces.length != 0)
	{
		System.out.print(" implements ");
		for(int i = 0; i < interfaces.length; i++)
		{
			System.out.print(interfaces[i].getName());
			if (i != (interfaces.length -1)) System.out.print(", ");
		}
	}
  }

  /** Cette m�thode affiche par ex "public class Toto extends Tata implements Titi, Tutu {" */
  public void afficheEnTeteClasse()
  {
	// Affichage du modifier , du nom de la classe et son ent�te si elle est g�n�rique
	System.out.print(Modifier.toString(m_cl.getModifiers()));
	System.out.print(" class " + m_cl.getName());

	// R�cup�ration de la superclasse si elle existe ( null si m_cl est le type Object )
	Class supercl = m_cl.getSuperclass();

	// On ecrit le "extends " que si la superclasse est non nulle et
	// diff�rente de Object
	if (supercl != null && !supercl.equals(Object.class))
	// ou variante suivante :
	// if ( supercl != null && supercl . getSuperclass () != null )
		System.out.print(" extends " + supercl.getName());

	// Affichage des interfaces que la classe implemente
	afficheInterfaces();
	// Enfin , l � accolade ouvrante !
	System.out.print(" {\n");
  }

  public void afficheAttributs()
  {
  	// A COMPLETER
  	Field[] field = this.getClasse().getDeclaredFields();
  	for (int i = 0; i < field.length; i++)
  	{
  		System.out.println(field[i]);
  	}
  }

  private void afficheParametres(Class[] paramTypes)
  {
	// Affichage du type des param�tres
	for (int j = 0; j < paramTypes.length; j++)
	{
		if (j > 0) System.out.print(", ");
		System.out.print(paramTypes[j].getName());
	}
	System.out.print(")");
  }

  private void afficheExceptions(Class [] exceptions)
  {
	// Affichage des Exceptions
	if (exceptions.length != 0)
	{
		System.out.print(" throws ");
		for(int k = 0; k < exceptions.length; k++)
		{
			System.out.print(exceptions[k]);
			if (k != (exceptions.length -1)) System.out.print(", ");
		}
	}
  }

  public void afficheConstructeurs()
  {
	Constructor[] constructors = m_cl.getDeclaredConstructors();
	for (int i = 0; i < constructors.length; i++)
	{
		// Le i�me constructeur
		Constructor c = constructors[i];
		// Affichage du modifier + du nom de la classe ( eq. nom du constructeur )
		System.out.print("\t" + Modifier.toString(c.getModifiers()));
		System.out.print(" " + m_cl.getName() + "(");
		// Affichage du type des param�tres
		Class[] paramTypes = c.getParameterTypes();
		afficheParametres(paramTypes);
		// Affichage des Exceptions
		Class[] exceptions = c.getExceptionTypes();
		afficheExceptions(exceptions);
		System.out.println("{}");
	}
  }

  public void afficheMethodes() throws NoSuchMethodException,SecurityException
  {
	Method[] methods = m_cl.getMethods();
	for (Method m : methods)
	{
		m_method = m;
		afficheMethode();
	}
  }

  public void afficheMethode()throws NoSuchMethodException,SecurityException
  {
	// Le type de retour
	Class retType = m_method.getReturnType();
	// Le nom de la m�thode
	String name = m_method.getName();
	// Affichage du modifier + type de retour + nom de la m�thode
	System.out.print("\t" + Modifier.toString(m_method.getModifiers()));
	System.out.print(" " + retType.getName() + " " + name + "(");
	// Affichage des types des param�tres
	Class[] paramTypes = m_method.getParameterTypes();
	afficheParametres(paramTypes);
	// Affichage des Exceptions
	Class[] exceptions = m_method.getExceptionTypes();
	afficheExceptions(exceptions);
	System.out.println("{}");
  }

  public Object creerInstance()	throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
  {
  	Object o;
    Class<?> novalues[] = {};
    m_valParam = novalues;
	o = m_cl.newInstance();
  	return o;
  }
  
  /*public Object creerInstance(Object ...values)	throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
  {
  	Object o=2;
  	m_valParam = values;
    //o = m_cl.getDeclaredConstructor(m_valParam);
  	return o;
  }*/

  public Object executeMethode(Object o, Object... args) throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException
  {
  	o.getMethode(args);
  }
}
