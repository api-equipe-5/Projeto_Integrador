import React, { useState, useCallback, useEffect } from "react";

import { View, Text, FlatList, StyleSheet } from "react-native";
import {
  Card,
  CardTitle,
  CardContent,
  CardAction,
  CardButton,
  CardImage,
} from "react-native-cards";

export default function DocumentosScreen({ navigation }) {
  const [tasks, setTasks] = useState([
    { id: "a", nomeArquivo: "arquivo.jpg", descricao: "Arquivo recebido", dataCriação: new Date() },
  ]);

  const renderItem = ({ item }) => {
    return (
      <View>
        <Card>
          <CardTitle isDark={false} title={item.nomeArquivo} />
          <CardContent isDark={false} text={item.descricao} />
          <CardContent isDark={false} text={item.dataCriação.toString()} />

          <CardAction separator={false} inColumn={false}>
            <CardButton onPress={() => {}} title="Baixar" />
          </CardAction>
        </Card>
      </View>
    );
  };

  return (
    <View style={styles.containerText}>
      <Text style={styles.texttop}>Chat Porps</Text>
      <Text style={styles.textconf}>Arquivos</Text>
      <View style={styles.viewFiles}>
        <FlatList
          data={tasks}
          renderItem={renderItem}
          keyExtractor={(item) => item.id}
        />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  viewFiles:{
    height:"90%",
    color:"black"
  },
  containerText: {
    justifyContent: "flex-start",
    margin: 20,
    textAlign: "center",
  },
  text: {
    padding: 10,
    textAlign: "left",
    color: "#6E6E6E",
    fontWeight: "bold",
  },
  texttop: {
    textAlign: "left",
    fontWeight: "bold",
    fontSize: 25,
    color: "#6E6E6E",
  },
  textconf: {
    fontSize: 19,
    textAlign: "left",
    marginBottom: 10,
    fontStyle: "italic",
    color: "#6E6E6E",
  },
});
