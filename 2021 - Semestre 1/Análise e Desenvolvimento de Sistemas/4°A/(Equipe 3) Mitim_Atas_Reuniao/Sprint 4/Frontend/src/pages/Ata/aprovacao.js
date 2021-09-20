import React, { useEffect, useState } from 'react';
import Navbar from '../../components/Navbar/navbar';
import rotaata from '../../components/Navbar/rotaata.json';
import { Button, message, Table } from 'antd';
import { atas } from '../../services/crudata';
import { useHistory } from 'react-router-dom';
import md5 from 'md5';


function Aprovacao() {

    var nota;

    const history = useHistory();

    const columns = [
        { title: 'ID', dataIndex: 'id', key: 'id' },
        { title: 'Nº', dataIndex: 'numero', key: 'numero' },
        { title: 'Status', dataIndex: 'status', key: 'status' },
        { title: 'Pauta', dataIndex: 'pauta', key: 'pauta' },
        { title: 'Tema', dataIndex: 'tema', key: 'tema' },
        {
            title: 'Ações', key: 'acoes',
            render: (fila) => (
                <>
                    <Button type="default" onClick={() => Localizar(fila)}>Ver ATA</Button>
                </>
            )
        }
    ];

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



    useEffect(() => {
        if (localStorage.getItem('usr-pass') == md5('Colaborador')) {
            history.push('/criata');
            nota = 'Sem permissão de acesso para Aprovação de ATA';
            error(nota);
        }
        async function Assinadas() {
            const response = await atas();
            setResultado(response.data.filter(function (element) {
                return element.status == 'Assinada' && element.aprovacao == 'false';
            }))
        }
        Assinadas();

    }, [])


    async function Localizar(fila) {
        localStorage.setItem('ata-iden', fila.id);
        history.push('/aprovar');
    }

    return (
        <>
            <Navbar routes={rotaata} />
            <h2>Aprovações Pendentes</h2>

            <Table columns={columns} dataSource={resultado}
                scroll={{ x: 700 }}
                style={{ width: "60%", minWidth: "200px", marginTop: "5%" }} >
            </Table>

        </>
    );
}

export default Aprovacao;