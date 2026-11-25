import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaDAO {
    
    // query 1 SELECT
    public List<Mahasiswa> getAllMahasiswa() throws SQLException {
        List<Mahasiswa> daftarMahasiswa =new ArrayList<>();

        String sql = "SELECT * FROM Mahasiswa";

        try(
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                Mahasiswa mahasiswa = new Mahasiswa(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("prodi")
                );
                daftarMahasiswa.add(mahasiswa);
            }
        } 
        return daftarMahasiswa;
    }

    // query 2 INSERT
    public void tambahMahasiswa(Mahasiswa mahasiswa) throws SQLException {
        String sql = "INSERT INTO mahasiswa (nama, prodi) VALUES (?, ?)";

        try(Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, mahasiswa.getNama());
                ps.setString(2, mahasiswa.getProdi());
                ps.executeUpdate();

                conn.commit();
            } catch(SQLException e) {
                conn.rollback();

                throw e;
            }
        }
    }

    // query 3 UPDATE
    public void updateMahasiswa(Mahasiswa mahasiswa) throws SQLException {
        String sql = "UPDATE mahasiswa SET nama = ?, prodi = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, mahasiswa.getNama());
                ps.setString(2, mahasiswa.getProdi());
                ps.setInt(3, mahasiswa.getId());
                ps.executeUpdate();

                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }


    // query 4 DELETE
    public void hapusMahasiswa(int id) throws SQLException {
        String sql = "DELETE FROM mahasiswa WHERE id = ?";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, id);
                ps.executeUpdate();

                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }
}