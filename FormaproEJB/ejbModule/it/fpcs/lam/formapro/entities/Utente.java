package it.fpcs.lam.formapro.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@NamedQuery(name="Utente.findAll", query="SELECT u FROM Utente u")
//@NamedQuery(name = "Utente.checkCredentials", query = "SELECT r FROM Utente r  WHERE r.username = ?1 and r.password = ?2")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_utente")
	private int idUtente;

	private String codicefiscale;

	private String cognome;

	private String nome;
	
	//bi-directional one-to-many association to Autorizzazione
	@OneToMany(mappedBy="utente")
	private List<Autorizzazione> autorizzazioni;

	//bi-directional many-to-one association to AnagraficaUtente
	@OneToMany(mappedBy="utente")
	private List<AnagraficaUtente> anagraficaUtentes;

	public Utente() {
	}

	public int getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getCodicefiscale() {
		return this.codicefiscale;
	}

	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<AnagraficaUtente> getAnagraficaUtentes() {
		return this.anagraficaUtentes;
	}

	public void setAnagraficaUtentes(List<AnagraficaUtente> anagraficaUtentes) {
		this.anagraficaUtentes = anagraficaUtentes;
	}

	public AnagraficaUtente addAnagraficaUtente(AnagraficaUtente anagraficaUtente) {
		getAnagraficaUtentes().add(anagraficaUtente);
		anagraficaUtente.setUtente(this);

		return anagraficaUtente;
	}

	public AnagraficaUtente removeAnagraficaUtente(AnagraficaUtente anagraficaUtente) {
		getAnagraficaUtentes().remove(anagraficaUtente);
		anagraficaUtente.setUtente(null);

		return anagraficaUtente;
	}

}