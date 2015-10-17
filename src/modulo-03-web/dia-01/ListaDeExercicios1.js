
/* função bem me quer, mal me quer... */
function daisyGame(numeroDePetalas){

  var resto = numeroDePetalas % 2;

  if ( resto === 1 ){
    return console.log('Love Me');
  }else {
    return console.log('Love Me Not');
  }
}




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




/* Imprime isntrutores */
function imprime(nomes, funcao){
  if(typeof funcao !== 'function'){
    alert('o segundo parametro deve ser uma função');
  }
  for(i = 0; i < nomes.length ; i++){
    funcao(nomes[i]);
  }
}
/*chamando a função imprime instrutores*/
imprime(['bernardo','nunes','dudu','ben-hur','fabrício','zanatta'],(function funcaoInterna(instrutor){
  console.log('olá querido instrutor:', instrutor);
}));
