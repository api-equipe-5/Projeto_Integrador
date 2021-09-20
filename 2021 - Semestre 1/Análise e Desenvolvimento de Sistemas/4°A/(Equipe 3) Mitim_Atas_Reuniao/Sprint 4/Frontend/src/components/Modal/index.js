
import { Page, Text, View, Document, PDFViewer, PDFDownloadLink, StyleSheet, Image } from '@react-pdf/renderer';

import './ataModal.css'

export default function ModalAta({ assuntos, conteudo, close, participa, assinante }) {

    console.log(participa)


    const MyDocument = () => (
        <Document style={{paddingTop:'10px'}}>
            <Page size="A4" style={{paddingBottom: '10px'}}>
                <View style={{ border: '1px solid black', margin: '10px', display: 'flex', flexDirection: 'row', alignItems: 'center' }}>
                    <View style={{ borderRight: '1px solid black', padding: '30px' }}>
                        <Text>ATA</Text>
                        <Text>Nº.: {conteudo.numero}</Text>
                    </View>
                    <View style={{ borderRight: '1px solid black', padding: '20px' }}>
                        <Text>Data:{conteudo.datacriacao} - {conteudo.data}</Text>
                        <Text>Início: {conteudo.inicio} Horas   Fim: {conteudo.fim} Horas</Text>
                        <Text>Local: {conteudo.local}</Text>
                    </View>
                    <View>
                        <Image style={{ height: '100px', width: '120px', paddingLeft: '20px' }} src="https://i.ibb.co/RznpQxJ/iacit-logo.jpg"></Image>
                    </View>
                </View>
                <View style={{ display: 'flex', flexDirection: 'colum', alignItems: 'center', margin: '10px' }}>
                    <Text style={{ fontWeight: 'bold' }}>ATA DE REUNIÃO</Text>
                </View>
                <View style={{ border: '1px solid black', margin: '10px', display: 'flex', flexDirection: 'row', alignItems: 'center' }}>
                    <View style={{ fontSize: '15px' }}>
                        <Text style={{ marginBottom: '15px' }}>Projeto: {conteudo.tema}</Text>
                        {
                            participa.map((participa) => (
                                <View key={participa.id} style={{ display: 'flex', flexDirection: 'row', alignItems: 'center', margin: '10px', paddingBottom: '10px' }}>

                                    <View style={{ margin: '15px' }}>
                                        <Text>Participante:</Text>
                                        <Text >{participa.cargo} - {participa.nome}</Text>
                                    </View>
                                    <View style={{ margin: '15px' }}>
                                        <Text>Área:</Text>
                                        <Text >{participa.area}</Text>
                                    </View>
                                    <View style={{ margin: '15px' }}>
                                        <Text>Email: </Text>
                                        <Text>{participa.email}</Text>
                                    </View>
                                    <View style={{ margin: '15px' }}>
                                        <Text>Telefone:</Text>
                                        <Text >{participa.telefone}</Text>
                                    </View>
                                </View>
                            ))
                        }
                    </View>
                </View>
                <View style={{ display: 'flex', flexDirection: 'colum', alignItems: 'center' }}>
                    <Text style={{ border: '1px solid black', width: '575px;', textAlign: 'center', padding: '5px;', backgroundColor: '#c6d9f1' }}>PAUTA</Text>
                    <Text style={{ border: '1px 1px 1px solid black', borderTopWidth: '0px', width: '575px;', textAlign: 'center', padding: '8px;', marginBottom: '10px', fontSize: '15px' }}>{conteudo.pauta}</Text>
                </View>
                <View style={{ border: '1px solid black', margin: '10px', padding: '5px' }}>
                    <Text style={{ fontWeight: 'bold', marginBottom: '10px' }}>Observações:</Text>
                    <Text style={{ marginBottom: '10px', fontSize: '12px' }}> 1 -  Deve ser disponibilizada cópia da Ata de Reunião para os participantes e envolvidos;</Text>
                    <Text style={{ fontSize: '12px' }}>2 – O campo PRAZO define as datas de entrega das solicitações por parte dos responsáveis definidos no campo RESPONSÁVEL.</Text>
                </View>
                <View >
                    <View style={{ border: '1px solid black', margin: '10px', display: 'flex', flexDirection: 'row', alignItems: 'center', backgroundColor: '#c6d9f1' }}>
                        <Text style={{ margin: '10px' }}>ID</Text>
                        <Text style={{ marginRight: '30px', marginLeft: '80px' }}>ASSUNTO</Text>
                        <Text style={{ marginRight: '60px', marginLeft: '50px' }}>RESPONSÁVEL</Text>
                        <Text style={{ margin: '10px' }}>PRAZO</Text>
                    </View>
                    {
                        assuntos.map((assuntos) => (
                            <View key={assuntos.id} style={{ margin: '10px', display: 'flex', flexDirection: 'row', alignContent: 'center' }}>
                                <Text style={{ marginLeft: '15px', width: '30px;' }}>{assuntos.id}</Text>
                                <Text style={{ marginLeft: '10px', width: '230px;', fontSize: '15px' }}>{assuntos.assunto}</Text>
                                <Text style={{ marginLeft: '10px', width: '180px', fontSize: '15px' }}>{assuntos.responsavel}</Text>
                                <Text style={{ fontSize: '15px' }}>{assuntos.prazo}</Text>
                            </View>
                        ))
                    }

                </View>
            </Page>
            <Page size="A4">
                <View style={{ margin: '20px' }}>
                    <View>
                        <Text style={{ marginBottom: '40px' }}>Continuação da ATA Nº.: {conteudo.numero}</Text>
                    </View>
                    <View>
                        {
                            assinante.map((assinante) => (
                                <View key={assinante.id} style={{ marginBottom: '20px' }} >
                                    <Text style={{ margin: '10px' }}>______________________</Text>
                                    <Text>{assinante.cargo} - {assinante.nome}</Text>
                                </View>

                            ))
                        }
                    </View>
                </View>
            </Page>
        </Document >
    )

    return (
        <div className="modal">
            <div className="fundo">
                <h1>Visualizar PDF</h1>
                <button onClick={close} type="button" className='button-fechar' style={{ height: '40px', width: '20px', margin: '10px' }}>X</button>
                <PDFViewer style={{ height: '200px', width: '400px' }}>
                    <MyDocument />
                </PDFViewer>
                <div>
                    <PDFDownloadLink document={<MyDocument />} fileName='Ata.pdf'>
                        {({ blob, url, loading, error }) => (loading ? 'Carregando Documento...' : 'Baixar')}
                    </PDFDownloadLink>
                </div>
            </div>
        </div>

    )
}