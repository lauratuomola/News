
package wad.controller;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wad.domain.Category;
import wad.domain.News;
import wad.repository.CategoryRepository;
import wad.repository.NewsRepository;

@Controller
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public String listhome(Model model) {
        PageRequest pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "newsDate");
        model.addAttribute("news", newsRepository.findAll(pageable));
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }

    @GetMapping("/addnews")
    public String list(Model model) {
        model.addAttribute("news", this.newsRepository.findAll());
        model.addAttribute("categories", this.categoryRepository.findAll());
        return "addnews";
    }

    @PostMapping("/addnews")
    public String add(@RequestParam String header, String ingres, String text/*, @PathVariable Long newsId, @PathVariable Long categoryId*/) {
        News newa = new News();
        
        newa.setHeader(header);
        newa.setIngres(ingres);
        newa.setText(text);
        
        this.newsRepository.save(newa);
//        
//        News news = newsRepository.getOne(newsId);
//        Category category = categoryRepository.getOne(categoryId);
//        
//        category.getNews().add(news);
//        news.getCategory().add(category);
        return "redirect:/addnews";
    }
    
     @GetMapping("/addcategory")
    public String category(Model model) {
        
        return "addcategory";
    }
    
    @PostMapping("/addcategory")
    public String addCategory(@RequestParam String categoryName) {
        Category category=new Category();
        category.setCategoryName(categoryName);
        categoryRepository.save(category);
        
        
        return "redirect:/addcategory";
    }
    
//    @GetMapping("/{categoryid}")
//    public String list(Model model, @PathVariable Long categoryid) {
//        Category category=this.categoryRepository.getOne(categoryid);
//        model.addAttribute("category", category);
//        model.addAttribute("news", this.newsRepository.findAll());
//         
//
//        return "category";
//    }
    
    @GetMapping("/{id}")
    public String news(Model model, @PathVariable Long id) {
        News news=this.newsRepository.getOne(id);
        System.out.println(news);
        newsRepository.save(news);
        model.addAttribute("news", news);
        return "news";
    }

}
