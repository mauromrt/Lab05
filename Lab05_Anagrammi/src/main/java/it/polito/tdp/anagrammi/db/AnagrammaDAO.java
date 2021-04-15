package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {
    
	public boolean parolaCorretta(String parola) {
		
		String sql = "SELECT nome "
				+ "FROM parola "
				+ "WHERE parola.nome = ?"; 
		
		
		
		
		try {
			
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,parola);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {    //se la query non produce risultato nullo, allora la parola passata è ancora valida
				
				return true;  
			}
			
			rs.close();
			st.close();
			conn.close();
			
			
			
		}catch(SQLException s) {
			throw new RuntimeException ("Errore nell'interrogazione al DB", s);
		}
		
		
		return false;
	}
	
}
