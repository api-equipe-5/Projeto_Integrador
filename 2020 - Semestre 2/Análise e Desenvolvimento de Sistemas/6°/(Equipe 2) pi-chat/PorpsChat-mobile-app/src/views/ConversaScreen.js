import React, { useState, useCallback, useEffect } from "react";
import {
  View,
  Text,
  TouchableOpacity,
  StyleSheet,
  FlatList,
  Image,
} from "react-native";
import {
  Card,
  CardTitle,
  CardContent,
  CardAction,
  CardButton,
  CardImage,
} from "react-native-cards";

export default function ConversaScreen({ navigation }) {
  const [tasks, setTasks] = useState([
    {
      id: "a",
      nome: "Instrutor 1",
    },
    {
      id: "a",
      nome: "Instrutor 2",
    },
    {
      id: "a",
      nome: "Instrutor 3",
    },
  ]);

  const renderItem = ({ item }) => {
    return (
      <View>
        <TouchableOpacity
          onPress={() => {
            navigation.navigate("ConversaDetail", { name: item.nome });
          }}
        >
          <Card style={{ flexDirection: "row", alignItems: "center" }}>
            <Image
              style={styles.tinyLogo}
              source={{
                uri: "https://reactnative.dev/img/tiny_logo.png",
              }}
            />
            <Text>{item.nome}</Text>
          </Card>
        </TouchableOpacity>
      </View>
    );
  };

  return (
    <View style={{ flex: 1 }}>
      <View style={styles.containerText}>
        <Text style={styles.texttop}>Chat Porps</Text>
        <Text style={styles.textconf}>Conversas</Text>
      </View>
      <View style={{ width: "100%" }}>
        <View style={{ height: "73%" }}>
          <FlatList
            data={tasks}
            renderItem={renderItem}
            keyExtractor={(item) => item.key}
          />
        </View>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  tinyLogo: {
    width: 50,
    height: 50,
    margin: 10,
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
