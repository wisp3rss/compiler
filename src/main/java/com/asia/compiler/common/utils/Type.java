package com.asia.compiler.common.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Type {
    INT("i32"),
    FLOAT("float"),
    STRING("%String");

    @Getter
    private String value;
}
