package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class App2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        
        System.out.println("\n=== TEST 1: department findById ===");
        Department dep = departmentDao.findById(3);
        System.out.println(dep);

        System.out.println("\n=== TEST 2: department findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: department insert ===");
        String name = sc.nextLine();
        if (name != "") {
            Department newDep = new Department(null, name);
            departmentDao.insert(newDep);
            System.out.println("New Department inserted! Id = " + newDep.getId());
        }
        
        System.out.println("\n=== TEST 4: seller update ===");
        int id = sc.nextInt();
        sc.nextLine();
        if (id != 0) {
            name = sc.nextLine();
            dep = new Department(id, name);
            departmentDao.update(dep);
            System.out.println("Update completed!");
        }

        System.out.println("\n=== TEST 5: department delete ===");
        System.out.println("Enter id for delete test: ");
        id = sc.nextInt();
        sc.nextLine();
        if (id != 0) {
            departmentDao.deleteById(id);
            System.out.println("Delete completed!");
        }
        sc.close();
    }
}
