//testes utilizados

//arrange
var carro = new Basket();
var cafe = new Item('kkk666', 5 , 'café', 10);
var cafeB = new Item('0909b', 6 , 'café 2', 1);
var refri = new Item('600613', 8 , 'pepsi', 6.4);
var computador = new Item('m4rv1n', 11 , 'pc', 1000);
var celular = new Item('ea7b4', 26 , 'SmartPhone', 1500);
carro.adicionarItem(cafeB);
carro.adicionarItem(cafe);
carro.adicionarItem(refri);
carro.adicionarItem(celular);
//act
var subtotal = carro.itens[0].calcularSubTotal();
console.assert(subtotal === 6, 'Erro Ao calcular sub total do Item');

carro.adicionarItem(computador);
console.assert(carro.itens.length === 5, 'Erro Ao Adicionar Item');

carro.removerItem('m4rv1n');
console.assert(carro.itens.length === 4, 'Erro Ao Remover Item');

carro.atualizarQuantidade('0909b',50);
console.assert(carro.itens[0].quantidade === 50, 'Erro Ao atualizar Quantidade Do Item');

var valorTotal = carro.calcularValorTotal();
console.assert(valorTotal === 39151.2 || Math.floor(valorTotal) === 35236, 'Erro Ao calcular valor total');
