package es.ulpgc.spotify.downloader;

import com.google.gson.Gson;
import es.ulpgc.spotify.downloader.ClasesPOJO.Albums;
import es.ulpgc.spotify.downloader.ClasesPOJO.Artist;
import es.ulpgc.spotify.downloader.ClasesPOJO.Tracks;
import es.ulpgc.spotify.downloader.SQLDataBase.SQLAlbumManagement;
import es.ulpgc.spotify.downloader.SQLDataBase.SQLArtistManagement;
import es.ulpgc.spotify.downloader.SQLDataBase.SQLTrackManagement;

import java.util.ArrayList;
import java.util.Map;

import static java.lang.Thread.sleep;

public class RefactoredInserts {
    static int counter = 0;
    SQLTrackManagement trackManagement = new SQLTrackManagement();
    SQLAlbumManagement albumManagement = new SQLAlbumManagement();
    SQLArtistManagement artistManagement = new SQLArtistManagement();

    public void ArtistTableData(SpotifyAccessor accessor, ArrayList<String> singers) throws Exception {
        for (String singer : singers) {
            String json = accessor.get("/artists/" + singer, Map.of());
            counter++;
            if (counter % 100 == 0) sleep(3000);
            Gson gson = new Gson();
            Artist artist = gson.fromJson(json, Artist.class);
            artistManagement.insertArtist(artist);
        }
    }

    public void TrackTableData(SpotifyAccessor accessor, ArrayList<String> idAlbums) throws Exception {
        for (String ident : idAlbums) {
            String json3 = accessor.get("/albums/" + ident + "/tracks", Map.of());
            counter++;
            if (counter % 100 == 0) sleep(3000);
            Gson gson3 = new Gson();
            Tracks tracks = gson3.fromJson(json3, Tracks.class);
            for (Tracks song : tracks.getItems()) {
                Artist[] artist = song.getArtists();
                ArrayList<String> TracksCreators = new ArrayList<>();
                for (Artist artist1 : artist) {
                    String name = artist1.getName();
                    TracksCreators.add(name);
                }
                trackManagement.InsertTrack(song, TracksCreators);
            }
        }
    }

    public void AlbumTableData(SpotifyAccessor accessor, ArrayList<String> singers, ArrayList<String> idAlbums) throws Exception {
        for (String singer : singers) {
            String json2 = accessor.get("/artists/" + singer + "/albums", Map.of());
            counter++;
            if (counter % 200 == 0) sleep(3000);
            Gson gson2 = new Gson();
            Albums albums = gson2.fromJson(json2, Albums.class);
            for (Albums album : albums.getItems()) {
                idAlbums.add(album.getId());
                Artist[] artists = album.getArtists();
                ArrayList<String> albumCreators = new ArrayList<>();
                for (Artist artist1 : artists) albumCreators.add(artist1.getName());
                albumManagement.insertAlbum(album, albumCreators);
            }
        }
    }
}