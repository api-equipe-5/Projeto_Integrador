import 'package:app/screens/homepage.dart';
import 'package:app/utilities/api/sign-in.dart';
import 'package:flutter/material.dart';
import 'package:app/screens/login.dart';
import 'package:onesignal_flutter/onesignal_flutter.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    OneSignal.shared.init('4e00ece4-3802-4c60-b83c-314b3d74ace2');

    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: FutureBuilder(
        //verificação se o usuário já está logado no app p/ não ir para a tela de login
        future: signInWithGoogle(),
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            return Homepage(); //se houver dados salvos, ela vai direto para a homepage
          }else {
            return LoginScreen(); //se não houver dados salvas, ela vai para o login
          }
        },
      ),
    );
  }
}
