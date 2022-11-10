import java.util.Scanner;

public class TheSystemofFirstDegree{
	static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.err.println("He phuong trinh co dang a11x1+a12x2=b1 a21x1+a22x2=b2 vui long nhap lan luot cac gia tri\n");
        System.out.print("Nhap a11, a11 = ");
        float a = scanner.nextFloat();
        System.out.print("Nhap a12, a12 = ");
        float b =scanner.nextFloat();
        System.out.print("Nhap b1, b1 = ");
        float e = scanner.nextFloat();
        System.out.print("Nhap a21, a21 = ");
        float c = scanner.nextFloat();
        System.out.print("Nhap a22, a22 = ");
        float d = scanner.nextFloat();
        System.out.print("Nhap b2, b2 = ");
        float f = scanner.nextFloat();
        giaiBacnhat2an(a, b, e, c, d, f);
    }
    
    public static void giaiBacnhat2an(float a, float b, float e, float c, float d, float f) {
    	float det = a * d - b * c;
    	if (det == 0)
    		System.out.println("He Phuong Trinh vo nghiem");
    	else {
    		float x = ((d) * (e) - (b) * (f)) / det;
            float y = ((a) * (f) - (c) * (e)) / det;
            System.out.print("x=" + x + " y=" + y);
    	}
        
    }
}