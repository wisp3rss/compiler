package com.asia.compiler.common.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum Type {
    INT("i32", "INT"),
    FLOAT("double", "FLOAT"),
    STRING("i32", "STRING"),
    BOOL("i32", "BOOL"),
    LOOP("", "");

    @Getter
    private String value;
    private String stringValue;

    @Override
    public String toString() {
        return stringValue;
    }
}
