package br.com.perfilcar.perfil.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "perfis")
public class Perfil implements Serializable{

	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String apelido;
    private String marca;
    private String modelo;
    private String quilometragemAtual;
    private String anoFabricacao;
    private String anoModelo;
    private String nomeProprietario;
    private String informacoesAdicionais;
    private String timestamp;
    private String emailProprietario;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getQuilometragemAtual() {
		return quilometragemAtual;
	}
	public void setQuilometragemAtual(String quilometragemAtual) {
		this.quilometragemAtual = quilometragemAtual;
	}
	public String getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public String getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}
	
	public String getInformacoesAdicionais() {
		return informacoesAdicionais;
	}
	public void setInformacoesAdicionais(String informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}
	public String getEmailProprietario() {
		return emailProprietario;
	}
	public void setEmailProprietario(String emailProprietario) {
		this.emailProprietario = emailProprietario;
	}
  
}