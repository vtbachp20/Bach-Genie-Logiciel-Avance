package org.ifi.p20.gla.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
 
@Component
@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class HelloWorld {
    private String message;
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
}
