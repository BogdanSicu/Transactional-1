package munte.transactional.service;

import munte.transactional.dto.EmployeeDTO;
import munte.transactional.repository.DepartmentRepository;
import munte.transactional.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String saveEmployee(EmployeeDTO employeeDTO) {
        return null;
    }
}
