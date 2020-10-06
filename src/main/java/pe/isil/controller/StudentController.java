package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.Student;
import pe.isil.service.IStudentService;

import java.rmi.StubNotFoundException;
import java.util.List;


@Controller
public class StudentController {


    @Autowired
    IStudentService studentService;

    @GetMapping("/students")
    public String getStudentList(Model model){


        List<Student> students = studentService.getAll();
        model.addAttribute("students",students);

        return "student-list";
    }

    @GetMapping("/students/add")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "student-add";
    }

    @PostMapping("/students/save")
    public String saveStudent(Model model,Student student){
        studentService.create(student);

        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String studentForEdit(@PathVariable Integer id, Model model){
        Student student= studentService.findById(id);
        if (student !=null){
            model.addAttribute("student",student);
            return "student-edit";
        }
        return "index";
    }

    @PostMapping("/students/update")
    public String updateStudent(Model model,Student student){
        studentService.update(student);

        return "redirect:/students";
    }

   @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Integer id){

       Student student= studentService.findById(id);
        if (student !=null){
            studentService.delete(student);

        }
       return "redirect:/students";
   }
}

