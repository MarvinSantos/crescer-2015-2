var clubes = [
  {
    nome: 'Arsenal',
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Manchester United',
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
    titulos: [
      { desc: 'Nacionais', qtd: 5 },
      { desc: 'Continentais', qtd: 1 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }
];
                        // EXERCICIO 1

// exercicio 1.A
function ordenaPorNacionais(arreiClubes){
  return arreiClubes.sort(
      function(elem1,elem2){
        return elem1.titulos[0].qtd < elem2.titulos[0].qtd;
      }
    )
};

// exercicio 1.B
function ordenaPorContinentais(arreiClubes){
  return arreiClubes.sort(
      function(elem1,elem2){
        return elem1.titulos[1].qtd < elem2.titulos[1].qtd;
      }
    )
};

// exercicio 1.C
function ordenaPorMundiais(arreiClubes){
  return arreiClubes.sort(
      function(elem1,elem2){
        return elem1.titulos[2].qtd < elem2.titulos[2].qtd;
      }
    )
};

                              // EXERCICIO 2

// exercicio 2.A
function somarPorNacionais(arreiClubes){
  var soma = 0;
  for( var i = 0, len = arreiClubes.length; i < len ; i++ ){
    soma = soma + arreiClubes[i].titulos[0].qtd;
  }
  return soma;
};


// exercicio 2.B
function somarPorContinentais(arreiClubes){
  var soma = 0;
  for( var i = 0, len = arreiClubes.length; i < len ; i++ ){
    soma = soma + arreiClubes[i].titulos[1].qtd;
  }
  return soma;
};


// exercicio 2.C
function somarPorTodosTitulos(arreiClubes){
  return somarPorNacionais(arreiClubes) + somarPorContinentais(arreiClubes) + somarPorMundiais(arreiClubes);
};

// função criada para auxilio
function somarPorMundiais(arreiClubes){
  var soma = 0;
  for( var i = 0, len = arreiClubes.length; i < len ; i++ ){
    soma = soma + arreiClubes[i].titulos[2].qtd;
  }
  return soma;
};



                //EXERCÍCIO 3
//retorna apenas os times com qtd de titulos nacionais maior do que 18
function apenasOsMelhores(arreiClubes){
  var times = [];
  for(var i = 0,len = arreiClubes.length; i < len ; i++ ){
    if(arreiClubes[i].titulos[0].qtd > 18){
      times.push(arreiClubes[i])
    }
  }
  return times;
}
