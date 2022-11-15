import java.util.Scanner;

public class CThu extends CNguoi{
	
	private int so;
	private String vtri;
	private long bthang;
	private String mua;
	private String clbo;
	
	public CThu() {
		super();
		so = 0;
		vtri = new String();
		bthang = 0;
		mua = new String();
		clbo = new String();
	}
	
	public CThu(CThu c) {
		super(c);
		so = c.so;
		vtri = new String(c.vtri);
		bthang = c.bthang;
		mua = new String(c.mua);
		clbo = new String(c.clbo);
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		super.nhap();
		System.out.print("Nhap vao so ao cua cau thu: ");
		so = sc.nextInt(); sc.nextLine();
		System.out.print("Nhap vao vi tri cua cau thu: ");
		vtri = sc.nextLine();
		System.out.print("Nhap vao so ban thang ma cau thu ghi duoc: ");
		bthang = sc.nextInt(); sc.nextLine();
		System.out.print("Nhap vao mua giai cau thu thi dau: ");
		mua = sc.nextLine();
		System.out.print("Nhap vao ten clb cua cau thu: ");
		clbo = sc.nextLine();
	}
	
	public void in() {
		super.in();
		System.out.print(", So ao: " + so + ", Vi tri: " + vtri + ", So ban thang ghi duoc: " + bthang + ", Mua giai: " + mua + ", Ten clb: " + clbo);
	}
	
	public String toString() {
		return super.toString() + (", So ao: " + so + ", Vi tri: " + vtri + ", So ban thang ghi duoc: " + bthang + ", Mua giai: " + mua + ", Ten clb: " + clbo);
	}
	
	public long tinhLuong() {
		long tienLuong = 7000000;
		if (this.vtri.equalsIgnoreCase("Thu mon")) {
			tienLuong += 3000000;
		}
		else if (this.vtri.equalsIgnoreCase("Hau ve")) {
			tienLuong += 4000000;
		}
		else if (this.vtri.equalsIgnoreCase("Trung ve")) {
			tienLuong += 4500000;
		}
		else if (this.vtri.equalsIgnoreCase("Tien ve")) {
			tienLuong += 5000000;
		}
		else if (this.vtri.equalsIgnoreCase("Tien dao")) {
			tienLuong += 7000000;
		}
		tienLuong += this.bthang * 500000;
		tienLuong = tienLuong * 9 / 10;
		return tienLuong;
	}
	
	public long laySoBanThang() {
		return this.bthang;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("So luong doi tuong ban muon nhap: ");
		int n = sc.nextInt();
		CNguoi c[] = new CNguoi[n];
		for (int i = 0; i < n; i++) {
			System.out.println("\nNhap vao thong tin cho doi tuong " + (i + 1) + ":");
			System.out.println("Ban nhap thong tin cho ConNguoi[1] hay CauThu[2]?");
			System.out.print("->Lua chon cua ban la: "); int choice = sc.nextInt();
			if (choice == 1) {
				c[i] = new CNguoi();
				c[i].nhap();
			}
			else {
				c[i] = new CThu();
				c[i].nhap();
			}
		}
		System.out.println("\nDanh sach ban vua nhap la:");
		for (int i = 0; i < n; i++) {
			System.out.println("- Thong tin cua doi tuong thu " + (i + 1) + ": " + c[i]);
		}
		long dsTienLuong[] = new long[n];
		for (int i = 0; i < n; i++) {
			dsTienLuong[i] = c[i].tinhLuong();
		}
		System.out.println("\nDanh sach tien luong:");
		for (int i = 0; i < n; i++) {
			System.out.println("- Tien luong cua nguoi thu " + (i + 1) + " la: " + dsTienLuong[i] + " VND");
		}
		int bThangTuoi18_24 = 0;
		int bThangTuoi25_28 = 0;
		int bThangLonHon28 = 0;
		for (int i = 0; i < n; i++) {
			if (c[i].layTuoi() >= 18 && c[i].layTuoi() <= 24) {
				bThangTuoi18_24 += c[i].laySoBanThang();
			}
			else if (c[i].layTuoi() >= 25 && c[i].layTuoi() <= 28) {
				bThangTuoi25_28 += c[i].laySoBanThang();
			}
			else if (c[i].layTuoi() > 28) {
				bThangLonHon28 += c[i].laySoBanThang();
			}
		}
		System.out.println("\nThong ke so ban thang cua cau thu o cac do tuoi:");
		System.out.println("- Ban thang cap do tuoi 18 - 24: " + bThangTuoi18_24);
		System.out.println("- Ban thang cap do tuoi 25 - 28: " + bThangTuoi25_28);
		System.out.println("- Ban thang cap do tuoi > 28: " + bThangLonHon28);
	}
}
