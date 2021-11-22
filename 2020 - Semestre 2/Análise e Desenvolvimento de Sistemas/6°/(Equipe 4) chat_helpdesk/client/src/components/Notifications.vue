<template>
<div class="row">
    <div class="col s12">
        <div class="card blue-grey darken-1 pop">
            <div class="card-content">
                <span class="card-title white-text" style="padding-block: 5px"><i class="material-icons white-text">notifications</i>
                    Atividades</span>
                <div class="row blue-grey darken-2">
                    <div class="input-field col s9 m5 l5 white-text">
                        <i class="material-icons prefix">search</i>
                        <input v-on:keyup.enter="filter_hub" id="search_title" type="text" class="validate white-text" />
                        <label for="icon_prefix">Pesquisar por titulo</label>
                    </div>
                    <a v-on:click="filter_hub()" class="col s2 m1 l1 btn-small green" style="margin-top:20px"><i class="material-icons">search</i></a>
                    <div class="col l6">
                        <div class="input-field col s6 m6 l6">
                            <i class="material-icons prefix white-text">date_range</i>
                            <input id="date_initial" type="text" class="datepicker white-text" />
                            <label for="icon_prefix">Data Inicial</label>
                        </div>
                        <div class="input-field col s6 m6 l6">
                            <i class="material-icons prefix white-text">date_range</i>
                            <input id="date_final" type="text" class="datepicker white-text" />
                            <label for="icon_prefix">Data Final</label>
                        </div>
                        <a v-on:click="filter_hub()" class="col s12 green btn"><i class="material-icons left">search</i>Aplicar filtro de
                            data</a>
                    </div>
                    <div class="input-field col s12 m8 l8">
                        <p class="col s12 m3 l3">
                            <label>
                                <input type="checkbox" id="atv_avencer" v-on:click="filter_hub()" />
                                <span class="blue-text">À vencer</span>
                            </label>
                        </p>
                        <p class="col s12 m3 l3">
                            <label>
                                <input type="checkbox" id="atv_fechadas" v-on:click="filter_hub()" />
                                <span class="green-text">Concluidas</span>
                            </label>
                        </p>
                        <p class="col s12 m3 l3">
                            <label>
                                <input type="checkbox" id="atv_atrasadas" v-on:click="filter_hub()" />
                                <span class="red-text">Atrasadas</span>
                            </label>
                        </p>
                    </div>
                </div>
                <div class="row">
                    <div class="scrolable white-text">
                        <div v-if="atividadesFiltradas.length >= 1">
                            <div class="col s12 m6 l6 pop" style="cursor: pointer" v-for="(atividade, key) in atividadesFiltradas" v-bind:key="atividade.id" v-bind:id="key">
                                <div class="card-panel grey lighten-5 z-depth-1 hoverable" v-on:click="setModalContent(atividade, key)">
                                    <div class="row valign-wrapper">
                                        <div class="col s4 m3 l3 avatar">
                                            <i v-if="
                            atividade.status == 1 &&
                            dataConvert(atividade.dataLimite) > new Date()
                          " class="large material-icons circle blue">notifications</i>
                                            <i v-if="
                            atividade.status == 1 &&
                            dataConvert(atividade.dataLimite) < new Date()
                          " class="large material-icons circle red">notifications</i>
                                            <i v-if="atividade.status == 0" class="large material-icons circle green">notifications</i>
                                        </div>
                                        <div class="col s9">
                                            <span class="black-text truncate modal-trigger" href="#modal_atividade">
                                                <p>{{ atividade.titulo }}</p>
                                                <br />
                                                {{ atividade.conteudo }}
                                                <br />
                                                <p class="secondary-content" style="
                              color: #66bb6a;
                              padding: 10px;
                              font-weight: bold;
                            ">
                                                    Prazo:
                                                    {{
                              `${atividade.dataLimite
                                .split("T")[0]
                                .slice(8, 10)}/${atividade.dataLimite
                                .split("T")[0]
                                .slice(5, 7)}/${atividade.dataLimite
                                .split("T")[0]
                                .slice(0, 4)}`
                            }}
                                                </p>
                                            </span>

                                            <a v-if="
                            atividade.status == 1 &&
                            (dataConvert(atividade.dataLimite) < new Date() ||
                              dataConvert(atividade.dataLimite) > new Date())
                          " v-on:click="concluirAtividade(atividade.id, key)" class="btn col s10 green"><i class="material-icons left">check</i> Concluir</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div v-if="atividadesFiltradas.length == 0">Sem registros</div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div id="modal_atividade" class="modal" style="height: 400px">
        <div class="modal-content">
            <div class="row">
                <h4 class="col s12 center-align green-text text-lighten-1">
                    {{ atividadeSelectedTitulo }}
                </h4>
            </div>
            <div class="grey lighten-3 col s12 center-align">
                <blockquote>{{ atividadeSelectedTituloConteudo }}</blockquote>
            </div>
            <div class="grey lighten-3 col s12 left-align" style="margin-top: 5px">
                <p>
                    Disparada por: {{ atividadeSelectedRemetenteNome }}
                    {{ atividadeSelectedDataDisparo }}
                </p>
                <p>Prazo de conclusão: {{ atividadeSelectedDataAgendada }}</p>
                <p v-if="atividadeSelectedStatus == 0">
                    Concluida no dia:
                    {{ this.dateFormat(atividadeSelectedDataConclusao) }}
                </p>
            </div>

            <div class="modal-footer center-align">
                <a style="margin-right: 10px" class="modal-close red btn center-align"><i class="material-icons left">close</i>Fechar
                </a>
                <a v-if="atividadeSelectedStatus == 1" class="modal-close green btn center-align" v-on:click="
              concluirAtividade(atividadeSelectedID, atividadeSelectedElementID)
            "><i class="material-icons left">check</i>Concluir Atividade
                </a>
            </div>
        </div>
    </div>
