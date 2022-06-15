package com.programmingdarinol.belajar.webclient.service;

public interface UniversityService {

  /**
   * Using Non-declarative Webclient
   * @param countryName
   */
  void getByCountryName(String countryName);

  /**
   * Using Declarative Webclient (Only in springframework 6)
   * @param countryName
   */
  void findByCountryName(String countryName);
}
