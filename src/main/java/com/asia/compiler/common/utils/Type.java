package com.asia.compiler.common.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Type {
    INT("i32"),
    FLOAT("double"),
    STRING("i32");

    @Getter
    private String value;
}
