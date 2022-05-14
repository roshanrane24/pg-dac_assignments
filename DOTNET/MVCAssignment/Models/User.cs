using System.ComponentModel.DataAnnotations;

namespace MVCAssignment.Models
{
    public class User
    {
        [Key]
        public string Username { get; set; }

        [StringLength(20, ErrorMessage = "Password must be between 8 to 20 characters.", MinimumLength = 8)]
        [DataType(DataType.Password)]
        [Required(ErrorMessage = "Please Enter password")]
        public string Password { get; set; }

        [Compare("Password", ErrorMessage = "Password Does Not match")]
        public string ConfirmPassword { get; set; }

        [EmailAddress]
        public string Email { get; set; }

        [DataType(DataType.Text)]
        [StringLength(60, ErrorMessage = "Name cannot be more than 60 characters")]
        [Required(ErrorMessage = "Please enter name")]
        public string Name { get; set; }

        [DataType(DataType.Text)]
        public string City { get; set; }

        [DataType(DataType.PhoneNumber)]
        [StringLength(10, ErrorMessage = "Invalid Phone Number", MinimumLength = 10)]
        public string PhoneNumber { get; set; }
    }
}