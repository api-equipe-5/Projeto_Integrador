package br.com.fatec.model;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ToConvert
{
    private void run(final String command) throws IOException, InterruptedException {
        final Process p = Runtime.getRuntime().exec("cmd cmd.exe /c " + command);
        System.out.println(command);
        final BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        final BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        String output;
        while ((output = stdInput.readLine()) != null) {
            System.out.println(output);
        }
        while ((output = stdError.readLine()) != null) {
            System.out.println(output);
        }
        p.waitFor();
        System.out.println("Process finished !\n");
    }
    
    public void shapeToPost(final String pathFile) throws IOException, InterruptedException {
        System.out.printf("Op: Shapefile to PostgreSQL\nFile: %s\n", pathFile);
        final Path path = Paths.get(pathFile, new String[0]);
        final String fileName = path.getFileName().toString().replace(".shp", "");
        final String temp = "shp2pgsql -d -D %s fatecsjc.\"temp_%s\" | psql -h localhost -d postgis -U postgres";
        final String command = String.format(temp, pathFile, fileName);
        this.run(command);
    }
    
    public void postToShape(final String pathFile, final String tableName) throws IOException, InterruptedException {
        System.out.printf("Op: PostgreSQL To Shapefile \nFile: %s\nTableName: %s\n", pathFile, tableName);
        final String temp = "pgsql2shp -f %s -h localhost -u postgres postgis fatecsjc.\"%s\"";
        final String command = String.format(temp, pathFile, tableName);
        this.run(command);
    }
}