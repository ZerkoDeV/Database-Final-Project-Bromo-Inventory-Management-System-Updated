package bromomanagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class MahasiswaModel extends Koneksi {

    public MahasiswaModel() throws SQLException {
    }
    
    public DefaultTableModel GetAll() throws SQLException {
        Connection cn = super.GetConnection();
        Statement cmd = cn.createStatement();
        ResultSet rs = cmd.executeQuery("SELECT * FROM barang");
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode");
        model.addColumn("Nama_barang");
        model.addColumn("Tanggal_masuk");
        model.addColumn("Tipe");
        model.addColumn("Distributor");
        model.addColumn("Stock");
        while (rs.next()) {
            model.addRow(new Object[] 
            {
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                
            });
        }
        
        return model;
    }
    
    public void Delete(String kode) throws SQLException {
        final String sql = "DELETE FROM barang WHERE kode = ?";
        Connection cn = super.GetConnection();
        PreparedStatement cmd = cn.prepareStatement(sql);
        
        cmd.setString(1, kode);
        cmd.execute();
    }
    
    public void Insert(String kode, String Nama_barang, String Tanggal_masuk, String Tipe, String Distributor, String Stock) throws SQLException {
        final String sql = "INSERT INTO barang VALUES(?, ?, ?, ?, ?, ?)";
        Connection cn = super.GetConnection();
        PreparedStatement cmd = cn.prepareStatement(sql);
        
        cmd.setString(1, kode);
        cmd.setString(2, Nama_barang);
        cmd.setString(3, Tanggal_masuk);
        cmd.setString(4, Tipe);
        cmd.setString(5, Distributor);
        cmd.setString(6, Stock);
        
        cmd.execute();
    }
    
    public void Update(String kode, String Nama_barang, String Tanggal_masuk, String Tipe, String Distributor, String Stock) throws SQLException {
        final String sql = "UPDATE barang SET Nama_barang = ?, Tanggal_masuk = ?, Tipe = ?, Distributor = ?, Stock = ? WHERE kode = ?";
        Connection cn = super.GetConnection();
        PreparedStatement cmd = cn.prepareStatement(sql);
        
        cmd.setString(1, Nama_barang);
        cmd.setString(2, Tanggal_masuk);
        cmd.setString(3, Tipe);
        cmd.setString(4, Distributor);
        cmd.setString(5, Stock);
        cmd.setString(6, kode);
        
        cmd.execute();
    }
    
      public void UpdateDis(String Distributor, String Nama_barang) throws SQLException {
        final String sql = "UPDATE distributor SET distributor = ?, Nama_barang = ?";
        Connection cn = super.GetConnection();
        PreparedStatement cmd = cn.prepareStatement(sql);
        
        
        
        cmd.setString(1, Distributor);
        cmd.setString(2, Nama_barang);
        
        cmd.execute();
    }
     public void InsertDis(String Distributor, String Nama_barang) throws SQLException {
        final String sql = "INSERT INTO distributor VALUES(?, ?)";
        Connection cn = super.GetConnection();
        PreparedStatement cmd = cn.prepareStatement(sql);
        
        cmd.setString(1, Distributor);
        cmd.setString(2, Nama_barang);
        cmd.execute();
    }
}

