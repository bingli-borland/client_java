package io.prometheus.client.authenticator;

public class BasicAuthenticator extends com.sun.net.httpserver.BasicAuthenticator {
    private final String userName;
    private final String password;

    public BasicAuthenticator(String realm, String userName, String password) {
        super(realm);
        this.userName = userName;
        this.password = password;
    }

    public boolean checkCredentials(String userName, String password) {
        return this.userName.equals(userName) && this.password.equals(password);
    }
}