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


import ImagemIbisHotel from '../../../../assets/ibishotel.png';
import ImagemIbisHotel2 from '../../../../assets/ibishotel2.png';
import ImagemIbisHotel3 from '../../../../assets/ibishotel3.png';
import ImagemIbisHotel4 from '../../../../assets/ibishotel4.png';


export default function BoasVindas({navigation}) {
  const headerHeight = useHeaderHeight();

  return (
    <View style={{...styles.container, marginTop: headerHeight}}>
      <View style={styles.content}>
      <Text style={styles.teste}>Hotel Ibis Dutra</Text>
      <Swiper index={0}
          autoplay={false}
          loop={false}
          style={styles.wrapper}
          showsButtons={true}>

        <View style={styles.slide1}>
        <Image
              source={ImagemIbisHotel}
              resizeMode={'contain'}
              style={styles.ImagemIbisHotel}
            />
        </View>
        <View style={styles.slide2}>
        <Image
              source={ImagemIbisHotel2}
              resizeMode={'contain'}
              style={styles.ImagemIbisHotel}
            />
        </View>
        <View style={styles.slide2}>
        <Image
              source={ImagemIbisHotel3}
              resizeMode={'contain'}
              style={styles.ImagemIbisHotel}
            />
        </View>
        <View style={styles.slide2}>
        <Image
              source={ImagemIbisHotel4}
              resizeMode={'contain'}
              style={styles.ImagemIbisHotel}
            />
        </View>
        
      </Swiper>
      <Text style={styles.comodidades}>Comodidades</Text>
      <Text style={styles.descricao}>🅿️ Estacionamento grátis</Text>
      <Text style={styles.descricao}>📶 Wi-Fi</Text>
      <Text style={styles.descricao}>❄️ Ar-condicionado</Text>
      <Text style={styles.descricao}>☕ Café da manhã</Text>
      <Text style={styles.descricao}></Text>
      <Text style={styles.descricao}></Text>
      <Text style={styles.descricao}></Text>
      <Text style={styles.descricao}></Text>
      <Text style={styles.descricao}></Text>
      <ButtonComponent text="Reservar um quarto!" style={styles.botao} onPress={() => {Linking.openURL('https://www.google.com/travel/hotels/entity/CgsI14an6N283aGCARAB/overview?g2lb=2502548%2C4258168%2C4270442%2C4306835%2C4317915%2C4371334%2C4401769%2C4419364%2C4429192%2C4482438%2C4486153%2C4509341%2C4515403%2C4533547%2C4533568%2C4533882%2C4536454%2C4552139%2C4554490%2C4270859%2C4284970%2C4291517&hl=pt-BR&gl=br&ssta=1&rp=ENeGp-jdvN2hggEQ14an6N283aGCATgCQABIAcABAg&ictx=1&utm_campaign=sharing&utm_medium=link&utm_source=htls&ts=CAESABpJCisSJzIlMHg5NGNjNGE4OWNlNmRkOTgzOjB4ODI0Mzc1ZTVkZDA5YzM1NxoAEhoSFAoHCOUPEAYYFBIHCOUPEAYYFRgBMgIQACoJCgU6A0JSTBoA'); }}/>
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
