import pandas as pd
import os

low_memory = False
local = os.environ['temp']

NORTE = ["ACRE", "AMAPA", "AMAZONAS", "PARA", "RONDONIA","RORAIMA", "TOCANTINS"]
NORDESTE = ["ALAGOAS", "BAHIA", "CEARA", "MARANHAO", "PARAIBA", "PERNAMBUCO", "PIAUI", "RIO GRANDE DO NORTE", "SERGIPE"]
CENTRO_OESTE = ["DISTRITO FEDERAL", "GOIAS", "MATO GROSSO", "MATO GROSSO DO SUL"]
SUDESTE = ["ESPIRITO SANTO", "MINAS GERAIS", "RIO DE JANEIRO", "SAO PAULO"]
SUL = ["PARANA","RIO GRANDE DO SUL","SANTA CATARINA"]

df_PSF = pd.read_csv(f'{local}\PSF_NOVO.csv', delimiter=',', encoding='iso-8859-1')
df_END_PSF = pd.read_csv(f'{local}\END_PSF_NOVO.csv', delimiter=',', encoding='iso-8859-1')
df_OPR = pd.read_csv(f'{local}\OPR_NOVO.csv', delimiter=',', encoding='iso-8859-1')

df_PSF = df_PSF.rename(columns={'id': 'ID', 'cpf': 'CPF'})
df_END_PSF = df_END_PSF.rename(columns={'id_pessoa_fisica': 'ID'})
df_OPR = df_OPR.rename(columns={'doc_cli': 'CPF'})

df_OPRuPSF = pd.merge(df_OPR, df_PSF, on='CPF')
del df_OPR, df_PSF

df_OPRuPSFuEndPsf = pd.merge(df_OPRuPSF, df_END_PSF, on='ID')
del df_OPRuPSF, df_END_PSF

df_OPRuPSFuEndPsf['vlr_ctrd_fta_tfm'] = df_OPRuPSFuEndPsf['vlr_ctrd_fta_tfm'].astype('float64')

df_Total_B05_REM = df_OPRuPSFuEndPsf.query('(cod_mdl == "B05")')
del df_OPRuPSFuEndPsf

df_Total_B05_REM = df_Total_B05_REM.drop(columns=['id_opr_cad_pos','CPF','tip_cli','qtd_pcl','dat_vct_ult_pcl','sdo_ddr_tfm','vlr_ctrd', 'id_ult_rss_opr', 'id_mdl', 'cod_mdl', 'id_fnt', 'ID', 'idc_sexo', 'ano_dat_nascimento', 'nom_cidade'])

df_Total_B05_REM['REGIAO'], df_Total_B05_REM['FAIXA'] = 'NaN', 'NaN'

for index, row in df_Total_B05_REM.iterrows():
    
    if row['des_estado'] in NORTE:
        df_Total_B05_REM.loc[index,'REGIAO'] =  str('NORTE')
        
    elif row['des_estado'] in NORDESTE:
        df_Total_B05_REM.loc[index,'REGIAO'] =  str('NORDESTE')
        
    elif row['des_estado'] in CENTRO_OESTE:
        df_Total_B05_REM.loc[index,'REGIAO'] =  str('CENTRO-OESTE')
        
    elif row['des_estado'] in SUDESTE:
        df_Total_B05_REM.loc[index,'REGIAO'] =  str('SUDESTE')
        
    elif row['des_estado'] in SUL:
        df_Total_B05_REM.loc[index,'REGIAO'] =  str('SUL')
        
    
    if row['vlr_ctrd_fta_tfm'] <= 50000:
        df_Total_B05_REM.loc[index,'FAIXA'] =  str('0-50')
        
    elif row['vlr_ctrd_fta_tfm'] > 50000 and row['vlr_ctrd_fta_tfm'] <= 100000:
        df_Total_B05_REM.loc[index,'FAIXA'] =  str('50-100')
        
    elif row['vlr_ctrd_fta_tfm'] > 100000 and row['vlr_ctrd_fta_tfm'] <= 150000:
        df_Total_B05_REM.loc[index,'FAIXA'] =  str('100-150')
        
    elif row['vlr_ctrd_fta_tfm'] > 150000 and row['vlr_ctrd_fta_tfm'] <= 200000:
        df_Total_B05_REM.loc[index,'FAIXA'] =  str('150-200')
    
    elif row['vlr_ctrd_fta_tfm'] > 200000:
        df_Total_B05_REM.loc[index,'FAIXA'] =  str('200+')

