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
		try {
			File dir = new File (mappe);
			File fil = new File(dir, filnavn);
			PrintWriter skriver = new PrintWriter(fil);
			
			skriver.println(samling.toString());
			
			skriver.close();
			
			return true; 
			
		} catch (Exception e) {
			return false; 
		}
	}
}
