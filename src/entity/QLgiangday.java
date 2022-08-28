package entity;

public class QLgiangday {
    private GiangVien giangVien;

    private MonHoc monHoc;

    private QLChiTiet quanlyct;
    private QLChiTiet[]QLCT;

    private  TienLuong[] qlTienLuong;

    private QLChiTiet getQuanlyct(){
        return quanlyct;
    }

    public GiangVien getGiangVien(){
        return giangVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public void setGiangVien(GiangVien giangVien){
        this.giangVien=giangVien;
    }

    public QLChiTiet[] getQLCT() {
        return QLCT;
    }

    public void setQLCT(QLChiTiet[] QLCT) {
        this.QLCT = QLCT;
    }

    public TienLuong[] getQlTienLuong(){
        return qlTienLuong;
    }

    public void setQlTienLuong(TienLuong[] qlTienLuong) {
        this.qlTienLuong = qlTienLuong;
    }
}
