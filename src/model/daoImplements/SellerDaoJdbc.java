package model.daoImplements;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.util.List;

public class SellerDaoJdbc implements SellerDao {

    private Connection conn = null;

    public SellerDaoJdbc (Connection conn){
        this.conn = conn;
    }
    @Override
    public void insert(Seller seller) {

    }

    @Override
    public void update(Seller seller) {

    }

    @Override
    public void deleteByID(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select seller .*, department.Name as DepName " +
                    "from seller INNER JOIN department " +
                    "ON seller.DepartmentId = Department.id " +
                    "where seller.Id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()){
                Department department = instantiateDepartment(rs);
                Seller seller = instantiateSeller(rs, department);
                return seller;
            }

        } catch (SQLException s){
            throw new DbException("Error: " +s.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            //nao fechei conexao aqui, pq tem outros metodos que podem ser usados na mesma conexao - insert() por exemplo.
        }

        return null;
    }

    private Seller instantiateSeller(ResultSet rs, Department department) throws SQLException {
        Seller seller = new Seller();
        seller.setId(rs.getInt("Id"));
        seller.setName(rs.getString("Name"));
        seller.setEmail(rs.getString("Email"));
        seller.setBirthDate(rs.getDate("BirthDate"));
        seller.setBaseSalary(rs.getDouble("BaseSalary"));
        seller.setDepartment(department);
        return seller;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department department = new Department();
        department.setId(rs.getInt("DepartmentId"));
        department.setName(rs.getString("DepName"));
        return department;
    }

    @Override
    public List<Seller> findAll() {
        return null;
    }
}
