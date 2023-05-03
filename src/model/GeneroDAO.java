package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GeneroDAO {
	private Connection con;
	private PreparedStatement cmd;
	private Genero genero;
	
	public GeneroDAO() {
		this.con = Conexao.getConnection();
		try {
			this.con.setAutoCommit(false);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public GeneroDAO(Genero genero) {
		this.genero = genero;
		this.con = Conexao.getConnection();
		try {
			this.con.setAutoCommit(false);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public boolean post() throws SQLException {
		try {
			String sql = "INSERT INTO genero (nomeG) VALUES (?);";
			this.cmd = this.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			this.cmd.setString(1, this.genero.getNomeG());
			
			if(this.cmd.executeUpdate() > 0) {
				this.con.commit();
				return true;
			} else {
				this.con.rollback();
				return false;
			}
		} catch(Exception e) {
			this.con.rollback();
			return false;
		} finally {
			Conexao.dispose(this.con);
		}
	}
	
	public boolean update() throws SQLException {
		try {
			String sql = "UPDATE genero SET nomeG = ? WHERE idG = ?;";
			this.cmd = this.con.prepareStatement(sql);
			this.cmd.setString(1, this.genero.getNomeG());
			this.cmd.setInt(2, this.genero.getIdG());
			
			if(this.cmd.executeUpdate() > 0) {
				this.con.commit();
				return true;
			} else {
				this.con.rollback();
				return false;
			}
		} catch(Exception e) {
			this.con.rollback();
			return false;
		} finally {
			Conexao.dispose(this.con);
		}
	}
	
	public boolean delete() throws SQLException {
		try {
			String sql = "DELETE FROM genero WHERE idG = ?;";
			this.cmd = this.con.prepareStatement(sql);
			this.cmd.setInt(1, this.genero.getIdG());
			
			if(this.cmd.executeUpdate() > 0) {
				this.con.commit();
				return true;
			} else {
				this.con.rollback();
				return false;
			}
		} catch(Exception e) {
			this.con.rollback();
			return false;
		} finally {
			Conexao.dispose(this.con);
		}
	}
	
	public ArrayList<Genero> getAll() throws SQLException {
		try {
			String sql = "SELECT * FROM genero ORDER BY idG;";
			this.cmd = this.con.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			
			ArrayList<Genero> generos = new ArrayList<>();
			
			while(rs.next()) {
				generos.add(new Genero(rs.getInt("idG"), rs.getString("nomeG")));
			}
			
			return generos;
		} catch(Exception e) {
			return null;
		} finally {
			Conexao.dispose(this.con);
		}
	}
	
	public boolean exists() throws SQLException {
		try {
			String sql = "SELECT * FROM genero WHERE nomeG == ?";
			this.cmd = this.con.prepareStatement(sql);
			this.cmd.setString(1, this.genero.getNomeG());
			ResultSet rs = cmd.executeQuery();
			
			ArrayList<Genero> generos = new ArrayList<>();
			
			while(rs.next()) {
				generos.add(new Genero(rs.getInt("idG"), rs.getString("nomeG")));
			}
			
			return generos.size() > 0;
		} catch(Exception e) {
			return false;
		} finally {
			Conexao.dispose(this.con);
		}
	}
	
	
}
