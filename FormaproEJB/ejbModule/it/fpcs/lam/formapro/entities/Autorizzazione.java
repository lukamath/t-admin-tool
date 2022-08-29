package it.fpcs.lam.formapro.entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@NamedQuery(name = "Autorizzazione.checkCredentials", query = "SELECT a FROM Autorizzazione a  WHERE a.username = ?1 and a.password = ?2")
public class Autorizzazione implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Autorizzazione() {
		super();
	}
	
	@Id
	@Column(name="id_autorizzazione")
	private int idAutorizzazione;
	
	private String username;
	
	private String password;
	
	private String ruolo;
	
	//bi-directional many-to-one association to Utente
		@ManyToOne
		@JoinColumn(name="id_utente")
		private Utente utente;

	public int getIdAutorizzazione() {
		return idAutorizzazione;
	}

	public void setIdAutorizzazione(int idAutorizzazione) {
		this.idAutorizzazione = idAutorizzazione;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	
}
