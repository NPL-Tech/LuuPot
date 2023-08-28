using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProjectDotNetV2.Data.Entities
{
    public class Bill
    {
        public int BillId { get; set; }
        public string NameOrder { get; set; }
        public string Receiver { get; set; }

        public DateTime DatePayment { get; set; }
        public double price { get; set; }
        public Transport Transport { get; set; }
    }
}
