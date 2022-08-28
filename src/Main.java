import entity.GiangVien;
import entity.MonHoc;
import entity.QLgiangday;
import entity.QLChiTiet;
import java.util.Scanner;
public class Main {
    private static GiangVien[] LECTURERS=new GiangVien[100];
    private static MonHoc[] SUBJECTS= new MonHoc[100];
    private static QLgiangday[] TEACHING = new QLgiangday[100];

    public static void main(String[] args) {
        Menu();
    }
    private static void Menu(){
        while (true){
            int funtionChoice=funtionChoice();
            switch (funtionChoice){
                case 1:
                    nhapGiangVienMoi();
                    break;
                case 2:
                    hienthiGiangVien();
                    break;
                case 3:
                    nhapMonHocMoi();
                    break;
                case 4:
                    hienthiMonHoc();
                    break;
                case 5:
                    taoKeKhaiGiangDay();
                    hienDSKeKhai();
                    break;
                case 6:
                    hienDSKeKhai();
                    break;
                case 7:
                    SortbyName();
                    SortbyQuantiyy();
                    break;
                case 8:
                    CreateTinhLuong();
                    break;
                case 9:
                    System.out.println("Xin cảm ơn đã sử dụng phần mềm của chúng tôi");
                    return;
            }
        }
    }
    private static int funtionChoice(){
        System.out.println("\n\n===== PHẦN MỀM QUẢN LÝ TRẢ LƯƠNG GIẢNG VIÊN =====\n\n");
        System.out.println("1. Nhập danh sách giảng viên mới.");
        System.out.println("2. In ra danh sách giảng viên trong hệ thống.");
        System.out.println("3. Nhập danh sách môn học mới.");
        System.out.println("4. In ra danh sách môn học trong hệ thống.");
        System.out.println("5. Lập kê khai giảng dạy cho giảng viên.");
        System.out.println("6. In ra danh sách kê khai giảng dạy.");
        System.out.println("7. Sắp xếp danh sách kê khai.");
        System.out.println("8. Tính lương giảng viên.");
        System.out.println("9. Thoát chương trình");
        System.out.println("--------------------------------------");
        System.out.print("Xin mời nhập lựa chọn của bạn: ");
        int funtionChoice=-1;
        do{
            funtionChoice=new Scanner(System.in).nextInt();
            if(funtionChoice>=1 && funtionChoice<=9){
                break;
            }
            System.out.print("Chức năng chọn không họp lệ, vui lòng chọn lại: ");
        }while(funtionChoice>9||funtionChoice<1);
        return funtionChoice;
    }
    //Nhập giảng viên mới
    private static void nhapGiangVienMoi(){
        //nhập khách hàng mới

        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập số lượng giảng viên mới cần thêm:");
        int slgiangvien=sc.nextInt();
        for (int i = 0; i < slgiangvien; i++) {
            System.out.println("Nhập thông tin giảng viên thứ "+(i+1));
            //Nhập thông tin giảng viên
           GiangVien gv =new GiangVien();
            gv.inputInfo();
            //Lưu thông tin vào mảng LECTURERS
            luuGiangVien(gv);
        }

    }
    //Lưu giảng viên
    private static void luuGiangVien(GiangVien giangVien){
        for (int i = 0; i <LECTURERS.length; i++) {
            if(LECTURERS[i]==null){
                LECTURERS[i]=giangVien;
                break;
            }
        }
    }

    private static void hienthiGiangVien(){
        for (int i = 0; i < LECTURERS.length; i++) {
            if(LECTURERS[i]==null){
                continue;
            }
            System.out.println(LECTURERS[i]);
        }
    }

    private static void nhapMonHocMoi(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số lượng môn học mới cần thêm:");
        int slmonhoc=sc.nextInt();
        for (int i = 0; i < slmonhoc; i++) {
            System.out.println("Nhập thông tin môn học thứ "+(i+1));
            MonHoc monHoc=new MonHoc();
            monHoc.inputInfo();
            luuMonHoc(monHoc);
        }
    }

