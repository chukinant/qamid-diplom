package ru.iteco.fmhandroid.ui.testdata;

public final class TestUsers {

    private TestUsers() {
    }

    public static final Credentials VALID =
            new Credentials("login2", "password2");

    public static final Credentials EMPTY =
            new Credentials("", "");

    public static final Credentials WRONG =
            new Credentials("login", "password");
}
