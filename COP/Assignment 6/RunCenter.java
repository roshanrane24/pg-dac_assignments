//
//----------------------------------------------
//******* Java Assignment Section-6 ********* Prev=57
//---------------------------------------------
//1. Install Eclipse with help of lab faculty, write and run some java programs.
//   Set it up for java 8.
//
//2. Practice whatever is tought in the classroom - final, access modifier, constructors
//
//3. Write a menu driven billing system for a Snacks center, items available are Tea(Rs. 10), Samosa (Rs. 20), Sandwitch(Rs. 50), Green Tea (Rs. 15) etc. as follows - 
//
//****Welcome to Snack Center *********
//1. Tea (Rs. 10)
//2. Green Tea (Rs. 15)
//3. Samosa (Rs. 20)
//4. Sandwitch (Rs. 50)
//5. Generate Bill & Exit
//Enter your choice : 1
//   Enter quantity : 2
//   
//1. Tea (Rs. 10)
//2. Green Tea (Rs. 15)
//3. Samosa (Rs. 20)
//4. Sandwitch (Rs. 50)
//5. Generate Bill & Exit
//Enter your choice : 3
//  Enter quantity : 3
//  
//1. Tea (Rs. 10)
//2. Green Tea (Rs. 15)
//3. Samosa (Rs. 20)
//4. Sandwitch (Rs. 50)
//5. Generate Bill & Exit
//Enter your choice : 5
//
// *****BILL****
// Tea    2    20
// Samosa 3    60
// ------------
// Total = 80
//

import java.util.Scanner;

class RunCenter {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        SnackCenter sc = new SnackCenter();
        int choice = 0;

        while (choice != 5) {
            SnackCenter.displayMenu();

            System.out.print("Enter your choice : ");
            choice = scan.nextInt();

            int quantity = 0;
            if (choice > 0 && choice < 5) {
                System.out.print("Enter Quantity : ");
                quantity = scan.nextInt();
            }
            sc.takeOrder(choice, quantity);
        }

        scan.close();
        sc.displayBill();
    }
}