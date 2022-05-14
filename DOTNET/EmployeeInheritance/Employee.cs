using System;

namespace EmployeeInheritance
{
    public class Employee
    {
        private static int _id;
        private string _name = null;
        private decimal _basic;
        private short _deptNo;

        public string Name
        {
            get { return this._name; }
            set
            {
                if (value.Length > 0)
                    this._name = value;
                else
                    Console.WriteLine("Name cannot be empty");
            }
        }

        public int EmpNo { get; }

        public decimal Basic
        {
            get { return _basic; }
            set
            {
                if (value > 180000 && value < 250000)
                    this._basic = value;
                else
                    Console.WriteLine("Basic must be within 180000 - 250000");
            }
        }

        public short DeptNo
        {
            get => _deptNo;
            set
            {
                if (value > 0)
                    this._deptNo = value;
                else
                    Console.WriteLine("Department Number must be greater than 0");
            }
        }

        public Employee(string name = "", decimal basic = 0, short deptNo = 0)
        {
            this.EmpNo = _id++;
            this.Name = name;
            this.Basic = basic;
            this.DeptNo = deptNo;
        }

        static Employee()
        {
            _id = 1;
        }

        public virtual decimal CalcNetSalary()
        {
            return (Basic - Basic * 0.18M) + ((Basic - Basic * 0.18M) * 0.1M);
        }
    }
}