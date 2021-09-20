
namespace APIFATECForms
{
    partial class Form1
    {
        /// <summary>
        /// Variável de designer necessária.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpar os recursos que estão sendo usados.
        /// </summary>
        /// <param name="disposing">true se for necessário descartar os recursos gerenciados; caso contrário, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código gerado pelo Windows Form Designer

        /// <summary>
        /// Método necessário para suporte ao Designer - não modifique 
        /// o conteúdo deste método com o editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.btnBuscar = new System.Windows.Forms.Button();
            this.txtNomeArquivo = new System.Windows.Forms.TextBox();
            this.imgLabel = new System.Windows.Forms.Label();
            this.ArquivoSelecionado = new System.Windows.Forms.Label();
            this.sfMap1 = new EGIS.Controls.SFMap();
            this.LabelBaseDeDados = new System.Windows.Forms.Label();
            this.txtArquivoPExtrair = new System.Windows.Forms.TextBox();
            this.LabelRegiaoNorte = new System.Windows.Forms.Label();
            this.LabelRegiaoNordeste = new System.Windows.Forms.Label();
            this.LabelRegiaoCentroOeste = new System.Windows.Forms.Label();
            this.LabelRegiaoSudeste = new System.Windows.Forms.Label();
            this.LabelRegiaoSul = new System.Windows.Forms.Label();
            this.ImgCenter = new System.Windows.Forms.PictureBox();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.ImgPastaFechada = new System.Windows.Forms.PictureBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.ImgZoomOut = new System.Windows.Forms.PictureBox();
            this.ImgZoomIn = new System.Windows.Forms.PictureBox();
            this.pictureBox3 = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.ImgCenter)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.ImgPastaFechada)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.ImgZoomOut)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.ImgZoomIn)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
            this.SuspendLayout();
            // 
            // btnBuscar
            // 
            this.btnBuscar.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btnBuscar.Font = new System.Drawing.Font("Century Gothic", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnBuscar.ForeColor = System.Drawing.Color.Black;
            this.btnBuscar.Location = new System.Drawing.Point(596, 7);
            this.btnBuscar.Margin = new System.Windows.Forms.Padding(4);
            this.btnBuscar.Name = "btnBuscar";
            this.btnBuscar.Size = new System.Drawing.Size(100, 30);
            this.btnBuscar.TabIndex = 0;
            this.btnBuscar.Text = "Buscar";
            this.btnBuscar.UseVisualStyleBackColor = true;
            this.btnBuscar.Click += new System.EventHandler(this.btnBuscarClick);
            // 
            // txtNomeArquivo
            // 
            this.txtNomeArquivo.Location = new System.Drawing.Point(372, 587);
            this.txtNomeArquivo.Margin = new System.Windows.Forms.Padding(4);
            this.txtNomeArquivo.Name = "txtNomeArquivo";
            this.txtNomeArquivo.ReadOnly = true;
            this.txtNomeArquivo.Size = new System.Drawing.Size(548, 23);
            this.txtNomeArquivo.TabIndex = 4;
            // 
            // imgLabel
            // 
            this.imgLabel.AutoSize = true;
            this.imgLabel.Location = new System.Drawing.Point(28, 518);
            this.imgLabel.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.imgLabel.Name = "imgLabel";
            this.imgLabel.Size = new System.Drawing.Size(0, 17);
            this.imgLabel.TabIndex = 9;
            // 
            // ArquivoSelecionado
            // 
            this.ArquivoSelecionado.AutoSize = true;
            this.ArquivoSelecionado.Font = new System.Drawing.Font("Century Gothic", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ArquivoSelecionado.ForeColor = System.Drawing.Color.Black;
            this.ArquivoSelecionado.Location = new System.Drawing.Point(210, 587);
            this.ArquivoSelecionado.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.ArquivoSelecionado.Name = "ArquivoSelecionado";
            this.ArquivoSelecionado.Size = new System.Drawing.Size(154, 19);
            this.ArquivoSelecionado.TabIndex = 13;
            this.ArquivoSelecionado.Text = "Arquivo selecionado:";
            // 
            // sfMap1
            // 
            this.sfMap1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.sfMap1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.sfMap1.CentrePoint2D = ((EGIS.ShapeFileLib.PointD)(resources.GetObject("sfMap1.CentrePoint2D")));
            this.sfMap1.Cursor = System.Windows.Forms.Cursors.Cross;
            this.sfMap1.DefaultMapCursor = System.Windows.Forms.Cursors.Cross;
            this.sfMap1.DefaultSelectionCursor = System.Windows.Forms.Cursors.Cross;
            this.sfMap1.Font = new System.Drawing.Font("Tw Cen MT", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.sfMap1.Location = new System.Drawing.Point(214, 50);
            this.sfMap1.MapBackColor = System.Drawing.SystemColors.ActiveCaption;
            this.sfMap1.Margin = new System.Windows.Forms.Padding(4);
            this.sfMap1.Name = "sfMap1";
            this.sfMap1.PanSelectMode = EGIS.Controls.PanSelectMode.Pan;
            this.sfMap1.RenderQuality = EGIS.ShapeFileLib.RenderQuality.High;
            this.sfMap1.Size = new System.Drawing.Size(706, 520);
            this.sfMap1.TabIndex = 18;
            this.sfMap1.UseMemoryStreams = false;
            this.sfMap1.UseMercatorProjection = false;
            this.sfMap1.ZoomLevel = 1D;
            this.sfMap1.ZoomToSelectedExtentWhenCtrlKeydown = false;
            this.sfMap1.MouseDoubleClick += new System.Windows.Forms.MouseEventHandler(this.sfMap1_MouseDoubleClick);
            this.sfMap1.MouseEnter += new System.EventHandler(this.sfMap1_MouseEnter);
            // 
            // LabelBaseDeDados
            // 
            this.LabelBaseDeDados.AutoSize = true;
            this.LabelBaseDeDados.Font = new System.Drawing.Font("Century Gothic", 10F);
            this.LabelBaseDeDados.Location = new System.Drawing.Point(54, 156);
            this.LabelBaseDeDados.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.LabelBaseDeDados.Name = "LabelBaseDeDados";
            this.LabelBaseDeDados.Size = new System.Drawing.Size(112, 19);
            this.LabelBaseDeDados.TabIndex = 20;
            this.LabelBaseDeDados.Text = "Base de Dados";
            this.LabelBaseDeDados.Click += new System.EventHandler(this.BaseDeDadosClick);
            this.LabelBaseDeDados.MouseLeave += new System.EventHandler(this.LabelBaseDeDados_MouseLeave);
            // 
            // txtArquivoPExtrair
            // 
            this.txtArquivoPExtrair.Font = new System.Drawing.Font("Century Gothic", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtArquivoPExtrair.Location = new System.Drawing.Point(214, 12);
            this.txtArquivoPExtrair.Name = "txtArquivoPExtrair";
            this.txtArquivoPExtrair.Size = new System.Drawing.Size(351, 24);
            this.txtArquivoPExtrair.TabIndex = 21;
            this.txtArquivoPExtrair.Text = " Digite o nome do arquivo que deseja extrair...";
            this.txtArquivoPExtrair.Click += new System.EventHandler(this.txtArquivoPExtrairClick);
            this.txtArquivoPExtrair.KeyDown += new System.Windows.Forms.KeyEventHandler(this.txtArquivoPExtrairKeyDown);
            // 
            // LabelRegiaoNorte
            // 
            this.LabelRegiaoNorte.AutoSize = true;
            this.LabelRegiaoNorte.Font = new System.Drawing.Font("Century Gothic", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LabelRegiaoNorte.Location = new System.Drawing.Point(54, 185);
            this.LabelRegiaoNorte.Name = "LabelRegiaoNorte";
            this.LabelRegiaoNorte.Size = new System.Drawing.Size(99, 19);
            this.LabelRegiaoNorte.TabIndex = 22;
            this.LabelRegiaoNorte.Text = "Região Norte";
            this.LabelRegiaoNorte.Visible = false;
            this.LabelRegiaoNorte.Click += new System.EventHandler(this.RegiaoNorte_Click);
            // 
            // LabelRegiaoNordeste
            // 
            this.LabelRegiaoNordeste.AutoSize = true;
            this.LabelRegiaoNordeste.Font = new System.Drawing.Font("Century Gothic", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LabelRegiaoNordeste.Location = new System.Drawing.Point(54, 212);
            this.LabelRegiaoNordeste.Name = "LabelRegiaoNordeste";
            this.LabelRegiaoNordeste.Size = new System.Drawing.Size(123, 19);
            this.LabelRegiaoNordeste.TabIndex = 23;
            this.LabelRegiaoNordeste.Text = "Região Nordeste";
            this.LabelRegiaoNordeste.Visible = false;
            this.LabelRegiaoNordeste.Click += new System.EventHandler(this.RegiaoNordeste_Click);
            // 
            // LabelRegiaoCentroOeste
            // 
            this.LabelRegiaoCentroOeste.AutoSize = true;
            this.LabelRegiaoCentroOeste.Font = new System.Drawing.Font("Century Gothic", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LabelRegiaoCentroOeste.Location = new System.Drawing.Point(54, 238);
            this.LabelRegiaoCentroOeste.Name = "LabelRegiaoCentroOeste";
            this.LabelRegiaoCentroOeste.Size = new System.Drawing.Size(154, 19);
            this.LabelRegiaoCentroOeste.TabIndex = 24;
            this.LabelRegiaoCentroOeste.Text = "Região Centro-Oeste";
            this.LabelRegiaoCentroOeste.Visible = false;
            this.LabelRegiaoCentroOeste.Click += new System.EventHandler(this.RegiaoCentroOeste_Click);
            // 
            // LabelRegiaoSudeste
            // 
            this.LabelRegiaoSudeste.AutoSize = true;
            this.LabelRegiaoSudeste.Font = new System.Drawing.Font("Century Gothic", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LabelRegiaoSudeste.Location = new System.Drawing.Point(54, 264);
            this.LabelRegiaoSudeste.Name = "LabelRegiaoSudeste";
            this.LabelRegiaoSudeste.Size = new System.Drawing.Size(116, 19);
            this.LabelRegiaoSudeste.TabIndex = 25;
            this.LabelRegiaoSudeste.Text = "Região Sudeste";
            this.LabelRegiaoSudeste.Visible = false;
            this.LabelRegiaoSudeste.Click += new System.EventHandler(this.RegiaoSudeste_Click);
            // 
            // LabelRegiaoSul
            // 
            this.LabelRegiaoSul.AutoSize = true;
            this.LabelRegiaoSul.Font = new System.Drawing.Font("Century Gothic", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LabelRegiaoSul.Location = new System.Drawing.Point(54, 290);
            this.LabelRegiaoSul.Name = "LabelRegiaoSul";
            this.LabelRegiaoSul.Size = new System.Drawing.Size(81, 19);
            this.LabelRegiaoSul.TabIndex = 26;
            this.LabelRegiaoSul.Text = "Região Sul";
            this.LabelRegiaoSul.Visible = false;
            this.LabelRegiaoSul.Click += new System.EventHandler(this.LabelRegiaoSul_Click);
            // 
            // ImgCenter
            // 
            this.ImgCenter.Image = ((System.Drawing.Image)(resources.GetObject("ImgCenter.Image")));
            this.ImgCenter.Location = new System.Drawing.Point(741, 7);
            this.ImgCenter.Name = "ImgCenter";
            this.ImgCenter.Size = new System.Drawing.Size(32, 31);
            this.ImgCenter.TabIndex = 28;
            this.ImgCenter.TabStop = false;
            this.ImgCenter.Click += new System.EventHandler(this.ImgCenter_Click);
            this.ImgCenter.MouseEnter += new System.EventHandler(this.ImgCenter_MouseEnter);
            // 
            // pictureBox2
            // 
            this.pictureBox2.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.pictureBox2.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox2.Image")));
            this.pictureBox2.Location = new System.Drawing.Point(831, 482);
            this.pictureBox2.Name = "pictureBox2";
            this.pictureBox2.Size = new System.Drawing.Size(71, 72);
            this.pictureBox2.TabIndex = 27;
            this.pictureBox2.TabStop = false;
            // 
            // ImgPastaFechada
            // 
            this.ImgPastaFechada.Image = ((System.Drawing.Image)(resources.GetObject("ImgPastaFechada.Image")));
            this.ImgPastaFechada.Location = new System.Drawing.Point(12, 148);
            this.ImgPastaFechada.Name = "ImgPastaFechada";
            this.ImgPastaFechada.Size = new System.Drawing.Size(45, 34);
            this.ImgPastaFechada.TabIndex = 19;
            this.ImgPastaFechada.TabStop = false;
            this.ImgPastaFechada.Click += new System.EventHandler(this.ImgPastaFechadaClick);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(22, 12);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(158, 130);
            this.pictureBox1.TabIndex = 15;
            this.pictureBox1.TabStop = false;
            // 
            // ImgZoomOut
            // 
            this.ImgZoomOut.Image = ((System.Drawing.Image)(resources.GetObject("ImgZoomOut.Image")));
            this.ImgZoomOut.Location = new System.Drawing.Point(888, 7);
            this.ImgZoomOut.Name = "ImgZoomOut";
            this.ImgZoomOut.Size = new System.Drawing.Size(32, 31);
            this.ImgZoomOut.TabIndex = 30;
            this.ImgZoomOut.TabStop = false;
            this.ImgZoomOut.Click += new System.EventHandler(this.ImgZoomOut_Click);
            this.ImgZoomOut.MouseEnter += new System.EventHandler(this.ImgZoomOut_MouseEnter);
            // 
            // ImgZoomIn
            // 
            this.ImgZoomIn.Image = ((System.Drawing.Image)(resources.GetObject("ImgZoomIn.Image")));
            this.ImgZoomIn.Location = new System.Drawing.Point(816, 7);
            this.ImgZoomIn.Name = "ImgZoomIn";
            this.ImgZoomIn.Size = new System.Drawing.Size(32, 31);
            this.ImgZoomIn.TabIndex = 31;
            this.ImgZoomIn.TabStop = false;
            this.ImgZoomIn.Click += new System.EventHandler(this.ImgZoomIn_Click);
            this.ImgZoomIn.MouseEnter += new System.EventHandler(this.ImgZoomIn_MouseEnter);
            // 
            // pictureBox3
            // 
            this.pictureBox3.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.pictureBox3.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.pictureBox3.Location = new System.Drawing.Point(237, 499);
            this.pictureBox3.Name = "pictureBox3";
            this.pictureBox3.Size = new System.Drawing.Size(55, 55);
            this.pictureBox3.SizeMode = System.Windows.Forms.PictureBoxSizeMode.AutoSize;
            this.pictureBox3.TabIndex = 32;
            this.pictureBox3.TabStop = false;
            this.pictureBox3.Visible = false;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ScrollBar;
            this.ClientSize = new System.Drawing.Size(941, 622);
            this.Controls.Add(this.pictureBox3);
            this.Controls.Add(this.ImgZoomIn);
            this.Controls.Add(this.ImgZoomOut);
            this.Controls.Add(this.ImgCenter);
            this.Controls.Add(this.pictureBox2);
            this.Controls.Add(this.LabelRegiaoSul);
            this.Controls.Add(this.LabelRegiaoSudeste);
            this.Controls.Add(this.LabelRegiaoCentroOeste);
            this.Controls.Add(this.LabelRegiaoNordeste);
            this.Controls.Add(this.LabelRegiaoNorte);
            this.Controls.Add(this.txtArquivoPExtrair);
            this.Controls.Add(this.LabelBaseDeDados);
            this.Controls.Add(this.ImgPastaFechada);
            this.Controls.Add(this.sfMap1);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.ArquivoSelecionado);
            this.Controls.Add(this.imgLabel);
            this.Controls.Add(this.txtNomeArquivo);
            this.Controls.Add(this.btnBuscar);
            this.Font = new System.Drawing.Font("Century Gothic", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "JavaPastry";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.Click += new System.EventHandler(this.Form1_Click);
            this.MouseMove += new System.Windows.Forms.MouseEventHandler(this.Form1_MouseMove);
            ((System.ComponentModel.ISupportInitialize)(this.ImgCenter)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.ImgPastaFechada)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.ImgZoomOut)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.ImgZoomIn)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnBuscar;
        private System.Windows.Forms.TextBox txtNomeArquivo;
        private System.Windows.Forms.Label imgLabel;
        private System.Windows.Forms.Label ArquivoSelecionado;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.PictureBox ImgPastaFechada;
        private System.Windows.Forms.Label LabelBaseDeDados;
        private System.Windows.Forms.TextBox txtArquivoPExtrair;
        private System.Windows.Forms.Label LabelRegiaoNorte;
        private System.Windows.Forms.Label LabelRegiaoNordeste;
        private System.Windows.Forms.Label LabelRegiaoCentroOeste;
        private System.Windows.Forms.Label LabelRegiaoSudeste;
        private System.Windows.Forms.Label LabelRegiaoSul;
        private System.Windows.Forms.PictureBox pictureBox2;
        private EGIS.Controls.SFMap sfMap1;
        private System.Windows.Forms.PictureBox ImgCenter;
        private System.Windows.Forms.PictureBox ImgZoomOut;
        private System.Windows.Forms.PictureBox ImgZoomIn;
        private System.Windows.Forms.PictureBox pictureBox3;
    }
}

