import 'package:firebase_auth/firebase_auth.dart';
import 'package:google_sign_in/google_sign_in.dart';

final FirebaseAuth _auth = FirebaseAuth.instance; //chamando as coisas do firebase
final GoogleSignIn googleSignIn = GoogleSignIn(); //chamando as coisas do login do google

Future<String> signInWithGoogle() async { //estrutura do login. muitas coisas não sei, só sei que é assim
  final GoogleSignInAccount googleSignInAccount = await googleSignIn.signIn();
  final GoogleSignInAuthentication googleSignInAuthentication = await googleSignInAccount.authentication;

  final AuthCredential credential = GoogleAuthProvider.getCredential( //pegando uns ids aí
    idToken: googleSignInAuthentication.idToken,
    accessToken: googleSignInAuthentication.accessToken
  );

  final AuthResult authResult = await _auth.signInWithCredential(credential);
  final FirebaseUser user = authResult.user;

  assert(!user.isAnonymous); //faz verificação se o usuário não é anônimo
  assert(await user.getIdToken() != null); //faz verificação de token

  final FirebaseUser currentUser = await _auth.currentUser(); //usuário atual
  assert(user.uid == currentUser.uid); //verificação do id

  return 'signInWithGoogle Succeeded: $user';
}

signOutGoogle() async { //Log out do usuário
  await googleSignIn.signOut();
} 

Future<dynamic> getUserData() async { //pegando o nome do usuário lá do firebase
  String displayName = (await _auth.currentUser()).displayName;
  String email = (await _auth.currentUser()).email;
  String photo = (await _auth.currentUser()).photoUrl;
  var date = (await _auth.currentUser()).metadata.creationTime;
  List data = [displayName, email, photo, date]; //não se dá return em três variáveis. então fiz uma lista
  return data;
}