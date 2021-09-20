using System;
using System.Collections.Generic;
using System.Data;
using System.Data.OleDb;
using System.IO;
using System.Linq;
using System.Reflection;

namespace APIFATECForms
{
    class ConexaoDados : Form1
    {
        APIFATECEntities db = new APIFATECEntities();

        object conexaoDadosObjTipoObjClasseConexaoDados = new object();


        static string PastaDaAplicacao = Directory.GetParent(Directory.GetCurrentDirectory()).Parent.FullName;
        static string BasePath = Path.Combine(PastaDaAplicacao, "BasePath");
        //static string dbfFileName = @"C:\Users\Agostin\Desktop\Grupo-JavaPastry-BranchTeste\grupo02-javapastry\APIFATECForms\BasePath\SHAPEFILE_BRASIL\BR_UF_2020.dbf";
        static string dbfFileName = BasePath + @"\BR_MUNICIPIOS_2020\BR_MUNICIPIOS_2020.dbf";

        static string constr = "Provider = VFPOLEDB.1; Data Source =" + Directory.GetParent(dbfFileName).FullName;
        /* a variavel excelfilename tem que vir come o texto que o usario digitou quando buscou um arquivo. Para assim,
           conseguir salvar no banco de acordo com o IBGE, dessa forma, eu consigo deixar o insert no banco automatizado        
         */
        //static string ExcelFileName = @"C:\Users\Agostin\Desktop\Grupo-JavaPastry-BranchTeste\grupo02-javapastry\APIFATECForms\BasePath\SHAPEFILE_BRASIL\" + "arquivo_convertido";
        static string ExcelFileName = BasePath + @"\BR_MUNICIPIOS_2020\" + "BR_Municipios_2020.xlsx";
        int tentativa = 0;

        static Missing mv = Missing.Value;

        List<string> ListaEstadosRegiaoNorte = new List<string>();

        public void OpenConnection(string connectionString)
        {


            try
            {
                using (OleDbConnection connection = new OleDbConnection(connectionString))
                {
                    ;

                    // List<object> ListaTipoObjClasseConexaoDados = new List<object>();
                    //List<ConexaoDados> ListaTipoConexaoDadosClasseConexaoDados = new List<ConexaoDados>(); //Lista da classe ConexaoDados

                    try
                    {
                        connection.Open();
                        Console.WriteLine("ServerVersion: {0} \nDataSource: {1}",
                        connection.ServerVersion, connection.DataSource);
                    }
                    catch (Exception ex)
                    {
                        Console.WriteLine(ex.Message);
                    }
                    // The connection is automatically closed when the
                    // code exits the using block.

                    var sql = "select * from " + Path.GetFileName(dbfFileName) + ";";
                    OleDbCommand cmd = new OleDbCommand(sql, connection);
                    DataTable dt = new DataTable();

                    if (connection.State == ConnectionState.Open)
                    {
                        OleDbDataAdapter da = new OleDbDataAdapter(cmd);
                        Console.Write("Reading database...  ");
                        da.Fill(dt);
                        Console.WriteLine("Completed.");
                    }

                    if (dt != null && dt.Rows.Count > 0)
                    {
                        Arquivo arquivo = new Arquivo();
                        if (arquivo.VerificaSeExisteArquivoX(dt, ExcelFileName) == true)
                        {
                            GenerateExcel(dt, ExcelFileName);
                        }
                        // arquivo.VerificaSeExisteArquivoX(dt, ExcelFileName);
                    }

                    OleDbDataReader dr = cmd.ExecuteReader();

                    while (dr.Read())
                    {
                        // criar um codigo que leia as colunas do excel e preencha o objeto no banco
                        // e não que eu mude a cada insert
                        // pode ser feita um querie no banco que busque os dados referentes as colunas do excel, no qual retorne qual tabela deve ser inserido tudo que estiver preencgido no excel
                        // lembrar de substituir os cracteres especiais por letras e acentos certos

                        //string Cd_uf = dr[0].ToString().Trim();
                        //string Nm_uf = dr[1].ToString().Trim();
                        //string Sigla_uf = dr[2].ToString().Trim();
                        //string Nm_regiao = dr[3].ToString().Trim();

                        if (tentativa < 1)
                        {
                            string cd_mun = dr[0].ToString().Trim();
                            string nm_mun = dr[1].ToString().Trim();
                            string sigla_uf = dr[2].ToString().Trim();
                            string area_km2 = dr[3].ToString().Trim();

                            //int CD_UF = int.Parse(Cd_uf);
                            int Cd_mun = int.Parse(cd_mun);
                            decimal Area_km2 = decimal.Parse(area_km2);

                            BRASIL_MUNICIPIO bRASIL_MUNICIPIO = new BRASIL_MUNICIPIO
                            {
                                cd_mun = Cd_mun,
                                nm_mun = nm_mun,
                                sigla_uf = sigla_uf,
                                área_km2 = Area_km2
                            };

                            try
                            {
                                if (db.BRASIL_MUNICIPIO != null)
                                {
                                    db.BRASIL_MUNICIPIO.Add(bRASIL_MUNICIPIO);
                                    db.SaveChanges();
                                }
                            }
                            catch (Exception ex)
                            {
                                tentativa++;
                                // Console.WriteLine(ex);
                            }
                        }
                        else
                        {
                            break;
                        }


                    }

                    if (connection.State == ConnectionState.Open)
                    {
                        try
                        {
                            connection.Close();
                        }
                        catch { }
                    }

                    /*
                    BR_UF_2020 bR_UF_2020 = new BR_UF_2020
                    {
                        cd_uf = CD_UF,
                        nm_regiao = Nm_regiao,
                        nm_uf = Nm_uf,
                        sigla_uf = Sigla_uf,
                    };

                    try
                    {
                        if(db.BR_UF_2020 != null)
                        {
                            db.BR_UF_2020.Add(bR_UF_2020);
                            db.SaveChanges();
                        }

                    }

                    catch (Exception ex)
                    {
                        Console.WriteLine(ex);
                    }

                    */
                }
            }
            catch (Exception ex)
            {

            }

            List<BR_UF_2020> UFsRegiaoNorte = db.BR_UF_2020.Where(banco => banco.nm_regiao == "Norte").ToList();
            List<BR_UF_2020> UFsRegiaoNordeste = db.BR_UF_2020.Where(banco => banco.nm_regiao == "Nordeste").ToList();
            List<BR_UF_2020> UFsRegiaoCentroOeste = db.BR_UF_2020.Where(banco => banco.nm_regiao == "Centro-oeste").ToList();
            List<BR_UF_2020> UFsRegiaoSudeste = db.BR_UF_2020.Where(banco => banco.nm_regiao == "Sudeste").ToList();
            List<BR_UF_2020> UFsRegiaoSul = db.BR_UF_2020.Where(banco => banco.nm_regiao == "Sul").ToList();
            List<BR_UF_2020> UFsBrasil = db.BR_UF_2020.Where(banco => banco.cd_uf == banco.cd_uf).ToList();

            ListaBrasil = UFsBrasil;
            ListaRegiaoNorte = UFsRegiaoNorte;
            ListaRegiaoNordeste = UFsRegiaoNordeste;
            ListaRegiaoCentroOeste = UFsRegiaoCentroOeste;
            ListaRegiaoSudeste = UFsRegiaoSudeste;
            ListaRegiaoSul = UFsRegiaoSul;



        }
        //return


