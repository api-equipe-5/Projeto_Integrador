from cx_Freeze import setup, Executable

base = "Win32GUI"
 
setup(name='METAapp',
    version='1.0',
    description='descrição do programa',
    options={'build_exe': {'packages': ['pandas', 'numpy', 'plotly',
                                        'xlrd', 'jinja2', 'PIL']}},
    executables = [Executable(
                   script='METAapp_4.py',
                   base=base,
		   icon='./imgs/icon.ico'
                   )
                  ]
)
