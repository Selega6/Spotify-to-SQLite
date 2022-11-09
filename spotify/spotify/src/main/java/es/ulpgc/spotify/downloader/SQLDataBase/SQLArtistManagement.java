package es.ulpgc.spotify.downloader.SQLDataBase;

import es.ulpgc.spotify.downloader.ClasesPOJO.Artist;
import es.ulpgc.spotify.downloader.ClasesPOJO.Followers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLArtistManagement {
    SQLiteDataBase connection = new SQLiteDataBase();

    public void insertArtist(Artist artist) {
        final String SQL = "INSERT INTO artists VALUES(?, ?, ?, ?)  ON CONFLICT(id) DO UPDATE SET name = ? , " +
                "popularity = ?, followers = ? WHERE id = ?";
        try (Connection con = connection.GetConnection(); PreparedStatement ps = con.prepareStatement(SQL)) {
            ps.setString(1, artist.getId());
            ps.setString(2, artist.getName());
            ps.setInt(3, artist.getPopularity());
            Followers followers = artist.getFollowers();
            ps.setInt(4, followers.getTotal());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DropTableArtist(Connection connect) throws SQLException {
        Statement statement = connect.createStatement();
        statement.execute("DROP TABLE artists;");
    }
}