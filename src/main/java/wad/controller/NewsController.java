package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wad.domain.News;
import wad.repository.NewsRepository;
import wad.repository.CategoriesRepository;

@Controller
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private CategoriesRepository categoryRepository;

    @GetMapping("news/add")
    public String add(Model model) {
        model.addAttribute("news", this.newsRepository.findAll());
        model.addAttribute("categories", this.categoryRepository.findAll());
        return "news/add";
    }

    @PostMapping("news")
    public String create(@RequestParam String header, @RequestParam String ingres, @RequestParam String text, @RequestParam Long categoryId) {
        News news = new News();

        news.setHeader(header);
        news.setIngres(ingres);
        news.setText(text);
        news.addCategory(categoryRepository.getOne(categoryId));
        
        this.newsRepository.save(news);

        return "redirect:/news/" + news.getId();
    }

    @GetMapping("news/{id}")
    public String get(Model model, @PathVariable Long id) {
        News news = this.newsRepository.getOne(id);
        model.addAttribute("news", news);
        model.addAttribute("timestamp", news.getCreatedAt().toLocalDate().toString());

        return "news/get";
    }

    @DeleteMapping("news/{id}")
    public String delete(Model model, @PathVariable Long id) {
        newsRepository.deleteById(id);
        return "redirect:/";
    }

}
