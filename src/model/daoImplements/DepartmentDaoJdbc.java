package model.daoImplements;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.List;

public class DepartmentDaoJdbc implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department department) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO department (Name) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, department.getName());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected != 0){
                ResultSet rs = st.getGeneratedKeys();

                if (rs.next()){

                    System.out.println("\nInsert completed!" +
                            "\nDepartment with id = " +rs.getInt(1)+ " and name = " +department.getName());
                }
            }

        } catch (SQLException e) {
            throw new DbException("Error in insert department. No Rows affected! " + e.getMessage());
        } finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void deleteByID(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }
}
