##Operaje wejścia-wyjścia
###String
Test:
```
V_0 = "abc";

#----print test----
PRINT V_0;

#----read test----
READ V_0;
PRINT V_0;
```

W pliku result.ll:
```llvm
@.strAssignString_V_0 = private unnamed_addr constant [6 x i8] c"abc\00"
declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
declare i8* @__strcpy_chk(i8*, i8*, i64) #1
@.stringScan = private unnamed_addr constant [3 x i8] c"%s\00"
@.stringPrint = private unnamed_addr constant [4 x i8] c"%s\0A\00"
define i32 @main() nounwind{
    %V_0 = alloca i32
    %tmp_V_0 = alloca [256 x i8]
    store i32 0, i32* %V_0
    %1 = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_V_0, i64 0, i64 0
    %2 = call i8* @__strcpy_chk(i8* %1, i8* getelementptr inbounds ([6 x i8], [6 x i8]* @.strAssignString_V_0, i64 0, i64 0), i64 256)
    %3 = load i32, i32* %V_0
    %4 = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_V_0, i64 0, i64 0
    %5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.stringPrint, i64 0, i64 0), i8* %4)
    %6  = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_V_0, i64 0, i64 0
    %7  = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.stringScan, i64 0, i64 0), i8* %6)
    %8 = load i32, i32* %V_0
    %9 = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_V_0, i64 0, i64 0
    %10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.stringPrint, i64 0, i64 0), i8* %9)
    ret i32 0 
}
```

podajemy wartość z klawiatury: `JFIK`

Wynik po uruchomieniu: 
```
abc
JFIK
```