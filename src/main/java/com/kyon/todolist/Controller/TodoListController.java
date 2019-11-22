package com.kyon.todolist.Controller;

import com.kyon.todolist.Database.DbRepository;
import com.kyon.todolist.Database.DbTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Date;
import java.util.List;

@Controller
public class TodoListController {
    @Autowired
    DbRepository repository;

    @RequestMapping("/todolist")
    public String todolist(Model model){
        Iterable<DbTodo> list = repository.findAll(Sort.by(Sort.Direction.ASC, "deadlineDt"));
        model.addAttribute("data", list);
        model.addAttribute("size", ((List<DbTodo>) list).size());
        return "todolist";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String add(DbTodo data, @RequestParam("comment") String comment) {
        if(repository.findExactMatch(comment).size() == 0) {
            data.setState(false);
            data.setCreationDt(new Date(System.currentTimeMillis()));
            this.repository.save(data);
        }
        return "forward:/todolist";
    }

    @RequestMapping(value = "/done", method = RequestMethod.POST)
    public String done(@RequestParam("id") Integer id) {
        DbTodo data = this.repository.getOne(id);
        data.setState(true);
        this.repository.save(data);
        return "forward:/todolist";
    }

    @RequestMapping(value = "/undone", method = RequestMethod.POST)
    public String undone(@RequestParam("id") Integer id) {
        DbTodo data = this.repository.getOne(id);
        data.setState(false);
        this.repository.save(data);
        return "forward:/todolist";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") Integer id) {
        DbTodo data = this.repository.getOne(id);
        this.repository.delete(data);
        return "forward:/todolist";
    }
}
