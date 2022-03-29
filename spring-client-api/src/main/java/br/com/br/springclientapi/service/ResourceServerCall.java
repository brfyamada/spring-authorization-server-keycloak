//[AUTHORIZATION SERVER] [OAUTH2] [CLIENT] [STEP 4] Making a call to the resource server
package br.com.br.springclientapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResourceServerCall {

    private final WebClient webClient;

    @Value("${resource-server.url}")
    private String resourceServerurl;

    @Scheduled(fixedDelay = 5000)
    public void callResourceServer() {
        log.info("Calling the resource server!");
        webClient.get()
                .uri(resourceServerurl + "/hello/system")
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(System.out::println);
    }

}
