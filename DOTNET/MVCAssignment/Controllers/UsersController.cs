using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Data.SqlClient;
using MVCAssignment.Models;
using static MVCAssignment.DBCode.DBHelper;

namespace MVCAssignment.Controllers
{
    public class UsersController : Controller
    {

        #region UserHome
        public ActionResult Home()
        {
            // Create empty user object
            User user = null;

            try
            {
                if (Session["loggedInUser"] == null)
                {
                    // no session for a user
                    HttpCookie cookie = Request.Cookies["loggedInUser"];

                    string username = string.Empty;

                    if (cookie != null)
                    {
                        username = cookie["username"].ToString();
                    }

                    // When cookie empty
                    if (string.IsNullOrWhiteSpace(username))
                    {
                        return RedirectToAction("Login");
                    }

                    // Get User details
                    user = GetUserFromDataBase(username);

                    // user not found which was saver in cookie
                    if (user == null)
                    {
                        return RedirectToAction("Login");
                    }
                }
                else
                {
                    // Get user from session
                    user = (User)Session["loggedInUser"];
                }
            }
            catch (Exception ex)
            {
                ViewBag.ErrorMessag = ex.Message;
            }

            return View(user);
        }
        #endregion

        #region Registration

        // GET: Users/Register
        public ActionResult Register()
        {
            return View();
        }

        // POST: Users/Register
        [HttpPost]
        public ActionResult Register(User user)
        {
            try
            {
                // check if user exist
                if (GetUserFromDataBase(user.Username) != null)
                {
                    ViewBag.ErrorMessage = "User already exist.";
                    return View();
                }

                // Add a user to database
                AddUserToDB(user);

                // Write a message for successful registration
                TempData["Message"] = "Registartion Successful";

                return RedirectToAction("Login");
            }
            catch
            {
                ViewBag.ErrorMessage = "Registration Failed";
                return View();
            }
        }
        #endregion

        #region Login
        // GET: Users/Login
        public ActionResult Login()
        {
            return View();
        }

        [HttpPost]
        // Post: Users/Login
        public ActionResult Login(string Username, string Password, bool persist)
        {
            try
            {
                // Create a user
                User user = GetUserFromDataBase(Username);

                #region ErrorMessages
                // User not exist
                if (user == null)
                {
                    ViewBag.ErrorMessage = "User does not exist.";
                    return View();
                }

                // Password Does not match
                if (user.Password != Password)
                {
                    ViewBag.ErrorMessage = "Username & Password does not match";
                    return View();
                }
                #endregion

                if (persist)
                {
                    // Create a seesion for user
                    Session["loggedInUser"] = user;
                }
                else
                {
                    // Create a cookie for user for 5 min
                    HttpCookie cookie = new HttpCookie("loggedInUser");
                    cookie.Expires = DateTime.Now.AddSeconds(40);

                    cookie["username"] = user.Username;

                    Response.Cookies.Add(cookie);
                }

                return RedirectToAction("Home");

            }
            catch (Exception ex)
            {
                ViewBag.ErrorMessage = ex.Message;
            }

            return View();
        }

        #endregion

        #region UpdateUser
        // GET: User/Edit/5
        public ActionResult Update()
        {
            User user = null;

            try
            {
                if (Session["loggedInUser"] == null)
                {
                    // no session for a user
                    HttpCookie cookie = Request.Cookies["loggedInUser"];

                    string username = string.Empty;

                    if (cookie != null)
                    {
                        username = cookie["username"].ToString();
                    }

                    // When cookie empty
                    if (string.IsNullOrWhiteSpace(username))
                    {
                        return RedirectToAction("Login");
                    }

                    // Get User details
                    user = GetUserFromDataBase(username);

                    // user not found which was saver in cookie
                    if (user == null)
                    {
                        return RedirectToAction("Login");
                    }
                }
                else
                {
                    // Get user from session
                    user = (User)Session["loggedInUser"];
                }

                return View(user);
            }
            catch (Exception ex)
            {
                ViewBag.Error = ex.Message;
                return RedirectToAction("Home");
            }

        }

        // POST: User/Edit/5
        [HttpPost]
        public ActionResult Update(User user)
        {
            try
            {
                // TODO: Add update logic here
                UpdateUser(user);

                return RedirectToAction("Home");
            }
            catch (Exception ex)
            {
                ViewBag.ErrorMessage = ex.Message;
                return View(user);
            }
        }
        #endregion

        // Log Out
        public ActionResult Logout()
        {
            // Delete session
            Session.Abandon();
            Session.Clear();

            // Delete User Cookie
            Request.Cookies["loggedInUser"].Expires = DateTime.Now.AddDays(-1);

            TempData["Message"] = "User has been succesfully logged out";

            return RedirectToAction("Login");
        }

    }
}
