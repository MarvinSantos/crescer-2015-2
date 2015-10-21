
function Basket(){
  this.itens = [];
};

Basket.prototype.adicionarItem = function(item){
  this.itens.push(item);
};

Basket.prototype.removerItem = function(skuPassado){
  var itemParaRemover = this.itens.filter(function(elem){
    return elem.sku === skuPassado;
  });
  var index = itemParaRemover.indexOf();
  this.itens.splice(index,1);
};

Basket.prototype.atualizarQuantidade = function(skuPassado, novaQuantidade){
  for(var i = 0,len=this.itens.length;i<len;i++){
    if(this.itens[i].sku === skuPassado){
      this.itens[i].quantidade = novaQuantidade;
    }
  }
};

Basket.prototype.calcularValorTotal = function(){
  var soma = 0;
  for(var i = 0,len=this.itens.length;i<len;i++){
    soma += this.itens[i].calcularSubTotal();
  }
  if(this.jogarMoedaDeDesconto() === true){
    soma = soma - (soma*0.1);
  }
  return soma;
};

Basket.prototype.jogarMoedaDeDesconto = function(){
  var desconto = false;
  if(Math.random() <= 0.4){
    desconto = true;
  }
  return desconto;
};
