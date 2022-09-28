package com.example.forportfoliyo.repository;

import com.example.forportfoliyo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Long> {

    @Query("select e from Employee e where e.name=:name and e.lastName=:lastName")//oddiy query  jpa query
    List<Employee> findAll(@Param("name") String name,
                           @Param("lastName") String lastName);


    List<Employee> findAllByNameAndLastName(String name,String lastName);

    @Query(value = "SELECT *FROM employee e WHERE e.last_name=:name",nativeQuery = true)//Nativ equery database ga qanday query yozsak bu yerga ham wunaqa qilib yoziw
    List<Employee> findAll(@Param("name") String name);


    List<Employee> findAllByNameLike(String name); ///Aynan birxilini ob ciqadi


    @Query("select e from Employee e where UPPER(e.name)  like upper(concat('%', :name,'%')) order by e.id asc ") //Har qanday holatda qidir
    List<Employee> findAllByNameLikeJPQL(@Param("name") String name);

    @Query(value = "SELECT * FROM employee e WHERE e.name LIKE :%name",nativeQuery = true)
    List<Employee> findAllByNameLikeNative(@Param("name") String name);

    List<Employee> findAllByNameStartingWithOrderByIdDesc(String name); //Math query

    List<Employee> findAllByNameEndingWith(String name); //Math query

//    @Modifying
//    @Query("update Employee set deleted = true where id = :id")
//    void softDeleteById(Long id);

    List<Employee> findAllByDepartment_Id(Long id);
}
