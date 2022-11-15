import java.util.Scanner;

public class Xe {
	
	private String soxe;
	private String loai;
	private String ngay;
	private char tthai;
	
	public Xe() {
		soxe = new String();
		loai = new String();
		ngay = new String();
		tthai = 'K';
	}
	
	public Xe(Xe x) {
		soxe = new String(x.soxe);
		loai = new String(x.loai);
		ngay = new String(x.ngay);
		tthai = x.tthai;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("- Nhap vao so xe: ");
		soxe = sc.nextLine();
		System.out.print("- Nhap vao loai xe: ");
		loai = sc.nextLine();
		System.out.print("- Nhap vao ngay dang kiem: ");
		ngay = sc.nextLine();
		System.out.print("- Nhap vao trang thai cho phep luu hanh (C: Co, K: Khong): ");
		tthai = sc.nextLine().charAt(0);
	}
	
	public void in() {
		System.out.print("[So xe: " + soxe + ", Loai xe: " + loai + ", Ngay dang kiem: " + ngay + ", Trang thai cho phep luu hanh: " + tthai + " ]");
	}
	
	public String toString() {
		return ("[So xe: " + soxe + ", Loai xe: " + loai + ", Ngay dang kiem: " + ngay + ", Trang thai cho phep luu hanh: " + tthai + " ]");
	}
	
	public char layTThaiCapPhep() {
		return this.tthai;
	}
	
	public String layThangNam() {
		String thangNam[] = this.ngay.split("-");
		return thangNam[1] + " - " + thangNam[2];
	}
	
	public static void main(String[] args) {
		Xe x1 = new Xe();
		x1.nhap();
		System.out.println("Thong tin doi tuong xe x1 ban vua nhap: " + x1);
		Xe x2 = new Xe(x1);
		System.out.println("Thong tin doi tuong xe x2: " + x2);
	}
}
