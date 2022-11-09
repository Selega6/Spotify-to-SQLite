package es.ulpgc.spotify.downloader.ClasesPOJO;

public class Artist {
    private final int popularity;
    private final String id;
    private final String name;
    private final Followers followers;

    public Artist(int popularity, String id, String name, Followers followers) {
        this.popularity = popularity;
        this.id = id;
        this.name = name;
        this.followers = followers;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Followers getFollowers() {
        return followers;
    }
}