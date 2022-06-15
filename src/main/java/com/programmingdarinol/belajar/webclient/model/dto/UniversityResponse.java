package com.programmingdarinol.belajar.webclient.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UniversityResponse {

  @JsonProperty("name")
  private String name;

  @JsonProperty("web_pages")
  private String[] website;

}
