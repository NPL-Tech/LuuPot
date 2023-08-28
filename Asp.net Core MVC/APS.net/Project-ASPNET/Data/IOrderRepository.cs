using ProjectDotNetV2.Data.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectDotNetV2.Data
{
    public interface IOrderRepository
    {
        void CreateOrder(Order order);
    }
}
