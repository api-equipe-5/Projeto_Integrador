import React from 'react';
import {StyleSheet, Text, Image, SafeAreaView, ScrollView} from 'react-native';
import ImagemMulherSorrindo from '../../../assets/MulherSorrindo2.png';
import ftExePontosTurísticos from '../../../assets/ftExePontosTurísticos.png';
import ftExePontosTurísticosSJC from '../../../assets/ftExePontosTurísticosSJC.png';

const exePontosTuristicos = () => {
  return (
    <SafeAreaView style={styles.container}>
          < ScrollView>
            <SafeAreaView style={styles.slide}>
            <Image
                source={ImagemMulherSorrindo}              
                style={styles.ImagemMulherSorrindo}
            />

            <Text style={styles.title}>Pontos Turísticos</Text>

            <Text style={styles.text}>Diga a Afirmação:</Text>
            <Text style={styles.text1}>"Helena, mostrar</Text>
            <Text style={styles.text4}> pontos turísticos"</Text>

            <Text style={styles.text}>ou algo similar</Text>
            <Text style={styles.text2}>e a Helena responderá </Text>
            <Text style={styles.text2}>com a seguinte ação:</Text>
            <Image
                source={ftExePontosTurísticos}              
                style={styles.ftExePontosTurísticos}
            />


            <Text style={styles.text3}>A partir daí, você escolhe </Text>
            <Text style={styles.text2}>uma cidade e a Helena </Text>
            <Text style={styles.text2}>mostra os principais pontos </Text>
            <Text style={styles.text2}>turísticos de lá, veja:</Text>

            <Image
                source={ftExePontosTurísticosSJC}              
                style={styles.ftExePontosTurísticosSJC}
            />

            <Text style={styles.text3}>Outra opção seria dizer </Text>
            <Text style={styles.text2}>o nome da cidade junto a </Text>
            <Text style={styles.text2}>afirmação do exemplo:</Text>
            <Text style={styles.text1}>"Helena, mostrar</Text>
            <Text style={styles.text4}> pontos turísticos de"</Text>
            <Text style={styles.text4}> São José dos Campos"</Text>








            
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
    height: 1780,
    backgroundColor: '#FFFFFF',
    borderRadius: 20,
    marginTop: 75,
    marginBottom: 20,
    
  },
  ftExePontosTurísticos: {
    height: 505,
    width: 320,
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 25,
    marginLeft: 20,
    marginBottom: 10,
    borderWidth: 2.5,
    borderColor:'#4c1482',
    borderRadius: 13,
  },
  ftExePontosTurísticosSJC: {
    height: 480,
    width: 280,
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 25,
    marginLeft: 40,
    marginBottom: 10,
    borderWidth: 2.5,
    borderColor:'#4c1482',
    borderRadius: 13,
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
  
});

export default exePontosTuristicos;
