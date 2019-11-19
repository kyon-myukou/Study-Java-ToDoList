package com.kyon.todolist.Controller;

import com.kyon.todolist.Database.DbRepository;
import com.kyon.todolist.Database.DbTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoListController {
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
}