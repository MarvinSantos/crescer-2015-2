
/* exercício 1 */
/* função bem me quer, mal me quer... */
function daisyGame(numeroDePetalas){

  var resto = numeroDePetalas % 2;

  if ( resto === 1 ){
    return console.log('Love Me');
  }else {
    return console.log('Love Me Not');
  }
}




/* exercício 2 */
/*função que retorna o maior texto dentro de um array de strings*/
function maiorTexto(textos){
  var auxiliar = textos[0];
  for (i = 1 ; i < textos.length; i++){
    var texto = textos[i];
    if (texto.length > auxiliar.length){
      auxiliar = texto;
    }
  }
  return console.log(auxiliar);
}




/* exercício 3 */
/* Imprime isntrutores */
function imprime(nomes, funcao){
  if(typeof funcao === 'function'){
    for(i = 0; i < nomes.length ; i++){
      funcao(nomes[i]);
    }
  }else{
    console.log('type error: ' + typeof funcao + ' is not a function' );
  }
}
/*chamando a função imprime instrutores*/
imprime(['bernardo','nunes','dudu','ben-hur','fabrício','zanatta'],(function funcaoInterna(instrutor){
  console.log('olá querido instrutor:', instrutor);
}));



/* exercício 4 */
/* função não recursiva para calcular a noma de n numeros da sequencia de fibonacci */
function fiboSum(n){
  var seq = 0,soma = 1;
  var numero1 = 0, numero2 = 1;
  for(i = 0; i < n; i++){
    soma = soma + seq;
    seq = numero1 + numero2;
    numero1 = numero2;
    numero2 = seq;

  }
  return soma;
}





/* exercício 5 */
/* função que retorna o numero de uma coluna */
function excelis(coluna){
    var indice = 0;
    if(coluna.length === 1){
      indice = coluna.toUpperCase().charCodeAt(0) - 64;
    }else{
      for (var i = 0; i < coluna.length; i++) {
          indice = indice * 26 + coluna.toUpperCase().charCodeAt(i) - 64;
      }
    }
    return indice;
}
