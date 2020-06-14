##Struct Test
Test: 
```
INT a;
BOOL b;

struct SFoo{
    INT a;
}

struct SFoo2{
    INT a;
    BOOL b;
}

SFoo sfoo = new struct SFoo();
sfoo.a;

SFoo2 sfoo2 = new struct SFoo2();
a = sfoo2.a;
b = sfoo2.b;

a = sfoo.a + 2;
a = sfoo.a + sfoo2.a;

IF(!sfoo2.b){}
IF(sfoo.a >= 0){}
IF(sfoo.a != sfoo2.a){}

```

W pliku result.ll:
```llvm

```

Wynik po uruchomieniu: 
```

```