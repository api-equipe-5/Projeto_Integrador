import sys
from cx_Freeze import setup, Executable
from PyQt5.QtWidgets import QApplication, QMainWindow, QPushButton, QToolTip, QLabel, QLineEdit
from PyQt5 import QtGui

base = None
if sys.platform == "win32":
    base = "Win32GUI"

executables = [
        Executable("script.py", base=base)
]

buildOptions = dict(
        packages = [],
        includes = [],
        include_files = [],
        excludes = []
)




setup(
    name = "NomeDoPrograma",
    version = "1.0",
    description = "Descrição do programa",
    options = dict(build_exe = buildOptions),
    executables = executables
 )
