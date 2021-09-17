import React from "react";
import { StyleSheet, Text, View } from "react-native";

import Converter from "../ConversorMoedas/conversor";

export default class App extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <Converter coinA="USD" coinB="BRL" />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
});