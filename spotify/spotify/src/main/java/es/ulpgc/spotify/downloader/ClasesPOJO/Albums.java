package es.ulpgc.spotify.downloader.ClasesPOJO;

public class Albums {
    private final String album_type;
    private final int total_tracks;
    private final Albums[] items;
    private final String id;
    private final Albums album;
    private final String name;
    private final String release_date;
    private final Artist[] artists;
    private final Tracks tracks;

    public Albums(String album_type, int total_tracks, Albums[] items, String id, Albums album, String name, String release_date, Artist[] artists, Tracks tracks) {
        this.album_type = album_type;
        this.total_tracks = total_tracks;
        this.items = items;
        this.id = id;
        this.album = album;
        this.name = name;
        this.release_date = release_date;
        this.artists = artists;
        this.tracks = tracks;
    }

    public String getAlbum_type() {
        return album_type;
    }

    public int getTotal_tracks() {
        return total_tracks;
    }

    public Albums[] getItems() {
        return items;
    }

    public String getId() {
        return id;
    }

    public Albums getAlbum() {
        return album;
    }

    public String getName() {
        return name;
    }

    public String getRelease_date() {
        return release_date;
    }

    public Artist[] getArtists() {
        return artists;
    }

    public Tracks getTracks() {
        return tracks;
    }
}
