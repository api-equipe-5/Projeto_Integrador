using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO.Compression;
using System.IO;
using ZipFile = System.IO.Compression.ZipFile;
using System.Data.OleDb;
using System.Data;

namespace TesteAPI
{
    class Program : Conversao
    {
        //Para usar a classe ZipFile, você deve fazer referência ao assembly System.IO.Compression.FileSystem em seu projeto.
        // MAP PATH PESQUISAR - Open file 
        // Se eu fosse deixar para ler ou criar alguma pasta dentro do disco do cliente, teria que deixar um watch dog o tempo todo
        // alem disso poderia dar muito erro
        static void Main(string[] args)
        {

            string path = @"c:\Teste"; // Esse é o nome do diretorio que vai ser criado No disco local
            string zipPath = @"C:\Users\Agostin\Desktop\FATEC - Banco de Dados\SHAPE_3518305.zip";
            string PastaFinal = "\\Teste\\VariavelImportante";
            string ZipAreaImovel = @"c:\Teste\AREA_IMOVEL.zip";

            ArquivoZip zip = new ArquivoZip();

            try
            {
                zip.CriarPasta(path);
            }

            catch { }

            Console.WriteLine(Directory.GetFiles(path));


            try
            {
                ZipFile.ExtractToDirectory(zipPath, path); //Extrai os arquivos do zip Shape e manda para o diretorio
            }
            catch { }


            // criar outra pasta para guardar a variavel AREA_IMOVEL
            try
            {
                zip.CriarPasta(PastaFinal);
            }

            catch (Exception e)
            {
                Console.WriteLine("A pasta ja existe", e.ToString());
            }


            try
            {
                ZipFile.ExtractToDirectory(ZipAreaImovel, PastaFinal); //Extrai os arquivos do zip Shape e manda para o diretorio
            }
            catch { }


            Conversao conversao = new Conversao();
            conversao.OpenConnection(constr);
            Console.ReadKey();











        }
    }
}
