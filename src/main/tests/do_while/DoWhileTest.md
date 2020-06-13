##simple do while test
Test: 
```
INT V_1;
V_1 = 4;

DO {
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
br label %dowhile_0

dowhile_0:
    %1 = load i32, i32* %V_1
    %2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %1)
    %3 = load i32, i32* %V_1
    %4 = sub i32 %3, 1
    store i32 %4, i32* %V_1
    br label %dowhile_0_c

dowhile_0_c:
    %5 = load i32, i32* %V_1
    %6 = icmp sge i32 %5, 0
    br i1 %6, label %dowhile_0, label %end_dowhile_0

end_dowhile_0:
    ret i32 0 
}
```

Wynik po uruchomieniu: 
```
4
3
2
1
0
```