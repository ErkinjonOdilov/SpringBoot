package com.example.forportfoliyo.web.rest;

import com.example.forportfoliyo.entity.Employee;
import com.example.forportfoliyo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

    public final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees") //birinchi Post turiwi kerak chunki brinchi malumot yeratiladi
    public ResponseEntity create(@RequestBody Employee employee){
        Employee result = employeeService.save(employee);
        return  ResponseEntity.ok(result);
    }

    @PutMapping("/employees")
    public ResponseEntity update(@RequestBody Employee employee){
        if(employee.getId()==null){
            return ResponseEntity.badRequest().build();
        }
        Employee result = employeeService.save(employee);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Optional<Employee>> getOne(@PathVariable Long id){
        Optional<Employee> byId = employeeService.findById(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping("/employees")
    public ResponseEntity getAll(@RequestParam String email,@RequestParam String name){
        List<Employee> all = employeeService.findAll(email,name);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/employees/search")
    public ResponseEntity getAllQueryParam(@RequestParam String name){
        List<Employee> all = employeeService.findByQueryParam(name);
        return ResponseEntity.ok(all);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.ok("Qator o'chirildi");
    }
}
