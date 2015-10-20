
function Basket(){
  this.itens = [];
};

Basket.prototype.adcionarItem = function(item){
  this.itens.push(item);
};


function Item(sku,quantidade,descricao,valorUnitario){
  this.sku = sku;
  this.quantidade = quantidade;
  this.descricao = descricao;
  this.valorUnitario = valorUnitario;
}
