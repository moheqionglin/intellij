package com.flower.intellij.button;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ButtonController {

    public boolean setButtonInfo(Button button) {
        return true;
    }

    public boolean getButtonStatus(Button button) {
        return true;
    }
}
