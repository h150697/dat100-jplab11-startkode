package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return this.nesteledig; 
	}
	
	public Innlegg[] getSamling() {
		return this.innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		boolean funnet = false; 
		
		int pos = 0;
		
		while( pos < nesteledig && !funnet) {
			if(innleggtabell[pos].erLik(innlegg)) {
				funnet = true;
			} else {
				pos++;
			}
		}
		
		if(funnet) {
			return pos;
		} else {
			return -1;
		}
		
	}

	public boolean finnes(Innlegg innlegg) {
		int pos = finnInnlegg(innlegg);
		if(pos >= 0 ) {
			return true;
		} else {
			return false;
		}		
	}

	public boolean ledigPlass() {
		boolean ledig = false;
		
		for(int i = 0; i < innleggtabell.length; i++) {
			if(innleggtabell[i] == null) {
				ledig = true; 
			}
		}
		
		if (ledig == false) {
			ledig = false; 
		}
		
		return ledig; 
	}
	
	public boolean leggTil(Innlegg innlegg) {
		boolean ny = finnInnlegg(innlegg) == -1;
		
		if(ny && nesteledig < innleggtabell.length) {
			innleggtabell[nesteledig] = innlegg;
			this.nesteledig++;
			return true; 
		} else {
			return false; 
		}
	}
	
	public String toString() {

		String svar = nesteledig + "\n";
		for (int i = 0; i < nesteledig; i++) {
			svar += innleggtabell[i].toString();
		}
		
		return svar;
		
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] utvid = new Innlegg[innleggtabell.length*2];
		
		for(int i = 0; i < innleggtabell.length; i++) {
			utvid[i] = innleggtabell[i];
		}
		
		innleggtabell = utvid;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		int pos = finnInnlegg(innlegg);
		
		if(pos >= 0) {
			nesteledig--;
			innleggtabell[pos] = innleggtabell[nesteledig];
			innleggtabell[nesteledig] = null;
			return true; 
		}
		
		return false;
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}