import React, { useState, useCallback, useEffect } from "react";
import {
  View,
  Text,
  StyleSheet,
  FlatList,
  TouchableOpacity,
  Modal,
  TextInput,
} from "react-native";
import {
  Card,
  CardTitle,
  CardContent,
  CardAction,
  CardButton,
  CardImage,
} from "react-native-cards";
import MaterialCommunityIcons from "react-native-vector-icons/MaterialCommunityIcons";

export default function AtividadesScreen({ navigation }) {
  const [modalVisible, setModalVisible] = useState(false);
  const [pickedColor, setPickedColor] = useState(undefined);
  const [title, setTitle] = useState(undefined);
  const [content, setContent] = useState(undefined);

  const [tasks, setTasks] = useState([]);

  const colors = [
    { key: "red" },
    { key: "#385F73" },
    { key: "#03A9F4" },
    { key: "teal" },
    { key: "green" },
  ];

  const addTask = (newTask) => {
    tasks.unshift(newTask);
    setTitle(undefined);
    setContent(undefined);
    setPickedColor(undefined);
    setModalVisible(false);
  };

  const renderItem = ({ item }) => {
    return (
      <View>
        <Card style={{ backgroundColor: item.style.bg }}>
          <CardTitle isDark={true} title={item.title} />
          <CardContent isDark={true} text={item.text} />
          <CardAction separator={true} inColumn={false}>
            <CardButton
              onPress={() => {
                const newTask = tasks.filter((task) => task.key != item.key);
                setTasks(newTask);
              }}
              title="Apagar"
              color="#FFF"
            />
          </CardAction>
        </Card>
      </View>
    );
  };

  return (
    <View style={{ flex: 1 }}>
      <View style={styles.containerText}>
        <Text style={styles.texttop}>Chat Porps</Text>
        <Text style={styles.textconf}>Atividades</Text>
      </View>
      <View>
        <TouchableOpacity
          style={{  ...styles.addButton, ...styles.openButton,backgroundColor: "#2196F3" }}
          onPress={() => {
            setModalVisible(true);
          }}
        >
          <MaterialCommunityIcons name="plus" color={"white"} size={25} />
          <Text style={{color:"white", fontWeight:"bold"}}>Adicionar uma atividade</Text>
        </TouchableOpacity>
      </View>
      <View style={{ height: "73%" }}>
        <FlatList
          data={tasks}
          renderItem={renderItem}
          keyExtractor={(item) => item.key}
        />
      </View>
      <Modal
        animationType="fade"
        transparent={true}
        visible={modalVisible}
        onRequestClose={() => {
          Alert.alert("Modal has been closed.");
        }}
      >
        <View style={styles.centeredView}>
          <View style={styles.modalView}>
            <Text style={styles.modalText}>Adicione uma atividade</Text>

            <View style={styles.inputs}>
              <TextInput
                textContentType={"none"}
                style={styles.input}
                placeholder="Título"
                onChangeText={(title) => setTitle(title)}
                value={title}
              />
              <TextInput
                textContentType={"none"}
                style={styles.input}
                placeholder="Conteúdo"
                onChangeText={(content) => setContent(content)}
                value={content}
              />
            </View>
            <View style={styles.colorsView}>
              {colors.map((obj, index) => {
                return (
                  <TouchableOpacity
                    key={(Math.floor(Math.random() * 10000) + 1).toString()}
                    onPress={() => {
                      setPickedColor(obj.key);
                    }}
                    style={[
                      styles.color,
                      {
                        backgroundColor: obj.key,
                        width: pickedColor == obj.key ? 35 : 30,
                        height: pickedColor == obj.key ? 35 : 30,
                        borderRadius: pickedColor == obj.key ? 17.5 : 15,
                      },
                    ]}
                  />
                );
              })}
            </View>
            <TouchableOpacity
              style={{ ...styles.openButton, backgroundColor: "#2196F3" }}
              onPress={() => {
                const cardTitle =
                  !title || title.trim() == "" ? "Sem título" : title;
                const cardContent =
                  !content || content.trim() == "" ? "Sem conteúdo" : content;

                addTask({
                  key: (Math.floor(Math.random() * 10000) + 1).toString(),
                  title: cardTitle,
                  text: cardContent,
                  style: {
                    bg: pickedColor ? pickedColor: "#03A9F4",
                  },
                });
              }}
            >
              <Text style={styles.textStyle}>Criar Atividade</Text>
            </TouchableOpacity>
          </View>
        </View>
      </Modal>
    </View>
  );
}

const styles = StyleSheet.create({
  color: {
    width: 30,
    height: 30,
    margin: 5,
    borderRadius: 15,
  },
  colorsView: {
    marginVertical: 15,
    flexDirection: "row",
  },
  input: {
    borderRadius:5,
    borderWidth: 1,
    padding: 10,
    margin: 10,
  },
  inputs: {
    width: "95%",
  },
  addButton: {
    width: "60%",
    marginBottom: 20,
    alignSelf: "flex-end",
    marginRight: 10,
    padding: 10,
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "center",
    elevation: 2,
    shadowColor: "#000",
    shadowOffset: {
      width: 0,
      height: 2,
    },
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
  centeredView: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    marginTop: 22,
  },
  modalView: {
    margin: 20,
    width: "80%",
    backgroundColor: "white",
    borderRadius: 20,
    padding: 35,
    alignItems: "center",
    shadowColor: "#000",
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowOpacity: 0.25,
    shadowRadius: 3.84,
    elevation: 5,
  },
  openButton: {
    backgroundColor: "#F194FF",
    borderRadius: 10,
    padding: 10,
    elevation: 2,
  },
  textStyle: {
    color: "white",
    fontWeight: "bold",
    textAlign: "center",
  },
  modalText: {
    marginBottom: 15,
    fontSize:18,
    textAlign: "center",
  },
});
