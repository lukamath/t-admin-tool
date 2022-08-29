package it.fpcs.lam.formapro.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@NamedQuery(name="Edizione.findAll", query="SELECT e FROM Edizione e")
//@NamedQuery(name = "Edizione.findEditionDetailsById", query = "SELECT e FROM Edizione e WHERE e.id_edizione = :id_e")
public class Edizione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_edizione")
	private int idEdizione;

	@Column(name="anno_edizione")
	private int annoEdizione;

	@Temporal(TemporalType.DATE)
	@Column(name="data_esame")
	private Date dataEsame;

	@Temporal(TemporalType.DATE)
	@Column(name="data_fine")
	private Date dataFine;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inizio")
	private Date dataInizio;

	@Column(name="id_billing_corso")
	private int idBillingCorso;

	@Column(name="id_corso")
	private int idCorso;

	private String orario;
	
	//bi-directional one-to-many association to Studente
	@OneToMany(fetch = FetchType.EAGER, mappedBy="edizione")
	private List<Studente> studenti;	
	
	//bi-directional many-to-one association to Corso
	@ManyToOne 
	@PrimaryKeyJoinColumn(name="id_corso")
	private Corso corso;

	public Edizione() {
	}

	public int getIdEdizione() {
		return this.idEdizione;
	}

	public void setIdEdizione(int idEdizione) {
		this.idEdizione = idEdizione;
	}

	public int getAnnoEdizione() {
		return this.annoEdizione;
	}

	public void setAnnoEdizione(int annoEdizione) {
		this.annoEdizione = annoEdizione;
	}

	public Date getDataEsame() {
		return this.dataEsame;
	}

	public void setDataEsame(Date dataEsame) {
		this.dataEsame = dataEsame;
	}

	public Date getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Date getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public int getIdBillingCorso() {
		return this.idBillingCorso;
	}

	public void setIdBillingCorso(int idBillingCorso) {
		this.idBillingCorso = idBillingCorso;
	}

	public int getIdCorso() {
		return this.idCorso;
	}

	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}

	public String getOrario() {
		return this.orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}

	public List<Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Studente> studenti) {
		this.studenti = studenti;
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

}