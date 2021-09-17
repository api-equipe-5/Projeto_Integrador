import React, { useState } from 'react';
import {useHeaderHeight} from '@react-navigation/stack';
import { View, Text, TextInput, StyleSheet } from 'react-native';
import Button from '../../components/Button';
import RadioForm, {RadioButton, RadioButtonInput, RadioButtonLabel} from 'react-native-simple-radio-button';

// import { Container } from './styles';

const measures = [
  {
      "id": 1,
      "gender": "masculino",
      "brazilSize": 36,
      "euaSize": 6,
      "europeSize": 38
  },
  {
      "id": 2,
      "gender": "masculino",
      "brazilSize": 37,
      "euaSize": 6.5,
      "europeSize": 39
  },
  {
      "id": 3,
      "gender": "masculino",
      "brazilSize": 38,
      "euaSize": 7,
      "europeSize": 40
  },
  {
      "id": 4,
      "gender": "masculino",
      "brazilSize": 39,
      "euaSize": 7.5,
      "europeSize": "40-41"
  },
  {
      "id": 5,
      "gender": "masculino",
      "brazilSize": 39,
      "euaSize": 8,
      "europeSize": 41
  },
  {
      "id": 6,
      "gender": "masculino",
      "brazilSize": 40,
      "euaSize": 8.5,
      "europeSize": "41-42"
  },
  {
      "id": 7,
      "gender": "masculino",
      "brazilSize": 40,
      "euaSize": 9,
      "europeSize": 42
  },
  {
      "id": 8,
      "gender": "masculino",
      "brazilSize": 41,
      "euaSize": 9.5,
      "europeSize": "42-43"
  },
  {
      "id": 9,
      "gender": "masculino",
      "brazilSize": 41,
      "euaSize": 10,
      "europeSize": 43
  },
  {
      "id": 10,
      "gender": "masculino",
      "brazilSize": 42,
      "euaSize": 10.5,
      "europeSize": "43-44"
  },
  {
      "id": 11,
      "gender": "masculino",
      "brazilSize": 42,
      "euaSize": 11,
      "europeSize": 44
  },
  {
      "id": 12,
      "gender": "masculino",
      "brazilSize": 43,
      "euaSize": 11.5,
      "europeSize": "44-45"
  },
  {
      "id": 13,
      "gender": "masculino",
      "brazilSize": 43,
      "euaSize": 12,
      "europeSize": 45
  },
  {
      "id": 14,
      "gender": "masculino",
      "brazilSize": 44,
      "euaSize": 13,
      "europeSize": 46
  },
  {
      "id": 15,
      "gender": "masculino",
      "brazilSize": 45,
      "euaSize": 14,
      "europeSize": 47
  },
  {
      "id": 16,
      "gender": "masculino",
      "brazilSize": 46,
      "euaSize": 15,
      "europeSize": 48
  },
  {
      "id": 17,
      "gender": "masculino",
      "brazilSize": 48,
      "euaSize": 16,
      "europeSize": 49
  },
  {
      "id": 18,
      "gender": "feminino",
      "brazilSize": 33,
      "euaSize": 4,
      "europeSize": 35
  },
  {
      "id": 18,
      "gender": "feminino",
      "brazilSize": 33,
      "euaSize": 4.5,
      "europeSize": 35
  },
  {
      "id": 18,
      "gender": "feminino",
      "brazilSize": 34,
      "euaSize": 5,
      "europeSize": "35-36"
  },
  {
      "id": 18,
      "gender": "feminino",
      "brazilSize": 34,
      "euaSize": 5.5,
      "europeSize": 36
  },
  {
      "id": 18,
      "gender": "feminino",
      "brazilSize": 35,
      "euaSize": 6,
      "europeSize": "36-37"
  },
  {
      "id": 18,
      "gender": "feminino",
      "brazilSize": 35,
      "euaSize": 6.5,
      "europeSize": 37
  },
  {
      "id": 18,
      "gender": "feminino",
      "brazilSize": 36,
      "euaSize": 7,
      "europeSize": "37-38"
  },
  {
      "id": 18,
      "gender": "feminino",
      "brazilSize": 36,
      "euaSize": 7.5,
      "europeSize": 38
  },
  {
      "id": 18,
      "gender": "feminino",
      "brazilSize": 37,
      "euaSize": 8,
      "europeSize": "38-39"
  },
  {
      "id": 18,
      "gender": "feminino",
      "brazilSize": 7,
      "euaSize": 8.5,
      "europeSize": 39
  },
  {
      "id": 18,
      "gender": "feminino",
      "brazilSize": 38,
      "euaSize": 9,
      "europeSize": "39-40"
  },
  {
      "id": 18,
      "gender": "feminino",
      "brazilSize": 38,
      "euaSize": 9.5,
      "europeSize": 40
  },
  {
      "id": 18,
      "gender": "feminino",
      "brazilSize": 39,
      "euaSize": 10,
      "europeSize": "40-41"
  },
  {
      "id": 18,
      "gender": "feminino",
      "brazilSize": 39,
      "euaSize": 10.5,
      "europeSize": 41
  },
  {
      "id": 18,
      "gender": "feminino",
      "brazilSize": 40,
      "euaSize": 11,
      "europeSize": "41-42"
  },
  {
      "id": 18,
      "gender": "feminino",
      "brazilSize": 40,
      "euaSize": 11.5,
      "europeSize": 42
  },
  {
      "id": 18,
      "gender": "feminino",
      "brazilSize": 41,
      "euaSize": 12,
      "europeSize": "42-43"
  }
];

