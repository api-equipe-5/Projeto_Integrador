package org.fatec.shapegis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FtCursoDagua {
	private int cda_cd;
	private String cda_cd_otto;
	private Double cda_nu_dist_bh;
	private Double cda_nu_comp;
	private Double cda_ar_bacia;
	private String cda_cd_desagua;
	private int cda_nu_nivel_otto;
	private int cda_nu_ordem;
	private String cda_ds_dominialidade;	
	
}
