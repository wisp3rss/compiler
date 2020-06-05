#Projekt 2 cz.1 - Kompilator
Joanna Warchulska
Anna Konieczna

#Struktura projektu
 * Główna klasa w projekcie: `src/main/java/com/asia/compiler/facade/Controller.java`

 * Plik testowy: `src/main/resources/lang.txt`
 
 * Wynik: `src/main/resources/result.ll`

Aby skompilować projekt należy uruchomić metodę main w klasie głównej.
Spowoduje to wygenerowanie wyniku na podstawie danych z pliku testowego.

Plik testowy zawiera przykłady operacji dostępnych w programie.


##Uruchomienie programu:
```bash
lli -force-interpreter result.ll
```

#Przykłady

##Deklaracja zmiennych i przypisanie wartości
###Int
Test:
```
#declaration
INT V_0;
INT V_1;

#assigning
V_0 = 5;
V_1 = 3;
```

W pliku result.ll:

```llvm
declare i32 @printf(i8*, ...)
 declare i32 @scanf(i8*, ...)
 @strpi = constant [4 x i8] c"%d\0A\00"
 @strpd = constant [4 x i8] c"%f\0A\00"
 @strs = constant [3 x i8] c"%d\00"
 @.strdouble = private unnamed_addr constant [4 x i8] c"%lf\00"
 define i32 @main() nounwind{
 %V_0 = alloca i32
 %V_1 = alloca i32
 store i32 5, i32* %V_0
 store i32 3, i32* %V_1
 ret i32 0 }
 ```

###Double
Test:
```
#declaration
FLOAT V_0;
FLOAT V_1;

#assigning
V_0 = 5.12;
V_1 = 3.6283;
```

W pliku result.ll:
```llvm
declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
@.strdouble = private unnamed_addr constant [4 x i8] c"%lf\00"
define i32 @main() nounwind{
%V_0 = alloca double
%V_1 = alloca double
store double 5.12, double* %V_0
store double 3.6283, double* %V_1
ret i32 0 }
```

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
declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
declare i8* @__strcpy_chk(i8*, i8*, i64) #1
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
@.strdouble = private unnamed_addr constant [4 x i8] c"%lf\00"
@.stringScan = private unnamed_addr constant [3 x i8] c"%s\00"
@.stringPrint = private unnamed_addr constant [4 x i8] c"%s\0A\00"
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
ret i32 0 }
```

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
%tmp_V_0 = alloca i32
%V_0 = alloca i32
store i32 0, i32* %tmp_V_0
%tmp_V_1 = alloca i32
%V_1 = alloca i32
store i32 0, i32* %tmp_V_1
store i32 1, i32* %V_0
store i32 0, i32* %V_1
%1 = load i32, i32* %V_0
%2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.strbool, i64 0, i64 0), i32 %1)%3 = load i32, i32* %V_1
%4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.strbool, i64 0, i64 0), i32 %3)ret i32 0 }

```

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
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
@.strdouble = private unnamed_addr constant [4 x i8] c"%lf\00"
define i32 @main() nounwind{
%V_0 = alloca i32
store i32 5, i32* %V_0
%1 = load i32, i32* %V_0
%2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %1)
%3 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i64 0, i64 0), i32* %V_0)
%4 = load i32, i32* %V_0
%5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %4)
ret i32 0 }
```

podajemy wartość z klawiatury: `23`

Wynik po uruchomieniu: 
```
5
23
```

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
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
@.strdouble = private unnamed_addr constant [4 x i8] c"%lf\00"
define i32 @main() nounwind{
%V_0 = alloca double
store double 5.12, double* %V_0
%1 = load double, double* %V_0
%2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %1)
%3 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.strdouble, i64 0, i64 0), double* %V_0)
%4 = load double, double* %V_0
%5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %4)
ret i32 0 }
```

podajemy wartość z klawiatury: `6.8808`

Wynik po uruchomieniu: 
```
5.120000
6.880800
```

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
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
@.strdouble = private unnamed_addr constant [4 x i8] c"%lf\00"
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
ret i32 0 }

```

podajemy wartość z klawiatury: `JFIK`

Wynik po uruchomieniu: 
```
abc
JFIK
```

###Bool
Test:
```
V_0 = true;

#----print test----
PRINT V_0;

#----read test----
READ V_0;
PRINT V_0;
```

W pliku result.ll:
```llvm
//TODO

```


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
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
@.strdouble = private unnamed_addr constant [4 x i8] c"%lf\00"
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
ret i32 0 }
```

Wynik po uruchomieniu: 
```
6
30
3
1
```

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
 declare i32 @scanf(i8*, ...)
 declare i8* @__strcpy_chk(i8*, i8*, i64) #1
 @strpi = constant [4 x i8] c"%d\0A\00"
 @strpd = constant [4 x i8] c"%f\0A\00"
 @strs = constant [3 x i8] c"%d\00"
 @.strdouble = private unnamed_addr constant [4 x i8] c"%lf\00"
 @.stringScan = private unnamed_addr constant [3 x i8] c"%s\00"
 @.stringPrint = private unnamed_addr constant [4 x i8] c"%s\0A\00"
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
 ret i32 0 }
```

Wynik po uruchomieniu: 
```
1.491700
4.624270
2.728551
```

##If, If else
Test: 
```
INT V_0;
V_0 = 2;

INT V_1;
V_1 = 4;

IF (true) {
    IF(true){
        PRINT V_0;
    }
    ELSE {
        PRINT V_1;
    }
    PRINT V_0;
}
ELSE {
    PRINT V_1;
}
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
%V_0 = alloca i32
store i32 2, i32* %V_0
%V_1 = alloca i32
store i32 4, i32* %V_1
%1 = alloca i32
store i32 1, i32* %1
%2 = load i32, i32* %1
%3 = icmp ne i32 %2, 0
br i1 %3, label %if_1, label %end_if_1
if_1:
%4 = load i32, i32* %V_0
%5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %4)
br label %end_if_1
end_if_1:
ret i32 0 }

```

Wynik po uruchomieniu: 
```
2
2
```



######Pozostałe operacje arytmetyczne działają analogicznie do powyższych przykładów.

##Obsługa błędów
####Brak zadeklarowanej zmiennej:
`Variable V_0 undefined.`
####Próba ponownego zadeklarowania już istniejącej zmiennej:
`"Variable V_0  already defined.`
####Podanie wartości innej niż typ zmiennej:
`"Variable V_0 incompatible."`
####Próba operacji na dwóch zniennych różnych typów:
`Incompatible types between V_0 and V_1`
####Próba operacji na zmiennej i stałej różnych typów:
`Cannot cast V_0 with type INT with type FLOAT`

`Cannot cast INT to FLOAT`

`Cannot cast FLOAT to INT`
####Błąd przy próbie wczytania lub wypisania zmiennej:
`Variable V_0 not found.`
___
######Cały program przetestowany został na systemie iOS oraz Linux. 
######Niestety na systemie iOS ze względu na llvm nie działa przypisywanie wartości do stringa (STRINT V_0 = "a")
######Terminal wyświetla błąd: `LLVM ERROR: Tried to execute an unknown external function: __strcpy_chk`
######Pozostałe funkcje działają dla obu systemów.
