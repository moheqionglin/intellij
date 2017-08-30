/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flower.intellij.component.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wang_gang0101
 */
@Repository
public class CommonReposity {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final Map<String, SimpleJdbcInsert> insertMap = new ConcurrentHashMap<>();

    public CommonReposity() {
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    public <T extends Object> List<T> query(String sql, Class<T> type) {
        return jdbcTemplate.query(sql, (rs, row) -> DomainUtils.rs2bean(rs, type));
    }

    public <T> List<T> query(String sql, PreparedStatementSetter pss, Class<T> type) {
        return jdbcTemplate.query(sql, pss, (rs, row) -> DomainUtils.rs2bean(rs, type));
    }

    private LinkedHashMap<String, Object> getValseMap(Object object) {
        return mapper.convertValue(object, LinkedHashMap.class);
    }

    public Long insert2mysql(Object object, String tableName) {
        SimpleJdbcInsert insert = getInsert(tableName);
        Number idVal = insert.executeAndReturnKey(getValseMap(object));
        return idVal.longValue();
    }

    private SimpleJdbcInsert getInsert(String tableName) {
        if (insertMap.containsKey(tableName)) {
            return insertMap.get(tableName);
        }
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName(tableName).usingGeneratedKeyColumns("id");
        insertMap.put(tableName, insert);
        return getInsert(tableName);
    }

    private boolean equals(Object a, Object b) {
        if (a == null && b == null) {
            return true;
        }

        if ((a == null && b.equals(0))
                || (b == null && a.equals(0))) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.getClass() != b.getClass()) {
            return false;
        }

        if (a.getClass() == BigDecimal.class) {
            BigDecimal ba = (BigDecimal) a;
            BigDecimal bb = (BigDecimal) b;
            return ba.compareTo(bb) == 0;
        }

        return a.equals(b);
    }

    private String sqlUpdate(Object newObject, Object oldObject, String tableName) {
        Map<String, Object> oldObjectMap = getValseMap(oldObject);
        Map<String, Object> newObjectMap = getValseMap(newObject);
        String sqlPre = "update " + tableName + " set ";
        StringBuilder sqlSb = new StringBuilder(sqlPre);
        newObjectMap.forEach((key, value) -> {
            if (!oldObjectMap.containsKey(key)
                    || "createTime".equals(key) || "updateTime".equals(key) || "id".equals(key)) {
            } else if (value != null && !equals(value, oldObjectMap.get(key))) {
                if (value.getClass() == String.class || value.getClass() == Enum.class) {
                    sqlSb.append(key).append(" = '").append(value).append("' , ");
                } else if (value.getClass().getComponentType() == byte.class) {
                } else {
                    sqlSb.append(key).append(" = ").append(value).append(" , ");
                }
            }
        });
        if (sqlSb.toString().equals(sqlPre)) {
            return null;
        } else {
            sqlSb.append(" updateTime = now() where id = ").append(newObjectMap.get("id"));
            return sqlSb.toString();
        }
    }

    public boolean updateObject(Object newObject, Object oldObject, String tableName) {
        String sql = sqlUpdate(newObject, oldObject, tableName);
        if (StringUtils.isEmpty(sql)) {
            return false;
        }
        jdbcTemplate.update(sql);
        log.info(sql);
        return true;
    }
}
