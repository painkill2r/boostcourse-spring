package kr.or.connect.spring.jdbc.dao;

public class RoleDaoSqls {

    public static final String SELECT_ALL = "SELECT role_id, description FROM boost_role ORDER BY role_id ASC";
    public static final String UPDATE = "UPDATE boost_role SET description = :description WHERE 1 = 1 AND role_id = :roleId";
    public static final String SELECT_BY_ROLE_ID = "SELECT role_id, description FROM boost_role WHERE 1 = 1 AND role_id = :roleId";
    public static final String DELETE_BY_ROLE_ID = "DELETE FROM boost_role WHERE 1 = 1 AND role_id = :roleId";
}
