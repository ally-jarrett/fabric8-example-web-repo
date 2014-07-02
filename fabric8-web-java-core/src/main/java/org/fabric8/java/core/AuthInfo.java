package org.fabric8.java.core;

import org.fabric8.java.utils.Strings;

public class AuthInfo {

	public String username;
	public String password;

	public boolean set() {

		return Strings.isNotBlank(username) && Strings.isNotBlank(password);
	}

}
