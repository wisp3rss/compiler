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
 define i32 @main() nounwind{
     %V_0 = alloca i32
     %V_1 = alloca i32
     store i32 5, i32* %V_0
     store i32 3, i32* %V_1
     ret i32 0 
    }
 ```