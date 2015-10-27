### Formas de se chamar uma função:

Função:

```
var soma = function() {
  for (var i = 0, soma = 0; i < arguments.length;i++) {
    soma+=arguments[i];
  }
  return soma;
}
```

Podemos chamá-la destas formas:

1. soma(1,2,3); // 6
2. soma.call(this, 1,2,3); // 6
3. soma.apply(this, [1,2,3]); // 6
4. soma.call(this, [1,2,3]); // Cuidado! vai retornar "01,2,3"