df_Total_B05_REM = df_Total_B05_REM.query('(REGIAO != "NaN")')
   
df_NORTE = df_Total_B05_REM.query('(des_estado == "ACRE") or (des_estado == "AMAPA") or (des_estado == "AMAZONAS") or (des_estado == "PARA") or (des_estado == "RONDONIA") or (des_estado == "RORAIMA") or (des_estado == "TOCANTINS")')
df_ACRE = df_Total_B05_REM.query('(des_estado == "ACRE")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_AMAPA = df_Total_B05_REM.query('(des_estado == "AMAPA")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_AMAZONAS = df_Total_B05_REM.query('(des_estado == "AMAZONAS")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_PARA = df_Total_B05_REM.query('(des_estado == "PARA")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_RONDONIA = df_Total_B05_REM.query('(des_estado == "RONDONIA")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_RORAIMA = df_Total_B05_REM.query('(des_estado == "RORAIMA")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_TOCANTINS = df_Total_B05_REM.query('(des_estado == "TOCANTINS")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])

df_NORDESTE = df_Total_B05_REM.query('(des_estado == "ALAGOAS") or (des_estado == "BAHIA") or (des_estado == "CEARA") or (des_estado == "MARANHAO") or (des_estado == "PARAIBA") or (des_estado == "PERNAMBUCO") or (des_estado == "PIAUI") or (des_estado == "RIO GRANDE DO NORTE") or (des_estado == "SERGIPE")')
df_ALAGOAS = df_Total_B05_REM.query('(des_estado == "ALAGOAS")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_BAHIA = df_Total_B05_REM.query('(des_estado == "BAHIA")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_CEARA = df_Total_B05_REM.query('(des_estado == "CEARA")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_MARANHAO = df_Total_B05_REM.query('(des_estado == "MARANHAO")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_PARAIBA = df_Total_B05_REM.query('(des_estado == "PARAIBA")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_PERNAMBUCO = df_Total_B05_REM.query('(des_estado == "PERNAMBUCO")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_PIAUI = df_Total_B05_REM.query('(des_estado == "PIAUI")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_RIO_GRANDE_DO_NORTE = df_Total_B05_REM.query('(des_estado == "RIO GRANDE DO NORTE")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_SERGIPE = df_Total_B05_REM.query('(des_estado == "SERGIPE")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])

df_CENTRO_OESTE = df_Total_B05_REM.query('(des_estado == "DISTRITO FEDERAL") or (des_estado == "GOIAS") or (des_estado == "MATO GROSSO") or (des_estado == "MATO GROSSO DO SUL")')
df_DISTRITO_FEDERAL = df_Total_B05_REM.query('(des_estado == "DISTRITO FEDERAL")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_GOIAS = df_Total_B05_REM.query('(des_estado == "GOIAS")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_MATO_GROSSO = df_Total_B05_REM.query('(des_estado == "MATO GROSSO")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_MATO_GROSSO_DO_SUL = df_Total_B05_REM.query('(des_estado == "MATO GROSSO DO SUL")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])

df_SUDESTE = df_Total_B05_REM.query('(des_estado == "ESPIRITO SANTO") or (des_estado == "MINAS GERAIS") or (des_estado == "RIO DE JANEIRO") or (des_estado == "SAO PAULO")')
df_ESPIRITO_SANTO = df_Total_B05_REM.query('(des_estado == "ESPIRITO SANTO")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_MINAS_GERAIS = df_Total_B05_REM.query('(des_estado == "MINAS GERAIS")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_RIO_DE_JANEIRO = df_Total_B05_REM.query('(des_estado == "RIO DE JANEIRO")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_SAO_PAULO = df_Total_B05_REM.query('(des_estado == "SAO PAULO")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])

df_SUL = df_Total_B05_REM.query('(des_estado == "PARANA") or (des_estado == "RIO GRANDE DO SUL") or (des_estado == "SANTA CATARINA")')
df_PARANA = df_Total_B05_REM.query('(des_estado == "PARANA")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_RIO_GRANDE_DO_SUL = df_Total_B05_REM.query('(des_estado == "RIO GRANDE DO SUL")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])
df_SANTA_CATARINA = df_Total_B05_REM.query('(des_estado == "SANTA CATARINA")').drop(columns=['des_estado', 'REGIAO', 'FAIXA'])

df_BRASIL = df_Total_B05_REM
df_BRASIL = df_BRASIL.rename(columns={'vlr_ctrd_fta_tfm': 'BRASIL', 'des_estado': 'ESTADO'})

df_NORTE = df_NORTE.join(df_ACRE, lsuffix='_norte', rsuffix='_acre')
df_NORTE = df_NORTE.join(df_AMAPA, lsuffix='_acre', rsuffix='_amapa')
df_NORTE = df_NORTE.join(df_AMAZONAS, lsuffix='_amapa', rsuffix='_amazonas')
df_NORTE = df_NORTE.join(df_PARA, lsuffix='_amazonas', rsuffix='_para') 
df_NORTE = df_NORTE.join(df_RONDONIA, lsuffix='_para', rsuffix='_rondonia')
df_NORTE = df_NORTE.join(df_RORAIMA, lsuffix='_rondonia', rsuffix='_roraima')
df_NORTE = df_NORTE.join(df_TOCANTINS, lsuffix='_roraima', rsuffix='_tocantins')
df_NORTE = df_NORTE.rename(columns={'des_estado': 'ESTADO', 'vlr_ctrd_fta_tfm_norte': 'NORTE', 'vlr_ctrd_fta_tfm_acre': 'ACRE',
                                   'vlr_ctrd_fta_tfm_amapa': 'AMAPA', 'vlr_ctrd_fta_tfm_amazonas': 'AMAZONAS',
                                   'vlr_ctrd_fta_tfm_para': 'PARA', 'vlr_ctrd_fta_tfm_rondonia': 'RONDONIA',
                                   'vlr_ctrd_fta_tfm_roraima': 'RORAIMA', 'vlr_ctrd_fta_tfm_tocantins': 'TOCANTINS'})

df_NORDESTE = df_NORDESTE.join(df_ALAGOAS, lsuffix='_nodeste', rsuffix='_alagoas')
df_NORDESTE = df_NORDESTE.join(df_BAHIA, lsuffix='_alagoas', rsuffix='_bahia')
df_NORDESTE = df_NORDESTE.join(df_CEARA, lsuffix='_bahia', rsuffix='_ceara')
df_NORDESTE = df_NORDESTE.join(df_MARANHAO, lsuffix='_ceara', rsuffix='_maranhao')
df_NORDESTE = df_NORDESTE.join(df_PARAIBA, lsuffix='_maranhao', rsuffix='_paraiba')
df_NORDESTE = df_NORDESTE.join(df_PERNAMBUCO, lsuffix='_paraiba', rsuffix='_pernambuco')
df_NORDESTE = df_NORDESTE.join(df_PIAUI, lsuffix='_pernambuco', rsuffix='_piaui')
df_NORDESTE = df_NORDESTE.join(df_RIO_GRANDE_DO_NORTE, lsuffix='_piaui', rsuffix='_rio_grande_do_norte')
df_NORDESTE = df_NORDESTE.join(df_SERGIPE,lsuffix='_rio_grande_do_norte', rsuffix='_sergipe')
df_NORDESTE = df_NORDESTE.rename(columns={'des_estado': 'ESTADO', 'vlr_ctrd_fta_tfm_nodeste': 'NORDESTE', 'vlr_ctrd_fta_tfm_alagoas': 'ALAGOAS',
                                   'vlr_ctrd_fta_tfm_bahia': 'BAHIA', 'vlr_ctrd_fta_tfm_ceara': 'CEARA',
                                   'vlr_ctrd_fta_tfm_maranhao': 'MARANHAO', 'vlr_ctrd_fta_tfm_paraiba': 'PARAIBA',
                                   'vlr_ctrd_fta_tfm_pernambuco': 'PERNAMBUCO', 'vlr_ctrd_fta_tfm_piaui': 'PIAUI',
                                   'vlr_ctrd_fta_tfm_rio_grande_do_norte': 'RIO GRANDE DO NORTE', 'vlr_ctrd_fta_tfm_sergipe': 'SERGIPE'})

df_CENTRO_OESTE = df_CENTRO_OESTE.join(df_DISTRITO_FEDERAL, lsuffix='_centro_oeste', rsuffix='_distrito_federal')
df_CENTRO_OESTE = df_CENTRO_OESTE.join(df_GOIAS, lsuffix='_distrito_federal', rsuffix='_goias')
df_CENTRO_OESTE = df_CENTRO_OESTE.join(df_MATO_GROSSO, lsuffix='_goias', rsuffix='_mato_grosso')
df_CENTRO_OESTE = df_CENTRO_OESTE.join(df_MATO_GROSSO_DO_SUL, lsuffix='_mato_grosso', rsuffix='_mato_grosso_do_sul')
df_CENTRO_OESTE = df_CENTRO_OESTE.rename(columns={'des_estado': 'ESTADO', 'vlr_ctrd_fta_tfm_centro_oeste': 'CENTRO OESTE', 
                                                  'vlr_ctrd_fta_tfm_distrito_federal': 'DISTRITO FEDERAL',
                                                  'vlr_ctrd_fta_tfm_goias': 'GOIAS', 
                                                  'vlr_ctrd_fta_tfm_mato_grosso': 'MATO GROSSO',
                                                  'vlr_ctrd_fta_tfm': 'MATO GROSSO DO SUL'})

df_SUDESTE = df_SUDESTE.join(df_ESPIRITO_SANTO, lsuffix='_sudeste', rsuffix='_espirito_santo')
df_SUDESTE = df_SUDESTE.join(df_MINAS_GERAIS, lsuffix='_espirito_santo', rsuffix='_minas_gerais')
df_SUDESTE = df_SUDESTE.join(df_RIO_DE_JANEIRO, lsuffix='_minas_gerais', rsuffix='_rio_de_janeiro')
df_SUDESTE = df_SUDESTE.join(df_SAO_PAULO, lsuffix='_rio_de_janeiro', rsuffix='_sao_paulo')
df_SUDESTE = df_SUDESTE.rename(columns={'des_estado': 'ESTADO', 'vlr_ctrd_fta_tfm_sudeste': 'SUDESTE', 
                                                  'vlr_ctrd_fta_tfm_espirito_santo': 'ESPIRITO SANTO',
                                                  'vlr_ctrd_fta_tfm_minas_gerais': 'MINAS GERAIS', 
                                                  'vlr_ctrd_fta_tfm_rio_de_janeiro': 'RIO DE JANEIRO',
                                                  'vlr_ctrd_fta_tfm': 'SAO PAULO'})

df_SUL = df_SUL.join(df_PARANA, lsuffix='_sul', rsuffix='_parana')
df_SUL = df_SUL.join(df_RIO_GRANDE_DO_SUL, lsuffix='_parana', rsuffix='_rio_grande_do_sul')
df_SUL = df_SUL.join(df_SANTA_CATARINA,lsuffix='_rio_grande_do_sul', rsuffix='_santa_catarina')
df_SUL = df_SUL.rename(columns={'des_estado': 'ESTADO', 'vlr_ctrd_fta_tfm_sul': 'SUL', 
                                'vlr_ctrd_fta_tfm_parana': 'PARANA',
                                'vlr_ctrd_fta_tfm_rio_grande_do_sul': 'RIO GRANDE DO SUL', 
                                'vlr_ctrd_fta_tfm_santa_catarina': 'SANTA CATARINA'})

del df_Total_B05_REM, df_ACRE, df_AMAPA, df_AMAZONAS, df_PARA, df_RONDONIA, df_RORAIMA, df_TOCANTINS, df_ALAGOAS, df_BAHIA, df_CEARA, df_MARANHAO, df_PARAIBA, df_PERNAMBUCO, df_PIAUI, df_RIO_GRANDE_DO_NORTE, df_SERGIPE, df_DISTRITO_FEDERAL, df_MATO_GROSSO, df_GOIAS, df_MATO_GROSSO_DO_SUL, df_ESPIRITO_SANTO, df_MINAS_GERAIS, df_RIO_DE_JANEIRO, df_SAO_PAULO, df_PARANA, df_RIO_GRANDE_DO_SUL, df_SANTA_CATARINA
