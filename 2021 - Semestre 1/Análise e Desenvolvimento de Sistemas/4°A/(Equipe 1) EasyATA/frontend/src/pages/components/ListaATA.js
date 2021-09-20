import React, { forwardRef } from 'react'
import AtasService from '../../service/AtasService';
import axios from 'axios'

import MaterialTable from 'material-table'
import ArrowDownward from '@material-ui/icons/ArrowDownward';
import ChevronLeft from '@material-ui/icons/ChevronLeft';
import ChevronRight from '@material-ui/icons/ChevronRight';
import Clear from '@material-ui/icons/Clear';
import FirstPage from '@material-ui/icons/FirstPage';
import LastPage from '@material-ui/icons/LastPage';
import Search from '@material-ui/icons/Search';
import DoneIcon from '@material-ui/icons/Done';
import FilterListIcon from '@material-ui/icons/FilterList';
import EditIcon from '@material-ui/icons/Edit';
import SaveIcon from '@material-ui/icons/Save';
import CheckIcon from '@material-ui/icons/Check';
import HowToRegIcon from '@material-ui/icons/HowToReg';
import { Link } from 'react-router-dom';


const tableIcons = {
    Clear: forwardRef((props, ref) => <Clear {...props} ref={ref} />),
    FirstPage: forwardRef((props, ref) => <FirstPage {...props} ref={ref} />),
    LastPage: forwardRef((props, ref) => <LastPage {...props} ref={ref} />),
    NextPage: forwardRef((props, ref) => <ChevronRight {...props} ref={ref} />),
    PreviousPage: forwardRef((props, ref) => <ChevronLeft {...props} ref={ref} />),
    ResetSearch: forwardRef((props, ref) => <Clear {...props} ref={ref} />),
    Search: forwardRef((props, ref) => <Search {...props} ref={ref} />),
    SortArrow: forwardRef((props, ref) => <ArrowDownward {...props} ref={ref} />),
    Done: forwardRef((props, ref) => <DoneIcon {...props} ref={ref} />),
    Filter: forwardRef((props, ref) => <FilterListIcon {...props} ref={ref} />),
    Edit: forwardRef((props, ref) => <EditIcon {...props} ref={ref} />),
    Save: forwardRef((props, ref) => <SaveIcon {...props} ref={ref} />),
    Check: forwardRef((props, ref) => <CheckIcon {...props} ref={ref} />),
    Reg: forwardRef((props, ref) => <HowToRegIcon {...props} ref={ref} />),
};
export var dadosRevisao = {}

