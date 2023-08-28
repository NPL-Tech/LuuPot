using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProjectDotNetV2.Data.Entities
{
    public class Transport
    {
        public int TransportId { get; set; }
        public string CodeT { get; set; }
        public DateTime DateTransport { get; set; }
        public DateTime DateTransportTake { get; set; }

        public string Note { get; set; }
        [JsonProperty("Order")]
        public Order Order { get; set; }
    }
}
