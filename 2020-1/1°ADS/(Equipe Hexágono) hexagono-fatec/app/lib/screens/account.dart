import 'package:app/screens/sidebar/sidebar.dart';
import 'package:app/utilities/api/sign-in.dart';
import 'package:flutter/material.dart';

class MyAccountBody extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Stack(children: <Widget>[
      Container(
        height: double.infinity,
        width: double.infinity,
        decoration: BoxDecoration(
          gradient: LinearGradient(
          begin: Alignment.topCenter,
          end: Alignment.bottomCenter,
          colors: [
            Color(0xDD000000),
            Color(0xFF000000),
            Color(0xFF000000),
            ],
          stops: [0.1, 0.7, 0.9],
          )
        ),
      ),
      Container(
        height: double.infinity,
        child: SingleChildScrollView(
          physics: AlwaysScrollableScrollPhysics(),
          padding: EdgeInsets.symmetric(
            horizontal: 40,
            vertical: 68,
          ),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Center(
                child: FutureBuilder<dynamic>(
                    //pegando a lista que dei return lá no sign-in.dart
                    future: getUserData(),
                    builder: (context, snapshot) {
                      if (snapshot.hasData) {
                        return Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: <Widget>[
                            Container(
                              alignment: Alignment.center,
                              margin: const EdgeInsets.all(10.0),
                              width: 800.0,
                              height: 120.0,
                              child: ClipRRect(
                                child: Image.network(
                                    snapshot.data[2]), //index 2 -> foto
                                borderRadius: BorderRadius.circular(50),
                              ),
                            ),
                            Container(
                              alignment: Alignment.topCenter,
                              margin: const EdgeInsets.all(10.0),
                              child: Text(
                                snapshot.data[0], // index 0 -> nome
                                style: TextStyle(
                                  color: Colors.white,
                                  fontFamily: 'OpenSans',
                                  fontSize: 40,
                                  fontWeight: FontWeight.bold,
                                ),
                              ),
                            ),
                            Container(
                              alignment: Alignment.center,
                              child: Text(
                                snapshot.data[1], // index 1 -> email
                                style: TextStyle(
                                  color: Colors.white,
                                  fontFamily: 'OpenSans',
                                  fontSize: 20,
                                  fontWeight: FontWeight.bold,
                                ),
                              ),
                            ),
                          ],
                        );
                      } else {
                        return Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: <Widget>[
                            Container(
                              alignment: Alignment.center,
                              margin: const EdgeInsets.all(10.0),
                              width: 800.0,
                              height: 120.0,
                              child: ClipRRect(
                                child: Image.asset('assets/avatar.png'),
                                borderRadius: BorderRadius.circular(50),
                              ),
                            ),
                            Container(
                              alignment: Alignment.topCenter,
                              margin: const EdgeInsets.all(10.0),
                              child: Text(
                                'User',
                                style: TextStyle(
                                  color: Colors.white,
                                  fontFamily: 'OpenSans',
                                  fontSize: 40,
                                  fontWeight: FontWeight.bold,
                                ),
                              ),
                            ),
                            Container(
                              alignment: Alignment.center,
                              child: Text(
                                'user@email.com',
                                style: TextStyle(
                                  color: Colors.white,
                                  fontFamily: 'OpenSans',
                                  fontSize: 20,
                                  fontWeight: FontWeight.bold,
                                ),
                              ),
                            ),
                          ],
                        );
                      }
                    }),
              )
            ],
          ),
        ),
      ),
    ]);
  }
}

class MyAccount extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Stack(children: <Widget>[
        MyAccountBody(),
        Sidebar(),
      ]),
    );
  }
}
