package com.asia.compiler.common.model;

import com.asia.compiler.common.utils.Instructions;
import com.asia.compiler.common.utils.Type;
import lombok.Value;

@Value
public class IntermediateObject<T> {

    private Instructions instructions;
    private Type type;
    private String v1;
    private String v2;
    private T val;
}
