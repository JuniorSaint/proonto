package br.com.proonto.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    @DisplayName("Should delete object with - SUCCESS")
    void deleteWithSuccess(){

    }

    @Test
//    @DisplayName("Should delete object with - SUCCESS")
    void findByEmail() {

    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByNameOrEmail() {
    }
}