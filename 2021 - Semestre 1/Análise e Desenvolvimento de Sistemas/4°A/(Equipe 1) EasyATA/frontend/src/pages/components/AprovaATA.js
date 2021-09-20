import React, { forwardRef} from 'react'
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
import { Ata } from './Ata';
import  {dados} from './Assinatura'


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
};


class ListaATA extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            atas: []
        }
    }

    componentDidMount(){
        AtasService.getAtas().then((response) => {
            this.setState({ atas: response.data})
        }); 
    }

    handleSuccess(data){
        let changeStatus = {
            estado: "Aprovado"
        }
        Object.assign(data, changeStatus)
        console.log(data)
        
        axios
          .put('http://localhost:8080/api/ata/', data)
          .then((response) => {
            this.setState({ atas: response.data})
            document.location.reload(true);
        }); 
    };

    handleFail(data){
        let changeStatus = {
            estado: "Nova"
        }
        Object.assign(data, changeStatus)
        console.log(data)
        
        axios
          .put('http://localhost:8080/api/ata/', data)
          .then((response) => {
            this.setState({ atas: response.data})
            document.location.reload(true);
        }); 
    };
    
    render(){
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
                    actions: 'Ação'
                },
                body: {
                    emptyDataSourceMessage: 'Não há nenhum registro',
                    filterRow: {
                        filterTooltip: 'Filter'
                    }
                }
            }}
            icons={tableIcons}
            title="Gerenciar Situação das ATAs"
            columns={[
                { title: 'ID', field: 'id'},
                { title: 'Tema', field: 'tema' },
                { title: 'Pauta', field: 'pauta' },
                { title: 'Data Início', field: 'data_inicio'},
                { title: 'Data Fim', field: 'data_fim' },
                { title: 'Horário Início', field: 'hora_inicio' },
                { title: 'Horário Fim', field: 'hora_fim'},
                { title: 'Local', field: 'local'},
                { title: 'Status', field: 'estado', 
                defaultFilter: 'Pendente' ,
                filtering: false,
                lookup: {'Pendente': 'Pendente', 'Aprovado': 'Aprovado', 'Reprovado': 'Reprovado'}}
              ]}
              data={this.state.atas}
              actions={[
                rowData => ({  
                    icon: () => <DoneIcon style={{ color: "green" }} />,
                    tooltip: 'Aprovar',
                    onClick: (event, rowData) => {this.handleSuccess(rowData)}
                }), 
                rowData => ({  
                    icon: () => <Clear style={{ color: "red" }} />,
                    tooltip: 'Reprovar',
                    onClick: (event, rowData) => {this.handleFail(rowData)}
                })
            ]}
              options={{
                actionsColumnIndex: -1,
                filtering: true
              }}
            />
        )
    }
}
export default ListaATA
