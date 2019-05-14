package br.com.senac.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.OneToOne;

@Entity
public class OrdemServico implements Serializable{

	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY) 
private Long id;


@OneToOne(mappedBy="OrdemServico")
private Usuario usuario;

private Date dataDeAbertura;

private Date dataDeFechamento;

@Column (length=300)
private String descricao;

@Column (length=300)
private String registroFotografico;

@Column (length=300)
private String latitudeFotografica;

@Column (length=300)
private String longitudeFotografica;

@Column (length=300)
private String contratista;

@Column (length=300)
private String status;


@OneToMany(mappedBy="OrdemServico")//mapeando a ordem de servico dentro da classe recurso
private Set<Recurso> Recurso;


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public Usuario getUsuario() {
	return usuario;
}


public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}


public Date getDataDeAbertura() {
	return dataDeAbertura;
}


public void setDataDeAbertura(Date dataDeAbertura) {
	this.dataDeAbertura = dataDeAbertura;
}


public Date getDataDeFechamento() {
	return dataDeFechamento;
}


public void setDataDeFechamento(Date dataDeFechamento) {
	this.dataDeFechamento = dataDeFechamento;
}


public String getDescricao() {
	return descricao;
}


public void setDescricao(String descricao) {
	this.descricao = descricao;
}


public String getRegistroFotografico() {
	return registroFotografico;
}


public void setRegistroFotografico(String registroFotografico) {
	this.registroFotografico = registroFotografico;
}


public String getLatitudeFotografica() {
	return latitudeFotografica;
}


public void setLatitudeFotografica(String latitudeFotografica) {
	this.latitudeFotografica = latitudeFotografica;
}


public String getLongitudeFotografica() {
	return longitudeFotografica;
}


public void setLongitudeFotografica(String longitudeFotografica) {
	this.longitudeFotografica = longitudeFotografica;
}


public String getContratista() {
	return contratista;
}


public void setContratista(String contratista) {
	this.contratista = contratista;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}


public Set<Recurso> getRecurso() {
	return Recurso;
}


public void setRecurso(Set<Recurso> recurso) {
	Recurso = recurso;
}

//@OneToMany (mappedBy="recurso")
//private List<Recurso> recursos;

//private boolean fechada; //banco de dados em boolean




//public List<Recurso> getRecursos() {
//	return recursos;
//}
//
//public void setRecursos(List<Recurso> recursos) {
//	this.recursos = recursos;
//}




}
