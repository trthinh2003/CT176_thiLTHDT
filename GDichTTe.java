import java.util.Scanner;

public class GDichTTe extends GDich {
	
	private float dgia;
	private int sluong;
	private char loai;
	private float tgia;
	
	public GDichTTe() {
		super();
		dgia = 0.0f;
		sluong = 0;
		loai = 'F';
		tgia = 0.0f;
	}
	
	public GDichTTe(GDichTTe g) {
		super(g);
		dgia =g.dgia;
		sluong = g.sluong;
		loai = g.loai;
		tgia = g.tgia;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		super.nhap();
		System.out.print("Nhap vao don gia: ");
		dgia = sc.nextFloat();
		System.out.print("Nhap vao so luong: ");
		sluong = sc.nextInt(); sc.nextLine();
		System.out.print("Nhap vao loai tien te (V: VND, U: USD, E: Euro): ");
		loai = sc.nextLine().charAt(0);
		System.out.print("Nhap vao ti gia: ");
		tgia = sc.nextFloat();
	}
	
	public void in() {
		super.in();
		System.out.println(", Don gia: " + dgia + ", So luong: " + sluong + ", Loai tien te: " + loai + ", Ti gia: " + tgia);
	}
	
	public String toString() {
		return super.toString() + (", Don gia: " + dgia + ", So luong: " + sluong + ", Loai tien te: " + loai + ", Ti gia: " + tgia);
	}
	
	public float tinhTienGiaoDich() {
		return this.doiSangVND(this.dgia) * this.sluong * this.tgia;
	}
	
	public float doiSangVND(float donGia) {
		float tienDoi = 0.0f;
		if (this.loai == 'U') {
			tienDoi += this.dgia * 24000;
		}
		else if (this.loai == 'E') {
			tienDoi += this.dgia * 35000;
		}
		else {
			tienDoi += this.dgia;
		}
		return tienDoi;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("So luong doi tuong ban muon nhap la: ");
		int n = sc.nextInt();
		GDich g[] = new GDich[n];
		for (int i = 0; i < n; i++) {
			System.out.println("\nNhap thong tin giao dich cho doi tuong " + (i + 1) + ":");
			System.out.println("Ban muon nhap thong tin cho doi tuong GiaoDich[1] hay GiaoDichTienTe[2]?");
			System.out.print("->Lua chon cua ban la: "); int choice = sc.nextInt();
			if (choice == 1) {
				g[i] = new GDich();
				g[i].nhap();
			}
			else {
				g[i] = new GDichTTe();
				g[i].nhap();
			}
		}
		System.out.println("\nDanh sach doi tuong giao dich ban vua nhap:");
		for (int i = 0; i < n; i++) {
			System.out.println("- Thong tin cua doi tuong " + (i + 1) + ": " + g[i]);
		}
		System.out.print("\nDanh sach ma so giao dich tien te co gia tri > 100000 VND: ");
		for (int i = 0; i < n; i++) {
			if (g[i].tinhTienGiaoDich() > 100000) {
				System.out.print(g[i].layMaGD() + " ");
			}
		}
		System.out.println("\n\nThong ke giao dich theo thang - nam:");
		for (int i = 0; i < n; i++) {
			System.out.println("- Giao dich thang " + g[i].tachThangNamGD() + ": " + g[i].tinhTienGiaoDich() + " VND");
		}
	}
}
