// Assignment 6 - 1 (Day 4)

using System;
using System.Collections.Generic;

namespace EmployeeCollection1
{
    public class Program
    {
        static void Main()
        {
            Dictionary<int, Employee> empDictionary = new Dictionary<int, Employee>();
            while (true)
            {
                Employee emp = GetEmployee();
                empDictionary[emp.EmpNo] = emp;

                Console.Write("Do you want to add more employee (y/yes|[n/No]) : ");
                var resp = Console.ReadLine();

                if (resp != "y" || resp != "Y" || resp != "yes" || resp != "Yes")
                    break;
            }
            Console.WriteLine(":: Employee With Highest Salary :: ");
            Console.WriteLine(CalcMaxSalary(empDictionary));

            Console.WriteLine(":: Search Employee :: ");
            Console.WriteLine(empDictionary[GetEmpNo()]);

            Console.WriteLine(":: Search Index :: ");
            Employee[] emps = new Employee[empDictionary.Count];
            empDictionary.Values.CopyTo(emps, 0);
            Console.WriteLine(emps[Convert.ToInt32(Console.ReadLine()) - 1]);
        }

        #region getEmployeeFromUser
        private static Employee GetEmployee()
        {
            Console.WriteLine("Enter Employee Details : ");
            string empName = GetEmpName();
            short empDeptNo = GetEmpDept();
            decimal empBasic = GetEmpBasic();

            return new Employee(empName, empBasic, empDeptNo);
        }

        #region getEmloyeeDetail
        private static int GetEmpNo()
        {
            try
            {
                Console.Write("Enter Employee Number : ");
                return Convert.ToInt32(Console.ReadLine());
            }
            catch (Exception e)
            {
                Console.WriteLine($"Exception while parsing EmpNo :: {e}");
                return GetEmpNo();
            }
        }

        private static string GetEmpName()
        {
            try
            {
                Console.Write("Enter Employee Name : ");
                return Console.ReadLine() ?? throw new InvalidOperationException();
            }
            catch (InvalidOperationException e)
            {
                Console.WriteLine($"Employee Name Required :: {e}");
                return GetEmpName();
            }
            catch (Exception e)
            {
                Console.WriteLine($"Exception while parsing EmpName :: {e}");
                return GetEmpName();
            }
        }

        private static decimal GetEmpBasic()
        {
            try
            {
                Console.Write("Enter Employee Salary : ");
                return Convert.ToDecimal(Console.ReadLine());
            }
            catch (Exception e)
            {
                Console.WriteLine($"Exception while parsing EmpBasic :: {e}");
                return GetEmpBasic();
            }
        }

        private static short GetEmpDept()
        {
            try
            {
                Console.Write("Enter Employee DeptNo : ");
                return Convert.ToInt16(Console.ReadLine());
            }
            catch (Exception e)
            {
                Console.WriteLine($"Exception while parsing EmpDeptNo :: {e}");
                return GetEmpDept();
            }
        }
        #endregion
        #endregion

        #region CalcMaxSalary
        private static Employee CalcMaxSalary(Dictionary<int, Employee> dict)
        {
            Employee maxEmp = null;

            foreach (Employee emp in dict.Values)
            {
                // Assuming first employees has max Salary
                if (maxEmp == null)
                    maxEmp = emp;
                else
                {
                    // Check if current employee has more salary than maxEmp
                    if (maxEmp.Basic < emp.Basic)
                        maxEmp = emp;
                }

            }
            return maxEmp;
        }
        #endregion
    }
}