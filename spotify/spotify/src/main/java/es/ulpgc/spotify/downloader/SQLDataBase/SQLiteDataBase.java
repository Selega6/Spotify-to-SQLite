package es.ulpgc.spotify.downloader.SQLDataBase;

import java.sql.*;

public class SQLiteDataBase {
    static String url = "jdbc:sqlite:C:\\Users\\Gabri\\IdeaProjects\\spotify\\spotify\\src\\SpotifyDB.db";

    public Connection GetConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public void CreateTableArtist() {
        final String SQL = "CREATE TABLE IF NOT EXISTS artists (id TEXT PRIMARY KEY,name TEXT, popularity INTEGER, followers INTEGER);";
        try (Connection con = GetConnection(); Statement statement = con.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void CreateTableAlbum() {
        final String SQL = "CREATE TABLE IF NOT EXISTS albums (id TEXT PRIMARY KEY,name TEXT,artistName TEXT ,releaseDate TEXT," +
                " albumType TEXT, TotalTracks INTEGER);";
        try (Connection con = GetConnection(); Statement statement = con.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void CreateTableTrack() {
        final String SQL = "CREATE TABLE IF NOT EXISTS tracks (id TEXT PRIMARY KEY,name TEXT,artistName TEXT ," +
                "durationMs INTEGER, popularity INTEGER, trackNumber INTEGER, explicit BOOLEAN);";
        try (Connection con = GetConnection(); Statement statement = con.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}