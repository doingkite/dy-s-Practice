import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import 'feed.dart';

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final List<String> images = [
      "https://biz.chosun.com/resizer/QrCYUge5K6tRrYJH6n-TchYCsfw=/616x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosunbiz/ILN72GJXRJTNX6IFX5JVWK6YYA.jpg",
      "https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2024/03/11/6dfc08a3-b6ec-4196-ae1c-f54596e30802.jpg",
      "https://static.news.zumst.com/images/100/2020/07/30/914c5ce86de64764bec5b375870964d8.jpg",
      "https://nowcdn.smtown.com/upload/news/images/2020/12/24/jPH729t2fvV7fSb5_1f62d32e71c94b3db8e6f7410128c112_1608793416864.jpg",
      "https://image.yes24.com/goods/111735957/XL",
      "https://cdn.living-sense.co.kr/news/photo/202403/63058_56264_2610.jpg",
      "https://blog.kakaocdn.net/dn/bXJ0Lw/btqY7obf4Gr/zrhDZD0S6C0K6BRhssUaC1/img.gif",
    ];
    return Scaffold(
      appBar: AppBar(
        leading: IconButton(
          icon: Icon(CupertinoIcons.camera, color: Colors.black),
          onPressed: () {},
        ),
        actions: [
          IconButton(
            icon: Icon(CupertinoIcons.paperplane, color: Colors.black),
            onPressed: () {},
          )
        ],
        title: Image.asset(
          'assets/logo.png',
          height: 32,
        ),
        centerTitle: true,
        backgroundColor: Colors.white,
      ),
      body: ListView.builder(
        itemCount: images.length, // 이미지 개수만큼 보여주기
        itemBuilder: (context, index) {
          final image = images[index]; // index에 해당하는 이미지
          return Feed(imageUrl: image); // imageUrl 전달
        },
      ),
    );
  }
}
