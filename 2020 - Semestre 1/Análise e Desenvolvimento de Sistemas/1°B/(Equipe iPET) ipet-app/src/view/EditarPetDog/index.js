import React, { useState, useEffect } from 'react';
import { 
StyleSheet,
Text,
ScrollView,
View,
TouchableHighlight,
AsyncStorage,
ActivityIndicator
} from 'react-native';
import api from '../../services/api';
import { TextInput } from 'react-native-paper';
import { CheckBox } from 'react-native-elements'

export default function EditPet({ navigation }) {

    const { petId } = navigation.state.params

    const [ user, setUser ] = useState()
    const [ name, setName ] = useState()
    const [ type, setType ] = useState()
    const [ color, setColor ] = useState()
    const [ age, setAge ] = useState()
    const [ born, setBorn ] = useState()
    const [ breed, setBreed ] = useState()
    const [ castrationDate, setCastrationDate ] = useState()
    const [ disease, setDisease ] = useState()
    const [ loading, setLoading ] = useState(false)

    useEffect(() => {
        async function getPet () {
          const response = await api.get(`/pet/show/${petId}`)
    
          setName(response.data.name)
          setType(response.data.type)
          setColor(response.data.color)
          setAge(response.data.age)
          setBorn(response.data.born)
          setBreed(response.data.breed)
          setCastrationDate(response.data.castrationDate)
          setDisease(response.data.disease)  
        }
    
        getPet()
    
      }, [])

    useEffect(() => {
        async function getUser() {
            const id = await AsyncStorage.getItem('@ipet:userId')

 
                const response = await api.get(`/user/${id}`)
                setUser(response.data.name)

        }
        getUser()
    }, [])

    const optionsDog = [
        {
            'id': 1,
            'doenca': 'Raiva Canina'
        },
        {
            'id': 2,
            'doenca': 'Cinomose'
        },
        {
            'id': 3,
            'doenca': 'Doença Periodental'
        },
        {
            'id': 4,
            'doenca': 'Parvovirose'
        },
        {
            'id': 5,
            'doenca': 'Câncer'
        },
        {
            'id': 6,
            'doenca': 'Leptospirose'
        },
        {
            'id': 7,
            'doenca': 'Hepatite Infecciosa Canina'
        },
        {
            'id': 8,
            'doenca': 'Sarna'
        },
        {
            'id': 9,
            'doenca': 'Taxoplasmose'
        },
        {
            'id': 10,
            'doenca': 'Coronavírus'
        },
        {
            'id': 11,
            'doenca': 'Hepatite'
        },
        {
            'id': 12,
            'doenca': 'Parvovírus'
        },
        {
            'id': 13,
            'doenca': 'Displasia de Quadril'
        },
        {
            'id': 14,
            'doenca': 'Reumatismo'
        },
        {
            'id': 15,
            'doenca': 'Epilepsia'
        },
        {
            'id': 16,
            'doenca': 'Periodontite'
        },
        {
            'id': 17,
            'doenca': 'Piometra'
        },
        {
            'id': 18,
            'doenca': 'Torção Gástrica'
        },
        {
            'id': 19,
            'doenca': 'Alergias Cutâneas'
        },
        {
            'id': 20,
            'doenca': 'Diabetes'
        },
        {
            'id': 21,
            'doenca': 'Criptorquidia'
        },
        {
            'id': 22,
            'doenca': 'Otite'
        }
    ]

    const optionsCat = [
        {
            'id': 1,
            'doenca': 'Clamidiose'
        },
        {
            'id': 2,
            'doenca': 'Raiva Felina'
        },
        {
            'id': 3,
            'doenca': 'Insuficiência Renal Crônica'
        },
        {
            'id': 4,
            'doenca': 'Peritonite Infecciosa Felina'
        },
        {
            'id': 5,
            'doenca': 'Vírus da Imunodeficiência Felina'
        },
        {
            'id': 6,
            'doenca': 'Rinotraqueíte Viral - Gripe de gato'
        },
        {
            'id': 7,
            'doenca': 'Leucemia Felina'
        },
        {
            'id': 8,
            'doenca': 'Panleucopenia Felina'
        },
        {
            'id': 9,
            'doenca': 'Rinotraqueite Felina'
        },
        {
            'id': 10,
            'doenca': 'Calicivirose'
        },
        {
            'id': 11,
            'doenca': 'Pneumonite'
        },
        {
            'id': 12,
            'doenca': 'Alergia'
        },
        {
            'id': 13,
            'doenca': 'Conjutivite'
        },
        {
            'id': 14,
            'doenca': 'Doença Periodenta'
        },
        {
            'id': 15,
            'doenca': 'Otite'
        },
        {
            'id': 16,
            'doenca': 'Obesidade e Peso Excessivo'
        },
        {
            'id': 17,
            'doenca': 'Gripe Felina'
        }
    ]


    async function handlePet () {
        setLoading(true)
        const id = await AsyncStorage.getItem('@ipet:userId')
        try {
            const response = await api.put(`/pet/update/${petId}`, {
                name,
                type,
                color,
                age, 
                born,
                breed,
                disease,
                castrationDate,
                owner: user,
                ownerId: id     
            })
            navigation.push('Home')
            
        } catch (error) {
            setLoading(false)
            console.log(error)    
        }
    }

  return (
    <ScrollView style={styles.container}>
        <View style={{ justifyContent: 'center', alignItems: 'center' }}>
            <TextInput style={{ backgroundColor:'#8D99AE', borderColor: '#FFFFFF', width: '90%' }}
            label="Nome do Pet"
            mode="outlined"
            value={name}
            onChangeText={(value) => setName(value)}
            />

            <TextInput style={{ backgroundColor:'#8D99AE', borderColor: '#FFFFFF', width: '90%' }}
            label="Tipo (Cão ou Gato)"
            mode="outlined"
            value={type}
            onChangeText={(value) => setType(value)}
            />

            <TextInput style={{ backgroundColor:'#8D99AE', borderColor: '#FFFFFF', width: '90%' }}
            label="Cor do Pet"
            mode="outlined"
            value={color}
            onChangeText={(value) => setColor(value)}
            />
            
            <TextInput style={{ backgroundColor:'#8D99AE', borderColor: '#FFFFFF', width: '90%' }}
            label="Idade"
            mode="outlined"
            value={age}
            onChangeText={(value) => setAge(value)}
            />
            
            <TextInput style={{ backgroundColor:'#8D99AE', borderColor: '#FFFFFF', width: '90%' }}
            label="Data de Nascimento"
            mode="outlined"
            value={born}
            onChangeText={(value) => setBorn(value)}
            />
            
            <TextInput style={{ backgroundColor:'#8D99AE', borderColor: '#FFFFFF', width: '90%' }}
            label="Raça"
            mode="outlined" 
            value={breed}
            onChangeText={(value) => setBreed(value)}
            />
            
            <TextInput style={{ backgroundColor:'#8D99AE', borderColor: '#FFFFFF', width: '90%' }}
            label="Data de Castração"
            mode="outlined"
            value={castrationDate}
            onChangeText={(value) => setCastrationDate(value)}
            />

            <TextInput style={{ backgroundColor:'#8D99AE', borderColor: '#FFFFFF', width: '90%' }}
            label="Patologias"
            mode="outlined"
            value={disease}
            onChangeText={(value) => setDisease(value)}
            />
            {
              loading ? <ActivityIndicator size="small" color="#EF233C" style={{ marginTop:20 }} />
              : 
                <TouchableHighlight style={[ styles.btnCadastrarPet ]}
                onPress={() => handlePet()}>
                    <Text style={{ color:"#FFFFFF" }}> Atualizar Dados iPet </Text>
                </TouchableHighlight>
            }
            
        </View>
    </ScrollView>
    );
}

    const styles = StyleSheet.create({
        container: {
            flex: 1,
            backgroundColor: '#8D99AE',
            paddingTop: 20
        },
        
        btnCadastrarPet: {
        width:"90%",
        height:47,
        backgroundColor:"#EF233C",
        justifyContent:"center",
        alignItems:"center",
        borderWidth:1,
        borderColor:"#2B2D42",
        borderRadius:7,
        marginTop:20,
        marginBottom: 30
        },

        container2: {
            flex: 1,
            backgroundColor: '#FFF',
            width:"70%",
            marginTop:10,
            borderRadius:5
        },

        button2: {
            backgroundColor: "#2B2D42",
            width:20,
            borderRadius:50
        }
    }
);