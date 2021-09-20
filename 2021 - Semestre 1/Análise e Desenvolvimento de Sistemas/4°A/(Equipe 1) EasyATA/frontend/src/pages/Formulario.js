import React, { useState } from 'react'
import { CSVLink } from "react-csv";
import "../assets/css/style.css"
import imagens from "../assets/images/iacitlogo.jpg"

import { Page, Text, View, StyleSheet, PDFDownloadLink, Document, Image} from '@react-pdf/renderer';

import Popup from './components/Popup';
import api from "../service/api";

import Menu from './Menu';

export function Formulario() {

    const style = StyleSheet.create({
        page: {
            backgroundColor: '#fff',
            fontSize: '10pt'
        },

        header: {
            height: '80px',
            width: '80%',
            margin: '5% 10% 0 10%',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-start',
            fontSize: '12pt',

            one: {
                height: '100%',
                width: '30%',
                textAlign: 'center',
                padding: '5%'
            },
            two: {
                height: '100%',
                width: '50%',
                padding: '5px',
            },
            three: {
                height: '100%',
                width: '20%',
            },
        },

        projeto: {
            height: '160px',
            width: '80%',
            margin: "0 10% 0",
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-start',
            
            one: {
                height: '100%',
                width: '25%',    
            }
        },

        pauta: {
            height: '20px',
            width: '80%',
            margin: '15px 10% 0',
            padding: '4px 0 4px',
            textAlign: 'center',
            backgroundColor: 'lightblue',

            one: {
                height: '25px',
                width: '80%',
                margin: "0 10% 0",
                padding: '4px 0 4px',
                textAlign: 'center'
            }
        },

        assunto: {
            width: '80%',
            marginLeft: '10%',
            marginRight: '10%',
            marginTop: '15px',
            backgroundColor: 'grey',
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'flex-start',
            
            one: {
                backgroundColor: 'red',
                height: '15px',
                width: '5%',               
            },
            two: {
                backgroundColor: 'green',
                height: '15px',
                width: '70%',
            },
            three: {
                backgroundColor: 'blue',
                height: '15px',
                width: '15%',
            },
            four: {
                backgroundColor: 'purple',
                height: '15px',
                width: '10%',
            },
            five: {
                backgroundColor: 'purple',
                height: '100%',
                
            }
        },
        

    });

    const MyDocument = () => (
        <Document>
            <Page size="A4" style={style.page}>
                <View style={style.header}>
                    <View style={style.header.one}>
                        <Text>ATA Nº.:</Text>                     
                    </View>
                    <View style={style.header.two}>
                        <Text>Data: {data_inicio} - {data_fim}</Text>
                        <Text style={{marginTop: '15px'}}>Início: {hora_inicio} Fim: {hora_fim}</Text>
                        <Text style={{marginTop: '15px'}}>Local: {local}</Text>
                    </View>
                    <View style={style.header.three}>
                        <Image src={imagens} style={style.header.img} />
                    </View>
                </View>
                
                <View style={{width: "100%", textAlign: "center", margin: "15px 0 15px", fontSize: "12pt"}}>
                    <Text>ATA DE REUNIÃO</Text>
                </View>

                <View style={{height: "15px", width: "80%", margin: "0 10% 0"}}>
                    <Text>Projeto: {tema}</Text>
                </View>

                <View style={style.projeto}>
                    <View style={style.projeto.one}>
                        <Text><b>Participante(s):</b></Text>
                        <Text>{participante}</Text>                               
                    </View>
                    <View style={style.projeto.one}>
                        <Text>Área(s):</Text>
                        <Text>{area}</Text>                         
                    </View>
                    <View style={style.projeto.one}>
                        <Text>E-mail(s):</Text>
                        <Text>{email}</Text>                 
                    </View>
                    <View style={style.projeto.one}>
                        <Text>Telefone(s):</Text>
                        <Text>{telefone}</Text>                  
                    </View>
                </View> 

                <View style={style.pauta}>
                    <Text>PAUTA</Text>
                </View>
                <View style={style.pauta.one}>
                    <Text>{pauta}</Text>
                </View>

                <View style={{height: "55px", width: "80%", margin: "15px 10% 0", padding: "5px"}}>
                    <Text>Observações:</Text>
                    <Text style={{marginTop: '5px'}}>1 – Deve ser disponibilizada cópia da Ata de Reunião para os participantes e envolvidos;</Text>
                    <Text style={{marginTop: '5px'}}>2 – O campo PRAZO define as datas de entrega das solicitações por parte dos responsáveis definidos no campo RESPONSÁVEL.</Text>
                </View>

                <View style={{heigth: "15px", width: "80%", margin: "15px 10% 0", textAlign: "center"}}>
                    <Text>DISTRIBUIÇÃO: {area}</Text>
                </View>
                <View style={{heigth: "15px", width: "80%", margin: "15px 10% 0", textAlign: "left"}}>
                
                <Text>Assuntos: </Text>
                <Text>{assunto}</Text>
                <Text>Responsáveis: </Text>
                <Text>{responsavel}</Text>
                <Text>Prazos: </Text>
                <Text>{prazo}</Text>


                <Text>Representantes: </Text>
                <Text>{representante}</Text>
                <Text>Nomes: </Text>
                <Text>{nome}</Text>
                <Text>Assinaturas:</Text>
                <Text>{assinatura}</Text>
                </View>
                
            </Page>
        </Document>
    );
    
    const [buttonPopup, setButtonPopup] = useState(false);

    const headers = [
        { label: "Tema", key: "tema" },
        { label: "Pauta", key: "pauta" },
        { label: "Data_Inicio", key: "data_inicio" },
        { label: "Data_Fim", key: "data_fim" },
        { label: "Hora_Inicio", key: "hora_inicio" },
        { label: "Hora_Fim", key: "hora_fim" },
        { label: "Local", key: "local" },
        { label: "Participante", key: "participante" },
        { label: "Area", key: "area" },
        { label: "Email", key: "email" },
        { label: "Telefone", key: "telefone" },
        { label: "Assunto", key: "assunto" },
        { label: "Responsavel", key: "responsavel" },
        { label: "Prazo", key: "prazo" },
        { label: "Distribuicao", key: "distribuicao" },
        { label: "Representante", key: "representante" },
        { label: "Nome", key: "nome" },
        { label: "Assinatura", key: "assinatura" }

    ];

    const [tema, setTema] = useState("");
    const [pauta, setPauta] = useState("");
    const [data_inicio, setData_Inicio] = useState("");
    const [data_fim, setData_Fim] = useState("");
    const [hora_inicio, setHora_Inicio] = useState("");
    const [hora_fim, setHora_Fim] = useState("");
    const [local, setLocal] = useState("");
    const [participante, setParticipante] = useState("");
    const [area, setArea] = useState("");
    const [email, setEmail] = useState("");
    const [telefone, setTelefone] = useState("");
    const [assunto, setAssunto] = useState("");
    const [responsavel, setResponsavel] = useState("");
    const [prazo, setPrazo] = useState("");
    const [distribuicao, setDistribuicao] = useState("");
    const [representante, setRepresentante] = useState("");
    const [nome, setNome] = useState("");
    const [assinatura, setAssinatura] = useState("");
    const [estado, setEstado] = useState("")
    const [data, setData] = useState([]);

    async function handleCadastrar(e){

        setData([...data, {tema, pauta, data_inicio, data_fim, 
            hora_inicio, hora_fim, local, participante, 
            area, email, telefone, assunto, responsavel, 
            prazo, distribuicao, representante, nome, assinatura, estado}]);

        const dados = {
            tema, 
            pauta,
            data_inicio,
            data_fim,
            hora_inicio,
            hora_fim,
            local,
            participante,
            area,
            email,
            telefone,
            assunto,
            responsavel,
            prazo,
            distribuicao,
            representante,
            nome,
            assinatura,
            estado: 'Nova'
        };

        try{
        const response = await api.post('saveAta', dados);
        alert('Sucesso!')
        }catch(err){
            alert('Erro')
        }
    }

    return (
        <div>
            <Menu/>
            <div className="container">       
            
            <div className="card shadow" style={{margin:'5%'}}>
                <div className="card-header">
                    <h4>Formulário <small>da ATA</small></h4>        
                </div>
                <div className="card-body">
                    <form>                       
                            <div>
                                <div className="form-group row">
                                    <div className="col-2">Tema da Reunião:</div>
                                    <div className="col-4">
                                        <input type="text" className="form-control" name="tema" id="tema"
                                         onChange={(e) => setTema(e.target.value)}  />       
                                    </div>  
                                    <div className="col-2">Pauta da Reunião:</div>
                                    <div className="col-4">
                                        <input type="text" className="form-control" name="pauta"
                                         onChange={(e) => setPauta(e.target.value)}  />       
                                    </div>  
                                </div> 
                                <div className="form-group row">
                                    <div className="col-2">Data:</div>
                                    <div className="col-4">
                                        <input type="date" className="form-control" name="data_inicio" placeholder="Início" 
                                         onChange={(e) => setData_Inicio(e.target.value)} />       
                                    </div>  
                                    <div className="col-4">
                                        <input type="date" className="form-control" name="data_fim" placeholder="Fim" 
                                         onChange={(e) => setData_Fim(e.target.value)}/>       
                                    </div>  
                                </div>

                                <div className="form-group row">
                                <div className="col-2">Horário:</div>
                                    <div className="col-4">
                                        <input type="time" className="form-control" name="hora_inicio" placeholder="Início"  
                                        onChange={(e) => setHora_Inicio(e.target.value)} />       
                                    </div>  
                                    <div className="col-4">
                                        <input type="time" className="form-control" name="hora_fim" placeholder="Fim" 
                                        onChange={(e) => setHora_Fim(e.target.value)}/>       
                                    </div> 
                                </div>
                                <div className="form-group row">
                                    <div className="col-2">Local da Reunião:</div>
                                    <div className="col-4">
                                        <input type="text" className="form-control" name="local" 
                                         onChange={(e) => setLocal(e.target.value)}/>       
                                    </div>                    
                                </div>
                            </div>
                    </form>                                       
                </div>

                <div className="alert alert-danger" role="alert">
                    Todos os campos abaixo devem ser preenchidos da seguinte forma:
                    <b> Item1, Item2, Item3...</b> 
                </div>

                <div className="card">
                    <div className="card-header" style={{textAlign:'center'}}>
                        <h5>Adicionar Participantes</h5>
                    </div>
                    <div className="card-body">
                        <form>                       
                            <div>
                                    <div className="form-group row">                                      
                                        <div className="col">
                                            <textarea type="text" className="form-control" name="participante" placeholder="Participante1, Participante2..." required  
                                            onChange={(e) => setParticipante(e.target.value)}/>       
                                        </div> 
                                        <div className="col">
                                            <textarea type="text" className="form-control" name="area" placeholder="Área1, Área2..." 
                                            onChange={(e) => setArea(e.target.value)}/>       
                                        </div>
                                        <div className="col">
                                            <textarea type="text" className="form-control" name="email" placeholder="E-mail1, E-mail2..." 
                                            onChange={(e) => setEmail(e.target.value)}/>       
                                        </div> 
                                        <div className="col">
                                            <textarea type="text" className="form-control" name="telefone" placeholder="Telefone1, Telefone2"
                                            onChange={(e) => setTelefone(e.target.value)} />       
                                        </div>                                     
                                    </div>             
                                </div>                                                                                    
                        </form>
                    </div>
                </div>

                <div className="card">
                    <div className="card-header" style={{textAlign:'center'}}>
                        <h5>Adicionar Assunto</h5>
                    </div>
                    <div className="card-body">
                        <form>                       
                            <div>
                                    <div className="form-group row">                                      
                                        <div className="col">
                                            <textarea className="form-control" name="assunto" placeholder="Assunto1, Assunto2" 
                                            onChange={(e) => setAssunto(e.target.value)} />       
                                        </div>
                                        <div className="col">
                                            <textarea type="text" className="form-control" name="responsavel" placeholder="Responsável1, Responsável2" 
                                            onChange={(e) => setResponsavel(e.target.value)}/>       
                                        </div> 
                                        <div className="col">
                                            <textarea type="text" className="form-control" name="prazo" placeholder="Prazo1, Prazo2" 
                                            onChange={(e) => setPrazo(e.target.value)}/>       
                                        </div> 
                                        <div className="col">
                                            <textarea type="text" className="form-control" name="distribuicao" placeholder="Distribuição1, Distribuição2" 
                                            onChange={(e) => setDistribuicao(e.target.value)} />       
                                        </div>              
                                    </div>             
                                </div>                                                                                  
                        </form>
                    </div>    
                </div>

                <div className="card-body">
                    <div className="row justify-content-center align-items-center">
                    <button className='btn btn-success' onClick={() => {handleCadastrar(); setButtonPopup(true);}}>Enviar ATA</button>

                        <Popup trigger={buttonPopup} setTrigger={setButtonPopup}>
                            <h1>Documento enviado!</h1>
                            <h2>Agora escolha o tipo de arquivo que deseja gerar:</h2>
                            <PDFDownloadLink document={<MyDocument />} fileName="DocumentoATA.pdf">
                                 {({ blob, url, loading, error }) => (loading ? 'Loading document...' : 'Download now!')} <button style={{marginRight:"5px"}} className="btn btn-outline-danger">PDF</button>
                            </PDFDownloadLink>
                            <CSVLink data={data} headers={headers}><button className="btn btn-outline-success"> CSV</button></CSVLink>
                        </Popup>
                    </div>     
                </div>
            </div>  
        </div>   
    </div>       
    )
}
export default Formulario