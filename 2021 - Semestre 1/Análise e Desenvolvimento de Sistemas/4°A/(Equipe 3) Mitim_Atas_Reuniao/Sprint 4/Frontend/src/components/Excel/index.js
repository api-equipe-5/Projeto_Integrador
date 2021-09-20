import React from 'react';
import './excel.css'
import ReactHTMLTableToExcel from 'react-html-table-to-excel';



export default function Excel({ assuntos, conteudo, close, participa }) {

    return (
        <div>

            <div class="ritz grid-container" dir="ltr">
                <div className="modal">
                    <button onClick={close} style={{ margin: '10px' }}>X</button>
                    <ReactHTMLTableToExcel
                        id="test-table-xls-button"
                        className="download-table-xls-button"
                        table="table-to-xls"
                        filename="Ata"
                        sheet="Ata"
                        buttonText="Download Excel" />
                </div>
                <table class="waffle some" cellspacing="0" cellpadding="0" id="table-to-xls">
                    <tbody>
                        <tr style={{ height: '135px' }}>
                            <th id="1198975052R0" style={{ height: '135px' }} class="row-headers-background">
                                <div class="row-header-wrapper" style={{ lineHeight: '135px' }}>1</div>
                            </th>
                            <td class="s0"><span style={{ fontSize: "18px", fontFamily: "Arial", textAlign: 'center' }}>ATA Nº.:{conteudo.numero}</span></td>
                            <td class="s1"><span style={{ fontSize: "18px", fontFamily: "Arial" }}>Data:{conteudo.datacriacao} - {conteudo.data}<br /></span><span
                                style={{ fontSize: "18px", fontFamily: "Arial" }}>Início: {conteudo.inicio} Horas   Fim: {conteudo.fim} Horas Local: {conteudo.local}</span></td>
                            <td class="s1"></td>
                            <td class="s2"></td>
                        </tr>
                        <tr style={{ height: "78px" }}>
                            <th id="1198975052R1" style={{ height: "78px" }} class="row-headers-background">
                                <div class="row-header-wrapper" style={{ lineHeight: "78px" }}>2</div>
                            </th>
                            <td class="s3" colspan="4"><span style={{ fontSize: "18px", fontFamily: "Arial" }}>ATA DE REUNIÃO</span></td>
                        </tr>
                        <tr style={{ height: "416" }}>
                            <th id="1198975052R2" style={{ height: "416" }} class="row-headers-background">
                                <div class="row-header-wrapper" style={{ lineHeight: "416" }}>3</div>
                            </th>
                            <td class="s4" dir="ltr" colspan="3">
                                <span>Projeto: {conteudo.tema}</span>
                                {participa.map((participa) => (
                                    <>
                                        <span>Participante: {participa.cargo} - {participa.nome}</span>
                                        <span>Área: {participa.area}</span>
                                        <span>Email: {participa.email}</span>
                                        <span>Telefone: {participa.telefone}</span>
                                    </>
                                ))}
                            </td>
                            <td class="s2"></td>
                        </tr>
                        <tr style={{ height: "12px" }}>
                            <th id="1198975052R3" style={{ height: "12px" }} class="row-headers-background">
                                <div class="row-header-wrapper" style={{ lineHeight: "12px" }}>4</div>
                            </th>
                            <td class="s5"></td>
                            <td class="s5"></td>
                            <td class="s5"></td>
                            <td class="s6"></td>
                        </tr>
                        <tr style={{ height: "41px" }}>
                            <th id="1198975052R4" style={{ height: "41px" }} class="row-headers-background">
                                <div class="row-header-wrapper" style={{ lineHeight: "41px" }}>5</div>
                            </th>
                            <td class="s7" colspan="3"><span style={{ fontSize: "18px", fontFamily: "Arial" }}>PAUTA</span></td>
                            <td class="s8"></td>
                        </tr>
                        <tr style={{ height: "44px" }}>
                            <th id="1198975052R5" style={{ height: "44px" }} class="row-headers-background">
                                <div class="row-header-wrapper" style={{ lineHeight: "44px" }}>6</div>
                            </th>
                            <td class="s9" colspan="3"><span style={{ fontSize: "14px", fontFamily: "Arial" }}>{conteudo.pauta}</span>
                            </td>
                            <td class="s8"></td>
                        </tr>
                        <tr style={{ height: "26px" }}>
                            <th id="1198975052R6" style={{ height: "26px" }} class="row-headers-background">
                                <div class="row-header-wrapper" style={{ lineHeight: "26px" }}>7</div>
                            </th>
                            <td class="s5"></td>
                            <td class="s5"></td>
                            <td class="s5"></td>
                            <td class="s6"></td>
                        </tr>
                        <tr style={{ height: "120px" }}>
                            <th id="1198975052R7" style={{ height: "120px" }} class="row-headers-background">
                                <div class="row-header-wrapper" style={{ lineHeight: "120px" }}>8</div>
                            </th>
                            <td class="s1" colspan="3"><span style={{ fontSize: "18px", fontFamily: "Arial" }}>Observações:<br /></span><span
                                style={{ fontSize: "12px", fontFamily: "Arial" }}>1 - Deve ser disponibilizada cópia da Ata de Reunião para os
                participantes e envolvidos;<br /></span><span style={{ fontSize: "12px", fontFamily: "Arial" }}>2 – O campo PRAZO
                                define as datas de entrega das solicitações por parte dos responsáveis definidos no campo
                RESPONSÁVEL.</span></td>
                            <td class="s2"></td>
                        </tr>
                        <tr style={{ height: "25px" }}>
                            <th id="1198975052R8" style={{ height: "25px" }} class="row-headers-background">
                                <div class="row-header-wrapper" style={{ lineHeight: "25px" }}>9</div>
                            </th>
                            <td class="s5"></td>
                            <td class="s5"></td>
                            <td class="s5"></td>
                            <td class="s6"></td>
                        </tr>
                        <tr style={{ height: "55px" }}>
                            <th id="1198975052R9" style={{ height: "55px" }} class="row-headers-background">
                                <div class="row-header-wrapper" style={{ lineHeight: "55px" }}>10</div>
                            </th>
                            <td class="s10" colspan="3"><span style={{ fontSize: "18px", fontFamily: "Arial" }}>ID ASSUNTO RESPONSÁVEL PRAZO</span>
                            </td>
                            <td class="s8"></td>
                        </tr>
                        <tr style={{ height: "105px" }}>
                            <th id="1198975052R10" style={{ height: "105px" }} class="row-headers-background">
                                <div class="row-header-wrapper" style={{ lineHeight: "105px" }}>11</div>
                            </th>
                            {
                                assuntos.map((assuntos) => (
                                    <td class="s2" colspan="4">
                                        <span style={{ fontSize: "18px", fontFamily: "Arial" }}>{assuntos.id}</span><span
                                            style={{ fontSize: "18px", fontFamily: "Arial" }}>{assuntos.assunto} {assuntos.responsavel} {assuntos.prazo}<br /></span>
                                    </td>
                                ))
                            }
                        </tr>
                    </tbody>
                </table>

            </div>
        </div>
    )
}