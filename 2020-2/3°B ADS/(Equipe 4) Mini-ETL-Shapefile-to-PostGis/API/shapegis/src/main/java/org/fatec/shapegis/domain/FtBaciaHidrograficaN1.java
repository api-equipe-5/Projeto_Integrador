package org.fatec.shapegis.domain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.geotools.data.DataStore;
import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.Query;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.opengis.feature.Property;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@Data
@RestController
@RequestMapping("/ftbacia")
public class FtBaciaHidrograficaN1 {
	private int bhi_cd;
	private String bhi_cd_otto;
	private Double bhi_ar;
	private String geom;
	private DataStore dataStore;

	@RequestMapping("/colshape")
	// http://localhost:8080/ftbacia/colshape
	private ArrayList<String> getAttibute() throws IOException {
		ArrayList<String> fields = new ArrayList<String>();
		File file = new File(
				"C:\\Users\\Daniel S. Oliveira\\Documents\\AGENCIA_NACIONAL_AGUAS\\geoft_bho_2017_curso_dagua\\geoft_bho_2017_curso_dagua.shp");
		FileDataStore myData = FileDataStoreFinder.getDataStore(file);
		SimpleFeatureSource source = myData.getFeatureSource();
		SimpleFeatureType schema = source.getSchema();

		Query query = new Query(schema.getTypeName());
		query.setMaxFeatures(1);

		FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures(query);
		try (FeatureIterator<SimpleFeature> features = collection.features()) {
			while (features.hasNext()) {
				SimpleFeature feature = features.next();

				for (Property attribute : feature.getProperties()) {
					fields.add(attribute.getName().toString());
				}
			}
		}
		return fields;
	}
}

// @joao - POM utilizado para as soluções implementadas
// Apagar este comentário quando atualizar o POM do projeto por favor!
/**
 * 
 * <?xml version="1.0" encoding="UTF-8"?>
<!-- Este arquivo contem as dependências que serão utilizadas no projeto -->

<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">

	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.2.10.RELEASE</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>
	<groupId>org.fatec</groupId>
	<artifactId>shapegis</artifactId>
	<version>1.0.0</version>
	<name>shapegis</name>
	<description>Projeto mini ETL Shapefile to PostGis</description>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<geotools.version>24-SNAPSHOT</geotools.version>
		<java.version>11</java.version>
		<path.shared.gdal>/path/to/apache-tomcat/shared/lib</path.shared.gdal>
		<geotools.version>25-SNAPSHOT</geotools.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<dependency>
			<!-- Ferramenta utilizada para atualizar automaticamente as atualizações 
				no projeto -->
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.11</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.geotools</groupId>
			<artifactId>gt-shapefile</artifactId>
			<version>${geotools.version}</version>
		</dependency>
		<dependency>
			<groupId>org.geotools</groupId>
			<artifactId>gt-swing</artifactId>
			<version>${geotools.version}</version>
		</dependency>
		<dependency>
			<groupId>org.geotools.jdbc</groupId>
			<artifactId>gt-jdbc-postgis</artifactId>
			<version>${geotools.version}</version>
		</dependency>
		<dependency>
			<groupId>org.geotools.xsd</groupId>
			<artifactId>gt-xsd-gml3</artifactId>
			<version>24.0</version>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
			<plugin>
				<inherited>true</inherited>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
				</configuration>
			</plugin>
		</plugins>
	</build>
	<repositories>
		<repository>
			<id>osgeo</id>
			<name>OSGeo Release Repository</name>
			<url>https://repo.osgeo.org/repository/release/</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
			<releases>
				<enabled>true</enabled>
			</releases>
		</repository>
		<repository>
			<id>osgeo-snapshot</id>
			<name>OSGeo Snapshot Repository</name>
			<url>https://repo.osgeo.org/repository/snapshot/</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
			<releases>
				<enabled>false</enabled>
			</releases>
		</repository>
	</repositories>

</project>

 */