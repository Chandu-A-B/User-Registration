package com.consumer.registration.modelTest;

import com.consumer.registration.model.UserCredentials;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserCredentialsTest {

    @Test
    void test() {
        UserCredentials user = new UserCredentials();
        UserCredentials users = new UserCredentials("Chandu","chandu123");
        user.setUserName("Chandu");
        assertEquals(user.getUserName(), "Chandu");
        user.setPassword("chandu123");
        assertEquals(user.getPassword(),"chandu123");
    }
}
