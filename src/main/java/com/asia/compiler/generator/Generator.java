package com.asia.compiler.generator;

import com.asia.compiler.common.model.IntermediateObject;
import java.util.List;
import lombok.NoArgsConstructor;

@NoArgsConstructor(staticName = "instance")
public class Generator {

    static String header_text = "";
    static int reg = 1;
    String result = "";

    public String generate(List<IntermediateObject> intermediateObjectList) {

        intermediateObjectList.forEach(o -> {
                switch (o.getInstructions()) {
                    case PRINT:
                        result += generatePrint(o);
                        break;
                    case READ:
                        result += generateRead(o);
                        break;
                    case DECLARE:
                        result += generateDefine(o);
                        break;
                }
            }
        );
        return result;
    }

    private String generatePrint(IntermediateObject obj) {
        String main_text = "%" + reg + " = load " + obj.getType().getValue() + ", " + obj.getType().getValue() + "* %" + obj.getV1() + "\n";
        reg++;
        main_text +=
            "%" + reg + " = call " + obj.getType().getValue() + " (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, " + obj.getType()
                .getValue() + " 0, " + obj.getType().getValue() + " 0), " + obj.getType().getValue() + " %" + (reg - 1) + ")\n";
        reg++;
        return main_text;
    }

    private String generateRead(IntermediateObject obj) {
        String main_text =
            "%" + reg + " = call " + obj.getType().getValue() + " (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, " + obj
                .getType().getValue() + " 0, " + obj.getType().getValue() + " 0), " + obj.getType().getValue() + "* %" + obj.getV1() + ")\n";
        reg++;
        return main_text;
    }

    private String generateDefine(IntermediateObject obj){
        String main_text = "%"+obj.getV1()+" = alloca "+ obj.getType().getValue() +"\n";

        return main_text;
    }

}
