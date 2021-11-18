import React, { useEffect, useState } from 'react'
import {
    View,
    Text,
    ScrollView,
    TouchableHighlight,
    StyleSheet,
    AsyncStorage 
} from 'react-native'
import { AntDesign } from '@expo/vector-icons';
import { Fontisto } from '@expo/vector-icons';
import api from '../../services/api';
import styled from 'styled-components/native'
import { Container } from 'native-base'
import moment from 'moment'

export default function Parasiting({ navigation }){
  const {petId} = navigation.state.params;
  const [parasitings, setParasiting] = useState([])

  useEffect(() => {
    async function getParasiting () {
      const userId = await AsyncStorage.getItem('@ipet:userId')
      
      const response = await api.get(`/parasiting/${petId}`)

      setParasiting(response.data)
    }

    getParasiting()

  }, [])

  async function deleteParasiting (id) {
    const response = await api.delete(`/parasiting/delete/${id}`)

    navigation.goBack()
  }

  return (
    <Container style={{ margin: 0 }}>
      <ScrollView style={ styles.container }>
        <Row>
          {
            parasitings.length < 1 ? 
            <View style={{ justifyContent: "center", alignItems: "center", display: "flex" }}>
              <Fontisto name="injection-syringe" size={52} color="white" />
              <Text style={{ color: "#FFFFFF" }}> Não possui parasitário cadastrado </Text>
            </View>
            :
            parasitings.map(parasiting => (
              <Box key={parasiting._id}>
                <View style={{ width: "90%" }}>
                  <Text style={ styles.parasitingName }>{ parasiting.name } </Text>
                  <Text style={ styles.parasitingDates }>
                    { moment(parasiting.parasitingDate).format('DD/MM/YYYY ') }- 
                    { moment(parasiting.returningDate).format(' DD/MM/YYYY') }
                  </Text>
                </View>
                <Fontisto name="trash" size={20} color="grey" 
                  onPress={() => deleteParasiting(parasiting._id)}
                />
              </Box>  
            ))
          }        
        </Row>   
      </ScrollView>  
        <AddButton style={{ position: "absolute" }} onPress={() => navigation.push('CadParasitario', { petId })}>
            <AntDesign name="plus" size={24} color="black" />
        </AddButton>
    </Container>    

  )
}

const Box = styled.View`
    background-color: #FFFFFF;
    width: 95%;
    height: 70px;
    border-radius: 7px;
    margin: 2%;
    box-shadow: 5px 5px 5px rgba(0,0,0,0.24);
    justify-content: center;
    display: flex;
    padding: 5%;
    flex-direction: row;
`;

const Row = styled.View`
    display: flex;
    flex-direction: column;
`;

const AddButton = styled.TouchableHighlight`
        align-items: center;
        justify-content: center;
        align-self: flex-end;
        width: 70px;                                      
        bottom: 70px;                                            
        right: 20px;
        height: 70px;
        background-color: #FFFFFF;
        border-radius: 100px;
        box-shadow: 2px 2px 2px rgba(0,0,0,0.24);
`;


const styles = StyleSheet.create({
    container: {
        backgroundColor: "#8D99AE",
        padding: '3%'
    },
    vaccineName: { 
        textAlign: 'left'
    },
    vaccineDates: {
        textAlign: 'left',
        color: '#A1A1A1',
        fontSize: 13
    }
});