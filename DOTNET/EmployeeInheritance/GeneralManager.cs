namespace EmployeeInheritance
{
    public class GeneralManager : Manager
    {
        public string Perks { get; set; }

        public GeneralManager(string designation, string name = "", decimal basic = 0, short deptNo = 0, string perks = "") : base(designation, name, basic, deptNo)
        {
            Perks = perks;
        }
    }
}