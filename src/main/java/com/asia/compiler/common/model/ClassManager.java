package com.asia.compiler.common.model;

import com.asia.compiler.common.utils.Type;
import com.asia.compiler.parser.gen.langParser.DefineContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class ClassManager {

    Map<String, Map<String, List<Function>>> classMap;      //mapa nazwaKlasy -> mape <nazwaFunkcji, listaFunkcji>, listaFunkcji przechowuje wszystkie warianty danej nazwy (przeladowania)
    String currentDefClass;
    Map<String, List<Field>> structMap;                     //mapa nazwaStruktury -> liste argumentow
    Boolean isInFunction;
    Map<String, List<Function>> allFunctionMap;

    public ClassManager() {
        classMap = new HashMap<>();
        classMap.put("Main", new HashMap<>());
        currentDefClass = "Main";
        structMap = new HashMap<>();
        structMap.put("Main", new ArrayList<>());
        isInFunction = false;
        allFunctionMap = new HashMap<>();
    }

    public Type getType(DefineContext ctx) {
        if (ctx.DEF_INT() != null) {
            return Type.INT;
        } else if (ctx.DEF_FLOAT() != null) {
            return Type.FLOAT;
        } else if (ctx.DEF_BOOL() != null) {
            return Type.BOOL;
        } else if (ctx.DEF_STRING() != null) {
            return Type.STRING;
        }
        return Type.NULL;
    }

    public void setCurrentDefClass(String currentDefClass) {
        this.currentDefClass = currentDefClass;
        classMap.put(currentDefClass, new HashMap<>());
    }
}
