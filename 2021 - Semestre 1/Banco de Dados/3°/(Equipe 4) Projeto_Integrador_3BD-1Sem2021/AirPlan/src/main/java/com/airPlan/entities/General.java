package com.airPlan.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.stream.Stream;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class General {

    private String flg_secundary;

    private String flg_secundary_id;

    private String cdl_section;

    private String cdl_sub_section;

    private String cdl_block_number;

    private String cdl_block_name;

    private String cdl_code;

    private String flg_tag;

    private String mnl_name;

    private String emp_name;

    private String emp_password;

    private String emp_confirm_password;

    private Integer typ_id;

    private String emp_last_name;

    private General[] codelist = new General[3];

    public Integer addLista(General[] general, CodeList[] codeListModel, User user) {
        int count = 3;
        for (int i = 0; i < 3; i++) {
            if (general[i].getFlg_secundary().equals("")) {
                --count;
                continue;
            } else {
                codeListModel[i] = new CodeList(i, general[i].getFlg_secundary().equals("")? null : general[i].getFlg_secundary(),
                        general[i].getCdl_section().equals("")? null : general[i].getCdl_section(),
                        general[i].getCdl_block_number().equals("")? null : Integer.parseInt(general[i].getCdl_block_number()), general[i].getCdl_sub_section(),
                        general[i].getCdl_block_name(), general[i].getCdl_code().equals("")? null : Integer.parseInt(general[i].getCdl_code()), user.getEmp_id());
            }
        }
        return count;
    }

    public Integer verification(int count, CodeList[] codeListModel) {
        for (int i = 0; i < count; i++) {
            if(codeListModel[i].getFlg_secundary() == null || codeListModel[i].getCdl_section() == null ||
            codeListModel[i].getCdl_block_number() == null){
                count = 0;
                break;
            }
        }
        return count;
    }
}

