public class SnackCenter {

    int tea;
    int gTea;
    int samosa;
    int sandwich;

    static int teaRate = 10;
    static int gTeaRate = 15;
    static int samosaRate = 20;
    static int sandwichRate = 50;

    public SnackCenter () {
        System.out.println("****Welcome to Snack Center *********");
        this.tea = 0;
		this.gTea = 0;
		this.samosa = 0;
		this.sandwich = 0;
    }

    static void displayMenu(){
        System.out.println("1. Tea (Rs. 10)");
        System.out.println("2. Green Tea (Rs. 15)");
        System.out.println("3. Samosa (Rs. 20)");
        System.out.println("4. Sandwich (Rs. 50)");
        System.out.println("5. Generate Bill & Exit");
    }

    public void displayBill() {
        System.out.println();
        System.out.println("*****BILL****");
        if (this.tea != 0) System.out.println("Tea\t\t"
                + this.tea + "\t" + SnackCenter.teaRate);
        if (this.gTea != 0) System.out.println("Green Tea\t"
                + this.gTea + "\t" + SnackCenter.gTeaRate);
        if (this.samosa != 0) System.out.println("Samosa\t\t"
                + this.samosa + "\t" + SnackCenter.samosaRate);
        if (this.sandwich != 0) System.out.println("Sandwich\t"
                + this.sandwich + "\t" + SnackCenter.sandwichRate);
        System.out.println("------------");
        System.out.println("Total = " + ((this.tea * SnackCenter.teaRate) + (this.gTea * SnackCenter.gTeaRate) + (this.samosa * SnackCenter.samosaRate) + (this.sandwich * SnackCenter.sandwichRate)));

    }

    public void takeOrder(int item, int quantity) {	
        switch (item) {
            case 1 -> this.tea += quantity;
            case 2 -> this.gTea += quantity;
            case 3 -> this.samosa += quantity;
            case 4 -> this.sandwich += quantity;
            case 5 -> {}
            default -> System.out.println("Not a valid choice.");
        }
    }
}
