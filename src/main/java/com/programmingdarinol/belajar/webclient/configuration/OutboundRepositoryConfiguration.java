package com.programmingdarinol.belajar.webclient.configuration;

import com.programmingdarinol.belajar.webclient.outbound.UniversityOutboundRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class OutboundRepositoryConfiguration {

  @Bean
  public UniversityOutboundRepository universityOutboundRepository(WebClient webClientUniversity){
    HttpServiceProxyFactory factory = HttpServiceProxyFactory
        .builder(new WebClientAdapter(webClientUniversity))
        .build();
    return factory.createClient(UniversityOutboundRepository.class);
  }

}
