package org.jcwal.so.network.exception;

import org.macula.exception.MaculaException;

public class NetworkException extends MaculaException {

	private static final long serialVersionUID = 1L;

	public NetworkException(String message) {
		super(message);
	}

	@Override
	public String getParentCode() {
		return "Network-Webapp";
	}

}
