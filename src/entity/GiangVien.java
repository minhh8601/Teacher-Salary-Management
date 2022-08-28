package entity;

import java.util.Scanner;

public class GiangVien extends Nguoi {
    public static final String GSTS="GS-TS";
    public static final String PGSTS="PGS-TS";
    public static final String GVC="Giảng viên chính";
    public static final String TS="Thạc sỹ";
    private static int AUTO_ID=-1;
    private int maGV;
    private String trinhDo;

    private double tienLuong;

    public GiangVien(){
        if(AUTO_ID==-1){
            AUTO_ID=100;
            this.maGV=++AUTO_ID;
            return;
        }
        this.maGV=++AUTO_ID;
    }

    public GiangVien(int maGV,String hoTen,String diaChi,String sdt, String trinhDo) {
        this.maGV = maGV;
        this.hoTen=hoTen;
        this.diaChi=diaChi;
        this.sdt=sdt;
        this.trinhDo = trinhDo;

    }

    public int getMaGV() {
        return maGV;
    }

    public void setMaGV(int maGV) {
        this.maGV = maGV;
    }
    @Override
    public void setHoTen(String hoTen){
        this.hoTen=hoTen;
    }
    @Override
    public String getDiaChi(){
        return diaChi;
    }
    @Override
    public void setDiaChi(String diaChi){
        this.diaChi=diaChi;
    }
    @Override
    public String getSdt(){
        return sdt;
    }
    @Override
    public void setSdt(String sdt){
        this.sdt=sdt;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    @Override
    public String toString(){
        return "entity.GiangVien{" +
                "Mã giảng viên=" + maGV +
                ", Họ tên='" + hoTen + '\'' +
                ", Địa chỉ='" + diaChi + '\'' +
                ", Trình độ='" + trinhDo + '\'' +
                '}';
    }

    public void inputInfo(){
        System.out.print("Nhập tên giảng viên: ");
        this.hoTen=new Scanner(System.in).nextLine();
        System.out.print("Nhập địa chỉ giảng viên: ");
        this.diaChi=new Scanner(System.in).nextLine();
        System.out.print("Nhập số điện thoại giảng viên: ");
        this.sdt=new Scanner(System.in).nextLine();
        System.out.println("Nhập trình độ là 1 trong các lựa chọn dưới đây: ");
        System.out.println("1. GS-TS");
        System.out.println("2. PGS-TS");
        System.out.println("3. Giảng viên chính");
        System.out.println("4. Thạc sĩ");
        int choice=-1;
        do{
            choice=new Scanner(System.in).nextInt();
            if(choice>=1 && choice<=4){
                break;
            }
            System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại");
        }while(choice>4 || choice<1);
        switch (choice){
            case 1:
                this.trinhDo = GiangVien.GSTS;
                break;
            case 2:
                this.trinhDo = GiangVien.PGSTS;
                break;
            case 3:
                this.trinhDo = GiangVien.GVC;
                break;
            case 4:
                this.trinhDo = GiangVien.TS;
                break;
        }
    }
}
