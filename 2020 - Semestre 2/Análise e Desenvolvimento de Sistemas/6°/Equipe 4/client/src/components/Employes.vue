<template>
<div>
    <div class="row">
        <div class="col s12">
            <div class="card blue-grey darken-1 pop">
                <div class="card-content white-text">
                    <span class="card-title" style="padding-block: 5px"><i class="material-icons">group</i> Funcionários</span>
                    <div class="row blue-grey">
                        <div class="container">
                            <form class="col s12 center-align">
                                <div class="row">
                                    <div class="input-field col s12">
                                        <i class="material-icons prefix">search</i>
                                        <textarea id="icon_prefix2" class="materialize-textarea"></textarea>
                                        <label for="icon_prefix2" class="white-text">Pesquisar</label>
                                    </div>
                                    <p class="col s6">
                                        <label>
                                            <input class="red" type="checkbox" />
                                            <span class="white-text">Diretores</span>
                                        </label>
                                    </p>
                                    <p class="col s6">
                                        <label>
                                            <input type="checkbox" />
                                            <span class="white-text">Atendentes</span>
                                        </label>
                                    </p>
                                </div>
                            </form>
                        </div>
                        <div>
                            <div v-for="(user, key) in usuarios" v-bind:key="user.id" v-bind:id="key">
                                <div v-if="usuario.id != user.id" class="col s12 m3 black-text pop hoverable" style="cursor: pointer">
                                    <div class="card horizontal modal-trigger" v-on:click="
                        () => {
                          this.selectedUser = user;
                        }
                      " href="#modal_usuario">
                                        <div class="card-image">
                                            <img src="../assets/profile.png" style="height: 120px; width: 100px" />
                                        </div>
                                        <div class="card-stacked">
                                            <div class="card-content center-align">
                                                <p>{{ user.nome }}</p>
                                                <br />
                                                <p>Diretor</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div id="modal_usuario" class="modal">
        <div class="modal-content center-align">
            <div class="col s12 m8 offset-m2 l6 offset-l3">
                <div class="grey lighten-5">
                    <div class="row ">
                        <div class="col s12">
                            <img src="../assets/profile.png" alt="" class="circle responsive-img" />
                            <!-- notice the "circle" class -->
                        </div>
                        <div class="col s12" style="padding:15px; overflow-y:hidden !important">
                            <span class="black-text" style="font-size: 1.5em"> Fabiola </span>
                            <br />
                            <span class="black-text"> Diretor </span>
                        </div>
                        <div class="col s12">
                            <a class="btn-small blue" style="margin-bottom: 5px">Enviar Mensagem</a>
                            <br />
                            <a href="#modal_atividade" class="btn-small modal-trigger orange">Agendar Atividade</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div id="modal_atividade" class="modal" style="height: 400px">
        <div class="modal-content">
            <h4>Atividade</h4>
            <hr />
            <div class="row">
                <form class="col s12">
                    <div class="row">
                        <div class="input-field col s6">
                            <i class="material-icons prefix">title</i>
                            <input id="atividade_titulo" type="text" data-length="10" />
                            <label for="input_text">Título</label>
                        </div>
                        <div class="input-field col s6">
                            <i class="material-icons prefix">date_range</i>
                            <input id="data_agendamento" type="text" class="datepicker" />
                            <label for="icon_prefix2">Data</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">mode_edit</i>
                            <textarea style="
                    border-bottom: 1px solid #66bb6a;
                    box-shadow: 0 1px 0 0 #66bb6a;
                  " id="atividade_conteudo" class="materialize-textarea" data-length="120"></textarea>
                            <label for="textarea2">Conteúdo</label>
                        </div>
                    </div>
                </form>
                <a class="btn green" v-on:click="postAtividade()">Agendar Atividade</a>
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

let usuarios;
async function getUsuarios() {
    usuarios = await axios.get(`http://localhost:8081/spring-app/usuario/`, {
        headers: {
            "Access-Control-Allow-Origin": "*",
        },
    });
    usuarios = usuarios.data;
    return usuarios;
}

async function postAtividade() {
    let dataDisparo = new Date();
    dataDisparo = `${dataDisparo.getFullYear()}-${dataDisparo.getMonth()+1}-${dataDisparo.getDate()}`;
    let dataAgendada = document.getElementById('data_agendamento').value;
    dataAgendada = `${dataAgendada.slice(6)}-${dataAgendada.slice(3,5)}-${dataAgendada.slice(0,2)}`;

    await axios
        .post(
            "http://localhost:8081/spring-app/atv/", {
                titulo: document.getElementById("atividade_titulo").value,
                conteudo: document.getElementById("atividade_conteudo").value,
                nomeRemetente: usuario.nome,
                nomeDestinatario: this.selectedUser.nome,
                dataDisparo,
                dataAgendada,
                status: "1"
            }, {
                headers: {
                    "Access-Control-Allow-Origin": "*"
                }
            }
        )
        .then(() => {
            document.getElementById("atividade_titulo").value = "";
            document.getElementById("atividade_conteudo").value = "";
            document.getElementById('data_agendamento').value = "";
            M.toast({
                html: '<p class="green-text">Atividade agendada com sucesso!</p>',
            });
        });
}
let selectedUser;

export default {
    name: "Employes",
    props: {
        usuario: Object,
    },
    data() {
        return {
            usuarios,
            selectedUser,
        };
    },
    mounted() {
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
        M.Datepicker.init(document.querySelectorAll('.datepicker'), calendar_options);
        M.Modal.init(document.querySelectorAll(".modal"));
    },
    methods: {
        getUsuarios,
        postAtividade,
    },
    beforeMount: async function () {
        this.usuarios = await this.getUsuarios();
        console.log(this.usuarios);
    },
};
</script>

<style>
.datepicker-date-display {
    background-color: #66bb6a;
}

.datepicker-cancel {
    color: red;
}

.datepicker-done {
    color: #66bb6a;
}

.datepicker-table td.is-selected {
    background-color: #66bb6a;
}

.modal .datepicker-modal {
    width: 65%;
}
</style>
