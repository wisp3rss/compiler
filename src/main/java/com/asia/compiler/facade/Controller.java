package com.asia.compiler.facade;

import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.generator.Generator;
import com.asia.compiler.parser.Parser;
import java.util.List;

public class Controller {

    public static void main(String[] args) {
        String code = "PRINT V_0";
        List<IntermediateObject> intermediateCode = new Parser().parse(code);
        String result = Generator.instance().generate(intermediateCode);
        System.out.println(result);
    }

}
