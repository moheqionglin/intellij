package com.flower.intellij.component.wifi;

import com.flower.intellij.component.common.CommonReposity;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class WifiRepository {

    @Autowired
    private CommonReposity commonReposity;

    public List<Wifi> getWifiList() {
        try {
            return commonReposity.query("select * from wifi", Wifi.class);
        } catch (Exception e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
            return new ArrayList<>();
        }
    }

    public boolean addWifi(Wifi wifi) {
        try {
            commonReposity.insert2mysql(wifi, "wifi");
            return true;
        } catch (Exception e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
            return false;
        }
    }

    public Wifi getWifi(Long id) {
        try {
            return commonReposity.query("select * from wifi where id = ? ",
                    ps -> ps.setLong(1, id), Wifi.class)
                    .stream().findAny().orElse(null);
        } catch (Exception e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
            return null;
        }
    }
}
