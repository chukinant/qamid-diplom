package ru.iteco.fmhandroid.ui.auxiliaries;

//import com.github.javafaker.Faker;
import lombok.Value;

public class DataHelper {

    private DataHelper() {
    }

    @Value
    public static class Creds {
        String login;
        String password;
    }

    public static Creds getValidCredentials() {
    return new Creds ("login2", "password2");
    }

}


