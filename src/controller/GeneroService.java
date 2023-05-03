package controller;

import java.sql.SQLException;

import model.Genero;
import model.GeneroDAO;

public class GeneroService {
	private GeneroDAO generoDao;
	
	public GeneroService() {
		generoDao = new GeneroDAO();
	}
	
	private void config(Genero gen) {
		this.generoDao.setGenero(gen);
	}
	
	public boolean add(Genero gen) throws SQLException {
		try {
			config(gen);
			if(!generoDao.exists()) {
				return generoDao.post();
			}
			return false;	
		}catch (SQLException e) {
			return false;
		}
	}
}
