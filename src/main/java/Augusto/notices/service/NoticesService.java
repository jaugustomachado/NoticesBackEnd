package Augusto.notices.service;


import Augusto.notices.exceptions.NoticeNotFoundException;
import Augusto.notices.model.Notices;
import Augusto.notices.repository.NoticesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class NoticesService {

    private final NoticesRepository noticesRepository;

    @Autowired
    public NoticesService(final NoticesRepository noticesRepository) {
        this.noticesRepository = noticesRepository;
    }

    @Transactional
    public List<Notices> list(final String title) {
        if(title!=null && !title.trim().isEmpty()) {
            return this.noticesRepository.findByTitle(title);
        } else {
            return this.noticesRepository.findAll();
        }
    }

    @Transactional
    public Notices get(final Long id) {
        return this.noticesRepository.findById(id)
                .orElseThrow(() -> new NoticeNotFoundException("Notice not found"));
    }


    @Transactional
    public Notices update(final Long id, final Notices updatedNotice) {
        return this.noticesRepository.findById(id)
                .map(notice -> {
                    notice.setTitle(updatedNotice.getTitle());
                    notice.setDescriptions(updatedNotice.getDescriptions());

                    return this.noticesRepository.save(notice);
                })
                .orElseThrow(() -> new NoticeNotFoundException("Notice not found"));
    }

    @Transactional
    public Notices updatePartially(final Long id){
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return this.noticesRepository.findById(id)
                .map(notice -> {
                    if (notice.getViewing_date()==null) {
                        notice.setViewing_date(sdf.format(date));
                        return this.noticesRepository.save(notice);
                    }
                    return notice;
                })
                .orElseThrow(() -> new NoticeNotFoundException("Notice not found"));
    }

    @Transactional
    public String delete(final Long id) {
        this.noticesRepository.delete(
                this.noticesRepository.findById(id)
                        .orElseThrow(() -> new NoticeNotFoundException("Notice not found")));
        return "Notice Deleted";
    }

    @Transactional
    public String save(final Notices notice) {
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        notice.setPublication_date(sdf.format(date));
        this.noticesRepository.save(notice);
        return "Notice saved";
    }
}
