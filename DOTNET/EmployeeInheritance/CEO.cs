namespace EmployeeInheritance
{
    public class CEO : Employee
    {
        public CEO(string name = "", decimal basic = 0, short deptNo = 0) : base(name, basic, deptNo)
        { }

        public sealed override decimal CalcNetSalary()
        {
            return base.CalcNetSalary() + (base.CalcNetSalary() * 0.05M);
        }
    }
}