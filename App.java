import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            fw.write(maGiay + ", ");
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

    public static void giamSoLuongGiay() {
        soLuongGiay--;
    }
}

// Lớp con
class Giay_da_bong extends Giay {
    private String loaiDe;
    private int soLuong;
    private int giaBan;

    // Hàm thiết lập mặc định (Constructor)
    public Giay_da_bong() {
        super();
        loaiDe = "";
        soLuong = 0;
        giaBan = 0;
    }

    public Giay_da_bong(String maGiay, String tenGiay, int size, String loaiDe, int soLuong, int giaBan) {
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

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
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
            giaBan = scanner.nextInt();
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
            giaBan = Integer.parseInt(arr[5]);
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
    private int giaBan;

    // Hàm thiết lập (Constructor)
    public Giay_cau_long() {
        super();
        doBam = 0;
        soLuong = 0;
        giaBan = 0;
    }

    public Giay_cau_long(String maGiay, String tenGiay, int size, int doBam, int soLuong, int giaBan) {
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

    public void setGiaBan(int giaBan) {
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
            giaBan = scanner.nextInt();
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
            giaBan = Integer.parseInt(arr[5]);
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
    private int giaBan;

    // Hàm thiết lập (Constructor)
    public Giay_chay_bo() {
        super();
        doEm = 0;
        soLuong = 0;
        giaBan = 0;
    }

    public Giay_chay_bo(String maGiay, String tenGiay, int size, int doEm, int soLuong, int giaBan) {
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

    public void setGiaBan(int giaBan) {
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
            giaBan = scanner.nextInt();
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
            giaBan = Integer.parseInt(arr[5]);
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
            try {
                System.out.println("Danh sach giay da bong: ");
                BufferedReader reader = new BufferedReader(new FileReader("Football.txt"));
                String currentLine;
                while ((currentLine = reader.readLine()) != null){
                    System.out.println(currentLine);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                System.out.println("Danh sach giay cau long: ");
                BufferedReader reader = new BufferedReader(new FileReader("Badminton.txt"));
                String currentLine;
                while ((currentLine = reader.readLine()) != null){
                    System.out.println(currentLine);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                System.out.println("Danh sach giay chay bo: ");
                BufferedReader reader = new BufferedReader(new FileReader("Running.txt"));
                String currentLine;
                while ((currentLine = reader.readLine()) != null){
                    System.out.println(currentLine);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    

    // Sửa thông tin giày
    public void suaGiay(String maGiay, Scanner scanner, String fileName) {
        boolean found = false;
        for (Giay giay : list) {
            if (giay.getMaGiay().equals(maGiay)) {
                found = true;
                System.out.println("Nhap thong tin moi cho giay (ma giay se khong thay doi):");
                System.out.print("Nhap ten giay moi: ");
                giay.setTenGiay(scanner.nextLine());
                System.out.print("Nhap size moi: ");
                giay.setSize(Integer.parseInt(scanner.nextLine()));
                if (giay instanceof Giay_da_bong) {
                    Giay_da_bong giayDaBong = (Giay_da_bong) giay;
                    System.out.print("Nhap loai de moi: ");
                    giayDaBong.setLoaiDe(scanner.nextLine());
                    System.out.print("Nhap so luong moi: ");
                    giayDaBong.setSoLuong(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Nhap gia ban moi: ");
                    giayDaBong.setGiaBan(Integer.parseInt(scanner.nextLine()));
                } else if (giay instanceof Giay_cau_long) {
                    Giay_cau_long giayCauLong = (Giay_cau_long) giay;
                    System.out.print("Nhap do bam moi: ");
                    giayCauLong.setDoBam(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Nhap so luong moi: ");
                    giayCauLong.setSoLuong(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Nhap gia ban moi: ");
                    giayCauLong.setGiaBan(Integer.parseInt(scanner.nextLine()));
                } else if (giay instanceof Giay_chay_bo) {
                    Giay_chay_bo giayChayBo = (Giay_chay_bo) giay;
                    System.out.print("Nhap do em moi: ");
                    giayChayBo.setDoEm(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Nhap so luong moi: ");
                    giayChayBo.setSoLuong(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Nhap gia ban moi: ");
                    giayChayBo.setGiaBan(Integer.parseInt(scanner.nextLine()));
                }
    
                break; 
            }
        }
    
        if (found) {
            try {
                List<String> lines = new ArrayList<>();
                for (Giay g : list) {
                        String line = g.getMaGiay() + ", " + g.getTenGiay() + ", " + g.getSize();
                        if (fileName == "Football.txt") {
                            Giay_da_bong giayDaBong = (Giay_da_bong) g;
                            line += ", " + giayDaBong.getLoaiDe() + ", " + giayDaBong.getSoLuong() + ", " + giayDaBong.getGiaBan();
                        } else if (fileName == "Badminton.txt") {
                            Giay_cau_long giayCauLong = (Giay_cau_long) g;
                            line += ", " + giayCauLong.getDoBam() + ", " + giayCauLong.getSoLuong() + ", " + giayCauLong.getGiaBan();
                        } else if (fileName == "Running.txt") {
                            Giay_chay_bo giayChayBo = (Giay_chay_bo) g;
                            line += ", " + giayChayBo.getDoEm() + ", " + giayChayBo.getSoLuong() + ", " + giayChayBo.getGiaBan();
                        }
                        lines.add(line);
                }
    
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (!found) {
            System.out.println("Khong tim thay giay voi ma: " + maGiay);
        }
    }
    
    
    

    // Xóa giày theo mã
    public void xoaGiay(String maGiay, String fileName) {
    
        List<String> lines = new ArrayList<>();
        Giay.giamSoLuongGiay();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String currentline;
            while ((currentline = reader.readLine()) != null) {
                String[] part = currentline.split(", ");
                if (!part[0].trim().equals(maGiay)) {
                    lines.add(currentline);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        list.removeIf(giay -> giay.getMaGiay().equals(maGiay));
    }
    

    // Tìm kiếm giày theo mã
    public void timKiem(String maGiay, String fileName){

            try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                
                String currentLine;
                while ((currentLine = reader.readLine()) != null){
                String [] part = currentLine.split(", ");
                if (part[0].trim().equals(maGiay)){
                    System.out.println("Giay can tim la: " + currentLine);
                    return;
                }
                
                }
            } catch (Exception e) {
                e.printStackTrace();
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
            fw.write(maUser + ", ");
            System.out.print("Nhap ten user: ");
            tenUser = scanner.nextLine();
            fw.write(tenUser + ", ");
            System.out.print("Nhap dia chi: ");
            diaChi = scanner.nextLine();
            fw.write(diaChi + ", ");
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

    public static void giamSoLuongUser(){
        soLuongUser--;
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
    public void suaUser(String maUser, Scanner scanner){
        boolean found = false;
        for (User user : list){
            if (user.getMaUser().equals(maUser)){
                found = true;
                System.out.println("Nhap thong tin moi cho user (ma user se khong thay doi):");
                System.out.print("Nhap ten user moi: ");
                user.setTenUser(scanner.nextLine());
                System.out.print("Nhap dia chi moi: ");
                user.setDiaChi(scanner.nextLine());
                System.out.print("Nhap so dien thoai moi: ");
                user.setSdt(scanner.nextLine());
                try {
                    List<String> lines = new ArrayList<>();
                    for (User u : list){
                        String line = u.getMaUser() + ", " + u.getTenUser() + ", " + u.getDiaChi() + ", " + u.getSdt();
                        lines.add(line);
                    }
                    BufferedWriter writer = new BufferedWriter(new FileWriter("User.txt", false));
                    for (String line : lines){
                        writer.write(line);
                        writer.newLine();
                    }
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        if (!found){
            System.out.println("Khong tim thay user voi ma: " + maUser);
        }
    }

    // Xóa user theo mã
    public void xoaUser(String maUser){

        List<String> lines = new ArrayList<>();
        User.giamSoLuongUser();
        try (BufferedReader reader = new BufferedReader(new FileReader("User.txt"))){
            String currentLine;
            while ((currentLine = reader.readLine()) != null){
                String [] part = currentLine.split(", ");
                if (!part[0].trim().equals(maUser)){
                    lines.add(currentLine);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
    }
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("User.txt"))){
        for (String line : lines){
            writer.write(line);
            writer.newLine();
        }
    } catch (Exception e){
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
    private int tongTien;
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

    public HoaDon(String maHoaDon, User user, List<Giay> dsGiay, int tongTien, String ngayMua) {
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

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
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
            fw.write(maHoaDon + ", ");
            user.nhapThongTin(fw);
            System.out.print("Nhap tong tien: ");
            tongTien = scanner.nextInt();
            fw.write(tongTien + ", ");
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
            String[] arr = line.split(", ");
            maHoaDon = arr[0];
            user.setMaUser(arr[1]);
            user.setTenUser(arr[2]);
            user.setDiaChi(arr[3]);
            user.setSdt(arr[4]);
            tongTien = Integer.parseInt(arr[5]);
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

    public static void giamSoLuongHoaDon(){
        soLuongHoaDon--;
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
    public void suaHoaDon(String maHoaDon, Scanner scanner){
        boolean found = false;
        for (HoaDon hoaDon : list){
            if (hoaDon.getMaHoaDon().equals(maHoaDon)){
                found = true;
                System.out.println("Nhap thong tin moi cho hoa don (ma hoa don se khong thay doi):");
                System.out.print("Nhap ten user moi: ");
                hoaDon.getUser().setTenUser(scanner.nextLine());
                System.out.print("Nhap dia chi moi: ");
                hoaDon.getUser().setDiaChi(scanner.nextLine());
                System.out.print("Nhap so dien thoai moi: ");
                hoaDon.getUser().setSdt(scanner.nextLine());
                System.out.print("Nhap tong tien moi: ");
                hoaDon.setTongTien(Integer.parseInt(scanner.nextLine()));
                System.out.print("Nhap ngay mua moi: ");
                hoaDon.setNgayMua(scanner.nextLine());
                try {
                    List<String> lines = new ArrayList<>();
                    for (HoaDon hd : list){
                        String line = hd.getMaHoaDon() + ", " + hd.getUser().getMaUser() + ", " + hd.getUser().getTenUser() + ", " + hd.getUser().getDiaChi() + ", " + hd.getUser().getSdt() + ", " + hd.getTongTien() + ", " + hd.getNgayMua();
                        lines.add(line);
                    }
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Bill.txt", false));
                    for (String line : lines){
                        writer.write(line);
                        writer.newLine();
                    }
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (!found){
        System.out.println("Khong tim thay hoa don voi ma: " + maHoaDon);
    }
}

    // Xóa hoá đơn theo mã
    public void xoaHoaDon(String maHoaDon){

        List<String> lines = new ArrayList<>();
        HoaDon.giamSoLuongHoaDon();
        try (BufferedReader reader = new BufferedReader(new FileReader("Bill.txt"))){
            String currentLine;
            while ((currentLine = reader.readLine()) != null){
                String [] part = currentLine.split(", ");
                if (!part[0].trim().equals(maHoaDon)){
                    lines.add(currentLine);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Bill.txt"))){
            for (String line : lines){
                writer.write(line);
                writer.newLine();
            }
        } catch (Exception e){
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
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DSG dsg = new DSG();
        DSU dsu = new DSU();
        DSHD dshd = new DSHD();

        while (true) {
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
            switch (choice) {
                case 1:
                boolean flag = false;
                while (!flag){
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
                    switch (choice1) {
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
                            switch (loai) {
                                case 1:
                                    giay = new Giay_da_bong("", "", 0, "", 0, 0);
                                    if (giay != null) {
                                        dsg.themGiay(giay, "Football.txt");
                                    }
                                    break;
                                case 2:
                                    giay = new Giay_cau_long("", "", 0, 0, 0, 0);
                                    if (giay != null) {
                                        dsg.themGiay(giay, "Badminton.txt");
                                    }
                                    break;
                                case 3:
                                    giay = new Giay_chay_bo("", "", 0, 0, 0, 0);
                                    if (giay != null) {
                                        dsg.themGiay(giay, "Running.txt");
                                    }
                                    break;
                                case 4:
                                    break;
                            }
                            break;
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
                            switch (choice2) {
                                case 1:
                                    System.err.print("Nhap ma giay can sua: ");
                                    String maSua = scanner.nextLine();
                                    try {
                                        dsg.suaGiay(maSua, scanner,"Football.txt");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case 2:
                                    System.err.print("Nhap ma giay can sua: ");
                                    String maSua1 = scanner.nextLine();
                                    try {
                                        dsg.suaGiay(maSua1, scanner, "Badminton.txt");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case 3:
                                    System.err.print("Nhap ma giay can sua: ");
                                    String maSua2 = scanner.nextLine();
                                    try {
                                        dsg.suaGiay(maSua2, scanner, "Running.txt");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case 4:
                                    break;
                            }
                            break;
                        case 3:
                            System.err.println("-----------------------------------------------");
                            System.err.println("Nhap loai giay can xoa: ");
                            System.err.println("1. Giay da bong");
                            System.err.println("2. Giay cau long");
                            System.err.println("3. Giay chay bo");
                            System.err.println("4. Quay lai");
                            System.err.println("-----------------------------------------------");
                            System.err.print("Nhap lua chon cua ban: ");
                            int loai1 = Integer.parseInt(scanner.nextLine());
                            System.err.println("-----------------------------------------------");
                            switch (loai1) {
                                case 1:
                                    System.err.print("Nhap ma giay can xoa: ");
                                    String maXoa = scanner.nextLine();
                                    dsg.xoaGiay(maXoa, "Football.txt");
                                    break;
                                case 2:
                                    System.err.print("Nhap ma giay can xoa: ");
                                    String maXoa1 = scanner.nextLine();
                                    dsg.xoaGiay(maXoa1, "Badminton.txt");
                                    break;
                                case 3:
                                    System.err.print("Nhap ma giay can xoa: ");
                                    String maXoa2 = scanner.nextLine();
                                    dsg.xoaGiay(maXoa2, "Running.txt");
                                    break;
                                case 4:
                                    break;
                            }
                            break;
                        case 4:
                            System.err.println("-----------------------------------------------");
                            System.err.println("Nhap loai giay can tim: ");
                            System.err.println("1. Giay da bong");
                            System.err.println("2. Giay cau long");
                            System.err.println("3. Giay chay bo");
                            System.err.println("4. Quay lai");
                            System.err.println("-----------------------------------------------");
                            System.err.print("Nhap lua chon cua ban: ");
                            int loai2 = Integer.parseInt(scanner.nextLine());
                            System.err.println("-----------------------------------------------");
                            switch(loai2){
                                case 1:
                                    System.err.print("Nhap ma giay can tim: ");
                                    String maTim = scanner.nextLine();
                                    dsg.timKiem(maTim, "Football.txt");
                                    break;
                                case 2:
                                    System.err.print("Nhap ma giay can tim: ");
                                    String maTim1 = scanner.nextLine();
                                    dsg.timKiem(maTim1, "Badminton.txt");
                                    break;
                                case 3:
                                    System.err.print("Nhap ma giay can tim: ");
                                    String maTim2 = scanner.nextLine();
                                    dsg.timKiem(maTim2, "Running.txt");
                                    break;
                                case 4:
                                    break;
                            }
                            break;
                        case 5:
                            dsg.hienThi();
                            break;
                        case 6:
                            dsg.tongSoLuong();
                            break;
                        case 7:
                            flag = true;
                            break;
                    }
                }
                    break;
                case 2:
                    boolean flag1 = false;
                    while (!flag1){
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
                    int choice3 = Integer.parseInt(scanner.nextLine());
                    System.err.println("---------------------------------------------------");
                    switch (choice3) {
                        case 1:
                            User user = new User("", "", "", "");
                            dsu.themUser(user, "User.txt");
                            break;
                        case 2:
                            System.err.print("Nhap ma user can sua: ");
                            String maSua = scanner.nextLine();
                            try {
                                dsu.suaUser(maSua, scanner);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 3:
                            System.err.print("Nhap ma user can xoa: ");
                            String maXoa = scanner.nextLine();
                            dsu.xoaUser(maXoa);
                            break;
                        case 4:
                            System.err.print("Nhap ma user can tim: ");
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
                            flag1 = true;
                            break;
                    }
                    }
                    break;
                case 3:
                    boolean flag2 = false;
                    while(!flag2){
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
                    int choice4 = Integer.parseInt(scanner.nextLine());
                    System.err.println("---------------------------------------------------");
                    switch (choice4) {
                        case 1:
                            HoaDon hoaDon = new HoaDon("", new User("", "", "", ""), new ArrayList<>(), 0, "");
                            dshd.themHoaDon(hoaDon, "Bill.txt");
                            break;
                        case 2:
                            System.err.print("Nhap ma hoa don can sua: ");
                            String maSua = scanner.nextLine();
                            try {
                                dshd.suaHoaDon(maSua, scanner);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 3:
                            System.err.print("Nhap ma hoa don can xoa: ");
                            String maXoa = scanner.nextLine();
                            dshd.xoaHoaDon(maXoa);
                            break;
                        case 4:
                            System.err.print("Nhap ma hoa don can tim: ");
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
                            flag2 = true;
                            break;
                    }
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Lua chon khong hop le. Vui long nhap lai.");
                    break;
            }
        }
    }
}