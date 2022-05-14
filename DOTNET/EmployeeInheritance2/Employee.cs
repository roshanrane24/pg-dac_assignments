using System;

namespace EmployeeInheritance2
{
    public abstract class Employee : IDbFunctions
    {
        private static int _id;
        private string _name;
        private short _deptNo;
        private protected decimal _basic;

        public string Name
        {
            get => this._name;
            set
            {
                if (!string.IsNullOrEmpty(value))
                    this._name = value;
                else
                    Console.WriteLine("Name cannot be empty");
            }
        }

        public int EmpNo { get; }

        public abstract decimal Basic { get; set; }

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

        protected Employee(string name, decimal basic, short deptNo)
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

        public abstract decimal CalcNetSalary();

        public override string ToString()
        {
            return $@"EmpNo : {this.EmpNo}
Name : {this.Name}
Dept No : {this.DeptNo}
Basic : {this.Basic}";
        }

        public void Insert()
        {
            Console.WriteLine("Employee -> Insert");
        }

        public void Update()
        {
            Console.WriteLine("Employee -> Update");
        }

        public void Delete()
        {
            Console.WriteLine("Employee -> Delete");
        }
    }
}