package com.project.projectwebapp.controller;
import javax.validation.Valid;

import com.project.projectwebapp.model.Student;
import com.project.projectwebapp.service.StudentService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

@Controller
@SessionAttributes("student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/studentList")
    public String studentList(Model model, Pageable pageable) {
        model.addAttribute("studenci", studentService.getStudenci(pageable).getContent());
        return "studentList";
    }

    @GetMapping("/studentEdit")
    public String studentEdit(@RequestParam(required = false) Integer studentId, Model model) {
        if (studentId != null) {
            model.addAttribute("student", studentService.getStudent(studentId).get());
        } else {
            Student student = new Student();
            model.addAttribute("student", student);
        }
        return "studentEdit";
    }

    @PostMapping(path = "/studentEdit")
    public String studentEditSave(@ModelAttribute @Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "studentEdit";
        }
        try {
            student = studentService.setStudent(student);
        } catch (HttpStatusCodeException e) {
            bindingResult.rejectValue(null, String.valueOf(e.getStatusCode().value()),
                    e.getStatusCode().getReasonPhrase());
            return "studentEdit";
        }
        return "redirect:/studentList";
    }

    @PostMapping(params="cancel", path = "/studentEdit")
    public String studentEditCancel() { // żądanie będzie zawierało parametr 'cancel'
        return "redirect:/studentList";
    }

    @PostMapping(params="delete", path = "/studentEdit")
    public String studentEditDelete(@ModelAttribute Student student) {
        studentService.deleteStudent(student.getStudentId());
        return "redirect:/studentList";
    }
}