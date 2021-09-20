import React, { useState, useCallback, useEffect } from "react";
import { View, Text } from "react-native";
import { GiftedChat } from "react-native-gifted-chat";

export default function ConversaParticularScreen({ route, navigation }) {
  const [messages, setMessages] = useState([]);
  const { name } = route.params;

  useEffect(() => {
    setMessages([
      //   {
      //     _id: 1,
      //     text: "Hello developer",
      //     createdAt: new Date(),
      //     user: {
      //       _id: 2,
      //       name: "React Native",
      //       avatar: "https://placeimg.com/140/140/any",
      //     },
      //   },
    ]);
  }, []);

  const onSend = useCallback((messages = []) => {
    setMessages((previousMessages) =>
      GiftedChat.append(previousMessages, messages)
    );
  }, []);

  return (
    <View style={{ flex: 1, height: "100%" }}>
      <View>
        <View style={{ width: "100%", marginTop: 40, borderBottomWidth: 1 }}>
        
          <Text style={{ fontSize: 18, textAlign:"center" }}>{name}</Text>
        </View>
      </View>
      <GiftedChat
        messages={messages}
        placeholder={"Escreva uma mensagem..."}
        onSend={(messages) => onSend(messages)}
        user={{
          _id: 1,
        }}
      />
    </View>
  );
}
