import React, { useEffect, useState } from 'react';
import Navbar from '../../components/Navbar/navbar';
import rotaata from '../../components/Navbar/rotaata.json';
import { Button, Select, message, DatePicker, Table, Form, Row, Input, Col, Modal } from 'antd';
import { atas, ediata } from '../../services/crudata';
import { useHistory } from 'react-router-dom';
import moment from 'moment';
import { edipart, participantes } from '../../services/crudparticipante';
import md5 from 'md5';


function Revisoes() {

    const [modalAssinar, setModalAssinar] = useState(false);
    const [pauta, setPauta] = useState('');
    const [part, setPart] = useState();
    const [parts, setParts] = useState();

    const abrirModalAssinar = () => {
        setModalAssinar(!modalAssinar);
        console.log(part)
    }
    const onChangePauta = (e) => {
        const pauta = e.target.value;
        setPauta(pauta);
    };
    var nota;
    var revisado;
    var partusuario = [];
    var atapart = [];
    var assfalt = 0;
    const history = useHistory();

    const columns = [
        { title: 'ID', dataIndex: 'id', key: 'id' },
        { title: 'Nº', dataIndex: 'numero', key: 'numero' },
        { title: 'Status', dataIndex: 'status', key: 'status' },
        { title: 'Pauta', dataIndex: 'pauta', key: 'pauta' },
        { title: 'Data de Criação', dataIndex: 'datacriacao', key: 'datacriacao' },
        {
            title: 'Ações', key: 'acoes',
            render: (fila) => (
                <>
                    <Button type="default" onClick={() => selecionarAta(fila)}>Revisar</Button>{'   '}
                    <Button type="default" onClick={() => autorizarAssinatura(fila)}>Assinar</Button>
                </>
            )
        }
    ];

    const { Item } = Form;
    const handleChange = e => {
        const { name, value } = e.target;
        setPart({
            ...part,
            [name]: value
        });
        console.log(part);
    }

    const [resultado, setResultado] = useState([]);
    const [ata, setAta] = useState();
    const warning = (mensagem) => {
        message.warning(mensagem);
    };
    const success = (mensagem) => {
        message.success(mensagem);
    };
    const error = (mensagem) => {
        message.error(mensagem);
    };
    const info = (mensagem) => {
        message.info(mensagem);
    };

    async function buscarPart() {
        const response = await participantes();
        for (var j = 0; j < response.data.length; j++) {
            if (response.data[j].idata == localStorage.getItem('ata-iden')) {
                if (response.data[j].assinatura == null && response.data[j].assinante == 'true') {
                    assfalt = assfalt + 1;
                }
            }
        }
        if (assfalt < 1) {
            ata.status = 'Assinada';
            setTimeout(() => {
                UpdateAta();
            }, 500)

        }
    }

    useEffect(() => {

        async function AtaPart() {
            const response = await atas();
            for (var i = 0; i < partusuario.length; i++) {
                for (var j = 0; j < response.data.length; j++) {
                    if (response.data[j].id == partusuario[i].idata) {
                        atapart.push(response.data[j]);
                    }
                }
            }
            setResultado(atapart.filter(function (element) {
                return element.status == 'Nova' || element.status == 'Revisada';
            }))
            console.log(part)

        }
        async function PartUsuario() {
            const response = await participantes();
            partusuario = response.data.filter(function (element) {
                return element.idusuario == localStorage.getItem('usr-iden');
            });

            setParts(partusuario);
            AtaPart();

        }
        PartUsuario();

    }, [])

    function selecionarAta(fila) {
        localStorage.setItem('ata-iden', fila.id);
        history.push('/revata');
    }

    async function autorizarAssinatura(fila) {
        localStorage.setItem('ata-iden', fila.id);
        console.log(localStorage.getItem('ata-iden'))
        setAta(fila);
        for (var i = 0; i < parts.length; i++) {
            if (parts[i].idata == fila.id) {
                if (parts[i].revisao != 'ok') {
                    nota = 'Não é possível assinar sem antes ter revisado o documento';
                    warning(nota);
                }
                else {
                    if (parts[i].assinante == 'false') {
                        nota = 'Sua assinatura não é requerida neste documento';
                        warning(nota);
                    }
                    else {
                        console.log(parts[i])
                        if (parts[i].assinatura == md5(fila.codassinatura)) {
                            nota = 'Você já assinou este documento';
                            warning(nota);
                        }
                        else {
                            setPart(parts[i]);
                            abrirModalAssinar();

                        }
                    }
                }
            }
        }
    }

    function VerAssinatura(part) {
        if (part.assinatura === ata.codassinatura) {
            Assinar();
        }
        else {
            nota = 'Código Inválido (Verifique seu e-mail)';
            warning(nota);
        }
    }

    async function Assinar() {
        try {
            const response = await edipart(part);
            if (response.data == 'Saved') {
                nota = 'ATA Assinada!';
                success(nota);
                buscarPart();
                console.log(assfalt);

            }

        }
        catch (err) {
            console.log(err)
            nota = 'Erro ao assinar..';
            error(nota);
        }
    }
    async function UpdateAta() {
        try {
            console.log(ata);
            const response = await ediata(ata);
            if (response.data == 'Saved') {
                success(nota);
                setTimeout(() => {
                    history.go('/revisoes');
                }, 500)
            }

        }
        catch (err) {
            console.log(err)
            nota = 'Erro ao assinar..';
            error(nota);
        }
    }

    return (
        <>
            <Navbar routes={rotaata} />
            <h2>Revisões</h2>
            <p style={{ fontSize: "80%" }}>Revise as ATAS das reuniões das quais você participou, e verifique se sua Assinatura é requerida.</p>

            <Table columns={columns} dataSource={resultado}
                locale={{
                    triggerAsc: 'Exibir em ordem Crescente',
                    triggerDesc: 'Exibir em ordem Decrescente',
                    cancelSort: 'Cancelar', filterReset: 'Limpar'
                }}
                scroll={{ x: 700 }}
                style={{ width: "60%", minWidth: "200px", marginTop: "5%" }} >
            </Table>
            <Modal
                visible={modalAssinar}
                title="Assinando ATA"
                onCancel={abrirModalAssinar}
                centered
                footer={[
                    <Button onClick={abrirModalAssinar}>Cancelar</Button>,
                    <Button type="primary" onClick={() => VerAssinatura(part)}>Assinar</Button>,
                ]}
            >
                <Form >
                    <Item label="Insira aqui o Código de Assinatura enviado por e-mail">
                        <Input name="assinatura" onChange={handleChange} />
                    </Item>
                </Form>
            </Modal>
        </>
    );
}

export default Revisoes;