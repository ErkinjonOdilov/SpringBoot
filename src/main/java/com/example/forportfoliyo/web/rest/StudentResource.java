package com.example.forportfoliyo.web.rest;

import com.example.forportfoliyo.model.Course;
import com.example.forportfoliyo.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {

    @PostMapping("/students")
    public ResponseEntity create(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }

    @PostMapping("/students/list")
    public ResponseEntity createAll(@RequestBody List<Student> students){
        return ResponseEntity.ok(students);
    }

    @PutMapping("/students") //Update
    public ResponseEntity update(@RequestBody Student student){
        student.setLastName("test uchun");
        return ResponseEntity.ok(student);
    }


    @PutMapping("/students/{id}") //Update
    public ResponseEntity updateSecond(@PathVariable Long id,
                                       @RequestBody Student student){
        student.setLastName("Test uchun");
        student.setId(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getOne(@PathVariable Long id){
        Student student=new Student();
        student.setId(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students")
    public ResponseEntity getAll(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String lastName,
                                 @RequestParam Integer age){
        List<Student> students=new ArrayList<>();
        Course course=new Course();
        course.setId(2L);
        course.setName("Test course");
        students.add(new Student(id,name,lastName,age,course));
        students.add(new Student(3L,"name","lastName",36,course));
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return  ResponseEntity.ok(id+" Malumot ocirildi");
    }

    @PatchMapping("/students/{id}")//qisman update
    public ResponseEntity patchUpdate(@PathVariable Long id,
                                      @RequestBody Student student){
        return ResponseEntity.ok(student);
    }



}
