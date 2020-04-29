package com.asia.compiler.common.model;

import com.asia.compiler.common.utils.Instructions;
import com.asia.compiler.common.utils.MathArgType;
import com.asia.compiler.common.utils.Type;
import io.vavr.Tuple2;
import lombok.Value;

@Value
public class IntermediateObject<T> {

    Instructions instructions;
    Type type;
    String v1;
    String v2;
    T val;
    MathArgType mathArgType;
    Tuple2<Object, Object> mathArgs;
}
