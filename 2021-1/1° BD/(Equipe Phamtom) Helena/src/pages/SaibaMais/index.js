import React from 'react';
import {StyleSheet, Text, SafeAreaView, ScrollView, Image, View} from 'react-native';
import ButtonComponent from '../../components/Button';
import FotoSJC from '../../../assets/SJoséCampos.jpg';
import FotoJacarei from '../../../assets/Patio_Trilhos1.jpg';
import FotoSaoSebastiao from '../../../assets/saoSebastiao.jpg';
import FotoCamposdoJordao from '../../../assets/camposdoJordao.jpg';


export default function SobreCidade({navigation}){

  const histSJCampos = () => {
    navigation.navigate('sobreSJCampos');
  };

  const histConstrucao = () => {
    navigation.navigate('construcao');
  };

  return (
    <SafeAreaView style={styles.container}>
        
      <View style={styles.titulo}>
        <Text style={styles.title}>Saiba Mais sobre as Cidades Disponíveis!</Text>
      </View>

        <ScrollView>

        <SafeAreaView style={styles.slide2}>

        <SafeAreaView style={styles.slide}>
            <View style={styles.botao}>
              <Image
                source={FotoSJC}
                style={styles.FotoSJC}
              />
            </View>
            <View style={styles.botao}>
              <ButtonComponent text="São José dos Campos, SP" style={{fontWeight: "bold"}} onPress={histSJCampos}/>
            </View>
        </SafeAreaView>

        <SafeAreaView style={styles.slide}>
            <View style={styles.botao}>
              <Image
                source={FotoCamposdoJordao}
                style={styles.FotoCamposdoJordao}
              />
            </View>
            <View style={styles.botao}>
              <ButtonComponent text="Campos do Jordão, SP  🚧" style={{fontWeight: "bold"}} onPress={histConstrucao}/>
            </View>
        </SafeAreaView>

        <SafeAreaView style={styles.slide}>
            <View style={styles.botao}>
              <Image
                source={FotoJacarei}
                style={styles.FotoJacarei}
              />
            </View>
            <View style={styles.botao}>
              <ButtonComponent text="Jacareí, SP  🚧" style={{fontWeight: "bold"}} onPress={histConstrucao}/>
            </View>
        </SafeAreaView>

        <SafeAreaView style={styles.slide}>
            <View style={styles.botao}>
              <Image
                source={FotoSaoSebastiao}
                style={styles.FotoSaoSebastiao}
              />
            </View>
            <View style={styles.botao}>
              <ButtonComponent text="São Sebastião, SP  🚧" style={{fontWeight: "bold"}} onPress={histConstrucao}/>
            </View>
        </SafeAreaView>

        </SafeAreaView>
        </ScrollView>
    </SafeAreaView>
 );
}

const styles = StyleSheet.create({
  container: {
    /* sbackgroundColor: '#F0FF', */
    justifyContent: 'center',
    alignItems: 'center',
  },
  botao: {
    width: 380,
    marginTop: 5,
    marginBottom: -28,
    justifyContent: 'center',
    flexDirection: 'column',
    marginLeft: 30,
  },
  titulo:{
  },

  FotoSJC: {
    height: 233,
    width: 380,
    marginBottom: 15,
    marginTop: -100,
    justifyContent: 'center',
    alignItems: 'center',
    borderRadius: 10,
  },
  FotoJacarei: {
    height: 233,
    width: 380,
    marginBottom: 15,
    marginTop: -100,
    justifyContent: 'center',
    alignItems: 'center',
    borderRadius: 10,
  },
  FotoCamposdoJordao: {
    height: 233,
    width: 380,
    marginBottom: 15,
    marginTop: -100,
    justifyContent: 'center',
    alignItems: 'center',
    borderRadius: 10,
  },

   FotoSaoSebastiao: {
    height: 233,
    width: 380,
    marginBottom: 15,
    marginTop: -100,
    justifyContent: 'center',
    alignItems: 'center',
    borderRadius: 10,
  },
  
  slide: {
    flexDirection: 'column',
    justifyContent: 'center',
    marginLeft: 15,
    alignItems: 'flex-end',
    marginTop: 100,
    marginBottom: 5,
    width: 380,
    height: 220,
    backgroundColor: '#9867C5',
    borderRadius: 20,
  },
  slide2: {
    flexDirection: 'column',
    flex: 1,
    marginTop: 5,
    width: 410,
    height: 1400,
    backgroundColor: '#FFFF',
  },
  text: {
    textAlign: 'center',
    fontSize: 28,
    color: '#000000',
    marginTop: 32,
    marginBottom: 50,
  },
  title: {
    textAlign: 'center',
    fontSize: 27,
    color: 'white',
    marginTop: 55,
    marginBottom: 25,
    marginLeft: 16,
    marginRight: 16,
  },
});
