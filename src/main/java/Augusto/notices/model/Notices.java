package Augusto.notices.model;


import Augusto.notices.model.Abstract.AbstractNotices;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.text.SimpleDateFormat;

@Entity
@Table(schema = "notices_database", name = "notices", uniqueConstraints =  { @UniqueConstraint(name = "uk_title", columnNames = "title") })

public class Notices extends AbstractNotices {

    public Notices() {
        super();
    }

    public String toStringUpdatePartially() {
        return String.format("{ %s id=%d, title='%s', descriptions='%s', publication_date='%s',viewing_date='%s' }",
                super.toString(),
                super.getId(),
                this.getTitle(),
                this.getDescriptions(),
                new SimpleDateFormat("yyyy-MM-dd").format(this.getPublication_date()),
                new SimpleDateFormat("yyyy-MM-dd").format(this.getViewing_date())
        );
    }

    @Override
    public String toString() {
        return String.format("{%s title='%s'}",
                super.toString(),
                this.getTitle()
        );
    }

}
