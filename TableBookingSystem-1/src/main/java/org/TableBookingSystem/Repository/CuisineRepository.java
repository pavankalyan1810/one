package org.TableBookingSystem.Repository;

import java.util.List;

import org.TableBookingSystem.model.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Long> {

	List<Cuisine> findBycuisineName(String cuisineName);

	List<Cuisine> findBycuisineItem(String cuisineItem);
	

	List<Cuisine> findBycuisineId(Long cuisineId);
	

	


	
}