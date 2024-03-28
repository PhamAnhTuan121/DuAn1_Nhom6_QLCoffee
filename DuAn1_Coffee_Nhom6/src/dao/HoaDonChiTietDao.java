/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Dao.impl.InterfaceHoadonchittiet;
import Model.HoaDonChiTiet;
import Helper.JDBCHeper;
import java.sql.ResultSet;
import Model.SanPham;
import java.util.ArrayList;
import java.util.List;

public class HoadonchitietDAO implements InterfaceHoadonchittiet {

    String INSERT_SQL = "INSERT dbo.HoaDonChiTiet VALUES (?,?,?,?,?,?,?,?)";
    String UPDATE_SQL_TrangThai = "UPDATE dbo.HoaDonChiTiet SET TTthanhtoan = ?  WHERE ID_HoaDon = ? AND ID_SanPham = ?";
    String UPDATE_SQL_IDHoaDon = "UPDATE dbo.HoaDonChiTiet SET ID_HoaDon = ?  WHERE ID_HoaDon = ? AND ID_SanPham = ? ";
    String UPDATE_SQL_soluong = "UPDATE dbo.HoaDonChiTiet SET Soluong = ?, TongGia = ?, ghichu = ?, Gia = ? WHERE ID_HoaDon = ? AND ID_SanPham = ?";
    //String UPDATE_SQL_TrangThaiTT = "UPDATE dbo.HoaDon SET TTThanhtoan = ? WHERE ID_Hoadon = ?";
    String DELETE_SQL = "DELETE FROM dbo.HoaDonChiTiet WHERE ID_Hoadon = ? AND ID_SanPham = ?";
    String SELECT_ALL_SQL = "SELECT * FROM dbo.HoaDon";
    String SELECT_ALL_BY_ID_HD = "SELECT * FROM dbo.HoaDonChiTiet JOIN dbo.HoaDon ON HoaDon.ID_Hoadon = HoaDonChiTiet.ID_HoaDon \n"
            + "WHERE dbo.HoaDonChiTiet.TTThanhtoan = 1 AND HoaDon.ID_Hoadon = ? ";
    String SELECT_ALL_BY_ID_Ban = "SELECT * FROM dbo.HoaDonChiTiet JOIN dbo.HoaDon ON HoaDon.ID_Hoadon = HoaDonChiTiet.ID_HoaDon \n"
            + "        JOIN dbo.BanChiTiet ON BanChiTiet.ID_Hoadon = HoaDon.ID_Hoadon JOIN dbo.Ban ON Ban.ID_Ban = BanChiTiet.ID_Ban \n"
            + "        WHERE HoaDon.TTThanhtoan = 0 \n"
            + "       AND dbo.HoaDonChiTiet.TTthanhtoan = 1  AND dbo.HoaDon.Trangthai = 1 AND dbo.Ban.Hoatdong = 0 AND dbo.Ban.ID_Ban = ?";
    String SELECT_BY_ID_SQL = "SELECT * FROM dbo.HoaDonChiTiet WHERE ID_HoaDon = ? AND ID_SanPham = ?";
    String SELECT_BY_ID_MaHD_TT1 = "SELECT * FROM dbo.HoaDonChiTiet JOIN dbo.HoaDon ON HoaDon.ID_Hoadon = HoaDonChiTiet.ID_HoaDon \n"
            + "WHERE dbo.HoaDonChiTiet.TTThanhtoan = 1 AND HoaDon.ID_Hoadon = ? AND ID_SanPham = ?";
    String SELECT_BY_ID_MaHD_TT0 = "SELECT * FROM dbo.HoaDonChiTiet JOIN dbo.HoaDon ON HoaDon.ID_Hoadon = HoaDonChiTiet.ID_HoaDon \n"
            + "WHERE dbo.HoaDonChiTiet.TTThanhtoan = 0 AND HoaDon.ID_Hoadon = ? AND ID_SanPham = ?";
    String UPDATE_LY_DO_HUY = "UPDATE dbo.HoaDonChiTiet SET Lydohuy = ? WHERE ID_HoaDon = ? AND ID_SanPham = ?";
    String UPDATE_Ghi_chu = "UPDATE dbo.HoaDonChiTiet SET ghichu = ? WHERE ID_HoaDon = ? AND ID_SanPham = ?";
    String selcecCountSPhuy = "SELECT COUNT(*) AS Soluongdonhuy FROM dbo.HoaDonChiTiet WHERE TTthanhtoan = 0 AND ID_HoaDon = ?";
    String SELECT_BY_ID_SQL_1 = "SELECT * FROM dbo.HoaDonChiTiet WHERE ID_HoaDon = ?";
    
