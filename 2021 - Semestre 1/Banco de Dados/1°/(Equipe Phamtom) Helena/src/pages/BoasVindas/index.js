import {ServerContainer} from '@react-navigation/native';
import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  TouchableOpacity,
  ScrollView,
  View,
  Image,
  Button,
} from 'react-native';
import ButtonComponent from '../../components/Button';
import Swiper from 'react-native-swiper';
import {useHeaderHeight} from '@react-navigation/stack';

import ImagemMulher from '../../../assets/mulher.png';
import ImagemMicrophone from '../../../assets/microfone2.png';
import ImagemExemploTempo from '../../../assets/ExemploTempo.png';
import imagemExemploClimaAtual from '../../../assets/imagemExemploClimaAtual.png';
import Icon from "react-native-vector-icons/Feather"

export default function BoasVindas({navigation}) {
  const headerHeight = useHeaderHeight();

  const botao = () => {
    navigation.navigate('Pergunta');
  };
  

  return (
    <View style={{...styles.container, marginTop: headerHeight}}>
      <View style={styles.content}>
        <View style={styles.imagemMulherContainer}>
          <Image
            source={ImagemMulher}
            resizeMode={'contain'}
            style={styles.imagemMulher}
          />
        </View>
        <Text style={styles.text4} onPress={botao}>Pular Tutorial </Text>
        <Swiper
          index={0}
          autoplay={false}
          loop={false}
          style={styles.wrapper}
          showsButtons={false}>
          <View style={styles.slide1}>
            <Text style={styles.text3}>Muito prazer, eu me chamo</Text>
            <Text style={styles.text5}>Helena!</Text>
            <Text style={styles.text3}>Sou sua assistente virtual de viagens!</Text>
          </View>
          <View style={styles.slide2}>
            <Text style={styles.helenaName}>
              Estou aqui para te ajudar em diversas atividades!
            </Text>
            <Text style={styles.PorExemploText}>Por exemplo:</Text>
            <Text style={styles.lunchexample}>"Helena, qual o clima atual?"</Text>
          </View>
          <View style={styles.slide3}>
            <Text style={styles.textresp}>"Helena, qual o clima atual?"</Text>
          
            <Image
            source={imagemExemploClimaAtual}
            style={styles.imagemExemploClimaAtual}>
            </Image>
            
          </View>
          <View style={styles.slide4}>
            <Text style={styles.text1}>Basta apertar o botão e dizer meu nome! </Text>
            <Image
              source={ImagemMicrophone}
              resizeMode={'contain'}
              style={styles.imageMicrophone}
            />
            <View style={styles.botaoIniciar}>
            <ButtonComponent text='Iniciar' onPress={botao} />
            </View>
          </View>
        </Swiper>
      </View>
    </View>
  );
}

//Basta chamar meu nome e falar!

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  content: {
    margin: 16,
    flex: 1,
  },
  imagemMulherContainer: {
    alignItems: 'center',
    marginTop: -52,
    marginBottom: 22,
  },
  imageMulherSorrindoContainer: {
    flex: 1,
    alignItems: 'center',
  },
  imagemExemploClimaAtual: {
    height: 232,
    width: 180,
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: -40,
    marginBottom: -15,
    borderRadius: 13,
  },
  helenaName: {
    textAlign: 'center',
    fontSize: 30,
    color: '#000000',
    marginTop: 55,
  },
  text1: {
    flex: 0.7,
    textAlign: 'center',
    fontSize: 30,
    color: '#000000',
    marginLeft: 8,
    marginRight: 8,
    marginTop: 48,
  },
  text2: {
    flex: 0.5,
    textAlign: 'center',
    fontSize: 30,
    color: '#000000',
    marginTop: 32,
  },
  textresp: {
    flex: 0.5,
    textAlign: 'center',
    fontSize: 30,
    color: '#000000',
    marginTop: 32,
    marginBottom:50,
  },
  text3: {
    textAlign: 'center',
    fontSize: 30,
    color: '#000000',
    marginTop: 64,
    marginLeft: 16,
    marginRight: 16,
  },
  text4: {
    textAlign: 'right',
    fontSize: 25,
    color: '#c19de3',
    marginTop: -50,
    marginLeft: 16,
    marginRight: 16,
  },
  text5: {
    textAlign: 'center',
    fontSize: 35,
    color: '#511789',
    marginTop: 30,
    marginBottom: -43,
    marginLeft: 16,
    marginRight: 16,
    fontWeight: "bold",
  },
  lunchexample: {
    textAlign: 'center',
    fontSize: 30,
    color: '#000000',
    margin: 8,
  },
  timetext: {
    textAlign: 'center',
    fontSize: 30,
    color: '#511789',
    marginTop: 16,
  },
  PorExemploText: {
    textAlign: 'center',
    fontSize: 30,
    color: '#511789',
    marginTop: 55,
    marginRight: 155,
    marginBottom: 16,
    fontWeight: "bold",
  },
  imagemMulher: {
    height: 200,
  },
  imagemMulherSorrindo: {
    width: 250,
    height: 250,
  },
  imageMicrophone: {
    height: 130,
  },
  wrapper: {},
  slide1: {
    flex: 1,
    justifyContent: 'flex-start',
    alignItems: 'center',
    width: 370,
    height: 50,
    backgroundColor: '#FFFFFF',
    borderRadius: 20,
  },
  slide2: {
    flex: 1,
    justifyContent: 'flex-start',
    alignItems: 'center',
    width: 370,
    height: 50,
    backgroundColor: '#FFFFFF',
    borderRadius: 20,
  },
  slide3: {
    flex: 1,
    justifyContent: 'flex-start',
    alignItems: 'center',
    width: 370,
    height: 50,
    backgroundColor: '#FFFFFF',
    borderRadius: 20,
  },
  slide4: {
    flex: 1,
    justifyContent: 'flex-start',
    alignItems: 'center',
    width: 370,
    height: 50,
    backgroundColor: '#FFFFFF',
    borderRadius: 20,
  },
  text: {
    color: '#fff',
    fontSize: 30,
    fontWeight: 'bold',
  },
  ImagemExemploTempo: {
    height: 225,
    width: 237,
    marginLeft: 16,
    marginTop: 0,
    marginBottom: -30,
    justifyContent: 'center',
    alignItems: 'center',
  },
  botaoIniciar:{
    marginBottom: 15,
    width: 150,
  }
});
