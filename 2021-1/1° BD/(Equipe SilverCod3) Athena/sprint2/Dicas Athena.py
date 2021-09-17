import sqlite3

banco = sqlite3.connect('dicas_athena.db')

cursor = banco.cursor()

# CÓDIGO PARA CRIAÇÃO DA TABELA: cursor.execute("CREATE TABLE dicas (dicas text)")
 
# CÓDIGO PADRÃO PARA INSERÇÃO DE DADOS NA TABELA: cursor.execute("INSERT INTO dicas VALUES ('')")

#cursor.execute("INSERT INTO dicas VALUES ('Defina metas e depois, divida essas metas em elementos menores. Em vez de pensar em estudar 10 capítulos de uma vez, leia 2 por dia, por exemplo.')")
#cursor.execute("INSERT INTO dicas VALUES ('Crie objetivos diários, semanais e mensais. É um jeito de acompanhar seu progresso e de ver o que ainda precisa de atenção extra.')")
#cursor.execute("INSERT INTO dicas VALUES ('Escolha um bom lugar de estudos. Selecionar uma área desconfortável ou improvisada demais vai comprometer o seu desempenho. O ideal é escolher um lugar tranquilo, com boa iluminação e boa temperatura.')")
#cursor.execute("INSERT INTO dicas VALUES ('Faça com que o espaço esteja sempre arrumado para não causar distrações. Após finalizar um dia de estudo, deixe o ambiente pronto para o seguinte. Assim, facilita manter a organização.')")
#cursor.execute("INSERT INTO dicas VALUES ('Um modo de manter a sua motivação no alto é se recompensar por cumprir metas. Pode ser bem simples: um chocolate após o estudo de um capítulo ou um episódio da sua série favorita são boas recompensas.')")
#cursor.execute("INSERT INTO dicas VALUES ('O ideal é se desconectar de redes sociais pra evitar ter a atenção desfocada dos estudos. Se for possível, deixe o seu celular no silencioso e em outro cômodo para ver como faz a diferença.')")
#cursor.execute("INSERT INTO dicas VALUES ('Mais relevante do que conseguir “dar conta” das matérias é o seu bem-estar. Então, respeite os limites do seu corpo e mente. É essencial fazer algumas pausas ao longo do estudo.')")
#cursor.execute("INSERT INTO dicas VALUES ('Para evitar o tédio nos estudos, intercale as tarefas. Experimente estudar vários assuntos por dia — é ainda melhor se estiverem conectados. Tente também misturar leitura, exercícios e revisão.')")
#cursor.execute("INSERT INTO dicas VALUES ('Muitas pessoas precisam de tratamento psicológico para lidar com a pressão e a ansiedade das provas e isso não é motivo de vergonha. Não hesite em procurar um profissional se necessário.')")
#cursor.execute("INSERT INTO dicas VALUES ('Após alguns minutos de leitura, pare um pouco e tente lembrar e dizer, na mente ou em voz alta, quais são as ideias centrais até aquele ponto. Isso pode evitar uma leitura maçante.')")
#cursor.execute("INSERT INTO dicas VALUES ('Ter um bom desempenho acadêmico não tem nada a ver com talento inato: trata-se de determinação. Não diga \"Eu odeio estudar\", e sim \"Eu vou estudar até ficar mais habilidoso\".')")
#cursor.execute("INSERT INTO dicas VALUES ('Deixe sempre um tempo livre para seu descanso, ou para poder encaixar alguma outra atividade. Sempre bom ter um horário mais flexível, para possíveis imprevistos. ')")
#cursor.execute("INSERT INTO dicas VALUES ('Para melhorar a fixação do conteúdo, tente fazer anotações, marcar observações que irão te ajudar a lembrar, e por que não fazer um desenho ou até mesmo um esquema utilizando palavras-chave.')")
#cursor.execute("INSERT INTO dicas VALUES ('Estude primeiro as matérias que possui mais dificuldade, com a mente mais descansada, você terá mais concentração e tempo para esclarecer as dúvidas que surgirem no decorrer do estudo.')")
#cursor.execute("INSERT INTO dicas VALUES ('Evite estudar muito a matéria do seu teste na noite anterior, isso ajuda a diminuir sua ansiedade, repasse somente os pontos principais e procure ter uma boa noite de sono. Repouso é fundamental.')")
#cursor.execute("INSERT INTO dicas VALUES ('Se gosta de ouvir música durante o estudo, cuidado com o volume, para que não atrapalhe sua concentração. Opte por canções em idiomas que não conhece ou instrumentais, para evitar de cantar junto..')")
#cursor.execute("INSERT INTO dicas VALUES ('Pratique a leitura, isso irá te auxiliar a desenvolver sua interpretação. Ela será essencial para resolução de suas atividades.')")
#cursor.execute("INSERT INTO dicas VALUES ('Faça perguntas para você mesmo a respeito do conteúdo, isso te ajudará a focar no conteúdo. Saber o que, por que, quando, como, onde e quem, são perguntas que te ajudam a memorizar o tema.')")
#cursor.execute("INSERT INTO dicas VALUES ('Para aquela matéria muito difícil, busque um grupo de estudos com seus colegas, ou até mesmo grupos em redes sociais ou sites especializados no tema.')")
#cursor.execute("INSERT INTO dicas VALUES ('Não esqueça do seu descanso, uma mente cansada não rende. Busque tirar um tempo com atividades que goste, para que seu cérebro possa descansar, e ter um melhor rendimento.')")
#cursor.execute("INSERT INTO dicas VALUES ('Tente rever o conteúdo de uma aula ou novo conteúdo dentro de 24hs, estudos dizem que essa prática auxiliar absorver até 80% do conteúdo visto.')")
#cursor.execute("INSERT INTO dicas VALUES ('Revisar o conteúdo, ou até mesmo estudar um pouco antes de dormir, pode auxiliar seu cérebro a reter informações. Esse momento é quando se inicia o processo de consolidação da memória.')")
#cursor.execute("INSERT INTO dicas VALUES ('Uma das melhores formas de aprender é ensinando, sempre que possível busque ensinar a um colega o que aprendeu, assim seu conhecimento será mais facilmente consolidado.')")
#cursor.execute("INSERT INTO dicas VALUES ('Saia da sua zona de conforto, ficar estudando somente o conteúdo que já domina não irá de auxiliar. Busque a matéria que tem dificuldade, e tente sempre explorar diversas formas de estuda-la..')")
#cursor.execute("INSERT INTO dicas VALUES ('Para evitar o tédio, busque estudar de formas difrentes, leia o conteúdo, faça exercícios ou até mesmo uma revisão. ')")

#banco.commit()

#APAGAR DADOS:

# try:
#     banco = sqlite3.connect('dicas_athena.db')
#
#     cursor = banco.cursor()
#
#     cursor.execute("DELETE from dicas WHERE dicas = 'INSIRA AQUI O DADO A SER APAGADO'")
#
#     banco.commit()
#     banco.close()
#     print('Os dados foram deletados com sucesso.')
#
# except sqlite3.Error as erro:
#     print('Houve um erro ao excluir os dados solicitados: ', erro)

