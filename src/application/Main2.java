package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        /*System.out.println("\n=== TEST 1: Department insert ===");
        Department dp1 = new Department(null, "Teste2");
        departmentDao.insert(dp1);*/

        /*System.out.println("\n=== TEST 2: Department findById ===");
        Department dep = departmentDao.findById(4);
        System.out.println(dep);*/

        /*System.out.println("\n=== TEST 3: Department deleteById ===");
        departmentDao.deleteByID(17);*/

        System.out.println("\n=== TEST 4: Department update =======");
        Department dep2 = departmentDao.findById(1);
        dep2.setName("Food");
        departmentDao.update(dep2);

        /*System.out.println("\n=== TEST 5: Department findAll ===");
        List<Department> listDepartments = departmentDao.findAll();
        for (Department departments : listDepartments){
            System.out.println(departments);
        }*/
    }
}
