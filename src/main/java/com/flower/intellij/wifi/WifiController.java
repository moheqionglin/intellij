package com.flower.intellij.wifi;

import com.flower.intellij.button.Button;
import com.flower.intellij.button.Status;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WifiController {

    public boolean setWifiInfo(Wifi wifi) {
        return true;
    }

    public boolean addButton(Wifi wifi, Button button) {
        return true;
    }

    public Status getWifiStatus(Wifi wifi) {
        return Status.BROKEN;
    }
}
