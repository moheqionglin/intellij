package com.flower.intellij.component.wifi;

import com.flower.intellij.component.button.Status;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class WifiRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Wifi> getWifiList() {
        try {
            return jdbcTemplate.query("select * from wifi",
                    (rs, row) -> {
                        Wifi wifi = new Wifi();
                        wifi.setId(rs.getLong("id"));
                        wifi.setStatus(Status.valueOf(rs.getString("status")));
                        wifi.setLocation(rs.getString("location"));
                        return wifi;
                    });
        } catch (Exception e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
            return new ArrayList<>();
        }
    }

    public boolean addWifi(Wifi wifi) {
        
        log.info(wifi.getStatus().toString());
        
        try {
            jdbcTemplate.update("insert into wifi (status, location) values (?,?)",
                    ps -> {
                        ps.setString(1, wifi.getStatus().toString());
                        ps.setString(2, wifi.getLocation());
                    }
            );
            return true;
        } catch (Exception e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
            return false;
        }
    }

    public Wifi getWifi(Long id) {
        try {
            return jdbcTemplate.query("select * from wifi where id = ? ",
                    ps -> ps.setLong(1, id),
                    (rs, row) -> {
                        Wifi wifi = new Wifi();
                        wifi.setId(rs.getLong("id"));
                        wifi.setStatus(Status.valueOf(rs.getString("status")));
                        wifi.setLocation(rs.getString("location"));
                        return wifi;
                    }).stream().findAny().orElse(null);
        } catch (Exception e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
            return null;
        }
    }
}
