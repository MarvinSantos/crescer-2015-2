

String.prototype.palindromo = function(){
  var reverso = this.split('').reverse().join('');
  return this.toString() === reverso;
}

Date.prototype.bissexto = function(){
  return ((this.getFullYear() % 100 !== 0 && this.getFullYear() % 4 === 0) || (this.getFullYear() % 400 === 0));

}
