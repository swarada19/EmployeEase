package com.swarada.emproject;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class EmpController {

   //EmployeeService employeeService = new EmployeeServiceImpl();
   
   //Dependency Injection
   @Autowired
   EmployeeService employeeService;

   @GetMapping("employees/{id}")
   public Employee getAllEmployeeById(@PathVariable Long id){
      System.out.println("Hiiii");
      return employeeService.readEmployee(id);
   }

   @PostMapping("employees")
   public String createEmployee(@RequestBody Employee employee){
      return employeeService.createEmployee(employee);
   }

   @DeleteMapping("employees/{id}")
   public String deleteEmployee(@PathVariable Long id){
      if(employeeService.deleteEmployee(id))
          return "Deleted Successfully";
      return "Not Found";
   }

   @PutMapping("employees/{id}")
   public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
      return employeeService.updateEmployee(id, employee);
   }
 
   
}
