function CarrinhoDeComprasChantagista() {
  CarrinhoDeCompras.apply(this, arguments);
};

CarrinhoDeComprasChantagista.prototype = Object.create(CarrinhoDeCompras.prototype);

CarrinhoDeCompras.prototype.forcarCompra = function() {
  if (!this.intervalo) {
    // var self = this;
    // self.itens
    // guardamos o id do intervalo em uma propriedade do objeto (em memória)
    // para poder cancelá-lo posteriormente
    this.intervalo = setInterval(function() {
      this.itens.forEach(function(elem) {
        console.log('antes: ', elem.valorUnitario);
        elem.valorUnitario += elem.valorUnitario * .1;
        console.log('depois: ', elem.valorUnitario);
      });
    }.bind(this), 5000);  
  }
};

CarrinhoDeCompras.prototype.concluirPedido = function() {
  clearInterval(this.intervalo);
  // remover propriedade intervalo do objeto
  delete this.intervalo;
};