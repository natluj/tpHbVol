package dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Reservation;
import model.Vol;

public class ReservationDAO {

	/**
	 * Méthode pour créer un réservation
	 */
	public static void createReservation() {
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		EntityManager em = Tools.createEntityManager();
		Tools.beginTx(em);

		System.out.println("Indiquez le numéro du vol de votre choix : ");
		String numVol = scan1.nextLine();
		
		TypedQuery<Vol> avion = em.createQuery("SELECT v FROM Vol v WHERE numVol='" + numVol + "'", Vol.class);
		Vol vol = avion.getSingleResult();		
		
		System.out.println("Entrez votre Nom : ");
		String nom = scan1.nextLine();
		System.out.println("Entrez votre Prénom : ");
		String prenom = scan1.nextLine();
		System.out.println("Quel est votre âge ? ");
		int age = scan2.nextInt();
		Reservation reservation = new Reservation(nom, prenom, age, vol);
		
		em.persist(reservation);
		System.out.println("Votre réservation a été enregistrée pour le vol " + vol.getNumVol() + ".");

		Tools.commitTxAndClose(em);
		scan1.close();
		scan2.close();
		
	}
	
	
	/**
	 * Méthode pour visualiser les réservations d'un vol
	 */
	public static void showReservations() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Saisissez le numéro du vol : ");
		String numVol = scan.nextLine();
		
	}
	
}
