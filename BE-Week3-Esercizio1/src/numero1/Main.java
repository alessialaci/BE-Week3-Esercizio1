package numero1;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		
		DB db = new DB();
		Cliente c1 = new Cliente("Gianna", "Tavolo", LocalDate.of(1992, 3, 3), "Lazio");
		
		db.connect();
		
		boolean inserisciCliente = true;
		if (inserisciCliente) {
			c1.inserisciCliente();
		}
		
		boolean aggiornaCliente = false;
		if (aggiornaCliente) {
			c1.aggiornaCliente("Barbara", 1);
		}
		
		boolean deleteStudent = false;
		if (deleteStudent) {
			c1.eliminaCliente(4);
		}
		
		boolean showStudent = false;
		if (showStudent) {
			c1.mostraClienti();
		}
		
		db.disconnect();
		
		// SELECT nome, cognome FROM clienti WHERE data_nascita = '1992'

	}

}
