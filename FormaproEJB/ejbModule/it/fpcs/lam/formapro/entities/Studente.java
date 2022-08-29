package it.fpcs.lam.formapro.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@NamedQuery(name="Studente.findAll", query="SELECT s FROM Studente s")
public class Studente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_iscrizione;
	
	private int id_utente;
	
	private int id_edizione;
	
	private int id_registro;
	
	private String cognome;

	private String nome;
	
	private String codicefiscale;
	
	private String sesso;
	
	private String tipo_corso;
	
	private String status_iscrizione;
	
	private String status_pagamenti;
	
	private String nazione_nascita;
	
	private String cittadinanza;
	
	//bi-directional many-to-one association to Edizione
	@ManyToOne 
	@PrimaryKeyJoinColumn(name="id_edizione")
	private Edizione edizione;

	//bi-directional one-to-many association to Tirocinio
	@OneToMany(fetch = FetchType.EAGER, mappedBy="studente")
	private List<Tirocinio> tirocini;	
	
	public int getId_iscrizione() {
		return id_iscrizione;
	}

	public void setId_iscrizione(int id_iscrizione) {
		this.id_iscrizione = id_iscrizione;
	}

	public int getId_utente() {
		return id_utente;
	}

	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}

	public int getId_edizione() {
		return id_edizione;
	}

	public void setId_edizione(int id_edizione) {
		this.id_edizione = id_edizione;
	}

	public int getId_registro() {
		return id_registro;
	}

	public void setId_registro(int id_registro) {
		this.id_registro = id_registro;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodicefiscale() {
		return codicefiscale;
	}

	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getTipo_corso() {
		return tipo_corso;
	}

	public void setTipo_corso(String tipo_corso) {
		this.tipo_corso = tipo_corso;
	}

	public String getStatus_iscrizione() {
		return status_iscrizione;
	}

	public void setStatus_iscrizione(String status_iscrizione) {
		this.status_iscrizione = status_iscrizione;
	}

	public String getStatus_pagamenti() {
		return status_pagamenti;
	}

	public void setStatus_pagamenti(String status_pagamenti) {
		this.status_pagamenti = status_pagamenti;
	}

	public String getNazione_nascita() {
		return nazione_nascita;
	}

	public void setNazione_nascita(String nazione_nascita) {
		this.nazione_nascita = nazione_nascita;
	}

	public String getCittadinanza() {
		return cittadinanza;
	}

	public void setCittadinanza(String cittadinanza) {
		this.cittadinanza = cittadinanza;
	}

	public Edizione getEdizione() {
		return edizione;
	}

	public void setEdizione(Edizione edizione) {
		this.edizione = edizione;
	}

	public List<Tirocinio> getTirocini() {
		return tirocini;
	}

	public void setTirocini(List<Tirocinio> tirocini) {
		this.tirocini = tirocini;
	}
	
}
