def horarios():
    semana = ["segunda", "terça", "quarta", "quinta", "sexta", "sabado", "domingo"]
    materias = []
    dias_semana = []
    horario_materia = []

    try:
        while True:
            semana_dia = (str(input('dia da semana: ')).strip().split()[0].lower())
            if semana_dia not in semana:
                print("Parece que você digitou algo invalido, tente novamente !")
                continue
            if semana_dia != "sabado" and semana_dia != "domingo":
                x = semana_dia + "-feira"
                dias_semana.append(x)
            else:
                dias_semana.append(semana_dia)
            resp = str(input(f'Gostaria de cadastrar um novo dia da semana ? '
                             f'[SIM/NAO] : ')).upper().strip()[0]
            if resp == "S":
                continue
            if resp == "N":
                break
        print(dias_semana)
    except ValueError:
        print('Valor digitado inválido, tente novamente !')
    for posi, c in enumerate(dias_semana):
        while True:
            try:
                materia = input(f'Qual matéria gostaria de cadastrar para "{dias_semana[posi]}" ?: ').strip().lower()
                materias.append(materia)
                resp = str(input(f'Gostaria de cadastrar uma nova matéria para "{dias_semana[posi]}" ?: '
                                 f'[SIM/NAO] : ')).upper().strip()[0]
                if resp == "S":
                    continue
                if resp == "N":
                    print(materias)
                    for pos, c in enumerate(materias):
                        horario_inicial = input(
                            f'Quando começa a aula da matéria: "{materias[pos]}" (hh:mm) ?: ').strip().replace(" ", ":")
                        horario_final = input(
                            f'Quando termina a aula da matéria: "{materias[pos]}" (hh:mm) ?: ').strip().replace(" ",
                                                                                                                ":")
                        horario_materia.append(f"{horario_inicial}-{horario_final}")
                        try:
                            with open("aulas.txt", "a") as arquivo:
                                arquivo.write(f'Dia: {dias_semana[posi]} '
                                              f'Aulas: {materias[pos]} = horario: {horario_materia[pos]} \n')
                        except Exception as error:
                            print('>> Arquivo não encontrado, tente novamente !')
                            print(error)
                    materias.clear()
            except Exception as error:
                print('>> Encontramos algum erro, por gentileza tente novamente')
                print(error)
            break
