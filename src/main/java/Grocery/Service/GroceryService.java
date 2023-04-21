package Grocery.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Grocery.Entity.GroceryItems;
import Grocery.Repository.GroceryRepository;
@Service
public class GroceryService 
{
	@Autowired
	private GroceryRepository groceryRepo;
	
	public List<GroceryItems> getAllGroceries()
	{
		List<GroceryItems> items=groceryRepo.findAll();
		return items;
	}
	public GroceryItems getGroceryById(String groceryId)
	{
		return groceryRepo.findById(groceryId).get();
	}
	
	public GroceryItems addGrocery(GroceryItems items)
	{
		return groceryRepo.save(items);
	}
	public GroceryItems updateGrocery(GroceryItems groceryitems)
	{
		   GroceryItems existingitem=groceryRepo.findById(groceryitems.getGroceryId()).get();
	       existingitem.setGroceryName(groceryitems.getGroceryName());
	       existingitem.setQuantity(groceryitems.getQuantity());
	       existingitem.setCategory(groceryitems.getCategory());
	       return groceryRepo.save(existingitem);
	}
	
	public void deleteGrocery(GroceryItems groceryitems)
	{
		
		groceryRepo.delete(groceryitems);
	}
	
}
