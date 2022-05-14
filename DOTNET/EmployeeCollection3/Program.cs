// Assignment 6 - 3 (Day 4)

using System;
using System.Collections.Generic;

namespace EmployeeCollection3
{
    static class Program
    {
        static void Main()
        {
            List<Employee> empList = new List<Employee>();
            empList.Add(new Employee("Emp1", 180000, 5));
            empList.AddRange(
                new[] {
                new Employee("Emp2", 190000, 2),
                new Employee("Emp3", 210000, 5),
                new Employee("Emp5", 195000, 4),
                new Employee("Emp6", 220000, 6)
                }
            );
            empList.Insert(3, new Employee("Emp4", 250000, 2));

            foreach (var employee in empList)
            {
                Console.WriteLine(employee);
                Console.WriteLine();
            }
        }
    }
}