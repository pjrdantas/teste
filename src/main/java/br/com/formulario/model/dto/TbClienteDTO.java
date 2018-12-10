package br.com.formulario.model.dto;

import java.math.BigDecimal;


public class TbClienteDTO {
	

	
	private int id;	
	private BigDecimal clienteLimiteCredito;
	private String clienteNome;
	private String clienteRisco;
	private String clienteTaxaJuro;
	
	public TbClienteDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getClienteLimiteCredito() {
		return clienteLimiteCredito;
	}

	public void setClienteLimiteCredito(BigDecimal clienteLimiteCredito) {
		this.clienteLimiteCredito = clienteLimiteCredito;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}

	public String getClienteRisco() {
		return clienteRisco;
	}

	public void setClienteRisco(String clienteRisco) {
		this.clienteRisco = clienteRisco;
	}

	public String getClienteTaxaJuro() {
		return clienteTaxaJuro;
	}

	public void setClienteTaxaJuro(String clienteTaxaJuro) {
		this.clienteTaxaJuro = clienteTaxaJuro;
	}

	

	
}