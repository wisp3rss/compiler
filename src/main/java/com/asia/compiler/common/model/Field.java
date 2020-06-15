package com.asia.compiler.common.model;

import com.asia.compiler.common.utils.Type;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Field {

    String name;
    Type type;
    String classStructName;

    @Override
    public String toString() {
        return type.getStringValue();
    }
}
