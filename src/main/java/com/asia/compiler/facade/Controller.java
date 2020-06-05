package com.asia.compiler.facade;

import com.asia.compiler.common.model.LabelStack;
import com.asia.compiler.generator.Generator;
import com.asia.compiler.parser.Parser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Controller {

    public static void main(String[] args) {
        String filePath = "src/main/resources/langTest.txt";
        String code = readFileAsString(filePath);
        LabelStack labelStack = new LabelStack();

        Parser.of(labelStack).parse(code)
                .map(list -> new Generator(labelStack).generate(list))
                .ifPresent(result ->
                        whenWriteStringUsingBufferedWritter_thenCorrect("src/main/resources/resultTest.ll", result)
                );
    }

    private static String readFileAsString(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    public static void whenWriteStringUsingBufferedWritter_thenCorrect(String fileName, String result) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(result);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
