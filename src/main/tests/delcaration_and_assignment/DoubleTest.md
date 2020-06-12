##Deklaracja zmiennych i przypisanie wartości
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
define i32 @main() nounwind{
    %V_0 = alloca double
    %V_1 = alloca double
    store double 5.12, double* %V_0
    store double 3.6283, double* %V_1
    ret i32 0 
}
```