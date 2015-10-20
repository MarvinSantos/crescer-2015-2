
function Basket(){
  this.itens = [];
};

Basket.prototype.adcionarItem = function(item){
  this.itens.push(item);
};

Basket.prototype.removerItem = function(skuPassado){
  var itemParaRemover = this.itens.filter(function(elem){
    return elem.sku === skuPassado;
  });
  var index = itemParaRemover.indexOf();
  this.itens.splice(index,1);
};

function Item(sku,quantidade,descricao,valorUnitario){
  this.sku = sku;
  this.quantidade = quantidade;
  this.descricao = descricao;
  this.valorUnitario = valorUnitario;
}
