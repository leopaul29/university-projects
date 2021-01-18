/**
* @(#)CompteBanquaireR.java
*
*
* @author 
* @version 1.00 2013/6/7
*/
import java.lang.Thread;
import java.lang.Runnable;
public class CompteBancaire implements Runnable {
private double m_solde = 0.0;
public CompteBancaire() {
m_solde = 0.0;
}

/*Runnable :
*getSold
*setSolde
*ajouterSomme
*retrancherSomme*/

public void run() {

double MonSolde = m_solde;
System.out.println("Le solde de debut est : " + getSolde());

MonSolde.setSolde(200.0);
System.out.println("Le nouveau solde est : " + getSolde());

MonSolde.ajouterSomme(15.0);
System.out.println("Le solde après ajout de 15 est : " + getSolde());

MonSolde.retrancherSomme(135.0);
System.out.println("Le solde après retrait 135 est : " + getSolde());
}

public synchronized double getSolde() {return m_solde; }
public synchronized void setSolde(double newSolde) {m_solde = newSolde; }
public synchronized void ajouterSomme(double ajout) {m_solde = m_solde + ajout; }
public synchronized void retrancherSomme(double retrait) {m_solde = m_solde - retrait; }

public static void main (String[] args) {

CompteBanquaireR cb = new CompteBanquaireR();
Thread t = new Thread(new CompteBanquaireR(cb));
t.start();
}

}
