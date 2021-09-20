import React, { useState } from 'react'
import { CSVLink } from 'react-csv';
import  {dados} from './Assinatura'
import { Page, Text, View, StyleSheet, PDFDownloadLink, Document, Image} from '@react-pdf/renderer';
import Popup from './Popup';
import imagens from '../../assets/images/iacitlogo.jpg'


export function Ata(){  

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
                        <Text>Data: {dados.data_inicio} - {dados.data_fim}</Text>
                        <Text style={{marginTop: '15px'}}>Início: {dados.hora_inicio} Fim: {dados.hora_fim}</Text>
                        <Text style={{marginTop: '15px'}}>Local: {dados.local}</Text>
                    </View>
                    <View style={style.header.three}>
                        <Image src={imagens} style={style.header.img} />
                    </View>
                </View>
                
                <View style={{width: "100%", textAlign: "center", margin: "15px 0 15px", fontSize: "12pt"}}>
                    <Text>ATA DE REUNIÃO</Text>
                </View>

                <View style={{height: "15px", width: "80%", margin: "0 10% 0"}}>
                    <Text>Projeto: {dados.tema}</Text>
                </View>

                <View style={style.projeto}>
                    <View style={style.projeto.one}>
                        <Text><b>Participante(s):</b></Text>
                        <Text>{dados.participante}</Text>                               
                    </View>
                    <View style={style.projeto.one}>
                        <Text>Área(s):</Text>
                        <Text>{dados.area}</Text>                         
                    </View>
                    <View style={style.projeto.one}>
                        <Text>E-mail(s):</Text>
                        <Text>{dados.email}</Text>                 
                    </View>
                    <View style={style.projeto.one}>
                        <Text>Telefone(s):</Text>
                        <Text>{dados.telefone}</Text>                  
                    </View>
                </View> 

                <View style={style.pauta}>
                    <Text>PAUTA</Text>
                </View>
                <View style={style.pauta.one}>
                    <Text>{dados.pauta}</Text>
                </View>

                <View style={{height: "55px", width: "80%", margin: "15px 10% 0", padding: "5px"}}>
                    <Text>Observações:</Text>
                    <Text style={{marginTop: '5px'}}>1 – Deve ser disponibilizada cópia da Ata de Reunião para os participantes e envolvidos;</Text>
                    <Text style={{marginTop: '5px'}}>2 – O campo PRAZO define as datas de entrega das solicitações por parte dos responsáveis definidos no campo RESPONSÁVEL.</Text>
                </View>

                <View style={{heigth: "15px", width: "80%", margin: "15px 10% 0", textAlign: "center"}}>
                    <Text>DISTRIBUIÇÃO: {dados.area}</Text>
                </View>

                <View style={{heigth: "15px", width: "80%", margin: "15px 10% 0", textAlign: "left"}}>
                
                    <Text>Assuntos: </Text>
                    <Text>{dados.assunto}</Text>
                    <Text>Responsáveis: </Text>
                    <Text>{dados.responsavel}</Text>
                    <Text>Prazos: </Text>
                    <Text>{dados.prazo}</Text>


                    <Text>Representantes: </Text>
                    <Text>{dados.representante}</Text>
                    <Text>Nomes: </Text>
                    <Text>{dados.nome}</Text>
                    <Text>Assinaturas:</Text>
                    <Text>{dados.assinatura}</Text>
                </View>    
            </Page>
        </Document>
    );
    
    const [buttonPopup, setButtonPopup] = useState(false);

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
                                    <input type="text" className="form-control" name="tema" id="tema" value={dados.tema}
                                    />
                                </div>
                                <div className="col-2">Pauta da Reunião:</div>
                                <div className="col-4">
                                    <input type="text" className="form-control" name="pauta" value={dados.pauta}
                                    />
                                </div>
                            </div>
                            <div className="form-group row">
                                <div className="col-2">Data:</div>
                                <div className="col-4">
                                    <input type="date" className="form-control" name="data_inicio" value={dados.data_inicio}
                                    />
                                </div>
                                <div className="col-4">
                                    <input type="date" className="form-control" name="data_fim" value={dados.data_fim}
                                    />
                                </div>
                            </div>

                            <div className="form-group row">
                                <div className="col-2">Horário:</div>
                                <div className="col-4">
                                    <input type="time" className="form-control" name="hora_inicio" value={dados.hora_inicio}
                                    />
                                </div>
                                <div className="col-4">
                                    <input type="time" className="form-control" name="hora_fim" value={dados.hora_fim}
                                    />
                                </div>
                            </div>
                            <div className="form-group row">
                                <div className="col-2">Local da Reunião:</div>
                                <div className="col-4">
                                    <input type="text" className="form-control" name="local" value={dados.local}
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
                                        <textarea type="text" className="form-control" name="participante"  value={dados.participante}
                                        />
                                    </div>
                                    <div className="col">
                                        <textarea type="text" className="form-control" name="area" value={dados.area}
                                        />
                                    </div>
                                    <div className="col">
                                        <textarea type="text" className="form-control" name="email"  value={dados.email}
                                        />
                                    </div>
                                    <div className="col">
                                        <textarea type="text" className="form-control" name="telefone" value={dados.telefone}
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
                                        <textarea className="form-control" name="assunto" value={dados.assunto}
                                        />
                                    </div>
                                    <div className="col">
                                        <textarea type="text" className="form-control" name="responsavel" value={dados.responsavel}
                                        />
                                    </div>
                                    <div className="col">
                                        <textarea type="text" className="form-control" name="prazo" value={dados.prazo}
                                        />
                                    </div>
                                    <div className="col">
                                        <textarea type="text" className="form-control" name="distribuicao" value={dados.distribuicao}
                                        />
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div className="card-body">
                    <div className="row justify-content-center align-items-center">
                    <button className='btn btn-success' onClick={() => {setButtonPopup(true);}}>Imprimir ATA</button>

                        <Popup trigger={buttonPopup} setTrigger={setButtonPopup}>
                            <h2>Agora escolha o tipo de arquivo que deseja gerar:</h2>
                            <PDFDownloadLink document={<MyDocument />} fileName="DocumentoATA.pdf">
                                 {({ blob, url, loading, error }) => (loading ? 'Loading document...' : 'Download now!')} <button style={{marginRight:"5px"}} className="btn btn-outline-danger">PDF</button>
                            </PDFDownloadLink>
                            <CSVLink data={JSON.stringify(dados)} ><button className="btn btn-outline-success"> CSV</button></CSVLink>
                        </Popup>
                    </div>     
                </div>
            </div>
        </div>
    </div>

    )
}
                           