// public class CarrinhoDeCompras

function CarrinhoDeCompras(itens) {
  this.itens = itens || [];
};

CarrinhoDeCompras.prototype.adicionar = function(item) {
  this.itens.push(item);
};

CarrinhoDeCompras.prototype.remover = function(sku) {
  this.itens = this.itens.filter(function(item) {
    return item.sku !== sku;
  });
};

CarrinhoDeCompras.prototype.atualizarQuantidade = function(sku, quantidade) {
  
  this.itens.map(function(item) {

    if (item.sku === sku) {
      item.quantidade = quantidade;
    }

    return item;
  });

};

CarrinhoDeCompras.prototype.calcularValorTotal = function() {
  
  var desconto = this.sortearDesconto() ? 0.1 : 0;

  var total = this.itens.reduce(function(soma, elem) {
    return soma + elem.calcularSubTotal();
  }, 0);

  return total -= total * desconto;
};

CarrinhoDeCompras.prototype.sortearDesconto = function() {
  var coin = Math.random();
  var sorte = coin < 0.4;
  return sorte;
};

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