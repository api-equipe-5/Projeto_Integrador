import React, { useState } from 'react';
import {StyleSheet, TouchableHighlight, View, Image, Text, AsyncStorage} from 'react-native'
import { TextInput, BottomNavigation } from 'react-native-paper';
import logo from '../../../assets/logo.png'

export default function Login({navigation}) {

  return (

<View style={ styles.container} >
    <Image source={logo} style={ styles.logo }> 
        </Image>

    <TextInput
    style ={ styles.input }
    label = 'Senha'
    mode = 'outlined'
        />
    
    <TextInput
    style ={ styles.input }
    label = 'Nova senha'
    mode = 'outlined'
        />
    
    <TextInput
    style ={ styles.input }
    label = 'Confirme a nova senha'
    mode = 'outlined'
        />

    <TouchableHighlight style={[ styles.btnRegistro, styles.btnGeneral ]}>
        <Text style ={{ color: '#FFF' } }> Salvar senha </Text>
    </TouchableHighlight>

</View>

)}


const styles = StyleSheet.create({ 
    logo: {
      width: 150,
      height: 150,
      marginTop: 50
    },

    container: {
      flex: 1,
      backgroundColor: '#8D99AE',
      alignItems: 'center',
      justifyContent: 'center',
    },

    input: {
      marginTop: 17,
      textAlignVertical: 'center',
      color: '#FFFFFF',
      fontSize: 16,
      height: 47,
      width: "90%"
     },

    btnGeneral: {
      width: "90%",
      height: 47,
      borderWidth: 1,
      borderColor: "#2B2D42",
      borderRadius: 7,
      justifyContent: "center",
      alignItems: "center"
     },

    text: {
      textAlign: "center",
      color: "#FFFFFF",
      fontSize: 16,
      marginTop: 50
      },
    
    btnRegistro: {
      backgroundColor: "#EF233C",
      marginTop: 17
    },
})