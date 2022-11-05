package br.com.proonto.models.responses;

import java.io.Serializable;

public interface ContactResponseTest extends Serializable {
     static final long serialVersionUID = 1L;
     Long getId();
     String getNome();
     String getTelefone();
     String getEmail();
}
 