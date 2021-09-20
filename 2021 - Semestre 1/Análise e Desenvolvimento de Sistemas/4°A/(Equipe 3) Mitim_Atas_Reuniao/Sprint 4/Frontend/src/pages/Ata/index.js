import React, { useState } from 'react';
import Navbar from '../../components/Navbar/navbar';
import rotaata from '../../components/Navbar/rotaata.json';
import { cadata, atas } from '../../services/crudata';
import { usuarios } from '../../services/crudusuario';
import { cadpart } from '../../services/crudparticipante';
import { cadast } from '../../services/crudassunto';
import { MinusCircleOutlined, PlusOutlined } from '@ant-design/icons';
import { Input, TimePicker, DatePicker, Form, Button, Space, Checkbox, message, Row, Col } from 'antd';
import moment from 'moment';
import { useHistory } from 'react-router-dom';
import md5 from 'md5';
import { LoadingScreen } from '../../components/Loading/loading';


function CriATA() {

    var ataGlobal = { codassinatura: "" };
    var partGlobal = [];
    var assuGlobal;
    var idata;
    var nota;
    var atapart;
    const [loading, setLoading] = useState(false);
    const [data, setData] = useState(null);
    const [inicio, setInicio] = useState(null);
    const [fim, setFim] = useState(null);
    const [dataCriacao, setDataCriacao] = useState(moment().format('DD-MM-YYYY'));
    const [prazo, setPrazo] = useState(null);
    const history = useHistory();

    const success = (mensagem) => {
        message.success(mensagem);
    };
    const warning = (mensagem) => {
        message.warning(mensagem);
    }
    const error = (mensagem) => {
        message.error(mensagem);
    }

    async function CadastrarAta(ataGlobal) {
        try {
            setLoading(true)
            const response = await cadata(ataGlobal);
            switch (response.data) {
                case ('Saved'):
                    buscarAta();
                    break;
                default:
                    nota = 'Erro ao criar Ata..';
                    error(nota);
                    setLoading(false)
                    break;
            }
        }
        catch (err) {
            nota = "Erro de conexão"
            error(nota);
            console.log(err);
            setLoading(false)
        }
    }

    const onFinishAta = values => {

        if (values.assuntos == null || values.participantes == null) {
            nota = 'Assunto e Participantes são obrigatórios';
            error(nota);

        }
        else {
            if (values.assuntos.length == 0 || values.participantes.length == 0) {
                nota = 'Assunto e Participantes são obrigatórios';
                error(nota);

            }
            else {
                if (values.participantes.length < 2) {
                    nota = 'Deve haver ao menos 2 participantes';
                    warning(nota);

                }
                else {
                    values.ata.inicio = inicio;
                    values.ata.data = data;
                    values.ata.prazo = prazo;
                    values.ata.fim = fim;
                    values.ata.status = 'Nova';
                    values.ata.aprovacao = 'false';
                    values.ata.criador = localStorage.getItem('usr-name');
                    values.ata.datacriacao = moment().format('DD-MM-YYYY');
                    ataGlobal = values.ata;
                    partGlobal = values.participantes;
                    assuGlobal = values.assuntos;
                    console.log(ataGlobal)
                    for (var i = 0; i < partGlobal.length; i++) {
                        if (partGlobal[i].assinante == null) {
                            partGlobal[i].assinante = 'false';
                        }
                        else {
                            partGlobal[i].assinante = 'true';
                        }
                        partGlobal[i].revisao = ' ';
                    }
                    for (var i = 0; i < assuGlobal.length; i++) {
                        assuGlobal[i].prazo = assuGlobal[i].prazo.format('DD-MM-YYYY');
                    }
                    console.log(partGlobal)
                    console.log(assuGlobal)
                    buscarUsrs();
                }
            }
        }
    };

    async function buscarUsrs() {
        const response = await usuarios();
        var encontrados = 0;
        var vertelefone = 0;

        for (var j = 0; j < partGlobal.length; j++) {
            for (var i = 0; i < response.data.length; i++) {
                if (response.data[i].email == partGlobal[j].email) {
                    partGlobal[j].idusuario = response.data[i].id;
                    encontrados = encontrados + 1;
                    if (isNumber(partGlobal[j].telefone) === true) {
                        if (partGlobal[j].telefone.length < 10) {
                            nota = 'Telefone ' + (j + 1) + ' inválido';
                            error(nota);
                        }
                        else {
                            vertelefone = vertelefone + 1;
                        }
                    }
                    else {
                        nota = 'O campo Telefone deve conter somente números';
                        error(nota);
                    }
                }
            }
            if (encontrados == j) {
                nota = 'E-mail ' + (j + 1) + ' não cadastrado';
                error(nota);
            }
        }
        if (encontrados == partGlobal.length && vertelefone == partGlobal.length) {
            ataGlobal.codassinatura = md5(ataGlobal.data + ataGlobal.pauta + ataGlobal.criador)
            console.log(ataGlobal.codassinatura)
            CadastrarAta(ataGlobal);
        }
    }

    const { TextArea } = Input;

    function isNumber(n) {
        return !isNaN(parseFloat(n)) && isFinite(n);
    }

    async function buscarAta() {
        const response = await atas();
        for (var i = 0; i < partGlobal.length; i++) {
            partGlobal[i].idata = response.data[response.data.length - 1].id;
        }
        for (var i = 0; i < assuGlobal.length; i++) {
            assuGlobal[i].idata = response.data[response.data.length - 1].id;
        }
        idata = response.data[response.data.length - 1].id;
        console.log(partGlobal)
        console.log(assuGlobal)
        CadastrarParticipante();

    };

    async function CadastrarParticipante() {
        try {
            var avisopart;
            for (var i = 0; i < partGlobal.length; i++) {
                const response = await cadpart(partGlobal[i]);
                switch (response.data) {
                    case ('Saved'):
                        avisopart = 'ok';
                        break;
                    default:
                        nota = 'Erro ao cadastrar participantes..';
                        setLoading(false)
                        break;
                }
            }
            if (nota == 'Erro ao cadastrar participantes..') {
                error(nota);
                setLoading(false)
            }
            else {
                CadastrarAssunto();
            }
        }
        catch (err) {
            nota = "Erro de conexão"
            error(nota);
            console.log(err);
            setLoading(false)
        }
    };

    async function CadastrarAssunto() {
        try {
            var aviso;
            for (var i = 0; i < assuGlobal.length; i++) {
                const response = await cadast(assuGlobal[i]);
                switch (response.data) {
                    case ('Saved'):
                        aviso = 'ok';
                        break;
                    default:
                        nota = 'Erro ao cadastrar assuntos..';
                        break;
                }
            }
            if (nota == 'Erro ao cadastrar assuntos..') {
                error(nota);
            }
            else {

                nota = 'Ata Cadastrada!';
                success(nota);
                setTimeout(() => {
                    history.go('/criata')
                }, 1000);
            }
        }
        catch (err) {
            nota = "Erro de conexão"
            error(nota);
            console.log(err);
        }
    };
    console.log(ataGlobal)
    console.log(partGlobal)
    console.log(assuGlobal)

    return (

        <>
            {loading === false ? (
                <>
                    <Navbar routes={rotaata} />
                    <h2>Criação de ATAS</h2>

                    <Form onFinish={onFinishAta} style={{ width: '' }}>
                        <Row>
                            <Col>
                                <Form.Item name={['ata', 'data']} rules={[{ required: true, message: 'Este campo é obrigatório' }]}>

                                    <DatePicker placeholder="Data" format={'DD/MM/YYYY'}
                                        selected={data}
                                        onChange={date => (date != null) ? setData(date.format('DD-MM-YYYY')) : setData(date)} />
                                </Form.Item>
                            </Col>
                            <Col>
                                <Form.Item name={['ata', 'inicio']} rules={[{ required: true, message: 'Este campo é obrigatório' }]}>
                                    <TimePicker className="timer-ata" placeholder="Inicio:" format={'HH:mm'}
                                        selected={inicio}
                                        onChange={init => (init != null) ? setInicio(init.format('HH:mm')) : setInicio(init)} />
                                </Form.Item></Col>
                            <Col></Col>
                            <Col>
                                <Form.Item name={['ata', 'fim']} rules={[{ required: true, message: 'Este campo é obrigatório' }]}>
                                    <TimePicker className="timer-ata" placeholder="Fim:" format={'HH:mm'}
                                        selected={fim}
                                        onChange={final => (final != null) ? setFim(final.format('HH:mm')) : setFim(final)} />
                                </Form.Item>
                            </Col>
                            <Col>
                                <Form.Item name={['ata', 'datacriacao']} hidden={true}>

                                    <DatePicker placeholder="Data" format={'DD/MM/YYYY'}
                                        defaultValue={moment()} format={"DD/MM/YYYY"}
                                        selected={dataCriacao}
                                        onChange={date => (date != null) ? setDataCriacao(date.format('DD-MM-YYYY')) : setDataCriacao(date)} />
                                </Form.Item>
                            </Col>
                            <Col>
                                <Form.Item name={['ata', 'prazo']} rules={[{ required: true, message: 'Este campo é obrigatório' }]}>

                                    <DatePicker placeholder="Prazo" format={'DD/MM/YYYY'}
                                        selected={prazo}
                                        onChange={date => (date != null) ? setPrazo(date.format('DD-MM-YYYY')) : setPrazo(date)} />
                                </Form.Item>
                            </Col>
                        </Row>
                        <Form.Item name={['ata', 'local']} rules={[{ required: true, message: 'Este campo é obrigatório' }]}>
                            <Input placeholder="Local:" className="input-local"></Input>
                        </Form.Item>


                        <Form.Item name={['ata', 'tema']} rules={[{ required: true, message: 'Este campo é obrigatório' }]}>
                            <Input placeholder="Projeto/Tema" className="input-ata"></Input>
                        </Form.Item>

                        <Form.Item name={['ata', 'pauta']} rules={[{ required: true, message: 'Este campo é obrigatório' }]}>
                            <Input placeholder="Pauta" className="input-nome"></Input>
                        </Form.Item>

                        <h4>Participantes:</h4>

                        <Form.List name="participantes">
                            {(field, { add, remove }) => (
                                <>
                                    {field.map(({ key, name, fieldKey }) => (
                                        <Space key={key} style={{ display: 'flex', flexDirection: 'column', marginBottom: 10 }} align="baseline">
                                            <Row>

                                                <Col>
                                                    <Form.Item
                                                        name={[name, 'nome']}
                                                        fieldKey={[fieldKey, 'nome']}
                                                        rules={[{ required: true, message: 'Este campo é obrigatório' }]}

                                                    >
                                                        <Input placeholder="Nome" className="input-nome"></Input>
                                                    </Form.Item>
                                                    <Form.Item
                                                        name={[name, 'area']}
                                                        fieldKey={[fieldKey, 'area']}
                                                        rules={[{ required: true, message: 'Este campo é obrigatório' }]}

                                                    >
                                                        <Input placeholder="Área" className="input-nome"></Input>
                                                    </Form.Item>

                                                    <Form.Item
                                                        name={[name, 'email']}
                                                        fieldKey={[fieldKey, 'email']}
                                                        rules={[{ required: true, message: 'Este campo é obrigatório' }]}

                                                    >
                                                        <Input placeholder="E-mail" className="input-nome"></Input>
                                                    </Form.Item>
                                                </Col>
                                                <Col></Col>
                                                <Col>
                                                    <Form.Item
                                                        name={[name, 'telefone']}
                                                        fieldKey={[fieldKey, 'telefone']}
                                                        rules={[{ required: true, message: 'Este campo é obrigatório' }]}

                                                    >
                                                        <Input placeholder="Telefone" className="input-nome" maxLength="11" ></Input>
                                                    </Form.Item>
                                                    <Form.Item
                                                        name={[name, 'cargo']}
                                                        fieldKey={[fieldKey, 'cargo']}
                                                        rules={[{ required: true, message: 'Este campo é obrigatório' }]}

                                                    >
                                                        <Input placeholder="Cargo" className="input-nome"></Input>
                                                    </Form.Item>
                                                    <Form.Item
                                                        name={[name, 'assinante']}
                                                        fieldKey={[fieldKey, 'assinante']}
                                                        valuePropName="checked"

                                                    >
                                                        <Checkbox

                                                        >Autorizar Assinatura</Checkbox>
                                                    </Form.Item>
                                                </Col>
                                                <MinusCircleOutlined onClick={() => remove(name)} />
                                            </Row>
                                        </Space>
                                    ))}
                                    <Form.Item>
                                        <Button type="dashed" onClick={() => add()} block icon={<PlusOutlined />}>Adicionar Participante</Button>
                                    </Form.Item>
                                </>
                            )}
                        </Form.List>


                        <h4>Observações: </h4>
                        <p style={{ fontSize: "80%" }}>1- Deve ser disponibilizada uma cópia da Ata de Reunião para os participantes e envolvidos.</p>
                        <p style={{ fontSize: "80%" }}>2- O campo PRAZO define a data de entrega das solicitações por parte dos responsáveis definidos no campo RESPONSÁVEL.</p>
                        <div className="div-atasform">
                            <Form.List name="assuntos" >
                                {(field, { add, remove }) => (
                                    <>
                                        {field.map(({ key, name, fieldKey }) => (
                                            <Space key={key} style={{ display: 'flex', flexDirection: 'column', marginBottom: 10 }} align="baseline">

                                                <Form.Item
                                                    name={[name, 'assunto']}
                                                    fieldKey={[fieldKey, 'assunto']}
                                                    rules={[{ required: true, message: 'Este campo é obrigatório' }]}
                                                >
                                                    <TextArea rows={6} placeholder="Assunto" />
                                                </Form.Item>
                                                <Form.Item
                                                    name={[name, 'responsavel']}
                                                    fieldKey={[fieldKey, 'responsavel']}
                                                    rules={[{ required: true, message: 'Este campo é obrigatório' }]}

                                                >
                                                    <Input placeholder="Responsável" className="input-local"></Input>
                                                </Form.Item>
                                                <Form.Item
                                                    name={[name, 'prazo']}
                                                    fieldKey={[fieldKey, 'prazo']}
                                                    rules={[{ required: true, message: 'Este campo é obrigatório' }]}

                                                >
                                                    <DatePicker placeholder="Prazo" format={'DD/MM/YYYY'}
                                                    />
                                                </Form.Item>
                                                <MinusCircleOutlined onClick={() => remove(name)} />
                                            </Space>
                                        ))}
                                        <Form.Item>
                                            <Button type="dashed" onClick={() => add()} block icon={<PlusOutlined />}>Adicionar Assunto</Button>
                                        </Form.Item>
                                    </>
                                )}
                            </Form.List>

                        </div>
                        <Form.Item>
                            <Button htmlType="submit" type="primary" className="login-form-button">Criar ATA de Reunião</Button>
                        </Form.Item>
                    </Form></>
            ) : (<><LoadingScreen /></>)}


        </>
    );
}
export default CriATA;