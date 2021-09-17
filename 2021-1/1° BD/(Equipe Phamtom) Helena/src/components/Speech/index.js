import React, {useEffect, useState} from 'react';
import {StyleSheet, View, Text, TouchableOpacity} from 'react-native';

import {HelenaActions} from '../../configs/helenaActions';

import * as Permissions from 'expo-permissions';

import Voice from '@react-native-voice/voice';

import {MaterialCommunityIcons} from '@expo/vector-icons';

export default function Speech() {
  const [showRecordButton, setShowRecordButton] = useState(false);
  const [isRecording, setIsRecording] = useState(false);
  const [text, setText] = useState([]);

  let timer = null;

  function onSpeechStart(e) {
    console.log('onSpeechStart: ', e);
    setIsRecording(true);
    setText([]);
  }

  function onSpeechResults(e) {
    setIsRecording(false);
    console.log('onSpeechResults: ', e);
    const {value} = e;

    setText(value);

    const arrayWords = value.map(v => v.toLowerCase());
    console.log('arrayWords', arrayWords);

    const actionFinded = HelenaActions.find(action => {
      const words = action.words;
      const textSpeechIncludesInArray = words.some(word =>
        arrayWords.includes(word.toLowerCase()),
      );
      return textSpeechIncludesInArray;
    });

    console.log('actionFinded', actionFinded);

    if (!actionFinded) {
      return;
    }

    timer = setTimeout(() => {
      actionFinded.handler();
    }, 1 * 0);
  }

  function onSpeechEnd(e) {
    console.log('onSpeechEnd: ', e);
  }

  function onSpeechError(e) {
    setIsRecording(false);
    console.log('onSpeechError: ', e);
  }

  useEffect(() => {
    Voice.onSpeechStart = onSpeechStart;
    Voice.onSpeechEnd = onSpeechEnd;
    Voice.onSpeechError = onSpeechError;
    Voice.onSpeechResults = onSpeechResults;

    return () => {
      clearTimeout(timer);
      Voice.destroy().then(Voice.removeAllListeners);
    };
  }, []);

  useEffect(() => {
    async function requestPermissions() {
      const {status} = await Permissions.askAsync(Permissions.AUDIO_RECORDING);

      if (status !== 'granted') {
        setShowRecordButton(false);
      } else {
        setShowRecordButton(true);
      }
    }

    requestPermissions();
  }, []);

  const onStartButtonPress = async () => {
    try {
      await Voice.start('pt-BR');
    } catch (error) {
      console.log(error);
    }
  };

  const onStopButtonPress = async () => {
    try {
      await Voice.stop();
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <View style={styles.container}>
      {text.length === 0 && isRecording && (
        <Text style={styles.text}>Identificando fala...</Text>
      )}
      {text.length === 0 && !isRecording && (
        <Text style={styles.text}>Nenhum texto identificado</Text>
      )}
      {text.length > 0 && <Text style={styles.text}>{text.join(', ')}</Text>}
      <TouchableOpacity
        style={{...styles.buttonIcon, borderWidth: isRecording ? 2 : 0}}
        onPress={isRecording ? onStopButtonPress : onStartButtonPress}
        disabled={!showRecordButton}>
        <MaterialCommunityIcons
          name="microphone-outline"
          size={60}
          color="white"
        />
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    justifyContent: 'center',
    alignItems: 'center',
  },
  buttonIcon: {
    backgroundColor: '#5a189a',
    width: 64,
    height: 64,
    borderRadius: 50,
    borderColor: '#ffffff',
    justifyContent: 'center',
    alignItems: 'center',
  },
  text: {
    color: '#ffffff',
    fontSize: 16,
    marginBottom: 16,
  },
});
