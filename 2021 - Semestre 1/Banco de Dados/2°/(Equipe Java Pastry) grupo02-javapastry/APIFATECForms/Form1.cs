using EGIS.ShapeFileLib;
using System;
using System.Collections.Generic;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.IO;
using System.IO.Compression;
using System.Linq;
using System.Text;
using System.Windows.Forms;


namespace APIFATECForms
{
    public partial class Form1 : Form
    {

        APIFATECEntities db = new APIFATECEntities();

        public static string PastaDaAplicacao = Directory.GetParent(Directory.GetCurrentDirectory()).Parent.FullName;
        public static string BasePath = Path.Combine(PastaDaAplicacao, "BasePath");
        public static string AREA_IMOVEL = Path.Combine(BasePath, "AREA_IMOVEL");

        static string dbfFileName = BasePath + @"\BR_MUNICIPIOS_2020\BR_MUNICIPIOS_2020.dbf";
        public static string constr = "Provider = VFPOLEDB.1; Data Source =" + Directory.GetParent(dbfFileName).FullName;
        string pastaPrimeiraRenderizacao = BasePath + @"\SHAPEFILE_BRASIL\BR_UF_2020.shp";
        string testeshape = BasePath + @"\AREA_IMOVEL\AREA_IMOVEL.shp";


        private Color CorMapaInicial = Color.LightGray;
        private Color CorVerdeDiferente = Color.SeaGreen;
        private Color CorVerde = Color.ForestGreen;
        private Color CorAzul = Color.AliceBlue;
        private Color CorPreta = Color.Black;
        private Color CorBranca = Color.White;

        private Simulacao gifImage = null;
        private string filePath = @"C:\Users\Agostin\Desktop\Grupo-JavaPastry-BranchTeste\grupo02-javapastry\APIFATECForms\BasePath\Spinner-1s-200px.gif";

        Font font1 = new Font("Century Gothic", 9, FontStyle.Bold, GraphicsUnit.Pixel);

        int Segundos = 0;
        string Acrescimo = "";

        DialogResult result;

        int ContagemClickImgPasta = 0;
        int ClickTxtArquivoPExtrair = 0;
        string ShapeFileZipado = "";

        public static List<BR_UF_2020> ListaBrasil = new List<BR_UF_2020>();
        public static List<BR_UF_2020> ListaRegiaoNorte = new List<BR_UF_2020>();
        public static List<BR_UF_2020> ListaRegiaoNordeste = new List<BR_UF_2020>();
        public static List<BR_UF_2020> ListaRegiaoCentroOeste = new List<BR_UF_2020>();
        public static List<BR_UF_2020> ListaRegiaoSudeste = new List<BR_UF_2020>();
        public static List<BR_UF_2020> ListaRegiaoSul = new List<BR_UF_2020>();

        EGIS.ShapeFileLib.ShapeFile sf;

        public Form1()
        {
            InitializeComponent();
            ContagemClickImgPasta = ContagemClickImgPasta + 1;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            Arquivo zip = new Arquivo();

            zip.CriarPasta(BasePath);
            zip.CriarPasta(AREA_IMOVEL);
            //OpenShapefile(pastaPrimeiraRenderizacao);
            gifImage = new Simulacao(filePath);
            gifImage.ReverseAtEnd = false; //dont reverse at end
                                           //pictureBox3.BackColor = Color.Transparent;
            pictureBox3.Visible = true;
            pictureBox3.Image = gifImage.GetNextFrame();

            OpenShapefile(pastaPrimeiraRenderizacao);

            ConexaoDados c = new ConexaoDados();
            string shapefilePath = testeshape;
            string jsonPath = BasePath + @"\AREA_IMOVEL" + "output_out.json";

        }

        /*
        public void DisplayImgSearch()
        {
            labelImgSearch.Image = Image.FromFile(BasePath + @"/Searchpng.png");
            labelImgSearch.AutoSize = false;
            labelImgSearch.Size = labelImgSearch.Image.Size;
            labelImgSearch.ImageAlign = ContentAlignment.MiddleCenter;
            labelImgSearch.Text = "";
            labelImgSearch.BackColor = Color.Transparent;
        }
        */

