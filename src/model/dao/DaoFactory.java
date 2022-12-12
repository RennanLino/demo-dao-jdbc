package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
    public static SellerDao createSelerDao() {
        return new SellerDaoJDBC();
    }
}
