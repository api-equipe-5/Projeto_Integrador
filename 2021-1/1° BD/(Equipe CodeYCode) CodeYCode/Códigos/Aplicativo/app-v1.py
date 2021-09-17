#Bibliotecas demandadas pelo programa
import func



# início do programa
func.sintese_voz("Olá, eu sou Bet, sua assistente virtual!")
func.lembrete_jogo()
data_ontem = func.data_ontem()
func.limpa_agenda_automaticamente(data_ontem)
aguardando_comando = True

while aguardando_comando:
    comando_principal = func.ouvir_microfone()
    if func.encontrar_comando('Beth', comando_principal):
        func.sintese_voz('Estou aqui!')
        #loop para ouvir continuamente
        ouvindo = True
        while ouvindo:
                                                #solicita que o usuária diga algo
            func.sintese_voz('Dê um comando!')
            frase = func.ouvir_microfone()                        #aciona a função ouvir_microfone() e armazena em uma variável o que foi retornado da função
            
            #condição para realizar a função pesquisa_web
            if func.encontrar_comando('pesquisa', frase):         
                func.sintese_voz("O que deseja pesquisar? ")
                termo_busca = func.ouvir_microfone()  # armazena na variável busca o que foi retornado da função ouvir_microfone
                pesquisando = True
                while pesquisando:
                    if termo_busca == 'Não entendi!':
                        func.sintese_voz('Não entendi, tente novamente!')
                        pesquisando = True
                    else:
                        i = 0
                        func.sintese_voz(f'Encontrei resultados para: {termo_busca}')
                        func.abrir_site(func.pesquisa_web(termo_busca)[i])
                        explorando = True
                        while explorando:
                            func.sintese_voz(f'Deseja visualizar outros resultados para {termo_busca}?')
                            resposta = func.ouvir_microfone()
                            i += 1
                            if func.encontrar_comando('sim', resposta):
                                func.abrir_site(func.pesquisa_web(termo_busca)[i])
                                explorando = True
                            elif func.encontrar_comando('não', resposta):
                                explorando = False
                                pesquisando = False
                            else:
                                func.sintese_voz('Não entendi, tente novamente!')
                                abrindo_sites = True
                ouvindo= True      
           
            #Agenda
            elif func.encontrar_comando('agenda', frase):
                usando_agenda = True
                func.sintese_voz("Aqui está sua agenda completa de jogos.")
                func.exibir_agenda()
                while usando_agenda:
                    func.sintese_voz("O que deseja realizar com a agenda?")
                    termo_busca = func.ouvir_microfone()
                    if func.encontrar_comando('adicionar', termo_busca):
                        inserindo = True
                        while inserindo:
                            inserindo_dia = True
                            inserindo_mes = True
                            inserindo_ano = True
                            inserindo_horario = True
                            inserindo_time1 = True
                            inserindo_time2 = True
                            salvando = True
                            while inserindo_dia:
                                func.sintese_voz("Que dia acontecerá o jogo?")
                                dia_falado = func.ouvir_microfone()
                                if func.consulta_dia(dia_falado):
                                    dia = dia_falado
                                    func.sintese_voz('Dia armazenado!')
                                    inserindo_dia = False
                                else:
                                    func.sintese_voz('Poderia repetir, eu não entendi!')
                                    inserindo_dia = True
                            while inserindo_mes:
                                func.sintese_voz("Em que mês acontecerá o jogo?")
                                mes_falado = func.ouvir_microfone()
                                if func.consulta_meses(mes_falado.lower()):
                                    mes = mes_falado.lower()
                                    func.sintese_voz('Mês armazenado!')
                                    inserindo_mes = False
                                else:
                                    func.sintese_voz('Poderia repetir, eu não entendi!')
                                    inserindo_mes = True
                            while inserindo_ano:
                                func.sintese_voz("Em que ano acontecerá o jogo?")
                                ano_falado = func.ouvir_microfone()
                                if func.consulta_ano(ano_falado):
                                    ano = ano_falado
                                    func.sintese_voz('Ano armazenado!')
                                    inserindo_ano = False
                                else:
                                    func.sintese_voz('Poderia repetir, eu não entendi!')
                                    inserindo_ano = True
                            data_inserida = func.gerar_data(dia, mes, ano)                     
                            while inserindo_horario:
                                func.sintese_voz("Qual o horario do jogo? ")
                                horario_falado = func.ouvir_microfone()
                                if horario_falado != 'Não entendi!':
                                    horario = horario_falado
                                    func.sintese_voz('Horário armazenado!')
                                    inserindo_horario = False
                                else:
                                    sintese_voz= ('Poderia repetir, eu não entendi!')
                                    inserindo_horario = True
                            while inserindo_time1:
                                func.sintese_voz('Qual o nome do primeiro time?')
                                time_falado = func.ouvir_microfone()
                                if func.consulta_time(time_falado):
                                    time_1 = time_falado
                                    func.sintese_voz('Time armazenado!')
                                    inserindo_time1 = False
                                else:
                                    func.sintese_voz('Poderia repetir, eu não entendi!')
                                    inserindo_time1 = True
                            while inserindo_time2:
                                func.sintese_voz('Qual o nome do segundo time?')
                                time_falado = func.ouvir_microfone()
                                if func.consulta_time(time_falado):
                                    time_2 = time_falado
                                    func.sintese_voz('Time armazenado!')
                                    inserindo_time2 = False
                                else:
                                    func.sintese_voz= ('Poderia repetir, eu não entendi!')
                                    inserindo_time2 = True

                            while salvando:   
                                func.sintese_voz(f'Você deseja inserir o jogo entre {time_1} e {time_2} que acontece no dia {data_inserida} às {horario}, na sua agenda? ')
                                resposta = func.ouvir_microfone()
                                if(func.encontrar_comando('sim', resposta)):
                                    func.inserir_na_agenda(time_1, time_2, data_inserida, horario)
                                    func.sintese_voz('Jogo Salvo na sua agenda!')
                                    salvando = False
                                elif(func.encontrar_comando('não', resposta)):
                                    func.sintese_voz("Jogo descartado!")
                                    salvando = False
                                else:
                                    func.sintese_voz("Não entendi, tente novamente!")
                                    salvando = True
                            inserindo = False
                            usando_agenda = False
                    
                    elif func.encontrar_comando('atualizar', termo_busca):
                        func.sintese_voz('Por favor, quais os dados do jogo que deseja atualizar?')
                        atualizando = True
                        while atualizando:
                            inserindo_dia = True
                            inserindo_mes = True
                            inserindo_ano = True
                            inserindo_horario = True
                            inserindo_time1 = True
                            inserindo_time2 = True
                            salvando = True
                            while inserindo_time1:
                                func.sintese_voz('Qual o nome do primeiro time?')
                                time_falado = func.ouvir_microfone()
                                if func.consulta_time(time_falado):
                                    time_1 = time_falado
                                    func.sintese_voz('Time armazenado!')
                                    inserindo_time1 = False
                                else:
                                    func.sintese_voz('Poderia repetir, eu não entendi!')
                                    inserindo_time1 = True
                            while inserindo_time2:
                                func.sintese_voz('Qual o nome do segundo time?')
                                time_falado = func.ouvir_microfone()
                                if func.consulta_time(time_falado):
                                    time_2 = time_falado
                                    func.sintese_voz('Time armazenado!')
                                    inserindo_time2 = False
                                else:
                                    func.sintese_voz= ('Poderia repetir, eu não entendi!')
                                    inserindo_time2 = True
                            while inserindo_dia:
                                func.sintese_voz("Que o novo dia em que acontecerá o jogo?")
                                dia_falado = func.ouvir_microfone()
                                if func.consulta_dia(dia_falado):
                                    dia = dia_falado
                                    func.sintese_voz('Dia armazenado!')
                                    inserindo_dia = False
                                else:
                                    func.sintese_voz('Poderia repetir, eu não entendi!')
                                    inserindo_dia = True
                            while inserindo_mes:
                                func.sintese_voz("Em que mês acontecerá o jogo?")
                                mes_falado = func.ouvir_microfone()
                                if func.consulta_meses(mes_falado.lower()):
                                    mes = mes_falado.lower()
                                    func.sintese_voz('Mês armazenado!')
                                    inserindo_mes = False
                                else:
                                    func.sintese_voz('Poderia repetir, eu não entendi!')
                                    inserindo_mes = True
                            while inserindo_ano:
                                func.sintese_voz("Em que ano acontecerá o jogo?")
                                ano_falado = func.ouvir_microfone()
                                if func.consulta_ano(ano_falado):
                                    ano = ano_falado
                                    func.sintese_voz('Ano armazenado!')
                                    inserindo_ano = False
                                else:
                                    func.sintese_voz('Poderia repetir, eu não entendi!')
                                    inserindo_ano = True
                            data_inserida = func.gerar_data(dia, mes, ano)                     
                            while inserindo_horario:
                                func.sintese_voz("Qual o horario do jogo? ")
                                horario_falado = func.ouvir_microfone()
                                if horario_falado != 'Não entendi!':
                                    horario = horario_falado
                                    func.sintese_voz('Horário armazenado!')
                                    inserindo_horario = False
                                else:
                                    sintese_voz= ('Poderia repetir, eu não entendi!')
                                    inserindo_horario = True
                            while salvando:   
                                func.sintese_voz(f'Você deseja atualizar os dados do jogo entre {time_1} e {time_2} para: dia {data_inserida} às {horario}?')
                                resposta = func.ouvir_microfone()
                                if(func.encontrar_comando('sim', resposta)):
                                    func.atualizar_na_agenda(time_1, time_2, data_inserida, horario)
                                    func.sintese_voz('Dados do Jogo atualizados!')
                                    salvando = False
                                elif(func.encontrar_comando('não', resposta)):
                                    func.sintese_voz("Alteração descartada!")
                                    salvando = False
                                else:
                                    func.sintese_voz("Não entendi, tente novamente!")
                                    salvando = True
                            atualizando = False
                            usando_agenda = False

                    elif func.encontrar_comando('apagar', termo_busca):
                        func.sintese_voz("Diga os nomes dos clubes do jogo que deseja apagar na sua agenda!")
                        deletando = True
                        while deletando:
                            inserindo_time1 = True
                            inserindo_time2 = True
                            apagando = True
                            while inserindo_time1:
                                func.sintese_voz('Qual o nome do primeiro time?')
                                time_falado = func.ouvir_microfone()
                                if func.consulta_time(time_falado):
                                    del_time_1 = time_falado
                                    func.sintese_voz('Time armazenado!')
                                    inserindo_time1 = False
                                else:
                                    func.sintese_voz('Poderia repetir, eu não entendi!')
                                    inserindo_time1 = True
                            while inserindo_time2:
                                func.sintese_voz('Qual o nome do segundo time?')
                                time_falado = func.ouvir_microfone()
                                if func.consulta_time(time_falado):
                                    del_time_2 = time_falado
                                    func.sintese_voz('Time armazenado!')
                                    inserindo_time2 = False
                                else:
                                    func.sintese_voz= ('Poderia repetir, eu não entendi!')
                                    inserindo_time2 = True
                            while apagando:   
                                func.sintese_voz(f'Deseja realmente apagar o jogo entre {del_time_1} e {del_time_2} da sua agenda?')
                                resposta = func.ouvir_microfone()
                                if(func.encontrar_comando('sim', resposta)):
                                    func.deletar_na_agenda(del_time_1, del_time_2)
                                    func.sintese_voz('Jogo apagado da sua agenda!')
                                    apagando = False
                                elif(func.encontrar_comando('não', resposta)):
                                    func.sintese_voz("Operação cancelada!")
                                    apagando = False
                                else:
                                    func.sintese_voz("Não entendi, tente novamente!")
                                    apagando = True
                            deletando = False
                            usando_agenda = False

                    elif func.encontrar_comando('nada', termo_busca):
                        usando_agenda = False
                    else:
                        func.sintese_voz("Não entendi, tente novamente!")
                        usando_agenda = True
                ouvindo = True

            #busca por notícias(globo esporte)
            elif func.encontrar_comando('notícia', frase):
                busca_noticias = True
                while busca_noticias:
                    func.sintese_voz('Deseja receber notícias sobre qual time?')
                    time = func.ouvir_microfone()
                        
                    if func.consulta_time(time):
                        func.sintese_voz(f'Você escolheu: {time}')
                        site_noticias = f'https://globoesporte.globo.com/busca/?q={time}'
                        func.abrir_site(site_noticias)
                        busca_noticias = False
                    else:
                        func.sintese_voz('Não entendi qual o time você escolheu! Repita, por favor!')
                        busca_noticias = True
                ouvindo = True   

            #busca por vídeos(youtube)
            elif func.encontrar_comando('vídeo', frase):                   
                busca_videos = True
                while busca_videos:
                    func.sintese_voz('Deseja assistir vídeos sobre qual time?')
                    time = func.ouvir_microfone()
                    if func.consulta_time(time):
                        func.sintese_voz(f'Você escolheu: {time}')
                        site_videos = f'www.youtube.com/results?search_query={time}'
                        func.abrir_site(site_videos)
                        busca_videos = False
                    else:
                        func.sintese_voz('Não entendi qual o time você escolheu! Repita, por favor!')
                        busca_videos = True
                ouvindo = True

            #busca por memes (ole do brasil)
            elif func.encontrar_comando('meme', frase):
                busca_memes = True
                while busca_memes:
                    func.sintese_voz('Deseja visualizar memes sobre qual time?')
                    time = func.ouvir_microfone()
                    if func.consulta_time(time):
                        func.sintese_voz(f'Você escolheu: {time}')
                        site_memes = f'https://oledobrasil.com.br/?s={time}'
                        func.abrir_site(site_memes)
                        busca_memes = False
                    else:
                        func.sintese_voz('Não entendi qual o time você escolheu! Repita, por favor!')
                        busca_memes = True
                ouvindo = True

            #imprime a tabela de jogos do dia atualizada
            elif func.encontrar_comando('jogos de hoje', frase):
                func.sintese_voz('Estes são os jogos de hoje!')
                func.abrir_site('https://www.goal.com/br/not%C3%ADcias/programacao-partidas-futebol-tv-aberta-fechada-onde-assistir/1jf3cuk3yh5uz18j0s89y5od6w')
                explorando = True
                while explorando:
                    func.sintese_voz('Deseja acompanhar algum destes jogos?')
                    comando = func.ouvir_microfone()
                    if func.encontrar_comando('sim', comando):                   
                        abrindo = True
                        while abrindo:
                            func.sintese_voz('Qual destes jogos deseja acompanhar? Diga o nome de apenas um time!')
                            time = func.ouvir_microfone()
                            tabela_jogos = func.tabela_jogos_hoje()
                            comando = str(func.buscar_jogo_pagina(time, func.tabela_jogos_hoje()))
                            if comando != 'None':
                                func.abrir_site(f'https://globoesporte.globo.com/busca/?q={func.buscar_jogo_pagina(time, tabela_jogos)}')
                                func.sintese_voz('Aqui estão algumas informações sobre este jogo!')
                                abrindo = False
                                explorando = False
                            else:
                                func.sintese_voz('Poderia repetir, eu não entendi!')
                                abrindo = True 
                    elif func.encontrar_comando('não', comando):
                        func.sintese_voz('Ok!')
                        abrindo = False
                        explorando = False
                ouvindo = True
            
            #abre sites de apostas predefinidos
            elif func.encontrar_comando('aposta', frase):
                func.sintese_voz("Aqui está um site de apostas espostivas!")
                abrindo_site_apostas = True
                i = 0
                while abrindo_site_apostas:
                    func.abrir_site(func.pesquisa_web(func.lista_sites_apostas[i])[0])
                    explorando = True
                    while explorando:
                        func.sintese_voz('Deseja abrir outro site de apostas esportivas?')
                        resposta = func.ouvir_microfone()
                        i += 1
                        if func.encontrar_comando('sim', resposta):
                            func.abrir_site(func.pesquisa_web(func.lista_sites_apostas[i])[0])
                            explorando = True
                        elif func.encontrar_comando('não', resposta):
                            explorando = False
                            abrindo_site_apostas = False
                        else:
                            func.sintese_voz('Não entendi, tente novamente!')
                            abrindo_sites = True
                """ for titulo_site in func.lista_sites_apostas:
                    print(titulo_site)
                    abrir_site_aposta = True
                    while abrir_site_aposta:
                        func.sintese_voz("Deseja abrir algum destes sites?")
                        comando = func.ouvir_microfone()
                        if func.encontrar_comando('sim', comando):
                            func.sintese_voz("Qual destes sites deseja abrir?")
                            indice = func.ouvir_microfone()
                            for i in func.indices:
                                if func.encontrar_comando(i, indice):
                                    if i == 'primeiro':
                                        func.abrir_site(func.pesquisa_web(func.lista_sites_apostas[0])[0])
                                    elif i == 'segundo':
                                        func.abrir_site(func.pesquisa_web(func.lista_sites_apostas[1])[0])
                                    elif i == 'terceiro':
                                        func.abrir_site(func.pesquisa_web(func.lista_sites_apostas[2])[0])
                                    elif i == 'quarto':
                                        func.abrir_site(func.pesquisa_web(func.lista_sites_apostas[3])[0])
                                    abrir_site_aposta = False
                        elif func.encontrar_comando('não', comando):
                            abrir_site_aposta = False
                        else:
                            func.sintese_voz("Não entendi! Tente novamente, por favor!")
                            abrir_site_aposta = True """
                ouvindo = True

            #comando de voz que encerra o programa    
            elif func.encontrar_comando('obrigado', frase):       
                ouvindo = False

            #ouve e imprime o que foi dito indefinidamente até que algum comando seja entendido
            elif frase == 'Não entendi!':
                func.sintese_voz('Poderia repetir, eu não entendi!')
                ouvindo = True
            
        func.sintese_voz("Foi um prazer ajudá-lo!")
    elif func.encontrar_comando('parar', comando_principal):
        aguardando_comando = False
        func.sintese_voz("Foi um prazer ajudá-lo!")
func.sintese_voz('Até a próxima!')

