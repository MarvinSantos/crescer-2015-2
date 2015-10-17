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
