package br.com.proonto.mocks;

import br.com.proonto.models.entities.Contact;

import static br.com.proonto.mocks.MessageMock.ID;

public interface ContactMock {
    public static final  String NAME = "Junior";
    public static final  String EMAIL = "junior@junior.com";
    public static final  String PHONE = "(32) 99999-3333";
    public static final Contact CONTACT = new Contact();
}
