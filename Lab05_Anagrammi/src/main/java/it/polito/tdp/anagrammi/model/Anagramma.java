package it.polito.tdp.anagrammi.model;

public class Anagramma {
	
	

	private String parola;
	private boolean corretta;
	
	public Anagramma(String parola, boolean corretta) {
		
		this.parola = parola;
		this.corretta = corretta;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public boolean isCorretta() {
		return corretta;
	}

	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}
	
	
	
}
