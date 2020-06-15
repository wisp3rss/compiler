#Handling variable in fuction
##Test 1: 
```
func INT getFoo(){
    return a;
}
```

Wynik po uruchomieniu: 
```
Error: Undeclared return value:a
```

##Test 2: 
```
func INT getFoo(INT a){
    return a;
}
```

Wynik po uruchomieniu: 
```
BUILD SUCCESSFUL in 0s
```

##Test3: 
```
func INT getFoo(INT a){
    INT a;
    return a;
}
```

Wynik po uruchomieniu: 
```
Error: Variable a already defined.
```

##Test 3: 
```
INT a;

func INT getFoo(){
    return a;
}
```

Wynik po uruchomieniu: 
```
BUILD SUCCESSFUL in 0s
```