using System;

namespace EmployeeInheritance
{
    public class Manager : Employee
    {
        private string _designation = "";

        public string Designation
        {
            get => this._designation;
            set
            {
                if (value.Length > 0)
                    this._designation = value;
                else
                    Console.WriteLine("Designation cannot be empty");
            }
        }

        public Manager(string designation = "", string name = "", decimal basic = 0, short deptNo = 0) : base(name, basic,
            deptNo)
        {
            Designation = designation;
        }
    }
}