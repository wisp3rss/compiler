##Operacje arytmetyczne
###Double
Test:
```
a = 5.12;
b = 3.6283;

a = a - b;
PRINT a;

a = a * 3.1;
PRINT a;

b = 9.9 / b;
PRINT b;
```

W pliku result.ll:
```llvm
 declare i32 @printf(i8*, ...)
 declare i32 @scanf(i8*, ...)
 declare i8* @__strcpy_chk(i8*, i8*, i64) #1
 @strpi = constant [4 x i8] c"%d\0A\00"
 @strpd = constant [4 x i8] c"%f\0A\00"
 @strs = constant [3 x i8] c"%d\00"
 @.strbool = private unnamed_addr constant [4 x i8] c"%u\0A\00"
 @.strdouble = private unnamed_addr constant [4 x i8] c"%lf\00"
 @.stringScan = private unnamed_addr constant [3 x i8] c"%s\00"
 @.stringPrint = private unnamed_addr constant [4 x i8] c"%s\0A\00"
 define i32 @main() nounwind{
 	%a = alloca double
 	%b = alloca double
 	store double 5.12, double* %a
 	store double 3.6283, double* %b
 	%1 = load double, double* %a
 	%2 = load double, double* %b
 	%3 = fsub double %1, %2
 	store double %3, double* %a
 	%4 = load double, double* %a
 	%5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %4)
 	%6 = load double, double* %a
 	%7 = fmul double %6, 3.1
 	store double %7, double* %a
 	%8 = load double, double* %a
 	%9 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %8)
 	%10 = load double, double* %b
 	%11 = fdiv double 9.9, %10
 	store double %11, double* %b
 	%12 = load double, double* %b
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