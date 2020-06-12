##Operacje arytmetyczne
###Int
Test:
```
V_0 = 5;
V_1 = 3;

V_1 = V_1 + 3;
PRINT V_1;

V_1 = V_1 * V_0;
PRINT V_1;

V_1 = 90 / V_1;
PRINT V_1;

V_0 = 3 % 2;
PRINT V_0;
```

W pliku result.ll:
```llvm
declare i32 @printf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
define i32 @main() nounwind{
    %V_0 = alloca i32
    %V_1 = alloca i32
    store i32 5, i32* %V_0
    store i32 3, i32* %V_1
    %1 = load i32, i32* %V_1
    %2 = add i32 %1, 3
    store i32 %2, i32* %V_1
    %3 = load i32, i32* %V_1
    %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %3)
    %5 = load i32, i32* %V_1
    %6 = load i32, i32* %V_0
    %7 = mul i32 %5, %6
    store i32 %7, i32* %V_1
    %8 = load i32, i32* %V_1
    %9 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %8)
    %10 = load i32, i32* %V_1
    %11 = sdiv i32 90, %10
    store i32 %11, i32* %V_1
    %12 = load i32, i32* %V_1
    %13 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %12)
    %14 = sub i32 3, 2
    store i32 %14, i32* %V_0
    %15 = load i32, i32* %V_0
    %16 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %15)
    ret i32 0 
}
```

Wynik po uruchomieniu: 
```
6
30
3
1
```

######Pozostałe operacje arytmetyczne działają analogicznie do powyższych przykładów.