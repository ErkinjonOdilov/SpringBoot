package com.example.forportfoliyo.service;

import com.example.forportfoliyo.entity.Department;
import com.example.forportfoliyo.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

   public final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;

    }

    public Department save(Department department){
        return departmentRepository.save(department);
    }

    public List<Department> getAll(){
        List<Department> all = departmentRepository.findAll();
        return all;
    }
}
