import pandas as pd

'''
pessoa_fisica = pd.read_csv("/Dados/Complementares/fatec_pessoa_fisica.cvs", sep = '|', encoding='UTF-8', header = 1)
endereco_pessoa_fisica = pd.read_csv("/Dados/Complementares/fatec_endereco_pessoa_fisica.csv", sep = '|', encoding='UTF-8', header = 1)
fatec_operacao = pd.read_csv("/Dados/Complementares/fatec_opr.csv", sep = '|', encoding='UTF-8', header = 1)
fatec_movimento = pd.read_csv("/Dados/Complementares/fatec_mvt.csv", sep = '|', encoding='UTF-8', header = 1)
fatec_pagamento = pd.read_csv("/Dados/Complementares/fatec_pgt.csv", sep = '|', encoding='UTF-8', header = 1)

pessoa_fisica_colunas = pessoa_fisica.columns[1:len(pessoa_fisica.columns) - 1]
endereco_pessoa_fisica_colunas = endereco_pessoa_fisica.columns[1:len(endereco_pessoa_fisica.columns) - 1]
fatec_operacao_colunas = fatec_operacao.columns[1:len(fatec_operacao.columns) - 1]
fatec_movimento_colunas = fatec_movimento.columns[1:len(fatec_movimento.columns) - 1]
fatec_pagamento_colunas = fatec_pagamento.columns[1:len(fatec_pagamento.columns) - 1]

coluna_pessoa_fisica = pessoa_fisica.columns[1]
coluna_endereco_pessoa_fisica = endereco_pessoa_fisica.columns[1]
coluna_fatec_operacao = fatec_operacao.columns[1]
coluna_fatec_movimento = fatec_movimento.columns[1]
coluna_fatec_pagamento = fatec_pagamento.columns[1]

pessoa_fisica = pd.DataFrame(pessoa_fisica, columns = pessoa_fisica_colunas)
endereco_pessoa_fisica = pd.DataFrame(endereco_pessoa_fisica, columns = endereco_pessoa_fisica_colunas)
fatec_operacao = pd.DataFrame(fatec_operacao, columns = fatec_operacao_colunas)
fatec_movimento = pd.DataFrame(fatec_movimento, columns = fatec_movimento_colunas)
fatec_pagamento = pd.DataFrame(fatec_pagamento, columns = fatec_pagamento_colunas)
pessoa_fisica.columns = ['id', 'cpf', 'idc_sexo', 'ano_dat_nascimento']
endereco_pessoa_fisica.columns = ['id_pessoa_fisica', 'nom_cidade', 'des_estado']
fatec_operacao.columns = ['id_opr_cad_pos', 'doc_cli', 'tip_cli', 'qtd_pcl', 'dat_vct_ult_pcl', 'vlr_ctrd_fta_tfm', 'sdo_ddr_tfm', 'vlr_ctrd', 'id_ult_rss_opr', 'id_mdl', 'cod_mdl', 'id_fnt']
fatec_movimento.columns = ['id_opr_cad_pos', 'id_mvt_cad_pos', 'dat_vct', 'qtd_pcl_vnc', 'qtd_pcl_pgr', 'vlr_tot_fat_tfm',	'vlr_min_fat_tfm', 'vlr_pcl_tfm', 'tip_mvt', 'prd']
fatec_pagamento.columns = ['id_opr_cad_pos', 'id_mvt_cad_pos', 'id_pgt_cad_pos', 'dat_pgt', 'dat_vct_tfm', 'vlr_pgt_tfm', 'cod_mdl', 'cmd']

pessoa_fisica = pessoa_fisica[(pd.isna(pessoa_fisica['cpf']) != True)]
endereco_pessoa_fisica = endereco_pessoa_fisica[(pd.isna(endereco_pessoa_fisica['id_pessoa_fisica']) != True)]
fatec_operacao = fatec_operacao[(pd.isna(fatec_operacao['id_opr_cad_pos']) != True)]
fatec_movimento = fatec_movimento[(pd.isna(fatec_movimento['id_opr_cad_pos']) != True)]
fatec_pagamento = fatec_pagamento[(pd.isna(fatec_pagamento['id_opr_cad_pos']) != True)]

pessoa_fisica = pessoa_fisica[(pessoa_fisica['id'] != coluna_pessoa_fisica)]
endereco_pessoa_fisica = endereco_pessoa_fisica[(endereco_pessoa_fisica['id_pessoa_fisica'] != coluna_endereco_pessoa_fisica)]
fatec_operacao = fatec_operacao[(fatec_operacao['id_opr_cad_pos'] != coluna_fatec_operacao)]
fatec_movimento = fatec_movimento[(fatec_movimento['id_opr_cad_pos'] != coluna_fatec_movimento)]
fatec_pagamento = fatec_pagamento[(fatec_pagamento['id_opr_cad_pos'] != coluna_fatec_pagamento)]

'''

