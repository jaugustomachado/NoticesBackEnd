package Augusto.notices.repository.Interface;

import Augusto.notices.model.Abstract.AbstractNotices;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository<T extends AbstractNotices> extends JpaRepository<T, Long> {

}
