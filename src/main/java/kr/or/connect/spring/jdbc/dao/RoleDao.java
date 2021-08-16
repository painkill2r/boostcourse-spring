package kr.or.connect.spring.jdbc.dao;

import kr.or.connect.spring.jdbc.dto.Role;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static kr.or.connect.spring.jdbc.dao.RoleDaoSqls.*;

@Repository
public class RoleDao {

    private NamedParameterJdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertAction;
    private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

    /**
     * 스프링 4.3 부터는 기본 생성자가 없다면 자동으로 파라미터에 선언된 객체를 주입해준다.
     *
     * @param dataSource
     */
    public RoleDao(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("boost_role"); //어떤 테이블에 저장할 것인지 설정
    }

    public List<Role> selectdAll() {
        return jdbcTemplate.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
    }

    public int insert(Role role) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);
        return insertAction.execute(params);
    }

    public int update(Role role) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);
        return jdbcTemplate.update(UPDATE, params);
    }

    public int deleteById(Integer id) {
        Map<String, Integer> params = Collections.singletonMap("roleId", id);
        return jdbcTemplate.update(DELETE_BY_ROLE_ID, params);
    }

    public Role selectById(Integer id) {
        try {
            Map<String, Integer> params = Collections.singletonMap("roleId", id);
            return jdbcTemplate.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            //조건에 맞는 row가 없는 경우 NULL 반환
            return null;
        }
    }
}
