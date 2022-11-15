import java.util.Scanner;

public class ChuyenXe {
	
	private int msc;
	private String tenlx;
	private String nden;
	private float dthu;
	
	private Xe x;
	
	public ChuyenXe() {
		msc = 0;
		tenlx = new String();
		nden = new String();
		dthu = 0.0f;
		x = new Xe();
	}
	
	public ChuyenXe(ChuyenXe cx) {
		msc = cx.msc;
		tenlx = new String(cx.tenlx);
		nden = new String(cx.nden);
		dthu = cx.dthu;
		x = new Xe(cx.x);
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap vao ma so chuyen xe: ");
		msc = sc.nextInt(); sc.nextLine();
		System.out.print("Nhap vao ten nguoi lai xe: ");
		tenlx = sc.nextLine();
		System.out.print("Nhap vao noi den: ");
		nden = sc.nextLine();
		System.out.print("Nhap vao doanh thu: ");
		dthu = sc.nextFloat();
		System.out.println("Nhap vao thong tin xe: ");
		x.nhap();
	}
	
	public void in() {
		System.out.print("Ma so chuyen xe: " + msc + ", Ten nguoi lai xe: " + tenlx + ", Noi den: " + nden + ", Doanh thu: " + dthu + ", Thong tin xe: " + x);
	}
	
	public String toString() {
		return ("Ma so chuyen xe: " + msc + ", Ten nguoi lai xe: " + tenlx + ", Noi den: " + nden + ", Doanh thu: " + dthu + ", Thong tin xe: " + x);
	}
	
	public float tinhLoiNhuan() {
		return this.dthu * 30 / 100;
	}
	
	public char layTThaiCapPhep() {
		Xe xtt = new Xe(x);
		return xtt.layTThaiCapPhep();
	}
	
	public float layDoanhThu() {
		return this.dthu;
	}
	
	public String layThangNam() {
		return this.x.layThangNam();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("So luong doi tuong chuyen xe ban muon nhap: ");
		int m = sc.nextInt();
		ChuyenXe ds1[] = new ChuyenXe[m];
		for (int i = 0; i < m; i++) {
			System.out.println("\nNhap vao thong tin cho doi tuong chuyen xe thu " + (i + 1) + ":");
			ds1[i] = new ChuyenXe();
			ds1[i].nhap();
		}
		System.out.println("\nDanh sach chuyen xe ban vua nhap:");
		for (int i = 0; i < m; i++) {
			System.out.println("- Thong tin cua doi tuong thu " + (i + 1) + ": " + ds1[i]);
		}
		System.out.println("\nDanh sach chuyen xe bi huy (Chuyen xe khong duoc cap phep luu hanh hoac co doanh thu < 100000):");
		for (int i = 0; i < m; i++) {
			System.out.print("- Thong tin cua chuyen xe bi huy thu " + (i + 1) + ": ");
			if (ds1[i].layTThaiCapPhep() == 'K' || ds1[i].layDoanhThu() < 100000) {
				ds1[i].in();
			}
		}
		System.out.println("\nThong ke loi nhuan cua tung loai xe theo thang - nam:");
		for (int i = 0; i < m; i++) {
			System.out.println("- Loi nhuan thang " + ds1[i].layThangNam() + " la: " + ds1[i].tinhLoiNhuan() + " VND");
		}
		
	}
	
}
