//[AUTHORIZATION SERVER] [KEYCLOAK] [Step 3] Configure Security Class, the endpoint /hello/system will be able to be accessed onle by ROLE_SYSTEM (Client that hah been configured in Keycloak)
package br.com.byamada.springauthorizationserverkeycloak.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/hello/user")
                        .hasAuthority("ROLE_USER")
                    .antMatchers(HttpMethod.GET, "/hello/admin")
                        .hasAuthority("ROLE_ADMIN")
                    .antMatchers(HttpMethod.GET, "/hello/system")
                        .hasAuthority("ROLE_SYSTEM")
                .anyRequest()
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt()
                    .jwtAuthenticationConverter(getJwtAuthenticationConverter());
    }

    private JwtAuthenticationConverter getJwtAuthenticationConverter(){
        JwtGrantedAuthoritiesConverter converter = new JwtGrantedAuthoritiesConverter();
        converter.setAuthoritiesClaimName("authorities");
        converter.setAuthorityPrefix("");
        JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
        authenticationConverter.setJwtGrantedAuthoritiesConverter(converter);
        return authenticationConverter;
    }
}
