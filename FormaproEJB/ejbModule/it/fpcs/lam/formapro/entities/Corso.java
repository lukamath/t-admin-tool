package it.fpcs.lam.formapro.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the corso database table.
 * 
 */
@Entity
@NamedQuery(name="Corso.findAll", query="SELECT c FROM Corso c")
public class Corso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_corso")
	private int idCorso;

	@Column(name="nome_corso")
	private String nomeCorso;

	@Column(name="ore_corso")
	private int oreCorso;

	@Column(name="ore_lezione_corso")
	private int oreLezioneCorso;

	@Column(name="ore_tirocinio_corso")
	private int oreTirocinioCorso;

	@Column(name="tipo_corso")
	private String tipoCorso;

	//bi-directional many-to-one association to BillingCorso
	@OneToMany(mappedBy="corso")
	private List<BillingCorso> billingCorsos;
	
	//bi-directional many-to-one association to BillingCorso
	@OneToMany(mappedBy="corso")
	private List<Edizione> edizioni;
		
	public Corso() {
	}

	public int getIdCorso() {
		return this.idCorso;
	}

	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}

	public String getNomeCorso() {
		return this.nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public int getOreCorso() {
		return this.oreCorso;
	}

	public void setOreCorso(int oreCorso) {
		this.oreCorso = oreCorso;
	}

	public int getOreLezioneCorso() {
		return this.oreLezioneCorso;
	}

	public void setOreLezioneCorso(int oreLezioneCorso) {
		this.oreLezioneCorso = oreLezioneCorso;
	}

	public int getOreTirocinioCorso() {
		return this.oreTirocinioCorso;
	}

	public void setOreTirocinioCorso(int oreTirocinioCorso) {
		this.oreTirocinioCorso = oreTirocinioCorso;
	}

	public String getTipoCorso() {
		return this.tipoCorso;
	}

	public void setTipoCorso(String tipoCorso) {
		this.tipoCorso = tipoCorso;
	}

	public List<BillingCorso> getBillingCorsos() {
		return this.billingCorsos;
	}

	public void setBillingCorsos(List<BillingCorso> billingCorsos) {
		this.billingCorsos = billingCorsos;
	}

	public BillingCorso addBillingCorso(BillingCorso billingCorso) {
		getBillingCorsos().add(billingCorso);
		billingCorso.setCorso(this);

		return billingCorso;
	}

	public BillingCorso removeBillingCorso(BillingCorso billingCorso) {
		getBillingCorsos().remove(billingCorso);
		billingCorso.setCorso(null);

		return billingCorso;
	}

	public List<Edizione> getEdizioni() {
		return edizioni;
	}

	public void setEdizioni(List<Edizione> edizioni) {
		this.edizioni = edizioni;
	}

}