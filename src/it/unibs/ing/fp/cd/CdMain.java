package it.unibs.ing.fp.cd;

import it.unibs.fp.mylib.*;

public class CdMain {
	private static final String CD_DUPLICATO = "Attenzione: CD duplicato.";
	private static final String CONFERMA_ELIMINAZIONE = "Sei sicuro di voler eliminare il CD dall'archivio?";
	private static final String NON_TROVATO = "Elemento non trovato.";
	private static final String SCELTA_ERRATA = "Attenzione: scelta errata.";
	private static final String CD="CD";
	private static final String BRANO="brano";
	private static final String ARCHIVIO_CD="ARCHIVIO CD";
	private static final String INSERISCI_CD="Inserisci un CD: ";
	private static final String ELIMINA_CD="Elimina un CD:";
	private static final String VISUALIZZA_CD="Visualizza un CD: ";
	private final static String VISUALIZZA_ARCHIVIO_CD="Visualizza tutti i CD: ";
	private final static String SELEZIONE_CASUALE="Seleziona casualmente un brano:";
	private final static String CONTINUARE="Vuoi aggiungere un'altro brano?(S=Sì;N=No): ";
	private static final String [] SCELTA_AZIONE= {INSERISCI_CD,VISUALIZZA_CD,ELIMINA_CD,VISUALIZZA_ARCHIVIO_CD,SELEZIONE_CASUALE}; 
	
	public static void main(String[] args) {
		
		int azione=0;
		ArchivioCd archivio = creaArchivioCd();
		
		MyMenu menuCD =new MyMenu(ARCHIVIO_CD,SCELTA_AZIONE);
		do {
			azione=menuCD.scegli();
			
			switch(azione) {
			
				case 1: 
					inserisciCd(archivio);
					break;
					
					
				case 2:
					visualizzaCd(archivio);
					break;
					
				case 3:
					eliminaCd(archivio);
					break;
			
				case 4: 
					System.out.println(archivio.toString());
					break;
			
				case 5:
					estraiBrano(archivio);
					break;
			
				case 0:
					break;
					
				default:
					System.out.println(SCELTA_ERRATA);
					break;
			
			}
			
		}while(azione!=0);
	}

	private static void eliminaCd(ArchivioCd archivio) {
		int pos= cercaCd(archivio);
		
		if(pos>=0) {
			char risposta=ArchivioCdUtils.leggiRisposta(CONFERMA_ELIMINAZIONE);
			if(risposta=='S') {
				archivio.eliminaCd(pos);
			}
		}
		else
			System.out.println(NON_TROVATO);
	}

	private static void visualizzaCd(ArchivioCd archivio) {
		int pos = cercaCd(archivio);
		
		if(pos>=0)
			System.out.println(archivio.selezionaCd(pos).toString());
		else
			System.out.println(NON_TROVATO);
	}

	private static int cercaCd(ArchivioCd archivio) {
		String titolo=ArchivioCdUtils.leggiTitolo(CD);
		int pos=archivio.cercaPosizioneCd(titolo);
		return pos;
	}

	private static void inserisciCd(ArchivioCd archivio) {
		Cd cd=creaCd();
		boolean accettabile=false;
		
		do{
			accettabile=archivio.cercaCdDuplicato(cd.getTitolo());
			
			if(accettabile) {
				System.out.println(CD_DUPLICATO);
				cd=creaCd();
			}
			
		}while(accettabile);
		
		archivio.aggiungiCd(cd);
		
		boolean finito=false;
		do {
			Brano brano=creaBrano();
			cd.aggiungiBrano(brano);
			char risposta=ArchivioCdUtils.leggiRisposta(CONTINUARE);
			if(risposta=='S')
				finito=true;
			else
				finito=false;
		}while(finito);
	}

	private static void estraiBrano(ArchivioCd archivio) {
		int pos=ArchivioCdUtils.estraiInt(archivio.getSize());
		Cd cd1=archivio.selezionaCd(pos);
		
		pos=ArchivioCdUtils.estraiInt(cd1.getSize());
		Brano b1=cd1.selezionaBrano(pos);
		
		b1.toString();
	}
	
	private static ArchivioCd creaArchivioCd(){
		ArchivioCd archivio = new ArchivioCd();
		return archivio;
	}


	private static Brano creaBrano() {
		String titolo=ArchivioCdUtils.leggiTitolo(BRANO);
		int minuti=ArchivioCdUtils.leggiDurataMinuti();
		int secondi=ArchivioCdUtils.leggiDurataSecondi();
		Brano brano =new Brano(titolo,minuti,secondi);
		return brano;
	}

	private static Cd creaCd() {
		String titolo = ArchivioCdUtils.leggiTitolo(CD);
		String autore= ArchivioCdUtils.leggiAutore();
		Cd cd = new Cd(titolo, autore);
		return cd;
	}
}