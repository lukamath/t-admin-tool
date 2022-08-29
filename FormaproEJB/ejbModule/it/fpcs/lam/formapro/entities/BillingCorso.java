package it.fpcs.lam.formapro.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the billing_corso database table.
 * 
 */
@Entity
@Table(name="billing_corso")
@NamedQuery(name="BillingCorso.findAll", query="SELECT b FROM BillingCorso b")
public class BillingCorso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_billing_corso")
	private int idBillingCorso;

	@Column(name="costo_corso")
	private BigDecimal costoCorso;

	@Column(name="costo_inziocorso")
	private BigDecimal costoInziocorso;

	@Column(name="costo_iscrizione")
	private BigDecimal costoIscrizione;

	@Column(name="costo_kit")
	private BigDecimal costoKit;

	@Column(name="costo_rata")
	private BigDecimal costoRata;

	@Column(name="numero_rate")
	private int numeroRate;

	//bi-directional many-to-one association to Corso
	@ManyToOne
	@JoinColumn(name="id_corso")
	private Corso corso;

	public BillingCorso() {
	}

	public int getIdBillingCorso() {
		return this.idBillingCorso;
	}

	public void setIdBillingCorso(int idBillingCorso) {
		this.idBillingCorso = idBillingCorso;
	}

	public BigDecimal getCostoCorso() {
		return this.costoCorso;
	}

	public void setCostoCorso(BigDecimal costoCorso) {
		this.costoCorso = costoCorso;
	}

	public BigDecimal getCostoInziocorso() {
		return this.costoInziocorso;
	}

	public void setCostoInziocorso(BigDecimal costoInziocorso) {
		this.costoInziocorso = costoInziocorso;
	}

	public BigDecimal getCostoIscrizione() {
		return this.costoIscrizione;
	}

	public void setCostoIscrizione(BigDecimal costoIscrizione) {
		this.costoIscrizione = costoIscrizione;
	}

	public BigDecimal getCostoKit() {
		return this.costoKit;
	}

	public void setCostoKit(BigDecimal costoKit) {
		this.costoKit = costoKit;
	}

	public BigDecimal getCostoRata() {
		return this.costoRata;
	}

	public void setCostoRata(BigDecimal costoRata) {
		this.costoRata = costoRata;
	}

	public int getNumeroRate() {
		return this.numeroRate;
	}

	public void setNumeroRate(int numeroRate) {
		this.numeroRate = numeroRate;
	}

	public Corso getCorso() {
		return this.corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

}