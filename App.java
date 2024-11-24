import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.prefs.Preferences;

// Interface
interface GiayInterface {
    void nhap(FileWriter fw);
    void xuat(BufferedReader br);
}

// lớp cha
abstract class Giay implements GiayInterface {
    private String maGiay;
    private String tenGiay;
    private int size;
    // Thuộc tính static
    private static int soLuongGiay = 0;

    // Hàm thiết lập (Constructor)
    public Giay() {
        maGiay = "";
        tenGiay = "";
        size = 0;
        soLuongGiay++;
    }

    public Giay(String maGiay, String tenGiay, int size) {
        this.maGiay = maGiay;
        this.tenGiay = tenGiay;
        this.size = size;
        soLuongGiay++;
    }

    // Phương thức getter và setter
    public String getMaGiay() {
        return maGiay;
    }

    public void setMaGiay(String maGiay) {
        this.maGiay = maGiay;
    }

    public String getTenGiay() {
        return tenGiay;
    }

    public void setTenGiay(String tenGiay) {
        this.tenGiay = tenGiay;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // Phương thức static
    public static int getSoLuongGiay() {
        return soLuongGiay;
    }

    // Hàm nhập vào file
    public void nhap(FileWriter fw) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhap ma giay: ");
            maGiay = scanner.nextLine();
            fw.write(maGiay + ",");
            System.out.print("Nhap ten giay: ");
            tenGiay = scanner.nextLine();
            fw.write(tenGiay + ", ");
            System.out.print("Nhap size: ");
            size = scanner.nextInt();
            fw.write(size + ", ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hàm xuất từ file
    public void xuat(BufferedReader br) {
        try {
            String line = br.readLine();
            String[] arr = line.split(",");
            maGiay = arr[0];
            tenGiay = arr[1];
            size = Integer.parseInt(arr[2]);
            System.out.println("Ma giay: " + maGiay);
            System.out.println("Ten giay: " + tenGiay);
            System.out.println("Size: " + size);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Lớp con
class Giay_da_bong extends Giay {
    private String loaiDe;
    private int soLuong;
    private double giaBan;

    // Hàm thiết lập mặc định (Constructor)
    public Giay_da_bong() {
        super();
        loaiDe = "";
        soLuong = 0;
        giaBan = 0;
    }

    public Giay_da_bong(String maGiay, String tenGiay, int size, String loaiDe, int soLuong, double giaBan) {
        super(maGiay, tenGiay, size);
        this.loaiDe = loaiDe;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    // Phương thức getter và setter
    public String getLoaiDe() {
        return loaiDe;
    }

    public void setLoaiDe(String loaiDe) {
        this.loaiDe = loaiDe;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    // Hàm nhập vào file
    @Override
    public void nhap(FileWriter fw) {
        super.nhap(fw);
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhap loai de: ");
            loaiDe = scanner.nextLine();
            fw.write(loaiDe + ", ");
            System.out.print("Nhap so luong: ");
            soLuong = scanner.nextInt();
            fw.write(soLuong + ", ");
            System.out.print("Nhap gia ban: ");
            giaBan = scanner.nextDouble();
            fw.write(giaBan + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hàm xuất từ file
    @Override
    public void xuat(BufferedReader br) {
        super.xuat(br);
        try {
            String line = br.readLine();
            String[] arr = line.split(",");
            loaiDe = arr[3];
            soLuong = Integer.parseInt(arr[4]);
            giaBan = Double.parseDouble(arr[5]);
            System.out.println("Loai de: " + loaiDe);
            System.out.println("So luong: " + soLuong);
            System.out.println("Gia ban: " + giaBan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Giay_cau_long extends Giay {
    private int doBam;
    private int soLuong;
    private double giaBan;

    // Hàm thiết lập (Constructor)
    public Giay_cau_long() {
        super();
        doBam = 0;
        soLuong = 0;
        giaBan = 0;
    }

    public Giay_cau_long(String maGiay, String tenGiay, int size, int doBam, int soLuong, double giaBan) {
        super(maGiay, tenGiay, size);
        this.doBam = doBam;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    // Phương thức getter và setter
    public int getDoBam() {
        return doBam;
    }

    public void setDoBam(int doBam) {
        this.doBam = doBam;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public void nhap(FileWriter fw) {
        super.nhap(fw);
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhap do bam: ");
            doBam = scanner.nextInt();
            fw.write(doBam + ", ");
            System.out.print("Nhap so luong: ");
            soLuong = scanner.nextInt();
            fw.write(soLuong + ", ");
            System.out.print("Nhap gia ban: ");
            giaBan = scanner.nextDouble();
            fw.write(giaBan + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xuat(BufferedReader br) {
        super.xuat(br);
        try {
            String line = br.readLine();
            String[] arr = line.split(",");
            doBam = Integer.parseInt(arr[3]);
            soLuong = Integer.parseInt(arr[4]);
            giaBan = Double.parseDouble(arr[5]);
            System.out.println("Do bam: " + doBam);
            System.out.println("So luong: " + soLuong);
            System.out.println("Gia ban: " + giaBan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Giay_chay_bo extends Giay {
    private int doEm;
    private int soLuong;
    private double giaBan;

    // Hàm thiết lập (Constructor)
    public Giay_chay_bo() {
        super();
        doEm = 0;
        soLuong = 0;
        giaBan = 0;
    }

    public Giay_chay_bo(String maGiay, String tenGiay, int size, int doEm, int soLuong, double giaBan) {
        super(maGiay, tenGiay, size);
        this.doEm = doEm;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    // Phương thức getter và setter
    public int getDoEm() {
        return doEm;
    }

    public void setDoEm(int doEm) {
        this.doEm = doEm;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    // Hàm nhập vào file
    @Override
    public void nhap(FileWriter fw) {
        super.nhap(fw);
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhap do em: ");
            doEm = scanner.nextInt();
            fw.write(doEm + ", ");
            System.out.print("Nhap so luong: ");
            soLuong = scanner.nextInt();
            fw.write(soLuong + ", ");
            System.out.print("Nhap gia ban: ");
            giaBan = scanner.nextDouble();
            fw.write(giaBan + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hàm xuất từ file
    @Override
    public void xuat(BufferedReader br) {
        super.xuat(br);
        try {
            String line = br.readLine();
            String[] arr = line.split(",");
            doEm = Integer.parseInt(arr[3]);
            soLuong = Integer.parseInt(arr[4]);
            giaBan = Double.parseDouble(arr[5]);
            System.out.println("Do em: " + doEm);
            System.out.println("So luong: " + soLuong);
            System.out.println("Gia ban: " + giaBan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DSG {
    private List<Giay> list; // danh sách giày

    // Hàm thiết lập (Constructor)
    public DSG() {
        list = new ArrayList<>();
    }

    public DSG(List<Giay> list) {
        this.list = list;
    }

    // Thêm giày vào danh sách
    public void themGiay(Giay giay, String fileName) {
        list.add(giay);
        try {
            FileWriter fw = new FileWriter(fileName, true);
            giay.nhap(fw);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hiển thị danh sách giày
    public void hienThi (){
        String fileName = "";
        for (Giay giay : list){
            if (giay instanceof Giay_da_bong){
                fileName = "Football.txt";
            } else if (giay instanceof Giay_cau_long){
                fileName = "Badminton.txt";
            } else if (giay instanceof Giay_chay_bo){
                fileName = "Running.txt";
            }
        }

        if (!fileName.isEmpty()){
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String currentLine;
                while ((currentLine = reader.readLine()) != null){
                    System.out.println(currentLine);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Sửa thông tin giày
    public void suaGiay(String maGiay, Scanner scanner,  FileWriter fw){
        for (Giay giay : list) {
            if (giay.getMaGiay().equals(maGiay)) {
                if (giay instanceof Giay_da_bong) {
                    giay.nhap(fw);
                    System.err.println("Nhap loai de: ");
                    ((Giay_da_bong) giay).setLoaiDe(scanner.nextLine());
                    System.err.println("Nhap so luong: ");
                    ((Giay_da_bong) giay).setSoLuong(scanner.nextInt());
                    System.err.println("Nhap gia ban: ");
                    ((Giay_da_bong) giay).setGiaBan(scanner.nextDouble());
                } else if (giay instanceof Giay_cau_long) {
                    giay.nhap(fw);
                    System.err.println("Nhap do bam: ");
                    ((Giay_cau_long) giay).setDoBam(scanner.nextInt());
                    System.err.println("Nhap so luong: ");
                    ((Giay_cau_long) giay).setSoLuong(scanner.nextInt());
                    System.err.println("Nhap gia ban: ");
                    ((Giay_cau_long) giay).setGiaBan(scanner.nextDouble());
                } else if (giay instanceof Giay_chay_bo) {
                    giay.nhap(fw);
                    System.err.println("Nhap do em: ");
                    ((Giay_chay_bo) giay).setDoEm(scanner.nextInt());
                    System.err.println("Nhap so luong: ");
                    ((Giay_chay_bo) giay).setSoLuong(scanner.nextInt());
                    System.err.println("Nhap gia ban: ");
                    ((Giay_chay_bo) giay).setGiaBan(scanner.nextDouble());
                }
                return;
            }
        }
        System.out.println("Khong tim thay giay voi ma: " + maGiay);
    }

    // Xóa giày theo mã
    public void xoaGiay (String maGiay){

        // Xoá trong file
        String fileName ="";
        for (Giay giay : list){
            if(giay.getMaGiay().equals(maGiay)){
                if (giay instanceof Giay_da_bong){
                    fileName = "Football.txt";
                } else if (giay instanceof Giay_cau_long){
                    fileName = "Badminton.txt";
                } else if (giay instanceof Giay_chay_bo){
                    fileName = "Running.txt";
                }
            }
        }
        if (!fileName.isEmpty()){
            // Đọc và ghi các dòng không chứa mã giày cần xoá
            List<String> lines = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String currentline;
                while ((currentline = reader.readLine()) != null){
                    String [] part = currentline.split(",");
                    if (!part[0].equals(maGiay)){
                        lines.add(currentline);
                    }
                 }
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Ghi lại vào file 
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                for (String line:lines){
                    writer.write(line);
                    writer.newLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        list.removeIf(giay -> giay.getMaGiay().equals(maGiay));

}

    // Tìm kiếm giày theo mã
    public void timKiem(String maGiay){
        String fileName = "";
        for (Giay giay : list){
            if (giay.getMaGiay().equals(maGiay)){
                if (giay instanceof Giay_da_bong){
                    fileName = "Football.txt";
                } else if (giay instanceof Giay_cau_long){
                    fileName = "Badminton.txt";
                } else if (giay instanceof Giay_chay_bo){
                    fileName = "Running.txt";
                }
            }
        }
        if (!fileName.isEmpty()){
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String currentLine;
                while ((currentLine = reader.readLine()) != null){
                String [] part = currentLine.split(",");
                if (part[0].equals(maGiay)){
                    System.out.println("Giay can tim la: " + currentLine);
                    return;
                }
                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Hiển thị tổng số lượng giày
    public void tongSoLuong(){
        System.out.println("Tong so luong giay: " + Giay.getSoLuongGiay());
    }
}

// Interface user
interface UserInterface {
    void nhapThongTin(FileWriter fw);
    void xuatThongTin(BufferedReader br);
}

// Lớp cha
class User implements UserInterface{
    private String maUser;
    private String tenUser;
    private String diaChi;
    private String sdt;
    public static int soLuongUser = 0;

    // Hàm thiết lập
    public User (){
        maUser = "";
        tenUser = "";
        diaChi = "";
        sdt = "";
        soLuongUser++;
    }

    public User(String maUser, String tenUser, String diaChi, String sdt) {
        this.maUser = maUser;
        this.tenUser = tenUser;
        this.diaChi = diaChi;
        this.sdt = sdt;
        soLuongUser++;
    }

    // Phương thức getter và setter
    public String getMaUser() {
        return maUser;
    }

    public void setMaUser(String maUser) {
        this.maUser = maUser;
    }

    public String getTenUser() {
        return tenUser;
    }

    public void setTenUser(String tenUser) {
        this.tenUser = tenUser;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    // static
    public static int getSoLuongUser() {
        return soLuongUser;
    }

    //Hàm nhập thông tin vào file
    public void nhapThongTin(FileWriter fw){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhap ma user: ");
            maUser = scanner.nextLine();
            fw.write(maUser + ",");
            System.out.print("Nhap ten user: ");
            tenUser = scanner.nextLine();
            fw.write(tenUser + ",");
            System.out.print("Nhap dia chi: ");
            diaChi = scanner.nextLine();
            fw.write(diaChi + ",");
            System.out.print("Nhap so dien thoai: ");
            sdt = scanner.nextLine();
            fw.write(sdt + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hàm xuất thông tin có sẵn từ file
    public void xuatThongTin(BufferedReader br){
        try {
            String line = br.readLine();
            String[] arr = line.split(",");
            maUser = arr[0];
            tenUser = arr[1];
            diaChi = arr[2];
            sdt = arr[3];
            System.out.println("Ma user: " + maUser);
            System.out.println("Ten user: " + tenUser);
            System.out.println("Dia chi: " + diaChi);
            System.out.println("So dien thoai: " + sdt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DSU{
    // Danh sách user
    private List<User> list;
    private List<HoaDon> listHoaDon;

    // Hàm thiết lập 
    public DSU(){
        list = new ArrayList<>();
    }

    public DSU(List<User> list) {
        this.list = list;
    }

    // Thêm user vào danh sách
    public void themUser(User user, String fileName){
        list.add(user);
        try {
            FileWriter fw = new FileWriter(fileName, true);
            user.nhapThongTin(fw);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
    }
    }
    // Hiển thị danh sách user
    public void hienThi(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("User.txt"));
            String currentLine;
            while ((currentLine = reader.readLine()) != null){
                System.out.println(currentLine);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Sửa thông tin user
    public void suaUser(String maUser, Scanner scanner, FileWriter fw){
        for (User user : list){
            if (user.getMaUser().equals(maUser)){
                user.nhapThongTin(fw);
                return;
            }
        }
        System.out.println("Khong tim thay user voi ma: " + maUser);
    }

    // Xóa user theo mã
    public void xoaUser(String maUser){

        // Xoá trong file
        List<String> lines = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("User.txt"));
            String currentLine;
            while((currentLine = reader.readLine()) != null){
                String [] part = currentLine.split(",");
                if(!part[0].equals(maUser)){
                    lines.add(currentLine);
                }
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("User.txt"));
            for (String line : lines){
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        list.removeIf(user -> user.getMaUser().equals(maUser));
    }

    // Tìm kiếm user theo mã
    public void timKiem(String maUser){
        try {
             BufferedReader reader = new BufferedReader(new FileReader("User.txt"));
             String currentLine;
             while ((currentLine = reader.readLine())!= null){
             String [] part = currentLine.split(",");
                if (part[0].equals(maUser)){
                    System.out.println("User can tim la: " + currentLine);
                    return;
                }
                System.out.println("Không tìm thấy user có mã: " + maUser);
             }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    // Hiển thị tổng số lượng user
    public void tongSoLuong(){
        System.out.println("Tong so luong user: " + User.getSoLuongUser());
    }
}

// interface HoaDonInterface
interface HoaDonInterface{
    void nhapThongTin(FileWriter fw);
    void xuatThongTin(BufferedReader br);
}
// Hoá đơn
class HoaDon implements HoaDonInterface{
    private String maHoaDon;
    User user;
    List<Giay> dsGiay;
    private double tongTien;
    private String ngayMua;
    private static int soLuongHoaDon = 0;

    // Hàm thiết lập
    public HoaDon(){
        maHoaDon = "";
        user = null;
        dsGiay = new ArrayList<>();
        tongTien = 0;
        ngayMua = "";
        soLuongHoaDon++;
    }

    public HoaDon(String maHoaDon, User user, List<Giay> dsGiay, double tongTien, String ngayMua) {
        this.maHoaDon = maHoaDon;
        this.user = user;
        this.dsGiay = dsGiay;
        this.tongTien = tongTien;
        this.ngayMua = ngayMua;
        soLuongHoaDon++;
    }

    // Phương thức getter và setter
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Giay> getDsGiay() {
        return dsGiay;
    }

    public void setDsGiay(List<Giay> dsGiay) {
        this.dsGiay = dsGiay;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    // Phương thức static
    public static int getSoLuongHoaDon() {
        return soLuongHoaDon;
    }

    // Hàm nhập thông tin vào file
    public void nhapThongTin(FileWriter fw){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhap ma hoa don: ");
            maHoaDon = scanner.nextLine();
            fw.write(maHoaDon + ",");
            user.nhapThongTin(fw);
            System.out.print("Nhap tong tien: ");
            tongTien = scanner.nextDouble();
            fw.write(tongTien + ",");
            scanner.nextLine();
            System.out.print("Nhap ngay mua: ");
            ngayMua = scanner.nextLine();
            fw.write(ngayMua + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hàm xuất thông tin có sẵn từ file
    public void xuatThongTin(BufferedReader br){
        try {
            String line = br.readLine();
            String[] arr = line.split(",");
            maHoaDon = arr[0];
            user.setMaUser(arr[1]);
            user.setTenUser(arr[2]);
            user.setDiaChi(arr[3]);
            user.setSdt(arr[4]);
            tongTien = Double.parseDouble(arr[5]);
            ngayMua = arr[6];
            System.out.println("Ma hoa don: " + maHoaDon);
            System.out.println("Ten user: " + user.getTenUser());
            System.out.println("Dia chi: " + user.getDiaChi());
            System.out.println("So dien thoai: " + user.getSdt());
            System.out.println("Tong tien: " + tongTien);
            System.out.println("Ngay mua: " + ngayMua);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DSHD{
    private List<HoaDon> list;

    // Hàm thiết lập
    public DSHD(){
        list = new ArrayList<>();
    }

    public DSHD(List<HoaDon> list) {
        this.list = list;
    }

    // Thêm hoá đơn vào danh sách
    public void themHoaDon(HoaDon hoaDon, String fileName){
        list.add(hoaDon);
        try {
            FileWriter fw = new FileWriter(fileName, true);
            hoaDon.nhapThongTin(fw);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
    }
    }
    // Hiển thị danh sách hoá đơn
    public void hienThi(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Bill.txt"));
            String currentLine;
            while ((currentLine = reader.readLine()) != null){
                System.out.println(currentLine);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Sửa thông tin hoá đơn
    public void suaHoaDon(String maHoaDon, Scanner scanner, FileWriter fw){
        for (HoaDon hoaDon : list){
            if (hoaDon.getMaHoaDon().equals(maHoaDon)){
                hoaDon.nhapThongTin(fw);
                return;
            }
        }
        System.out.println("Khong tim thay hoa don voi ma: " + maHoaDon);
    }

    // Xóa hoá đơn theo mã
    public void xoaHoaDon(String maHoaDon){

        // Xoá trong file
        List<String> lines = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Bill.txt"));
            String currentLine;
            while((currentLine = reader.readLine()) != null){
                String [] part = currentLine.split(",");
                if(!part[0].equals(maHoaDon)){
                    lines.add(currentLine);
                }
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Bill.txt"));
            for (String line : lines){
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        list.removeIf(hoaDon -> hoaDon.getMaHoaDon().equals(maHoaDon));
    }

    // Tìm kiếm hoá đơn theo mã
    public void timKiem(String maHoaDon){
        try {
             BufferedReader reader = new BufferedReader(new FileReader("Bill.txt"));
             String currentLine;
             while ((currentLine = reader.readLine())!= null){
             String [] part = currentLine.split(",");
                if (part[0].equals(maHoaDon)){
                    System.out.println("Hoa don can tim la: " + currentLine);
                    return;
                }
                System.out.println("Không tìm thấy hoa don có mã: " + maHoaDon);
             }  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hiển thị tổng số lượng hoá đơn
    public void tongSoLuong(){
        System.out.println("Tong so luong hoa don: " + HoaDon.getSoLuongHoaDon());
    }
}

// Lớp chính
public class App{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DSG dsg = new DSG();
        DSU dsu = new DSU();
        DSHD dshd = new DSHD();

        while (true){
            System.err.println("---------------------------------------------------");
            System.err.println("Lua chon chuc nang o muc: ");
            System.err.println("1. Giay");
            System.err.println("2. User");
            System.err.println("3. Hoa don");
            System.err.println("4. Thoat");
            System.err.println("---------------------------------------------------");
            System.err.print("Nhap lua chon cua ban: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.err.println("---------------------------------------------------");

            switch (choice){ 
                case 1:
                        System.err.println("---------------------------------------------------");
                        System.err.println("1. Them giay");
                        System.err.println("2. Sua giay theo ma");
                        System.err.println("3. Xoa giay theo ma");
                        System.err.println("4. Tim kiem theo ma");
                        System.err.println("5. Hien thi danh sach giay");
                        System.err.println("6. Xem tong so luong giay");
                        System.err.println("7. Quay lai");
                        System.err.println("---------------------------------------------------");
                        System.err.print("Nhap lua chon cua ban: ");
                        int choice1 = Integer.parseInt(scanner.nextLine());
                        System.err.println("---------------------------------------------------");  
                        switch (choice1){
                            case 1:
                                System.err.println("---------------------------------------------------");
                                System.err.println("Chon loai giay can them:");
                                System.err.println("1. Giay da bong");
                                System.err.println("2. Giay cau long");
                                System.err.println("3. Giay chay bo");
                                System.err.println("4. Quay lai");
                                System.err.println("---------------------------------------------------");
                                System.err.print("Nhap lua chon cua ban: ");
                                int loai = Integer.parseInt(scanner.nextLine());
                                System.err.println("---------------------------------------------------");
                                Giay giay = null;
                                switch (loai){
                                    case 1:
                                    giay = new Giay_da_bong( "", "", 0, "", 0, 0);
                                    if (giay != null){
                                       dsg.themGiay(giay, "Football.txt");
                                    }    
                                break;
                                    case 2:
                                     giay = new Giay_cau_long("", "", 0, 0, 0, 0);
                                     if (giay != null){
                                        dsg.themGiay(giay,"Badminton.txt");
                                        }
                                    break;
                                    case 3:
                                    giay = new Giay_chay_bo("", "", 0, 0, 0, 0);
                                    if (giay != null){
                                        dsg.themGiay(giay, "Running.txt");
                                    }
                                    break;
                                    case 4:
                                    break;
                                }
                            case 2:
                                System.err.println("-----------------------------------------------");
                                System.err.println("Nhap loai giay can sua: ");
                                System.err.println("1. Giay da bong");
                                System.err.println("2. Giay cau long");
                                System.err.println("3. Giay chay bo");
                                System.err.println("4. Quay lai");
                                System.err.println("-----------------------------------------------");
                                System.err.print("Nhap lua chon cua ban: ");
                                int choice2 = Integer.parseInt(scanner.nextLine());
                                System.err.println("-----------------------------------------------");
                                switch (choice2){
                                    case 1:
                                        System.err.println("Nhap ma giay can sua: ");
                                        String maSua = scanner.nextLine();
                                        try {
                                            dsg.suaGiay(maSua, scanner, new FileWriter("Football.txt"));
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        break;
                                    case 2:
                                        System.err.println("Nhap ma giay can sua: ");
                                        String maSua1 = scanner.nextLine();
                                        try {
                                            dsg.suaGiay(maSua1, scanner, new FileWriter("Badminton.txt"));
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        break;
                                    case 3:
                                        System.err.println("Nhap ma giay can sua: ");
                                        String maSua2 = scanner.nextLine();
                                        try {
                                            dsg.suaGiay(maSua2, scanner, new FileWriter("Running.txt"));
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        break;
                                    case 4:
                                        break;
                                }
                                break;
                            case 3:
                                System.err.println("Nhap ma giay can xoa: ");
                                String maXoa = scanner.nextLine();
                                dsg.xoaGiay(maXoa);
                                break;
                            case 4:
                                System.err.println("Nhap ma giay can tim: ");
                                String maTim = scanner.nextLine();
                                dsg.timKiem(maTim);
                                break;
                            case 5:
                                dsg.hienThi();
                                break;
                            case 6:
                                dsg.tongSoLuong();
                                break;
                            case 7:
                                break;
                        }
                        
                 break;        
                 case 2:
                        System.err.println("---------------------------------------------------");
                        System.err.println("1. Them user");
                        System.err.println("2. Sua user theo ma");
                        System.err.println("3. Xoa user theo ma");
                        System.err.println("4. Tim kiem theo ma");
                        System.err.println("5. Hien thi danh sach user");
                        System.err.println("6. Xem tong so luong user");
                        System.err.println("7. Quay lai");
                        System.err.println("---------------------------------------------------");
                        System.err.print("Nhap lua chon cua ban: ");
                        int choice2 = Integer.parseInt(scanner.nextLine());
                        System.err.println("---------------------------------------------------");
                        switch (choice2){
                            case 1:
                                User user = new User( "", "", "", "");
                                dsu.themUser(user, "User.txt");
                                break;
                            case 2:
                                System.err.println("Nhap ma user can sua: ");
                                String maSua = scanner.nextLine();
                                try {
                                    dsu.suaUser(maSua, scanner, new FileWriter("User.txt"));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 3:
                                System.err.println("Nhap ma user can xoa: ");
                                String maXoa = scanner.nextLine();
                                dsu.xoaUser(maXoa);
                                break;
                            case 4:
                                System.err.println("Nhap ma user can tim: ");
                                String maTim = scanner.nextLine();
                                dsu.timKiem(maTim);
                                break;
                            case 5:
                                dsu.hienThi();
                                break;
                            case 6:
                                dsu.tongSoLuong();
                                break;
                            case 7:
                                break;
                        }
                        break;
                case 3:
                        System.err.println("---------------------------------------------------");
                        System.err.println("1. Them hoa don");
                        System.err.println("2. Sua hoa don theo ma");
                        System.err.println("3. Xoa hoa don theo ma");
                        System.err.println("4. Tim kiem theo ma");
                        System.err.println("5. Hien thi danh sach hoa don");
                        System.err.println("6. Xem tong so luong hoa don");
                        System.err.println("7. Quay lai");
                        System.err.println("---------------------------------------------------");
                        System.err.print("Nhap lua chon cua ban: ");
                        int choice3 = Integer.parseInt(scanner.nextLine());
                        System.err.println("---------------------------------------------------");
                        switch (choice3){
                            case 1:
                                HoaDon hoaDon = new HoaDon("", new User("", "", "", ""), new ArrayList<>(), 0, "");
                                dshd.themHoaDon(hoaDon, "Bill.txt");
                                break;
                            case 2:
                                System.err.println("Nhap ma hoa don can sua: ");
                                String maSua = scanner.nextLine();
                                try {
                                    dshd.suaHoaDon(maSua, scanner, new FileWriter("Bill.txt"));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 3:
                                System.err.println("Nhap ma hoa don can xoa: ");
                                String maXoa = scanner.nextLine();
                                dshd.xoaHoaDon(maXoa);
                                break;
                            case 4:
                                System.err.println("Nhap ma hoa don can tim: ");
                                String maTim = scanner.nextLine();
                                dshd.timKiem(maTim);
                                break;
                            case 5:
                                dshd.hienThi();
                                break;
                            case 6:
                                dshd.tongSoLuong();
                                break;
                            case 7:
                                break;
                        }
            }
        }
    }
}