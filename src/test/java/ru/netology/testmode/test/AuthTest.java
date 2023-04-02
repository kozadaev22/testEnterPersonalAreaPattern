package ru.netology.testmode.test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        var RegisteredUser = getRegisteredUser("active");
        $("[data-test-id='login'] input").setValue(RegisteredUser.getLogin());
        $("[data-test-id='password'] input").setValue(RegisteredUser.getPassword());
        $("[data-test-id=action-login]").click();
        $("h2").shouldHave(Condition.text("Личный кабинет")).shouldBe(Condition.visible);
    }
}
