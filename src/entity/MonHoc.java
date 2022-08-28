package entity;

import java.util.Scanner;

public class MonHoc {
    private static int AUTO_ID=-1;
    private int maMonHoc;
    private String tenMonHoc;
    private int tongSoTiet;
    private int soTietLyThuyet;
    private double mucKinhPhi;

    public MonHoc(){
        if(AUTO_ID==-1){
            AUTO_ID=100;
            this.maMonHoc=++AUTO_ID;
            return;
        }this.maMonHoc=++AUTO_ID;
    }

    public int getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(int maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public int getTongSoTiet() {
        return tongSoTiet;
    }

    public void setTongSoTiet(int tongSoTiet) {
        this.tongSoTiet = tongSoTiet;
    }

    public int getSoTietLyThuyet() {
        return soTietLyThuyet;
    }

    public void setSoTietLyThuyet(int soTietLyThuyet) {
        this.soTietLyThuyet = soTietLyThuyet;
    }

    public double getMucKinhPhi() {
        return mucKinhPhi;
    }

    public void setMucKinhPhi(double mucKinhPhi) {
        this.mucKinhPhi = mucKinhPhi;
    }

    @Override
    public String toString(){
        return "entity.MonHoc{" +
                "Mã môn học=" + maMonHoc +
                ", Tên môn học='" + tenMonHoc + '\'' +
                ", Tổng số tiết='" + tongSoTiet + '\'' +
                ", Số tiết lý thuyết='" + soTietLyThuyet + '\'' +
                ", Mức kinh phí='" + mucKinhPhi + '\'' +
                '}';
    }
    public void inputInfo(){
        System.out.print("Nhập tên môn học : ");
        this.tenMonHoc=new Scanner(System.in).nextLine();
        System.out.print("Nhập tổng số tiết dạy: ");
        this.tongSoTiet=new Scanner(System.in).nextInt();
        System.out.print("Nhập số tiết lý thuyết: ");
        this.soTietLyThuyet=new Scanner(System.in).nextInt();
        System.out.print("Nhập mức kinh phí: ");
        this.mucKinhPhi=new Scanner(System.in).nextDouble();
    }
}
