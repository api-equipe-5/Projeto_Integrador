export interface tarefa {
  id: string;
  status: string;
  horas: any;
  id_usuario: string;
  dataInicio: string;
  id_projeto?: string;
  concluido: boolean;
  descricao: string;
  projetoNome?: string;
}
