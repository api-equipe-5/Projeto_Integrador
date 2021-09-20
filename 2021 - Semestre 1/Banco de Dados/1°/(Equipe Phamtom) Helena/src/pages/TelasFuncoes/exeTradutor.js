import React from 'react';
import {StyleSheet, Text, Image, SafeAreaView, ScrollView} from 'react-native';
import ImagemMulherSorrindo from '../../../assets/MulherSorrindo2.png';
import ftExeTradutorGoogle from '../../../assets/ftExeTradutorGoogle.png';

const exeTradutor = () => {

  return (
    <SafeAreaView style={styles.container}>
          < ScrollView>
            <SafeAreaView style={styles.slide}>
            <Image
                source={ImagemMulherSorrindo}              
                style={styles.ImagemMulherSorrindo}
            />

            <Text style={styles.title}>Tradutor</Text>

            <Text style={styles.text}> Diga a Afirmação:</Text>
            <Text style={styles.text1}>"Helena, abrir tradutor"</Text>

            <Text style={styles.text}>ou algo similar </Text>
            <Text style={styles.text2}>e a Helena responderá </Text>
            <Text style={styles.text2}>com a seguinte ação:</Text>
            <Image
                source={ftExeTradutorGoogle}              
                style={styles.ftExeTradutorGoogle}
            />

            <Text style={styles.text}>Depois disso, você está </Text>
            <Text style={styles.text5}>livre para o uso do tradutor</Text>

            </SafeAreaView>
            </ScrollView>
          </SafeAreaView>
  );
}

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
    width: 360,
    height: 1030,
    backgroundColor: '#FFFFFF',
    borderRadius: 20,
    marginTop: 75,
    marginBottom: 20,
    
  },
  text: {
    textAlign: 'center',
    fontSize: 23,
    color: '#4c1482',
    marginTop: 30,
    marginBottom:10,
    fontWeight:'bold',
  },
  text1: {
    textAlign: 'center',
    fontSize: 23,
    color: '#000000',
    marginTop: 22,
    marginBottom:5,
  },
  text4: {
    textAlign: 'center',
    fontSize: 23,
    color: '#000000',
    marginTop: -10,
  },
  text2: {
    textAlign: 'center',
    fontSize: 20,
    color: '#4c1482',
    marginTop: -10,
    marginBottom:5,
    fontWeight:'bold',
  },
  text5: {
    textAlign: 'center',
    fontSize: 20,
    color: '#4c1482',
    marginTop: -15,
    marginBottom:-25,
    fontWeight:'bold',
  },
  text3: {
    textAlign: 'center',
    fontSize: 20,
    color: '#4c1482',
    marginTop: 15,
    marginBottom:7,
    fontWeight:'bold',
  },

  title: {
    textAlign: 'center',
    fontSize: 30,
    color: '#000000',
    marginTop: 15,
    marginLeft: 16,
    marginRight: 16,

  },

  ImagemMulherSorrindo: {
    height: 160,
    width: 160,
    justifyContent: 'center',
    marginLeft: 85,
    alignItems: 'center',
    marginTop: -140,
    marginBottom: -45,
  },
  ftExeTradutorGoogle: {
    height: 400,
    width: 330,
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 25,
    marginLeft: 15,
    marginBottom: 0,
    borderWidth: 2.5,
    borderColor:'#4c1482',
    borderRadius: 13,
  },
});

export default exeTradutor;
