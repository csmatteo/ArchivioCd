package it.unibs.ing.fp.cd;

import java.util.ArrayList;

public class ArchivioCd {
	private ArrayList <Cd> elencoCd;
	
	public ArchivioCd() {
		this.elencoCd = new ArrayList<Cd>();
	}

	public void aggiungiCd(Cd cd) {
		this.elencoCd.add(cd);
	}
	
	public void eliminaCd(int posCd) {
		this.elencoCd.remove(posCd);
	}
	
	public Cd selezionaCd(int posCd) {
		return elencoCd.get(posCd);
	}
	
	public int getSize() {
		return this.elencoCd.size();
	}

	public int cercaPosizioneCd(String titolo) {
		int i=0;
		
		for(i=0;i<elencoCd.size();i++) {
			if(titolo.equals(elencoCd.get(i).getTitolo()))
				return i;
		}	
		
		return -1;
	}
	
	public boolean cercaCdDuplicato(String titolo) {
		int i=0;
		
		for(i=0;i<elencoCd.size();i++) {
			if(titolo.equals(elencoCd.get(i).getTitolo()))
				return true;
		}	
		
		return false;
	}

	public String toString() {
		return "ArchivioCd [elencoCd=" + elencoCd + "]";
	}
}