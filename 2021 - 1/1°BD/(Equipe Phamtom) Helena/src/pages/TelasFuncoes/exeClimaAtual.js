import React from 'react';
import {StyleSheet, Text, Image, SafeAreaView, ScrollView} from 'react-native';
import ImagemMulherSorrindo from '../../../assets/MulherSorrindo2.png';
import imagemExemploClimaAtual from '../../../assets/imagemExemploClimaAtual.png';

const exeClimaAtual = () => {

  return (
    <SafeAreaView style={styles.container}>
    < ScrollView>
      <SafeAreaView style={styles.slide}>
      <Image
          source={ImagemMulherSorrindo}              
          style={styles.ImagemMulherSorrindo}
      />
    
      <Text style={styles.title}>Clima Atual</Text>

      <Text style={styles.text}>Diga a Afirmação:</Text>
      <Text style={styles.text1}>"Helena, mostrar</Text>
      <Text style={styles.text4}>o clima atual"</Text>

      <Text style={styles.text}>ou algo similar</Text>
      <Text style={styles.text2}>e a Helena responderá </Text>
      <Text style={styles.text2}>com a seguinte ação:</Text>
      <Image
        source={imagemExemploClimaAtual}              
        style={styles.imagemExemploClimaAtual}
       />
      <Text style={styles.text}>Pronto! Agora você pode </Text>
      <Text style={styles.text2}>ver o clima e a temperatura </Text>
      <Text style={styles.text5}>atual.</Text>
      
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
height: 990,
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
text3: {
textAlign: 'center',
fontSize: 20,
color: '#4c1482',
marginTop: 15,
marginBottom:7,
fontWeight:'bold',
},
text5: {
  textAlign: 'center',
  fontSize: 20,
  color: '#4c1482',
  marginTop: -10,
  marginBottom:-35,
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
imagemExemploClimaAtual: {
  height: 480,
  width: 300,
  justifyContent: 'center',
  alignItems: 'center',
  marginTop: 25,
  marginLeft: 30,
  marginBottom: 10,
  borderWidth: 2.5,
  borderColor:'#4c1482',
  borderRadius: 13,
},
});


export default exeClimaAtual;
