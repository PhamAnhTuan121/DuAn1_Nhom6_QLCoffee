
package model;
public class DonViSanPham {

    private String ID_DonviSP;
    private String TenDonvi;
    private int Kichthuoc;
    private int ThemTien;

    public DonViSanPham() {
    }

    public DonViSanPham(String ID_DonviSP, String TenDonvi, int Kichthuoc, int ThemTien) {
        this.ID_DonviSP = ID_DonviSP;
        this.TenDonvi = TenDonvi;
        this.Kichthuoc = Kichthuoc;
        this.ThemTien = ThemTien;
    }

    public String getID_DonviSP() {
        return ID_DonviSP;
    }

    public void setID_DonviSP(String ID_DonviSP) {
        this.ID_DonviSP = ID_DonviSP;
    }

    public String getTenDonvi() {
        return TenDonvi;
    }

    public void setTenDonvi(String TenDonvi) {
        this.TenDonvi = TenDonvi;
    }

    public int getKichthuoc() {
        return Kichthuoc;
    }

    public void setKichthuoc(int Kichthuoc) {
        this.Kichthuoc = Kichthuoc;
    }

    public int getThemTien() {
        return ThemTien;
    }

    public void setThemTien(int ThemTien) {
        this.ThemTien = ThemTien;
    }

    @Override
    public String toString() {
        return "DonViSanPham{" + "ID_DonviSP=" + ID_DonviSP + ", TenDonvi=" + TenDonvi + ", Kichthuoc=" + Kichthuoc + ", ThemTien=" + ThemTien + '}';
    }
    
}
