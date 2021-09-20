using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO.Compression;
using System.IO;
using ZipFile = ICSharpCode.SharpZipLib.Zip.ZipFile;

namespace TesteAPI
{


    public class ArquivoZip
    {


        internal static void ExtractToDirectory(string zipPath, string path)
        {
            throw new NotImplementedException();
        }

        public void CriarPasta(string path)
        {
            //metodo para criar pasta direto no disco local (C)


            // verifica se a pasta existe
            if (Directory.Exists(path))
            {
                Console.WriteLine("That path exists already.");
                //return; // se eu der return ele fecharia o código, sabendo que já existe uma pasta com esse nome
            }
            else
            {
                // Tenta criar a pasta
                DirectoryInfo DiretorioTeste = Directory.CreateDirectory(path);
                Console.WriteLine("The directory was created successfully at {0}.", Directory.GetCreationTime(path));
            }
        }


    }
}
