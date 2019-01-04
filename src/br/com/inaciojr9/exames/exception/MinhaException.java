package br.com.inaciojr9.exames.exception;

public class MinhaException extends RuntimeException {

	private static final long serialVersionUID = -636156475905068673L;
	
	public MinhaException(String message, Throwable e) {
		super(message, e);
	}

}
