package com.asia.compiler.generator;

import com.asia.compiler.common.model.IntermediateObject;
import java.util.List;
import lombok.NoArgsConstructor;

@NoArgsConstructor(staticName = "instance")
public class Generator {

    static String header_text = "";
    static int reg = 1;
    String result="";

    public String generate (List<IntermediateObject> intermediateObjectList){

        intermediateObjectList.forEach(o -> result += generatePrint(o));
        return result;
    }

    private String generatePrint (IntermediateObject obj){
        String main_text = "%"+reg+" = load i32, i32* %"+obj.getV1()+"\n";
        reg++;
        main_text += "%"+reg+" = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 %"+(reg-1)+")\n";
        reg++;
        return main_text;
    }

}
