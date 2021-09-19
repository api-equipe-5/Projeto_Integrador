import React,{useState,useEffect} from 'react';
import { FaArrowLeft } from 'react-icons/fa';
import InputMask from 'react-input-mask';
import { Link,useParams,useHistory } from 'react-router-dom';
import Sidenav from '../../../../components/sidenav/index';
import Header from '../../../../components/header/index';
import api from "./../../../../services/api";
import { FaEdit,FaCheck,FaExclamationTriangle,FaTimes } from 'react-icons/fa';

function EditPagamento(){

    const hist = useHistory();
    const {id} = useParams();

    const [valor,setValor]=useState();
    const [obs,setObs]=useState();
    const [data,setData]=useState();
    const [status,setStatus]=useState();
    const [motorista,setMotorista]=useState([]);

    var inputRules = {
        '9': '[0-9]','a': '[A-Za-z]','*': '[A-Za-z0-9]'
    }

    useEffect(()=>{
        getJornada();
    },[])

    async function getJornada(){
        const res = await api.get("/pagamento/"+id,{
            headers:{
                "Authorization":"Bearer "+localStorage.getItem("token")
            }
        })
        console.log(res.data);
        setValor(res.data.valor);
        setObs(res.data.observacao);
        setData(res.data.data);
        setStatus(res.data.status);
        setMotorista(res.data.usuario);
    }

    async function handleSubmit(e){
        e.preventDefault()
        try{
            await api.put("/pagamento/"+id,{
                "valor": valor,
                "observacao": obs,
                "status": status,
                "data": data,
                "usuario": {
                    "matricula": motorista.matricula
                }
            },{
                headers:{
                    "Authorization":"Bearer "+localStorage.getItem("token")
                }
            });
            alert("Pagamento atualizado");
            hist.push("/dashboard/pagamento");
        }catch(err){
            console.log(err);
        }
    }

    return(
        <div className="dashboard">
            <Sidenav/>
            <div className="content">
                <Header text="Pagamentos"/>
                <div className="main">
                    <div className="editColaborador">
                        <section>
                            <Link to='/dashboard/pagamento'>
                                <FaArrowLeft/>&nbsp;Voltar
                            </Link>
                        </section>
                            <h5><b>Usuário: </b>{motorista.nome}</h5>
                            <form onSubmit={handleSubmit}>
                            <div>
                                <label>Valor</label>
                                <input type="number" value={valor} onChange={e => setValor(e.target.value)} required/>
                            </div>
                            <div>
                                <label>Observação</label>
                                <input type="text" value={obs} onChange={e => setObs(e.target.value)} required/>
                            </div>
                            <div>
                                <label>Data</label>
                                <InputMask type="text" mask="99/99/9999" formatChars={inputRules} value={data} onChange={e => setData(e.target.value)} required/>
                            </div>
                            <div>
                                <label>Status</label>
                                <select value={status} onChange={e => setStatus(e.target.value)}>
                                    <option value='pago'>Pago</option>
                                    <option value='pendente'>Pendente</option>
                                    <option value='cancelado'>Cancelado</option>
                                </select>
                            </div>
                                <button type="submit">Salvar</button>
                            </form>  
                    </div>
                </div>
            </div>
        </div>
    );
}

export default EditPagamento;