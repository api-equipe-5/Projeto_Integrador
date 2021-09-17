import React from 'react';
import {StyleSheet, Text, Image, SafeAreaView, ScrollView} from 'react-native';
import ImagemMulherSorrindo from '../../../assets/MulherSorrindo2.png';
import ftExeOndeEstou from '../../../assets/ftExeOndeEstou.png';

const exeOndeEstou = () => {

  return (
    <SafeAreaView style={styles.container}>
          < ScrollView>
            <SafeAreaView style={styles.slide}>
            <Image
                source={ImagemMulherSorrindo}              
                style={styles.ImagemMulherSorrindo}
            />

            <Text style={styles.title}>Onde Estou?</Text>

            <Text style={styles.text}>Diga a Afirmação:</Text>
            <Text style={styles.text1}>"Helena, onde estou?"</Text>

            <Text style={styles.text}>ou algo similar </Text>
            <Text style={styles.text2}>e a Helena responderá </Text>
            <Text style={styles.text2}>com a seguinte ação:</Text>
            <Image
                source={ftExeOndeEstou}              
                style={styles.ftExeOndeEstou}
            />

            <Text style={styles.text3}>Com isso, você verá a </Text>
            <Text style={styles.text2}>sua localização atual.</Text>
            
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
    height: 940,
    backgroundColor: '#FFFFFF',
    borderRadius: 20,
    marginTop: 75,
    marginBottom: 20,
    
  },
  ftExeOndeEstou: {
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
  ftExeRoteiro: {
    height: 550,
    width: 320,
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 25,
    marginLeft: 20,
  },
});

export default exeOndeEstou;
