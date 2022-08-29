package it.fpcs.lam.formapro.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the anagrafica_utente database table.
 * 
 */
@Entity
@Table(name="anagrafica_utente")
@NamedQuery(name="AnagraficaUtente.findAll", query="SELECT a FROM AnagraficaUtente a")
public class AnagraficaUtente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_anagrafica")
	private int idAnagrafica;

	private String cittadinanza;

	@Column(name="indirizzo_cap")
	private String indirizzoCap;

	@Column(name="indirizzo_citta")
	private String indirizzoCitta;

	@Column(name="indirizzo_nome")
	private String indirizzoNome;

	@Column(name="indirizzo_numero")
	private String indirizzoNumero;

	@Column(name="indirizzo_particella")
	private String indirizzoParticella;

	@Column(name="indirizzo_provincia")
	private String indirizzoProvincia;

	@Column(name="nazione_nascita")
	private String nazioneNascita;

	@Column(name="numero_telefono1")
	private String numeroTelefono1;

	@Column(name="numero_telefono2")
	private String numeroTelefono2;

	@Column(name="numero_telefono3")
	private String numeroTelefono3;

	private String sesso;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="id_utente")
	private Utente utente;

	public AnagraficaUtente() {
	}

	public int getIdAnagrafica() {
		return this.idAnagrafica;
	}

	public void setIdAnagrafica(int idAnagrafica) {
		this.idAnagrafica = idAnagrafica;
	}

	public String getCittadinanza() {
		return this.cittadinanza;
	}

	public void setCittadinanza(String cittadinanza) {
		this.cittadinanza = cittadinanza;
	}

	public String getIndirizzoCap() {
		return this.indirizzoCap;
	}

	public void setIndirizzoCap(String indirizzoCap) {
		this.indirizzoCap = indirizzoCap;
	}

	public String getIndirizzoCitta() {
		return this.indirizzoCitta;
	}

	public void setIndirizzoCitta(String indirizzoCitta) {
		this.indirizzoCitta = indirizzoCitta;
	}

	public String getIndirizzoNome() {
		return this.indirizzoNome;
	}

	public void setIndirizzoNome(String indirizzoNome) {
		this.indirizzoNome = indirizzoNome;
	}

	public String getIndirizzoNumero() {
		return this.indirizzoNumero;
	}

	public void setIndirizzoNumero(String indirizzoNumero) {
		this.indirizzoNumero = indirizzoNumero;
	}

	public String getIndirizzoParticella() {
		return this.indirizzoParticella;
	}

	public void setIndirizzoParticella(String indirizzoParticella) {
		this.indirizzoParticella = indirizzoParticella;
	}

	public String getIndirizzoProvincia() {
		return this.indirizzoProvincia;
	}

	public void setIndirizzoProvincia(String indirizzoProvincia) {
		this.indirizzoProvincia = indirizzoProvincia;
	}

	public String getNazioneNascita() {
		return this.nazioneNascita;
	}

	public void setNazioneNascita(String nazioneNascita) {
		this.nazioneNascita = nazioneNascita;
	}

	public String getNumeroTelefono1() {
		return this.numeroTelefono1;
	}

	public void setNumeroTelefono1(String numeroTelefono1) {
		this.numeroTelefono1 = numeroTelefono1;
	}

	public String getNumeroTelefono2() {
		return this.numeroTelefono2;
	}

	public void setNumeroTelefono2(String numeroTelefono2) {
		this.numeroTelefono2 = numeroTelefono2;
	}

	public String getNumeroTelefono3() {
		return this.numeroTelefono3;
	}

	public void setNumeroTelefono3(String numeroTelefono3) {
		this.numeroTelefono3 = numeroTelefono3;
	}

	public String getSesso() {
		return this.sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}