using System;

namespace EmployeeInheritance2
{
    // ReSharper disable once InconsistentNaming
    public sealed class CEO : Employee
    {
        public override decimal Basic
        {
            get => this._basic;
            set
            {
                if (value > 60000 && value < 80000)
                    _basic = value;
                else
                    Console.WriteLine("Basic must be between 60000 & 80000");
            }

        }

        public CEO(string name = "", decimal basic = 0, short deptNo = 0) : base(name, basic, deptNo)
        {
            this.Basic = basic;
        }

        public sealed override decimal CalcNetSalary()
        {
            return this.Basic * 0.75M;
        }
    }
}