class ListaATA extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            atas: []
        }
    }

    componentDidMount() {
        AtasService.getAtas().then((response) => {
            this.setState({ atas: response.data })
        });
    }

    handleUpdate(data) {
        axios
            .post('http://localhost:8080/api/salvar/revisao', data)
            .then((response) => {
                this.setState({ atas: response.data })
                document.location.reload(true);
            });
    };

    handleApprove(data) {
        var dateNow = new Date()
        const localIpUrl = require('local-ip-url');
        var nome = localStorage.getItem('nome').replace(/['"]+/g, '');
        let changeStatus = {
            assinatura: data.assinatura + nome + dateNow.getHours() + ":" + dateNow.getMinutes() + '-' + localIpUrl('public') + '; '
        }
        Object.assign(data, changeStatus)
        console.log(data)

        axios
            .put('http://localhost:8080/api/ata', data)
            .then((response) => {
                this.setState({ atas: response.data })
                document.location.reload(true);
            });
    };


    render() {
        return (
            
            <MaterialTable
                localization={{
                    pagination: {
                        labelDisplayedRows: '{from}-{to} de {count}',
                        labelRowsSelect: 'atas'
                    },
                    toolbar: {
                        nRowsSelected: '{0} linha(s) selecionada',
                        searchPlaceholder: 'Buscar'
                    },
                    header: {
                        actions: 'Revisão',
                    },
                    body: {
                        emptyDataSourceMessage: 'Não há nenhum registro',
                        filterRow: {
                            filterTooltip: 'Filter'
                        }
                    }
                }}
                icons={tableIcons}
                title="ATAs Cadastradas"
                columns={[
                    { title: 'ID', field: 'id', editable: 'never' },
                    { title: 'Tema', field: 'tema' },
                    { title: 'Pauta', field: 'pauta' },
                    { title: 'Data Início', field: 'data_inicio' },
                    { title: 'Data Fim', field: 'data_fim' },
                    { title: 'Horário Início', field: 'hora_inicio' },
                    { title: 'Horário Fim', field: 'hora_fim' },
                    { title: 'Local', field: 'local' },
                    {
                        title: 'Status', field: 'estado', editable: 'never',
                        defaultFilter: 'Nova',
                        filtering: false,
                    }
                ]}

                data={this.state.atas}

                options={{
                    actionsColumnIndex: -1,
                    filtering: true,
                }}

                detailPanel={
                    rowData => {                        
                        dadosRevisao = Object.assign({}, rowData)
                        return (
                            <div>
                                <div className="container">

                                    <div className="card shadow" style={{ margin: '5%' }}>
                                        <div className="card-header">
                                            <h4>ATA</h4>
                                        </div>
                                        <div className="card-body">
                                            <form>
                                                <div>
                                                    <div className="form-group row">
                                                        <div className="col-2">Tema da Reunião:</div>
                                                        <div className="col-4">
                                                            <input type="text" className="form-control" name="tema" id="tema" value={rowData.tema}
                                                            />
                                                        </div>
                                                        <div className="col-2">Pauta da Reunião:</div>
                                                        <div className="col-4">
                                                            <input type="text" className="form-control" name="pauta" value={rowData.pauta}
                                                            />
                                                        </div>
                                                    </div>
                                                    <div className="form-group row">
                                                        <div className="col-2">Data:</div>
                                                        <div className="col-4">
                                                            <input type="date" className="form-control" name="data_inicio" placeholder="Início" value={rowData.data_inicio}
                                                            />
                                                        </div>
                                                        <div className="col-4">
                                                            <input type="date" className="form-control" name="data_fim" placeholder="Fim" value={rowData.data_fim}
                                                            />
                                                        </div>
                                                    </div>

                                                    <div className="form-group row">
                                                        <div className="col-2">Horário:</div>
                                                        <div className="col-4">
                                                            <input type="time" className="form-control" name="hora_inicio" placeholder="Início" value={rowData.hora_inicio}
                                                            />
                                                        </div>
                                                        <div className="col-4">
                                                            <input type="time" className="form-control" name="hora_fim" placeholder="Fim" value={rowData.hora_fim}
                                                            />
                                                        </div>
                                                    </div>
                                                    <div className="form-group row">
                                                        <div className="col-2">Local da Reunião:</div>
                                                        <div className="col-4">
                                                            <input type="text" className="form-control" name="local" value={rowData.local}
                                                            />
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                        <div className="card">
                                            <div className="card-header" style={{ textAlign: 'center' }}>
                                                <h5>Participantes</h5>
                                            </div>
                                            <div className="card-body">
                                                <form>
                                                    <div>
                                                        <div className="form-group row">
                                                            <div className="col">
                                                                <textarea type="text" className="form-control" name="participante" placeholder="Participante1, Participante2..." required value={rowData.participante}
                                                                />
                                                            </div>
                                                            <div className="col">
                                                                <textarea type="text" className="form-control" name="area" placeholder="Área1, Área2..." value={rowData.area}
                                                                />
                                                            </div>
                                                            <div className="col">
                                                                <textarea type="text" className="form-control" name="email" placeholder="E-mail1, E-mail2..." value={rowData.email}
                                                                />
                                                            </div>
                                                            <div className="col">
                                                                <textarea type="text" className="form-control" name="telefone" placeholder="Telefone1, Telefone2" value={rowData.telefone}
                                                                />
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>

                                        <div className="card">
                                            <div className="card-header" style={{ textAlign: 'center' }}>
                                                <h5>Assuntos</h5>
                                            </div>
                                            <div className="card-body">
                                                <form>
                                                    <div>
                                                        <div className="form-group row">
                                                            <div className="col">
                                                                <textarea className="form-control" name="assunto" placeholder="Assunto1, Assunto2" value={rowData.assunto}
                                                                />
                                                            </div>
                                                            <div className="col">
                                                                <textarea type="text" className="form-control" name="responsavel" placeholder="Responsável1, Responsável2" value={rowData.responsavel}
                                                                />
                                                            </div>
                                                            <div className="col">
                                                                <textarea type="text" className="form-control" name="prazo" placeholder="Prazo1, Prazo2" value={rowData.prazo}
                                                                />
                                                            </div>
                                                            <div className="col">
                                                                <textarea type="text" className="form-control" name="distribuicao" placeholder="Distribuição1, Distribuição2" value={rowData.distribuicao}
                                                                />
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>

                                        <div className="form-group row"  >
                                            <div className="col" style={{display: "flex", alignItems: "center", justifyContent: "center", marginTop: "10px"}}>
                                                <Link to="/revisao"> 
                                                    <button className="btn btn-outline-primary" id="revisao">Solicitar Revisão</button>
                                                </Link>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        )
                    }
                    
                }
            />
        )
    }
}
export default ListaATA

