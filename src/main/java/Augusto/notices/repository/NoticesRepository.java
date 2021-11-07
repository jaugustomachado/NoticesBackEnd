package Augusto.notices.repository;

import Augusto.notices.model.Notices;
import Augusto.notices.repository.Interface.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@org.springframework.stereotype.Repository
public interface NoticesRepository extends Repository<Notices> {

    @Query("SELECT t FROM Notices t WHERE t.title LIKE %?1%")
    List<Notices> findByTitle(String title);

}
