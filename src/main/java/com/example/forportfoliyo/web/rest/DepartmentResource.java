package com.example.forportfoliyo.web.rest;

import com.example.forportfoliyo.entity.Department;
import com.example.forportfoliyo.service.DepartmentService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentResource {

    public final DepartmentService departmentService;

    public DepartmentResource(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/department")
    public ResponseEntity<Department> create(@RequestBody Department department){
        Department save = departmentService.save(department);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/department")
    public List<Department> getAll(){
        return departmentService.getAll();
    }
}
