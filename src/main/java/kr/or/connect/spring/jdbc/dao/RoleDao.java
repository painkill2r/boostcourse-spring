package kr.or.connect.spring.jdbc.dao;

import kr.or.connect.spring.jdbc.dto.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

import static kr.or.connect.spring.jdbc.dao.RoleDaoSqls.*;

@Repository
public class RoleDao {

    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

    /**
     * 스프링 4.3 부터는 기본 생성자가 없다면 자동으로 파라미터에 선언된 객체를 주입해준다.
     *
     * @param dataSource
     */
    public RoleDao(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Role> selectdAll() {
        return jdbcTemplate.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
    }
}
