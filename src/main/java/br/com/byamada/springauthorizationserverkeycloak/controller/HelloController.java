//[AUTHORIZATION SERVER] [KEYCLOAK] [Step 4] Creatin a rest controller to test
package br.com.byamada.springauthorizationserverkeycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/user")
    public String getHelloUser() {
        return "Hello World (USER), Test using Resource Server!!!";
    }

    @GetMapping("/admin")
    public String getHelloAdmin() {
        return "Hello World (ADMIN), Test using Resource Server!!!";
    }

    @GetMapping("/system")
    public String getHelloSystem() {
        return "Hello World (SYSTEM), Test using Resource Server!!!";
    }
}
