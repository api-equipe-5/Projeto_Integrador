using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.OleDb;
using System.IO;
using OpenXmlPowerTools;
using System.Reflection;

namespace TesteAPI
{
    class Conversao
    {
        APIFATECEntities db = new APIFATECEntities();

        static Missing mv = Missing.Value;

        public static string dbfFileName = @"C:\Teste\VariavelImportante\AREA_IMOVEL.dbf";
        public static string constr = "Provider = VFPOLEDB.1; Data Source =" + Directory.GetParent(dbfFileName).FullName;
        public static string ExcelFileName = @"C:\Teste\VariavelImportante\" + "arquivo_convertido"; 

        public void OpenConnection(string connectionString)
        {
            connectionString = constr;

            using (OleDbConnection connection = new OleDbConnection(connectionString))
            {
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
                    

                    GenerateExcel(dt, ExcelFileName);
                }

                OleDbDataReader dr = cmd.ExecuteReader();

                

                while (dr.Read())
                {
                    string cod_imovel = dr[0].ToString().Trim();// .trim para tirar os white spaces
                    string num_area = dr[1].ToString().Trim();
                    string cod_estado = dr[2].ToString().Trim();
                    string nom_munici = dr[3].ToString().Trim();
                    string num_modulo = dr[4].ToString().Trim();
                    string tipo_imove = dr[5].ToString().Trim();
                    string situacao = dr[6].ToString().Trim();
                    string condicao_i = dr[7].ToString().Trim();

                    //Console.WriteLine(dr[0].ToString());

                    decimal NUM_AREA = decimal.Parse(num_area);
                    decimal NUM_MODULO = decimal.Parse(num_modulo);

                    AREA_IMOVEL area = new AREA_IMOVEL
                    {
                        cod_imovel = cod_imovel,
                        num_area = NUM_AREA,
                        cod_estado = cod_estado,
                        nom_munici = nom_munici,
                        condicao_i = condicao_i,
                        num_modulo = NUM_MODULO,
                        situacao = situacao,
                        tipo_imove = tipo_imove
                    };

                    db.AREA_IMOVEL.Add(area);
                    db.SaveChanges();

                    // lembrar de adicionar o data_cadastro na tabela para ter um versionamento
                    // dentro da tabela area_imovel eu consigo fazer uma busca por municipio e retornar o por municpio e ate por estado
                }

                if (connection.State == ConnectionState.Open)
                {
                    try
                    {
                        connection.Close();
                    }
                    catch { }
                }

            }
        }

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






    }
}










