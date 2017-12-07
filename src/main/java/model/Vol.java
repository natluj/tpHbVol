package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Vol {

	@Id
	@SequenceGenerator(name = "volSeq", sequenceName = "volSeq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "volSeq")
	private Integer id;

	@Column(unique = true)
	@Length(min = 4, max = 4)
	@NotNull
	private String numVol;

	@Enumerated(EnumType.STRING)
	@NotNull
	private Type type;

	@NotNull
	private Integer nbPlaces;

	@NotNull
	private String villeDeDepart;

	@NotNull
	private String villeDArrivee;

	@NotNull
	private LocalDate dateDeDepart;

	@OneToMany(mappedBy = "vol", fetch = FetchType.LAZY)
	Collection<Reservation> reservations = new ArrayList<>();

	/**
	 * CONSTRUCTOR
	 * 
	 * @param idVol
	 * @param numVol
	 * @param type
	 * @param nbPlaces
	 * @param villeDeDepart
	 * @param villeDArrivee
	 * @param dateDeDepart
	 * @param resList
	 */
	public Vol() {
		super();
	}
	public Vol(@NotNull String numVol, @NotNull Type type, @NotNull Integer nbPlaces, @NotNull String villeDeDepart, @NotNull String villeDArrivee,
			@NotNull LocalDate dateDeDepart) {
		this.numVol = numVol;
		this.type = type;
		this.nbPlaces = nbPlaces;
		this.villeDeDepart = villeDeDepart;
		this.villeDArrivee = villeDArrivee;
		this.dateDeDepart = dateDeDepart;
	}

	/**
	 * GETTERS & SETTERS
	 */

	public String getNumVol() {
		return numVol;
	}

	public void setNumVol(String numVol) {
		this.numVol = numVol;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public String getVilleDeDepart() {
		return villeDeDepart;
	}

	public void setVilleDeDepart(String villeDeDepart) {
		this.villeDeDepart = villeDeDepart;
	}

	public String getVilleDArrivee() {
		return villeDArrivee;
	}

	public void setVilleDArrivee(String villeDArrivee) {
		this.villeDArrivee = villeDArrivee;
	}

	public Integer getIdVol() {
		return id;
	}

	public void setIdVol(Integer id) {
		this.id = id;
	}

	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setResList(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	public void setNbPlaces(Integer nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public LocalDate getDateDeDepart() {
		return dateDeDepart;
	}

	public void setDateDeDepart(LocalDate dateDeDepart) {
		this.dateDeDepart = dateDeDepart;
	}

}
