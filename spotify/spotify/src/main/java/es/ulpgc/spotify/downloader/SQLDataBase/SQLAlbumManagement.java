package es.ulpgc.spotify.downloader.SQLDataBase;

import es.ulpgc.spotify.downloader.ClasesPOJO.Albums;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLAlbumManagement {
    SQLiteDataBase connection = new SQLiteDataBase();
    public void insertAlbum(Albums album, ArrayList<String> albumCreators ) {
        final String SQL = "INSERT INTO albums VALUES(?, ?, ?, ?, ?, ?)  ON CONFLICT(id) DO UPDATE SET name = ? , " +
                "artistName = ?, releaseDate = ?, albumType = ?, totalTracks = ? WHERE id = ?";
        try (Connection con = connection.GetConnection(); PreparedStatement ps = con.prepareStatement(SQL)) {
            ps.setString(1, album.getId());
            ps.setString(2, album.getName());
            ps.setString(3, albumCreators.toString());
            ps.setString(4, album.getRelease_date());
            ps.setString(5, album.getAlbum_type());
            ps.setInt(6, album.getTotal_tracks());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DropTableAlbum(Connection connect) throws SQLException {
        Statement statement = connect.createStatement();
        statement.execute("DROP TABLE albums;");
    }
}