package munte.transactional.service;

import munte.transactional.dto.EmployeeDTO;
import munte.transactional.entity.Department;
import munte.transactional.entity.Employee;
import munte.transactional.repository.DepartmentRepository;
import munte.transactional.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    @Transactional
    public String saveEmployee(EmployeeDTO employeeDTO) {

        Department department = new Department();
        department.setDepartmentName(employeeDTO.getDepartmentName());
        department.setDepartmentCode(employeeDTO.getDepartmentName());

        Long departmentId = departmentRepository.save(department).getDepartmentId();

//        Employee employee = new Employee();
        Employee employee = null;
        employee.setEmpName(employeeDTO.getEmpName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDepartmentId(departmentId);

        employeeRepository.save(employee);

        return "Employee is saved with Employee ID : " + employee.getEmployeeId();
    }
}
