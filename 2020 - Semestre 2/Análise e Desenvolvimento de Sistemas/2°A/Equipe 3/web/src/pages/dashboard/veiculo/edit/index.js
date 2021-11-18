import React,{useEffect,useState} from 'react';
import './index.css';
import { FaArrowLeft } from 'react-icons/fa';
import InputMask from 'react-input-mask';
import { Link,useParams,useHistory } from 'react-router-dom';
import Sidenav from '../../../../components/sidenav/index';
import Header from '../../../../components/header/index';
import api from "./../../../../services/api"

function EditVeiculo(props){

    let {id} = useParams();

    const hist = useHistory()
    const [chassi,setChassi]=useState();
    const [placa,setPlaca]=useState("");
    const [modelo,setModelo]=useState();
    const [ano,setAno]=useState();
    const [mask,setMask] = useState("aaa-9999")
    const [tipoPlaca,setTipoPlaca] = useState("ANTIGA")

    var inputRules = {
        '9': '[0-9]','a': '[A-Za-z]','*': '[A-Za-z0-9]'
    }

    async function getVeiculo(){
        const res = await api.get("/veiculo/"+id,{
            headers:{
                "Authorization":"Bearer "+localStorage.getItem("token")
            }
        })
        setChassi(res.data.chassi)
        setAno(res.data.ano)
        setModelo(res.data.modelo)
        setPlaca(res.data.placa)

        if(res.data.placa.indexOf("-")>-1){
            setTipoPlaca("ANTIGA")
            setMask("aaa-9999")
        }
        else{
            setTipoPlaca("MERCOSUL")

            setMask("aaa9a99")

        }

    }
    async function handleSubmit(e){
        e.preventDefault();
            try{
                const veiculo = {
                    chassi:chassi,
                    placa:placa,
                    modelo:modelo,
                    ano:ano
                }
                
                await api.put("/veiculo/"+id,veiculo,{
                    headers:{
                        "Authorization":"Bearer "+localStorage.getItem("token")
                    }
                })
                alert("Veículo editado com sucesso!");
                hist.push("/dashboard/veiculo")
                
            }catch(err){
                console.log(err);
            }
        }

        useEffect(()=>{
            if(tipoPlaca=="MERCOSUL"){
                setMask("aaa9a99")
            }
            else{
                setMask("aaa-9999")
            }
        },[placa])

        useEffect(()=>{
            getVeiculo()

        },[])

    return(
        <div className="dashboard">
            <Sidenav/>
            <div className="content">
                <Header text="Veículos"/>
                <div className="main">
                    <div className="editVeiculo">
                        <section>
                            <Link to="/dashboard/veiculo">
                                <FaArrowLeft/>&nbsp;Voltar
                            </Link>
                        </section>
                        <form onSubmit={handleSubmit}>
                            <div>
                                <label>Chassi</label>
                                <InputMask type="text" mask="*****************" value={chassi} formatChars={inputRules} onChange={e => setChassi(e.target.value)} disabled />
                            </div>
                            <div>
                                <label>Tipo da Placa</label>
                                <select value={tipoPlaca} onChange={e => setTipoPlaca(e.target.value)} > 
                                    <option value="ANTIGA">Placa Antiga</option>
                                    <option value="MERCOSUL">Placa com o padrão Mercosul</option>
                                </select>
                            </div>
                            <div>
                                <label>Placa</label>
                                <InputMask type="text" mask={mask}   value={placa} formatChars={inputRules} onChange={e => setPlaca(e.target.value)} />
                            </div>
                            <div>
                                <label>Modelo</label>
                                <input type="text" value={modelo} onChange={e=>setModelo(e.target.value)} />
                            </div>
                            <div>
                                <label>Ano</label>
                                <InputMask type="text" mask="9999" value={ano} formatChars={inputRules}  onChange={e => setAno(e.target.value)} />
                            </div>
                            <button type="submit">Editar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default EditVeiculo;