import 'dart:convert';
import 'package:http/http.dart' as http;

Future getLastTemperature() async { //temperaturas
  final response = await http.get(
      'https://app-db-e1e6c.firebaseio.com/temperatures.json?orderBy="timestamp"&limitToLast=1'); //isso aqui fala pro firebase ordenar os dados e retornar apenas o último cara após a ordenação
  if (response.statusCode == 200) {
    Map<String, dynamic> bla = json.decode(response.body);
    List _list = bla.values.toList(); //converte pra uma lista pra poder ordenar
    return _list[0][
        'value']; // como só tem um cara, acesso ele pelo índice zero e o valor da chave chamada 'value'
  }
  else {
    throw Exception(
        "Something went wrong and we couldn't check the temperature :(");
  }
}

Future getLastHumidity() async { //umidades
  final response = await http.get(
      'https://app-db-e1e6c.firebaseio.com/humidities.json?orderBy="timestamp"&limitToLast=1'); //isso aqui fala pro firebase ordenar os dados e retornar apenas o último cara após a ordenação
  if (response.statusCode == 200) {
    Map<String, dynamic> bla = json.decode(response.body);
    List _list = bla.values.toList(); //converte pra uma lista pra poder ordenar
    return _list[0][
        'value']; // como só tem um cara, acesso ele pelo índice zero e o valor da chave chamada 'value'
  }
  else {
    throw Exception(
        "Something went wrong and we couldn't check the humidity :(");
  }
}