import React, { forwardRef} from 'react'
import axios from 'axios'
import UserService from '../../service/UserService'

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
import PermContactCalendarIcon from '@material-ui/icons/PermContactCalendar';
import SupervisorAccountIcon from '@material-ui/icons/SupervisorAccount';
import PersonIcon from '@material-ui/icons/Person';
import DeleteIcon from '@material-ui/icons/Delete';

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
    Admin: forwardRef((props, ref) => <PermContactCalendarIcon {...props} ref={ref} />),
    Gerente: forwardRef((props, ref) => <SupervisorAccountIcon {...props} ref={ref} />),
    Usuario: forwardRef((props, ref) => <PersonIcon {...props} ref={ref} />),
    DeleteUser: forwardRef((props, ref) => <DeleteIcon {...props} ref={ref} />),

};


class UserComponent extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            users: []
        }
    }

    componentDidMount(){
        UserService.getUsers().then((response) => {
            this.setState({ users: response.data})
        }); 
    }

    handleAdmin(data){
        let changeStatus = {
            perfil: "Admin"
        }
        Object.assign(data, changeStatus)
        console.log(data)
        
        axios
          .put('http://localhost:8080/api/usuario/atualizar', data)
          .then((response) => {
            this.setState({ users: response.data})
            document.location.reload(true);
        }); 
    };

    handleUserDelete(userDel){
        axios
          .delete('http://localhost:8080/api/usuario/deletar', {data: userDel})
            .then((response) => {
            this.setState({ users: response.data})
            document.location.reload(true);
        });
    };

    handleManager(data){
        let changeStatus = {
            perfil: "Gerente"
        }
        Object.assign(data, changeStatus)
        console.log(data)
        
        axios
          .put('http://localhost:8080/api/usuario/atualizar', data)
          .then((response) => {
            this.setState({ users: response.data})
            document.location.reload(true);
        }); 
         
    };

    handleUser(data){
        let changeStatus = {
            perfil: "Usuário"
        }
        Object.assign(data, changeStatus)
        console.log(data)
        
        axios
          .put('http://localhost:8080/api/usuario/atualizar', data)
          .then((response) => {
            this.setState({ users: response.data})
            document.location.reload(true);
        }); 
    };
    
    render(){
        return (
            <MaterialTable
            localization={{
                pagination: {
                    labelDisplayedRows: '{from}-{to} de {count}',
                    labelRowsSelect: 'usuários'
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
            title="Usuários"
            columns={[
                { title: 'ID', field: 'id'},
                { title: 'Email', field: 'email' },
                { title: 'Nome', field: 'nome' },
                { title: 'Perfil', field: 'perfil',  lookup: {'Admin' : 'Admin', 'Gerente': 'Gerente', 'Usuário': 'Usuário'}}
              ]}
              data={this.state.users}
              actions={[
                rowData => ({  
                    icon: () => <PermContactCalendarIcon />,
                    tooltip: 'Admin',
                    onClick: (event, rowData) => {this.handleAdmin(rowData)}
                }), 
                rowData => ({  
                    icon: () => <SupervisorAccountIcon />,
                    tooltip: 'Gerente',
                    onClick: (event, rowData) => {this.handleManager(rowData)}
                }),
                rowData => ({  
                    icon: () => <PersonIcon />,
                    tooltip: 'Usuário',
                    onClick: (event, rowData) => {this.handleUser(rowData)}
                }),
                rowData => ({  
                    icon: () => <DeleteIcon />,
                    tooltip: 'Excluir',
                    onClick: (event, rowData) => {this.handleUserDelete(rowData)}
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
export default UserComponent



























// import React from 'react'

// import UserService from '../../service/UserService';

// class UserComponent extends React.Component{

    // constructor(props){
    //     super(props)
    //     this.state = {
    //         users: []
    //     }
    // }

    // componentDidMount(){
    //     UserService.getUsers().then((response) => {
    //         this.setState({ users: response.data})
    //     }); 
    // }

//     render(){
//         return (
//             <div className="container">
//                 <div className="card shadow" style={{margin:'5%'}}>
//                 <div className="card-header">
//                     <h4>Usuários cadastrados</h4>        
//                 </div>
//                     <table className = "table table-striped">
//                         <thead>
//                             <tr>
//                                 <td>ID:</td>
//                                 <td>Email:</td>
//                                 <td>Nome:</td>
//                                 <td>Usuario:</td>
//                             </tr>
//                         </thead>
//                     <tbody>
//                         {
//                             this.state.users.map(
//                                 user =>
//                                 <tr key = {user.id}>
//                                     <td>{user.id}</td>
//                                     <td>{user.email}</td>
//                                     <td>{user.nome}</td>
//                                     <td>{user.login}</td>  
//                                 </tr>    
//                             )
//                         }
//                     </tbody>

//                     </table>
//                 </div>
//             </div>

//         )
//     }
// }
// export default UserComponent
