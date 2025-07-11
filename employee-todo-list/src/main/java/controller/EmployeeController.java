package controller;

import model.Employee;
import model.Todo;
import service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee emp) {
        return service.updateEmployee(id, emp);
    }

    @GetMapping("/role/{role}")
    public List<Employee> findByRole(@PathVariable String role) {
        return service.getByRole(role);
    }

    @GetMapping("/{id}/todos")
    public List<Todo> getTodos(@PathVariable Long id) {
        return service.getTodosByEmployeeId(id);
    }

    @PostMapping("/{id}/todos")
    public Todo addTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return service.addTodoToEmployee(id, todo);
    }
}
