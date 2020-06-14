package com.asia.compiler.common.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.NoArgsConstructor;

@NoArgsConstructor(staticName = "instance")
public class FunctionMap {

    Map<String, List<Function>> functionMap = new HashMap<>();

}
