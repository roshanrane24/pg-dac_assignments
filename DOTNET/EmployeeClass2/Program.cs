// Assignment 2 - Day 2 
using System;

namespace EmployeeClass2
{
    static class Program
    {
        static void Main()
        {
            // create employee objects
            Employee o1 = new Employee();
            Employee o2 = new Employee();
            Employee o3 = new Employee();

            // print emp-no
            Console.WriteLine(o1.EmpNo);
            Console.WriteLine(o2.EmpNo);
            Console.WriteLine(o3.EmpNo);

            Console.WriteLine(o3.EmpNo);
            Console.WriteLine(o2.EmpNo);
            Console.WriteLine(o1.EmpNo);
        }
    }
}