
var data = new Date(2016,0,1);
console.assert(data.bissexto() === true, 'data1');

var data2 = new Date(2015,0,1);
console.assert(data2.bissexto() === false, 'data2 ');

var data3 = new Date(2010,0,1);
console.assert(data3.bissexto() === false, 'data3');

var data4 = new Date(2000, 0,1);
console.assert(data4.bissexto() === true, 'data4');
