package Grocery.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "grocery_items")
public class GroceryItems 
{
    @Id
	private String groceryId;
	
	private String groceryName;
	
	private int quantity;
	
	private String category;

	public String getGroceryId() {
		return groceryId;
	}

	public void setGroceryId(String groceryId) {
		this.groceryId = groceryId;
	}

	public String getGroceryName() {
		return groceryName;
	}

	public void setGroceryName(String groceryName) {
		this.groceryName = groceryName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public GroceryItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroceryItems(String groceryId, String groceryName, int quantity, String category) {
		super();
		this.groceryId = groceryId;
		this.groceryName = groceryName;
		this.quantity = quantity;
		this.category = category;
	}

	
	 
}
