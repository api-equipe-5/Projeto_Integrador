package org.jumbo.backend;

import org.jumbo.backend.services.ShapefileServices;

public class Testes {

	public static void main(String[] args) throws Exception {

		String arquivo = "D:\\Mega\\jumboetl\\shp\\geoft_bho_2017_ponto_drenagem.shp";

//		ShapefileServices.readShpDataStore(arquivo);
		ShapefileServices.readShpQuery(arquivo, 1);
//		ShapefileServices.getShpCols(arquivo, 1);
//		
//		arquivo = "D:\\bak\\shp\\geoft_bho_2017_curso_dagua.shp";
//		ShapefileServices.getShpCols(arquivo, 1);
//		
//		arquivo = "D:\\bak\\shp\\geoft_bho_ach_otto_nivel_01.shp";
//		ShapefileServices.getShpCols(arquivo, 1);
//		
//		arquivo = "D:\\bak\\shp\\geoft_bho_2017_ponto_drenagem.shp";
//		ShapefileServices.getShpGeomType(arquivo);
//		
//		arquivo = "D:\\bak\\shp\\geoft_bho_2017_curso_dagua.shp";
//		ShapefileServices.getShpGeomType(arquivo);
//		
//		arquivo = "D:\\bak\\shp\\geoft_bho_ach_otto_nivel_01.shp";
//		ShapefileServices.getShpGeomType(arquivo);

	}

}
