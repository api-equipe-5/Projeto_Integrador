package org.fatec.shapegis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FtPontoDrenagem {
	private int pdr_cd;
	private String pdr_cd_curso_dagua;
	private String pdr_ds;
	private String geom;

}
