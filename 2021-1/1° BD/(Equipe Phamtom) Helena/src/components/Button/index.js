import React from 'react';
import { StyleSheet, Text, TouchableOpacity, View } from 'react-native';

export default function Button({ text, onPress }) {
    return (
        <View style={styles.container}>
            <TouchableOpacity onPress={onPress} style={styles.button}>
                <Text style={styles.buttonText}>{text}</Text>
            </TouchableOpacity>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        marginTop: 16,
        marginBottom: 16
    },
    button: {
        backgroundColor: "#9867C5",
        padding: 10,
        borderRadius: 15,
    },
    buttonText: {
      fontSize: 20,
      color: '#fff',
      textAlign: "center",
    }, 
});