        public void CaixaDeMensagem(string mensagem, string caption, MessageBoxButtons button, MessageBoxIcon messageBoxIcon)
        {
            MenosZoom(5);
            result = MessageBox.Show(mensagem, caption, button, messageBoxIcon);
        }

        public string OpenShapefile(string path)
        {
            this.sfMap1.ClearShapeFiles();

            try
            {
                ConexaoDados dados = new ConexaoDados();
                // try pra caso o usuario digite o arquivo de texto que nao tem extensao .shp
                this.sfMap1.AddShapeFile(path, "ShapeFile", ""); // o ultimo parametro nao pode ser nulo
                RenderMap(CorMapaInicial, CorVerdeDiferente, CorBranca);
                dados.OpenConnection(constr);// nessa funcao que eu gero o excel // nao preciso mais gerar o excel
            }

            catch (Exception ex) { }

            return path;
        }

        public void RefreshMap()
        {
            this.sfMap1.ZoomLevel = this.sfMap1.ZoomLevel;
        }

        public void CenterMap()
        {
            string PastaDoShape = sf.FilePath + ".shp";
            if (PastaDoShape == pastaPrimeiraRenderizacao)
            {
                //PointD pontoCentro = this.sfMap1.CentrePoint2D; // get ponto centro do mapa
                PointD point = new PointD(-51.4190449415, -14.2396684585);
                this.sfMap1.CentrePoint2D = point;
                double ZoomAtual = this.sfMap1.ZoomLevel;
                this.sfMap1.ZoomLevel = 13.274216406924603;
            }
            else
            {
                PointD pontoCentro = this.sfMap1.CentrePoint2D; // get ponto centro do mapa
                PointD point = new PointD(-64.7019204307494, -3.58159896146659);
                //{{X=-64,7019204307494, Y=-3,58159896146659}}
                //this.sfMap1.CentrePoint2D = point;
                double ZoomAtual = this.sfMap1.ZoomLevel;
                // this.sfMap1.ZoomLevel = ZoomAtual;
                this.sfMap1.ZoomLevel = 30.826027930038009;
            }
        }

        public void MaisZoom()
        {
            double ZoomAtual = this.sfMap1.ZoomLevel;
            this.sfMap1.ZoomLevel = ZoomAtual + 3;
            if (ZoomAtual > 30)
            {
                string Mensagem = "Fora do limite máximo renderização.";
                string Caption = "Atenção!";
                MessageBoxButtons Button = MessageBoxButtons.OK;
                MessageBoxIcon Icon = MessageBoxIcon.Warning;

                CaixaDeMensagem(Mensagem, Caption, Button, Icon);
                CenterMap();
            }
        }

        public void MenosZoom(double zoom)
        {
            double ZoomAtual = this.sfMap1.ZoomLevel;
            try
            {
                this.sfMap1.ZoomLevel = ZoomAtual - zoom;
            }
            catch
            {
                if (ZoomAtual < 4)
                {
                    string Mensagem = "Fora do limite mínimo renderização.";
                    string Caption = "Atenção!";
                    MessageBoxButtons Button = MessageBoxButtons.OK;
                    MessageBoxIcon Icon = MessageBoxIcon.Warning;
                    CaixaDeMensagem(Mensagem, Caption, Button, Icon);
                    CenterMap();
                }
            }
        }