        public void GenerateExcel(DataTable sourceDataTable, string ExcelFileName)
        {
            // para rodar precisei adicionar referencia a lib objetos do Microsoft Excel 12.0 Object
            Console.Write("Generating Excel File...");
            Microsoft.Office.Interop.Excel.Application excelApp = new Microsoft.Office.Interop.Excel.Application();
            Microsoft.Office.Interop.Excel.Workbook wkb = excelApp.Workbooks.Add(mv);
            Microsoft.Office.Interop.Excel.Worksheet wks = wkb.Sheets[1];

            for (int i = 0; i < sourceDataTable.Columns.Count; ++i)
            {
                ((Microsoft.Office.Interop.Excel.Range)wks.Cells[1, i + 1]).Value = sourceDataTable.Columns[i].ColumnName;
            }

            Microsoft.Office.Interop.Excel.Range header = wks.get_Range((object)wks.Cells[1, 1], (object)wks.Cells[1, sourceDataTable.Columns.Count]);
            header.EntireColumn.NumberFormat = "@";

            object[,] sourceDataTableObjectArray = new object[sourceDataTable.Rows.Count, sourceDataTable.Columns.Count];

            for (int row = 0; row < sourceDataTable.Rows.Count; ++row)
            {
                for (int col = 0; col < sourceDataTable.Columns.Count; ++col)
                {
                    sourceDataTableObjectArray[row, col] = sourceDataTable.Rows[row][col].ToString();
                }
            }

            ((Microsoft.Office.Interop.Excel.Range)wks.get_Range((object)wks.Cells[2, 1], (object)wks.Cells[sourceDataTable.Rows.Count, sourceDataTable.Columns.Count])).Value2 = sourceDataTableObjectArray;

            header.EntireColumn.AutoFit();

            header.Font.Bold = true;

            wks.Application.ActiveWindow.SplitRow = 1;

            wks.Application.ActiveWindow.FreezePanes = true;

            try
            {
                wks.SaveAs(ExcelFileName, FileFormat: Microsoft.Office.Interop.Excel.XlFileFormat.xlOpenXMLWorkbook);

                wks = null;

                wkb = null;

                excelApp.Quit();

                Console.WriteLine("Completed.");
            }

            catch
            {
                Console.WriteLine("\nO arquivo já foi convertido");
            }


        }


        public Boolean CriarTabela(string NomeTabela)
        {
            try
            {
                //if()
                db.Database.ExecuteSqlCommand($"CREATE TABLE {NomeTabela}(Nome VARCHAR(50) NOT NULL)");
                return true;
            }
            catch (Exception EX)
            {
                return false;
            }
        }
    }
}




