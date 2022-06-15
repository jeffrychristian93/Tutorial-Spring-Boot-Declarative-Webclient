package com.programmingdarinol.belajar.webclient.outbound;

import com.programmingdarinol.belajar.webclient.model.dto.UniversityResponse;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UniversityOutboundServiceImpl implements UniversityOutboundService {

  @Autowired
  private WebClient webClientUniversity;
  @Autowired
  private UniversityOutboundRepository universityOutboundRepository;

  @Override
  public Flux<UniversityResponse> findUniversityByCountryName(String country) {
    return webClientUniversity
        .get()
        .uri("/search", uriBuilder -> {
          uriBuilder.queryParam("country", country);
          return uriBuilder.build();
        })
        .exchangeToMono(clientResponse -> clientResponse.bodyToMono(UniversityResponse[].class))
        .flatMapIterable(Arrays::asList);
  }

  @Override
  public UniversityResponse[] findUniversityByCountry(String country) {
    UniversityResponse[] response = universityOutboundRepository.findUniversityByCountry("Indonesia");
    return response;
  }

  @Override
  public ResponseEntity<UniversityResponse[]> getUniversityByCountry(String country) {
    ResponseEntity<UniversityResponse[]> response = universityOutboundRepository.getUniversityByCountry("Indonesia");
    return response;
  }

  @Override
  public Mono<UniversityResponse[]> reactiveFindUniversityByCountry(String country) {
    Mono<UniversityResponse[]> response = universityOutboundRepository.reactiveFindUniversityByCountry("Indonesia");
    return response;
  }
}
