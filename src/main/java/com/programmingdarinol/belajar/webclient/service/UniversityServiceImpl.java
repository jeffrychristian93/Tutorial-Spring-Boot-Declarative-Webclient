package com.programmingdarinol.belajar.webclient.service;

import com.programmingdarinol.belajar.webclient.model.dto.UniversityResponse;
import com.programmingdarinol.belajar.webclient.outbound.UniversityOutboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UniversityServiceImpl implements UniversityService {

  @Autowired
  private UniversityOutboundService universityOutboundService;

  @Override
  public void getByCountryName(String countryName) {
    Flux<UniversityResponse> flux = universityOutboundService.findUniversityByCountryName(countryName);
    flux.subscribe(response -> System.out.println("NORMAL WebClient : " + response));
  }

  @Override
  public void findByCountryName(String countryName) {
    UniversityResponse[] response1 = universityOutboundService.findUniversityByCountry(countryName);
    print(response1, 1);

    ResponseEntity<UniversityResponse[]> response2 = universityOutboundService.getUniversityByCountry(countryName);
    if (response2 != null) {
      if (response2.getStatusCode().is2xxSuccessful() && response2.getBody() != null) {
        print(response2.getBody(), 2);
      }
    }

    Mono<UniversityResponse[]> mono = universityOutboundService.reactiveFindUniversityByCountry(countryName);
    mono.subscribe(response -> print(response, 3));
  }

  private void print(UniversityResponse[] data, int number) {
    for (UniversityResponse response : data) {
      System.out.println("Declarative WebClient [" + number + "] : " + response);
    }
  }
}
