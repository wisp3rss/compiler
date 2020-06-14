##Example Test
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