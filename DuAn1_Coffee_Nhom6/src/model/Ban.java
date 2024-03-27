/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Ban {

    private int idBan;
    private boolean trangThai;
    private boolean hoatDong;
    private int soluongcho;

    public Ban() {
    }

    public Ban(int idBan, boolean trangThai, boolean hoatDong, int soluongcho) {
        this.idBan = idBan;
        this.trangThai = trangThai;
        this.hoatDong = hoatDong;
        this.soluongcho = soluongcho;
    }

    public int getIdBan() {
        return idBan;
    }

    public void setIdBan(int idBan) {
        this.idBan = idBan;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public boolean isHoatDong() {
        return hoatDong;
    }

    public void setHoatDong(boolean hoatDong) {
        this.hoatDong = hoatDong;
    }

    public int getSoluongcho() {
        return soluongcho;
    }

    public void setSoluongcho(int soluongcho) {
        this.soluongcho = soluongcho;
    }

    @Override
    public String toString() {
        return "Ban{" + "idBan=" + idBan + ", trangThai=" + trangThai + ", hoatDong=" + hoatDong + ", soluongcho=" + soluongcho + '}';
    }
    
}
