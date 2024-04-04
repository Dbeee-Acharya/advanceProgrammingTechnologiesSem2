package util;

import it.cosenonjaviste.crypto.BCrypt;

public class PasswordHashing {
	
	public static String getPasswordHash(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

}
