// public class ElfoNoturno extends Elfo
ElfoNoturno.prototype = Object.create(Elfo.prototype);

function ElfoNoturno(options) {
  // super(nome, flechas);
  //Elfo.call(this, nome, flechas);
  Elfo.apply(this, arguments);
  // Não funciona:
  // Elfo(nome, flechas);
}

// override
ElfoNoturno.prototype.atirarFlecha = function() {
  // super.atirarFlecha();
  Elfo.prototype.atirarFlecha.apply(this, arguments);
  console.log('novo atirar flecha');
};

// static
ElfoNoturno.mediaDeAlturaDosElfosNoturnos = function() {
  return 2.15;
};