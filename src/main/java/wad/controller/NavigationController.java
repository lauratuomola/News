package wad.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wad.domain.Category;
import wad.repository.CategoriesRepository;

@Controller
public class NavigationController {

    @Autowired
    private CategoriesRepository categoryRepository;    
    
    @GetMapping("navigation")
    public String index(Model model) {
        
        List<Category> categories = new ArrayList<>();

        categoryRepository
                .findAll()
                .stream()
                .filter((c) -> (c.isInNavBar()))
                .forEach((c) -> {
            categories.add(c);
        });
        
        model.addAttribute("categories", categories);
        return "navigation/index";
    }
    
}
