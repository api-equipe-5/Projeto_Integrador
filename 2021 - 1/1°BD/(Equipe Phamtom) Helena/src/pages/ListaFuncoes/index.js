import React from 'react';
import {
  StyleSheet,
  Text,
  TouchableOpacity,
  View,
  Image,
  ScrollView,
} from 'react-native';
import ButtonComponent from '../../components/Button';
import RoteiroPessoal from '../RoteiroPessoal';

export default function Main({navigation}) {
  
  const irParaClima = () => {
    navigation.navigate('exeClimaAtual');
  };
  const irParaCalculadora = () => {
    navigation.navigate('Calculadora');
  };
  const irParaRoteiroPessoal = () => {
    navigation.navigate('exeRoteiro');
  };
  const irParaOndeEstou = () => {
    navigation.navigate('exeOndeEstou');
  };
  const irParaPontosTuristicos = () => {
    navigation.navigate('exePontosTuristicos');
  };  
  const irParaMapaHoteis = () => {
    navigation.navigate('exePrecoHoteis');
  };  
  const irParaSaibaMais = () => {
    navigation.navigate('exeSaibaMais');
  };
  const irParaConversaoMoedas = () => {
    navigation.navigate('exeConversorMoedas');
  };
  const irParaConversaoMedidas = () => {
    navigation.navigate('construcao');
  };
  const irParaTradutor = () => {
    navigation.navigate('exeTradutor');
  };
  const irParaTeste = () => {
    navigation.navigate('Teste');
  };           

  return (
    <View style={styles.container}>
      <Text style={styles.conhecaFuncoes}>Conheça Nossas Funções!</Text>

      <View style={styles.content}>
        <ScrollView>
          <ButtonComponent text="Pontos Turísticos" onPress={irParaPontosTuristicos} />
          <ButtonComponent text="Onde Estou?" onPress={irParaOndeEstou} />
          <ButtonComponent text="Preço de Hoteis (Mapa)" onPress={irParaMapaHoteis}/>
          <ButtonComponent text="Roteiro Pessoal" onPress={irParaRoteiroPessoal} />
          <ButtonComponent text="Clima Atual" onPress={irParaClima} />
          <ButtonComponent text="Saiba Mais (Cidades)" onPress={irParaSaibaMais}/>
          <ButtonComponent text="Conversor de Moedas" onPress={irParaConversaoMoedas} />
          <ButtonComponent text="Conversor de Medidas" onPress={irParaConversaoMedidas} />
          <ButtonComponent text="Tradutor" onPress={irParaTradutor} />
        </ScrollView>
      </View>
    </View>
  );
}
//<ButtonComponent text="Calculadora" onPress={irParaCalculadora} />

const styles = StyleSheet.create({
  container: {
    flex: 1,
    marginLeft: 20,
    marginRight: 20,
    marginTop: 20,
  },
  content: {
    flex: 1,
    justifyContent: 'center',
  },
  conhecaFuncoes: {
    textAlign: 'center',
    fontSize: 25,
    color: '#FFF',
    marginTop: 15,
    marginBottom: 25,
  },
  naoHospedadoText: {
    textAlign: 'center',
    fontSize: 24,
    color: '#FFF',
  },
  hospedeText: {
    textAlign: 'center',
    fontSize: 24,
    color: '#FFF',
  },
  imagemiconhotel: {
    height: 100,
  },
  imagemhotelContainer: {
    alignItems: 'center',
  },
});
