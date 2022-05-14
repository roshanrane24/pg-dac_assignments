using System;

namespace Exception
{
    public abstract class Employee : IDbFunctions
    {
        private static int _id;
        private string _name;
        private short _deptNo;
        private protected decimal _basic;

        #region Properties

        public string Name
        {
            get => this._name;
            set
            {
                if (!string.IsNullOrEmpty(value))
                    this._name = value;
                else
                    throw new InvalidNameException("Name Cannot be empty");
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
                    throw new InvalidDeptException("Department Number must be greater than 0");
            }
        }

        #endregion

        protected Employee(string name, decimal basic, short deptNo)
        {
            this.Name = name;
            this.Basic = basic;
            this.DeptNo = deptNo;
            this.EmpNo = _id++;
        }

        static Employee()
        {
            Employee._id = 1;
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

    #region Exceptions

    class InvalidNameException : System.Exception
    {
        public InvalidNameException(string msg = "") : base(msg)
        {
        }
    }

    class InvalidBasicException : System.Exception
    {
        public InvalidBasicException(string msg = "") : base(msg)
        {
        }
    }

    class InvalidDeptException : System.Exception
    {
        public InvalidDeptException(string msg = "") : base(msg)
        {
        }
    }
}

#endregion