String.prototype.palindromo = function() {
  var invertido = this.split('').reverse().join('');
  // ou (cuidado com o vício de usar ==):
  // this == invertido
  return this.toString() === invertido;
};

// Casos de teste
[
  { teste: 'ovo', esperado: true },
  { teste: 'arara', esperado: true },
  { teste: 'rodador', esperado: true },
  { teste: 'não é palindromo', esperado: false },
  { teste: '171', esperado: true },
].forEach(
  function(ct) {
    var res = ct.teste.palindromo();
    console.assert(res === ct.esperado, 'Errooooou! CT:', ct.teste, 'Esperado:', ct.esperado, 'Obtido:', res);
  }
);