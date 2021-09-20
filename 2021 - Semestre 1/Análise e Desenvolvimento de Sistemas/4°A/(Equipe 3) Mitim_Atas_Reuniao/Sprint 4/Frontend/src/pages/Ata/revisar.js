import React, { useEffect, useState } from 'react';
import Navbar from '../../components/Navbar/navbar';
import rotaata from '../../components/Navbar/rotaata.json';
import { Button, Select, message, DatePicker, Table, Form, Row, Input, Col, Modal, Popconfirm } from 'antd';
import { atas, ediata } from '../../services/crudata';
import { useHistory } from 'react-router-dom';
import moment from 'moment';
import { participantes, edipart, cadpart, delpart } from '../../services/crudparticipante';
import { assuntos, cadast, delast, ediast } from '../../services/crudassunto';
import { revisoes, delrev, edirev, cadrev } from '../../services/crudrevisao';
import { usuarios } from '../../services/crudusuario';


function RevisarAta() {


    const [dadosata, setDadosata] = useState([]);
    const [dadospart, setDadospart] = useState([]);
    const [dadosassu, setDadosassu] = useState([]);
    const [dadosrevi, setDadosrevi] = useState([]);
    const [dadosmire, setDadosmire] = useState([]);
    const [revisado, setRevisado] = useState();

    var nota;
    var revpart;
    var revfalt = 0;
    var ataatual;
    var partatual = [];


    const history = useHistory();

    const columnsata = [
        { title: 'Nº', dataIndex: 'numero', key: 'numero' },
        { title: 'Data', dataIndex: 'data', key: 'data' },
        { title: 'Início', dataIndex: 'inicio', key: 'inicio' },
        { title: 'Fim', dataIndex: 'fim', key: 'fim' },
        { title: 'Prazo', dataIndex: 'prazo', key: 'prazo' },
        { title: 'Projeto/Tema', dataIndex: 'tema', key: 'tema' },
        { title: 'Pauta', dataIndex: 'pauta', key: 'pauta' },
        {
            title: 'Ações', key: 'acoes',
            render: (fila) => (
                <>
                    <Button type="primary" onClick={() => selecionarAta(fila)}>Editar</Button>
                </>
            )
        }

    ];

    const columnspart = [
        { title: 'Nome', dataIndex: 'nome', key: 'nome' },
        { title: 'Área', dataIndex: 'area', key: 'area' },
        { title: 'Telefone', dataIndex: 'telefone', key: 'telefone' },
        { title: 'Cargo', dataIndex: 'cargo', key: 'cargo' },
        { title: 'E-mail', dataIndex: 'email', key: 'email' },
        {
            title: 'Ações', key: 'acoes',
            render: (fila) => (
                <>
                    <Button type="primary" onClick={() => selecionarParticipante(fila)} >Editar</Button>{'   '}
                    <Popconfirm title="Tem certeza que deseja excluir este Participante?"
                        okText="Sim" cancelText="Não"
                        onConfirm={() => ExcluirVerPart(fila)}  >
                        <Button danger  >Excluir</Button>
                    </Popconfirm>
                </>
            )
        }
    ];

    const columnsassu = [
        { title: 'Assunto', dataIndex: 'assunto', key: 'assunto' },
        { title: 'Resonsável', dataIndex: 'responsavel', key: 'responsavel' },
        { title: 'Prazo', dataIndex: 'prazo', key: 'prazo' },
        {
            title: 'Ações', key: 'acoes',
            render: (fila) => (
                <>
                    <Button type="primary" onClick={() => selecionarAssunto(fila)} >Editar</Button>{'   '}
                    <Popconfirm title="Tem certeza que deseja excluir este Assunto?"
                        okText="Sim" cancelText="Não"
                        onConfirm={() => ExcluirVerAssu(fila)}  >
                        <Button danger  >Excluir</Button>
                    </Popconfirm>
                </>
            )
        }
    ];

    const columnrevi = [
        { title: 'ID', dataIndex: 'id', key: 'id' },
        { title: 'Assunto', dataIndex: 'assunto', key: 'assunto' },
        { title: 'Resonsável', dataIndex: 'responsavel', key: 'responsavel' },
        { title: 'Comentário', dataIndex: 'comentario', key: 'comentario' }
    ];

    const columnsmire = [
        { title: 'Assunto', dataIndex: 'assunto', key: 'assunto' },
        { title: 'Resonsável', dataIndex: 'responsavel', key: 'responsavel' },
        { title: 'Comentário', dataIndex: 'comentario', key: 'comentario' },
        {
            title: 'Ações', key: 'acoes',
            render: (fila) => (
                <>
                    <Button type="primary" onClick={() => selecionarRev(fila)}>Editar</Button>{/* {'   '}
                    <Popconfirm title="Tem certeza que deseja excluir esta Revisão?"
                        okText="Sim" cancelText="Não"
                        onConfirm={() => ExcluirRev(fila)}  >
                        <Button danger  >Excluir</Button>
                    </Popconfirm> */}
                </>
            )
        }
    ];

    const { Item } = Form;
    const [assunto, setAssunto] = useState();
    const [ata, setAta] = useState();
    const [participante, setParticipante] = useState();
    const [revisao, setRevisao] = useState();
    const [minharevisao, setMinharevisao] = useState();
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
                    dadosata.push(response.data[j]);
                    ataatual = response.data[j];
                }
            }
            setAta(dadosata)
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

            setAssunto(dadosassu);
            buscarRevi();
        }
        async function buscarRevi() {
            const response = await revisoes();
            for (var j = 0; j < response.data.length; j++) {
                if (response.data[j].idata == localStorage.getItem('ata-iden')) {
                    dadosrevi.push(response.data[j]);
                    if (response.data[j].idusuario == localStorage.getItem('usr-iden')) {
                        dadosmire.push(response.data[j]);
                    }
                }
            }
            setRevisao(dadosrevi);
            setMinharevisao(dadosmire);
            setRevisado(revpart);
            if (revfalt < 1) {
                console.log(ataatual)
                ataatual.status = 'Revisada';
                setTimeout(() => {
                    UpdateAta();
                }, 500)

            }

        }

        buscarAta();

    }, [])


    const [modalEditarAta, setModalEditarAta] = useState(false);
    const [modalEditarParticipante, setModalEditarParticipante] = useState(false);
    const [modalEditarAssunto, setModalEditarAssunto] = useState(false);
    const [modalEdit, setModalEdit] = useState(false);
    const [modalAddParticipante, setModalAddParticipante] = useState(false);
    const [modalAddAssunto, setModalAddAssunto] = useState(false);
    const [modalAdd, setModalAdd] = useState(false);
    const [modalEx, setModalEx] = useState(false);
    const [rev, setRev] = useState();
    const [a, setA] = useState();
    const [part, setPart] = useState({ nome: "", email: "", telefone: "", cargo: "", area: "" });
    const [assu, setAssu] = useState({ assunto: "", responsavel: "", prazo: "" });
    const [reviden, setReviden] = useState();
    const [exiden, setExiden] = useState();

    const abrirModalAdd = () => {
        setRev({ assunto: "", comentario: "" })
        setModalAdd(!modalAdd);
    }
    const abrirModalEx = (fila) => {
        setExiden(fila);
        setModalEx(!modalEx);
    }
    const abrirModalEditarAta = () => {
        setReviden('ediata');
        setModalEditarAta(!modalEditarAta);
    }
    const abrirModalEditarParticipante = () => {
        setReviden('edipart');
        setModalEditarParticipante(!modalEditarParticipante);
    }
    const abrirModalEditarAssunto = () => {
        setReviden('ediast');
        setModalEditarAssunto(!modalEditarAssunto);
    }
    const abrirModalEdit = () => {
        setModalEdit(!modalEdit);
    }
    const abrirModalAddParticipante = () => {
        setPart({ nome: "", email: "", telefone: "", cargo: "", area: "" })
        setReviden('cadpart');
        setModalAddParticipante(!modalAddParticipante);
    }
    const abrirModalAddAssunto = () => {
        setAssu({ assunto: "", responsavel: "", prazo: "" })
        setReviden('cadast');
        setModalAddAssunto(!modalAddAssunto);
    }

    const selecionarAta = (a) => {
        setA(a);
        abrirModalEditarAta();
    }
    const selecionarParticipante = (part) => {
        setPart(part);
        abrirModalEditarParticipante();
    }

    const selecionarAssunto = (assu) => {
        setAssu(assu);
        abrirModalEditarAssunto();
    }

    const selecionarRev = (rev) => {
        setRev(rev);
        abrirModalEdit();
    }

    const handleChangeAta = e => {
        const { name, value } = e.target;
        setA({
            ...a,
            [name]: value
        });
        console.log(ata);
    }
    const handleChangeParticipante = e => {
        const { name, value } = e.target;
        setPart({
            ...part,
            [name]: value
        });
        console.log(part);
    }

    const handleChangeAssunto = e => {
        const { name, value } = e.target;
        setAssu({
            ...assu,
            [name]: value
        });
        console.log(assu);
    }

    const handleChangeRev = e => {
        const { name, value } = e.target;
        setRev({
            ...rev,
            [name]: value
        });
        console.log(rev);
    }

    async function UpdateAta() {
        try {
            console.log(dadosata);
            const response = await ediata(ataatual);
        }
        catch (err) {
            console.log(err)
        }
    }

    function ExcluirVerPart(fila) {
        setReviden('delpart');
        abrirModalEx(fila);
    }
    function ExcluirVerAssu(fila) {
        setReviden('delast');
        abrirModalEx(fila);
    }

    async function ExcluirRev(fila) {
        try {
            const response = await delrev(fila.id);
            if (response.data === 'Deleted') {
                nota = 'Revisão Excluída!';
                success(nota);
                setTimeout(() => {
                    history.go('/revata');
                }, 500);
            }
            else {
                nota = 'Revisão não encontrada para exclusão';
                error(nota);
            }
        }
        catch (err) {
            console.log(err);
            nota = 'Erro ao excluir..';
            error(nota);
        }
    }

    function Add() {
        var count = 0;
        Object.keys(rev).forEach(function (item) {
            if (rev[item] == '') {
                count = count + 1;
            }
        })
        if (count > 0) {
            nota = 'Os campos do Registro de Revisão são obrigatórios';
            warning(nota);
        }
        else {
            rev.responsavel = localStorage.getItem('usr-name');
            rev.idusuario = parseInt(localStorage.getItem('usr-iden'));
            rev.idata = parseInt(localStorage.getItem('ata-iden'));

            AdicionarRev(rev);
        }

    }

    async function AdicionarRev(rev) {
        try {
            console.log(reviden)
            const response = await cadrev(rev);
            if (response.data === 'Saved') {
                switch (reviden) {
                    case 'ediata':
                        UpdateAtaReuniao();
                        break;
                    case 'edipart':
                        UpdateParticipante();
                        break;
                    case 'ediast':
                        UpdateAssunto();
                        break;
                    case 'cadpart':
                        AddParticipante();
                        break;
                    case 'cadast':
                        AddAssunto();
                        break;
                    case 'delpart':
                        ExcluirPart(exiden);
                        break;
                    case 'delast':
                        ExcluirAssu(exiden);
                        break;
                    default:
                        nota = 'Não foi possível concluir a operação de Revisão..';
                        error(nota);
                }

            }
        }
        catch (err) {
            console.log(err)
            nota = 'Erro ao adicionar..';
            error(nota);
        }
    }

    function VerificarRev() {
        console.log(revisado, revpart)
        revisado.revisao = 'ok';
        UpdatePart();
    }

    async function UpdatePart() {
        console.log(revisado)
        const response = await edipart(revisado);
        history.push('/revisoes');
    }

    async function Ver(rev) {
        try {
            console.log(rev)
            const response = await edirev(rev);
            if (response.data === 'Saved') {
                nota = 'Alterações salvas!';
                success(nota);
                setTimeout(() => {
                    history.go('/revata');
                }, 2500);
            }
        }
        catch (err) {
            console.log(err)
            nota = 'Erro ao salvar..';
            error(nota);
        }

    }

    async function UpdateAtaReuniao() {

        const response = await ediata(a);
        if (response.data == 'Saved') {
            nota = 'Alterações salvas!';
            success(nota);
        }
        setTimeout(() => {
            history.go('/revata');
        }, 500)

    }

    async function UpdateParticipante() {

        const response = await edipart(part);
        if (response.data == 'Saved') {
            nota = 'Alterações salvas!';
            success(nota);
        }
        setTimeout(() => {
            history.go('/revata');
        }, 500)
    }

    async function UpdateAssunto() {

        const response = await ediast(assu);
        if (response.data == 'Saved') {
            nota = 'Alterações salvas!';
            success(nota);
        }
        setTimeout(() => {
            history.go('/revata');
        }, 500)
    }

    async function buscarUsrs() {
        var count = 0;
        var vertelefone = 0;
        Object.keys(part).forEach(function (item) {
            if (part[item] == '') {
                count = count + 1;
            }
        })
        if (count > 0) {
            nota = 'Todos os campos são obrigatórios';
            warning(nota);
        }
        else {
            const response = await usuarios();
            for (var i = 0; i < response.data.length; i++) {
                if (response.data[i].email == part.email) {
                    if (isNumber(part.telefone) === true) {
                        if (part.telefone.length < 10 || part.telefone.length > 11) {
                            nota = 'Telefone inválido';
                            error(nota);
                        }
                        else {
                            vertelefone++;
                        }
                    }
                    else {
                        nota = 'O campo Telefone deve conter somente números';
                        error(nota);
                    }
                    part.idusuario = response.data[i].id;

                }
            }
            if (part.idusuario == null) {
                nota = 'E-mail não cadastrado';
                warning(nota);

            }
            else {
                if (vertelefone > 0) {
                    abrirModalAdd();
                }

            }
        }

    }

    function isNumber(n) {
        return !isNaN(parseFloat(n)) && isFinite(n);
    }

    async function AddParticipante() {
        part.idata = parseInt(localStorage.getItem('ata-iden'));
        part.assinante = 'false';
        const response = await cadpart(part);
        if (response.data == 'Saved') {
            nota = 'Participante Adicionado!';
            success(nota);
        }
        setTimeout(() => {
            history.go('/revata');
        }, 500)
    }

    async function AddAssunto() {
        assu.idata = parseInt(localStorage.getItem('ata-iden'));
        const response = await cadast(assu);
        if (response.data == 'Saved') {
            nota = 'Assunto Adicionado!';
            success(nota);
        }
        setTimeout(() => {
            history.go('/revata');
        }, 500)
    }

    function VerAssunto() {
        var count = 0;
        Object.keys(assu).forEach(function (item) {
            if (assu[item] == '') {
                count = count + 1;
            }
        })
        if (count > 0) {
            nota = 'Todos os campos são obrigatórios';
            warning(nota);
        }
        else {
            abrirModalAdd();
        }
    }

    function VerificarAta() {
        var count = 0;
        Object.keys(a).forEach(function (item) {
            if (a[item] == '') {
                count = count + 1;
            }

        })
        if (count > 0) {
            nota = 'Todos os campos são obrigatórios';
            warning(nota);
        }
        else {
            abrirModalAdd();
        }
    }

    async function ExcluirPart(fila) {
        try {
            const response = await delpart(fila.id);
            if (response.data === 'Deleted') {
                nota = 'Participante Excluído!';
                success(nota);
                setTimeout(() => {
                    history.go('/revata');
                }, 500);
            }

        }
        catch (err) {
            console.log(err);
            nota = 'Erro ao excluir..';
            error(nota);
        }
    }

    async function ExcluirAssu(fila) {
        try {
            const response = await delast(fila.id);
            if (response.data === 'Deleted') {
                nota = 'Assunto Excluído!';
                success(nota);
                setTimeout(() => {
                    history.go('/revata');
                }, 500);
            }

        }
        catch (err) {
            console.log(err);
            nota = 'Erro ao excluir..';
            error(nota);
        }
    }

    async function Edit() {
        try {
            const response = await edirev(rev);
            if (response.data === 'Saved') {
                nota = 'Alterações salvas!';
                success(nota);
                setTimeout(() => {
                    history.go('/revata');
                }, 500);
            }

        }
        catch (err) {
            console.log(err);
            nota = 'Erro ao salvar..';
            error(nota);
        }
    }
    return (
        <>

            <Navbar routes={rotaata} />
            <h2>Revisão de ATA</h2>




            <h4>Informações da ATA</h4>
            <Table columns={columnsata} dataSource={ata}
                scroll={{ x: 700 }}
                style={{ width: "60%", minWidth: "200px" }} >
            </Table>


            <h4>Participantes</h4>
            <Table columns={columnspart} dataSource={participante}
                scroll={{ x: 700 }}
                style={{ width: "60%", minWidth: "200px" }} >
            </Table>
            <Button type="primary" onClick={abrirModalAddParticipante}>Adicionar Participante</Button>

            <h4>Assuntos</h4>
            <Table columns={columnsassu} dataSource={assunto}
                scroll={{ x: 700 }}
                style={{ width: "60%", minWidth: "200px" }} >
            </Table>
            <Button type="primary" onClick={abrirModalAddAssunto}>Adicionar Assunto</Button>

            <h4>Revisões Feitas</h4>
            <Table columns={columnrevi} dataSource={revisao}
                scroll={{ x: 700 }}
                style={{ width: "60%", minWidth: "200px" }} >
            </Table>

            <h4>Minhas Revisões</h4>
            <Table columns={columnsmire} dataSource={minharevisao}
                scroll={{ x: 700 }}
                style={{ width: "60%", minWidth: "200px" }} >
            </Table>
            <Popconfirm title="Ao clicar em 'Sim' você indica que está de acordo com as informações presentes na ATA"
                okText="Sim" cancelText="Não"
                onConfirm={VerificarRev}  >
                <Button    >Marcar como Revisada</Button>
            </Popconfirm>

            <Modal
                visible={modalEditarAta}
                title="Editar Informações da ATA"
                onCancel={abrirModalEditarAta}
                centered
                footer={[
                    <Button onClick={abrirModalEditarAta}>Cancelar</Button>,
                    <Button type="primary" onClick={VerificarAta} >Salvar</Button>,
                ]}
            >
                <Form >
                    <Item label="Data">
                        <Input name="data" onChange={handleChangeAta} value={a && a.data} />
                    </Item>

                    <Item label="Inicio">
                        <Input name="inicio" onChange={handleChangeAta} value={a && a.inicio} />
                    </Item>

                    <Item label="Fim">
                        <Input name="fim" onChange={handleChangeAta} value={a && a.fim} />
                    </Item>
                    <Item label="Projeto/Tema">
                        <Input name="tema" onChange={handleChangeAta} value={a && a.tema} />
                    </Item>
                    <Item label="Pauta">
                        <Input name="pauta" onChange={handleChangeAta} value={a && a.pauta} />
                    </Item>
                </Form>
            </Modal>
            <Modal
                visible={modalEditarParticipante}
                title="Editar Participante"
                onCancel={abrirModalEditarParticipante}
                centered
                footer={[
                    <Button onClick={abrirModalEditarParticipante}>Cancelar</Button>,
                    <Button type="primary" onClick={abrirModalAdd} >Salvar</Button>,
                ]}
            >
                <Form >
                    <Item label="Nome">
                        <Input name="nome" onChange={handleChangeParticipante} value={part && part.nome} />
                    </Item>

                    <Item label="Área">
                        <Input name="area" onChange={handleChangeParticipante} value={part && part.area} />
                    </Item>

                    <Item label="Telefone" >
                        <Input name="telefone" onChange={handleChangeParticipante} value={part && part.telefone} />
                    </Item>
                    <Item label="Cargo">
                        <Input name="cargo" onChange={handleChangeParticipante} value={part && part.cargo} />
                    </Item>
                    <Item label="E-mail">
                        <Input name="email" onChange={handleChangeParticipante} value={part && part.email} />
                    </Item>
                </Form>
            </Modal>

            <Modal
                visible={modalEditarAssunto}
                title="Editar Assunto"
                onCancel={abrirModalEditarAssunto}
                centered
                footer={[
                    <Button onClick={abrirModalEditarAssunto}>Cancelar</Button>,
                    <Button type="primary" onClick={abrirModalAdd} >Salvar</Button>,
                ]}
            >
                <Form >
                    <Item label="Assunto">
                        <Input name="assunto" onChange={handleChangeAssunto} value={assu && assu.assunto} />
                    </Item>

                    <Item label="Responsável">
                        <Input name="responsavel" onChange={handleChangeAssunto} value={assu && assu.responsavel} />
                    </Item>

                    <Item label="Prazo">
                        <Input name="prazo" onChange={handleChangeAssunto} value={assu && assu.prazo} />
                    </Item>
                </Form>
            </Modal>

            <Modal
                visible={modalAddParticipante}
                title="Adicionar Participante"
                destroyOnClose={true}
                onCancel={abrirModalAddParticipante}
                centered
                footer={[
                    <Button onClick={abrirModalAddParticipante}>Cancelar</Button>,
                    <Button type="primary" onClick={() => buscarUsrs()} >Adicionar</Button>,
                ]}
            >
                <Form >
                    <Item label="Nome" >
                        <Input name="nome" onChange={handleChangeParticipante} />
                    </Item>

                    <Item label="Área">
                        <Input name="area" onChange={handleChangeParticipante} />
                    </Item>

                    <Item label="Telefone">
                        <Input name="telefone" onChange={handleChangeParticipante} />
                    </Item>
                    <Item label="Cargo">
                        <Input name="cargo" onChange={handleChangeParticipante} />
                    </Item>
                    <Item label="E-mail" >
                        <Input name="email" onChange={handleChangeParticipante} />
                    </Item>

                </Form>
            </Modal>

            <Modal
                visible={modalAddAssunto}
                title="Adicionar Assunto"
                onCancel={abrirModalAddAssunto}
                centered
                footer={[
                    <Button onClick={abrirModalAddAssunto}>Cancelar</Button>,
                    <Button type="primary" onClick={VerAssunto} >Adicionar</Button>,
                ]}
            >
                <Form >
                    <Item label="Assunto">
                        <Input name="assunto" onChange={handleChangeAssunto} />
                    </Item>

                    <Item label="Responsável">
                        <Input name="responsavel" onChange={handleChangeAssunto} />
                    </Item>

                    <Item label="Prazo">
                        <Input name="prazo" onChange={handleChangeAssunto} />
                    </Item>
                </Form>
            </Modal>
            <Modal
                visible={modalAdd}
                title="Registro de Revisão"
                onCancel={abrirModalAdd}
                centered
                footer={[
                    <Button onClick={abrirModalAdd}>Cancelar</Button>,
                    <Button type="primary" onClick={Add} >Salvar</Button>,
                ]}
            >
                <Form >
                    <Item label="Deixe seu comentário a respeito das alterações feitas">
                    </Item>
                    <Item label="Assunto da alteração">
                        <Input name="assunto" onChange={handleChangeRev} />
                    </Item>

                    <Item label="Comentário">
                        <Input name="comentario" onChange={handleChangeRev} />
                    </Item>
                </Form>
            </Modal>

            <Modal
                visible={modalEx}
                title="Registro de Revisão"
                onCancel={abrirModalEx}
                centered
                footer={[
                    <Button onClick={abrirModalEx}>Cancelar</Button>,
                    <Button type="primary" onClick={Add} >Salvar</Button>,
                ]}
            >
                <Form >
                    <Item label="Deixe seu comentário a respeito das alterações feitas">
                    </Item>
                    <Item label="Assunto da alteração">
                        <Input name="assunto" onChange={handleChangeRev} />
                    </Item>

                    <Item label="Comentário">
                        <Input name="comentario" onChange={handleChangeRev} />
                    </Item>
                </Form>
            </Modal>

            <Modal
                visible={modalEdit}
                title="Edição de Revisão"
                onCancel={abrirModalEdit}
                centered
                footer={[
                    <Button onClick={abrirModalEdit}>Cancelar</Button>,
                    <Button type="primary" onClick={Edit} >Salvar</Button>,
                ]}
            >
                <Form >
                    <Item label="Deixe seu comentário a respeito das alterações feitas">
                    </Item>
                    <Item label="Assunto da alteração">
                        <Input name="assunto" onChange={handleChangeRev} value={rev && rev.assunto} />
                    </Item>

                    <Item label="Comentário">
                        <Input name="comentario" onChange={handleChangeRev} value={rev && rev.comentario} />
                    </Item>
                </Form>
            </Modal>

        </>
    );
}

export default RevisarAta;