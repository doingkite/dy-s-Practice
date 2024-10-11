import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: HomePage(),
    );
  }
}

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Center(
      child: Text("home page"),
    ));
  }
}
// 1. 화면전체구성: scaffold 앱의 전체적레이아웃
// 2. 홈 지정.. 첫화면 지정하기 --HomePage
// 3. 앱바 제작 1) 로고png 삽입 2)아이콘 삽입 메테리얼..쿠퍼티노..?
// 4. 바디 제작 레이아웃 나누기- body column으로 감싸기 리펙터 
//    이미지 만들기:
//    아이콘버튼:
//    좋아요/ 설명/ 날짜: //
