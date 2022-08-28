package com.example.test;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class TaskController {
    List<Task> tasklist = new ArrayList<>();
    Task testTask = new Task();


    @GetMapping
    public String goHome(@ModelAttribute Task task, Model model) throws IOException {
        /** checking if task is empty, that would mean its a new instance of program run,
         so we fill the list from our json file that was saved last sesion  **/
        if (tasklist.isEmpty()) {
            addFromJson();
        }
        model.addAttribute("data", tasklist);


        return "task";

    }

    @GetMapping("/task")
    public String saveTask(@ModelAttribute Task task) {

        return "add_task";

    }

    @PostMapping("/addTask")
    public String addTask(@ModelAttribute Task task) throws IOException {
        tasklist.add(task);
        handleJson();
        System.out.println(" the size of the list " + tasklist.size());
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam UUID taskID) throws IOException {
        System.out.println("istrinta" + taskID);
        for (int i = 0; i < tasklist.size(); i++) {
            if (tasklist.get(i).getCorrId().equals(taskID)) {
                tasklist.remove(i);
                handleJson();
                return "redirect:/";
            }
        }

        return "redirect:/";
    }

    // creates json file and saves it in folder
    public void handleJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(tasklist);
        FileWriter object = new FileWriter("text.txt");
        object.write(jsonString);
        object.close();
        System.out.println(jsonString);


    }

    // Adding from json file to list
    public void addFromJson() throws IOException {
        ObjectMapper mapperAdd = new ObjectMapper();
        FileReader objectFile = new FileReader("text.txt");
        Task[] jsonString = mapperAdd.readValue(Paths.get("text.txt").toFile(), Task[].class);
        for (Task task : jsonString) {
            tasklist.add(task);

        }
    }

}
