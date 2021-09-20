import React, { useEffect, useState } from 'react';
import Navbar from '../../components/Navbar/navbar';
import rotaata from '../../components/Navbar/rotaata.json';
import ModalAtas from '../../components/Modal/';
import { Button, Input, message, Popconfirm, Table, Modal, Form } from 'antd';
import { atas, ediata } from '../../services/crudata';
import { useHistory } from 'react-router-dom';
import { assuntos } from '../../services/crudassunto';
import { participantes } from '../../services/crudparticipante';
import Excel from '../../components/Excel/index';



function ImprimirAta() {




    const history = useHistory();

    const [ataModal, setAtaModal] = useState(false);
    const [salvaAssunto, setSalvaAssunto] = useState();
    const [assuntoRes, setAssuntoRes] = useState([]);
    const [salvaParticipante, setSalvaParticipante] = useState([]);
    const [participanteRes, setParticipanteRes] = useState();
    const [salvaResultado, setSalvaResultado] = useState();
    const [resultado, setResultado] = useState([]);
    const [salvaAssinante, setSalvaAssinante] = useState();
    const [assinante, SetAssinante] = useState([]);
    const [excel1,setExcel1] = useState(false);
    const [envio,setEnvio] = useState('');

    var arrayAssuntos = []
    var arrayParticipante = []
    var arrayAssinante = [];

    const columns = [
        { title: 'ID', dataIndex: 'id', key: 'id' },
        { title: 'Nº', dataIndex: 'numero', key: 'numero' },
        { title: 'Status', dataIndex: 'status', key: 'status' },
        {
            title: 'Imprimir', key: 'acoes',
            render: (resultado) => (
                <>
                    <Button type="default" onClick={() => Exibir(resultado, assuntoRes, participanteRes, assinante)}>PDF</Button>{'   '}

                    <Button type="default" onClick={() => ExibirExcel(resultado, assuntoRes, participanteRes, assinante)}>EXCEL</Button>

                </>
            )
        }
    ];

    function Exibir(resultado, assuntoRes, participanteRes, assinante) {
        setAtaModal(!ataModal);
        Status(resultado);
        setEnvio('Enviada');
        setSalvaResultado(resultado);
        for (var i = 0; i < assuntoRes.length; i++) {
            if (assuntoRes[i].idata === resultado.id) {
                arrayAssuntos.push({ ...assuntoRes[i] })

            }
        } setSalvaAssunto(arrayAssuntos)
        for (var i = 0; i < participanteRes.length; i++) {
            if (participanteRes[i].idata === resultado.id) {
                arrayParticipante.push({ ...participanteRes[i] })
            }
        } setSalvaParticipante(arrayParticipante)
        for (var i = 0; i < assinante.length; i++) {
            if (assinante[i].idata === resultado.id) {
                arrayAssinante.push({ ...assinante[i] })
            }
            setSalvaAssinante(arrayAssinante)
        }
    }

    function ExibirExcel(resultado, assuntoRes, participanteRes, assinante) {
        setExcel1(!ataModal);
        Status(resultado);
        setEnvio('Enviada');
        setSalvaResultado(resultado);
        for (var i = 0; i < assuntoRes.length; i++) {
            if (assuntoRes[i].idata === resultado.id) {
                arrayAssuntos.push({ ...assuntoRes[i] })

            }
        } setSalvaAssunto(arrayAssuntos)
        for (var i = 0; i < participanteRes.length; i++) {
            if (participanteRes[i].idata === resultado.id) {
                arrayParticipante.push({ ...participanteRes[i] })
            }
        } setSalvaParticipante(arrayParticipante)
        for (var i = 0; i < assinante.length; i++) {
            if (assinante[i].idata === resultado.id) {
                arrayAssinante.push({ ...assinante[i] })
            }
            setSalvaAssinante(arrayAssinante)
        }

    }

     async function Status(resultado) {
        if (resultado.status != 'Enviada') {
            resultado.status = 'Enviada'
            const response = await ediata(resultado);
            
        }else{
            alert('já está enviada');
        };
    }

    function Fechar() {
        setAtaModal(!ataModal);
    }

    function FecharExcel() {
        setExcel1(ataModal);
    }



    useEffect(() => {
        async function ListarAssunto() {
            const response = await assuntos();
            setAssuntoRes(response.data);

        }
        ListarAssunto();

    }, [ataModal])

    useEffect(() => {
        async function ListarParticipante() {
            const response = await participantes();
            setParticipanteRes(response.data);

        }
        ListarParticipante();
    }, [ataModal])


    useEffect(() => {
        async function Listar() {
            const response = await atas();
            setResultado(response.data.filter(function (element) {
                return element.status == 'Assinada' || element.status == 'Enviada';
            }));
        }
        Listar();

    }, [])

    useEffect(() => {
        async function Assinantes() {
            const response = await participantes();
            SetAssinante(response.data.filter(function (element) {
                return element.assinante == 'true';
            }));
        }
        Assinantes();

    }, [ataModal])


    return (
        <>
            <Navbar routes={rotaata} />
            <h2>Impressão de ATA</h2>
            <Table columns={columns} dataSource={resultado}
                scroll={{ x: 700 }}
                style={{ width: "60%", minWidth: "200px", marginTop: "5%" }} >
            </Table>
            {ataModal && (
                <ModalAtas
                    conteudo={salvaResultado}
                    close={Fechar}
                    assuntos={salvaAssunto}
                    participa={salvaParticipante}
                    assinante={salvaAssinante}

                />
            )}
            {excel1 && (<Excel
                conteudo={salvaResultado}
                close={FecharExcel}
                assuntos={salvaAssunto}
                participa={salvaParticipante}
                assinante={salvaAssinante} />)}

        </>
    );
}

export default ImprimirAta;
