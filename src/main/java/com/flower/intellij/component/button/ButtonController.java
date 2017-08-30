package com.flower.intellij.component.button;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/button")
public class ButtonController {

    @PutMapping
    public boolean addButton(@RequestParam Long wifiId, @RequestBody Button button) {

        return true;
    }

    public boolean getButtonStatus(Button button) {
        return true;
    }
}
