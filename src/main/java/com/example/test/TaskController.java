package com.example.test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {
     List<Task> tasklist= new ArrayList<>();


    @GetMapping
    public String goHome( @ModelAttribute Task task, Model model) throws IOException {

        model.addAttribute("data",tasklist);
       // this creats json file( do logic elsewhere)
        ObjectMapper mapper= new ObjectMapper();
        String jsonString=mapper.writeValueAsString(tasklist);
        //writing to json file in default folder
        FileWriter object= new FileWriter("text.txt");
        object.write(jsonString);
        object.close();
        // printing out json
        System.out.println(jsonString);
        return "task";

    }
    @GetMapping("/task")
    public String saveTask(@ModelAttribute Task task){

            return"add_task" ;

    }

    @PostMapping("/addTask")
    public String addTask(@ModelAttribute Task task){
        tasklist.add(task);
        System.out.println(" the size of the list " + tasklist.size());
        return"redirect:/";
    }

}
