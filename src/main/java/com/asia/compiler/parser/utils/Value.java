package com.asia.compiler.parser.utils;

import com.asia.compiler.common.utils.Type;

public class Value{
    public String name;
    public Type type;
    public Value( String name, Type type ){
        this.name = name;
        this.type = type;
    }
}