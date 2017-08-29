package com.flower.intellij.component.wifi;

import com.flower.intellij.component.button.Button;
import com.flower.intellij.component.button.Status;
import com.flower.intellij.component.common.Instance;
import java.util.List;
import lombok.Data;

@Data
public class Wifi extends Instance {

    private Status status;
    private List<Button> buttons;
    private String location;

}
