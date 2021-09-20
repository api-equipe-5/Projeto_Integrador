import React, { useEffect, useState } from 'react';
import Navbar from '../../components/Navbar/navbar';
import rotaata from '../../components/Navbar/rotaata.json';
import { Button, Select, message, DatePicker, Table, Form, Input } from 'antd';
import { atas } from '../../services/crudata';
import { useHistory } from 'react-router-dom';


function MonitorarAta() {


    const [status, setStatus] = useState([]);
    const [datacriacao, setDatacriacao] = useState(null);
    const [pauta, setPauta] = useState('');
    const onChangePauta = (e) => {
        const pauta = e.target.value;
        setPauta(pauta);
    };
    var nota;
    var def = [];
    const history = useHistory();

    const columns = [
        { title: 'ID', dataIndex: 'id', key: 'id' },
        {
            title: 'Nº', dataIndex: 'numero', key: 'numero', defaultSortOrder: 'null',
            sorter: (a, b) => a.id - b.id,
        },
        { title: 'Status', dataIndex: 'status', key: 'status' },
        { title: 'Pauta', dataIndex: 'pauta', key: 'pauta' },
        { title: 'Data de Criação', dataIndex: 'datacriacao', key: 'datacriacao' }
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
        async function Listar() {
            const response = await atas();

            setResultado(response.data);
        }
        Listar();

    }, [])

    async function Filtrar() {
        console.log(datacriacao)

        const response = await atas();
        def = response.data;

        console.log(def)
        console.log(status)
        if (status.length > 0) {
            def = def.filter(function (element) {
                return status.includes(element.status);
            });
            console.log(def)
            setResultado(def);
        }
        if (datacriacao != null) {
            def = def.filter(function (element) {
                return element.datacriacao.includes(datacriacao);
            });
            console.log(def)
            setResultado(def);
        }
        console.log(pauta)
        if (pauta != '') {
            def = def.filter(function (element) {
                return element.pauta.includes(pauta);
            });
            console.log(def)
            setResultado(def);
        }
        console.log(def, resultado)
        setResultado(def);
    }

    const { Option } = Select;

    const [data, setData] = useState(null);

    const onFinish = (values) => {

        if (status.length > 0 || datacriacao != null || pauta != '') {
            Filtrar();
        }
        else {
            Filtrar();
        }
    };

    return (
        <>
            <Navbar routes={rotaata} />
            <h2>Monitoramento de ATA</h2>
            <Form onFinish={onFinish} >
                <Form.Item
                    name="status"
                    label="Status"
                    rules={[
                        {
                            type: 'array',
                        },
                    ]}
                >
                    <Select mode="multiple" placeholder="Status" style={{ minWidth: '170px', width: '100%' }}
                        onChange={stat => setStatus(stat)}  >
                        <Option value="Nova">Nova</Option>
                        <Option value="Revisada">Revisada</Option>
                        <Option value="Assinada">Assinada</Option>
                        <Option value="Enviada">Enviada</Option>
                    </Select>
                </Form.Item>
                <Form.Item name="datacriacao" label="Data de Criação"  >
                    <DatePicker placeholder="Data de Criação" format={'DD/MM/YYYY'}
                        selected={data}
                        onChange={date => (date != null) ? setDatacriacao(date.format('DD-MM-YYYY')) : setDatacriacao(date)}
                        style={{ minWidth: '170px', width: '100%' }} />
                </Form.Item>
                <Form.Item
                    name="pauta"
                    label="Pauta"
                >
                    <Input placeholder="Pauta" style={{ minWidth: '170px', width: '100%' }}
                        onChange={onChangePauta} />
                </Form.Item>
                <Form.Item>
                    <Button className='login-form-button' type='primary' htmlType="submit">
                        Filtrar
                </Button>
                </Form.Item>
            </Form>
            <Table columns={columns} dataSource={resultado}
                locale={{
                    triggerAsc: 'Exibir em ordem Crescente',
                    triggerDesc: 'Exibir em ordem Decrescente',
                    cancelSort: 'Cancelar', filterReset: 'Limpar'
                }}
                scroll={{ x: 700 }}
                style={{ width: "60%", minWidth: "200px", marginTop: "5%" }} >
            </Table>
        </>
    );
}

export default MonitorarAta;