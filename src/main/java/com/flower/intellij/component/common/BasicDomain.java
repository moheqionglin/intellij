package com.flower.intellij.component.common;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class BasicDomain {

    private Long id;
    private Timestamp createTime;
    private Timestamp updateTime;
}
