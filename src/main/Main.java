package main;

import java.sql.SQLException;

import controller.*;
import model.Genero;

public class Main {

	public static void main(String[] args) throws SQLException {
		GeneroService service = new GeneroService();
		
		if(service.add(new Genero(0, "Terror"))) {
			System.out.println("Gênero cadastrado");
		}else {
			System.out.println("SLA");
		}
	}

}
