package com.asia.compiler.common.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Type {
    INT("i32", "INT"),
    FLOAT("double", "FLOAT"),
    STRING("i32", "STRING"),
    BOOL("i32", "BOOL"),
    NULL("", ""),
    CLASS_STRUCT("", "class/struct");

    @Getter
    private final String value;
    @Getter
    private final String stringValue;

    @Override
    public String toString() {
        return stringValue;
    }
}
