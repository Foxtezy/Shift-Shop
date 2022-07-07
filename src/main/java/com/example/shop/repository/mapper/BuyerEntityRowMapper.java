package com.example.shop.repository.mapper;

import com.example.shop.repository.model.BuyerEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BuyerEntityRowMapper implements RowMapper<BuyerEntity> {
    @Override
    public BuyerEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        rs.absolute(rowNum);
        BuyerEntity result = new BuyerEntity();
        result.setLogin(rs.getString("login"));
        result.setAddress(rs.getString("address"));
        result.setBalance(rs.getDouble("balance"));
        return result;
    }
}
