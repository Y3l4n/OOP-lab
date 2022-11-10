import java.util.Scanner;
public class SortArray {
    
	public static void main(String[] args) {
	    int n, tmp;
	    Scanner scanner = new Scanner(System.in);
	    do {
	        System.out.print("Nhap vao so phan tu cua mang: ");
	        n = scanner.nextInt();
	    } while (n < 0);
	    
	    int array[] = new int[n];
	         
	    System.out.println("Nhap cac phan tu cho mang: ");
	    for (int i = 0; i < n; i++) {
	        System.out.print("Nhap phan tu thu " + (i+1)+ ": ");
	        array[i] = scanner.nextInt();
	        
	    }
	         
	    // Hiển thị mảng vừa nhập
	    System.out.println("\nMang ban dau: ");
	    for (int i = 0; i < n; i++) {
	        System.out.print(array[i] + "\t");
	    }
	        
	         
	
	    for (int i = 0; i < n - 1; i++) {
	        for (int j = i + 1; j <= n - 1; j++) {
	            if (array[i] < array[j]) {
	                tmp = array[i];
	                array[i] = array[j];
	                array[j] = tmp;
	            }
	        }
	    }
	    System.out.println("\nMang sau khi sap xep giam dan la:");
	    for (int i = 0; i < n; i++) {
	        System.out.print(array[i] + "\t");
	    }
	        
	        
	        for (int i = 0; i < n - 1; i++) {
		        for (int j = i + 1; j <= n - 1; j++) {
		            if (array[i] > array[j]) {
		                tmp = array[i];
		                array[i] = array[j];
		                array[j] = tmp;
		            }
		        }
		    }
	        
	        System.out.println("\nMang sau khi sap xep tang dan la: ");
		    for (int i = 0; i < n; i++) {
		        System.out.print(array[i] + "\t");
		    } 
	}
}

