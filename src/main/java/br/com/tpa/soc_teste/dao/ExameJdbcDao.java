package br.com.tpa.soc_teste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.tpa.soc_teste.exception.DaoException;
import br.com.tpa.soc_teste.model.Exame;

public class ExameJdbcDao implements ExameDao {
	
	@Override
	public List<Exame> listar() {
		String query = "SELECT id, nome, descricao FROM Exame";
		List<Exame> exames = new ArrayList<Exame>();
		
		try (Connection connection = Database.getConnection()) {
			try (Statement stmt = connection.createStatement()) {
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					Exame exame = new Exame();
					exame.setId(rs.getLong("id"));
					exame.setNome(rs.getString("nome"));
					exame.setDescricao(rs.getString("descricao"));
					exames.add(exame);
				}
			} catch(SQLException e) {
				throw new DaoException("Erro ao fechar statement", e);
			}
		} catch(SQLException e) { 
			 throw new DaoException("Erro ao fechar conexão", e); 
		 }
		return exames;
	}

	public void atualizar(Exame exame) {
		String query = "UPDATE Exame SET nome = ?, descricao = ? WHERE id = ?";
		
		try (Connection connection = Database.getConnection()) {
			try (PreparedStatement stmt = connection.prepareStatement(query)) {
				stmt.setString(1, exame.getNome());
				stmt.setString(2, exame.getDescricao());
				stmt.setLong(3, exame.getId());
				stmt.execute();
				connection.commit();
				} catch(SQLException e) {
				throw new DaoException("Erro ao fechar statement", e);
			}
		 } catch(SQLException e) { 
			 throw new DaoException("Erro ao fechar conexão", e); 
		 }
	}

	public void inserir(Exame exame) {
		String query = "INSERT INTO Exame (nome, descricao) VALUES (?, ?)";
		
		try (Connection connection = Database.getConnection()) {
			try (PreparedStatement stmt = connection.prepareStatement(query)) {
				stmt.setString(1, exame.getNome());
				stmt.setString(2, exame.getDescricao());
				stmt.execute();
				connection.commit();
				} catch(SQLException e) {
				throw new DaoException("Erro ao fechar statement", e);
			}
		 } catch(SQLException e) { 
			 throw new DaoException("Erro ao fechar conexão", e); 
		 }
	}

	public void excluir(Long id) {
		String query = "DELETE FROM Exame WHERE id = " + id;
		
		try (Connection connection = Database.getConnection()) {
			try (PreparedStatement stmt = connection.prepareStatement(query)) {
				stmt.execute();
				} catch(SQLException e) {
				throw new DaoException("Erro ao fechar statement", e);
			}
		} catch (SQLException e) {
			throw new DaoException("Erro ao fechar conexão", e); 
		 }
	}

	@Override
	public Exame buscar(Long id) {
		String query = "SELECT id, nome, descricao FROM Exame WHERE id = " + id;
		Exame exame = new Exame();
		
		try (Connection connection = Database.getConnection()) {
			try (Statement stmt = connection.createStatement()) {
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					exame.setId(rs.getLong("id"));
					exame.setNome(rs.getString("nome"));
					exame.setDescricao(rs.getString("descricao"));
				}
			} catch(SQLException e) {
				throw new DaoException("Erro ao fechar statement", e);
			}
		} catch(SQLException e) { 
			 throw new DaoException("Erro ao fechar conexão", e); 
		 }
		return exame;
	}


}
