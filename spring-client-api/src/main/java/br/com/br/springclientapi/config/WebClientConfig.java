//[AUTHORIZATION SERVER] [OAUTH2] [CLIENT] [STEP 3] Configuring the webClient to request token from authorization server
package br.com.br.springclientapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(ReactiveClientRegistrationRepository clientRegistrationRepository, ReactiveOAuth2AuthorizedClientService clientService) {
        ServerOAuth2AuthorizedClientExchangeFilterFunction oauth =
                new ServerOAuth2AuthorizedClientExchangeFilterFunction(
                        new AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager(
                                clientRegistrationRepository, clientService
                        )
                );
        oauth.setDefaultClientRegistrationId("client");
        return WebClient.builder()
                .filter(oauth)
                .build();
    }
}
