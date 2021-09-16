import React from 'react';
import {StyleSheet, Text, Image, SafeAreaView, ScrollView, Button, Linking, View} from 'react-native';
import ImagemMulherSorrindo from '../../../assets/MulherSorrindo2.png';
import MapaTuristico from '../../../assets/ExemploMapaTuristico.png';

import ButtonComponent from '../../components/Button';

const botao = () => {
  navigation.navigate('Pergunta');
};

const NumeroRecepcao = () => {
  return (
    <SafeAreaView style={styles.container}>
      <SafeAreaView style={styles.slide}>
      <Image
          source={ImagemMulherSorrindo}
          style={styles.ImagemMulherSorrindo}
        />
        <Text style={styles.title}>Foto mapa Turístico</Text>
        <Text style={styles.text}> "Helena, me mostre o mapa turístico"</Text>
        <ScrollView style={styles.scrollView}>
          <Image
            source={MapaTuristico}
            style={styles.MapaTuristico}
          />
        </ScrollView>
        <View style={styles.botaoMapa}>
        <ButtonComponent text='Abrir mapa' onPress={ ()=>{ Linking.openURL('https://www.sjc.sp.gov.br/media/129535/mapa_sjc_2020_atualizado_2_page-0001.jpg')}}/>
        </View>
      </SafeAreaView>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  container: {
    /* backgroundColor: '#F0FF', */
    justifyContent: 'center',
    alignItems: 'center',
  },
  slide: {
    flexDirection: 'column',
    justifyContent: 'center',
    /* alignItems: 'flex-end', */
    marginTop: 90,
    width: 360,
    height: 550,
    backgroundColor: '#FFFFFF',
    borderRadius: 20,
  },
  text: {
    textAlign: 'center',
    fontSize: 25,
    color: '#000000',
    marginTop: 16,
    marginBottom: 5,
  },
  title: {
    textAlign: 'center',
    fontSize: 20,
    fontWeight: 'bold',
    color: '#A020F0',
    marginTop: 32,
    marginLeft: 16,
    marginRight: 16,
  },
  ImagemMulherSorrindo: {
    height: 180,
    width: 310,
    justifyContent: 'center',
    alignItems: 'center',
  },
  MapaTuristico: {
    height: 170,
    width: 280,
    marginLeft: 45,
    marginBottom: 64,
    justifyContent: 'center',
    alignItems: 'center',
  },
  botaoMapa: {
    width: 200,
    height: 80,
    marginLeft: 80,
  },

});

export default NumeroRecepcao;
