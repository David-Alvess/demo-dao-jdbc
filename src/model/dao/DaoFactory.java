package model.dao;

import model.daoImplements.SellerDaoJdbc;

public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJdbc();
    }
}
