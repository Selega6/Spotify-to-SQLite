package es.ulpgc.spotify.downloader.ClasesPOJO;

public class Tracks {
    private final Tracks[] items;
    private final String next;
    private final String id;
    private final Artist[] artists;
    private final String name;
    private final int popularity;
    private final Albums album;
    private final int track_number;
    private final int duration_ms;
    private final boolean explicit;
    private final Albums[] albums;

    public Tracks(Tracks[] items, String next, String id, Artist[] artists, String name, int popularity, Albums album, int track_number, int duration_ms, boolean explicit, Albums[] albums) {
        this.items = items;
        this.next = next;
        this.id = id;
        this.artists = artists;
        this.name = name;
        this.popularity = popularity;
        this.album = album;
        this.track_number = track_number;
        this.duration_ms = duration_ms;
        this.explicit = explicit;
        this.albums = albums;
    }

    public Tracks[] getItems() {
        return items;
    }

    public String getNext() {
        return next;
    }

    public String getId() {
        return id;
    }

    public Artist[] getArtists() {
        return artists;
    }

    public String getName() {
        return name;
    }

    public int getPopularity() {
        return popularity;
    }

    public Albums getAlbum() {
        return album;
    }

    public int getTrack_number() {
        return track_number;
    }

    public int getDuration_ms() {
        return duration_ms;
    }

    public boolean isExplicit() {
        return explicit;
    }

    public Albums[] getAlbums() {
        return albums;
    }
}
