package controller;

import model.Container;

import java.util.ArrayList;

public interface IContainerController {
    // Cho phep nhap container
    public void nhap();

    // In danh sach tat ca container
    public void display();

    // In danh sach theo loai container
    public void display(String phanLoai);

    //In danh sach theo trang thai container
    public void search(String tinhTrang);

    // Kiem tra terminal In date cua container
    public void checkContainer();
}
