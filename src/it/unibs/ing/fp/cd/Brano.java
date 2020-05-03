package it.unibs.ing.fp.cd;

public class Brano {
	private String titolo;
	private int minuti;
	private int secondi;
	
	public Brano(String _titolo, int _minuti, int _secondi) {
		this.titolo = _titolo;
		this.minuti = _minuti;
		this.secondi = _secondi;
	}
	
	public String toString() {
		return "" + titolo + " [" + String.format("%02d", minuti)+ ":" + String.format("%02d", secondi) + "] ";
	}
	
	public String getTitolo() {
		return titolo;
	}
}
