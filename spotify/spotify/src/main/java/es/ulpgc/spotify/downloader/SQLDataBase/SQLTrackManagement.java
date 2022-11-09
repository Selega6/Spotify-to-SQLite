package es.ulpgc.spotify.downloader.SQLDataBase;

import es.ulpgc.spotify.downloader.ClasesPOJO.Tracks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLTrackManagement {
    SQLiteDataBase connection = new SQLiteDataBase();

    public void InsertTrack(Tracks track, ArrayList<String> trackCreators) {
        final String SQL = "INSERT INTO tracks VALUES(?, ?, ?, ?, ?, ?, ?)  ON CONFLICT(id) DO UPDATE SET name = ? , " +
                "artistName = ?, durationMs = ?, popularity = ?, trackNumber = ?, explicit = ? WHERE id = ?";
        try (Connection con = connection.GetConnection(); PreparedStatement ps = con.prepareStatement(SQL)) {
            ps.setString(1, track.getId());
            ps.setString(2, track.getName());
            ps.setString(3, trackCreators.toString());
            ps.setInt(4, track.getDuration_ms());
            ps.setInt(5, track.getPopularity());
            ps.setInt(6, track.getTrack_number());
            ps.setBoolean(7, track.isExplicit());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DropTableTrack(Connection connect) throws SQLException {
        Statement statement = connect.createStatement();
        statement.execute("DROP TABLE tracks;");
    }
}
