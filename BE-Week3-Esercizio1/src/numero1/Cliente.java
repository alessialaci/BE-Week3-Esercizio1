package numero1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Cliente extends DB {

	private String nome;
	private String cognome;
	private String regione_residenza;
	private LocalDate data_nascita;
	
	public Cliente(String nome, String cognome, LocalDate data_nascita, String regione_residenza) {
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.regione_residenza = regione_residenza;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getRegione_residenza() {
		return regione_residenza;
	}

	public void setRegione_residenza(String regione_residenza) {
		this.regione_residenza = regione_residenza;
	}

	public LocalDate getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(LocalDate data_nascita) {
		this.data_nascita = data_nascita;
	}

	public void inserisciCliente() {
        try {
            String sql = "INSERT INTO clienti (nome, cognome, data_nascita, regione_residenza) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, this.nome);
            stmt.setString(2, this.cognome);
            stmt.setDate(3, java.sql.Date.valueOf(this.data_nascita));
            stmt.setString(4, this.regione_residenza);
            stmt.execute();
            
            System.out.println("Insert successful");
          }
          catch(SQLException e) {
        	  System.out.println("Errore");
              e.printStackTrace();
          }
	}
	
	public void aggiornaCliente(String newNome, int id) {
        try {
            String sql = "UPDATE clienti SET nome = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, newNome);
            stmt.setInt(2, id);
            stmt.execute();
            
            System.out.println("Update successful");
          }
          catch(SQLException e) {
        	  System.out.println("Errore");
              e.printStackTrace();
          }
	}
	
	public void mostraClienti() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM clienti");
            
            System.out.println("Lista clienti:");
            while(rs.next()) {
            	System.out.printf("Nome: %s%n", rs.getString("nome"));
            }
            
            System.out.println("----------------------------------------------------------");
          }
          catch(SQLException e) {
        	  System.out.println("Errore");
              e.printStackTrace();
          }
	}
	
	public void eliminaCliente(int id) {
		try {
			String sql = "DELETE FROM clienti WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			
			System.out.println("Delete is successful!");
		}
		catch(SQLException e) {
			System.out.println("There was an error during deleting data");
			e.printStackTrace();
		}
	}
	
}
