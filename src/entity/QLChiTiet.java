package entity;

public class QLChiTiet {
    private MonHoc monHoc;
    private int soLop;

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public int getSoLop() {
        return soLop;
    }

    public void setSoLop(int soLop) {
        this.soLop = soLop;
    }

    @Override
    public String toString(){
        return "QLChiTiet{" +
                "Môn học=" + monHoc +
                ", Số lớp=" + soLop +
                '}';
    }
}
