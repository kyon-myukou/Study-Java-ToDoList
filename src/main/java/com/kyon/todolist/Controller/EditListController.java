package com.kyon.todolist.Controller;

import com.kyon.todolist.Database.DbRepository;
import com.kyon.todolist.Database.DbTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditListController {
    @Autowired
    DbRepository repository;

    @RequestMapping("/edit")
    public String edit(Model model){
        Iterable<DbTodo> list = repository.findAll();
        model.addAttribute("data", list);
        return "edit";
    }

    @RequestMapping(value = "/undone", method = RequestMethod.POST)
    public String undone(@RequestParam("id") Integer id) {
        DbTodo data = this.repository.getOne(id);
        data.setState(false);
        this.repository.save(data);
        return "redirect:/edit";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") Integer id) {
        DbTodo data = this.repository.getOne(id);
        this.repository.delete(data);
        return "redirect:/edit";
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String comment(@RequestParam("id") Integer id, @ModelAttribute("comment") String comment) {
        DbTodo data = this.repository.getOne(id);
        data.setComment(comment);
        this.repository.save(data);
        return "redirect:/edit";
    }
}
