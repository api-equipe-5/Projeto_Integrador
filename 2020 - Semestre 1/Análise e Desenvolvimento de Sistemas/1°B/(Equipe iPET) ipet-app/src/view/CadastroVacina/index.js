import React, { useState, useEffect } from 'react';
import { StyleSheet, Text, View, Image, TouchableHighlight} from 'react-native';
import api from '../../services/api';
import { TextInput } from 'react-native-paper';

export default function App({ navigation }) {

  const { petId } = navigation.state.params;
  const [ petName, setPetName ] = useState()
  const [ name, setName ] = useState()
  const [ vaccinationDate, setVaccinationDate ] = useState()
  const [ returningDate, setReturningDate ] = useState()

  useEffect(() => {
    async function loadInfos () {
      console.log(petId)
      const response = await api.get(`/pet/show/${petId}`)

      setPetName(response.data.name)
    }
    loadInfos()
  }, [])
  

  async function handleVaccine() {

    const vaccD = vaccinationDate.split('/')[0]
    const vaccM = vaccinationDate.split('/')[1]
    const vaccY = vaccinationDate.split('/')[2]
    const completeDate = vaccM + '/' + vaccD + '/' + vaccY

    const retD = returningDate.split('/')[0]
    const retM = returningDate.split('/')[1]
    const retY = returningDate.split('/')[2]
    const completeReturning = retM + '/' + retD + '/' + retY

    try {
      const response = await api.post('/vaccinate/create', {
        name,
        petId,
        petName,
        vaccinationDate: completeDate,
        returningDate: completeReturning
      })

      console.log(response.data)
      navigation.push('Home', { petId })
    } catch (error) {
      console.log(error)
    }
    
  }


  return (
    <View style={styles.container}>
      <View style={styles.container2}>

      <Text style={{fontSize:20, marginBottom:15}}>Adicionar uma Vacina:</Text> 

      <TextInput style={styles.Input}
      label="Nome da Vacina"
      mode="outlined"
      onChangeText={(value) => setName(value)}
      ></TextInput>

      <TextInput style={styles.Input}
      label="Data da Vacina"
      mode="outlined"
      onChangeText={(value) => setVaccinationDate(value)}
      ></TextInput>

      <TextInput style={styles.Input}
      label="Data para Revacinar"
      mode="outlined"
      onChangeText={(value) => setReturningDate(value)}
      ></TextInput>

      <TouchableHighlight style={[styles.btnGeneral]}
      onPress={() => handleVaccine()}>
        <Text style={{color: "#FFFFFF", fontSize:17}}> Salvar Dados </Text>
      </TouchableHighlight>

      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#8D99AE',
    alignItems: 'center',
    justifyContent: 'center'
  },

  container2: {
    flex: 1,
    backgroundColor: '#ffffff',
    alignItems: 'center',
    justifyContent: 'center',
    width: "90%",
    maxHeight: "60%",
    borderRadius: 10,
    marginBottom: 150
  },


  btnGeneral: {
    width: "80%",
    height: 47,
    borderWidth: 1,
    borderColor: "#2B2D42",
    borderRadius: 7,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "#EF233C",
    marginTop: 40
  },

  Input: {
   width: "90%",
   height: 47,
   marginTop: 10,
   backgroundColor: "#ffffff",
   borderRadius: 7,
   marginBottom: 10
  },

});