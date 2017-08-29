package com.flower.intellij.component.wifi;

import com.flower.intellij.component.button.Status;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wifi")
public class WifiController {

    @Autowired
    private WifiRepository wifiRepository;

    @GetMapping(path = "/getlist")
    public List<Wifi> getWifiList() {
        return wifiRepository.getWifiList();
    }

    @PutMapping(produces = "application/json")
    public boolean addWifi(@RequestBody Wifi wifi) {
        return wifiRepository.addWifi(wifi);
    }

    @GetMapping
    public Status getWifiStatus(@RequestParam Long id) {
        Wifi wifi = wifiRepository.getWifi(id);
        if (Objects.isNull(wifi)) {
            return null;
        }
        return wifi.getStatus();
    }
}
