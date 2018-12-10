package br.com.formulario.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the tb_cliente database table.
 * 
 */
@Entity
@Table(name="tb_cliente")
public class TbCliente {
	

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="tb_cliente_limite_credito", nullable=false, precision=10)
	private BigDecimal tbClienteLimiteCredito;

	@Column(name="tb_cliente_nome", nullable=false, length=45)
	private String tbClienteNome;

	@Column(name="tb_cliente_risco", nullable=false, length=1)
	private String tbClienteRisco;

	@Column(name="tb_cliente_taxa_juro", nullable=false, length=45)
	private String tbClienteTaxaJuro;

	public TbCliente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getTbClienteLimiteCredito() {
		return this.tbClienteLimiteCredito;
	}

	public void setTbClienteLimiteCredito(BigDecimal tbClienteLimiteCredito) {
		this.tbClienteLimiteCredito = tbClienteLimiteCredito;
	}

	public String getTbClienteNome() {
		return this.tbClienteNome;
	}

	public void setTbClienteNome(String tbClienteNome) {
		this.tbClienteNome = tbClienteNome;
	}

	public String getTbClienteRisco() {
		return this.tbClienteRisco;
	}

	public void setTbClienteRisco(String tbClienteRisco) {
		this.tbClienteRisco = tbClienteRisco;
	}

	public String getTbClienteTaxaJuro() {
		return this.tbClienteTaxaJuro;
	}

	public void setTbClienteTaxaJuro(String tbClienteTaxaJuro) {
		this.tbClienteTaxaJuro = tbClienteTaxaJuro;
	}

}