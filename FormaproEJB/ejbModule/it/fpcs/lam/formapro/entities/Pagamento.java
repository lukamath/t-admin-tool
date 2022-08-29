package it.fpcs.lam.formapro.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the pagamento database table.
 * 
 */
@Entity
@NamedQuery(name="Pagamento.findAll", query="SELECT p FROM Pagamento p")
public class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pagamento")
	private int idPagamento;

	private String accontosaldo;

	@Temporal(TemporalType.DATE)
	@Column(name="data_pagamento")
	private Date dataPagamento;

	@Column(name="descrizione_pagamento")
	private String descrizionePagamento;

	@Column(name="descrizione_sconto")
	private String descrizioneSconto;

	private String fattura;

	@Column(name="id_iscrizione")
	private int idIscrizione;

	@Column(name="metodo_pagamento")
	private String metodoPagamento;

	@Column(name="quota_pagamento")
	private BigDecimal quotaPagamento;

	@Column(name="quota_sconto")
	private BigDecimal quotaSconto;

	public Pagamento() {
	}

	public int getIdPagamento() {
		return this.idPagamento;
	}

	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}

	public String getAccontosaldo() {
		return this.accontosaldo;
	}

	public void setAccontosaldo(String accontosaldo) {
		this.accontosaldo = accontosaldo;
	}

	public Date getDataPagamento() {
		return this.dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getDescrizionePagamento() {
		return this.descrizionePagamento;
	}

	public void setDescrizionePagamento(String descrizionePagamento) {
		this.descrizionePagamento = descrizionePagamento;
	}

	public String getDescrizioneSconto() {
		return this.descrizioneSconto;
	}

	public void setDescrizioneSconto(String descrizioneSconto) {
		this.descrizioneSconto = descrizioneSconto;
	}

	public String getFattura() {
		return this.fattura;
	}

	public void setFattura(String fattura) {
		this.fattura = fattura;
	}

	public int getIdIscrizione() {
		return this.idIscrizione;
	}

	public void setIdIscrizione(int idIscrizione) {
		this.idIscrizione = idIscrizione;
	}

	public String getMetodoPagamento() {
		return this.metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public BigDecimal getQuotaPagamento() {
		return this.quotaPagamento;
	}

	public void setQuotaPagamento(BigDecimal quotaPagamento) {
		this.quotaPagamento = quotaPagamento;
	}

	public BigDecimal getQuotaSconto() {
		return this.quotaSconto;
	}

	public void setQuotaSconto(BigDecimal quotaSconto) {
		this.quotaSconto = quotaSconto;
	}

}