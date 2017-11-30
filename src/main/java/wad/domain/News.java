
package wad.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity

@AllArgsConstructor
@Data
public class News extends AbstractPersistable<Long>{
    private String header;
    private String ingres;
    private LocalDate newsDate;
    private String text;
    
      @ManyToMany
    private List<Category> categories;
    
    public News() {
        this.newsDate = LocalDate.now();
    }
     public List<Category> getCategory() {
        if (this.categories== null) {
            this.categories = new ArrayList<>();
        }

        return this.categories;
    }
        public void addQuestion(Category category) {
       this.categories.add(category);
    }
    
    
    
}
