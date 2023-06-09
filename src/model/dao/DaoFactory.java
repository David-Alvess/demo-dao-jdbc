package model.dao;

import db.DB;
import model.daoImplements.DepartmentDaoJdbc;
import model.daoImplements.SellerDaoJdbc;

public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJdbc(DB.getConnection());
    }
    public static DepartmentDao createDepartmentDao(){
        return new DepartmentDaoJdbc(DB.getConnection());
    }

}
