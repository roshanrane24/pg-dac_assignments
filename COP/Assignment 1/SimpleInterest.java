class SimpleInterest {
    public static void main(String[] args) {
        int principle = Integer.parseInt(args[0]);
        System.out.print("Principle Ammount : " + principle);

        double rate = Double.parseDouble(args[1]);
        System.out.print("Rate : "  + rate);

        int time = Integer.parseInt(args[2]);
        System.out.print("Duration : " + time);

        System.out.print("Simple Interest = ");
        System.out.print((principle * rate * time)/ 100);
        System.out.println(" Rs.");
    }
}
