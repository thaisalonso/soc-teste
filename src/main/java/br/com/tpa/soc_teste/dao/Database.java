package br.com.tpa.soc_teste.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;

import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.tools.RunScript;

import br.com.tpa.soc_teste.exception.DaoException;

public class Database {

	private static JdbcConnectionPool cp = JdbcConnectionPool.create("jdbc:h2:mem:test", "", "");
	
	static {
		try {
			RunScript.execute(getConnection(), new FileReader("src/main/resources/create.sql"));
		} catch (FileNotFoundException | SQLException e) {
			throw new DaoException("Erro ao criar base", e);
		}
	}
	
	static Connection getConnection() {
		try {
			return cp.getConnection();
		} catch (SQLException e) {
			throw new DaoException("Erro ao adquirir conexão", e); 
		}
	}
	

}
