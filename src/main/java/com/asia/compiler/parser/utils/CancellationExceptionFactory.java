package com.asia.compiler.parser.utils;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class CancellationExceptionFactory {

    public static void throwCancellationException(ParserRuleContext ctx, String message) {
        ctx.exception = new RecognitionException(message, null, null, ctx);
        throw new ParseCancellationException(message);
    }

}
