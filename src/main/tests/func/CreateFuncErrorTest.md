##Error handling in creating func
Test: 
```
func INT foo(INT a, BOOL b, FLOAT f){
   return 0;
}

func INT foo(INT a, BOOL b){
    return 0;
}

func INT foo(INT a, FLOAT b){
    return 0;
}

func INT foo(){
   return 0;
}

func INT foo2(){
   return 0;
}

func INT foo2(INT a, FLOAT b){
   return 0;
}

func INT foo2(FLOAT b,INT a){
   return 0;
}

func INT foo2(FLOAT b,INT a){
   return 0;
}
```


Wynik po uruchomieniu: 
```
Error: Function "foo2" with parameters: [FLOAT, INT] in class "Main" already defined.
```

##Correct redeclaration
Test: 
```
func INT foo(){
   INT ax;
   ax = 2;
   return ax;
}

func INT foo(INT a, FLOAT b){
   INT ax;
   ax = 2;
   return ax;
}

func INT foo(FLOAT b,INT a){
   INT ax;
   ax = 2;
   return ax;
}

func INT foo(FLOAT b, INT a, BOOL c){
   INT ax;
   ax = 2;
   return ax;
}
```


Wynik po uruchomieniu: 
```

```