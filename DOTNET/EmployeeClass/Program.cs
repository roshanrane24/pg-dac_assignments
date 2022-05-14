// Assignment 1 - Day 1 
using System;

namespace EmployeeClass
{
    class Program
    {
        static void Main()
        {
            // Constructor Test
            Employee o1 = new Employee(1, "Amol", 123465, 10);
            Employee o2 = new Employee(1, "Amol", 123465);
            Employee o3 = new Employee(1, "Amol");
            Employee o4 = new Employee(1);
            Employee o5 = new Employee();

            // Property Test
            Employee e = new Employee();

            // name
            e.Name = "";
            e.Name = "Roshan";
            Console.WriteLine(e.Name);

            // EmpNo
            e.EmpNo = 0;
            e.EmpNo = 10;
            Console.WriteLine(e.EmpNo);

            // Basic
            e.Basic = 1234;
            e.Basic = 234567;
            Console.WriteLine(e.Basic);

            // Dept No
            e.DeptNo = 0;
            e.DeptNo = 1;
            Console.WriteLine(e.DeptNo);

            // Net Salary
            Console.WriteLine(e.GetNetSalary());
        }
    }
}