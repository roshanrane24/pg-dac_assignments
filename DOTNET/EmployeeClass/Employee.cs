using System;

namespace EmployeeClass
{
    public class Employee
    {
        #region DataMembers
        string _name = "";
        int _empNo;
        decimal _basic;
        short _deptNo;
        #endregion

        #region Properties
        public string Name
        {
            get { return _name; }
            set
            {
                if (value.Length > 0)
                    _name = value;
                else
                    Console.WriteLine("Name cannot be empty");
            }
        }

        public int EmpNo
        {
            get { return _empNo; }
            set
            {
                if (value > 0)
                    _empNo = value;
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
                    _basic = value;
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
                    _deptNo = value;
                else
                    Console.WriteLine("Department Number must be greater than 0");
            }
        }
        #endregion

        public Employee(int empNo = 0, string name = "", decimal basic = 0, short deptNo = 0)
        {
            Name = name;
            EmpNo = empNo;
            Basic = basic;
            DeptNo = deptNo;
        }

        public decimal GetNetSalary()
        {
            return (Basic - Basic * 0.18M) + ((Basic - Basic * 0.18M) * 0.1M);
        }
    }
}