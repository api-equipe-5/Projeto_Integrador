package tools;

import java.io.File;
import java.io.FilenameFilter;

import shape.ShapeService;

public class FilterFile {
	
	ShapeService shape = new ShapeService();
	
	public void filtrandoArquivosShp() {
	  try {
		  File f = new File("C:\\Users\\Davi Machado\\Desktop\\ConsultCar\\Unzip\\");

          FilenameFilter filter = new FilenameFilter() {
              @Override
              public boolean accept(File f, String name) {
                  return name.endsWith(".shp");
              }
          };

          File[] files = f.listFiles(filter);

         
          for (int i = 0; i < files.length; i++) {
              			shape.shapeItem(files[i]);
              			
          }
      } catch (Exception e) {
          System.err.println(e.getMessage());
      }
	}
  }

	

