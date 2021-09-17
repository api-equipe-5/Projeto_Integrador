import {ServerContainer} from '@react-navigation/native';
import React from 'react';
import {
  StyleSheet,
  Text,
  View,
  Image,
  Linking
} from 'react-native';
import ButtonComponent from '../../../components/Button';
import Swiper from 'react-native-swiper';
import {useHeaderHeight} from '@react-navigation/stack';


import plazahotel1 from '../../../../assets/plazahotel1.png';
import plazahotel2 from '../../../../assets/plazahotel2.png';
import plazahotel3 from '../../../../assets/plazahotel3.png';
import plazahotel4 from '../../../../assets/plazahotel4.png';



export default function BoasVindas({navigation}) {
  const headerHeight = useHeaderHeight();

  return (
    <View style={{...styles.container, marginTop: headerHeight}}>
      <View style={styles.content}>
      <Text style={styles.teste}>Plaza Hotel</Text>
      <Swiper index={0}
          autoplay={false}
          loop={false}
          style={styles.wrapper}
          showsButtons={true}>

        <View style={styles.slide1}>
        <Image
              source={plazahotel1}
              resizeMode={'contain'}
              style={styles.ImagemIbisHotel}
            />
        </View>
        <View style={styles.slide2}>
        <Image
              source={plazahotel2}
              resizeMode={'contain'}
              style={styles.ImagemIbisHotel}
            />
        </View>
        <View style={styles.slide2}>
        <Image
              source={plazahotel3}
              resizeMode={'contain'}
              style={styles.ImagemIbisHotel}
            />
        </View>
        <View style={styles.slide2}>
        <Image
              source={plazahotel4}
              resizeMode={'contain'}
              style={styles.ImagemIbisHotel}
            />
        </View>
        
      </Swiper>
      <Text style={styles.comodidades}>Comodidades</Text>
      <Text style={styles.descricao}></Text>
      <Text style={styles.descricao}>📶 Wi-Fi</Text>
      <Text style={styles.descricao}>❄️ Ar-condicionado</Text>
      <Text style={styles.descricao}></Text>
      <Text style={styles.descricao}></Text>
      <Text style={styles.descricao}></Text>
      <Text style={styles.descricao}></Text>
      <Text style={styles.descricao}></Text>
      <ButtonComponent text="Reservar um quarto!" style={styles.botao} onPress={() => {Linking.openURL('https://www.hoteis.com/ho549370/plaza-hotel-sao-jose-dos-campos-brasil/?q-rooms=1&q-room-0-adults=2&q-room-0-children=0'); }}/>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({

  container: {
    flex: 1, 
    
  },
  content: {
    margin: 16,
    flex: 1,
  },
  ImagemIbisHotel: {
    width: 500,
    height: 250,
    marginTop: 40,
    borderRadius: 20
  },
 comodidades: {
    textAlign: 'left',
    fontSize: 30,
    color: 'white',
    marginBottom: 15,

  },
  descricao: {
    textAlign: 'left',
    marginLeft: 20,
    fontSize: 18,
    color: 'white',
  },
  descricao1: {
    textAlign: 'left',
    fontSize: 15,
    color: 'white',
  },
  text1: {

    textAlign: 'center',
    fontSize: 30,
    color: '#000000',
    marginLeft: 8,
    marginRight: 8,
    marginTop: 48,
  },
  text2: {

    textAlign: 'center',
    fontSize: 30,
    color: '#000000',
    marginTop: 32,
  },
  text3: {
    textAlign: 'center',
    fontSize: 30,
    color: '#000000',
    marginTop: 64,
    marginLeft: 16,
    marginRight: 16,
  },
  teste: {
    textAlign: 'center',
    fontSize: 25,
    color: 'white',
    marginLeft: 1,
    marginRight: 16,
  },
  wrapper: {
    marginBottom: -50,
    height: 310,
  },
  slide1: {

    justifyContent: 'flex-start',
    alignItems: 'center',
    width: 370,
    height: 10,
    margin: 10,
    borderRadius: 20,
  },
  slide2: {
    justifyContent: 'flex-start',
    alignItems: 'center',
    width: 370,
    height: 50,
    margin: 10,
    borderRadius: 20,
  },
});
