package com.example.test;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class TaskController {
     List<Task> tasklist= new ArrayList<>();
     Task testTask= new Task();



    @GetMapping
    public String goHome( @ModelAttribute Task task, Model model){

        model.addAttribute("data",tasklist);
        System.out.println(task.getCorrId());

        return "task";

    }
    @GetMapping("/task")
    public String saveTask(@ModelAttribute Task task){

            return"add_task" ;

    }

    @PostMapping("/addTask")
    public String addTask(@ModelAttribute Task task) throws IOException {
        tasklist.add(task);
        handleJson();
        System.out.println(" the size of the list " + tasklist.size());
        return"redirect:/";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam UUID taskID) throws IOException {
        System.out.println("istrinta"+ taskID);
        for( int i=0; i<tasklist.size(); i++){
            if (tasklist.get(i).getCorrId().equals(taskID)){
                tasklist.remove(i);
                handleJson();
                return "redirect:/";
            }
        }
        
       return "redirect:/";
    }

// creates json file and saves it in folder
    public void handleJson() throws IOException {
        ObjectMapper mapper= new ObjectMapper();
        String jsonString=mapper.writeValueAsString(tasklist);
        FileWriter object= new FileWriter("text.txt");
        object.write(jsonString);
        object.close();
        System.out.println(jsonString);


    }

}
