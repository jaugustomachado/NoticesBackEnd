package Augusto.notices.model.Abstract;


import Augusto.notices.model.Interface.NoticesEntity;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public class AbstractNotices implements NoticesEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "descriptions", nullable = false, length = 200)
    private String descriptions;

    @Column(name = "publication_date")
    private String publication_date;

    @Column(name = "viewing_date")
    private String viewing_date;

    protected AbstractNotices() {
        super();
    }

    protected AbstractNotices(final String title) {
        super();
        this.title = title;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDescriptions() {
        return descriptions;
    }

    @Override
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String getPublication_date() {
        return publication_date;
    }

    @Override
    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    @Override
    public String getViewing_date() {
        return viewing_date;
    }

    @Override
    public void setViewing_date(String viewing_date) {
        this.viewing_date = viewing_date;
    }


    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (!(this.getClass().equals(object.getClass()))) {
            return false;
        }

        return Objects.equals(this.getId(), ((AbstractNotices) object).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }



}
