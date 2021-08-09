package com.restfulbooker.api.payload;

import org.codehaus.jackson.annotate.JsonProperty;

public class Auth {
	
	@JsonProperty("username")
	private String userName;
	
	@JsonProperty("pwd")
	private String password;

	private Auth(String name, String pass) {
        userName = name;
        password = pass;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {
        private String userName, password;

        public Builder setUserName(String name) {
            userName = name;
            return this;
        }

        public Builder setPassword(String pass) {
            password = pass;
            return this;
        }

        public Auth build() {
            return new Auth(userName, password);
        }
    }
}
