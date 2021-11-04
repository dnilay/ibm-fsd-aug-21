package com.example.demo.repository;
import com.example.demo.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {


    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private EmployeeRepository employeeRepository;





    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        String name = "Marry";
      /*  Employee employee = new Employee();
        employee.setName(name);
        entityManager.persist(employee);
        entityManager.flush();*/

        // when
        Employee found = employeeRepository.findByName(name);


        // then
        Assert.assertNotNull(found);
        Assert.assertEquals(found.getName(),name);


    }

    @Test
    @Description("finding all employees")
    public void when_find_all_returnEmployees()
    {
        List<Employee> list=employeeRepository.findAll();
        Assert.assertTrue("number of employees are not 3",list.size()==3);
    }

}