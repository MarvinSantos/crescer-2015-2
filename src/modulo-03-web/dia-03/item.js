function Item(sku,quantidade,descricao,valorUnitario){
  this.sku = sku;
  this.quantidade = quantidade;
  this.descricao = descricao;
  this.valorUnitario = valorUnitario;
}


Item.prototype.calcularSubTotal = function(){
  return this.quantidade * this.valorUnitario;
};
