package ru.iteco.fmhandroid.ui.testdata;

import androidx.annotation.NonNull;

public final class Credentials {

    private final String login;
    private final String password;

    public Credentials(@NonNull String login,
                       @NonNull String password) {
        this.login = login;
        this.password = password;
    }

    @NonNull
    public String getLogin() {
        return login;
    }

    @NonNull
    public String getPassword() {
        return password;
    }
}
