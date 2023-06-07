package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("\n=== TEST 1: Seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: Seller findByDepartmentId ===");
        Department department = new Department(2, null);
        List<Seller> listSellers = sellerDao.findByDepartment(department);

        for (Seller obj : listSellers){
            System.out.println(obj);
        }
        System.out.println("\n=== TEST 3: Seller findByAll ===");
        listSellers = sellerDao.findAll();

        for (Seller obj : listSellers){
            System.out.println(obj);
        }

        /*System.out.println("\n=== TEST 4: Seller Insert ===");
        Seller seller1 = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
        sellerDao.insert(seller1);
        System.out.println("Inserted new id = " + seller1.getId()); */

        /*System.out.println("\n=== TEST 5: Seller update ===");
        Seller seller2 = sellerDao.findById(16);
        seller2.setName("Greg Maccallyster");
        sellerDao.update(seller2);
        System.out.println("Update completed");*/

        System.out.println("\n=== TEST 6: Seller deleteById ===");
        sellerDao.deleteByID(17);
        System.out.println("Delete completed!");
    }
}
