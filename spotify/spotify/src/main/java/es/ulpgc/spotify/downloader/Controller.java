package es.ulpgc.spotify.downloader;

import es.ulpgc.spotify.downloader.SQLDataBase.SQLAlbumManagement;
import es.ulpgc.spotify.downloader.SQLDataBase.SQLArtistManagement;
import es.ulpgc.spotify.downloader.SQLDataBase.SQLTrackManagement;
import es.ulpgc.spotify.downloader.SQLDataBase.SQLiteDataBase;

import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {
    public static ArrayList<String> singers = new ArrayList<>();

    public void controller() throws Exception {
        SpotifyAccessor accessor = new SpotifyAccessor();
        singers.add("0BEI7i5sgUuivcfwXLzFmM");
        singers.add("2yzxX2DI9LFK8VFTyW2zZ8");
        singers.add("5MhLmv7GgyjbxGqiIGasvT");
        singers.add("7dGJo4pcD2V6oG8kP0tJRR");
        singers.add("4rUyBlggM5tZUH5QZn9ZuO");
        SQLiteDataBase database = new SQLiteDataBase();
        RefactoredInserts inserts = new RefactoredInserts();
        ArrayList<String> idAlbums = new ArrayList<>();
        database.CreateTableArtist();
        database.CreateTableAlbum();
        database.CreateTableTrack();
        inserts.ArtistTableData(accessor, singers);
        inserts.AlbumTableData(accessor, singers, idAlbums);
        inserts.TrackTableData(accessor, idAlbums);
    }

    public void dropTables() throws SQLException {
        SQLiteDataBase connection = new SQLiteDataBase();
        SQLTrackManagement trackManagement = new SQLTrackManagement();
        SQLAlbumManagement albumManagement = new SQLAlbumManagement();
        SQLArtistManagement artistManagement = new SQLArtistManagement();
        artistManagement.DropTableArtist(connection.GetConnection());
        albumManagement.DropTableAlbum(connection.GetConnection());
        trackManagement.DropTableTrack(connection.GetConnection());
    }
}