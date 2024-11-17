import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
  
// lớp cha
abstract class Giay{
    
    private String maGiay;
    private String tenGiay;
    private int size;
    // Hàm thiết lập (Constructor) 
    public Giay() {
        maGiay = "";
        tenGiay = "";
        size = 0;
    }
    public Giay(String maGiay, String tenGiay, int size) {
        this.maGiay = maGiay;
        this.tenGiay = tenGiay;
        this.size = size;
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
    // Hàm nhập vào file 
    public void nhap(FileWriter fw){
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
    public void xuat(BufferedReader br){
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

    // thêm một phương thức để nhập các giá trị từ mảng chuỗi
    public void nhapFromArray(String[] arr) {
        maGiay = arr[0];
        tenGiay = arr[1];
        size = Integer.parseInt(arr[2]);
      }
}
// Lớp con 
class Giay_da_bong extends Giay{
    
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
    public String getLoaiDe(){
        return loaiDe;
    }
    public void setLoaiDe(String loaiDe){
        this.loaiDe = loaiDe;
    }
    public int getSoLuong(){
        return soLuong;
    }
    public void setSoLuong(int soLuong){
        this.soLuong = soLuong;
    }
    public double getGiaBan(){
        return giaBan;
    }
    public void setGiaBan(double giaBan){
        this.giaBan = giaBan;
    }
    // Hàm nhập vào file
    @Override
    public void nhap(FileWriter fw){
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
    public void xuat(BufferedReader br){
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
class Giay_cau_long extends Giay{
    
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
    public int getDoBam(){
        return doBam;
    }
    public void setDoBam(int doBam){
        this.doBam = doBam;
    }
    public int getSoLuong(){
        return soLuong;
    }
    public void setSoLuong(int soLuong){
        this.soLuong = soLuong;
    }
    public double getGiaBan(){
        return giaBan;
    }
    public void setGiaBan(double giaBan){
        this.giaBan = giaBan;
    }
    @Override
    public void nhap(FileWriter fw){
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
    public void xuat(BufferedReader br){
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
class Giay_chay_bo extends Giay{
    
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
    public int getDoEm(){
        return doEm;
    }
    public void setDoEm(int doEm){
        this.doEm = doEm;
    }
    public int getSoLuong(){
        return soLuong;
    }
    public void setSoLuong(int soLuong){
        this.soLuong = soLuong;
    }
    public double getGiaBan(){
        return giaBan;
    }
    public void setGiaBan(double giaBan){
        this.giaBan = giaBan;
    }
    // Hàm nhập vào file
    @Override
    public void nhap(FileWriter fw){
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
    public void xuat(BufferedReader br){
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

interface QuanLyGiay {
    void themGiay(Giay giay);
    void xoaGiay(String maGiay);
    void hienThi();
}

// Lớp danh sách các đối tượng (mảng các đối tượng)
class DSG implements QuanLyGiay {

    private List<Giay> list;
    private static int tongSoGiay = 0; // thuộc tính static để đếm tổng số giày

    // Hàm thiết lập (Constructor)
    public DSG() {
        this.list = new ArrayList<>();
    }

    public static int getTongSoGiay() {
        return tongSoGiay;
    }

    // Thêm giày vào danh sách
    @Override
    public void themGiay(Giay giay) {
        list.add(giay);
        tongSoGiay++;
    }

    // Xóa giày khỏi danh sách
    @Override
    public void xoaGiay(String maGiay) {
        list.removeIf(giay -> giay.getMaGiay().equals(maGiay));
        tongSoGiay--;
    }

    // Hiển thị danh sách giày
    @Override
    public void hienThi() {
        for (Giay giay : list) {
            if (giay instanceof Giay_da_bong) {
                System.out.println("Giay da bong:");
            } else if (giay instanceof Giay_cau_long) {
                System.out.println("Giay cau long:");
            } else if (giay instanceof Giay_chay_bo) {
                System.out.println("Giay chay bo:");
            }
            giay.xuat(null); // Gọi phương thức xuất của từng lớp
        }
    }

    // Ghi danh sách vào file
    public void ghiFile(String tenFile) {
        try (FileWriter fw = new FileWriter(tenFile)) {
            for (Giay giay : list) {
                fw.write(giay.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // đọc file 
    public void docFile(String tenFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                Giay giay;
                if (arr[0].startsWith("D")) { // mã giày bắt đầu bằng "D" là giày đá bóng
                    giay = new Giay_da_bong();
                } else if (arr[0].startsWith("C")) { // mã giày bắt đầu bằng "C" là giày cầu lông
                    giay = new Giay_cau_long();
                } else { // mặc định là giày chạy bộ
                    giay = new Giay_chay_bo();
                }
                giay.nhapFromArray(arr); // Gọi phương thức mới để thiết lập giá trị từ mảng
                list.add(giay);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
     } 
}
class ChucNang {
    private List<Giay> list;

    public ChucNang() {
        list = new ArrayList<>();
    }

    public void ThemGiay(Giay giay) {
        list.add(giay);
    }

    public void XemDanhSach() {
        for (Giay giay : list) {
            System.out.print("Ma giay: " + giay.getMaGiay() + ", Ten giay: " + giay.getTenGiay() + ", Size: " + giay.getSize());
            if (giay instanceof Giay_da_bong) {
                Giay_da_bong gdb = (Giay_da_bong) giay;
                System.out.print(", Loai de: " + gdb.getLoaiDe() + ", So luong: " + gdb.getSoLuong() + ", Gia ban: " + gdb.getGiaBan());
            } else if (giay instanceof Giay_cau_long) {
                Giay_cau_long gcl = (Giay_cau_long) giay;
                System.out.print(", Do bam: " + gcl.getDoBam() + ", So luong: " + gcl.getSoLuong() + ", Gia ban: " + gcl.getGiaBan());
            } else if (giay instanceof Giay_chay_bo) {
                Giay_chay_bo gcb = (Giay_chay_bo) giay;
                System.out.print(", Do em: " + gcb.getDoEm() + ", So luong: " + gcb.getSoLuong() + ", Gia ban: " + gcb.getGiaBan());
            }
            System.out.println();
        }
    
    }

    public Giay TimKiemTheoMa(String maGiay) {
        for (Giay giay : list) {
            if (giay.getMaGiay().equals(maGiay)) {
                return giay;
            }
        }
        return null;
    }

    public boolean SuaGiay(String maGiay, Giay giayMoi) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaGiay().equals(maGiay)) {
                list.set(i, giayMoi);
                return true;
            }
        }
        return false;
    }

    public boolean XoaGiay(String maGiay) {
        return list.removeIf(giay -> giay.getMaGiay().equals(maGiay));
    }
}

 
   
    // phần tiếp theo

