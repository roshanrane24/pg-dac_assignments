// Assignment 5 - Day 3 - Q2
using System;

namespace StudentsMarksArray
{
    public class Program
    {
        static void Main()
        {
            Console.Write("Enter number of batches : ");
            double[][] studentMarksByBatch = new double[Convert.ToInt16(Console.ReadLine())][];

            for (int i = 0; i < studentMarksByBatch.Length; i++)
            {
                Console.WriteLine($"Batch : {i + 1}");
                Console.Write($"Enter no. of students in Batch {i + 1} : ");
                studentMarksByBatch[i] = new double[Convert.ToInt16(Console.ReadLine())];

                // 
                for (int j = 0; j < studentMarksByBatch[i].Length; j++)
                {
                    Console.Write($"Marks for Batch {i + 1} Student {j + 1} : ");
                    studentMarksByBatch[i][j] = Convert.ToInt32(Console.ReadLine());
                }
            }

            for (int i = 0; i < studentMarksByBatch.Length; i++)
            {
                Console.WriteLine($"Batch {i + 1}");
                for (int j = 0; j < studentMarksByBatch[i].Length; j++)
                {
                    Console.WriteLine($"Student {j + 1} : {studentMarksByBatch[i][j]}");
                }
                Console.Write("\n");
            }
        }
    }
}