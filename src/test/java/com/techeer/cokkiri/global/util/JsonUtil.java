package com.techeer.cokkiri.global.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
  private final ObjectMapper objectMapper = new ObjectMapper();

  public String toJsonString(Object object) throws JsonProcessingException {
    return objectMapper.writeValueAsString(object);
  }
}
