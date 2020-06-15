##If, If else with two variables, operations: ==, !=
Test: 
```
INT a;
a = 2;

INT b;
b = 4;

IF (a != b) {           #true
    PRINT a;              #2
    IF(a == b){         #false
        PRINT a;
    }
    ELSE {
        PRINT b;          #4
    }
}
ELSE {
    PRINT b;
}
```

W pliku result.ll:
```llvm
declare i32 @printf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
define i32 @main() nounwind{
    %a = alloca i32
    store i32 2, i32* %a
    %b = alloca i32
    store i32 4, i32* %b
    %1 = load i32, i32* %a
    %2 = load i32, i32* %b
    %3 = icmp ne i32 %1, %2
    br i1 %3, label %if_1, label %else_1

if_1:
    %4 = load i32, i32* %a
    %5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %4)
    %6 = load i32, i32* %a
    %7 = load i32, i32* %b
    %8 = icmp eq i32 %6, %7
    br i1 %8, label %if_2, label %else_2

if_2:
    %9 = load i32, i32* %a
    %10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %9)
    br label %end_else_2

else_2:
    %11 = load i32, i32* %b
    %12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %11)
    br label %end_else_2

end_else_2:
    br label %end_else_1

else_1:
    %13 = load i32, i32* %b
    %14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %13)
    br label %end_else_1

end_else_1:
    ret i32 0 
}
```

Wynik po uruchomieniu: 
```
2
4
```