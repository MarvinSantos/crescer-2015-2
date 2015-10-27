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

function ordenaPorIndice(indice, times) {

  /* Arrow functions
  return clubes.sort(
    (x,y) => x.titulos[indice].qtd < y.titulos[indice].qtd
  );
  */

  var clubes = [];

  times.sort(function(elemEsq, elemDir, clubes) {
    return elemEsq.titulos[indice].qtd < elemDir.titulos[indice].qtd;
  });

  return clubes;
};

// 1A
// Crie uma função chamada ordenaPorNacionais(Array) 
// que recebe o array de clubes e retorna o array ordenado 
// pela quantidade de títulos Nacionais descendente (Z->A).

function ordenaPorNacionais(times) {
  return ordenaPorIndice(0, times);
};

console.log('1A: ', ordenaPorNacionais(clubes.concat()));

// 1B
// Crie uma função chamada ordenaPorContinentais(Array) que recebe o array de clubes e retorna o array ordenado pela quantidade de títulos Continentais descendente (Z->A).
function ordenaPorContinentais(times) {
  return ordenaPorIndice(1, times);
};

console.log('1B: ', ordenaPorContinentais(clubes.concat()));

// 1C
// Crie uma função chamada ordenaPorMundiais(Array) que recebe o array de clubes e retorna o array ordenado pela quantidade de títulos Mundiais descendente (Z->A).

function ordenaPorMundiais(times) {
  return ordenaPorIndice(2, times);
}
console.log('1C: ', ordenaPorMundiais(clubes.concat()));

function somaPorIndice(indice, clubes) {
  // clubes.reduce( (acc, elem) => acc + elem.titulos[0].qtd, 0)
  return clubes.reduce(function(acumulador, elemAtual) {
    return acumulador + elemAtual.titulos[indice].qtd;
  }, 0);
};

// 2A
function somarPorNacionais(clubes) {
  return somaPorIndice(0, clubes);
};

console.log('2A: ', somarPorNacionais(clubes.concat()));

// 2B
function somarPorContinentais(clubes) {
  return somaPorIndice(1, clubes);
};

console.log('2B: ', somarPorContinentais(clubes.concat()));

// 2C
function somarPorTodosTitulos(clubes) {
  /*
  var soma = 0;
  [0,1,2].forEach(function(i) {
    soma += somaPorIndice(i, clubes);
  });
  return soma;
  */
  return somarPorNacionais(clubes)
    + somarPorContinentais(clubes)
    + somaPorIndice(2, clubes);
};

console.log('2C: ', somarPorTodosTitulos(clubes.concat()));

function apenasOsMelhores(clubes) {
  return clubes.filter(function(elem) {
    return elem.titulos[0].qtd > 18;
  });
};

console.log('3: ', apenasOsMelhores(clubes.concat()));

console.log('Antes: ', clubes);

var teams = clubes.map(function(clube) {
  return clube.nome += ' FC', clube;
});

var teams2 = clubes.map(function(clube) {
  return {
    nome: clube.nome + ' 2',
    titulos: clube.titulos
  };
});

console.log('Depois: ', teams);
console.log('Depois Teams 2: ', teams2);

// 4
function calcularIdadeMedia(clubes) {

  var soma = clubes
    .map(function(elem) {
      // projetando as idades
      return new Date().getFullYear() - elem.fundacao.getFullYear();
    })
    .reduce(function(acumulador, elem) {
      return acumulador + elem;
    }, 0);

  return soma / clubes.length;
};

console.log('4: ', calcularIdadeMedia(clubes.concat()));