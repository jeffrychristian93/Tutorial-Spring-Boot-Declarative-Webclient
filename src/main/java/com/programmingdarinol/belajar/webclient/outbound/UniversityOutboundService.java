package com.programmingdarinol.belajar.webclient.outbound;

import com.programmingdarinol.belajar.webclient.model.dto.UniversityResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UniversityOutboundService {

  /**
   * Standard implementation of webclient
   * @param country
   * @return Flux<UniversityResponse>
   */
  Flux<UniversityResponse> findUniversityByCountryName(String country);

  /**
   * Using declarative implementation of webclient with endpoint repository
   * @param country
   * @return UniversityResponse[]
   */
  UniversityResponse[] findUniversityByCountry(String country);

  /**
   * Using declarative implementation of webclient with endpoint repository
   * @param country
   * @return ResponseEntity<UniversityResponse[]>
   */
  ResponseEntity<UniversityResponse[]> getUniversityByCountry(String country);

  /**
   * Using declarative implementation of webclient with endpoint repository
   * @param country
   * @return Mono<UniversityResponse[]>
   */
  Mono<UniversityResponse[]> reactiveFindUniversityByCountry(String country);
}
