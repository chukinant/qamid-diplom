package ru.iteco.fmhandroid.ui.steps;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import ru.iteco.fmhandroid.ui.testdata.NewsCategories;
import ru.iteco.fmhandroid.ui.testdata.NewsItemInfo;

public class NewsInfoHelper {

    private NewsInfoHelper() {}

    public static final class CategorySelection {
        private final String category;
        private final int position;

        public CategorySelection(String category, int position) {
            this.category = category;
            this.position = position;
        }

        public String getCategory() {
            return category;
        }

        public int getPosition() {
            return position;
        }
    }

    public static CategorySelection getRandomCategory() {
        String[] categories = NewsCategories.getCategories();
        int position = new Random().nextInt(categories.length);
        return new CategorySelection(categories[position], position);
    }

    public static String generateDate(int daysToAdd) {
        return LocalDate.now().plusDays(daysToAdd).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateTime(int hoursToAdd, int minutesToAdd) {
        return LocalTime.now().plusHours(hoursToAdd).plusMinutes(minutesToAdd).format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public static int getHour(String publicationTime) {
        return Integer.parseInt(publicationTime.substring(0, 2));
    }

    public static int getMinutes(String publicationTime) {
        return Integer.parseInt(publicationTime.substring(3, 5));
    }

    public static NewsItemInfo getNewsInfoTodayDateMinuteAgo() {
        CategorySelection categorySelected = getRandomCategory();
        String category = categorySelected.getCategory();
        int position = categorySelected.getPosition();
        String title = category;
        String publicationDate = generateDate(0);
        String publicationTime = generateTime(0,-1);
        String description = "News of " + category + " category. Publishing " + publicationDate + " at " + publicationTime;
        return new NewsItemInfo(category, position, title, publicationDate, publicationTime, description);
    }
}
