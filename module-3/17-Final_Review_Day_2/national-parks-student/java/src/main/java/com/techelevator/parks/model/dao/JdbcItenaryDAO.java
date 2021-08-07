package com.techelevator.parks.model.dao;

import com.techelevator.parks.model.Itenary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcItenaryDAO implements ItenaryDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcItenaryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Itenary create(Itenary itenary, String username) {
        String sql = "INSERT INTO itenary (itenary_id, name, startdate, enddate) VALUES (DEFAULT, ?, ?, ?) RETURNING itenary_id";
        Long id = jdbcTemplate.queryForObject(sql, Long.class, itenary.getName(), itenary.getStartDate(), itenary.getEndDate());
        itenary.setItenaryId(id);
        insertItenaryUser(id, username);
        return itenary;
    }

    @Override
    public List<Itenary> getListforUser(String username) {
        List<Itenary> itenaries = new ArrayList<Itenary>();

        String sql = "SELECT itenary.itenary_id, name, startdate, enddate FROM itenary " +
                "JOIN user_itenary ON user_itenary.itenary_id = itenary.itenary_id " +
                "JOIN users ON user_itenary.user_id = users.user_id " +
                "WHERE users.username = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, username);

        while(rows.next()) {
            itenaries.add(mapRowToItenary(rows));
        }
        return itenaries;
    }

    @Override
    public Itenary get(long itenaryId, String username) {
        Itenary itenary = null;

        String sql = "SELECT itenary.itenary_id, name, startdate, enddate FROM itenary " +
                "JOIN user_itenary ON user_itenary.itenary_id = itenary.itenary_id " +
                "JOIN users ON user_itenary.user_id = users.user_id " +
                "WHERE users.username = ? AND itenary.itenary_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, username, itenaryId);

        if (rows.next()) {
            itenary = mapRowToItenary(rows);
        }
        return itenary;
    }

    @Override
    public void update(Itenary itenary) {
        String sql = "UPDATE itenary SET name = ?, startdate = ?, enddate = ? WHERE itenary_id = ?";
        jdbcTemplate.update(sql, itenary.getName(), itenary.getStartDate(), itenary.getEndDate(), itenary.getItenaryId());
    }

    @Override
    public void delete(long itenaryId) {
        String sqlDeleteUserItenary = "DELETE FROM user_itenary WHERE itenary_id = ?";
        jdbcTemplate.update(sqlDeleteUserItenary, itenaryId);

        String sql = "DELETE FROM itenary WHERE itenary_id = ?";
        jdbcTemplate.update(sql, itenaryId);
    }


    public boolean isItenaryUsers(Long itenaryId, String username) {
        String sql = "SELECT itenary.itenary_id FROM itenary " +
                "JOIN user_itenary ON user_itenary.itenary_id = itenary.itenary_id " +
                "JOIN users ON user_itenary.user_id = users.user_id " +
                "WHERE users.username = ? AND itenary.itenary_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, username, itenaryId);

        return rows.next();
    }

    private void insertItenaryUser(Long itenaryId, String username) {
        String sql = "INSERT INTO user_itenary (user_id, itenary_id) VALUES ((SELECT user_id FROM users WHERE username = ?), ?)";
        jdbcTemplate.update(sql, username, itenaryId);
    }


    private Itenary mapRowToItenary(SqlRowSet row) {
        Itenary itenary = new Itenary();

        itenary.setItenaryId(row.getLong("itenary_id"));
        itenary.setName(row.getString("name"));

        if (row.getDate("startdate") != null) {
            itenary.setStartDate(row.getDate("startdate").toLocalDate());
        }

        if (row.getDate("enddate") != null) {
            itenary.setEndDate(row.getDate("enddate").toLocalDate());
        }
        return itenary;
    }
}
