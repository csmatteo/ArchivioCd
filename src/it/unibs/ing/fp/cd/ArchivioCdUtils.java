package it.unibs.ing.fp.cd;

import java.util.Random;

import it.unibs.fp.mylib.InputDati;

public class ArchivioCdUtils {
	private static final String RICHIESTA_AUTORE_CD = "Inserire l'autore del CD: ";
	private static final String RISPOSTE_AMMISSIBILI = "SN";
	private static final String SECONDI = "secondi";
	private static final String MINUTI = "minuti";
	private static final String RICHIESTA_DURATA_BRANO = "Inserire la durata del brano (solo le cifre dei %s): ";
	private static final String RICHIESTA_TITOLO_BRANO_O_CD = "Inserire il titolo del %s: ";

	public static String leggiTitolo(String tipo) {
		return InputDati.leggiStringaNonVuota(String.format(RICHIESTA_TITOLO_BRANO_O_CD, tipo));
	}
	
	public static String leggiAutore() {
		return InputDati.leggiStringaNonVuota(RICHIESTA_AUTORE_CD);
	}
	
	public static int leggiDurataMinuti() {
		return InputDati.leggiInteroNonNegativo(String.format(RICHIESTA_DURATA_BRANO, MINUTI));
	}
	
	public static int leggiDurataSecondi() {
		return InputDati.leggiIntero(String.format(RICHIESTA_DURATA_BRANO, SECONDI), 0, 60);
	}
	
	public static char leggiRisposta(String messaggio) {
		return InputDati.leggiUpperChar(messaggio, RISPOSTE_AMMISSIBILI);
	}
	
	public static int estraiInt(int range) {
		Random randomInt = new Random();
		return randomInt.nextInt(range);
	}
}