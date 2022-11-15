package no.hvl.dat100.jplab11.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		PrintWriter skriver = null;
		boolean ok = true; 
		
		do {
		try {
			skriver = new PrintWriter(mappe + filnavn);
			skriver.println(samling.toString());
			skriver.close();
		}
		
		catch(FileNotFoundException e) {
			System.out.println("Katalogen finnes ikke.");
			ok = false; 
		}
	}	while (!ok);
		return ok;
	}
}
