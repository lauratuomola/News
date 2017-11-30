package wad.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
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

    private String categoryName;
    @ManyToMany(mappedBy = "categories")
    private List<News> news;

    public List<News> getNews() {
        if (this.news == null) {
            this.news = new ArrayList<>();
        }

        return this.news;
    }

    public void addNews(News news) {
        this.news.add(news);
    }
}