</div>
</template>

<script>
import axios from "axios";
import M from "materialize-css";

let usuario;
if (sessionStorage.usuario) {
    usuario = JSON.parse(sessionStorage.usuario);
}

let atividades = [];
let atividadesFiltradas = [];

let atividadeSelectedElementID;
let atividadeSelectedID;
let atividadeSelectedStatus;
let atividadeSelectedTitulo;
let atividadeSelectedTituloConteudo;
let atividadeSelectedDataDisparo;
let atividadeSelectedDataAgendada;
let atividadeSelectedDataConclusao;
let atividadeSelectedRemetenteNome;

function dateFormat(date) {
    console.log(date);
    return `${date.slice(8, 10)}/${date.slice(5, 7)}/${date.slice(0, 4)}`;
}

function setModalContent(atividade, key) {
    this.atividadeSelectedElementID = key;
    this.atividadeSelectedID = atividade.id;
    this.atividadeSelectedStatus = atividade.status;
    this.atividadeSelectedTitulo = atividade.titulo;
    this.atividadeSelectedTituloConteudo = atividade.conteudo;
    this.atividadeSelectedDataConclusao = atividade.dataConclusao;
    this.atividadeSelectedDataDisparo = `${atividade.dataDisparo
    .split("T")[0]
    .slice(8, 10)}/${atividade.dataDisparo
    .split("T")[0]
    .slice(5, 7)}/${atividade.dataDisparo.split("T")[0].slice(0, 4)}`;
    this.atividadeSelectedDataAgendada = `${atividade.dataLimite
    .split("T")[0]
    .slice(8, 10)}/${atividade.dataLimite
    .split("T")[0]
    .slice(5, 7)}/${atividade.dataLimite.split("T")[0].slice(0, 4)}`;
    this.atividadeSelectedRemetenteNome = atividade.atvRemetente.nome;
    return;
}
async function getAtividades() {
    atividades = await axios.get(
        `http://localhost:8081/spring-app/usuario/buscarAtividadesRecebidas?nome=${usuario.nome}`, {
            headers: {
                "Access-Control-Allow-Origin": "*",
            },
        }
    );
    atividades = atividades.data;
    return atividades;
}

async function deleteAtividade(id, key) {
    console.log(id);
    await axios
        .post(
            "http://localhost:8081/spring-app/atv/deletar", {
                id,
            }, {
                headers: {
                    "Access-Control-Allow-Origin": "*",
                },
            }
        )
        .then(() => {
            document.getElementById(key).classList.add("popOut");
            setTimeout(() => {
                this.atvi.splice(key, 1);
            }, 500);
        });

    return;
}

async function concluirAtividade(id, key) {
    let dataConclusao = new Date();
    dataConclusao = `${dataConclusao.getFullYear()}-${
    dataConclusao.getMonth() + 1
  }-${dataConclusao.getDate()}`;
    await axios
        .post(
            "http://localhost:8081/spring-app/atv/concluirAtividade", {
                id,
                status: 0,
                dataConclusao,
            }, {
                headers: {
                    "Access-Control-Allow-Origin": "*",
                },
            }
        )
        .then(() => {
            document.getElementById(key).classList.add("popOut");
            setTimeout(() => {
                this.atividadesFiltradas.splice(key, 1);
            }, 500);
        });

    return;
}
export default {
    name: "Notifications",
    data() {
        return {
            atividades,
            atividadesFiltradas,
            atividadeSelectedElementID,
            atividadeSelectedID,
            atividadeSelectedStatus,
            atividadeSelectedTitulo,
            atividadeSelectedTituloConteudo,
            atividadeSelectedDataDisparo,
            atividadeSelectedDataConclusao,
            atividadeSelectedDataAgendada,
            atividadeSelectedRemetenteNome,
        };
    },
    props: {
        usuario: Object,
    },
    methods: {
        getAtividades,
        deleteAtividade,
        concluirAtividade,
        setModalContent,
        buscarAtividadesPorTitulo,
        buscarAtividadesPorStatus,
        dataConvert,
        dateFormat,
        buscarAtividadesPorData,
        filter_hub,
    },
    mounted() {
        M.Modal.init(document.querySelectorAll(".modal"));
    },
    beforeMount: async function () {
        this.atividades = await this.getAtividades();
        this.atividadesFiltradas = this.atividades;

        let calendar_options = {
            format: "dd/mm/yyyy",
            i18n: {
                months: [
                    "Janeiro",
                    "Fevereiro",
                    "Março",
                    "Abril",
                    "Maio",
                    "Junho",
                    "Julho",
                    "Agosto",
                    "Setembro",
                    "Outubro",
                    "Novembro",
                    "Dezembro",
                ],
                monthsShort: [
                    "Jan",
                    "Fev",
                    "Mar",
                    "Abr",
                    "Mai",
                    "Jun",
                    "Jul",
                    "Ago",
                    "Set",
                    "Out",
                    "Nov",
                    "Dez",
                ],
                weekdays: [
                    "Sábado",
                    "Segunda",
                    "Terça",
                    "Quarta",
                    "Quinta",
                    "Sexta",
                    "Domingo",
                ],
                weekdaysShort: ["Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"],
                weekdaysAbbrev: ["D", "S", "T", "Q", "Q", "S", "S"],
                cancel: "Fechar",
                clear: "Limpar",
                done: "Confirmar",
            },
        };
        M.Datepicker.init(
            document.querySelectorAll(".datepicker"),
            calendar_options
        );
        console.log(this.atividadesFiltradas);
    },
};

