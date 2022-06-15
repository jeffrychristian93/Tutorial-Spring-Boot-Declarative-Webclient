package com.programmingdarinol.belajar.webclient.outbound;

import com.programmingdarinol.belajar.webclient.model.dto.UniversityResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface UniversityOutboundRepository {

  @GetExchange("/search")
  UniversityResponse[] findUniversityByCountry(@RequestParam String country);

  @GetExchange("/search")
  ResponseEntity<UniversityResponse[]> getUniversityByCountry(@RequestParam String country);

  @GetExchange("/search")
  Mono<UniversityResponse[]> reactiveFindUniversityByCountry(@RequestParam String country);

}
