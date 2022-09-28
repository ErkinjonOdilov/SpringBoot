package com.example.forportfoliyo.service;

import com.example.forportfoliyo.entity.Employee;
import com.example.forportfoliyo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;  //dependenci inject

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee  save(Employee employee){
      return  employeeRepository.save(employee);
    }

    public void delete(Long id){
      employeeRepository.deleteById(id);
    }

    public Optional<Employee> findById(Long id){
     Optional<Employee> employee= employeeRepository.findById(id);
        if(!employee.isPresent()){
            return null;
        }
     return employee;
    }



    public List<Employee> findAll(String email,String name){
        List<Employee> employees=employeeRepository.findAllByNameAndLastName(email,name);
        return employees;
    }


    public List<Employee> findByQueryParam(String name){
        return employeeRepository.findAllByNameLikeJPQL(name);
    }

    public List<Employee> getAllByDepartmentIdEmployees(Long id){
        List<Employee> allByDepartment_id = employeeRepository.findAllByDepartment_Id(id);
        return allByDepartment_id;
    }

//    public void deletedById(Long id){
//        employeeRepository.softDeleteById(id);
//    }
}
