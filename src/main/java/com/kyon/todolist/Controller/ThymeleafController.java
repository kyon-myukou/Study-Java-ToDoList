package com.kyon.todolist.Controller;

import com.kyon.todolist.DbRepository;
import com.kyon.todolist.DbTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeleafController {
    @Autowired
    DbRepository repository;

    @RequestMapping("/todolist")
    public String todolist(Model model){
        Iterable<DbTodo> list = repository.findAll();
        model.addAttribute("data", list);
        return "todolist";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String add(DbTodo data) {
        data.setState(false);
        this.repository.save(data);
        return "redirect:/todolist";
    }

    @RequestMapping(value = "/done", method = RequestMethod.POST)
    public String done(@RequestParam("id") Integer id) {
        DbTodo data = this.repository.getOne(id);
        data.setState(true);
        this.repository.save(data);
        return "redirect:/todolist";
    }

    @RequestMapping("/search")
    public String search(Model model){
        return "search";
    }

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
