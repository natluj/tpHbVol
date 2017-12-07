package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.persistence.EntityManager;

import dao.Tools;
import dao.VolDAO;
import model.Type;
import model.Vol;

public class Service {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		EntityManager em = Tools.createEntityManager();
		boolean quitterMenuPrincipal = false;

		do { // Menu Principal
			System.out.println("==============================================================");
			System.out.println("==                     MENU PRINCIPAL                       ==");
			System.out.println("==============================================================");
			System.out.println("1) Gestion des vols " + "\n2) Gestion des réservations" + "\n3) Quitter \n");

			System.out.print("Entrez votre choix : ");
			String choix = scan.next();

			switch (choix) {
			case "1":
				menuVol(em, scan);
				break;

			case "2":
				menuReservation(em, scan);
				break;

			case "3":
				quitterMenuPrincipal = true;
				System.out.println("A bientôt !");
				break;

			default:
				System.out.println("La commande n'est pas valide.");
			}
		} while (quitterMenuPrincipal == false);

	}


	/**
	 * MENU VOL
	 * @param em
	 */
	public static void menuVol(EntityManager em, Scanner scan) {

		boolean quitterMenuVol = false;
		 
		do { // Sous menu : Menu Vol
			System.out.println("==============================================================");
			System.out.println("==                        MENU VOL                          ==");
			System.out.println("==============================================================");
			System.out.println(
					"1) Création de vol " + "\n2) Liste des vols " + "\n3) Rechercher un avion par numéro"
							+ "\n4) Rechercher un avion par ville de départ et d'arrivée" + "\n5) Retour");

			System.out.print("Entrez votre choix : ");
			String choixVol = scan.nextLine();

			switch (choixVol) {
			case "1": // création de vol : détermination des propriétés
				System.out.println("Création de vol :");
				System.out.print("Entrez un numéro de vol (4 caractères) : ");
				String numVol = scan.nextLine();
				System.out.print("\nChoisissez le type de l'avion : ");

				boolean typeOK = false;
				Type type = null;
				do {
					System.out.println("\n1) A330 \n2) A340 \n3) A380 \n4) B747");
					System.out.println("Choisissez votre type d'avion : ");
					String choixType = scan.nextLine();
					switch (choixType) {
					case "1":
						type = Type.A330;
						typeOK = true;
						break;
					case "2":
						type = Type.A340;
						typeOK = true;
						break;
					case "3":
						type = Type.A380;
						typeOK = true;
						break;
					case "4":
						type = Type.B747;
						typeOK = true;
						break;
					default:
						System.out.println("Incorrect.");
						break;
					}
				} while (typeOK == false);
				
				System.out.print("Indiquez le nombre de places : ");
				int nbPlaces = scan.nextInt();
				System.out.print("Ville de départ ? ");
				String villeDeDepart = scan.next();
				System.out.print("Ville d'arrivée ? ");
				String villeDArrivee = scan.next();
				System.out.println("Date de départ (dd/mm/yyyy) ? ");
				String dateDep = scan.next();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
				LocalDate dateDeDepart = LocalDate.parse(dateDep, formatter);

				Vol vol = new Vol(numVol, type, nbPlaces, villeDeDepart, villeDArrivee,	dateDeDepart);
				VolDAO.createVol(em, vol);
				break;
				
			case "2":
				VolDAO.listingVols(em);
				break;

			case "3":
				VolDAO.showVolByNum(em, scan);
				break;

			case "4":
				VolDAO.searchVolByCity(em, scan);
				break;

			case "5":
				quitterMenuVol = true;
				break;

			default:
				System.out.println("Commande incorrecte.");
				break;
			}
		} while (quitterMenuVol == false);

	}

	
	/**
	 * MENU RESERVATION
	 */
	public static void menuReservation(EntityManager em, Scanner scan) {
		
		boolean quitterMenuReservation = false;
		
		do {
			System.out.println("==============================================================");
			System.out.println("==                    MENU RESERVATION                      ==");
			System.out.println("==============================================================");
			System.out.println(
					"1) Création de réservation " + "\n2) Liste des réservations d'un vol " + "\n3) Annuler une réservation"
							+ "\n4) Voir les réservations d'une personne" + "\n5) Retour");

			System.out.print("Entrez votre choix : ");
			
			String choixReservation = scan.nextLine();

			switch (choixReservation) {
			case "1":
				
				break;
			
			case "2":
				
				break;
				
			case "3":
				
				break;
				
			case "4":
				
				break;
				
			case "5":
				
				break;
				
			default:
				System.out.println("Il y a une erreur quelque part !");
				break;
			}
			
			
		}while(quitterMenuReservation==false);
		
		
		
	}
}
