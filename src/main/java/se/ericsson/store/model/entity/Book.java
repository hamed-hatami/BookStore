package se.ericsson.store.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Book_SEQ")
    @SequenceGenerator(name = "Book_SEQ", sequenceName = "Book_SEQ", allocationSize = 1)
    @Column(name = "id")
    private long id;

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
