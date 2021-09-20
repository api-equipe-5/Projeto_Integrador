import React from 'react';
import {StyleSheet, Text, Image, SafeAreaView, ScrollView, View, Linking} from 'react-native';
import ButtonComponent from '../../components/Button';
import helenaSad from '../../../assets/helenaSad.png';


export default function Tradutor({navigation}){

  
  return (
    <SafeAreaView style={styles.container}>
      <SafeAreaView style={styles.slide}>
      <Image
          source={helenaSad}
          style={styles.helenaSad}
        />
        <Text style={styles.title}>Oh não!</Text>
        <Text style={styles.text}>🚧 Houveram problemas quanto a implementação da funcionalidade, </Text>
        <Text style={styles.text1}>MAS NÃO TEMAS! </Text>
        <Text style={styles.text}>Apertando no botão abaixo </Text>
        <Text style={styles.text2}>você poderá usar o Google Tradutor! </Text>


        <View style={styles.titulo}>
        <Text style={styles.title}>Google Tradutor!</Text>
        </View>
        
        <View style={styles.botao}>
        <ButtonComponent text="Abrir" style={styles.botao} onPress={() => {Linking.openURL('https://translate.google.com.br/?hl=pt-BR'); }}/>
        </View>
      </SafeAreaView>
    </SafeAreaView>
 );
}

const styles = StyleSheet.create({
  container: {
    /* backgroundColor: '#F0FF', */
    justifyContent: 'center',
    alignItems: 'center',
  },
  botao: {
    width: 155,
    height: 470,
    justifyContent: 'center',
    flexDirection: 'column',
    marginLeft: 100,
    marginBottom: 50,
    marginTop: -200,
  },
  botao1: {
    width: 155,
    height: 530,
    justifyContent: 'center',
    flexDirection: 'column',
    marginLeft: 100
  },
  titulo:{
  },
  helenaSad: {
    height: 120,
    width: 120,
    justifyContent: 'center',
    marginLeft: 120,
    alignItems: 'center',
    marginTop: 170,
  },
  ftGoogleTradutor: {
    height: 235,
    width: 400,
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 60,
    marginLeft: -20,
    marginBottom: -20,
    borderWidth: 2.5,
    borderColor:'#4c1482',
    borderRadius: 13,
  },
  slide: {
    flexDirection: 'column',
    justifyContent: 'center',
    /* alignItems: 'flex-end', */
    marginTop: 70,
    width: 360,
    height: 570,
    backgroundColor: '#FFFFFF',
    borderRadius: 20,
  },
  text: {
    textAlign: 'center',
    fontSize: 23.5,
    color: '#000000',
    marginTop: 32,
    marginBottom: 20,
  },
  text1: {
    textAlign: 'center',
    fontSize: 22.5,
    color: '#4c1482',
    marginTop: 0,
    marginBottom: -10,
    fontWeight:'bold',
  },
  text2: {
    textAlign: 'center',
    fontSize: 23.5,
    color: '#000000',
    marginTop: -25,
    marginBottom: 20,
  },
  title: {
    textAlign: 'center',
    fontSize: 30,
    color: '#4c1482',
    marginTop: 15,
    marginLeft: 16,
    marginRight: 16,

  },
});
