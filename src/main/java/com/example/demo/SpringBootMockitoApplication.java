package com.example.demo;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMockitoApplication implements CommandLineRunner{

    private EmployeeRepository employeeRepository;

    @Autowired
    public SpringBootMockitoApplication(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMockitoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

       // employeeRepository.save(new Employee("John"));
        employeeRepository.save(new Employee("Marry"));
    }
}
