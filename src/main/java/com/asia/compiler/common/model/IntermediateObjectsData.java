package com.asia.compiler.common.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class IntermediateObjectsData {

    List<IntermediateObject> intermediateObjectList = new ArrayList<>();
    List<IntermediateObject> functionIntermediateObjectList = new ArrayList<>();
}
