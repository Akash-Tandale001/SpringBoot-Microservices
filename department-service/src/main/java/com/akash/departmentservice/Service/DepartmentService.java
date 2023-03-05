package com.akash.departmentservice.Service;

import com.akash.departmentservice.Entity.Department;
import com.akash.departmentservice.Repositroy.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside of saveDepartment method of deparmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside of findDepartmentById method of deparmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }

}
