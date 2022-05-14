// Assignment 8 (Day 4)

using System;
using System.Collections.Generic;

namespace Exception
{
    static class Program
    {
        static void Main()
        {
            List<Employee> list = new List<Employee>();

            try
            {
                list.Add(new CEO("ceo1", 100, 1));
            }
            catch (System.Exception e)
            {
                Console.WriteLine(e.Message);
            }

            try
            {
                list.Add(new CEO("ceo2", 65000));
            }
            catch (System.Exception e)
            {
                Console.WriteLine(e);
            }

            try
            {
                list.Add(new CEO("", 65000, 1));
            }
            catch (System.Exception e)
            {
                Console.WriteLine(e);
            }

            try
            {
                list.Add(new CEO("ceo3", 65000, 1));
            }
            catch (System.Exception e)
            {
                Console.WriteLine(e);
            }

            try
            {
                list.Add(new Manager("", "mgr1", 50000, 1));
            }
            catch (System.Exception e)
            {
                Console.WriteLine(e);
            }

            try
            {
                list.Add(new Manager("Project", "mgr2", 40000, 1));
            }
            catch (System.Exception e)
            {
                Console.WriteLine(e);
            }

            foreach (var emp in list)
            {
                Console.WriteLine(emp);
                Console.WriteLine();
            }
        }

    }
}