import zipfile
import os
filename = "ft_ponto_drenagem"
downloadedFileName = f'{filename}.zip'
DOWNLOAD_FOLDER = os.path.join(os.getcwd(), 'download')
extensions = [".shp", ".shx", ".dbf", ".cpg", ".prj", ".qix"]
downloadedFile = zipfile.ZipFile(f'{DOWNLOAD_FOLDER}/' + downloadedFileName, 'w')

for extension in extensions:
    try:
        downloadedFile.write(f'download/{filename}/' + filename + extension, arcname = filename + extension)
    except:
        pass


downloadedFile.close()
