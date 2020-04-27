package com.asia.compiler.parser.listeners;

import static com.asia.compiler.common.utils.Instructions.PRINT;
import static com.asia.compiler.common.utils.Type.INT;

import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.parser.gen.langBaseListener;
import com.asia.compiler.parser.gen.langParser.PrintContext;
import com.asia.compiler.parser.gen.langParser.ReadContext;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IOListener extends langBaseListener {

    private List<IntermediateObject> intermediateObjectList;

    @Override
    public void exitRead(ReadContext ctx) {
        super.exitRead(ctx);
    }

    @Override
    public void exitPrint(PrintContext ctx) {
        //sprawdzic w mapie typ zmiennej
        //jak typ nie w mapie to wywalić błąd

        intermediateObjectList.add(new IntermediateObject<>(PRINT, INT, ctx.NAME().getText(),"",0));
    }
}
