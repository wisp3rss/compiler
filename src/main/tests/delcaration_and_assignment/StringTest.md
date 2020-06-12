##Deklaracja zmiennych i przypisanie wartości
###String
Test:
```
#declaration
STRING V_0;
STRING V_1;

#assigning
V_0 = "ABC";
V_1 = "DEF";
```

W pliku result.ll:
```llvm
@.strAssignString_V_0 = private unnamed_addr constant [6 x i8] c"ABC\00"
@.strAssignString_V_1 = private unnamed_addr constant [6 x i8] c"DEF\00"
declare i8* @__strcpy_chk(i8*, i8*, i64) #1
define i32 @main() nounwind{
    %V_0 = alloca i32
    %tmp_V_0 = alloca [256 x i8]
    store i32 0, i32* %V_0
    %V_1 = alloca i32
    %tmp_V_1 = alloca [256 x i8]
    store i32 0, i32* %V_1
    %1 = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_V_0, i64 0, i64 0
    %2 = call i8* @__strcpy_chk(i8* %1, i8* getelementptr inbounds ([6 x i8], [6 x i8]* @.strAssignString_V_0, i64 0, i64 0), i64 256)
    %3 = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_V_1, i64 0, i64 0
    %4 = call i8* @__strcpy_chk(i8* %3, i8* getelementptr inbounds ([6 x i8], [6 x i8]* @.strAssignString_V_1, i64 0, i64 0), i64 256)
    ret i32 0 
}
```