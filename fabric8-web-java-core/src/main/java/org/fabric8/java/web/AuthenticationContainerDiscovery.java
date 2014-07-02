package org.fabric8.java.web;

public interface AuthenticationContainerDiscovery {
	
    /**
     * Gets the container name such as Apache Tomcat, used for logging purpose
     */
    String getContainerName();

    /**
     * Whether the container can/should be used for authentication
     *
     * @param configuration the configuration option (muteable)
     * @return <tt>true</tt> if the container is being used for authentication.
     */
    boolean canAuthenticate(AuthenticationConfiguration configuration);

}
