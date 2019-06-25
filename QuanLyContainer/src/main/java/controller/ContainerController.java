package controller;

import model.Container;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContainerController implements IContainerController {


    ArrayList<Container> containerList = new ArrayList<>(5);
    @Override
    public void nhap() {
        Container con = new Container();
        Scanner sc = new Scanner(System.in);
        Pattern p;
        Matcher m = null;
        p = Pattern.compile("[A-Z]{4}\\d{7}");
        while (true) {
            boolean containerFlag = false;
            System.out.print("Nhap ma so container: ");
            String maSo = sc.nextLine().trim();
            m = p.matcher(maSo);
            if (m.matches()) {
                for(Container con1: containerList){
                    if (con1.getMaSo().equals(maSo)){
                        containerFlag = true;
                        break;
                    }
                }
                if (containerFlag == true) {
                    System.out.println("mã số trùng");
                    continue;
                }
                else {
                    con.setMaSo(maSo);
                    break;
                }
            }
            System.out.println("Ma ko hop le ! vi du ABCD1234567,...... ");
        }

        while (true) {
            System.out.print("Nhap chieu dai container: ");
            int chieuDai = Integer.parseInt(sc.nextLine().trim());

            if (chieuDai > 0) {
                con.setChieuDai(chieuDai);
                break;
            }
            System.out.println("chieu dai phai lon hon 0 ! ");
        }

        while (true) {
            System.out.print("Nhap chieu rong container: ");
            int chieuRong = Integer.parseInt(sc.nextLine().trim());

            if (chieuRong > 0) {
                con.setChieuRong(chieuRong);
                break;
            }
            System.out.println("chieu rong phai lon hon 0 ! ");
        }

        p = Pattern.compile("(loai thuong|loai dong lanh)");
        while (true) {
            System.out.print("Nhap loai container: ");
            String loaiContainer = sc.nextLine().trim();
            m = p.matcher(loaiContainer);
            if (m.matches()) {
                con.setLoaiContainer(loaiContainer);
                break;
            }

            System.out.println("loai container khong hop le ! (loai thuong|loai dong lanh) ");
        }

        p = Pattern.compile("(tot|hong)");
        while (true) {
            System.out.print("Nhap tinh trang container (tot|hong): ");
            String coHuHongContainer = sc.nextLine().trim();
            m = p.matcher(coHuHongContainer);
            if (m.matches()) {
                con.setCoHuHongContainer(coHuHongContainer);
                break;
            }

            System.out.println("tinh trang container khong hop le ! (tot|hong)");

        }

        while(true){
            System.out.println("Nhap ngay vao cang theo: YYYY-MM-DD");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ngayvVaoCang = sc.nextLine();
            try {
                con.setNgayVaoCang(sdf.parse(ngayvVaoCang));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            break;
        }
        containerList.add(con);

//        while (true){
//
//            System.out.print("nhập ngày vào cảng yyyy-MM-dd: ");
//            String myDate = sc.next();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            ngayVaoCang=null;
//            try {
//                //Parsing the String
//                ngayVaoCang = sdf.parse(myDate);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }

    }

    @Override
    public void display() {
        if (containerList.isEmpty()) {
            System.out.println("hệ thống chưa có dữ liệu !");
            return;
        }
        for (Container item : containerList) {
            System.out.println(item);
        }
    }

    @Override
    public void display(String phanLoai) {
        phanLoai=phanLoai.toLowerCase();
        int count=0;
        for (Container item : containerList) {
            if(item.getLoaiContainer().toLowerCase().contains(phanLoai)){
                System.out.println(item);
                count++;
            }

        }
        if(count == 0){
            System.out.println("không tìm thấy loại container cần tìm"+phanLoai);
        }
    }

    @Override
    public void search(String tinhTrang) {
        tinhTrang=tinhTrang.toLowerCase();
        int count=0;
        for (Container item : containerList) {
            if(item.getCoHuHongContainer().toLowerCase().contains(tinhTrang)){
                System.out.println(item);
                count++;
            }

        }
        if(count==0){
            System.out.println("không tìm thấy yêu cầu"+tinhTrang);
        }
    }

    @Override
    public void checkContainer() {
        ArrayList<Container> lstCon = new ArrayList<>();
        for (Container con: containerList) {
            Date now = new Date();
            if(con.getNgayVaoCang().before(now)){
                con.setHoldFlag("Y");
                Scanner sc = new Scanner(System.in);
                System.out.println("Vui long tra tien de ra khoi cang: ");
                int money = sc.nextInt();
                if (money >= 1000){
                    con.setHoldFlag("N");
                }
            }else{
                con.setHoldFlag("N");
            }
        }

    }
}

