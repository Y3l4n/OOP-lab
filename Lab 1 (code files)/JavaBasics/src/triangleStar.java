import java.util.Scanner;
public class triangleStar {
    
    public static void main(String[] args) {
        
        int k = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Your number: ");

        int inputInt = input.nextInt();

        for (int i = 1; i <= inputInt; ++i, k = 0) {
            for (int space = 1; space <= inputInt - i; ++space){

                System.out.print(" ");
            }

            while(k != 2 * i - 1){
                System.out.print("*");
                k++;
            }
            System.out.println();
        }
        input.close();
    }
}
