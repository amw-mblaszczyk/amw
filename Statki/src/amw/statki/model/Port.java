package amw.statki.model;
// Generated Jul 15, 2019 1:41:18 PM by Hibernate Tools 5.1.7.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Port generated by hbm2java
 */
@Entity
@Table(name = "Port", schema = "dbo", catalog = "Statki")
public class Port implements java.io.Serializable {

	private Integer id;
	private String nazwa;
	private String skrot;
	private double la;
	private double fi;
	private Set<TransportTowaru> transportTowarus = new HashSet<TransportTowaru>(0);
	private Set<Towar> towars = new HashSet<Towar>(0);
	private Set<Rejs> rejsesForPortCelId = new HashSet<Rejs>(0);
	private Set<Rejs> rejsesForPortPoczId = new HashSet<Rejs>(0);

	public Port() {
	}

	public Port(String nazwa, String skrot, double la, double fi) {
		this.nazwa = nazwa;
		this.skrot = skrot;
		this.la = la;
		this.fi = fi;
	}

	public Port(String nazwa, String skrot, double la, double fi, Set<TransportTowaru> transportTowarus,
			Set<Towar> towars, Set<Rejs> rejsesForPortCelId, Set<Rejs> rejsesForPortPoczId) {
		this.nazwa = nazwa;
		this.skrot = skrot;
		this.la = la;
		this.fi = fi;
		this.transportTowarus = transportTowarus;
		this.towars = towars;
		this.rejsesForPortCelId = rejsesForPortCelId;
		this.rejsesForPortPoczId = rejsesForPortPoczId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nazwa", nullable = false, length = 25)
	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	@Column(name = "skrot", nullable = false, length = 5)
	public String getSkrot() {
		return this.skrot;
	}

	public void setSkrot(String skrot) {
		this.skrot = skrot;
	}

	@Column(name = "la", nullable = false, precision = 53, scale = 0)
	public double getLa() {
		return this.la;
	}

	public void setLa(double la) {
		this.la = la;
	}

	@Column(name = "fi", nullable = false, precision = 53, scale = 0)
	public double getFi() {
		return this.fi;
	}

	public void setFi(double fi) {
		this.fi = fi;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "port")
	public Set<TransportTowaru> getTransportTowarus() {
		return this.transportTowarus;
	}

	public void setTransportTowarus(Set<TransportTowaru> transportTowarus) {
		this.transportTowarus = transportTowarus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "port")
	public Set<Towar> getTowars() {
		return this.towars;
	}

	public void setTowars(Set<Towar> towars) {
		this.towars = towars;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "portByPortCelId")
	public Set<Rejs> getRejsesForPortCelId() {
		return this.rejsesForPortCelId;
	}

	public void setRejsesForPortCelId(Set<Rejs> rejsesForPortCelId) {
		this.rejsesForPortCelId = rejsesForPortCelId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "portByPortPoczId")
	public Set<Rejs> getRejsesForPortPoczId() {
		return this.rejsesForPortPoczId;
	}

	public void setRejsesForPortPoczId(Set<Rejs> rejsesForPortPoczId) {
		this.rejsesForPortPoczId = rejsesForPortPoczId;
	}

	@Override
	public String toString() {
		return "Port [id=" + id + ", nazwa=" + nazwa + ", skrot=" + skrot + ", la=" + la + ", fi=" + fi + "]";
	}
	
	

}
