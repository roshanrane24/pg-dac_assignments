using System;

namespace EmployeeInheritance
{
    static class Program
    {
        static void Main()
        {
            Employee emp = new Employee("Roshan", 210000, 10);
            PrintEmployee(emp);
            Manager mgr = new Manager("Deputy", "MGR1", 220000, 10);
            PrintEmployee(mgr);
            GeneralManager gMgr = new GeneralManager("Team", "MGR2", 239999, 20);
            PrintEmployee(gMgr);
            GeneralManager gMgr1 = new GeneralManager("Team", "MGR3", 239999, 10, "Perk1");
            PrintEmployee(gMgr1);
            Manager mgr1 = new GeneralManager("Sales", "MGR4", 239999, 10);
            PrintEmployee(mgr1);
            CEO ceo = new CEO("Boss", 249999, 1);
            PrintEmployee(ceo);
        }

        private static void PrintEmployee(Employee emp)
        {
            Console.WriteLine($@"EmpNO : {emp.EmpNo}
Name : {emp.Name}
Salary : {emp.Basic}
Dept No : {emp.DeptNo}");
            if (emp.GetType() == typeof(Manager))
                Console.WriteLine($@"Desiganation : {((Manager)emp).Designation}");

            if (emp.GetType() == typeof(GeneralManager))
                if (((GeneralManager)emp).Perks.Length > 0)
                    Console.WriteLine($@"Perks : {((GeneralManager)emp).Perks}");
        }
    }
}