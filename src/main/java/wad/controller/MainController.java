package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wad.repository.NewsRepository;
import wad.repository.CategoriesRepository;

@Controller
public class MainController {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private CategoriesRepository categoryRepository;

    @GetMapping("/")
    public String index(Model model) {
        PageRequest pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "createdAt");
        model.addAttribute("news", newsRepository.findAll(pageable));
        model.addAttribute("categories", categoryRepository.findAll());

        return "main/index";
    }
}
