import React, { useEffect, useState } from 'react';
import Navbar from '../../components/Navbar/navbar';
import rotaata from '../../components/Navbar/rotaata.json';
import { Button, message, Table, Form, Row, Col } from 'antd';
import { atas, ediata } from '../../services/crudata';
import { useHistory } from 'react-router-dom';
import { participantes } from '../../services/crudparticipante';
import { assuntos } from '../../services/crudassunto';
import { revisoes } from '../../services/crudrevisao';


function AprovarAta() {


    const [dadosata, setDadosata] = useState({ data: '', inicio: '', fim: '', local: '', tema: '', pauta: '' });
    const [dadospart, setDadospart] = useState([]);
    const [dadosassu, setDadosassu] = useState([]);
    const [dadosrevi, setDadosrevi] = useState([]);
    const [revisado, setRevisado] = useState();

    var nota;
    var revpart;
    var revfalt = 0;
    var ataatual;
    var partatual = [];

    const history = useHistory();

    const columnspart = [
        { title: 'Nome', dataIndex: 'nome', key: 'nome' },
        { title: 'Área', dataIndex: 'area', key: 'area' },
        { title: 'Telefone', dataIndex: 'telefone', key: 'telefone' },
        { title: 'Cargo', dataIndex: 'cargo', key: 'cargo' },
        { title: 'E-mail', dataIndex: 'email', key: 'email' }
    ];

    const columnsassu = [
        { title: 'Assunto', dataIndex: 'assunto', key: 'assunto' },
        { title: 'Resonsável', dataIndex: 'responsavel', key: 'responsavel' },
        { title: 'Prazo', dataIndex: 'prazo', key: 'prazo' }
    ];

    const columnrevi = [
        { title: 'ID', dataIndex: 'id', key: 'id' },
        { title: 'Assunto', dataIndex: 'assunto', key: 'assunto' },
        { title: 'Resonsável', dataIndex: 'responsavel', key: 'responsavel' },
        { title: 'Comentário', dataIndex: 'comentario', key: 'comentario' }
    ];

    const { Item } = Form;
    const [assunto, setAssunto] = useState();
    const [participante, setParticipante] = useState();
    const [revisao, setRevisao] = useState();
    const [faltantes, setFaltantes] = useState();
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

    useEffect(() => {
        async function buscarAta() {
            const response = await atas();
            for (var j = 0; j < response.data.length; j++) {
                if (response.data[j].id == localStorage.getItem('ata-iden')) {
                    setDadosata(response.data[j]);
                    ataatual = response.data[j];
                }
            }
            buscarPart();
        }
        async function buscarPart() {
            const response = await participantes();
            for (var j = 0; j < response.data.length; j++) {
                if (response.data[j].idata == localStorage.getItem('ata-iden')) {
                    if (response.data[j].idusuario == localStorage.getItem('usr-iden')) {
                        revpart = response.data[j];
                    }
                    partatual.push(response.data[j]);
                    dadospart.push(response.data[j]);
                    if (response.data[j].revisao != 'ok') {
                        revfalt = revfalt + 1;
                    }
                }

            }
            setParticipante(dadospart);
            buscarAssu();
        }
        async function buscarAssu() {
            const response = await assuntos();
            for (var j = 0; j < response.data.length; j++) {
                if (response.data[j].idata == localStorage.getItem('ata-iden')) {
                    dadosassu.push(response.data[j]);
                }
            }

            console.log(dadosata);
            console.log(dadospart);
            console.log(dadosassu);
            setAssunto(dadosassu);
            buscarRevi();
        }
        async function buscarRevi() {
            const response = await revisoes();
            for (var j = 0; j < response.data.length; j++) {
                if (response.data[j].idata == localStorage.getItem('ata-iden')) {
                    dadosrevi.push(response.data[j]);
                }
            }
            setRevisao(dadosrevi);
            setRevisado(revpart);

        }

        buscarAta();
        console.log(revisado)
    }, [])

    async function Aprovar() {
        dadosata.aprovacao = 'true';
        const response = await ediata(dadosata);
        if (response.data = 'Saved') {
            nota = 'ATA Aprovada!';
            success(nota);
            setTimeout(() => {
                history.push('/aprata');
            }, 500)
        }
        else {
            nota = 'Erro ao aprovar..';
            error(nota);
        }
    }
    const [modalEditar, setModalEditar] = useState(false);
    const [modalAdd, setModalAdd] = useState(false);
    const [rev, setRev] = useState();
    const abrirModalAdd = () => {
        setModalAdd(!modalAdd);
    }
    const abrirModalEditar = () => {
        setModalEditar(!modalEditar);
    }
    const selecionarRev = (rev) => {
        setRev(rev);
        abrirModalEditar();
    }



    return (
        <>


            <Navbar routes={rotaata} />
            <h2>Aprovação de ATA</h2>

            <Form>
                <Row style={{ width: "100%", marginBottom: "15%", backgroundColor: "white" }}>
                    <Col style={{ backgroundColor: "white", padding: "5px" }}>
                        <Item label="Data:">
                            <>{dadosata.data}</>
                        </Item>
                        <Item label="Início:">
                            <span>{dadosata.inicio}</span>
                        </Item>
                        <Item label="Fim:">
                            <span>{dadosata.fim}</span>
                        </Item>
                    </Col>
                    <Col>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</Col>
                    <Col style={{ backgroundColor: "white", padding: "5px" }}>
                        <Item label="Local:">
                            <span>{dadosata.local}</span>
                        </Item>
                        <Item label="Projeto/Tema:">
                            <span>{dadosata.tema}</span>
                        </Item>
                        <Item label="Pauta:">
                            <span>{dadosata.pauta}</span>
                        </Item>
                    </Col>
                </Row>


            </Form>
            <h4>Participantes</h4>
            <Table columns={columnspart} dataSource={participante}
                scroll={{ x: 700 }}
                style={{ width: "60%", minWidth: "200px" }} >
            </Table>

            <h4>Assuntos</h4>
            <Table columns={columnsassu} dataSource={assunto}
                scroll={{ x: 700 }}
                style={{ width: "60%", minWidth: "200px" }} >
            </Table>

            <h4>Revisões Feitas</h4>
            <Table columns={columnrevi} dataSource={revisao}
                scroll={{ x: 700 }}
                style={{ width: "60%", minWidth: "200px" }} >
            </Table>

            <Button type="primary" onClick={Aprovar}>Aprovar</Button>


        </>
    );
}

export default AprovarAta;