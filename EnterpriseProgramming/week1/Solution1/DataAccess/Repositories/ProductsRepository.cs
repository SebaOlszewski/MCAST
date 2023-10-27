using DataAccess.DataContext;
using Domain.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataAccess.Repositories
{
    //Dependency Injection - design pattern that manages the creation of instances 
    public class ProductsRepository
    {
        private ShoppingCartContext _shoppingCartContext;

        //constructor
        public ProductsRepository(ShoppingCartContext shoppingCartContext)
        {
            _shoppingCartContext = shoppingCartContext;
        }



        //what is the difference between IQueryable and List
        //1. (Drawback) in IQueryrable you cannot debuug. You can do that in the List
        //2. (Advantage) IQueryable never opens a call to the database until you convert ir into a List

        /*  
            Example
         
            GetProducts().Where(x=>x.Name.Containst(variable).Skip(5).Take(10).OrderBy(x=>.Name);
            myCommand.ToList();//
            IQueryable is more efficient than he list, the list would connecto to the SQL server multiple times,
            IQUeryable will do it less times
        */
        //methods
        public IQueryable<Product> GetProducts()
        { 
            return _shoppingCartContext.Products; //the list of products is not retrieved until you call ToList()
        }

        public Product? GetProduct(Guid id)
        {
            return _shoppingCartContext.Products.SingleOrDefault(x => x.Id==id);
        }


        public void AddProduct(Product product)
        { 
            
            _shoppingCartContext.Products.Add(product);
            _shoppingCartContext.SaveChanges(); //this commits to the database
        }


        public void UpdateProduct(Product product)
        {
        
        }

        public void DeleteProduct(Guid id) { }
               

    }
}
