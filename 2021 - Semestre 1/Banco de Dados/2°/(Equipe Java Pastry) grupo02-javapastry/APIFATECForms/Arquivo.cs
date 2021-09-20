using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO.Compression;
using System.Data;

namespace APIFATECForms
{
    class Arquivo : ConexaoDados
    {


        public void CriarPasta(string Pasta)
        {
            // seu eu criar um metodo que ja inicializa criando todas as pastas ficaria dificil pra conseguir extrair tudo
            if (Directory.Exists(Pasta))
            {
            }
            else
            {
                Directory.CreateDirectory(Pasta);
                Console.WriteLine("\nFoi gerada a pasta {0} dentro do projeto - {1}.", Pasta, Directory.GetCreationTime(Pasta));
            }
        }

        public void ExtrairArquivo(string zipPath, string extractPath)
        {
            ZipFile.ExtractToDirectory(zipPath, extractPath);
        }

        public void DeletarArquivos(string pasta)
        {
            System.IO.DirectoryInfo di = new DirectoryInfo(pasta);

            foreach (FileInfo file in di.GetFiles())
            {
                file.Delete();
            }
        }

        public void DeletarArquivos2(string pasta)
        {
            System.IO.DirectoryInfo di = new DirectoryInfo(pasta);

            foreach (FileInfo file in di.GetFiles())
            {
                if (file.Extension == ".zip")
                {
                    file.Delete();
                }

            }

        }

        public bool VerificaSeExisteArquivoX(DataTable sourceDataTable, string ExcelFileName)
        {
            string excelfileName  = ExcelFileName;
            bool retorno;

            if (File.Exists(excelfileName) == true)
            {
                Console.WriteLine("Já existe esse arquivo");
                retorno = false;
            }
            else
            {
                retorno = true;
                //GenerateExcel(sourceDataTable, ExcelFileName);
            }
            return retorno;
        }

        




    }
}
