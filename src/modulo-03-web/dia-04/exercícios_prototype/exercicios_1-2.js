

String.prototype.palindromo = function(){
  var reverso = this.split('').reverse().join('');
  return this.split('').join('') === reverso;
}

Date.prototype.bissexto = function(){
  var  ehBissexto = ((this.getFullYear() % 100 !== 0 )&&((this.getFullYear() % 4 === 0) || (this.getFullYear() % 400 === 0))) ? true : false;
  return ehBissexto;
}
