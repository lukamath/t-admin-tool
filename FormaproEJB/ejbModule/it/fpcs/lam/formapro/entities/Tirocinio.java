package it.fpcs.lam.formapro.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity

public class Tirocinio implements Serializable {
	private static final long serialVersionUID = 1L;

	public Tirocinio() {
		super();
	}

	@Id
	private int id_tirocinio;
	
	private int id_iscrizione;
	
	private int id_struttura;
	
	private int esperienza;
	
	@Temporal(TemporalType.DATE)
	private Date data_inizio;
	
	@Temporal(TemporalType.DATE)
	private Date data_fine;
	
	private String stato_tirocinio;
	
	private String stato_lavorazione;
	
	//bi-directional many-to-one association to Studente
	@ManyToOne 
	@PrimaryKeyJoinColumn(name="id_iscrizione")
	private Studente studente;
	
	//bi-directional many-to-one association to Struttura
	@ManyToOne 
	@PrimaryKeyJoinColumn(name="id_struttura")
	private Struttura struttura;

	public int getId_tirocinio() {
		return id_tirocinio;
	}

	public void setId_tirocinio(int id_tirocinio) {
		this.id_tirocinio = id_tirocinio;
	}

	public int getId_iscrizione() {
		return id_iscrizione;
	}

	public void setId_iscrizione(int id_iscrizione) {
		this.id_iscrizione = id_iscrizione;
	}

	public int getId_struttura() {
		return id_struttura;
	}

	public void setId_struttura(int id_struttura) {
		this.id_struttura = id_struttura;
	}

	public int getEsperienza() {
		return esperienza;
	}

	public void setEsperienza(int esperienza) {
		this.esperienza = esperienza;
	}

	public Date getData_inizio() {
		return data_inizio;
	}

	public void setData_inizio(Date data_inizio) {
		this.data_inizio = data_inizio;
	}

	public Date getData_fine() {
		return data_fine;
	}

	public void setData_fine(Date data_fine) {
		this.data_fine = data_fine;
	}

	public String getStato_tirocinio() {
		return stato_tirocinio;
	}

	public void setStato_tirocinio(String stato_tirocinio) {
		this.stato_tirocinio = stato_tirocinio;
	}

	public String getStato_lavorazione() {
		return stato_lavorazione;
	}

	public void setStato_lavorazione(String stato_lavorazione) {
		this.stato_lavorazione = stato_lavorazione;
	}
	

	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}

	public Struttura getStruttura() {
		return struttura;
	}

	public void setStruttura(Struttura struttura) {
		this.struttura = struttura;
	}
	
	
}
