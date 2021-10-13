// Q8. Write a java program to convert temperature from celsius to fahrenheit, get input from command line ?

class CelciusToFahrenheit {
    public static void main(String[] args) {
        double temp = Double.parseDouble(args[0]);
        System.out.println("Temperature in fahrenheit " + (((9 * temp) / 5) + 32) );
    }
}
