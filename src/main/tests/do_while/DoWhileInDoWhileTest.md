##simple do while test
Test: 
```
INT V_1;
V_1 = 4;

INT V_2;
V_2 = 1;

INT V_0;
V_0 = 0;

DO {
    DO{
        PRINT V_0;
        V_2 = V_2 - 1;
    }
    WHILE (V_2 > 0);

    PRINT V_1;
    V_1 = V_1 - 1;
}
WHILE (V_1 >= 0);
```

W pliku result.ll:
```llvm
declare i32 @printf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
define i32 @main() nounwind{
    %V_1 = alloca i32
    store i32 4, i32* %V_1
    %V_2 = alloca i32
    store i32 1, i32* %V_2
    %V_0 = alloca i32
    store i32 0, i32* %V_0
    br label %dowhile_1

dowhile_1:
    br label %dowhile_2

dowhile_2:
    %1 = load i32, i32* %V_0
    %2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %1)
    %3 = load i32, i32* %V_2
    %4 = sub i32 %3, 1
    store i32 %4, i32* %V_2
    br label %dowhile_2_c

dowhile_2_c:
    %5 = load i32, i32* %V_2
    %6 = icmp sgt i32 %5, 0
    br i1 %6, label %dowhile_2, label %end_dowhile_2

end_dowhile_2:
    %7 = load i32, i32* %V_1
    %8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %7)
    %9 = load i32, i32* %V_1
    %10 = sub i32 %9, 1
    store i32 %10, i32* %V_1
    br label %dowhile_1_c

dowhile_1_c:
    %11 = load i32, i32* %V_1
    %12 = icmp sge i32 %11, 0
    br i1 %12, label %dowhile_1, label %end_dowhile_1

end_dowhile_1:
    ret i32 0 
}
```

Wynik po uruchomieniu: 
```
0
4
0
3
0
2
0
1
0
0
```