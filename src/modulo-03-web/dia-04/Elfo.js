function Elfo(options) {
  options = options || {};
  this.nome = options.nome;
  this.flechas = options.flechas || 42;

  Object.defineProperty(this, 'flechas', {
    writable: false
  });
}

Elfo.prototype.atirarFlecha = function(dwarf) {
  console.log('atirando flecha...');
};