const radioProps = [
  {label: 'Masculino', value: 'masculino' },
  {label: 'Feminino', value: 'feminino' }
];

const radioCountryProps = [
  {label: 'Brasil', value: 'BR' },
  {label: 'EUA', value: 'EUA' },
  {label: 'Europa', value: 'EU' }
];

const ConversorMedidas = () => {
  const headerHeight = useHeaderHeight();

  const [filter, setFilter] = useState({
    size: null,
    gender: null,
    country: null,
  });

  const [result, setResult] = useState('');

  function onChangeSize(size) {
    setFilter(oldFilters => ({
      ...oldFilters,
      size: size.replace(/[- #*;,<>\{\}\[\]\\\/]/gi, '')
    }))
  }
  function onChangeGender(gender) {
    setFilter(oldFilters => ({
      ...oldFilters,
      gender
    }))
  }

  function onChangeCountry(country) {
    setFilter(oldFilters => ({
      ...oldFilters,
      country
    }))
  }

  function handleClickButton() {

    let countryKeyFind = null;

    if (filter.country === 'EUA')
      countryKeyFind = 'euaSize';
    
    if (filter.country === 'EU')
      countryKeyFind = 'europeSize';

    if (filter.country === 'BR')
      countryKeyFind = 'brazilSize';

    const obj = measures.find(measure => measure[countryKeyFind] == filter.size && measure.gender == filter.gender);

    if (!obj) {
      setResult('Informe uma busca válida');
      return;
    }

    setResult(`Brasil: ${obj.brazilSize} | EUA: ${obj.euaSize} | Europa: ${obj.europeSize}`);
  }

  return (
    <View style={{...styles.container, marginTop: headerHeight}}>
      <Text style={styles.rodape}>Conversor de Tênis! </Text>
      <View style={styles.content}>
        <Text style={styles.text}>Tamanho</Text>
        <RadioForm style={styles.radioForm} formHorizontal={true} animation={true}>
          {radioCountryProps.map((obj, i) => (
            <RadioButton labelHorizontal={true} key={i} >
              <RadioButtonInput
                obj={obj}
                index={i}
                isSelected={filter.country === obj.value}
                onPress={onChangeCountry}
                borderWidth={1}
                buttonInnerColor={'#FFFFFF'}
                buttonOuterColor={'#FFFFFF'}
                buttonSize={25}
                buttonOuterSize={40}
                buttonStyle={{}}
                buttonWrapStyle={{marginLeft: 10}}
              />
              <RadioButtonLabel
                obj={obj}
                index={i}
                labelHorizontal={true}
                onPress={onChangeCountry}
                labelStyle={{fontSize: 20, color: '#FFFFFF'}}
                labelWrapStyle={{}}
              />
            </RadioButton>
          ))}
        </RadioForm>
        <TextInput
          style={styles.input}
          value={filter.size}
          onChangeText={onChangeSize}
          placeholder="Informe o tamanho do calçado"
          keyboardType="numeric"
          maxLength={3}
        />
        
        <Text style={styles.text}>Gênero</Text>
        <RadioForm style={styles.radioForm} formHorizontal={true} animation={true}>
          {radioProps.map((obj, i) => (
            <RadioButton labelHorizontal={true} key={i} >
              <RadioButtonInput
                obj={obj}
                index={i}
                isSelected={filter.gender === obj.value}
                onPress={onChangeGender}
                borderWidth={1}
                buttonInnerColor={'#FFFFFF'}
                buttonOuterColor={'#FFFFFF'}
                buttonSize={25}
                buttonOuterSize={40}
                buttonStyle={{}}
                buttonWrapStyle={{marginLeft: 10}}
              />
              <RadioButtonLabel
                obj={obj}
                index={i}
                labelHorizontal={true}
                onPress={onChangeGender}
                labelStyle={{fontSize: 20, color: '#FFFFFF'}}
                labelWrapStyle={{}}
              />
            </RadioButton>
          ))}
        </RadioForm>
        <Button text="Converter" onPress={handleClickButton} />
        {result ? (
          <View style={styles.resultContent}>
            {result.split(" | ").map((item, index) => (
              <Text key={index} style={styles.resultText}>{item}</Text>
            ))}
          </View>
        ) : null}
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1
  },
  content: {
    margin: 16,
    flex: 1,
  },
  text: {
    fontSize: 26,
    color: "#FFFFFF",
    textAlign: 'center',
    fontWeight: 'bold',
    marginTop: -15
  },
  radioForm: {
    justifyContent: 'center',
    marginVertical: 20
  },
  resultContent: {
    padding: 10,
    backgroundColor: "#FFFFFF",
    borderRadius: 10,
    marginTop: 20
  },
  resultText: {
    fontSize: 30,
    color: "#000000",
    textAlign: "center"
  },
  rodape: {
    textAlign: 'center',
    fontWeight: "bold",
    fontSize: 30,
    color: 'white',
    marginTop: -5,
    marginBottom: 50,
    marginLeft: 16,
    marginRight: 16,
  },
  input: {
    height: 60,
    marginBottom: 38,
    borderWidth: 1,
    borderRadius: 20,
    backgroundColor: "#FFFFFF",
    color: "#000000",
    paddingHorizontal: 20,
    fontSize: 22,
    textAlign: 'center'
  }
})

export default ConversorMedidas;
