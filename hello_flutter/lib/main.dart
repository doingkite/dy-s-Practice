import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false, //디버그배너 숨기기
      theme: ThemeData(
        useMaterial3: false,
      ),
      home: Scaffold(
        appBar: AppBar(
          title: Text(
            '용마단 가입하기',
            style: TextStyle(fontSize: 28),
          ),
          centerTitle: true,
        ),
        body: SingleChildScrollView(
          child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              children: [
                Padding(
                  padding: const EdgeInsets.all(10),
                  child: Image.network(
                    "https://pbs.twimg.com/media/GRz6LQracAMIstT?format=jpg&name=4096x4096",
                    width: 320,
                  ),
                ),
                TextField(
                  decoration: InputDecoration(labelText: '이메일'),
                ),
                TextField(
                  obscureText: true, //입력된텍스트마스킹
                  decoration: InputDecoration(labelText: '비밀번호'),
                ),
                Container(
                  width: double.infinity,
                  margin: const EdgeInsets.only(top: 16),
                  child: ElevatedButton(
                    onPressed: () {},
                    child: Text('로그인'),
                  ),
                )
              ],
            ),
          ),
        ),
      ),
    );
  }
}
