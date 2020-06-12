##Operaje wejścia-wyjścia
###Int
Test:
```
V_0 = 5;

#----print test----
PRINT V_0;

#----read test----
READ V_0;
PRINT V_0;
```

W pliku result.ll:
```llvm
declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
define i32 @main() nounwind{
    %V_0 = alloca i32
    store i32 5, i32* %V_0
    %1 = load i32, i32* %V_0
    %2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %1)
    %3 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i64 0, i64 0), i32* %V_0)
    %4 = load i32, i32* %V_0
    %5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %4)
    ret i32 0 
}
```

podajemy wartość z klawiatury: `23`

Wynik po uruchomieniu: 
```
5
23
```
