import React, { useState } from 'react';
import { Radio, Form, Input } from 'antd';



export const Tipo = () => {
    const [tipo,setTipo] = useState('');
    const onChangeTipo = (e) => {
        const tipo = e.target.value;
        setTipo(tipo);
    };

    return(
        <>
        <Form.Item
          name={['user', 'tipo']}
          rules={[
            {
              required: true,
            },
          ]}
        >
          <Radio.Group onChange={onChangeTipo}>
          <Radio value="Administrador">Administrador</Radio>
          <Radio value="Gerente">Gerente</Radio>
          <Radio value="Colaborador">Colaborador</Radio>
          </Radio.Group>
        </Form.Item>
        </>
    );
};

export const Nome = () => {
    const [nome,setNome] = useState('');
    const onChangeNome = (e) => {
        const nome = e.target.value;
        setNome(nome);
    };

    return(
        <>
        <Form.Item
          name={['user', 'nome']}
          rules={[
            {
              required: true,
            },
          ]}
        >
          <Input placeholder='Nome' onChange={onChangeNome} />
        </Form.Item>
        </>
    );
};

export const Email = () => {
    const [email,setEmail] = useState('');
    const onChangeEmail = (e) => {
        const email = e.target.value;
        setEmail(email);
    };

    return(
        <>
        <Form.Item
          name={['user', 'email']}
          rules={[
            {
              type: 'email',
              required: true,
            },
          ]}
        >
          <Input placeholder='E-mail' onChange={onChangeEmail} />
        </Form.Item>
        </>
    );
};

export const Senha = () => {
    const [senha,setSenha] = useState('');
    const onChangeSenha = (e) => {
        const senha = e.target.value;
        setSenha(senha);
    };

    return(
        <Form.Item
          name={['user', 'senha']}
          rules={[
            {
              required: true,
            },
          ]}
        >
          <Input type='password' maxLength='8' placeholder='Senha' onChange={onChangeSenha} />
        </Form.Item>
    );
};

export const Cargo = () => {
    const [cargo,setCargo] = useState('');
    const onChangeCargo = (e) => {
        const cargo = e.target.value;
        setCargo(cargo);
    };

    return(
        <Form.Item
        name={['user', 'cargo']}
        rules={[
          {
            required: true,
          },
        ]}
      >
        <Input placeholder='Cargo' onChange={onChangeCargo} />
      </Form.Item>
    );
};

export const Area = () => {
    const [area,setArea] = useState('');
    const onChangeArea = (e) => {
    const area = e.target.value;
    setArea(area);
    }
    return(
        <Form.Item
          name={['user', 'area']}
          rules={[
            {
              required: true,
            },
          ]}
        >
          <Input placeholder='Área' onChange={onChangeArea} />
      </Form.Item>
    );
};