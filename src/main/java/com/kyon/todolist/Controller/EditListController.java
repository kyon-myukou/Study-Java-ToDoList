package com.kyon.todolist.Controller;

import com.kyon.todolist.Database.DbRepository;
import com.kyon.todolist.Database.DbTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Date;

@Controller
public class EditListController {
    @Autowired
    DbRepository repository;

    @RequestMapping("/edit")
    public String edit(Model model, @RequestParam("id") Integer id){
        DbTodo data = this.repository.getOne(id);
        model.addAttribute("data", data);
        Iterable<DbTodo> list = repository.findAll(Sort.by(Sort.Direction.ASC, "deadlineDt"));
        model.addAttribute("all", list);
        return "edit";
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String comment(@RequestParam("id") Integer id, @ModelAttribute("comment") String comment) {
        if(repository.findExactMatch(comment).size() == 0) {
            DbTodo data = this.repository.getOne(id);
            data.setComment(comment);
            this.repository.save(data);
        }
        return "forward:/edit";
    }

    @RequestMapping(value = "/deadlineDt", method = RequestMethod.POST)
    public String deadlineDt(@RequestParam("id") Integer id, @ModelAttribute("deadlineDt") Date deadlineDt) {
        DbTodo data = this.repository.getOne(id);
        data.setDeadlineDt(deadlineDt);
        this.repository.save(data);
        return "forward:/edit";
    }
}
