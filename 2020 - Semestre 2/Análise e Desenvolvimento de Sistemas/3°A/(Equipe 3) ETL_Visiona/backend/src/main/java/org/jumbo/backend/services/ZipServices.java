/*****************************************************************/
/* Copyright 2013 Code Strategies                                */
/* This code may be freely used and distributed in any project.  */
/* However, please do not remove this credit if you publish this */
/* code in paper or electronic form, such as on a web site.      */
/*****************************************************************/
/* JumboETL Comments                                             */
/* The presented code was changed to fit the requirements of     */
/* this project.                                                 */
/*****************************************************************/

package org.jumbo.backend.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipServices {

	public static void zipDirectory(String pastaCriada, String table, String palavraAleatoria) throws IOException {
		System.out.println("\tIniciando processo de criação do arquivo compactado");
		File directoryToZip = new File(pastaCriada);

		List<File> fileList = new ArrayList<File>();
		System.out
				.println("\tColetando o nome de todos os arquivos do diretório: " + directoryToZip.getCanonicalPath());
		getAllFiles(directoryToZip, fileList);
		System.out.println("\tCriando o arquivo compactado");
		writeZipFile(directoryToZip, fileList, table, palavraAleatoria);
		System.out.println("\tArquivo compactado gerado");
	}

	public static void getAllFiles(File dir, List<File> fileList) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				fileList.add(file);
				if (file.isDirectory()) {
					System.out.println("\t\tDiretório: " + file.getCanonicalPath());
					getAllFiles(file, fileList);
				} else {
					System.out.println("\t\tArquivo: " + file.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeZipFile(File directoryToZip, List<File> fileList, String table, String palavraAleatoria) {

		try {
			FileOutputStream fos = new FileOutputStream(
					System.getProperty("user.dir") + "\\jumbo_despacha\\" + table + "-" + palavraAleatoria + ".zip");
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (File file : fileList) {
				if (!file.isDirectory()) { // we only zip files, not directories
					addToZip(directoryToZip, file, zos);
				}
			}

			zos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addToZip(File directoryToZip, File file, ZipOutputStream zos)
			throws FileNotFoundException, IOException {

		FileInputStream fis = new FileInputStream(file);

		// we want the zipEntry's path to be a relative path that is relative
		// to the directory being zipped, so chop off the rest of the path
		String zipFilePath = file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() + 1,
				file.getCanonicalPath().length());
		System.out.println("\t\tEscrevendo '" + zipFilePath + "' no arquivo compactado");
		ZipEntry zipEntry = new ZipEntry(zipFilePath);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}

		zos.closeEntry();
		fis.close();
	}

}
