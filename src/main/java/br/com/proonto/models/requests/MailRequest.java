package br.com.proonto.models.requests;

import lombok.Data;

@Data
public class MailRequest {
    private String name;
    private String to;
    private String from;
    private String subject;
}


