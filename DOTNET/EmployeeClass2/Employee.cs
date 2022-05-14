using System;

namespace EmployeeClass2
{
    public class Employee
    {
        #region DataMembers
        private static int _id;
        private string _name = null;
        private int _empNo;
        private decimal _basic;
        private short _deptNo;
        #endregion

        #region Properties
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

        public int EmpNo
        {
            get { return this._empNo; }
            set
            {
                if (value > 0)
                    this._empNo = value;
                else
                    Console.WriteLine("Employee number must be more than 0");
            }
        }

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
            get { return _deptNo; }
            set
            {
                if (value > 0)
                    this._deptNo = value;
                else
                    Console.WriteLine("Department Number must be greater than 0");
            }
        }
        #endregion

        #region Constructor
        public Employee(string name = "", decimal basic = 0, short deptNo = 0)
        {
            this._empNo = _id++;
            this.Name = name;
            this.Basic = basic;
            this.DeptNo = deptNo;
        }

        static Employee()
        {
            _id = 1;
        }
        #endregion

        public decimal GetNetSalary()
        {
            return (Basic - Basic * 0.18M) + ((Basic - Basic * 0.18M) * 0.1M);
        }

        public override string ToString()
        {
            return $"{nameof(Name)}: {Name}, {nameof(EmpNo)}: {EmpNo}, {nameof(Basic)}: {Basic}, {nameof(DeptNo)}: {DeptNo}";
        }
    }
}