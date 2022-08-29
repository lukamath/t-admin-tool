package it.fpcs.lam.formapro.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the iscrizione database table.
 * 
 */
@Embeddable
public class IscrizionePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_iscrizione")
	private int idIscrizione;

	@Column(name="id_studente")
	private int idStudente;

	public IscrizionePK() {
	}
	public int getIdIscrizione() {
		return this.idIscrizione;
	}
	public void setIdIscrizione(int idIscrizione) {
		this.idIscrizione = idIscrizione;
	}
	public int getIdStudente() {
		return this.idStudente;
	}
	public void setIdStudente(int idStudente) {
		this.idStudente = idStudente;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof IscrizionePK)) {
			return false;
		}
		IscrizionePK castOther = (IscrizionePK)other;
		return 
			(this.idIscrizione == castOther.idIscrizione)
			&& (this.idStudente == castOther.idStudente);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idIscrizione;
		hash = hash * prime + this.idStudente;
		
		return hash;
	}
}