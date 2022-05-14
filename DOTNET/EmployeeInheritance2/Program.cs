// Assignment 4 - Day 3
using System;

namespace EmployeeInheritance2
{
    public class Program
    {
        static void Main()
        {
            Employee e1 = new Manager("MGR", "Roshan", 26000, 20);
            Employee e2 = new GeneralManager("MGR", "Roshan", 56000, 10, "Perks");
            Employee e3 = new CEO("Roshan", 66000, 30);

            Console.WriteLine(e1);
            Console.WriteLine(e2);
            Console.WriteLine(e3);

            Console.WriteLine(e1.CalcNetSalary());
            Console.WriteLine(e2.CalcNetSalary());
            Console.WriteLine(e3.CalcNetSalary());

        }
    }
}