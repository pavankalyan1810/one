package org.TableBookingSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.TableBookingSystem.Service.CuisineService;
import org.TableBookingSystem.model.Cuisine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//
//@RestController
//@RequestMapping("/api/cuisines")
//public class CuisineController {
//
//	@Autowired
//    private CuisineService cuisineService;
//	
//
//    @GetMapping
//    public List<Cuisine> getAllCuisines() {
//        return cuisineService.getAllCuisines();
//        
//    }
//    @GetMapping("/{id}")
//    public Optional<Cuisine> getCuisineById(@PathVariable Long cuisineId) {
//        return cuisineService.getCuisineById(cuisineId);
//    }
//    
//    @PostMapping
//    public Cuisine addCuisine(@RequestBody Cuisine cuisine) {
//        return cuisineService.addCuisine(cuisine);
//    }
//    
//}


@Controller
@RequestMapping("/cuisines")
public class CuisineController {

    @Autowired
    private CuisineService cuisineService;

    @GetMapping
    public String getAllCuisines(Model model) {
        List<Cuisine> cuisines = cuisineService.getAllCuisines();
        model.addAttribute("cuisines", cuisines);
        return "cuisineList"; // HTML view name
    }

    @GetMapping("/{id}")
    public String getCuisineById(@PathVariable Long id, Model model) {
        Optional<Cuisine> cuisine = cuisineService.getCuisineById(id);
        if (cuisine.isPresent()) {
            model.addAttribute("cuisine", cuisine.get());
            return "cuisineDetails"; // HTML view name for displaying single cuisine details
        } else {
            // Handle case where cuisine with given ID is not found
            return "error"; // HTML view name for error page
        }
    }

    @PostMapping
    public String addCuisine(Cuisine cuisine) {
        cuisineService.addCuisine(cuisine);
        return "redirect:/cuisines"; // Redirect to the list of all cuisines
    }
    
    
    @PostMapping("/{id}/update")
    public String updateCuisine(@PathVariable Long id, Cuisine cuisine) {
        cuisine.setCuisineId(id); // Ensure the correct ID is set for update
        cuisineService.updateCuisine(cuisine);
        return "redirect:/cuisines"; // Redirect to the list of all cuisines
    }

    @PostMapping("/{id}/delete")
    public String deleteCuisine(@PathVariable Long id) {
        cuisineService.deleteCuisine(id);
        return "redirect:/cuisines"; // Redirect to the list of all cuisines
    }
}