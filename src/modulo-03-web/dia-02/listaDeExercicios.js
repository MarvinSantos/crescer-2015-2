var clubes = [
  {
    nome: 'Arsenal',
    fundacao: new Date(1886, 0, 1),
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Manchester United',
    fundacao: new Date(1878, 0, 1),
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    fundacao: new Date(1892, 2, 15),
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
    fundacao: new Date(1905, 2, 10),
    titulos: [
      { desc: 'Nacionais', qtd: 5 },
      { desc: 'Continentais', qtd: 1 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }
];
                        // EXERCICIO 1

//criar função auxiliar para ordenar o array para evitar duplocação de codigo


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

// com console.log utilizar concat() "arreiClubes.concat().sort()" ou
// utilizar o terceiro parametro da função dentro do sort como o array que sera ordenado


                              // EXERCICIO 2

// utilizar reduce()
//criar função auxiliar
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
//utilizar filter
//retorna apenas os times com qtd de titulos nacionais maior do que 18
function apenasOsMelhores(arreiClubes){
  var times = [];
  for(var i = 0,len = arreiClubes.length; i < len ; i++ ){
    if(arreiClubes[i].titulos[0].qtd > 18){
      times.push(arreiClubes[i]);
    }
  }
  return times;
};



            //EXERCÍCIO 4
//media de idade dos clubes

function calcularIdadeMedia(arreiClubes){
  var soma = arreiClubes.reduce(function(acumulador,clube){
    var data = new Date().getFullYear();
    return acumulador + data - clube.fundacao.getFullYear();
  },0);
  return soma / arreiClubes.length;
};
