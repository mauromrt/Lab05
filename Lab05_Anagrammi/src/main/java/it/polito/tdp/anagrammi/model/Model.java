package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Model {
	
	AnagrammaDAO dao = new AnagrammaDAO();
	
	
	public List<Anagramma> calcolaAnagrammi (String parola){
		
		List<Anagramma> risultato = new ArrayList<Anagramma>();
		
		metodoRicorsivo("", parola, 0, risultato );
		
		return risultato;
	}
	
	
	private void metodoRicorsivo (String parziale, String daPermutare ,int livello, List<Anagramma> risultato) {
		//caso terminale ---> la nostra parola (daPermutare ) è ormai vuota.
		if(daPermutare.length()==0) {
			
		   risultato.add(new Anagramma(parziale, true));
		}
		
		//se non abbiamo ancora terminato, fai ricorsione
		
		for(int i=0; i<daPermutare.length() ;i++) {
			
			String nuovaParziale = parziale+ daPermutare.charAt(i); 
			String nuovaDaPermutare = daPermutare.substring(0,i)+ daPermutare.substring(i+1);
	    
		//filtro per applicare la ricorsione ---> se nuovaParziale rappresenta un prefisso presente nel Dizionario.
			if (dao.parolaCorretta(nuovaParziale) ){
				metodoRicorsivo(nuovaParziale, nuovaDaPermutare, livello+1, risultato);
			}
		
			else {
				//il prefisso a cui si è arrivati non è presente nel dizionario, va però continuata la ricorsione 
				//per stampare tale anagramma della parola come anagramma errato
				 if(nuovaDaPermutare.length()==0) {
					 risultato.add(new Anagramma(nuovaParziale, false));
					
				 }
				 
				 else
					 metodoRicorsivo(nuovaParziale, nuovaDaPermutare, livello+1, risultato);
				
			}
			
			
			
		}
		
		
	}
}
