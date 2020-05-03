package it.unibs.ing.fp.cd;

import java.util.ArrayList;

public class Cd {
	private String titolo;
	private String autore;
	private ArrayList <Brano> elencoBrani;
	
	public Cd(String _titolo, String _autore) {
		this.titolo = _titolo;
		this.autore = _autore;
		this.elencoBrani = new ArrayList <Brano>();
	}
	
	public void aggiungiBrano(Brano b) {
		this.elencoBrani.add(b);
	}
	
	public Brano selezionaBrano(int posBrano) {
		return elencoBrani.get(posBrano);
	}
	
	public int getSize() {
		return this.elencoBrani.size();
	}

	public String toString() {
		StringBuilder stampa = new StringBuilder();
		stampa.append("Titolo: " + titolo + ", Autore: " + autore + ", Lista dei brani: ");
		
		for(int i=0;i<elencoBrani.size();i++)
			stampa.append(elencoBrani.get(i));
		
		return stampa.toString();
	}
	
	public String getTitolo() {
		return titolo;
	}
}
