/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import Model.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import View.HoadonchitietJDialog;
import Dao.HoadonchitietDAO;
import Model.DonViSanPham;
import Model.GiamGiaChiTiet;
import Model.Hoadon;
import Dao.*;
import Model.SanPham;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.NumberFormat;
import java.util.Locale;
/**
 *
 * @author ctuye
 */
public class SerHoaDonChiTiet {
    Locale vn = new Locale("vi", "VN");
     HoadonchitietDAO dao=new HoadonchitietDAO();
     DaoGiamGia DAOGG = new DaoGiamGia();
    ChiTietGiamGiaDao DAOGGCT = new ChiTietGiamGiaDao();
      public void filltotablehoadonchitiet(int a){
       List<HoaDonChiTiet> list = new ArrayList<>();
        DefaultTableModel model=(DefaultTableModel) HoadonchitietJDialog.tblHoaDonChiTiet.getModel();
        model.setRowCount(0);
        try {
          list= dao.selectById1(a);
           for (HoaDonChiTiet hd : list) {
//               hd.setGia(GiaTheoSize(hd.getID_SanPHam()));
//               hd.setTongGia(hd.getGia() * hd.getSoluong());
                model.addRow(new Object[]{
                    hd.getID_Hoadon(),
                    hd.getID_SanPHam(),
                    hd.getSoluong(),
//                    GiaTheoSize(hd.getID_SanPHam()),
//                    GiaTheoSize(hd.getID_SanPHam()) * hd.getSoluong(),
                    NumberFormat.getInstance().format(hd.getGia()),
                    NumberFormat.getInstance().format(hd.getTongGia()* hd.getSoluong()),
                    hd.isTrangThai() ?"" : "Hủy",
                        hd.getLyDoHuy()
                    
                });
                 
            }
       } catch (Exception e) {
       }
    }
