using System;

namespace EmployeeCollection1
{
    public class Employee
    {
        private static int _id;
        private string _name = null;
        private int _empNo;
        private decimal _basic;
        private short _deptNo;

        public string Name
        {
            get => this._name;
            set
            {
                if (!string.IsNullOrWhiteSpace(value))
                    this._name = value;
                else
                    throw new Exception("Name can't be empty.");
            }
        }

        public int EmpNo
        {
            get => this._empNo;
            set
            {
                if (value > 0)
                    this._empNo = value;
                else
                    throw new Exception("Employee number must be more than 0");
            }
        }

        public decimal Basic
        {
            get => _basic;
            set
            {
                if (value >= 180000 && value <= 250000)
                    this._basic = value;
                else
                    throw new Exception("Basic must be within 180000 - 250000");
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
                    throw new Exception("Department Number must be greater than 0");
            }
        }

        static Employee()
        {
            Employee._id = 1;
        }

        public Employee(string name = "", decimal basic = 0, short deptNo = 0)
        {
            this.Name = name;
            this.EmpNo = _id++;
            this.Basic = basic;
            this.DeptNo = deptNo;
        }

        public decimal GetNetSalary()
        {
            return Basic * 0.82M;
        }

        public override string ToString()
        {
            return $@"No {EmpNo}: 
Name : {Name}
Dept NO : {DeptNo}
Basic : {Basic}";
        }
    }
}