    private static void luuMonHoc(MonHoc monHoc){
        for (int i = 0; i <SUBJECTS.length; i++) {
            if(SUBJECTS[i]==null){
                SUBJECTS[i]=monHoc;
                break;
            }
        }
    }

    public static void hienthiMonHoc(){
        for (int i = 0; i < SUBJECTS.length; i++) {
            if(SUBJECTS[i]==null){
                continue;
            }
            System.out.println(SUBJECTS[i]);
        }
    }

    private static void taoKeKhaiGiangDay(){

        Scanner sc=new Scanner(System.in);
        if(!checkData()){
            System.out.println("Dữ liệu về giảng viên và môn học rỗng, vui lòng thêm dữ liệu.");
            return;
        }
        System.out.println("Nhập số lượng giảng viên cần kê khai:");
        int slgv=sc.nextInt();
        for (int i = 0; i < slgv; i++) {
            QLgiangday qlgd = new QLgiangday();
            GiangVien giangVien=  nhapGiangVien(i);

            qlgd.setGiangVien(giangVien);

            QLChiTiet[] chitiet= taoQLChiTiet();
            qlgd.setQLCT(chitiet);

            saveQLGD(qlgd);

        }
    }
    private static void saveQLGD(QLgiangday qlgd){
        for (int i = 0; i < TEACHING.length; i++) {
            if(TEACHING[i]==null){
                TEACHING[i]=qlgd;
                return;
            }
        }
    }

    private static void hienDSKeKhai(){
        for (int i = 0; i <TEACHING.length ; i++) {
            QLgiangday QUANLY=TEACHING[i];
            if(QUANLY!=null){
                System.out.println("Giang viên "+QUANLY.getGiangVien().getHoTen()+"đã chọn môn học sau:");
                for (int j = 0; j < QUANLY.getQLCT().length; j++) {
                    System.out.println(QUANLY.getQLCT()[j]);

                }
                System.out.println("_______________________");
            }
        }
    }

    private static boolean checkData(){
        boolean CSDLGiangVien=false;
        for (int i = 0; i < LECTURERS.length; i++) {
            if(LECTURERS[i]!=null){
                CSDLGiangVien=true;
                break;
            }
        }
        boolean CSDLMonHoc=false;
        for (int i = 0; i < SUBJECTS.length; i++) {
            if(SUBJECTS[i]!=null){
                CSDLMonHoc=true;
                break;
            }
        }
        return CSDLGiangVien && CSDLMonHoc;
    }

    private static QLChiTiet[] taoQLChiTiet(){
        System.out.println("Nhập số lượng môn học giảng viên đăng ký dạy:");
        int slmon= new Scanner(System.in).nextInt();
        QLChiTiet[] chiTiets=new QLChiTiet[slmon];
        for (int i = 0; i < slmon; i++) {
            QLChiTiet qlChiTiet=new QLChiTiet();

            //xác định được xem giảng viên dạy môn nào
            //bắt bgiảng viên nhập mã môn học muốn dạy
            MonHoc monHoc= nhapMonHoc(i);
            //lưu đầu sách tìm được vào chi tiết đơn hàng(chi tiết mượn sách)
            qlChiTiet.setMonHoc(monHoc);

            System.out.println("Nhập số lượng lớp dạy môn học này:");
            int quantity;
            do {
                quantity=new Scanner(System.in).nextInt();
                if(quantity>0&&quantity<=3){
                    break;
                }
                System.out.println("Không đuọc dạy quá 3 lớp học");
            }while (true);

            qlChiTiet.setSoLop(quantity);


            //lưu chi tiết kê khai vừa nhập
            for (int j = 0; j < chiTiets.length; j++) {
                if (chiTiets[i]==null){
                    chiTiets[i]=qlChiTiet;
                    break;
                }
            }

        }
        return chiTiets;
    }

    private static MonHoc nhapMonHoc(int index){
        System.out.println("Xin mời nhập mã môn học của môn học  thứ "+(index+1)+"mà giảng viên muốn mượn:");
        int mamon;
        MonHoc monHoc;
        do {
            mamon=new Scanner(System.in).nextInt();
            monHoc=searchMonHocbyid(mamon);
            if(monHoc!=null){
                break;

            }
            System.out.println("Không tồn tại mã môn học có id là "+mamon+",vui lòng nhập lại");
        }while (true);
        return monHoc;
    }

