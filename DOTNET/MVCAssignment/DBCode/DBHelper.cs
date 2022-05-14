using MVCAssignment.Models;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace MVCAssignment.DBCode
{
    public class DBHelper
    {
        private static SqlConnection CreateConnection()
        {
            // Create a New SqlConnection
            SqlConnection connection = new SqlConnection();
            connection.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=UserDatabase;Integrated Security=True;Connect Timeout=30;Encrypt=False;TrustServerCertificate=False;ApplicationIntent=ReadWrite;MultiSubnetFailover=False";

            // Open Connection
            connection.Open();

            return connection;
        }

        public static User GetUserFromDataBase(string username)
        {
            // SQL Command
            SqlCommand command = new SqlCommand()
            {
                Connection = CreateConnection(),
                CommandText = "SELECT * FROM \"User\" WHERE USERNAME = @UserName",
                CommandType = System.Data.CommandType.Text
            };

            // add parameters
            command.Parameters.AddWithValue("@UserName", username);

            // Execute & Return Query
            SqlDataReader dr = command.ExecuteReader(System.Data.CommandBehavior.CloseConnection);

            // Create a user with null
            User user = null;

            // read data
            if (dr.Read())
            {
                user = new User()
                {
                    Username = (string)dr["USERNAME"],
                    Password = (string)dr["PASSWORD"],
                    Email = (string)dr["EMAIL"],
                    Name = (string)dr["NAME"],
                    City = (string)dr["CITY"],
                    PhoneNumber = (string)dr["PHONE"]
                };
            }

            // Close Reader
            dr.Close();

            return user;
        }

        public static void AddUserToDB(User user)
        {
            // SqlCommand Object Creation
            SqlCommand command = new SqlCommand("INSERT_USER", CreateConnection())
            {
                CommandType = System.Data.CommandType.StoredProcedure
            };

            // Parameters for Query
            command.Parameters.AddWithValue("@UserName", user.Username);
            command.Parameters.AddWithValue("@PassWord", user.Password);
            command.Parameters.AddWithValue("@Email", user.Email);
            command.Parameters.AddWithValue("@Name", user.Name);
            command.Parameters.AddWithValue("@City", user.City);
            command.Parameters.AddWithValue("@Phone", user.PhoneNumber);

            // execute the query
            command.ExecuteNonQuery();

            // close the connection
            command.Connection.Close();
        }

        public static void UpdateUser(User user)
        {
            // SqlCommand Object Creation
            SqlCommand command = new SqlCommand("UPDATE_USER", CreateConnection())
            {
                CommandType = System.Data.CommandType.StoredProcedure
            };

            // Parameters for Query
            command.Parameters.AddWithValue("@UserName", user.Username);
            command.Parameters.AddWithValue("@PassWord", user.Password);
            command.Parameters.AddWithValue("@Email", user.Email);
            command.Parameters.AddWithValue("@Name", user.Name);
            command.Parameters.AddWithValue("@City", user.City);
            command.Parameters.AddWithValue("@Phone", user.PhoneNumber);

            // execute the query
            command.ExecuteNonQuery();

            // close the connection
            command.Connection.Close();
        }
    }
}