package com.mnp.personsmanager;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {
    JdbcTemplate jdbcTemplate;

    public PersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(Person person){
        String sql = "INSERT INTO person VALUES (?,?,?)";
        jdbcTemplate.update(sql, new Object[]{person.getId(), person.getFirstname(), person.getLastname()});
    }

    public void delete(long id){
        String sql = "DELETE FROM person WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    /*@EventListener(ApplicationReadyEvent.class)
    public void dbManage(){
    }*/
}
