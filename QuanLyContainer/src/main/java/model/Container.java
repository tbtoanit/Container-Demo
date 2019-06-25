package model;

import java.util.*;
import java.util.regex.*;

import java.util.Date;


import java.util.regex.Pattern;
import java.lang.String;


public class Container {
    private String maSo;
    private int chieuDai;
    private int chieuRong;
    private String loaiContainer;
    private String coHuHongContainer;
    private Date ngayVaoCang;
    private String holdFlag;

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public int getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(int chieuDai) {
        this.chieuDai = chieuDai;
    }

    public int getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(int chieuRong) {
        this.chieuRong = chieuRong;
    }

    public String getLoaiContainer() {
        return loaiContainer;
    }

    public void setLoaiContainer(String loaiContainer) {
        this.loaiContainer = loaiContainer;
    }

    public String getCoHuHongContainer() {
        return coHuHongContainer;
    }

    public void setCoHuHongContainer(String coHuHongContainer) {
        this.coHuHongContainer = coHuHongContainer;
    }

    public Date getNgayVaoCang() {
        return ngayVaoCang;
    }

    public void setNgayVaoCang(Date ngayVaoCang) {
        this.ngayVaoCang = ngayVaoCang;
    }

    public String getHoldFlag() {
        return holdFlag;
    }

    public void setHoldFlag(String holdFlag) {
        this.holdFlag = holdFlag;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %d, %s, %s, %s, %s", maSo, chieuDai, chieuRong, loaiContainer, coHuHongContainer, ngayVaoCang, holdFlag);
    }
}
