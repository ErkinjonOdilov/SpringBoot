package com.example.forportfoliyo.entity;


import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    @NotNull
    @Size(min = 5, max = 150)   //javani ozi tekshradi
    @Email
    @Column(name = "email",length = 150,unique = true,nullable = false)
    private String email;

    @ManyToOne
    private Department department;

    @OneToOne(optional = false) //javada tekshiradi null likkg
    @JoinColumn(name = "account_id",unique = true,nullable = false)
    private Account account;

    @OneToMany
    private Set<Item> items; //unique

    @ManyToMany
    private Set<Project> projects;  ///dublikat nvolmasiligi uchun setdan foydalandik

    public Employee(Set<Project> projects) {
        this.projects = projects;
    }

    public Employee() {

    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Department getDepartment() {
        return department;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
