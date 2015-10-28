using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DbFuncionarios
{
    public class BaseDeDados
    {
        public List<Funcionario> Funcionarios
        {
            get; private set;
        }

        public BaseDeDados()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor = new Cargo("Desenvolvedor", 190);
            Cargo analista = new Cargo("Analista", 250);
            Cargo gerente = new Cargo("Gerente", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Lucas Leal", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Jean Pinzon", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Rafael Benetti", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Maurício Borges", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Leandro Andreolli", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Felipe Nervo", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Lucas Kauer", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Eduardo Arnold", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Gabriel Alboy", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = analista;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Carlos Henrique", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = analista;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Margarete Ricardo", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = gerente;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        //A
        public IList<Funcionario> OrdenadosPorCategoria()
        {
            var resultado = Funcionarios.OrderBy(funcionario => funcionario.Cargo.Titulo).ToList();
            return resultado;
        }

        //B
        public IList<Funcionario> BuscarPorNome(string nome)
        {
            var resultado = Funcionarios.Where(funcionario => funcionario.Nome.Contains(nome)).OrderBy(funcionario => funcionario.Nome).ToList();
            return resultado;
        }

        //C
        public IList<dynamic> BuscaRapida(string nome)
        {
            var funcionario = Funcionarios.Where(funcionario2 => funcionario2.Nome == nome)
                                          .Select(x => new {Nome = x.Nome,Titulo = x.Cargo.Titulo});

            return funcionario.ToList<dynamic>();

        }

        //D
        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho?[] turnos)
        {
            var funcionarios = from funcionario in Funcionarios
                               where turnos.Contains(funcionario.TurnoTrabalho)
                               select funcionario;

            return funcionarios.ToList();

        }

        //D de outra forma não funcional

        //public IList<Funcionario> BuscarPorTurno(TurnoTrabalho turno1,TurnoTrabalho turno2 = TurnoTrabalho.Default,TurnoTrabalho turno3 = TurnoTrabalho.Default)
        //{
        //    var funcionario = Funcionarios.Where(funcionario1 => funcionario1.TurnoTrabalho == turno1);
        //    var funcionario2 = Funcionarios.Where(funcionario3 => funcionario3.TurnoTrabalho == turno2);
        //    var funcionario4 = Funcionarios.Where(funcionario5 => funcionario5.TurnoTrabalho == turno3);
        //    funcionario.Concat(funcionario2);
        //    funcionario.Concat(funcionario4);
        //    return funcionario.ToList();

        //}


        //E
        public IList<dynamic> QtdFuncionariosPorTurno()
        {
            var funcionariosAgrupados = (Funcionarios.GroupBy(funcionario => funcionario.TurnoTrabalho)).ToList();

            var query = from funcionario in funcionariosAgrupados
                        select new
                        {
                            Turno = funcionario.Key,
                            Contagem = funcionario.Count()
                        };
            return query.ToList<dynamic>();
        }

        //F
        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            IList<Funcionario> funcionarios = Funcionarios.Where(funcionario => funcionario.Cargo.Equals(cargo)).ToList();

            return funcionarios;
        }


        //G
        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            DateTime dataDeHoje = DateTime.Now;

            IList<Funcionario> funcionarios = Funcionarios.Where(funcionario => 
                                    ((idade - 5) <= (dataDeHoje.Year - funcionario.DataNascimento.Year)) && 
                                    ((dataDeHoje.Year - funcionario.DataNascimento.Year) <= (idade + 5))).ToList();

            return funcionarios;
        }


        //H
        public double SalarioMedio(TurnoTrabalho? turno)
        {
            double media = 0.0;

            if (turno.HasValue)
            {
                IList<Funcionario> funcionarios =  BuscarPorTurno(turno);

                media = (funcionarios.Sum(funcionario => funcionario.Cargo.Salario)) / (funcionarios.Count());
            }
            return media;
        }

        //I
        public IList<Funcionario> AniversariantesDoMes()
        {
            return (Funcionarios.Where(funcionario => funcionario.DataNascimento.Month == DateTime.Now.Month)).ToList();
        }


    }
}
