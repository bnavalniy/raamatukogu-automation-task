package entity;

public enum Genre {
    NON_FICTION("Non-fiction"), FICTION("Fiction");

    final String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre;
    }
}
