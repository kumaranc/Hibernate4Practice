package com.arulstudies.hibernate.operations.employees;

import com.arulstudies.hibernate.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Map;

public class EmployeeService {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        Employee employee = employeeService.getEmployeeObj(0, "aravind", "IT", "chennai", "9940208162");
        employeeService.createOrUpdateEmp(employee);
    }

    public List<Employee> getAllEmployees(Map<String, String> filterCondition,
                                          Map<String, String> sortCondition, int limit, int offset) {
        Session session = Util.getInstance().getSession(Employee.class);
        Transaction transaction = session.beginTransaction();
        String condition = Util.getInstance().convertMapToString(filterCondition);
        String sortCond = Util.getInstance().convertMapToString(sortCondition);
        List<Employee> employeeList = null;

        try {
            employeeList = session.createQuery("from Employee "+ condition + sortCond)
                            .setMaxResults(limit).setFirstResult(offset).list();

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            Util.getInstance().terminateSession(session);
        }

        return employeeList;
    }

    public boolean createOrUpdateEmp(Employee employee) {
        Session session = Util.getInstance().getSession(Employee.class);
        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(employee);
            transaction.commit();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            Util.getInstance().terminateSession(session);
        }
        return true;
    }

    public boolean removeEmployee(String id) {
        Session session = Util.getInstance().getSession(Employee.class);
        Transaction transaction = session.beginTransaction();

        try {
            Employee employee  = (Employee) session.get(Employee.class, id);
            session.delete(employee);
        } catch (Exception ex) {
            System.out.println("Delete Failed" + ex.getMessage());
            return false;
        } finally {
            Util.getInstance().terminateSession(session);
        }

        return true;
    }

    public Employee getEmployeeObj(int id, String name, String location, String dept, String mobileNumber) {
        Employee employee = new Employee();
        if(id > 0) employee.setId(id);
        employee.setName(name);
        employee.setDepartment(location);
        employee.setLocation(dept);
        employee.setMobileNumber(mobileNumber);

        return employee;
    }
}
