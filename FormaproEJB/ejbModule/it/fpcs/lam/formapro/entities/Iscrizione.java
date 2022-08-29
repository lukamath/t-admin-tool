package it.fpcs.lam.formapro.entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@NamedQuery(name="Iscrizione.findAll", query="SELECT i FROM Iscrizione i")
public class Iscrizione implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IscrizionePK id;

	@Column(name="id_edizione")
	private int idEdizione;

	@Column(name="id_utente")
	private int idUtente;
	
	@Column(name="id_registro")
	private int idRegistro;

	@Column(name="status_iscrizione")
	private String statusIscrizione;

	public Iscrizione() {
	}

	public IscrizionePK getId() {
		return this.id;
	}

	public void setId(IscrizionePK id) {
		this.id = id;
	}

	public int getIdEdizione() {
		return this.idEdizione;
	}

	public void setIdEdizione(int idEdizione) {
		this.idEdizione = idEdizione;
	}

	public int getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public int getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}

	public String getStatusIscrizione() {
		return this.statusIscrizione;
	}

	public void setStatusIscrizione(String statusIscrizione) {
		this.statusIscrizione = statusIscrizione;
	}

}