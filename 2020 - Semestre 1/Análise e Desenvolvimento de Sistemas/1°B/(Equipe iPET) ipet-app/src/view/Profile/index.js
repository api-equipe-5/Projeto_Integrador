import React, { useState, useEffect } from 'react';
import { 
  StyleSheet,
  Text,
  View,
  Image,
  TouchableHighlight
} from 'react-native';
import { AntDesign } from '@expo/vector-icons';
import { Fontisto } from '@expo/vector-icons';
import { Entypo } from '@expo/vector-icons';
import logo from '../../../assets/logo.png'
//import photo from '../../../assets/photo.png'
import moment from 'moment'

import styled from 'styled-components/native'
import api from '../../services/api';
 
export default function Index({ navigation }) {

  const { petId } = navigation.state.params;

  
  const [ name, setName ] = useState()
  const [ type, setType ] = useState()
  const [ color, setColor ] = useState()
  const [ age, setAge ] = useState()
  const [ breed, setBreed ] = useState()
  const [ castrationDate, setCastrationDate ] = useState()
  const [ disease, setDisease ] = useState()


  useEffect(() => {
    async function getPet () {
      const response = await api.get(`/pet/show/${petId}`)

      setName(response.data.name)
      setType(response.data.type)
      setColor(response.data.color)
      setAge(response.data.age)
      setBreed(response.data.breed)
      setCastrationDate(response.data.castrationDate)
      setDisease(response.data.disease)

      console.log(castrationDate, response.data.castrationDate)

    }

    getPet()

  }, [])
  

  return (
    <View style={styles.container}>
      <View style={styles.container2}>
        <View style={styles.container3}>
          <Image source={logo} style={ styles.logo } />
          <Text style={{ fontWeight: "bold", fontSize: 19, marginBottom: 20 }}> {name}</Text>
          <Text>Tipo: {type}</Text>
          <Text>Cor: {color}</Text>
          <Text>Idade: {age}</Text>
          <Text>Raça: {breed}</Text>
          {
            !castrationDate == '-' ?
            <Text>Castração: { moment(castrationDate).format('MM/DD/YYYY') } </Text> 
            : <Text>Castração: { castrationDate } </Text> 
          }
          
          <Text>Patologias : {disease}</Text>
          
   
        </View>
      </View>
      
      <SmallBtn style={ styles.vaccine }
        onPress={() => navigation.navigate('Vermifugo', {petId})}
      >
        <Entypo name="dots-three-horizontal" size={16} color="white" /> 
      </SmallBtn>
      <SmallBtn style={ styles.parasiting }
        onPress={() => navigation.navigate('Parasitario', {petId})}
      > 
        <Entypo name="bug" size={16} color="white" />
      </SmallBtn>
      <SmallBtn style={ styles.vermifuge }
        onPress={() => navigation.push('Vacinas', { petId })}
      > 
        <Fontisto name="injection-syringe" size={16} color="white" />
      </SmallBtn>

      <SmallBtn style={ styles.pen }
        onPress={() => navigation.navigate('UpdateDog', {petId})}
      >
        <Entypo name="edit" size={16} color="white" /> 
      </SmallBtn>
    </View>
  );
}

const SmallBtn = styled.TouchableHighlight`
        align-items: center;
        justify-content: center;
        width: 30px;
        position: absolute;                                                                                  
        right: 30px;
        height: 30px;
        background-color: #8D99AE;
        border-radius: 100px;
        box-shadow: 2px 2px 2px rgba(0,0,0,0.24);
`;
 
const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#8D99AE',
    alignItems: 'center',
    justifyContent: 'center',
  },
 
  container2: {
    flex: 1,
    backgroundColor: '#FFFFFF',
    alignItems: 'center',
    justifyContent: 'center',
    width: '95%',
    maxHeight: '95%',
    borderRadius: 15
  },
 
  container3: {
    flex: 1,
    backgroundColor: "#FFFFFF",
    alignItems: 'center',
    justifyContent: 'center',
    width: "80%",
    maxHeight: "50%",
    marginBottom: 150
  },
 
  photo: {
    width: 155,
    height: 155,
    borderRadius: 30,
    marginBottom: 40,
    borderWidth: 1,
    borderColor: "#2B2D42",
    backgroundColor: "#FFFFFF"
  },
 
  vaccine: {
    bottom: 50
  },

  parasiting: {
    bottom: 90,
  },

  vermifuge: {
    bottom: 125
  },

  pen: {
    top: 40
  },

  logo: {
    width: 155,
    height: 155,
    borderRadius: 100,
    marginBottom: 70
}
});