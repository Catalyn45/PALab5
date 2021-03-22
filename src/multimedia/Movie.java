package multimedia;

public class Movie extends Item {
    private int releaseYear;
    private int rating;

    public Movie(String name, String path, String id, int releaseYear, int rating) {
        super(name, path, id);
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return "Movie{" +
                super.toString() +
                ", releaseYear=" + releaseYear +
                ", rating=" + rating +
                '}';
    }
}
