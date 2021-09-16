import {ServerContainer} from '@react-navigation/native';
import React from 'react';
import {StyleSheet, Text, SafeAreaView, ScrollView, Image, View} from 'react-native';
import {useHeaderHeight} from '@react-navigation/stack';
import Swiper from 'react-native-swiper';
import igrejaMatrizSJC from '../../../assets/igrejaMatrizSJC.jpg';
import tecelagemParahyba from '../../../assets/tecelagemParahyba.png';
import vicentinoAranha from '../../../assets/vicentinoAranha.jpg';
import sjcFoto1 from '../../../assets/sjcFoto1.jpg';
import sjcFoto2 from '../../../assets/sjcFoto2.jpg';
import sjcFoto3 from '../../../assets/sjcFoto3.jpg';
import sjcFoto4 from '../../../assets/sjcFoto4.jpg';
import sjcFoto5 from '../../../assets/sjcFoto5.jpg';
import sjcFoto6 from '../../../assets/sjcFoto6.jpg';
import sjcFoto7 from '../../../assets/sjcFoto7.jpg';
import sjcFoto8 from '../../../assets/sjcFoto8.jpg';
import sjcFoto9 from '../../../assets/sjcFoto9.jpg';
import sjcFoto10 from '../../../assets/sjcFoto10.jpg';
import sjcFoto11 from '../../../assets/sjcFoto11.jpg';
import sjcFoto12 from '../../../assets/sjcFoto12.jpg';
import sjcFoto13 from '../../../assets/sjcFoto13.jpg';
import sjcFoto14 from '../../../assets/sjcFoto14.jpg';
import sjcFoto15 from '../../../assets/sjcFoto15.jpg';

