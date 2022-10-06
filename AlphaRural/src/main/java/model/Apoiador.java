package model;

public class Apoiador{
	private int id_Apoiador;
	private String dataNasc;
	private String nome;
	private String telefone;
	private String tipoDoacao;
	private String telContato;
	private String email;
	
	public int getId_Apoiador() {
		return id_Apoiador; 
	}
	public void setId_Apoiador(int id_Apoiador) {
		this.id_Apoiador = id_Apoiador;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTipoDoacao() {
		return tipoDoacao;
	}
	public void setTipoDoacao(String tipoDoacao) {
		this.tipoDoacao = tipoDoacao;
	}
	public String getTelContato() {
		return telContato;
	}
	public void setTelContato(String telContato) {
		this.telContato = telContato;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	

}
