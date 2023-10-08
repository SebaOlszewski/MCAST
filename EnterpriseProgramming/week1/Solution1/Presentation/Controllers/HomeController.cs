using Microsoft.AspNetCore.Mvc;
using Presentation.Models;
using System.Diagnostics;

namespace Presentation.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public IActionResult Index()
        {
            return View();
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
        //note : IActionResult is a base calss from whitch all type of result-classes inherit from 
        //      e.g ViewResult, FileResult, JsonResult, ...

        public IActionResult Test()
        {
            //note: by default, MVC will load the View bearing the same name as the action
            //      if you want to load a different view then you have to specity the name of the View
            return View();
        }
    }
}