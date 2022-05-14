// Assignment 5 - Day 3 - Q3
using System;

namespace StudentStructure
{
    public class Program
    {
        public struct Student
        {
            public string Name { get; set; }
            public int RollNo { get; set; }
            public decimal Marks { get; set; }

            public Student(string name, int rollNo, decimal marks)
            {
                Name = name;
                RollNo = rollNo;
                Marks = marks;
            }
        }
        static void Main()
        {
            Student[] students = new Student[5];

            Console.WriteLine("Enter details of 5 student : ");

            for (int i = 0; i < students.Length; i++)
            {
                Console.WriteLine("Enter Student Details [Name RollNo Marks] : ");
                string[] data = Console.ReadLine().Split();
                students[i] = new Student()
                {
                    Name = data[0],
                    RollNo = Convert.ToInt32(data[1]),
                    Marks = Convert.ToDecimal(data[2])
                };
            }

            foreach (Student s in students)
            {
                PrintStudent(s);
            }

        }

        private static void PrintStudent(Student student)
        {
            Console.WriteLine($@"Name : {student.Name}
RollNo : {student.RollNo}
Marks : {student.Marks}
");
        }
    }
}