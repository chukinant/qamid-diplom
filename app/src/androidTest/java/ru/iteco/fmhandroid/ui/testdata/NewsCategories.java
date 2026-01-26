package ru.iteco.fmhandroid.ui.testdata;

import androidx.annotation.NonNull;

public final class NewsCategories {

    private static final String[] CATEGORIES = {
            "Объявление",
            "День рождения",
            "Зарплата",
            "Профсоюз",
            "Праздник",
            "Массаж",
            "Благодарность",
            "Нужна помощь"
    };

    private NewsCategories() {
    }

    public static String[] getCategories() {
        return CATEGORIES;
    }
}
