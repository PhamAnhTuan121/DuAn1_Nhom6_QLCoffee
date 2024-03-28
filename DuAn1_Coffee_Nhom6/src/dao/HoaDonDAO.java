/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Dao.impl.InterfaceHoadon;
import Model.Hoadon;
import Helper.JDBCHeper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ctuye
 */
public class HoaDonDAO implements InterfaceHoadon {

    String INSERT_SQL = "INSERT dbo.HoaDon VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL_TrangThai = "UPDATE dbo.HoaDon SET Trangthai = ? WHERE ID_Hoadon = ?";
    String UPDATE_SQL_khachhang = "UPDATE dbo.HoaDon SET SDT = ?,Ten = ?,tenShip =?,diaChi =? WHERE ID_Hoadon = ?";
    String UPDATE_SQL_TrangThaiTT = "UPDATE dbo.HoaDon SET TTThanhtoan = ? WHERE ID_Hoadon = ?";
    String UPDATE_SQL_ThanhTien = "UPDATE dbo.HoaDon SET Thanhtien = ? WHERE ID_Hoadon = ?";
    String UPDATE_SQL_Ly_DO = "UPDATE dbo.HoaDon SET Lydohuy = ? WHERE ID_Hoadon = ?";
    String UPDATE_SQL_DEM_SP_HUY = "UPDATE dbo.HoaDon SET Soluongsanphamhuy = ? WHERE ID_Hoadon = ?";
    String DELETE_SQL = "{CALL chuyendon(?)}";
    String SELECT_ALL_SQL = "SELECT * FROM dbo.HoaDon";
    String SELECT_ALL_SQL_HD_CTT_BY_ID_BAN = "SELECT * FROM dbo.HoaDon JOIN dbo.BanChiTiet ON BanChiTiet.ID_Hoadon = HoaDon.ID_Hoadon WHERE TTThanhtoan = 0 AND dbo.HoaDon.Trangthai = 1 AND  ID_Ban = ? ";
    String SELECT_ALL_SQL_HD_CTT = "SELECT * FROM dbo.HoaDon where Trangthai = 1 AND TTThanhtoan = 0";
    String SELECT_BY_ID_SQL = "SELECT * FROM dbo.HoaDon WHERE ID_Hoadon = ?";
    String SELECT_ALL_SQL_trangthai = "SELECT * FROM dbo.HoaDon where Trangthai = 1 and ID_Nhanvien =?";
    String SELECT_ALL_SQL_trangthai1 = "SELECT * FROM dbo.HoaDon where Trangthai = 1";
    String SELECT_ALL_SQL_trangthai1_chuathanhtoan = "SELECT * FROM dbo.HoaDon where Trangthai = 1 AND TTThanhtoan = 0 and ID_Nhanvien=?";
    String SELECT_ALL_SQL_trangthai1_dathanhtoan = "SELECT * FROM dbo.HoaDon where Trangthai = 1 AND TTThanhtoan = 1 and ID_Nhanvien=?";
    String SELECT_ALL_SQL_trangthai0 = "SELECT * FROM dbo.HoaDon where Trangthai = 0 and ID_Nhanvien=?";
    String SELECT_ALL_SQL_trangthai0_chuathanhtoan = "SELECT * FROM dbo.HoaDon where Trangthai = 0 AND TTThanhtoan = 0 and ID_Nhanvien=?";
    String SELECT_ALL_SQL_trangthai0_dathanhtoan = "SELECT * FROM dbo.HoaDon where Trangthai = 0 AND TTThanhtoan = 1 and ID_Nhanvien=?";
    String select_all_sql_find_HOATDOng = "select *from HoaDon where Ngaytao between ? and ? and Trangthai = 1";
    String select_all_sql_find_HOATDOng_chuathanhtoan = "select *from HoaDon where Ngaytao between ? and ? and Trangthai = 1 and TTThanhtoan = 0";
    String select_all_sql_find_HOATDOng_dathanhtoan = "select *from HoaDon where Ngaytao between ? and ? and Trangthai = 1 and TTThanhtoan = 1";
    String select_all_sql_find_KoHoatDong = "select *from HoaDon where Ngaytao between ? and ? and Trangthai = 0";
    String select_all_sql_find_KoHoatDong_dathanhtoan = "select *from HoaDon where Ngaytao between ? and ? and Trangthai = 0 AND TTThanhtoan = 1";
    String select_all_sql_find_KoHoatDong_chuathanhtoan = "select *from HoaDon where Ngaytao between ? and ? and Trangthai = 0 AND TTThanhtoan = 0";
    String select_all_sql_find_HOATDOng_keyword_IDHoaDon = "select *from HoaDon where Ngaytao between ? and ? and Trangthai = 1";
    String select_all_sql_find_KoHoatDong_keyword_IDHoaDon = "select *from HoaDon where Ngaytao between ? and ? and Trangthai = 0";
    String select_all_sql_find_KoHoatDong_keyword_IDMaNV = "SELECT * FROM HoaDon WHERE ID_Nhanvien LIKE ? and Trangthai = 0 ";
    String select_all_sql_find_HoatDong_keyword_IDMaNV = "SELECT * FROM HoaDon WHERE ID_Nhanvien LIKE ? and Trangthai = 1 ";
    String select_all_sql_find_KoHoatDong_1ngay = "select *from HoaDon where Ngaytao =?  and Trangthai = 1 ";
    String select_all_sql_find_KoHoatDong_1ngay_dathanhtoan = "select *from HoaDon where Ngaytao =?  and Trangthai = 1 AND TTThanhtoan = 1";
    String select_all_sql_find_KoHoatDong_1ngay_chuathanhtoan = "select *from HoaDon where Ngaytao =?  and Trangthai = 1 AND TTThanhtoan = 0";
    String select_all_sql_find_HoatDong_1ngay = "select *from HoaDon where Ngaytao =?  and Trangthai = 0";
    String select_all_sql_find_HoatDong_1ngay_dathanhtoan = "select *from HoaDon where Ngaytao =?  and Trangthai = 0 AND TTThanhtoan = 1";
    String select_all_sql_find_HoatDong_1ngay_chuathanhtoan = "select *from HoaDon where Ngaytao =?  and Trangthai = 0 AND TTThanhtoan = 0";
    
    