##If, If else
Test: 
```
INT V_0;
V_0 = 2;

INT V_1;
V_1 = 4;

IF (true) {
    IF(false){
        PRINT V_0;
    }
    ELSE {
        PRINT V_1;
    }
    PRINT V_0;
}
ELSE {
    PRINT V_1;
}
```

W pliku result.ll:
```llvm
declare i32 @printf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
define i32 @main() nounwind{
    %V_0 = alloca i32
    store i32 2, i32* %V_0
    %V_1 = alloca i32
    store i32 4, i32* %V_1
    %1 = alloca i32
    store i32 1, i32* %1
    %2 = load i32, i32* %1
    %3 = icmp ne i32 %2, 0
    br i1 %3, label %if_1, label %else_1

if_1:
    %4 = alloca i32
    store i32 0, i32* %4
    %5 = load i32, i32* %4
    %6 = icmp ne i32 %5, 0
    br i1 %6, label %if_2, label %else_2

if_2:
    %7 = load i32, i32* %V_0
    %8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %7)
    br label %end_else_2

else_2:
    %9 = load i32, i32* %V_1
    %10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %9)
    br label %end_else_2

end_else_2:
    %11 = load i32, i32* %V_0
    %12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %11)
    br label %end_else_1

else_1:
    %13 = load i32, i32* %V_1
    %14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %13)
    br label %end_else_1

end_else_1:
    ret i32 0 
}


```

Wynik po uruchomieniu: 
```
4
2
```