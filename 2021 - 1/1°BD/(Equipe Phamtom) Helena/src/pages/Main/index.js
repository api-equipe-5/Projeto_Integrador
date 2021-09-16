import React from 'react';
import {StyleSheet, Text, TouchableOpacity, View, Image} from 'react-native';
import ButtonComponent from '../../components/Button';
import ImagemIconLogo from '../../../assets/PhantomLogo2.png';
import ImagemMulherSorrindo from '../../../assets/MulherSorrindo2.png';


export default function Main({navigation}) {
  const handleClickGuest = () => {
    navigation.navigate('BoasVindas');
  };

  const BotaoListaFuncoes = () => {
    navigation.navigate('ListaFuncoes');
  };

  return (
    <View style={styles.container}>
      <Image
          source={ImagemMulherSorrindo}
          style={styles.ImagemMulherSorrindo}
        />
      <Text style={styles.sejaBemVindoText}>Seja bem-vindo!</Text>
      <View style={styles.content}>
        <Text style={styles.naoHospedadoText}>Pronto para conhecer a Helena?</Text>
        <ButtonComponent text="Começar agora" onPress={handleClickGuest} />
        <Text style={styles.hospedeText}>Conheça as funcionalidades</Text>
        <ButtonComponent text="Lista de funcionalidades" onPress={BotaoListaFuncoes} />
      </View>
      <View style={styles.imagemhotelContainer}>
        <Image
          source={ImagemIconLogo}
          resizeMode={'contain'}
          style={styles.ImagemIconLogo}
        />
      </View>
    </View>
  );
}
const styles = StyleSheet.create({
  container: {
    flex: 1,
    marginLeft: 16,
    marginRight: 16,
    marginTop: 16,
  },
  content: {
    flex: 1,
    justifyContent: 'center',
  },
  sejaBemVindoText: {
    textAlign: 'center',
    fontSize: 30,
    color: '#FFF',
    marginBottom: 10
  },
  naoHospedadoText: {
    textAlign: 'center',
    fontSize: 24,
    color: '#FFF',
  },
  hospedeText: {
    textAlign: 'center',
    fontSize: 24,
    color: '#FFF',
  },
  ImagemIconLogo: {
    height: 50,
    marginBottom: 13
  },
  imagemhotelContainer: {
    alignItems: 'center',
  },
  ImagemMulherSorrindo: {
    height: 250,
    width: 262,
    marginLeft: 38,
    justifyContent: 'center',
    alignItems: 'center',
  },
});
