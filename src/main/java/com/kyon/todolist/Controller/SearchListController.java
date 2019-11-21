package com.kyon.todolist.Controller;

import com.kyon.todolist.Database.DbRepository;
import com.kyon.todolist.Database.DbTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchListController {
    @Autowired
    DbRepository repository;

    @RequestMapping("/search")
    public String search(Model model){
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView search(ModelAndView mav, @ModelAttribute("keyword") String keyword){
        List<DbTodo> list = repository.findComment(keyword);
        mav.addObject("data", list);
        return mav;
    }
}
