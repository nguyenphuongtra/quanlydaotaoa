package com.example.quanlydaotao.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.quanlydaotao.entity.Student;
import com.example.quanlydaotao.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ModelAttribute
    public void exposeRequest(HttpServletRequest request, Model model) {
        model.addAttribute("request", request);
        model.addAttribute("requestURI", request.getRequestURI());
    }

    @GetMapping
    public String listStudents(@RequestParam(required = false) String keyword, Model model) {
        model.addAttribute("students", studentService.search(keyword));
        model.addAttribute("keyword", keyword);
        return "students/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("mode", "create");
        return "students/form";
    }

    @PostMapping
    public String createStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public String showStudentDetail(@PathVariable UUID id, Model model) {
        Student student = studentService.getById(id);
        model.addAttribute("student", student);
        model.addAttribute("mode", "view");
        model.addAttribute("readOnly", true);
        return "students/form";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable UUID id, Model model) {
        Student student = studentService.getById(id);
        model.addAttribute("student", student);
        model.addAttribute("mode", "edit");
        model.addAttribute("readOnly", false);
        return "students/form";
    }

    @PostMapping("/{id}/edit")
    public String updateStudent(@PathVariable UUID id, @ModelAttribute("student") Student student) {
        student.setId(id);
        studentService.save(student);
        return "redirect:/students";
    }

    @PostMapping("/{id}/delete")
    public String deleteStudent(@PathVariable UUID id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}