    private static MonHoc searchMonHocbyid(int mamon){
        for (int i = 0; i < SUBJECTS.length; i++) {
            MonHoc monHoc=SUBJECTS[i];
            if(monHoc!=null&&monHoc.getMaMonHoc()==mamon){
                return monHoc;
            }
        }
        return null;
    }

    private static GiangVien nhapGiangVien(int index){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập mã giảng viên thứ "+(index+1)+"muốn kê khai:");
        int magiangvien;
        GiangVien giangVien;
        do {
            magiangvien=sc.nextInt();
            giangVien=searchGiangVienbyid(magiangvien);
            if(searchGiangVienbyid(magiangvien)!=null){
                break;
            }
            System.out.println("Không tồn tại mã giảng viên");
        }while (true);

        return giangVien;
    }

    private static GiangVien searchGiangVienbyid(int magiangvien){
        for (int i = 0; i <LECTURERS.length ; i++) {
            GiangVien gv=LECTURERS[i];
            if(gv!=null&&gv.getMaGV()==magiangvien){
                return gv;
            }
        }
        return null;
    }

    private static void SortbyName(){
        int n = TEACHING.length;

        QLgiangday temp;
        for (int i = 0; i < n; i++) {

            for (int j = i+1; j < n; j++) {
                QLgiangday ql1=TEACHING[i];

                QLgiangday ql2=TEACHING[j];
                if(ql1 == null || ql2 == null){
                    break;
                }
                if (ql1.getGiangVien().getHoTen().compareTo(ql2.getGiangVien().getHoTen())>0){
                    temp = TEACHING[i];
                    TEACHING[i]= TEACHING[j];
                    TEACHING[j]= temp;
                }

            }

        }
    }

    private static void SortbyQuantiyy(){
        int n = TEACHING.length;

        QLgiangday temp;
        for (int i = 0; i < n; i++) {

            for (int j = i+1; j < n; j++) {
                QLgiangday ql1=TEACHING[i];

                QLChiTiet[] quanlyct=ql1.getQLCT();
                QLChiTiet detail1 = quanlyct[i];

                QLgiangday ql2=TEACHING[j];

                QLChiTiet[] quanlyct2=ql2.getQLCT();
                QLChiTiet detail2 = quanlyct2[j];
                if(ql1 == null || ql2 == null){
                    break;
                }
                if (detail1.getMonHoc().getTongSoTiet()<detail2.getMonHoc().getTongSoTiet()){
                    temp = TEACHING[i];
                    TEACHING[i]= TEACHING[j];
                    TEACHING[j]= temp;
                }

            }

        }
    }

    private static void CreateTinhLuong() {
        boolean CSDLTL = false;
        for (int i = 0; i < TEACHING.length; i++) {
            if (TEACHING[i] != null) {
                CSDLTL = true;
            }
        }
        if (!CSDLTL) {
            System.out.println("Dữ liệu trống, vui lòng tạo thêm.");
            return;
        }

        for (int i = 0; i < TEACHING.length; i++) {
            QLgiangday kekhai = TEACHING[i];
            if (kekhai == null) {
                continue;
            }
            double TienLuong = 0;
            QLChiTiet[] qldetail = kekhai.getQLCT();
            for (int j = 0; j < qldetail.length; j++) {
                QLChiTiet detail = qldetail[j];
                TienLuong += ((detail.getMonHoc().getMucKinhPhi()*detail.getMonHoc().getSoTietLyThuyet())
                        +((detail.getMonHoc().getMucKinhPhi()*0.7)*(detail.getMonHoc().getTongSoTiet()-detail.getMonHoc().getSoTietLyThuyet())))*(detail.getSoLop());
            }
            System.out.println("Giảng viên " + kekhai.getGiangVien().getHoTen() + " có lương: " + TienLuong + "VND");

        }
    }


}