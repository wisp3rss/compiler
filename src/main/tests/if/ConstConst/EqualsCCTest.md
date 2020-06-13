##If, If else
Test: 
```
INT V_0;
V_0 = 2;

INT V_1;
V_1 = 4;

IF (1==1) {
    IF(2!=5){
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
    %1 = icmp eq i32 1, 1
    br i1 %1, label %if_1, label %else_1

if_1:
    %2 = icmp ne i32 2, 5
    br i1 %2, label %if_2, label %else_2

if_2:
    %3 = load i32, i32* %V_0
    %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %3)
    br label %end_else_2

else_2:
    %5 = load i32, i32* %V_1
    %6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %5)
    br label %end_else_2

end_else_2:
    %7 = load i32, i32* %V_0
    %8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %7)
    br label %end_else_1

else_1:
    %9 = load i32, i32* %V_1
    %10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %9)
    br label %end_else_1

end_else_1:
    ret i32 0 
}
```

Wynik po uruchomieniu: 
```
2
2
```