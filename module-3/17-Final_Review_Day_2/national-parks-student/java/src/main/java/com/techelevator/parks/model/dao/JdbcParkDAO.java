package com.techelevator.parks.model.dao;

import com.techelevator.parks.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcParkDAO implements ParksDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcParkDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Park> list() {
        List<Park> parks = new ArrayList<Park>();
        String sql = "SELECT parkcode, url, fullname, description, state, image_url FROM park";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while(rows.next()) {
            parks.add(mapRowToPark(rows));
        }
        return parks;
    }

    @Override
    public Park get(String parkCode) {
        Park park = null;
        String sql = "SELECT parkcode, url, fullname, description, state, image_url FROM park WHERE parkcode = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, parkCode);
        while(rows.next()) {
            park = mapRowToPark(rows);
        }
        return park;
    }

    private Park mapRowToPark(SqlRowSet row) {
        Park park = new Park();

        park.setParkCode(row.getString("parkcode"));
        park.setUrl(row.getString("url"));
        park.setFullName(row.getString("fullname"));
        park.setDescription(row.getString("description"));
        park.setState(row.getString("state"));
        park.setImage_url(row.getString("image_url"));

        return park;
    }
}
