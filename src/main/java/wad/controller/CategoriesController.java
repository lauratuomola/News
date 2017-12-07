package wad.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Category;
import wad.domain.News;
import wad.repository.CategoriesRepository;

@Controller
public class CategoriesController {

    @Autowired
    private CategoriesRepository categoryRepository;

    @GetMapping("categories")
    public String list(Model model) {
        model.addAttribute("categories", this.categoryRepository.findAll());
        return "categories/list";
    }

    @GetMapping("categories/add")
    public String add(Model model) {
        return "categories/add";
    }

    @PostMapping("categories")
    public String create(@RequestParam String name, boolean inNavBar) {
        Category category = new Category();
        category.setName(name);
        category.setInNavBar(inNavBar);
        categoryRepository.save(category);

        return "redirect:/categories/" + category.getId();
    }

    @GetMapping("categories/{id}")
    public String get(Model model, @PathVariable Long id) {
        Category category = this.categoryRepository.getOne(id);
        model.addAttribute("category", category);
        model.addAttribute("news", category.getNews());

        return "categories/get";
    }

    @DeleteMapping("categories/{id}")
    public String delete(Model model, @PathVariable Long id) {
        Category category = this.categoryRepository.getOne(id);

        category.getNews().forEach((n) -> {
            n.removeCategory(category);
        });
        categoryRepository.deleteById(id);

        return "redirect:/";
    }

}
