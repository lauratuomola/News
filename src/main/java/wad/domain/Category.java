package wad.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Category extends AbstractPersistable<Long> {
    private String name;
    private boolean inNavBar;
    
    @ManyToMany(mappedBy = "categories")
    private List<News> news;

    public void addNews(News news) {
        this.news.add(news);
    }

}
