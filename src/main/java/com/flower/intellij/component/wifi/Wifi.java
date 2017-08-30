package com.flower.intellij.component.wifi;

import com.flower.intellij.component.button.Button;
import com.flower.intellij.component.common.BasicDomain;
import java.util.List;
import lombok.Data;

@Data
public class Wifi extends BasicDomain {

    private String status;
    private List<Button> buttons;
    private String location;

}