function filter_hub() {
    let abertas = document.getElementById("atv_avencer").checked;
    let fechadas = document.getElementById("atv_fechadas").checked;
    let atrasadas = document.getElementById("atv_atrasadas").checked;
    let searchInput = document.getElementById("search_title").value;
    let initialDate = document.getElementById("date_initial").value;
    let finalDate = document.getElementById("date_final").value;

    this.atividadesFiltradas = this.atividades;
    if (initialDate && initialDate != "" && finalDate && finalDate != "") {
        this.buscarAtividadesPorData();
    }

    if (abertas || fechadas || atrasadas) {
        this.buscarAtividadesPorStatus();
    }

    if (searchInput && searchInput != "") {
        this.buscarAtividadesPorTitulo();
    }
}

function buscarAtividadesPorTitulo() {
    let searchInput = document.getElementById("search_title").value;

    let atividadesFiltradasTitulo = [];
    if (searchInput && searchInput != "") {
        this.atividadesFiltradas.forEach((atividade) => {
            console.log(atividade);
            if (atividade.titulo.toLowerCase().includes(searchInput.toLowerCase())) {
                atividadesFiltradasTitulo.push(atividade);
            }
        });
        this.atividadesFiltradas = atividadesFiltradasTitulo;
        return;
    }
    return;
}

function buscarAtividadesPorStatus() {
    let abertas = document.getElementById("atv_avencer").checked;
    let fechadas = document.getElementById("atv_fechadas").checked;
    let atrasadas = document.getElementById("atv_atrasadas").checked;

    let atividadesFiltradasStatus = [];
    if (abertas || fechadas || atrasadas) {
        if (abertas) {
            this.atividadesFiltradas.forEach((atividade) => {
                if (
                    atividade.status == 1 &&
                    dataConvert(atividade.dataLimite) > new Date()
                ) {
                    atividadesFiltradasStatus.push(atividade);
                }
            });
        }

        if (fechadas) {
            this.atividadesFiltradas.forEach((atividade) => {
                if (atividade.status == 0) {
                    atividadesFiltradasStatus.push(atividade);
                }
            });
        }

        if (atrasadas) {
            this.atividadesFiltradas.forEach((atividade) => {
                if (
                    atividade.status == 1 &&
                    dataConvert(atividade.dataLimite) < new Date()
                ) {
                    atividadesFiltradasStatus.push(atividade);
                }
            });
            console.log(atividadesFiltradasStatus);
        }
        this.atividadesFiltradas = atividadesFiltradasStatus;
    }
}

function dataConvert(date) {
    let dataSplit;
    if (date.indexOf("-") != -1) {
        dataSplit = `${date.slice(8, 10)}/${date.slice(5, 7)}/${date.slice(0, 4)}`;
    } else {
        dataSplit = date;
    }
    dataSplit = dataSplit.split("/");
    let newDate = new Date(
        parseInt(dataSplit[2], 10),
        parseInt(dataSplit[1], 10) - 1,
        parseInt(dataSplit[0], 10)
    );
    return newDate;
}

function buscarAtividadesPorData() {
    let initialDate = document.getElementById("date_initial").value;
    let finalDate = document.getElementById("date_final").value;

    if (initialDate && initialDate != "" && finalDate && finalDate != "") {
        initialDate = dataConvert(initialDate);
        finalDate = dataConvert(finalDate);
        let objetosFiltrados = this.atividadesFiltradas.filter((atividade) => {
            console.log(dataConvert(atividade.dataLimite));
            return (
                dataConvert(atividade.dataLimite) >= initialDate &&
                dataConvert(atividade.dataLimite) <= finalDate
            );
        });
        console.log("filter asdasdas", objetosFiltrados);
        this.atividadesFiltradas = objetosFiltrados;
    }
}
</script>

<style>
blockquote {
    border-left: 5px solid #66bb6a;
}
</style>
