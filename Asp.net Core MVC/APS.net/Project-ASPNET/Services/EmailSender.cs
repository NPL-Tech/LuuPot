using Microsoft.AspNetCore.Identity.UI.Services;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Options;
using SendGrid;
using SendGrid.Helpers.Mail;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Text;
using System.Threading.Tasks;

namespace ProjectDotNetV2.Services
{
    public class EmailSender : IEmailSender
    {
        private string host;
        private string alias;
        private string from;
        public EmailSender(IConfiguration configuration)
        {
            var smtpSection = configuration.GetSection("SMTP");
            if(smtpSection != null)
            {
                host = smtpSection.GetSection("Host").Value;
                from = smtpSection.GetSection("From").Value;
                alias = smtpSection.GetSection("Alias").Value;
            }
        }

        public async Task SendEmailAsync(string email, string subject, string message)
        {
            try
            {
                using (SmtpClient client = new SmtpClient(host))
                {
                    MailMessage mailMessage = new MailMessage();
                    mailMessage.From = new MailAddress(from, alias);
                    mailMessage.BodyEncoding = Encoding.UTF8;
                    mailMessage.To.Add(email);
                    mailMessage.Body = message;
                    mailMessage.Subject = subject;
                    mailMessage.IsBodyHtml = true;
                    client.Credentials = new NetworkCredential(email, "kingdemon");
                    //client.UseDefaultCredentials = false;

                    client.EnableSsl = true;
                    client.Send(mailMessage);
                }
            }
            catch
            {
                throw;
            }


        } 
    }
}
