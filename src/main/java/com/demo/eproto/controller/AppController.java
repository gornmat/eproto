package com.demo.eproto.controller;

import com.demo.eproto.model.Student;
import com.demo.eproto.model.StudentTask;
import com.demo.eproto.model.Task;
import com.demo.eproto.model.User;
import com.demo.eproto.service.*;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@AllArgsConstructor
public class AppController {

    private final UserService userService;
    private final StudentService studentService;
    private final ImageFileService imageFileService;
    private final TaskService taskService;
    private final StudentTaskService studentTaskService;
    private final MessageService messageService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping({"/index", "/"})
    public ModelAndView index() {
        var user = getCurrentUser();
        var role = getCurrentUserRole();

        ModelAndView mav = new ModelAndView("index");
        if ("ROLE_ADMIN".equals(role)) {
            mav.addObject("message", "");
            var students = studentService.getStudentsByClazz(user.getClazz());
            mav.addObject("students", students);
            List<Task> tasks = taskService.findAllByIdTeacher(user.getId());
            mav.addObject("tasks", tasks);
            mav.addObject("task", new Task());
        }

        if ("ROLE_USER".equals(role)) {
            var student = studentService.getStudentForParent(user);
            mav.addObject("student", student);
            //TODO display img
//            var path = imageFileService.getImagePath(user.getId());
//            InputStream is = path != null ? new ByteArrayInputStream(path) : null;
//            mav.addObject("image", is);
            var studentTasks = studentTaskService.getTasksForStudent(student.getId());
            mav.addObject("studentTasks", studentTasks);
        }

        return mav;
    }

    @RequestMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("createAccount")
    public String createAccount(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "login";
    }

    @PostMapping("saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("/showStudent/{id}")
    public ModelAndView showStudent(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("student");
        var studentTasks = studentTaskService.getTasksForStudent(id);
        mav.addObject("studentTasks", studentTasks);
        return mav;
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@ModelAttribute("student") Student student) {
        var user = getCurrentUser();
        studentService.delete(user);
        return "redirect:/";
    }

    @GetMapping("/editGrade/{id}")
    public ModelAndView editGrade(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("grade");
        var studentTask = studentTaskService.getTask(id);
        mav.addObject("studentTask", studentTask);
        return mav;
    }

    @PostMapping("/saveGrade")
    public ModelAndView saveGrade(@ModelAttribute("studentTask") StudentTask studentTask) {
        ModelAndView mav = new ModelAndView("student");
        studentTaskService.updateGrade(studentTask);
        var studentTasks = studentTaskService.getTasksForStudent(studentTask.getIdStudent());
        mav.addObject("studentTasks", studentTasks);
        return mav;
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
        var user = getCurrentUser();
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/";
        }
        String fileName = imageFileService.uploadFile(user, file);
        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');
        return "redirect:/";
    }

    @PostMapping("createTask")
    public String createTask(@ModelAttribute("task") Task task) {
        User user = getCurrentUser();
        var students = studentService.getStudentsByClazz(user.getClazz());
        taskService.createTask(user, students, task);
        return "redirect:/";
    }

    @PostMapping("sendMessage")
    public String sendMessage(@ModelAttribute("message") String message) {
        var teacher = getCurrentUser();
        var parents = userService.getUsersByClazz(teacher.getClazz());
        messageService.sendMessage(parents, message, teacher);
        return "redirect:/";
    }

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserByName(authentication.getName());
    }

    private String getCurrentUserRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().stream().findFirst().get().toString();
    }
}
