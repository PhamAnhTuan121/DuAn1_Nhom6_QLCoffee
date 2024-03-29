/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import Model.Hoadon;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View.QuanLyHoaDonJPanel;
import java.util.ArrayList;
import java.util.List;
import Dao.HoaDonDAO;
import Helper.Auth;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import java.text.NumberFormat;
/**
/**
 *
 * @author ctuye
 */
public class SerHoaDon {
     HoaDonDAO dao = new HoaDonDAO();
    Locale vn = new Locale("vi", "VN");
    public void filltotablehoadon() {
        List<Hoadon> list = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) QuanLyHoaDonJPanel.tblHoadon.getModel();
        model.setRowCount(0);
        try {
            list = dao.selectByIdNV(Auth.user.getId_Nhanvien());
            for (Hoadon hd : list) {
                model.addRow(new Object[]{
                    hd.getIdHoaDon(),
                    hd.getNgayTao(),
                    hd.isTrangThai() ? "Hoạt Động" : "Hủy Đơn",
                    hd.isTrangThaiTT() ? "Đã Thanh Toán" : "Chưa Thanh Toán",
                    hd.getIdNhanVien(),
                    NumberFormat.getInstance().format(hd.getThanhTien()),
                    hd.getSlSanPhamHuy(),
                        hd.getSDT()

                });
            }
        } catch (Exception e) {
        }
    }
    public void filltotablehoadon_chuathanhtoan() {
        List<Hoadon> list = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) QuanLyHoaDonJPanel.tblHoadon.getModel();
        model.setRowCount(0);
        try {
            list = dao.selectAll_trangthai1_chuathanhtoan(Auth.user.getId_Nhanvien());
            for (Hoadon hd : list) {
                model.addRow(new Object[]{
                    hd.getIdHoaDon(),
                    hd.getNgayTao(),
                    hd.isTrangThai() ? "Hoạt Động" : "Hủy Đơn",
                    hd.isTrangThaiTT() ? "Đã Thanh Toán" : "Chưa Thanh Toán",
                    hd.getIdNhanVien(),
                   NumberFormat.getInstance().format(hd.getThanhTien()),
                    hd.getSlSanPhamHuy(),
                        hd.getSDT()

                });
            }
        } catch (Exception e) {
        }
    }
}
