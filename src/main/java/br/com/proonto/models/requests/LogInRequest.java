package br.com.proonto.models.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LogInRequest implements Serializable {
  private static final long serialVersionUID = 1L;
  private String email;
  private String password;
}
