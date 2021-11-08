package Augusto.notices.controller;

import Augusto.notices.model.Notices;
import Augusto.notices.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping({ "/notices" })
public class NoticesController {

    private final NoticesService noticesService;

    @Autowired
    public NoticesController(final NoticesService noticesService) {
        this.noticesService = noticesService;
    }

    @CrossOrigin(origins = {"http://localhost:4200"})
    @GetMapping({ "", "/" })
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Notices> list(@RequestParam(required = false) final String title) {
        return this.noticesService.list(title);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping({ "/{id}", "/{id}/"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Notices get(@PathVariable(value="id") final Long id) {
        return this.noticesService.get(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping({ "/{id}", "/{id}/"})
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable(value="id") final Long id) {
        return this.noticesService.delete(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping({ "", "/" })
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String save(@RequestBody final Notices notice){
        return this.noticesService.save(notice);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping({ "/{id}", "/{id}/"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Notices update(@PathVariable(value="id") final Long id, @RequestBody final Notices notice) {
        return this.noticesService.update(id, notice);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PatchMapping({ "/{id}", "/{id}/"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Notices updatePartially(@PathVariable(value="id") final Long id){
        return this.noticesService.updatePartially(id);
    }





}
