import java.util.Scanner;
import java.lang.String;

public class GDich {
	
	private int mgd;
	private String hten;
	private String ngay;
	private boolean tthai;
	
	public GDich() {
		mgd = 0;
		hten = new String();
		ngay = new String();
		tthai = false;
	}
	
	public GDich(int mgd1, String hten1, String ngay1, boolean tthai1) {
		mgd = mgd1;
		hten = new String(hten1);
		ngay = new String(ngay1);
		tthai = tthai1;
	}
	
	public GDich(GDich g) {
		mgd = g.mgd;
		hten = new String(g.hten);
		ngay = new String(g.ngay);
		tthai = g.tthai;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap vao ma giao dich: "); 
		mgd = sc.nextInt(); sc.nextLine();
		System.out.print("Nhap vao ho va ten: ");
		hten = sc.nextLine();
		System.out.print("Nhap vao ngay thuc hien giao dich: ");
		ngay = sc.nextLine();
		System.out.print("Nhap vao trang thai giao dich (true: Thanh cong, false: That bai): ");
		tthai = sc.nextBoolean();
	}
	
	public void in() {
		System.out.print("Ma giao dich: "+ mgd + ", Ho va ten: " + hten + ", Ngay giao dich: " + ngay + ", Trang thai giao dich: " + tthai);
	}
	
	public String toString() {
		return ("Ma giao dich: "+ mgd + ", Ho va ten: " + hten + ", Ngay giao dich: " + ngay + ", Trang thai giao dich: " + tthai);
	}
	
	public float tinhTienGiaoDich() {
		return 0;
	}
	
	public int layMaGD() {
		return mgd;
	}
	
	public float doiSangVND(float donGia) {
		return 0.0f;
	}
	
	public String tachThangNamGD() {
		String s[] = this.ngay.split("-");		
		return s[1] + "-" + s[2];
	}
	
	public String layNgayGD() {
		return this.ngay;
	}
	
	public static void main(String[] args) {
		GDich gd1 = new GDich();
		gd1.nhap();
		System.out.println("Thong tin giao dich gd1: " + gd1);
		GDich gd2 = new GDich(gd1);
		System.out.println("Thong tin giao dich gd2: " + gd2);
	}
}
