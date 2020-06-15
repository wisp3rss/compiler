package com.asia.compiler.common.model;

import com.asia.compiler.common.utils.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class VariableMap {

    Map<String, Type> variableTypesMap = new HashMap<>(); //mapa zbiorcza wszystkich zmiennych
    List<HashMap<String, Type>> variableMapsList; //lista map zmiennych  z rozroznieniem na poziomy
    int level;

    public VariableMap() {
        HashMap<String, Type> firstLevel = new HashMap<>();
        variableMapsList = new ArrayList<>();
        variableMapsList.add(firstLevel);
        level = 0;
    }

    public void incrementLevel() {
        level += 1;
        HashMap<String, Type> nextLevel = new HashMap<>();
        variableMapsList.add(nextLevel);
    }

    public void decrementLevel() {
        if (level > 0) {
            level -= 1;

            HashMap<String, Type> lastLevel = variableMapsList.get(variableMapsList.size() - 1);
            lastLevel.keySet().forEach(o -> variableTypesMap.remove(o));
            variableMapsList.remove(variableMapsList.size() - 1);
        }
    }

    public void addVariable(String name, Type t) {
        variableTypesMap.put(name, t);
        variableMapsList.get(level).put(name, t);
    }

}
