package ru.netology.testmode.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.testmode.data.DataGenerator;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import static ru.netology.testmode.data.DataGenerator.Registration.getRegisteredUser;



public class AuthTest {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }
    @Test
    @DisplayName("Should successfully login with active registered user")
    void shouldSuccessfulLoginIfRegisteredActiveUser(){
        var ResteredUser = getRegisteredUser("active");
        $("[data-test-id='login'] input").setValue(DataGenerator.Registration.getLogin());


    }


}
