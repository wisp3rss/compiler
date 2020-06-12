##Operacje arytmetyczne
###Double
Test:
```
V_0 = 5.12;
V_1 = 3.6283;

V_0 = V_0 - V_1;
PRINT V_0;

V_0 = V_0 * 3.1;
PRINT V_0;

V_1 = 9.9 / V_1;
PRINT V_1;
```

W pliku result.ll:
```llvm
 declare i32 @printf(i8*, ...)
 @strpd = constant [4 x i8] c"%f\0A\00"
 define i32 @main() nounwind{
     %V_0 = alloca double
     %V_1 = alloca double
     store double 5.12, double* %V_0
     store double 3.6283, double* %V_1
     %1 = load double, double* %V_0
     %2 = load double, double* %V_1
     %3 = fsub double %1, %2
     store double %3, double* %V_0
     %4 = load double, double* %V_0
     %5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %4)
     %6 = load double, double* %V_0
     %7 = fmul double %6, 3.1
     store double %7, double* %V_0
     %8 = load double, double* %V_0
     %9 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %8)
     %10 = load double, double* %V_1
     %11 = fdiv double 9.9, %10
     store double %11, double* %V_1
     %12 = load double, double* %V_1
     %13 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %12)
     ret i32 0 
}
```

Wynik po uruchomieniu: 
```
1.491700
4.624270
2.728551
```

######Pozostałe operacje arytmetyczne działają analogicznie do powyższych przykładów.