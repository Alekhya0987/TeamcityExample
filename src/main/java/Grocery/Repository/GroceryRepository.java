package Grocery.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import Grocery.Entity.GroceryItems;

public interface GroceryRepository extends MongoRepository<GroceryItems, String>
{

	
}