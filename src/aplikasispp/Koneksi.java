/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasispp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection mysqlkoneksi;
    
    public static Connection configDB() {
        try {
            // URL khusus agar cocok dengan MySQL 8 di Laragon
            String url = "jdbc:mysql://127.0.0.1:3306/db_spp?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"; 
            String user = "root";
            String pass = ""; 
            
            // Daftarkan driver
            // Tambahkan ".cj" di tengahnya. Ini wajib untuk driver versi baru (8.0 ke atas)
            Class.forName("com.mysql.cj.jdbc.Driver");
            mysqlkoneksi = DriverManager.getConnection(url, user, pass);
            
        } catch (Exception e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
        }
        return mysqlkoneksi;
    }
}
