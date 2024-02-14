package com.codeandscale.bowling.configs;

import java.time.OffsetDateTime;
import java.util.Map;

public class ErrorResponse {

  private String traceId;
  private OffsetDateTime timestamp;
  private String message;
  private int status;
  private Map<String, String> errors;

  public ErrorResponse(
    String traceId,
    OffsetDateTime timestamp,
    String message,
    int status,
    Map<String, String> errors
  ) {
    this.traceId = traceId;
    this.timestamp = timestamp;
    this.message = message;
    this.status = status;
    this.errors = errors;
  }

  public ErrorResponse() {}

  public String getTraceId() {
    return traceId;
  }

  public void setTraceId(String traceId) {
    this.traceId = traceId;
  }

  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public Map<String, String> getErrors() {
    return errors;
  }

  public void setErrors(Map<String, String> errors) {
    this.errors = errors;
  }
}
