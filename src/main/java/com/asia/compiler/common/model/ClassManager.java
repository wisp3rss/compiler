package com.asia.compiler.common.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class ClassManager {
    Map<String, Map<String, List<Function>>> classMap;      //mapa nazwaKlasy -> mape <nazwaFunkcji, listaFunkcji>, listaFunkcji przechowuje wszystkie warianty danej nazwy (przeadowania)
    String currentDefClass;
    Map<String, List<Field>> structMap;                     //mapa nazwaStruktury -> liste argumentow

    public ClassManager(){
        classMap = new HashMap<>();
        classMap.put("Main", new HashMap<>());
        currentDefClass = "Main";
        structMap = new HashMap<>();
    }
}
