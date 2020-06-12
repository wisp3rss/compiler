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
 define i32 @main() nounwind{
 %V_0 = alloca i32
 %V_1 = alloca i32
 store i32 5, i32* %V_0
 store i32 3, i32* %V_1
 ret i32 0 }
 ```

##Operaje wejścia-wyjścia
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
ret i32 0 }
```

podajemy wartość z klawiatury: `6.8808`

Wynik po uruchomieniu: 
```
5.120000
6.880800
```

##Operacje arytmetyczne
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
ret i32 0 }
```

Wynik po uruchomieniu: 
```
6
30
3
1
```


##If, If else
Test: 
```
INT V_0;
V_0 = 2;

INT V_1;
V_1 = 4;

IF (true) {
    IF(!true){
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
@strpi = constant [4 x i8] c"%d\0A\00"
define i32 @main() nounwind{
%V_0 = alloca i32
store i32 2, i32* %V_0
%V_1 = alloca i32
store i32 4, i32* %V_1
%1 = alloca i32
store i32 1, i32* %1
%2 = load i32, i32* %1
%3 = icmp ne i32 %2, 0
br i1 %3, label %if_1, label %else_1
if_1:
%4 = alloca i32
store i32 0, i32* %4
%5 = load i32, i32* %4
%6 = icmp ne i32 %5, 0
br i1 %6, label %if_2, label %else_2
if_2:
%7 = load i32, i32* %V_0
%8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %7)
br label %end_else_2
else_2:
%9 = load i32, i32* %V_1
%10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %9)
br label %end_else_2
end_else_2:
%11 = load i32, i32* %V_0
%12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %11)
br label %end_else_1
else_1:
%13 = load i32, i32* %V_1
%14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %13)
br label %end_else_1
end_else_1:
ret i32 0 }


```

Wynik po uruchomieniu: 
```
2
4
```

##While 
Test
```
INT V_1;
V_1 = 4;

WHILE (V_1 >= 0) {
    PRINT V_1;
    V_1 = V_1 - 1;
}
```

W pliku result.ll
```
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
store i32 1, i32* %V_0
%V_1 = alloca i32
store i32 4, i32* %V_1
br label %while_0_c
while_0_c:
%1 = load i32, i32* %V_1
%2 = icmp sge i32 %1, 0
br i1 %2, label %while_0, label %end_while_0
while_0:
%3 = load i32, i32* %V_1
%4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %3)
%5 = load i32, i32* %V_1
%6 = sub i32 %5, 1
store i32 %6, i32* %V_1
br label %while_0_c
end_while_0:
ret i32 0 }

```

Wynik po uruchomieniu:
```
4
3
2
1
0
```


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
