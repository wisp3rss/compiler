##If, If else
Test: 
```
INT V_0;
READ V_0;

INT V_1;
V_1 = 4;

IF ( V_0 + 5 == V_1 - 5) {
    PRINT V_0;
}
ELSE {
    PRINT V_1;
}
```

W pliku result.ll:
```llvm
declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
define i32 @main() nounwind{
    %V_0 = alloca i32
    %1 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i64 0, i64 0), i32* %V_0)
    %V_1 = alloca i32
    store i32 4, i32* %V_1
    %math_var_0 = alloca i32
    %2 = load i32, i32* %V_0
    %3 = add i32 %2, 5
    store i32 %3, i32* %math_var_0
    %math_var_1 = alloca i32
    %4 = load i32, i32* %V_1
    %5 = sub i32 %4, 5
    store i32 %5, i32* %math_var_1
    %6 = load i32, i32* %math_var_0
    %7 = load i32, i32* %math_var_1
    %8 = icmp eq i32 %6, %7
    br i1 %8, label %if_1, label %else_1

if_1:
    %9 = load i32, i32* %V_0
    %10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %9)
    br label %end_else_1

else_1:
    %11 = load i32, i32* %V_1
    %12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %11)
    br label %end_else_1

end_else_1:
    ret i32 0 
}
```

podajemy wartość z klawiatury: `-6`

Wynik po uruchomieniu: 
```
-6
```