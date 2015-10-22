

CarrinhoDeComprasChantagista.prototype = Object.create(Basket.prototype);

function CarrinhoDeComprasChantagista(options){
  Basket.apply(this, arguments);
};



CarrinhoDeComprasChantagista.prototype.forcarCompra = function(){
  if(!this.myTimer){
    var self = this;
    this.myTimer = setInterval(function(){
      self.itens.forEach(function(elem){
        elem.valorUnitario += (elem.valorUnitario*0.1);
        console.log(elem.valorUnitario);
      })
    },5000);
  }
};

CarrinhoDeComprasChantagista.prototype.concluirPedido = function(){
  clearInterval(this.myTimer);
  delete this.myTimer;
};
