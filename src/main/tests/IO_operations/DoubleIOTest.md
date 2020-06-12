##Operaje wejścia-wyjścia
###Double
Test:
```
V_0 = 5.12;

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
@strpd = constant [4 x i8] c"%f\0A\00"
@.strdouble = private unnamed_addr constant [4 x i8] c"%lf\00"
define i32 @main() nounwind{
    %V_0 = alloca double
    store double 5.12, double* %V_0
    %1 = load double, double* %V_0
    %2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %1)
    %3 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.strdouble, i64 0, i64 0), double* %V_0)
    %4 = load double, double* %V_0
    %5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %4)
    ret i32 0 
}
```

podajemy wartość z klawiatury: `6.8808`

Wynik po uruchomieniu: 
```
5.120000
6.880800
```
