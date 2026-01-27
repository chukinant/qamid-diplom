package ru.iteco.fmhandroid.ui.testdata;

public final class NewsItemInfo {
    private final String category;
    private final int position;
    private final String title;
    private final String publicationDate;
    private final String publicationTime;
    private final String description;
    private final String creationDate;
    private final String status;

    public NewsItemInfo(String category,
                        int position,
                        String title,
                        String publicationDate,
                        String publicationTime,
                        String description,
                        String creationDate,
                        String status) {
        this.category = category;
        this.position = position;
        this.title = title;
        this.publicationDate = publicationDate;
        this.publicationTime = publicationTime;
        this.description = description;
        this.creationDate = creationDate;
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public int getPosition() {
        return position;
    }

    public String getTitle() {
        return title;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getPublicationTime() {
        return publicationTime;
    }

    public String getDescription() {
        return description;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getStatus() {
        return status;
    }
}