export default function SobreCidade({navigation}){

  const headerHeight = useHeaderHeight();

return (
    
    <View style={{...styles.container, marginTop: headerHeight}}>
      <View style={styles.content}>
        <View style={styles.slideroxo}>
            <Text style={styles.title}>São José dos Campos</Text>
        </View>
        
        <Swiper
          index={0}
          autoplay={false}
          loop={false}
          style={styles.wrapper}
          showsButtons={false}>

          <ScrollView >
          <Swiper style={styles.wrapper1}>
          <SafeAreaView style={styles.slide1}> 
            <Text style={styles.text5}>Imagens</Text>
            <Text style={styles.text7}>Coletânea de imagens da cidade</Text>
            <SafeAreaView style={styles.slideblack}> 
            <Image
              source={sjcFoto1}
              style={styles.sjcFoto}
            />
            <Image
              source={sjcFoto2}
              style={styles.sjcFoto}
            />
            <Image
              source={sjcFoto3}
              style={styles.sjcFoto}
            />
            <Image
              source={sjcFoto4}
              style={styles.sjcFoto}
            />
            <Image
              source={sjcFoto5}
              style={styles.sjcFoto}
            />
            <Image
              source={sjcFoto6}
              style={styles.sjcFoto}
            />
            <Image
              source={sjcFoto7}
              style={styles.sjcFoto}
            />
            <Image
              source={sjcFoto8}
              style={styles.sjcFoto}
            />
            <Image
              source={sjcFoto9}
              style={styles.sjcFoto}
            />
            <Image
              source={sjcFoto10}
              style={styles.sjcFoto}
            />
            <Image
              source={sjcFoto11}
              style={styles.sjcFoto}
            />
            <Image
              source={sjcFoto12}
              style={styles.sjcFoto}
            />
            <Image
              source={sjcFoto13}
              style={styles.sjcFoto}
            />
            <Image
              source={sjcFoto14}
              style={styles.sjcFoto}
            />
            
          </SafeAreaView></SafeAreaView></Swiper></ScrollView>
          
          <ScrollView >
          <Swiper style={styles.wrapper4}>
          <SafeAreaView style={styles.slide1_5}> 
            <Text style={styles.text5}>Dados Curiosos</Text>
            
            <Image
              source={sjcFoto15}
              style={styles.sjcFoto15}
            />

            <Text style={styles.text3}>
              <Text style={{fontWeight: "bold"}}>Natural: </Text>
               Joseense </Text>

            <Text style={styles.text4}>
              <Text style={{fontWeight: "bold"}}>Clima: </Text>
              Mesotérmico úmido com estação seca no inverno</Text>

            <Text style={styles.text4}>
              <Text style={{fontWeight: "bold"}}>Marco zero: </Text>
              Igreja Matriz </Text>

            <Text style={styles.text4}>
              <Text style={{fontWeight: "bold"}}>Região estadual: </Text>
              Vale do Paraíba</Text>

            <Text style={styles.text4}>
              <Text style={{fontWeight: "bold"}}>Estado: </Text>
              São Paulo</Text>

            <Text style={styles.text4}>
              <Text style={{fontWeight: "bold"}}>Região do Brasil: </Text>
              Sudeste</Text>
            <Text style={styles.text4}>
              <Text style={{fontWeight: "bold"}}>Distritos: </Text>
              Eugênio de Melo e São Francisco Xavier </Text>

            <Text style={styles.text4}>
              <Text style={{fontWeight: "bold"}}>Área: </Text>
              1.099,60km² </Text>

            <Text style={styles.text4}>
              <Text style={{fontWeight: "bold"}}>Altitude (cidade): </Text>
              Média de 600 metros</Text>

            <Text style={styles.text4}>
              <Text style={{fontWeight: "bold"}}>Vegetação: </Text>
              Vegetação nativa remanescente de mata atlântica, matas ciliares em trechos que acompanham as margens do Rio Paraíba do Sul e dos principais afluentes. Ocorre também algumas manchas de cerrado na região sul do município. </Text>

            <Text style={styles.text4}>
              <Text style={{fontWeight: "bold"}}>Relevo: </Text>
              A área do município situa-se no planalto atlântico e inclui subdivisões naturais em zonas, determinadas por feições morfológicas distintas: Serra da Mantiqueira, Médio Vale do Paraíba e Planalto de Paraitinga </Text>

          </SafeAreaView></Swiper></ScrollView>

          <ScrollView >
          <Swiper style={styles.wrapper2}>
          <SafeAreaView style={styles.slide2}>
            <Text style={styles.text5}>A Cidade</Text>

            <Text style={styles.text3}> 
              <Text style={{fontWeight: "bold"}}>São José dos Campos </Text>
               é um município brasileiro no interior do estado de São Paulo, conhecida como a Capital Brasileira da Tecnologia Aeroespacial. </Text>
            
            <Text style={styles.text2}>Une tradição, cultura e tecnologia</Text>
            <Text style={styles.text3}> No núcleo urbano estão localizados institutos federais de pesquisa científica, empresas de tecnologia de ponta, universidades, faculdades, centros de formação e muito mais. Por outro lado, a zona rural concentra quase 70% do território do município, boa parte em áreas de proteção ambiental. </Text>
            <Text style={styles.text2}>" Estamos localizados entre a serra e o mar "</Text>

          </SafeAreaView></Swiper></ScrollView>

          <ScrollView >
          <Swiper style={styles.wrapper3}>
          <SafeAreaView style={styles.slide3}>
            <Text style={styles.text5}>História</Text>

            <Text style={styles.text3}>No final do século 16, se formou a Aldeia do Rio Comprido, uma fazenda jesuítica que usava a atividade pecuarista para evitar incursões de bandeirantes. </Text>

            <Text style={styles.text4}>Porém, em 1611 a lei que regulamentava os aldeamentos indígenas por parte dos religiosos fez com que os jesuítas fossem expulsos.</Text>

            <Text style={styles.text4}>Os jesuítas voltaram anos mais tarde, estabelecendo-se em uma planície a 15 quilômetros de distância, onde hoje está a Igreja Matriz da cidade. </Text>

            <Image
              source={igrejaMatrizSJC}
              style={styles.igrejaMatrizSJC}
            />

            <Text style={styles.text4}>Em 1759, os jesuítas foram expulsos do Brasil, e todas as posses da ordem confiscadas por Portugal. Na mesma época, com o objetivo de aumentar a arrecadação provincial, a aldeia foi transformada em vila em 27 de julho de 1767 com o nome de São José do Paraíba, pelo governador de São Paulo, Luis Antonio de Souza Botelho Mourão.</Text>

            <Text style={styles.text4}>Em meados do século 19 o município passou a exibir sinais de crescimento econômico, graças à expressiva produção de algodão, exportado para a indústria têxtil inglesa.</Text>

            <Image
              source={tecelagemParahyba}
              style={styles.tecelagemParahyba}
            />

          </SafeAreaView></Swiper></ScrollView>
            
          <ScrollView>
          <Swiper style={styles.wrapper5}> 
          <SafeAreaView style={styles.slide4}>
            <Text style={styles.text5}>Fase Sanatorial</Text>
            
            <Text style={styles.text3}>Depois de ocupar posição periférica no período áureo do café no Vale do Paraíba, São José dos Campos ganhou destaque nacional na chamada fase sanatorial, quando inúmeros doentes procuravam o clima da cidade em busca de cura para a tuberculose.</Text>
            
            <Image
              source={vicentinoAranha}
              style={styles.vicentinoAranha}
            />
            
            <Text style={styles.text4}>Em 1924 foi inaugurado o Sanatório Vicentina Aranha, o maior do país. Somente em 1935, com os investimentos do governo de Getúlio Vargas e a transformação do município em estância climatérica e hidromineral, o município pôde investir em infraestrutura.</Text>
          </SafeAreaView></Swiper></ScrollView>          
        </Swiper>
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
    
    helenaName: {
      textAlign: 'center',
      fontSize: 30,
      color: '#000000',
      marginTop: 55,
    },
    text: {
      textAlign: 'center',
      fontSize: 22,
      color: '#000000',
      marginTop: -80,
      marginLeft: 16,
      marginRight: 16,
    },
    sjcFoto:{
      height: 240,
      width: 380,
      marginTop: 10,
      justifyContent: 'center',
      alignItems: 'center',
    },
    igrejaMatrizSJC:{
      height: 240,
      width: 380,
      marginBottom: -5,
      marginTop: 15,
      justifyContent: 'center',
      alignItems: 'center',
    },
    tecelagemParahyba:{
      height: 240,
      width: 380,
      marginBottom: -10,
      marginTop: 22,
      justifyContent: 'center',
      alignItems: 'center',
    },
    vicentinoAranha:{
      height: 240,
      width: 380,
      marginBottom: 10,
      marginTop: 22,
      justifyContent: 'center',
      alignItems: 'center',
    },
    sjcFoto15:{
      height: 240,
      width: 380,
      marginBottom: -20,
      marginTop: 50,
      justifyContent: 'center',
      alignItems: 'center',
    },
    text1: {
      flex: 0.7,
      textAlign: 'center',
      fontSize: 30,
      color: '#000000',
      marginLeft: 8,
      marginRight: 8,
      marginTop: 48,
    },
    text2: {
      textAlign: 'center',
      fontSize: 21,
      color: '#511789',
      marginTop: 30,
      marginBottom: -25,
      marginLeft: 16,
      marginRight: 16,
      fontWeight: "bold",
    },
    text3: {
      textAlign: 'center',
      fontSize: 20.5,
      color: '#000000',
      marginTop: 55,
      marginLeft: 16,
      marginRight: 16,
    },
    //#c19de3
    text4: {
      textAlign: 'center',
      fontSize: 20.5,
      color: '#000000',
      marginTop: 20,
      marginLeft: 16,
      marginRight: 16,
    },
    text5: {
      fontSize: 27,
      color: '#511789',
      marginTop: 15,
      marginBottom: -32,
      marginLeft: 16,
      marginRight: 16,
      fontWeight: "bold",
    },
    text6: {
      fontSize: 27,
      color: '#511789',
      marginTop: 15,
      marginBottom: -80,
      marginLeft: 16,
      marginRight: 16,
      fontWeight: "bold",
    },
    text7: {
      textAlign: 'center',
      fontSize: 25,
      color: '#000000',
      marginTop: 40,
      marginBottom: -15,

      marginLeft: 16,
      marginRight: 16,

    },
    
    lunchexample: {
      textAlign: 'center',
      fontSize: 30,
      color: '#000000',
      margin: 8,
    },
    timetext: {
      textAlign: 'center',
      fontSize: 30,
      color: '#511789',
      marginTop: 16,
    },
    wrapper: {
      height: 630,
      marginTop: -5,
    },
    wrapper1: {
      height: 3663,
      marginTop: -5,
    },
    wrapper2: {
      height: 680,
    },
    wrapper3: {
      height: 1470,
    },
    wrapper4: {
      height: 1320,
    },

    wrapper5: {
      height: 840,
    },


    slide1: {
      flex: 1,
      justifyContent: 'flex-start',
      alignItems: 'center',
      width: 380,
      height: 50,
      backgroundColor: '#FFFFFF',
      borderRadius: 20,
      marginTop: 25,
    },

    slide1_5: {
      flex: 1,
      justifyContent: 'flex-start',
      alignItems: 'center',
      width: 380,
      height: 50,
      backgroundColor: '#FFFFFF',
      borderRadius: 20,
      marginTop: 20,
    },

    slide2: {
      flex: 1,
      justifyContent: 'flex-start',
      alignItems: 'center',
      width: 380,
      height: 50,
      backgroundColor: '#FFFFFF',
      borderRadius: 20,
      marginTop: 20,

    },
    slide3: {
      flex: 1,
      justifyContent: 'flex-start',
      alignItems: 'center',
      width: 380,
      height: 50,
      backgroundColor: '#FFFFFF',
      borderRadius: 20,
      marginTop: 20,

    },
    slide4: {
      flex: 1,
      justifyContent: 'flex-start',
      alignItems: 'center',
      width: 380,
      height: 50,
      backgroundColor: '#FFFFFF',
      borderRadius: 20,
      marginTop: 20,

    },
    text: {
      color: '#fff',
      fontSize: 30,
      fontWeight: 'bold',
    },
    
    titulo:{
    },

    title: {
        textAlign: 'center',
        fontSize: 26,
        color: 'white',
        marginTop: 4,
        marginLeft: 16,
        marginRight: 16,
      },

      slideroxo: {
        flexDirection: 'column',
        justifyContent: 'center',
        marginLeft: -20,
        marginTop: -80,
        width: 420,
        height: 77,
        backgroundColor: '#9867C5',
      },
      slideblack: {
      flex: 1,
      justifyContent: 'flex-start',
      alignItems: 'center',
      width: 400,
      height: 50,
      backgroundColor: 'black',
      marginTop: 30,
      }
});