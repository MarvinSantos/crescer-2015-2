(function test01() {
  
  var carrinho1 = new CarrinhoDeCompras();
  carrinho1.adicionar(new Item({
    sku: 'novo-sku',
    descricao: 'chocolate 1000k',
    quantidade: 15,
    valorUnitario: 22.00
  }));

  console.assert(carrinho1.itens[0].sku === 'novo-sku', 'Test01');  
})();

(function test02() {
  
  var carrinho2 = new CarrinhoDeCompras([
    new Item({
      sku: 'sku-item-inline',
      descricao: 'chocolate 1000k',
      quantidade: 15,
      valorUnitario: 22.00
    })
  ]);

  console.assert(carrinho2.itens[0].sku === 'sku-item-inline', 'Test02');
})();

(function test03() {
  var carrinho3 = new CarrinhoDeCompras();
  carrinho3.adicionar(new Item({
    sku: 'iPhone 7',
    descricao: 'Celular gigante e caro',
    quantidade: 1,
    valorUnitario: 10000
  }));
  carrinho3.adicionar(new Item({
    sku: 'PS4',
    descricao: 'Videogame gigante e caro',
    quantidade: 2,
    valorUnitario: 2500
  }));
  carrinho3.adicionar(new Item({
    sku: 'iPhone 7',
    descricao: 'Celular gigante e caro',
    quantidade: 1,
    valorUnitario: 10000
  }));

  console.assert(carrinho3.itens[0].sku === 'iPhone 7', 'Test03');
  console.assert(carrinho3.itens[1].sku === 'PS4', 'Test03');
  console.assert(carrinho3.itens[2].sku === 'iPhone 7', 'Test03');
})();

(function test04() {
  var carrinho4 = new CarrinhoDeCompras();
  carrinho4.adicionar(new Item({
    sku: 'iPhone 7',
    descricao: 'Celular gigante e caro',
    quantidade: 1,
    valorUnitario: 10000
  }));
  carrinho4.adicionar(new Item({
    sku: 'PS4',
    descricao: 'Videogame gigante e caro',
    quantidade: 2,
    valorUnitario: 2500
  }));
  carrinho4.adicionar(new Item({
    sku: 'iPhone 7',
    descricao: 'Celular gigante e caro',
    quantidade: 1,
    valorUnitario: 10000
  }));

  console.assert(carrinho4.itens.length === 3, 'Test04');
  carrinho4.remover('iPhone 7');
  console.assert(carrinho4.itens.length === 1, 'Test04');
})();

// Test05
(function test05() {
  var carrinho5 = new CarrinhoDeCompras();
  carrinho5.adicionar(new Item({
    sku: 'iPhone 7',
    descricao: 'Celular gigante e caro',
    quantidade: 1,
    valorUnitario: 10000
  }));
  carrinho5.adicionar(new Item({
    sku: 'PS4',
    descricao: 'Videogame gigante e caro',
    quantidade: 2,
    valorUnitario: 2500
  }));
  carrinho5.adicionar(new Item({
    sku: 'iPhone 7',
    descricao: 'Celular gigante e caro',
    quantidade: 1,
    valorUnitario: 10000
  }));

  carrinho5.atualizarQuantidade('PS4', 5);
  console.assert(carrinho5.itens[1].quantidade === 5, 'test05');
  console.log(carrinho5);
})();