// Assignment 7 (Day 4)
using System;

namespace Lambda
{
    static class Program
    {
        static void Main()
        {
            // 1. decimal SimpleInterest(decimal P, decimal N, decimal R) -> returns calculated SimpleInterest
            Func<decimal, decimal, decimal, decimal> simpleInterest = (p, n, r) => (p * r * n) / 100;

            // 2. bool IsGreater(int a, int b) -> returns true if a is > b
            Func<int, int, bool> isGreater = (a, b) => a > b;

            // 3. decimal GetBasic(Employee e) -> returns the Basic salary of the employee
            Func<Employee, decimal> getBasic = employee => employee.Basic;

            // 4. bool IsEven(int num) -> returns true if the number is an even number
            Predicate<int> isEven = i => i % 2 == 0;

            // 5. bool IsGreaterThan10000(Employee e) -> returns true if the Basic Salary is > 10000
            Predicate<Employee> isGreaterThan = employee => employee.Basic > 10000;
        }
    }
}