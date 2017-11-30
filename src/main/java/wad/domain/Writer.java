
package wad.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Writer {
    @Id
    private String writerName;

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }
    
}
