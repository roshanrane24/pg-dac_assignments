namespace Exception
{
    public class GeneralManager : Manager
    {
        public string Perks { get; set; }
        public override decimal Basic
        {
            get => base.Basic;
            set
            {
                if (value > 40000 && value < 60000)
                    _basic = value;
                else
                    throw new InvalidBasicException("Basic must be between 40000 & 60000");
            }
        }

        public GeneralManager(string designation, string name = "", decimal basic = 0, short deptNo = 0, string perks = "") : base(designation, name, basic, deptNo)
        {
            this.Perks = perks;
        }

        public override decimal CalcNetSalary()
        {
            return base.CalcNetSalary() * 0.95m;
        }

        public override string ToString()
        {
            return $@"{base.ToString()}
Perks : {this.Perks}";
        }
    }
}