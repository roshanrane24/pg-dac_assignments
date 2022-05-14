using System;

namespace EmployeeInheritance2
{
    public class Manager : Employee
    {
        private string _designation;

        public string Designation
        {
            get => _designation;
            set
            {
                if (!string.IsNullOrEmpty(value))
                    _designation = value;
                else
                    Console.WriteLine("Designation cannot be empty");
            }
        }

        public override decimal Basic
        {
            get => _basic;
            set
            {
                if (value > 25000 && value < 50000)
                    _basic = value;
                else
                    Console.WriteLine("Basic must be between 25000 & 50000");
            }
        }

        public Manager(string designation = "", string name = "", decimal basic = 0, short deptNo = 0) : base(name, basic, deptNo)
        {
            Designation = designation;
        }

        public override decimal CalcNetSalary()
        {
            return Basic * 0.85m;
        }

        public override string ToString()
        {
            return $@"{base.ToString()}
Designation : {this.Designation}";
        }
    }
}