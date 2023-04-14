import java.util.Comparator;

public class Movie {

    private String title;
    private int year;
    private String actor;
    private String genre;

    public Movie(String title, int year, String actor, String genre) {

        this.title = title;
        this.year = year;
        this.actor = actor;
        this.genre = genre;
    }

    public String toString() {
        return title + " (" + year + "), "
                + "Actor: " + actor + " Genre: " + genre;
    }

    public boolean isOlderThan(Movie other) {
        return year < other.year;
    }

    public boolean isMoreRecentThan(Movie other) {
        return year > other.year;
    }

    public boolean equals(Movie other) {
        return title.equals(other.title)
                && year == other.year
                && actor.equals(other.actor)
                && genre.equals(other.genre);
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getActor() {
        return actor;
    }

    public String getGenre() {
        return genre;
    }

    public static Comparator<Movie> titleComparator = new Comparator<Movie>() {

        public int compare(Movie m1, Movie m2) {
            String title1 = m1.getTitle();
            String title2 = m2.getTitle();

            //ascending order
            return title1.compareTo(title2);
        }
    };

    public static Comparator<Movie> yearComparator = new Comparator<Movie>() {

        public int compare(Movie m1, Movie m2) {
            Integer year1 = m1.getYear();
            Integer year2 = m2.getYear();

            //ascending order
            return year1.compareTo(year2);
        }
    };

    public static Comparator<Movie> actorComparator = new Comparator<Movie>() {

        public int compare(Movie m1, Movie m2) {
            String actor1 = m1.getActor();
            String actor2 = m2.getActor();

            //ascending order
            return actor1.compareTo(actor2);
        }
    };

    public static Comparator<Movie> genreComparator = new Comparator<Movie>() {

        public int compare(Movie m1, Movie m2) {
            String genre1 = m1.getGenre();
            String genre2 = m2.getGenre();

            //ascending order
            return genre1.compareTo(genre2);
        }
    };

}
