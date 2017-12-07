package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class Reservation {

	@Id
	@SequenceGenerator(name = "resSeq", sequenceName = "resSeq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resSeq")
	private Integer id;

	@NotNull
	@Column(unique = true)
	private String numReservation;

	@NotNull
	private String nom;
	@NotNull
	private String prenom;
	@NotNull
	private Integer age;

	@ManyToOne
	@JoinColumn(name = "vol_id")
	private Vol vol;

	/**
	 * CONSTRUCTOR
	 */
	public Reservation() {
		super();
	}

	public Reservation(@NotNull String nom, @NotNull String prenom, @NotNull Integer age, Vol vol) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.vol = vol;
	}

	/**
	 * GETTERS & SETTERS
	 * 
	 * @return
	 */
	public int getIdVol() {
		return id;
	}

	public void setIdVol(int idVol) {
		this.id = idVol;
	}

	public String getNumReservation() {
		return numReservation;
	}

	public void setNumReservation(String numReservation) {
		this.numReservation = numReservation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public Integer getIdRes() {
		return id;
	}

	public void setIdRes(Integer idRes) {
		this.id = idRes;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
