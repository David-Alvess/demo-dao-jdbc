package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Main2 {
    public static void main(String[] args) {


        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\n=== TEST 7: Department insert ===");
        Department dp1 = new Department(null, "Teste2");

        departmentDao.insert(dp1);
    }
}