        public void RenderMap(Color CorMapaInteiro, Color CorSelecaoItem, Color CorBordaNaoSelecionada)
        {

            sf = this.sfMap1[0];
            sf.RenderSettings.FillColor = CorMapaInteiro;
            //sf.RenderSettings.FillColor = CorMapaInicial; // aqui eu seto a cor do mapa inteiro
            sf.RenderSettings.Font = font1; // aqui eu defino a fonte a ser usada no mapa
            sf.RenderSettings.SelectFillColor = CorSelecaoItem;
            //sf.RenderSettings.SelectFillColor = CorVerdeDiferente; // aqui eu defino a cor que vai ficar a regiao do mapa que fi clicada no getrecord
            sf.RenderSettings.OutlineColor = CorBordaNaoSelecionada;
            //sf.RenderSettings.OutlineColor = CorBranca; // define a cor das bordas nao selecionadas
            sf.RenderSettings.SelectOutlineColor = CorAzul; // aqui eu defino a cor do mapa quando selecionado // aqui eu defino a cor das bordas
            sf.RenderSettings.FieldName = sf.RenderSettings.DbfReader.GetFieldNames()[1]; // selecionando 1 eu pego todos os nomes das UFs
            RefreshMap();
        }

        private void ImgPastaFechadaClick(object sender, EventArgs e)
        {
            // funcao para dar movimento na imagem da pasta
            // o contagem click inicia com valor 1, assim que inicializamos os componentes do forms.
            // iniciando com o valor 1 a imagem da pasta "iria abrir", sabendo que ela inicia fechada.

            ImgPastaFechada.Size = ImgPastaFechada.Size;
            ImgPastaFechada.BackColor = Color.Transparent;
            ImgPastaFechada.Image = Image.FromFile(BasePath + @"/ImgPastaAberta-removebg-preview-redimensionada.png");

            LabelBaseDeDados.BorderStyle = BorderStyle.FixedSingle;
            LabelRegiaoNorte.Visible = true;
            LabelRegiaoNordeste.Visible = true;
            LabelRegiaoCentroOeste.Visible = true;
            LabelRegiaoSudeste.Visible = true;
            LabelRegiaoSul.Visible = true;

            if (ContagemClickImgPasta > 1)
            {
                ImgPastaFechada.Image = Image.FromFile(BasePath + @"/ImgPastaFechada-removebg-preview-redimensionada.png");
                ContagemClickImgPasta = ContagemClickImgPasta - 1;
                LabelRegiaoNorte.Visible = false;
                LabelRegiaoNordeste.Visible = false;
                LabelRegiaoCentroOeste.Visible = false;
                LabelRegiaoSudeste.Visible = false;
                LabelRegiaoSul.Visible = false;
            }

            if (ContagemClickImgPasta == 0)
            {
                ImgPastaFechada.Image = Image.FromFile(BasePath + @"/ImgPastaFechada-removebg-preview-redimensionada.png");
                ContagemClickImgPasta = ContagemClickImgPasta - 1;
                LabelRegiaoNorte.Visible = false;
                LabelRegiaoNordeste.Visible = false;
                LabelRegiaoCentroOeste.Visible = false;
                LabelRegiaoSudeste.Visible = false;
                LabelRegiaoSul.Visible = false;
            }

            ContagemClickImgPasta = ContagemClickImgPasta - 1;

            if (ContagemClickImgPasta == -2)
            {
                ContagemClickImgPasta = 1;
            }

        }

        private void BaseDeDadosClick(object sender, EventArgs e)
        {
            string PastaDoShape = sf.FilePath + ".shp";
            if (PastaDoShape == pastaPrimeiraRenderizacao)
            {
                ImgPastaFechadaClick(sender, e);
                LabelBaseDeDados.BorderStyle = BorderStyle.Fixed3D; ;
                LabelRegiaoNorte.BorderStyle = BorderStyle.None;
                LabelRegiaoNordeste.BorderStyle = BorderStyle.None;
                LabelRegiaoCentroOeste.BorderStyle = BorderStyle.None;
                LabelRegiaoSul.BorderStyle = BorderStyle.None;
                LabelRegiaoSudeste.BorderStyle = BorderStyle.None;

                sf.ClearSelectedRecords();
                RefreshMap();
            }
            else
            {
                gifImage = new Simulacao(filePath);
                gifImage.ReverseAtEnd = false; //dont reverse at end
                                               //pictureBox3.BackColor = Color.Transparent;
                pictureBox3.Visible = true;
                pictureBox3.Image = gifImage.GetNextFrame();

                RenderMap(CorMapaInicial, CorVerdeDiferente, CorBranca);
                OpenShapefile(pastaPrimeiraRenderizacao);
                ImgPastaFechadaClick(sender, e);
                LabelBaseDeDados.BorderStyle = BorderStyle.Fixed3D; ;
                LabelRegiaoNorte.BorderStyle = BorderStyle.None;
                LabelRegiaoNordeste.BorderStyle = BorderStyle.None;
                LabelRegiaoCentroOeste.BorderStyle = BorderStyle.None;
                LabelRegiaoSul.BorderStyle = BorderStyle.None;
                LabelRegiaoSudeste.BorderStyle = BorderStyle.None;

                sf.ClearSelectedRecords();
                RefreshMap();
            }
        }

        private void txtArquivoPExtrairKeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                Arquivo zip = new Arquivo();
                OpenFileDialog ofd = new OpenFileDialog();

                ofd.Title = "Busca de Arquivo";
                //ofd.InitialDirectory = NomePasta; se eu der esse comando eu inicio a funcao ShowDialog() dentro já dessa pasta
                ofd.CheckFileExists = true;
                ofd.CheckPathExists = true;
                ofd.RestoreDirectory = true;
                ofd.FileName = txtArquivoPExtrair.Text.Trim().ToUpper();
                ofd.Filter = "*(.zip)|*zip";

                if (ofd.ShowDialog(this) == DialogResult.OK)
                {
                    /*
                    ShapeFileZipado = ofd.FileName;
                    char separacao = '\\';
                    string[] DadosArquivo = ShapeFileZipado.Split(separacao);
                    string DadoImportante = DadosArquivo[4];
                    char separacao2 = '_';
                    string[] DadoCodigoIBGE = DadoImportante.Split(separacao2);
                    string DadoImportante2 = DadoCodigoIBGE[1];
                    string[] CodigoIBGECExtensao = DadoImportante2.Split('.');
                    string CodigoIBGE = CodigoIBGECExtensao[0]; // aqui eu consigo o codigo do ibge que tanto queria caralhooooo
                    int CODIGOIBGE = int.Parse(CodigoIBGE);

                    BRASIL_MUNICIPIO BuscaCodigoIBGE = db.BRASIL_MUNICIPIO.Where(busca => busca.cd_mun == CODIGOIBGE).FirstOrDefault();

                    */

                    try
                    {
                        using (ZipArchive archive = ZipFile.OpenRead(ShapeFileZipado))
                        {
                            Arquivo arquivo = new Arquivo();
                            zip.DeletarArquivos(AREA_IMOVEL);
                            foreach (ZipArchiveEntry entry in archive.Entries)
                            {
                                try
                                {
                                    if (IsDirectoryEmpty(AREA_IMOVEL) == true && entry.FullName == "AREA_IMOVEL.zip")
                                    {

                                        zip.ExtrairArquivo(entry.FullName, AREA_IMOVEL);
                                        // DEPOIS QUE EXTRAI OS DOCUMENTOS EU TENHO QUE POPULAR O BANCO
                                    }
                                }
                                catch { }
                            }
                        }
                    }
                    catch
                    {

                    }
                }
                else
                {

                }
            }
        }

        public bool IsDirectoryEmpty(string path)
        {
            return !Directory.EnumerateFileSystemEntries(path).Any();
        }

        private void txtArquivoPExtrairClick(object sender, EventArgs e)
        {
            ClickTxtArquivoPExtrair++;

            if (txtArquivoPExtrair.Text != "" && ClickTxtArquivoPExtrair == 1)
            {
                txtArquivoPExtrair.Text = "";
            }

            if (txtArquivoPExtrair.Text != "" && ClickTxtArquivoPExtrair == 3)
            {
                txtArquivoPExtrair.Text = txtArquivoPExtrair.Text;
            }

            ClickTxtArquivoPExtrair = ClickTxtArquivoPExtrair + 1;

            if (ClickTxtArquivoPExtrair == 4)
            {
                ClickTxtArquivoPExtrair = 2;
            }

        }

        /*
        private void labelImgSearch_Click(object sender, EventArgs e)
        {
            txtArquivoPExtrair.Text = "";
        }
        */

        private void btnBuscarClick(object sender, EventArgs e)
        {
            try
            {
                OpenFileDialog ofd = new OpenFileDialog();
                ofd.CheckFileExists = true;
                ofd.CheckPathExists = true;
                ofd.RestoreDirectory = true;

                //condição? expressão1_se_true : expressão2_se_false

                if(txtArquivoPExtrair.Text == " Digite o nome do arquivo que deseja extrair...")
                {
                    throw new Exception();
                }
                else if(txtArquivoPExtrair.Text == "")
                {
                    throw new Exception();
                }
                else
                {
                    ofd.FileName = txtArquivoPExtrair.Text.Trim().ToUpper();
                }

                if (ofd.ShowDialog(this) == DialogResult.OK)
                {

                    gifImage = new Simulacao(filePath);
                    gifImage.ReverseAtEnd = false; //dont reverse at end
                                                   //pictureBox3.BackColor = Color.Transparent;
                    pictureBox3.Visible = true;
                    pictureBox3.Image = gifImage.GetNextFrame();

                    /*
                    OpenShapefile(ofd.FileName); // aqui ele tenta abrir o shape file que eu selecionei, verificando seu nome
                                                 // por exemplo: "C:\\Users\\Agostin\\Desktop\\APIFATECForms\\BasePath\\AREA_IMOVEL\\AREA_IMOVEL.shp
                    */

                }
            }
            catch (Exception ex)
            {
                //MessageBox.Show(this, "Error : " + ex.Message);
            }

        }

        private void RegiaoNorte_Click(object sender, EventArgs e)
        {
            string VerificaPastaDoShape = sf.FilePath + ".shp";

            if (VerificaPastaDoShape == pastaPrimeiraRenderizacao)
            {
                sf.ClearSelectedRecords();

                LabelBaseDeDados.BorderStyle = BorderStyle.None;
                LabelRegiaoNorte.BorderStyle = BorderStyle.Fixed3D;
                LabelRegiaoNordeste.BorderStyle = BorderStyle.None;
                LabelRegiaoCentroOeste.BorderStyle = BorderStyle.None;
                LabelRegiaoSul.BorderStyle = BorderStyle.None;
                LabelRegiaoSudeste.BorderStyle = BorderStyle.None;

                List<int> RegiaoNorte = new List<int>();

                foreach (var uf in ListaRegiaoNorte)
                {
                    if (uf.nm_regiao == "Norte")
                    {
                        RegiaoNorte.Add(uf.cd_uf);
                    }
                }

                foreach (var item in RegiaoNorte)
                {
                    if (item == 11)
                    {
                        int primeiro = item - 11;
                        sf.SelectRecord(primeiro, true);
                    }
                    int i = item - 10;

                    sf.SelectRecord(i, true);
                }

                RefreshMap();
            }

            else
            {
                LabelBaseDeDados.BorderStyle = BorderStyle.None;
                LabelRegiaoNorte.BorderStyle = BorderStyle.Fixed3D;
                LabelRegiaoNordeste.BorderStyle = BorderStyle.None;
                LabelRegiaoCentroOeste.BorderStyle = BorderStyle.None;
                LabelRegiaoSul.BorderStyle = BorderStyle.None;
                LabelRegiaoSudeste.BorderStyle = BorderStyle.None;
            }

        }

        private void RegiaoNordeste_Click(object sender, EventArgs e)
        {
            string PastaDoShape = sf.FilePath + ".shp";
            if (PastaDoShape == pastaPrimeiraRenderizacao)
            {
                sf.ClearSelectedRecords();

                LabelBaseDeDados.BorderStyle = BorderStyle.None;
                LabelRegiaoNorte.BorderStyle = BorderStyle.None;
                LabelRegiaoNordeste.BorderStyle = BorderStyle.Fixed3D;
                LabelRegiaoCentroOeste.BorderStyle = BorderStyle.None;
                LabelRegiaoSul.BorderStyle = BorderStyle.None;
                LabelRegiaoSudeste.BorderStyle = BorderStyle.None;

                List<int> RegiaoNordeste = new List<int>();

                foreach (var uf in ListaRegiaoNordeste)
                {
                    if (uf.nm_regiao == "Nordeste")
                    {
                        RegiaoNordeste.Add(uf.cd_uf);
                    }
                }

                foreach (var item in RegiaoNordeste)
                {

                    int i = item - 14;

                    sf.SelectRecord(i, true);
                }

                RefreshMap();
            }

            else
            {
                LabelBaseDeDados.BorderStyle = BorderStyle.None;
                LabelRegiaoNorte.BorderStyle = BorderStyle.None;
                LabelRegiaoNordeste.BorderStyle = BorderStyle.Fixed3D;
                LabelRegiaoCentroOeste.BorderStyle = BorderStyle.None;
                LabelRegiaoSul.BorderStyle = BorderStyle.None;
                LabelRegiaoSudeste.BorderStyle = BorderStyle.None;
            }

        }

        private void RegiaoCentroOeste_Click(object sender, EventArgs e)
        {
            string PastaDoShape = sf.FilePath + ".shp";
            if (PastaDoShape == pastaPrimeiraRenderizacao)
            {
                sf.ClearSelectedRecords();

                LabelBaseDeDados.BorderStyle = BorderStyle.None;
                LabelRegiaoNorte.BorderStyle = BorderStyle.None;
                LabelRegiaoNordeste.BorderStyle = BorderStyle.None;
                LabelRegiaoCentroOeste.BorderStyle = BorderStyle.Fixed3D;
                LabelRegiaoSul.BorderStyle = BorderStyle.None;
                LabelRegiaoSudeste.BorderStyle = BorderStyle.None;

                List<int> RegiaoCentroOeste = new List<int>();

                foreach (var uf in ListaRegiaoCentroOeste)
                {
                    if (uf.nm_regiao == "Centro-oeste")
                    {
                        RegiaoCentroOeste.Add(uf.cd_uf);
                    }
                }

                foreach (var item in RegiaoCentroOeste)
                {
                    int i = item - 27;

                    sf.SelectRecord(i, true);
                }

                RefreshMap();
            }

            else
            {
                LabelBaseDeDados.BorderStyle = BorderStyle.None;
                LabelRegiaoNorte.BorderStyle = BorderStyle.None;
                LabelRegiaoNordeste.BorderStyle = BorderStyle.None;
                LabelRegiaoCentroOeste.BorderStyle = BorderStyle.Fixed3D;
                LabelRegiaoSul.BorderStyle = BorderStyle.None;
                LabelRegiaoSudeste.BorderStyle = BorderStyle.None;
            }

        }

        private void RegiaoSudeste_Click(object sender, EventArgs e)
        {
            string PastaDoShape = sf.FilePath + ".shp";
            if (PastaDoShape == pastaPrimeiraRenderizacao)
            {
                sf.ClearSelectedRecords();

                LabelBaseDeDados.BorderStyle = BorderStyle.None;
                LabelRegiaoNorte.BorderStyle = BorderStyle.None;
                LabelRegiaoNordeste.BorderStyle = BorderStyle.None;
                LabelRegiaoCentroOeste.BorderStyle = BorderStyle.None;
                LabelRegiaoSul.BorderStyle = BorderStyle.None;
                LabelRegiaoSudeste.BorderStyle = BorderStyle.Fixed3D;

                List<int> RegiaoSudeste = new List<int>();

                foreach (var uf in ListaRegiaoSudeste)
                {
                    if (uf.nm_regiao == "Sudeste")
                    {
                        RegiaoSudeste.Add(uf.cd_uf);
                    }
                }

                foreach (var item in RegiaoSudeste)
                {
                    if (item == 35)
                    {
                        int ii = item - 16;
                        sf.SelectRecord(ii, true);
                    }

                    int i = item - 15;
                    if (i < 20)
                    {
                        sf.SelectRecord(i, true);
                    }
                }

                RefreshMap();
            }

            else
            {
                LabelBaseDeDados.BorderStyle = BorderStyle.None;
                LabelRegiaoNorte.BorderStyle = BorderStyle.None;
                LabelRegiaoNordeste.BorderStyle = BorderStyle.None;
                LabelRegiaoCentroOeste.BorderStyle = BorderStyle.None;
                LabelRegiaoSul.BorderStyle = BorderStyle.None;
                LabelRegiaoSudeste.BorderStyle = BorderStyle.Fixed3D;
            }

        }

        private void LabelRegiaoSul_Click(object sender, EventArgs e)
        {
            string PastaDoShape = sf.FilePath + ".shp";
            if (PastaDoShape == pastaPrimeiraRenderizacao)
            {
                sf.ClearSelectedRecords();

                LabelBaseDeDados.BorderStyle = BorderStyle.None;
                LabelRegiaoNorte.BorderStyle = BorderStyle.None;
                LabelRegiaoNordeste.BorderStyle = BorderStyle.None;
                LabelRegiaoCentroOeste.BorderStyle = BorderStyle.None;
                LabelRegiaoSul.BorderStyle = BorderStyle.Fixed3D;
                LabelRegiaoSudeste.BorderStyle = BorderStyle.None;

                List<int> RegiaoSul = new List<int>();

                foreach (var uf in ListaRegiaoSul)
                {
                    if (uf.nm_regiao == "Sul")
                    {
                        RegiaoSul.Add(uf.cd_uf);
                    }
                }

                foreach (var item in RegiaoSul)
                {
                    int i = item - 21;
                    sf.SelectRecord(i, true);
                }
                RefreshMap();
            }

            else
            {
                LabelBaseDeDados.BorderStyle = BorderStyle.None;
                LabelRegiaoNorte.BorderStyle = BorderStyle.None;
                LabelRegiaoNordeste.BorderStyle = BorderStyle.None;
                LabelRegiaoCentroOeste.BorderStyle = BorderStyle.None;
                LabelRegiaoSul.BorderStyle = BorderStyle.Fixed3D;
                LabelRegiaoSudeste.BorderStyle = BorderStyle.None;
            }


        }

        private void Form1_Click(object sender, EventArgs e)
        {
            LabelBaseDeDados.BorderStyle = BorderStyle.None;
        }

        private void ImgCenter_MouseEnter(object sender, EventArgs e)
        {
            ToolTip toolTip1 = new ToolTip();
            toolTip1.ShowAlways = true;
            toolTip1.SetToolTip(ImgCenter, "Centralizar mapa");
        }

        private void ImgCenter_Click(object sender, EventArgs e)
        {
            CenterMap();
            RefreshMap();
        }

        private void ImgZoomIn_MouseEnter(object sender, EventArgs e)
        {
            ToolTip toolTip1 = new ToolTip();
            toolTip1.ShowAlways = true;
            toolTip1.SetToolTip(ImgZoomIn, "Mais zoom");

        }

        private void ImgZoomOut_MouseEnter(object sender, EventArgs e)
        {
            ToolTip toolTip1 = new ToolTip();
            toolTip1.ShowAlways = true;
            toolTip1.SetToolTip(ImgZoomOut, "Menos zoom");
        }

        private void ImgZoomIn_Click(object sender, EventArgs e)
        {
            MaisZoom();
        }

        private void ImgZoomOut_Click(object sender, EventArgs e)
        {
            MenosZoom(2.5);
        }

        private void sfMap1_MouseDoubleClick(object sender, MouseEventArgs e)
        {

            string PastaDoShape = sf.FilePath + ".shp";
            if (PastaDoShape == pastaPrimeiraRenderizacao)
            {
                string Mensagem = "Deseja visualizar as cidades desse estado?";
                string Caption = "";
                MessageBoxButtons Button = MessageBoxButtons.YesNoCancel;
                MessageBoxIcon Icon = MessageBoxIcon.Question;

                int recordIndex = sfMap1.GetShapeIndexAtPixelCoord(0, e.Location, 8);
                if (recordIndex >= 0)
                {
                    string[] recordAttributes = sfMap1[0].GetAttributeFieldValues(recordIndex);// pego os atributos dentro dauqle lugar que foi clicado
                    //MenosZoom(5);
                    CaixaDeMensagem(Mensagem, Caption, Button, Icon);
                    MenosZoom(5);

                    if (result == DialogResult.Yes)
                    {
                        RenderMap(CorVerdeDiferente, CorVerdeDiferente, CorBranca);

                        List<string> SiglasUF = new List<string>();

                        foreach (var uf in ListaBrasil)
                        {
                            if (uf.sigla_uf == uf.sigla_uf)
                            {
                                SiglasUF.Add(uf.sigla_uf);
                            }
                        }

                        foreach (var item in SiglasUF)
                        {
                            if (item == recordAttributes[2])
                            {
                                System.IO.DirectoryInfo di = new DirectoryInfo(BasePath);

                                foreach (var file in di.GetDirectories())
                                {
                                    string Diretorio = file.ToString();
                                    if (Diretorio == item)
                                    {
                                        string PastaBuscada = BasePath + @"\" + Diretorio;
                                        Acrescimo = PastaBuscada + @"\" + Diretorio + "_Municipios_2020.shp";

                                        // entrar na pasta e localizar o arquivo shape
                                        string PastadoShape = sf.FilePath + ".shp";
                                        if (PastadoShape == Acrescimo)
                                        {
                                        }
                                        else
                                        {
                                            gifImage = new Simulacao(filePath);
                                            gifImage.ReverseAtEnd = false; //dont reverse at end
                                                                           //pictureBox3.BackColor = Color.Transparent;
                                            pictureBox3.Visible = true;
                                            pictureBox3.Image = gifImage.GetNextFrame();

                                            OpenShapefile(Acrescimo);
                                        }

                                    }
                                }

                            }
                        }

                        sf.RenderSettings.SelectFillColor = CorMapaInicial;
                        sf.RenderSettings.OutlineColor = CorBranca;
                        //sf.RenderSettings.SelectOutlineColor = CorBranca;
                        RefreshMap();
                    }
                }
            }

            else if (Acrescimo == Acrescimo)
            {
                int recordIndex = sfMap1.GetShapeIndexAtPixelCoord(0, e.Location, 8);
                if (recordIndex >= 0)
                {
                    string[] recordAttributes = sfMap1[0].GetAttributeFieldValues(recordIndex);// pego os atributos dentro dauqle lugar que foi clicado
                    string[] attributeNames = sfMap1[0].GetAttributeFieldNames();
                    StringBuilder sb = new StringBuilder();
                    for (int n = 0; n < attributeNames.Length; ++n)
                    {
                        sb.Append(attributeNames[n]).Append(':' + " ").AppendLine(recordAttributes[n].Trim());
                    }
                    MessageBox.Show(this, sb.ToString(), "Atributos da seleção", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1);

                    string fileName = @"C:\Python27\example\hello_world.py";

                    Process p = new Process();
                    p.StartInfo = new ProcessStartInfo(@"C:\Users\Wil\Downloads\grupo02-javapastry-main\APIFATECForms\BasePath\javapastry.exe", fileName)
                    {
                        RedirectStandardOutput = true,
                        UseShellExecute = false,
                        CreateNoWindow = true
                    };
                    p.Start();

                    string output = p.StandardOutput.ReadToEnd();
                    p.WaitForExit();

                    Console.WriteLine(output);

                    Console.ReadLine();

                }
            }

        }

        private void LabelBaseDeDados_MouseLeave(object sender, EventArgs e)
        {
            pictureBox3.Visible = false;
        }

        private void sfMap1_MouseEnter(object sender, EventArgs e)
        {

        }

        private void Form1_MouseMove(object sender, MouseEventArgs e)
        {

            if (Segundos > DateTime.Now.Second)
            {
                pictureBox3.Visible = false;
            }

            Segundos++;

            if (Segundos == 60)
            {
                Segundos = 0;
            }
        }
    }
}
