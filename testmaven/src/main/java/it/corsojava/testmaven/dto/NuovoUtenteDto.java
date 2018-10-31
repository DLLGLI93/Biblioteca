package it.corsojava.testmaven.dto;

public class NuovoUtenteDto {
private String nome;
private String cognome;
private String cf;

private String username;
private String psw;
private String email;

private String domanda;
private String risposta;
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}
public String getCf() {
	return cf;
}
public void setCf(String cf) {
	this.cf = cf;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPsw() {
	return psw;
}
public void setPsw(String psw) {
	this.psw = psw;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getDomanda() {
	return domanda;
}
public void setDomanda(String domanda) {
	this.domanda = domanda;
}
public String getRisposta() {
	return risposta;
}
public void setRisposta(String risposta) {
	this.risposta = risposta;
}


}
