from cx_Freeze import setup, Executable

base = "Win32GUI"
 
setup(name='METAapp_2',
    version='1.0',
    description='descrição do programa',
    options={'build_exe': {'packages': ['pandas', 'numpy', 'plotly', 'jinja2']}},
    executables = [Executable(
                   script='METAapp_3.py',
                   base=base
                   )
                  ]
)
