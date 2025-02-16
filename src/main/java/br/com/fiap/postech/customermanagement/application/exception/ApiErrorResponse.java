package br.com.fiap.postech.customermanagement.application.exception;

public interface ApiErrorResponse {
    String getType();
    String getTitle();
    int getStatus();
}
