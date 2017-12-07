package dao;

import java.util.Collection;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Reservation;
import model.Vol;

public class VolDAO {

	/**
	 * Méthode pour créer un avion et son vol
	 * 
	 * @param vol
	 */
	public static void createVol(EntityManager em, Vol vol) {
		Tools.beginTx(em);

		em.persist(vol);
		System.out.println("Un vol a été créé !");

		Tools.commitTxAndClose(em);
	}

	/**
	 * Méthode pour lister les vols d'avion
	 */
	public static void listingVols(EntityManager em) {
		Tools.beginTx(em);

		TypedQuery<Vol> queryVols = em.createQuery("SELECT v FROM Vol v ORDER BY v.dateDeDepart", Vol.class);
		Collection<Vol> vols = queryVols.getResultList();
		System.out.println("Numéro\t | Type\t | Place\t | Départ\t | Arrivé\t | Date");

		for (Vol vol : vols) {
			int nbReservations = 0;
			for (Reservation r : vol.getReservations()) {
				nbReservations++;
			}

			System.out.println(vol.getNumVol() + "\t | " + vol.getType() + "\t | " + nbReservations + "/"
					+ vol.getNbPlaces() + "\t | " + vol.getVilleDeDepart() + "\t | " + vol.getVilleDArrivee() + "\t | "
					+ vol.getDateDeDepart());
		}

		Tools.commitTxAndClose(em);
	}

	/**
	 * Méthode pour la recherche d'avion par numéro
	 */
	public static Vol findVolByNum(EntityManager em, Scanner scan) {
		Tools.beginTx(em);

		System.out.println("Entrez un numéro d'avion : ");
		String numAvion = scan.nextLine();
		TypedQuery<Vol> avion = em.createQuery("SELECT v FROM Vol v WHERE v.numVol='" + numAvion + "'", Vol.class);
		scan.close();
		return avion.getSingleResult();
	}

	public static void showVolByNum(EntityManager em, Scanner scan) {
		Tools.beginTx(em);

		Vol vol = findVolByNum(em, scan);

		int nbReservations = 0;
		for (Reservation r : vol.getReservations()) {
			nbReservations++;
		}
		System.out.println("Infos : \n " + vol.getType() + "\n" + vol.getDateDeDepart() + "\n" + vol.getVilleDeDepart()
				+ "\n" + vol.getVilleDArrivee() + "\n" + nbReservations + "/" + vol.getNbPlaces());

		Tools.commitTxAndClose(em);
	}

	/**
	 * Méthode pour la recherche d'avion par villes
	 */
	public static void searchVolByCity(EntityManager em, Scanner scan) {
		Tools.beginTx(em);

		System.out.println("Saisissez la ville de départ :");
		String villeDeDepart = scan.nextLine();
		System.out.println("Saisissez la ville d'arrivée :");
		String villeDArrivee = scan.nextLine();

		TypedQuery<Vol> queryAvions = em.createQuery("SELECT v FROM Vol v WHERE v.villeDeDepart='" + villeDeDepart
				+ "' AND v.villeDArrivee='" + villeDArrivee + "'", Vol.class);
		Collection<Vol> avions = queryAvions.getResultList();

		System.out.println("Numéro\t | Type\t | Place\t | Départ\t | Arrivé\t | Date");

		for (Vol vol : avions) {
			int nbReservations = 0;
			for (Reservation r : vol.getReservations()) {
				nbReservations++;
			}

			System.out.println(vol.getNumVol() + "\t | " + vol.getType() + "\t | " + nbReservations + "/"
					+ vol.getNbPlaces() + "\t | " + vol.getVilleDeDepart() + "\t | " + vol.getVilleDArrivee() + "\t | "
					+ vol.getDateDeDepart());
		}

		Tools.commitTxAndClose(em);
		scan.close();
	}
}
