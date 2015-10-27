Date.prototype.bissexto = function(utc) {
  var ano = this.getFullYear();
  return (ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0;
};

[
  { teste: new Date(2015, 01, 01), esperado: false },
  { teste: new Date(2016, 01, 01), esperado: true },
  { teste: new Date(2000, 01, 01), esperado: true }
].forEach(
  function(ct) {
    var res = ct.teste.bissexto();
    console.assert(res === ct.esperado, 'Errooooou! CT:', ct.teste, 'Esperado:', ct.esperado, 'Obtido:', res);
  }
);