package com.airPlan.entities;


import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "codelist")
public class CodeList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cdl_id;

    private Integer mnl_id;

    private String flg_secundary;

    private String cdl_section;

    private Integer cdl_block_number;

    private String cdl_sub_section;

    private String cdl_block_name;

    private Integer cdl_code;

    private Integer emp_id;

    public CodeList(Integer mnl_id, String flg_secundary, String cdl_section, Integer cdl_block_number,
                    String cdl_sub_section, String cdl_block_name, Integer cdl_code, Integer emp_id) {

        this.mnl_id = mnl_id;
        this.flg_secundary = flg_secundary.trim();
        this.cdl_section = cdl_section.trim();
        this.cdl_block_number = cdl_block_number;
        this.cdl_sub_section = cdl_sub_section;
        this.cdl_block_name = cdl_block_name.trim();
        this.cdl_code = cdl_code;
        this.emp_id = emp_id;
    }

}
