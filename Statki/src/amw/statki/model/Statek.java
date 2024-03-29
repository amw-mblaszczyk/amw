package amw.statki.model;
// Generated Jul 15, 2019 1:41:18 PM by Hibernate Tools 5.1.7.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Statek generated by hbm2java
 */
@Entity
@Table(name = "Statek", schema = "dbo", catalog = "Statki")
public class Statek implements java.io.Serializable {

	private int id;
	private String nazwa;
	private String klasa;
	private String opis;
	private String bandera;
	private Set<TransportTowaru> transportTowarusForPortCelId = new HashSet<TransportTowaru>(0);
	private Set<TransportTowaru> transportTowarusForStatekId = new HashSet<TransportTowaru>(0);
	private Set<Rejs> rejses = new HashSet<Rejs>(0);
	private Set<Towar> towars = new HashSet<Towar>(0);

	public Statek() {
	}

	public Statek(int id, String nazwa) {
		this.id = id;
		this.nazwa = nazwa;
	}

	public Statek(int id, String nazwa, String klasa, String opis, String bandera,
			Set<TransportTowaru> transportTowarusForPortCelId, Set<TransportTowaru> transportTowarusForStatekId,
			Set<Rejs> rejses, Set<Towar> towars) {
		this.id = id;
		this.nazwa = nazwa;
		this.klasa = klasa;
		this.opis = opis;
		this.bandera = bandera;
		this.transportTowarusForPortCelId = transportTowarusForPortCelId;
		this.transportTowarusForStatekId = transportTowarusForStatekId;
		this.rejses = rejses;
		this.towars = towars;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nazwa", nullable = false, length = 20)
	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	@Column(name = "klasa", length = 20)
	public String getKlasa() {
		return this.klasa;
	}

	public void setKlasa(String klasa) {
		this.klasa = klasa;
	}

	@Column(name = "opis", length = 150)
	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@Column(name = "bandera", length = 4)
	public String getBandera() {
		return this.bandera;
	}

	public void setBandera(String bandera) {
		this.bandera = bandera;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statekByPortCelId")
	public Set<TransportTowaru> getTransportTowarusForPortCelId() {
		return this.transportTowarusForPortCelId;
	}

	public void setTransportTowarusForPortCelId(Set<TransportTowaru> transportTowarusForPortCelId) {
		this.transportTowarusForPortCelId = transportTowarusForPortCelId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statekByStatekId")
	public Set<TransportTowaru> getTransportTowarusForStatekId() {
		return this.transportTowarusForStatekId;
	}

	public void setTransportTowarusForStatekId(Set<TransportTowaru> transportTowarusForStatekId) {
		this.transportTowarusForStatekId = transportTowarusForStatekId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statek")
	public Set<Rejs> getRejses() {
		return this.rejses;
	}

	public void setRejses(Set<Rejs> rejses) {
		this.rejses = rejses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statek")
	public Set<Towar> getTowars() {
		return this.towars;
	}

	public void setTowars(Set<Towar> towars) {
		this.towars = towars;
	}

}
