package eu.kaatz.camunda.restclient.clients;

import eu.kaatz.camunda.restclient.domain.CustomReqresUserPageImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.HttpProtocol;
import reactor.netty.http.client.HttpClient;

@Slf4j
@Component
public class UserClient {

    @Value("${service.user.url.base}") String userServiceBaseUrl;
    @Value("${service.user.url.path}") String userServiceUrlPath;

    public CustomReqresUserPageImpl getUsersPage(Integer page_number){

        var httpClient = HttpClient.create().protocol(HttpProtocol.H2, HttpProtocol.HTTP11)
                .secure()
                .compress(true)
                .followRedirect(true);

        var webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient)).baseUrl(userServiceBaseUrl).build();

        return webClient.get()
                .uri(builder -> builder.path(userServiceUrlPath)
                        .queryParam("page", page_number).build())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(CustomReqresUserPageImpl.class)
                .block();
    }



}
