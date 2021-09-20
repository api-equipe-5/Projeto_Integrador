import React, { useState } from 'react'
import { CSVLink } from "react-csv";
import "../../assets/css/style.css"
import imagens from "../../assets/images/iacitlogo.jpg"

import { Page, Text, View, StyleSheet, PDFDownloadLink, Document, Image} from '@react-pdf/renderer';

import Popup from '../components/Popup';
import api from "../../service/api";
import Menu from '../Menu'
import  {dadosRevisao} from './ListaATA'


export function Revisao() {
    let dados ={}
    let infoRevisao ={}
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
                <Text>Responsaveis: </Text>
                <Text>{responsavel}</Text>
                <Text>Prazos: </Text>
                <Text>{prazo}</Text>


                <Text>Representantes: </Text>
                <Text>{representante}</Text>
                <Text>Nomes: </Text>
                <Text>{nome}</Text>
                <Text>Assinaturas: </Text>
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

    const [id, setId] = useState(dadosRevisao.id)
    const [tema, setTema] = useState(dadosRevisao.tema);
    const [pauta, setPauta] = useState(dadosRevisao.pauta);
    const [data_inicio, setData_Inicio] = useState(dadosRevisao.data_inicio);
    const [data_fim, setData_Fim] = useState(dadosRevisao.data_fim);
    const [hora_inicio, setHora_Inicio] = useState(dadosRevisao.hora_inicio);
    const [hora_fim, setHora_Fim] = useState(dadosRevisao.hora_fim);
    const [local, setLocal] = useState(dadosRevisao.local);
    const [participante, setParticipante] = useState(dadosRevisao.participante);
    const [area, setArea] = useState(dadosRevisao.area);
    const [email, setEmail] = useState(dadosRevisao.email);
    const [telefone, setTelefone] = useState(dadosRevisao.telefone);
    const [assunto, setAssunto] = useState(dadosRevisao.assunto);
    const [responsavel, setResponsavel] = useState(dadosRevisao.responsavel);
    const [prazo, setPrazo] = useState(dadosRevisao.prazo);
    const [distribuicao, setDistribuicao] = useState(dadosRevisao.distribuicao);
    const [representante, setRepresentante] = useState(dadosRevisao.representante);
    const [nome, setNome] = useState(dadosRevisao.nome);
    const [assinatura, setAssinatura] = useState(dadosRevisao.assinatura);
    const [assuntoRevisao, setAssuntoRevisao] = useState("");
    const [responsavelRevisao, setResponsavelRevisao] = useState("");
    const [prazoRevisao, setPrazoRevisao] = useState("");


    const [data, setData] = useState([]);
    const [infoRev, setInfoRev] = useState([])
    
     async function handleCadastrar(e){
         const assunto_rev = assuntoRevisao
         const prazo_rev = prazoRevisao        
         const responsavel_rev = responsavelRevisao
         const id_ata = id
         setData([...data, {id, tema, pauta, data_inicio, data_fim, 
             hora_inicio, hora_fim, local, participante, 
             area, email, telefone, assunto, responsavel, 
             prazo, distribuicao, representante, nome, assinatura}]);
         setInfoRev([...infoRev,{assunto_rev, responsavel_rev, prazo_rev, id_ata}]);

         dados = {
             id,
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
             estado:'Pendente'
         };

         infoRevisao ={
             id_ata,
             assunto_rev,
             responsavel_rev,
             prazo_rev
         }

         try{
            const response = await api.put('ata', dados);
            const revisar = await api.post('/salvar/revisao', infoRevisao)
            alert('Sucesso!')
         }catch(err){
             alert('Erro')
         }
     }
    return (
        <div>
            <Menu />
            <div className="container" >       
            
            <div className="card shadow" style={{margin:'5%'}}>
                <div className="card-header">
                    <h4>ATA</h4>        
                </div>
                <div className="card-body">
                    <form>                       
                            <div>
                                <div className="form-group row">
                                    <div className="col-2">Tema da Reunião:</div>
                                    <div className="col-4">
                                        <input type="text" className="form-control" name="tema" id="tema" value={tema}
                                        onChange={(e) => setTema(e.target.value)} /> 
                                    </div>  
                                    <div className="col-2">Pauta da Reunião:</div>
                                    <div className="col-4">
                                        <input type="text" className="form-control" name="pauta" value={pauta}
                                         onChange={(e) => setPauta(e.target.value)}  />       
                                    </div>  
                                </div> 
                                <div className="form-group row">
                                    <div className="col-2">Data:</div>
                                    <div className="col-4">
                                        <input type="date" className="form-control" name="data_inicio" value={data_inicio} 
                                         onChange={(e) => setData_Inicio(e.target.value)} />       
                                    </div>  
                                    <div className="col-4">
                                        <input type="date" className="form-control" name="data_fim" value={data_fim} 
                                         onChange={(e) => setData_Fim(e.target.value)}/>       
                                    </div>  
                                </div>

                                <div className="form-group row">
                                <div className="col-2">Horário:</div>
                                    <div className="col-4">
                                        <input type="time" className="form-control" name="hora_inicio" value={hora_inicio}  
                                        onChange={(e) => setHora_Inicio(e.target.value)} />       
                                    </div>  
                                    <div className="col-4">
                                        <input type="time" className="form-control" name="hora_fim" value={hora_fim}
                                        onChange={(e) => setHora_Fim(e.target.value)}/>       
                                    </div> 
                                </div>
                                <div className="form-group row">
                                    <div className="col-2">Local da Reunião:</div>
                                    <div className="col-4">
                                        <input type="text" className="form-control" name="local" value={local} 
                                         onChange={(e) => setLocal(e.target.value)}/>       
                                    </div>                    
                                </div>
                            </div>
                    </form>                                       
                </div>
                <div className="card">
                    <div className="card-header" style={{textAlign:'center'}}>
                        <h5>Participantes</h5>
                    </div>
                    <div className="card-body">
                        <form>                       
                            <div>
                                    <div className="form-group row">                                      
                                        <div className="col">
                                            <textarea type="text" className="form-control" name="participante" value={participante}  
                                            onChange={(e) => setParticipante(e.target.value)}/>       
                                        </div> 
                                        <div className="col">
                                            <textarea type="text" className="form-control" name="area" value={area} 
                                            onChange={(e) => setArea(e.target.value)}/>       
                                        </div>
                                        <div className="col">
                                            <textarea type="text" className="form-control" name="email" value={email} 
                                            onChange={(e) => setEmail(e.target.value)}/>       
                                        </div> 
                                        <div className="col">
                                            <textarea type="text" className="form-control" name="telefone" value={telefone}
                                            onChange={(e) => setTelefone(e.target.value)} />       
                                        </div>                                     
                                    </div>             
                                </div>                                                                                    
                        </form>
                    </div>
                </div>

                <div className="card">
                    <div className="card-header" style={{textAlign:'center'}}>
                        <h5>Assuntos</h5>
                    </div>
                    <div className="card-body">
                        <form>                       
                            <div>
                                    <div className="form-group row">                                      
                                        <div className="col">
                                            <textarea className="form-control" name="assunto" value={assunto} 
                                            onChange={(e) => setAssunto(e.target.value)} />       
                                        </div>
                                        <div className="col">
                                            <textarea type="text" className="form-control" name="responsavel" value={responsavel} 
                                            onChange={(e) => setResponsavel(e.target.value)}/>       
                                        </div> 
                                        <div className="col">
                                            <textarea type="text" className="form-control" name="prazo" value={prazo} 
                                            onChange={(e) => setPrazo(e.target.value)}/>       
                                        </div> 
                                        <div className="col">
                                            <textarea type="text" className="form-control" name="distribuicao" value={distribuicao} 
                                            onChange={(e) => setDistribuicao(e.target.value)} />       
                                        </div>              
                                    </div>             
                                </div>                                                                                  
                        </form>
                    </div>    
                </div>

                <div className="card">
                    <div className="card-header" style={{textAlign:'center'}}>
                        <h5>Dados da revisão</h5>
                    </div>
                    <div className="card-body">
                        <form>                       
                            <div>
                                    <div className="form-group row">                                      
                                        <div className="col">
                                            <input type="text" className="form-control" name="assunto_revisao" placeholder="Assunto da revisão"  
                                            onChange={(e) => setAssuntoRevisao(e.target.value)}
                                           />       
                                        </div> 
                                        <div className="col">
                                            <input type="text" className="form-control" name="responsavel_revisao" placeholder="Responsável da revisão" 
                                            onChange={(e) => setResponsavelRevisao(e.target.value)}
                                           />       
                                        </div> 
                                        <div className="col">
                                            <input type="date" className="form-control" name="prazo_revisao" placeholder="Prazo da revisão"
                                            onChange={(e) => setPrazoRevisao(e.target.value)} 
                                            />       
                                        </div>             
                                    </div>             
                                </div>                                                                                   
                        </form>
                    </div>    
                </div>


                <div className="card-body">
                    <div className="row justify-content-center align-items-center">
                    <button className='btn btn-success' onClick={() => {handleCadastrar(); setButtonPopup(true);}}>Enviar Revisão</button>

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
export default Revisao