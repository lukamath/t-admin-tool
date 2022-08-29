package it.fpcs.lam.formapro.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the struttura database table.
 * 
 */
@Entity
@NamedQuery(name="Struttura.findAll", query="SELECT s FROM Struttura s")
public class Struttura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_struttura")
	private int idStruttura;

	@Column(name="acronimo_struttura")
	private String acronimoStruttura;

	@Column(name="cap_struttura")
	private String capStruttura;

	@Column(name="citta_struttura")
	private String cittaStruttura;

	@Column(name="indirizzo_struttura")
	private String indirizzoStruttura;

	@Column(name="nome_struttura")
	private String nomeStruttura;

	@Column(name="posti_disponibili")
	private int postiDisponibili;

	@Column(name="posti_liberi")
	private int postiLiberi;

	@Column(name="posti_occupati")
	private int postiOccupati;

	@Column(name="provincia_struttura")
	private String provinciaStruttura;

	@Column(name="tipo_struttura")
	private String tipoStruttura;

	private String valutazione;

	@Column(name="zona_classe")
	private String zonaClasse;

	@Column(name="zona_nome")
	private String zonaNome;
	
	//bi-directional one-to-many association to Tirocinio
	@OneToMany(fetch = FetchType.EAGER, mappedBy="struttura")
	private List<Tirocinio> tirocini;	

	public Struttura() {
	}

	public int getIdStruttura() {
		return this.idStruttura;
	}

	public void setIdStruttura(int idStruttura) {
		this.idStruttura = idStruttura;
	}

	public String getAcronimoStruttura() {
		return this.acronimoStruttura;
	}

	public void setAcronimoStruttura(String acronimoStruttura) {
		this.acronimoStruttura = acronimoStruttura;
	}

	public String getCapStruttura() {
		return this.capStruttura;
	}

	public void setCapStruttura(String capStruttura) {
		this.capStruttura = capStruttura;
	}

	public String getCittaStruttura() {
		return this.cittaStruttura;
	}

	public void setCittaStruttura(String cittaStruttura) {
		this.cittaStruttura = cittaStruttura;
	}

	public String getIndirizzoStruttura() {
		return this.indirizzoStruttura;
	}

	public void setIndirizzoStruttura(String indirizzoStruttura) {
		this.indirizzoStruttura = indirizzoStruttura;
	}

	public String getNomeStruttura() {
		return this.nomeStruttura;
	}

	public void setNomeStruttura(String nomeStruttura) {
		this.nomeStruttura = nomeStruttura;
	}

	public int getPostiDisponibili() {
		return this.postiDisponibili;
	}

	public void setPostiDisponibili(int postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}

	public int getPostiLiberi() {
		return this.postiLiberi;
	}

	public void setPostiLiberi(int postiLiberi) {
		this.postiLiberi = postiLiberi;
	}

	public int getPostiOccupati() {
		return this.postiOccupati;
	}

	public void setPostiOccupati(int postiOccupati) {
		this.postiOccupati = postiOccupati;
	}

	public String getProvinciaStruttura() {
		return this.provinciaStruttura;
	}

	public void setProvinciaStruttura(String provinciaStruttura) {
		this.provinciaStruttura = provinciaStruttura;
	}

	public String getTipoStruttura() {
		return this.tipoStruttura;
	}

	public void setTipoStruttura(String tipoStruttura) {
		this.tipoStruttura = tipoStruttura;
	}

	public String getValutazione() {
		return this.valutazione;
	}

	public void setValutazione(String valutazione) {
		this.valutazione = valutazione;
	}

	public String getZonaClasse() {
		return this.zonaClasse;
	}

	public void setZonaClasse(String zonaClasse) {
		this.zonaClasse = zonaClasse;
	}

	public String getZonaNome() {
		return this.zonaNome;
	}

	public void setZonaNome(String zonaNome) {
		this.zonaNome = zonaNome;
	}

}