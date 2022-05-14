// Assignment 5 - Day 3 - Q1
using EmployeeClass2;
using System;

namespace EmployeeArray
{
    class Program
    {
        static void Main()
        {
            Employee[] empArr = new Employee[5];

            #region AcceptEmployeeData
            // Accept emp data
            Console.WriteLine("Enter details of the employees.");
            string data;
            for (int i = 0; i < empArr.Length; i++)
            {
                Console.WriteLine($"Employee {i + 1}");
                Console.Write("Enter employee Name, Basic Salary & Dept No : ");

                data = Console.ReadLine();
                if (string.IsNullOrWhiteSpace(data))
                {
                    Console.WriteLine("Please provid details");
                    i--;
                }
                else
                {
                    string[] details = data.Split(' ');
                    empArr[i] = new Employee(details[0], decimal.Parse(details[1]), short.Parse(details[2]));
                }
            }
            #endregion

            #region EmployeeWithHighestSalary
            // Emp with highest salary
            Employee maxSalEmp = empArr[0];
            foreach (Employee emp in empArr)
            {
                if (emp.Basic > maxSalEmp.Basic)
                    maxSalEmp = emp;
            }

            Console.WriteLine(maxSalEmp.Name + maxSalEmp.ToString());
            #endregion

            #region FindEmployee

            // Find Employee
            Console.Write("Enter Employee No : ");
            data = Console.ReadLine();
            int eId = int.Parse(data);
            foreach (Employee emp in empArr)
            {
                if (emp.EmpNo == eId)
                {
                    Console.WriteLine(emp.Name + emp.ToString());
                    return;
                }
            }

            Console.WriteLine("Employee Not Found");

            #endregion
        }
    }
}