package Grocery.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import Grocery.Entity.GroceryItems;
import Grocery.Service.GroceryService;
@RestController
public class GroceryResource 
{
	@Autowired
	private GroceryService groceryService;
	 @GetMapping("/getgroceries")
	   public ResponseEntity<List<GroceryItems>> getAccounts()
	   {
		   try 
		   {
			   List<GroceryItems> items=groceryService.getAllGroceries();
			   return new ResponseEntity<List<GroceryItems>>(items,HttpStatus.FOUND);
		   }
		   catch(Exception e)
		   {
			   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	       }
		 
	   }
	   @GetMapping("/getgroceries/{groceryId}")
	   public ResponseEntity<GroceryItems> getGroceryById(@PathVariable(value="groceryId") String groceryId)
	   {
		   try
		   {
			   GroceryItems items1=groceryService.getGroceryById(groceryId);
		      return new ResponseEntity<GroceryItems>(items1,HttpStatus.FOUND);
		   }
		   catch(Exception e)
		   {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);   
		   }
	   }
	
	   
	   @PostMapping("/addgrocery")
	   public ResponseEntity<GroceryItems> addGrocery(@RequestBody GroceryItems items)
	   {
		   try
		   {
			   GroceryItems items1=groceryService.addGrocery(items);
			  return new ResponseEntity<GroceryItems>(items1,HttpStatus.CREATED);
		   }
		   catch(Exception e)
		   {
			  return new ResponseEntity<>(HttpStatus.CONFLICT);
		   }
		  
	   }
	   @PutMapping("/updategrocery/{GroceryId}")
	   public ResponseEntity<GroceryItems> updateGrocery(@RequestBody GroceryItems items)
	   {
		   try
		   {
		   
		       GroceryItems updated_items=groceryService.updateGrocery(items);
		       return new ResponseEntity<GroceryItems>(updated_items,HttpStatus.OK);
		   
		   }
		   catch(Exception e)
		   {
			   return new ResponseEntity<>(HttpStatus.CONFLICT);
		   }
		   
	   }

	   @DeleteMapping("/deletegroceries/{GroceryId}")
	   public ResponseEntity<GroceryItems> deleteGrocery(@PathVariable(value="GroceryId")String GroceryId)
	   {
		   GroceryItems items=null;
		try
		{
			items=groceryService.getGroceryById(GroceryId);
			groceryService.deleteGrocery(items);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<GroceryItems>(items,HttpStatus.OK);
	   
	}
	   
}
