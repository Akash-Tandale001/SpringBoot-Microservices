package com.akash.departmentservice.Repositroy;

import com.akash.departmentservice.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department findByDepartmentId(Long departmentId);
}
