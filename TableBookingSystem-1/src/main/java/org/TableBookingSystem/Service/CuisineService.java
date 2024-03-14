package org.TableBookingSystem.Service;

import java.util.List;
import java.util.Optional;

import org.TableBookingSystem.Repository.CuisineRepository;
import org.TableBookingSystem.model.Cuisine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CuisineService {

    @Autowired
    private CuisineRepository cuisineRepository;

    public List<Cuisine> getAllCuisines() {
        return cuisineRepository.findAll();
    }
    
    public Cuisine addCuisine(Cuisine cuisine) {
        return cuisineRepository.save(cuisine);
    }
    
    public Optional<Cuisine> getCuisineById(Long id) {
        return cuisineRepository.findById(id);
    }
    
    public void updateCuisine(Cuisine cuisine) {
        // Check if the cuisine exists
        if (cuisineRepository.existsById(cuisine.getCuisineId())) {
            cuisineRepository.save(cuisine);
        }
    }
    
    public void deleteCuisine(Long id) {
        cuisineRepository.deleteById(id);
    }
    
    public List<Cuisine> getCuisineByName(String cuisineName) {
        return cuisineRepository.findBycuisineName(cuisineName);
    }
    
    public List<Cuisine> getCuisineByPrice(String cuisineItem) {
        return cuisineRepository.findBycuisineItem(cuisineItem);
    }
}