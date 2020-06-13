##If, If else with true/false and NOT
Test: 
```
FLOAT V_0;
V_0 = 2.1;

FLOAT V_1;
V_1 = 4.2;

IF (!false) {
    IF(!true){
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
@strpd = constant [4 x i8] c"%f\0A\00"
define i32 @main() nounwind{
    %V_0 = alloca double
    store double 2.1, double* %V_0
    %V_1 = alloca double
    store double 4.2, double* %V_1
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
    %7 = load double, double* %V_0
    %8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %7)
    br label %end_else_2

else_2:
    %9 = load double, double* %V_1
    %10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %9)
    br label %end_else_2

end_else_2:
    %11 = load double, double* %V_0
    %12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %11)
    br label %end_else_1

else_1:
    %13 = load double, double* %V_1
    %14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %13)
    br label %end_else_1

end_else_1:
    ret i32 0 
}

```

Wynik po uruchomieniu: 
```
4.200000
2.100000
```
