import React, { useState, useEffect } from 'react';
import { 
StyleSheet,
Text,
ActivityIndicator,
ScrollView,
View,
Image,
TouchableHighlight, 
Button,
AsyncStorage,
} from 'react-native';
import Constants from "expo-constants";
import * as Permissions from "expo-permissions";
import * as ImagePicker from 'expo-image-picker';
 
import { TextInput } from 'react-native-paper';
import { CheckBox } from 'react-native-elements'

import api from '../../services/api';
import { Left } from 'native-base';
 
export default function Disease({navigation}) {

    const { animal } = navigation.state.params

    const optionsDog = [
        {
            'id': 1,
            'doenca': 'RAIVA CANINA: A raiva é transmitida por meio da mordida de um animal. Os sintomas incluem febre, dor de cabeça, salivação excessiva, espasmos musculares, paralisia e confusão mental. Não há tratamento específico para a raiva, depois que os sintomas aparecem, a doença é quase sempre fatal. Procure imediatamente um atendimento médico caso ocorrer alguma mordida ou suspeita. Prevenido com vacina.'
        },
        {
            'id': 2,
            'doenca': 'CINOMOSE: está entre uma das doenças de cachorros mais graves. Isso porque ela atinge principalmente os filhotes, antes de completarem um mês de vida, quando ainda não possuem um sistema imunológico muito resistente. Os principais sintomas são febre, perda de apetite, corrimental ocular e nasal, diarreia, vômito, tiques nervosos e paralisias. Prevenido com vacina.'
        },
        {
            'id': 3,
            'doenca': 'DOENÇA PERIODENTAL: atinge a maior parte dos cães por um simples motivo: não escovar os dentes. Com o tempo os dentes acabam apodrecendo e caindo, por isso os veterinários costumam recomendar a escovação desde filhote.'
        },
        {
            'id': 4,
            'doenca': 'PARVOVIROSE:  A “parvo” atinge apenas os cães e causa muito vômito e diarreia com sangue. O vírus atinge o intestino e a medula óssea, sendo em 80% dos casos fatais. Devido ao fácil contágio o animal é isolado após qualquer sintoma e se inicia uma reposição dos fluídos e vitaminas perdidas.  A cura depende da capacidade do organismo de lutar contra o vírus.'
        },
        {
            'id': 5,
            'doenca': 'CÂNCER: costuma atingir animais mais idosos, mas, assim como acontece com os humanos, isso não é uma regra. Os tumores podem atingir diferentes partes do corpo do cachorro, sendo os de mama e próstata um dos mais comuns. A prevenção pode ser feita com uma boa alimentação, ou nestes casos específicos a castração precoce é indicada.'
        },
        {
            'id': 6,
            'doenca': 'LEPTOSPIROSE: A leptospirose é uma doença transmitida através da urina de ratos contaminados, por isso é conhecida também como a “doença do rato”. Uma vez no organismo canino a bactéria terá ações diferentes em cada um. Os sintomas mais comuns são hematomas e machucados na boca e na pele, falta de apetite, vômito, diarreia e febre.'
        },
        {
            'id': 7,
            'doenca': 'HEPATITE INFECCIOSA CANINA: é uma das doenças de cachorros transmitadas por vírus e atinge o fígado. Os sintomas e a recuperação do cachorro irão depender do grau em que a doença se manifesta no organismo. Pode não apresentar sintomas, podendo sofrer com paralisias e convulsões ou pode morrer em poucos dias sem restar tempo para agir.'
        },
        {
            'id': 8,
            'doenca': 'SARNA:  é uma doença de pele causada por ácaros. Existem dois tipos diferentes de sarna, a sarna sarcótica e a sarna demodécica, sendo esta uma doença parasitária que se transmite muito facilmente, embora tenha tratamento. Em alguns casos graves, pode deixar marcas para o resto da vida do cachorro.'
        },
        {
            'id': 9,
            'doenca': 'TAXOPLASMOSE: É um parasita intracelular que acarreta, geralmente, um risco leve, excepto quando afeta o feto da fêmea. Pode ser identificado através de sintomas neuromusculares, respiratórios e gastrointestinais. A maioria dos casos aparece em cachorros com menos de um ano. Tem tratamento fácil.'
        },
        {
            'id': 10,
            'doenca': 'CORONAVÍRUS: É uma doença viral e infecciosa que afeta todo o tipo de cachorros, especialmente os que não foram vacinados. Pode ser detectado no momento em que se verifica diarreia abundante, vômitos e até perda de peso no cachorro. Não existe vacina para isso, será o veterinário quem neutraliza os sintomas que a doença provoca.'
        },
        {
            'id': 11,
            'doenca': 'HEPATITE: Afeta, principalmente, o fígado e pode ter diferentes causas, como a viral. O tratamento principal é baseado no alívio dos sintomas e, caso não se cure, pode tornar-se crônica e provocar insuficiência hepática.'
        },
        {
            'id': 12,
            'doenca': 'PARVOVÍRUS: Assim como quase todas as doenças víricas, o parvovírus não conta com um antídoto concreto, sendo que o tratamento se baseia em tentar aliviar os sintomas do animal, que incluem depressão, febre e desidratação.'
        },
        {
            'id': 13,
            'doenca': 'DISPLASIA DE QUADRIL: Desenvolve-se ao longo do tempo, a partir dos 4 ou 5 meses de idade embora, geralmente, só apareça em cachorros com idade avançada. Embora seja um problema hereditário e degenerativo, alguns fatores como o crescimento rápido, a alimentação em excesso ou o exercício físico podem agravar o problema.'
        },
        {
            'id': 14,
            'doenca': 'REUMATISMO: Afeta as articulações e a cartilagem das mesmas, sendo uma doença degenerativa. Os sintomas incluem rigidez, inflamação e dor. O veterinário pode prescrever glucosamina, condroitina e outros tratamentos que aliviam e melhoram a sua condição.'
        },
        {
            'id': 15,
            'doenca': 'EPILEPSIA: É uma descarga eletroquímica do cérebro que pode aparecer em qualquer momento. As crises repetem-se por, praticamente, toda a vida do cachorro doente. Os episódios podem ser controlados com medicação receitada pelo veterinário.'
        },
        {
            'id': 16,
            'doenca': 'PERIODONTITE: Afeta o periodonto (gengiva, tecido, osso e ligamentos) e é derivada da formação de tártaro e placa, o que torna possível a proliferação de bactérias. Pouco a pouco, essas bactérias invadem a cavidade onde se localiza a raiz do dente e acabam provocando infecções graves ou perda de dentes.'
        },
        {
            'id': 17,
            'doenca': 'PIOMETRIA: É uma infecção bacteriana que se caracteriza pelo aparecimento de pus dentro da cavidade do útero ou matriz. Hoje em dia, contamos com medicamentos que tornam possível estudar o problema antes da cirurgia.'
        },
        {
            'id': 18,
            'doenca': 'TORÇÃO GÁSTRICA: As causas que provocam a rotação do intestino são desconhecidas. Para evitar que o seu cachorro sofras uma torção gástrica, evite refeições grandes de uma só vez, água em excesso e comer antes ou depois do exercício.'
        },
        {
            'id': 19,
            'doenca': 'ALERGIAS CUTANEAS: Assim como as pessoas, os cachorros também podem sofrer de alergias. Deve ser cuidadoso e consultar o veterinário se observar que o seu cachorro é alérgico a alguma substância.'
        },
        {
            'id': 20,
            'doenca': 'DIABETES: O açúcar faz parte da lista de alimentos proibidos para o cachorro, não só por promover o aparecimento de cegueira como por também provocar diabetes. Consulte o seu veterinário para conhecer o tratamento que o seu cachorro necessita caso verifique sede excessiva, emagrecimento, cataratas, aumento de apetite e aumento na frequência urinária.'
        },
        {
            'id': 21,
            'doenca': 'CRIPTORQUIDIA: Consiste na descida incompleta de um ou dois testículos. Deve ser diagnosticada o mais cedo possível requer intervenção cirúrgica. Tem em alguns casos, origem hereditária.'
        },
        {
            'id': 22,
            'doenca': 'OTITE: É a inflamação do ouvido interno, médio ou externo. Pode ser provocada por alergias, bactérias, parasitas ou corpos estranhos. O veterinário poderá investigar a comichão, a vermelhidão ou infecção que o seu cachorro pode ter, oferecendo um tratamento de acordo com a causa.'
        }
    ]

    const optionsCat = [
        {
            'id': 1,
            'doenca': 'CLAMIDOSE: é uma doença provocada por uma bactéria. Febres, espirros, tosses e conjutivite ocorrendo em apenas um olho são os principais sintomas. A taxa de contágio é alta e ocorre através do contato, locais com grande concentração de bichanos podem ser perigosos. Considerada uma zoonose, tem como principal forma de prevenção a vacinação. O tratamento pode ser feito a partir de colírios ou de antibióticos.'
        },
        {
            'id': 2,
            'doenca': 'RAIVA FELINA: é uma doença praticamente erradicada no Brasil, mas que ainda merece destaque pelo seu grau de periculosidade. Com taxa de mortalidade de 100%, os principais sintomas da doença são falta de apetite, medo de água e luz, febre, dilatação da pupila, mudanças no comportamento e salivação excessiva. Não existe tratamento e a única forma de prevenção é a vacinação.'
        },
        {
            'id': 3,
            'doenca': 'INSUFICIÊNCIA RENAL CRÔNICA: a insuficiência renal crônica é uma doença ligada a genética dos gatos e causada por alterações naturais dos rins. Por isso, mesmo que mínimos, os sintomas da insuficiência renal crônica como o animal beber mais água e urinar em maior quantidade e com maior frequência precisam ser levados em conta. O mais comum é diagnosticar a insuficiência renal crônica em animais idosos, quando o problema já está mais desenvolvido.'
        },
        {
            'id': 4,
            'doenca': 'PERITONITE INFECCIOSA FELINA: é uma doença causada por vírus que pode atingir o abdómen, o fígado, os rins, o cérebro e o sistema nervoso dos gatos, causando abcessos e infecções nessas áreas. Dentre os sintomas da doença considerada fatal estão perda de apetite, anemia, diarreia, febre e emagrecimento. Não há nenhum tipo de tratamento e um gato diagnosticado poderá morrer em alguns dias.'
        },
        {
            'id': 5,
            'doenca': 'VÍRUS DA IMUNODEFICIÊNCIA FELINA: atinge o sistema imunológico dos gatos e por isso ficou conhecido como “HIV dos gatos”. A transmissão ocorre principalmente através do contato sanguíneo, por meio de transfusões ou de lutas entre os bichanos. Uma alimentação adequada e com reforço vitamínico necessário já são fatores para manter o bem estar do animal.'
        },
        {
            'id': 6,
            'doenca': 'RINOTRAQUEÍTE VIRA: também conhecida por ser uma “gripe de gato”, é uma das principais doenças que atingem o sistema respiratório dos felinos. Quanto mais novo o animal é atingido, piores serão os sintomas apresentados. Dentre os principais sinais estão corise nasal e ocular, febre, falta de apetite, apatia e depressão. A melhor pessoa para te orientar a respeito é um médico veterinário de sua confiança.'
        },
        {
            'id': 7,
            'doenca': 'LEUCEMIA FELINA: É uma doença viral dos produzida por um oncovírus, ou seja, é um tipo de cancro transmitido por contato com fluidos corporais. Por exemplo, lutas de gatos podem provocar alguma ferida que sangra quando eles se limpam e lambem e entram em contacto com a saliva de outros gatos.'
        },
        {
            'id': 8,
            'doenca': 'PANLEUCOPENIA FELINA: Esta doença é provocada por um parvovírus que, de alguma forma, está relacionado com o parvovírus canino. A infecção ocorre pelo contato com fluidos corporais de um fato infectado. Os sintomas mais comuns incluem febre e, mais tarde, hipotermia, vômitos, diarreia, depressão, fraqueza, desidratação e anorexia.'
        },
        {
            'id': 9,
            'doenca': 'RINOTRAQUEITE FELINA: O vírus que provoca a doença é um herpesvírus. O vírus permanece nas vias aéreas, provocando infecções do trato respiratório. Entre 45 e 50% das doenças respiratórias em gatos são causadas por este vírus. Os sintomas incluem febre, espirros, coriza, conjuntivite, lacrimejamento e até úlceras na córnea.'
        },
        {
            'id': 10,
            'doenca': 'RINOTRAQUEITE FELINA: O vírus que provoca a doença é um herpesvírus. O vírus permanece nas vias aéreas, provocando infecções do trato respiratório. Entre 45 e 50% das doenças respiratórias em gatos são causadas por este vírus. Os sintomas incluem febre, espirros, coriza, conjuntivite, lacrimejamento e até úlceras na córnea.'
        },
        {
            'id': 11,
            'doenca': 'PNEUMONITE: Produz um microrganismo que produz uma série de infecções conhecidas como clamídias que se caracterizam por rinites e conjuntivites nos gatos. Não é uma doença mortal por si mesma mas, para evitar complicações, deve consultar o veterinário rapidamente para iniciar o tratamento. Os sintomas incluem lacrimejamento excessivo, conjuntivite, pálpebras doloridas e avermelhadas secreção ocular abundante que pode ser amarelada ou esverdeada, espirros, febre, tosse, coriza e falta de apetite, entre outros.'
        },
        {
            'id': 12,
            'doenca': 'ALERGIA: Como acontece conosco, os gatos também sofrem de alergias de origens muito diversas.'
        },
        {
            'id': 13,
            'doenca': 'CONJUTIVITE: Os gatos possuem uma saúde ocular delicada, por isso ficam com conjuntivite com facilidade.'
        },
        {
            'id': 14,
            'doenca': 'DOENÇA PERIODENTAL: Esta doença que afeta a boca do seu felino é comum, sobretudo em gatos idosos. Pode ser fatal se não for tratada a tempo.'
        },
        {
            'id': 15,
            'doenca': 'OTITE: O bichano apresenta excesso de cera escura na borda da orelha e no ouvido externo, além de um cheiro ruim na região. O felino também pode coçar demais a área com as patinhas, procurando aliviar o incômodo causado pelos aracnídeos, e acabar ferindo ainda mais o ouvido.'
        },
        {
            'id': 16,
            'doenca': 'OBESIDADE E EXCESSO DE PESO: A obesidade é um problema muito frequente em gatos domésticos hoje em dia. '
        },
        {
            'id': 17,
            'doenca': 'GRIPE FELINA: Os sintomas da gripe felina ou rinotraqueite são: tosse, espirros, corrimento ocular, corrimento nasal, dificuldade em mastigar ou deglutir alimentos na sua forma mais branda, caso evolua para formas mais severas com pneumonia pode determinar dificuldade respiratória.'
        }
    ]


    return(
        <ScrollView style={styles.container}>
            

            <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center', padding: 15 }}>
                <Text style={{ fontSize: 19, fontWeight: "bold", marginBottom: 20, color: '#FFFFFF' }}>
                    Patologias de { animal }
                </Text>
                {
                    animal == 'Gato' ?
                    optionsCat.map(doenca => (
                        <Text key={doenca.id} style={{ fontSize: 15, color: '#FFFFFF', marginBottom: 15 }}> { doenca.doenca } </Text>
                    ))
                    :
                    animal == 'Cão' ?
                    optionsDog.map(doenca => (
                        <Text key={doenca.id} style={{ fontSize: 15, color: '#FFFFFF', marginBottom: 15 }}> { doenca.doenca } </Text>
                    ))
                    : null
                }
            </View>
        </ScrollView>

        );
    }
    
    const styles = StyleSheet.create({
        container: {
            flex: 1,
            backgroundColor: '#8D99AE',
            paddingTop: 20
        },
        
        btnCadastrarPet: {
            width:"90%",
            height:47,
            backgroundColor:"#EF233C",
            justifyContent:"center",
            alignItems:"center",
            borderWidth:1,
            borderColor:"#2B2D42",
            borderRadius:7,
            marginTop:20,
            marginBottom: 30
        },

        container2: {
            flex: 1,
            backgroundColor: '#FFF',
            width:"70%",
            marginTop:10,
            borderRadius:5
        },

        button2: {
            backgroundColor: "#2B2D42",
            width:'9%',
            height: 40,
            borderRadius:10,
            marginTop:5,
            marginLeft: 2,
            display: "flex",
            justifyContent: "center",
            alignItems: "center"
        }
    }
 
)