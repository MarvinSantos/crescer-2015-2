(function test01() {
  var carrinho = new CarrinhoDeComprasChantagista([
    new Item({ sku: 'sku1', descricao: 'ray-ban', valorUnitario: 5 })
  ]);
  carrinho.forcarCompra();
  console.log(carrinho);
})();