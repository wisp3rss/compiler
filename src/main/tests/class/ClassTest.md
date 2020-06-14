##Class Test
Test: 
```
INT a;
BOOL b;

struct SFoo{
    INT a;
}

class CFoo{
    INT a;
    BOOL b;
}

class CFoo2{
    INT a;
    
    SFoo sfoo = new struct SFoo();
    
    CFoo cfoo = new class CFoo();

    func INT getFoo(INT a){
        return a;
    }
}

CFoo cfoo = new class CFoo();
cfoo.a;
b = cfoo.b;

CFoo2 cfoo2 = new class CFoo2();
a = cfoo2.a;                                         #blad
                                     
cfoo2.sfoo;
cfoo2.sfoo.a;

a = cfoo2.cfoo.a;

a = getFoo(3);

a = cfoo2.a + getFoo(3);
a = foo.a + foo2.a;

IF(cfoo2.a >= 0){}
IF(getFoo(3) != cfoo2.a){}

```

W pliku result.ll:
```llvm

```

Wynik po uruchomieniu: 
```

```