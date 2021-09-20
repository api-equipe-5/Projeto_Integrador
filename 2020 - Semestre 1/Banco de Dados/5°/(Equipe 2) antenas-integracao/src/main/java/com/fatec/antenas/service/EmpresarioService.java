package com.fatec.antenas.service;

import com.fatec.antenas.model.DocumentEmpresario;
import com.fatec.antenas.repository.EmpresarioRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class EmpresarioService {

    @Autowired
    private EmpresarioRepository empresarioRepository;

    public DocumentEmpresario ativaEmpresario(String b64) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(new String(Base64.getDecoder().decode(b64)));
            DocumentEmpresario empresario = empresarioRepository.findByEmail(jsonObject.get("email").toString());
            if (empresario == null) {
                return null;
            }
            empresario.setAtivo(true);
            return empresarioRepository.save(empresario);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
