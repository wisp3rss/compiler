package com.asia.compiler.common.model;

import com.asia.compiler.common.utils.Type;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(staticName = "empty")
public class Function {

    String funcName;
    Type funcType;
    List<Type> argsType;
    List<String> argsName;
}
