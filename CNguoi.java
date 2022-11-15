import java.util.Scanner;

public class CNguoi {
	
	private String id;
	private String hten;
	private String ngay;
	private char  phai;
	
	public CNguoi() {
		id = new String();
		hten = new String();
		ngay = new String();
		phai = 'F';
	}
	
	public CNguoi(CNguoi c) {
		id = new String(c.id);
		hten = new String(c.hten);
		ngay = new String(c.ngay);
		phai = c.phai;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap vao id: ");
		id = sc.nextLine();
		System.out.print("Nhap vao ho va ten: ");
		hten = sc.nextLine();		
		System.out.print("Nhap vao ngay thang nam sinh: ");
		ngay = sc.nextLine();
		System.out.print("Nhap vao phai (M: Nam, F: Nu): ");
		phai = sc.nextLine().charAt(0);
	}
	
	public void in() {
		System.out.print("ID: " + id + ", Ho va ten: " + hten + ", Ngay sinh: " + ngay + ", Gioi tinh: " + phai);
	}
	
	public String toString() {
		return ("ID: " + id + ", Ho va ten: " + hten + ", Ngay sinh: " + ngay + ", Gioi tinh: " + phai);
	}
	
	public long tinhLuong() {
		return 0;
	}
	
	public int layNamSinh(String ngaySinh) {
		String s = new String();
		String namSinh_string = new String();
		s = "";
		namSinh_string = "";
		for (int i = this.ngay.length() - 1; i >= 0; i--) {
			s += ngaySinh.charAt(i);
			if (i == 6) break;
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			namSinh_string += s.charAt(i);
		}
		return Integer.parseInt(namSinh_string);
	}
	
	public int layTuoi() {
		return 2022 - this.layNamSinh(this.ngay);
	}
	
	public long laySoBanThang() {
		return 0;
	}
	
	public static void main(String[] args) {
		CNguoi c1 = new CNguoi();
		c1.nhap();
		System.out.println("Thong tin doi tuong c1: " + c1);
		CNguoi c2 = new CNguoi(c1);
		System.out.println("Thong tin doi tuong c2: " + c2);
	}
}
