
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
