package wad.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@AllArgsConstructor
@Data
public class News extends AbstractPersistable<Long>{
    private String header;
    private String ingres;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    @Column(name="TEXT", length = 5000)
    private String text;
    
    @ManyToMany
    private List<Category> categories;
    
     @Lob
    private byte[] content;
    
    public News() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        
        this.categories = new ArrayList<>();
    }

     public void addCategory(Category category) {
       this.categories.add(category);
    }
     
     public void removeCategory(Category category) {
       this.categories.remove(category);
    }
    
}
