package org.fabric8.java.core;

import javax.security.auth.Subject;

public interface PrivilegedCallback {
	public void execute(Subject subject) throws Exception;
}
