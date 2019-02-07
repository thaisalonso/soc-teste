package br.com.tpa.soc_teste.exception;

public class DaoException extends RuntimeException {
	
	public DaoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
