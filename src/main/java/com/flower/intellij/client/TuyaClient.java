package com.flower.intellij.client;

import com.flower.intellij.button.Button;
import com.flower.intellij.button.Status;
import com.tuya.smart.TuyaCloudClient;
import com.tuya.smart.config.ClientConfig;
import org.springframework.stereotype.Service;

@Service
public class TuyaClient {

    private TuyaCloudClient tuyaCloudClient = null;

    public TuyaClient() {
        tuyaCloudClient = new TuyaCloudClient("", "", "", new ClientConfig());
    }

    public boolean startButton(Button button) {
        return true;
    }

    public boolean stopButton(Button button) {
        return true;
    }

    public Status checkButtonStatus(Button button) {
        return Status.BROKEN;
    }
}
