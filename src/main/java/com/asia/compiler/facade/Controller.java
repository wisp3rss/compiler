package com.asia.compiler.facade;

import com.asia.compiler.common.model.IntermediateObject;
import com.asia.compiler.generator.Generator;
import com.asia.compiler.parser.Parser;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Controller {

    public static void main(String[] args) {
        String filePath = "src/main/resources/lang.txt";
        String code = readFileAsString(filePath);

        List<IntermediateObject> intermediateCode = new Parser().parse(code);
        String result = Generator.instance().generate(intermediateCode);
        System.out.println(result);
    }

    private static String readFileAsString(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

}
