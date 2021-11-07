package Augusto.notices.model.Interface;

import java.io.Serializable;
import java.util.Date;

public interface NoticesEntity extends Serializable {


    Long getId();

    void setId(Long id);

    String getTitle();

    void setTitle(String title);

    String getDescriptions();

    void setDescriptions(String descriptions);

    String getPublication_date();

    void setPublication_date(String publication_date);

    String getViewing_date();

    void setViewing_date(String viewing_date);
}
