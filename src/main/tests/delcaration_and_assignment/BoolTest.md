##Deklaracja zmiennych i przypisanie wartości
###Bool
Test:
```
#declaration
BOOL V_0;
BOOL V_1;

#assigning
V_0 = true;
V_1 = fale;
```

W pliku result.ll:
```llvm
declare i32 @printf(i8*, ...)
@.strbool = private unnamed_addr constant [4 x i8] c"%u\0A\00"
define i32 @main() nounwind{
    %tmp_V_0 = alloca i32
    %V_0 = alloca i32
    store i32 0, i32* %tmp_V_0
    %tmp_V_1 = alloca i32
    %V_1 = alloca i32
    store i32 0, i32* %tmp_V_1
    store i32 1, i32* %V_0
    store i32 0, i32* %V_1
    %1 = load i32, i32* %V_0
    %2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.strbool, i64 0, i64 0), i32 %1)
    %3 = load i32, i32* %V_1
    %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.strbool, i64 0, i64 0), i32 %3)
    ret i32 0 
}
```