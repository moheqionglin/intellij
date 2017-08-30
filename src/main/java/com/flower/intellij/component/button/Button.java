package com.flower.intellij.component.button;

import com.flower.intellij.component.common.BasicDomain;
import com.flower.intellij.component.common.Status;
import com.flower.intellij.component.device.Device;
import lombok.Data;

@Data
public class Button extends BasicDomain {

    private Status status;
    private Device device;

}
