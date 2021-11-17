package com.example.freechair

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SqliteHelper (context: Context, name:String, version: Int):SQLiteOpenHelper(context,name,null,version){

    override fun onCreate(db: SQLiteDatabase?) {
        val create="CREATE TABLE IF NOT EXISTS \"restaurantDb\" (\n" +
                "\t\"no\"\tTEXT,\n" +
                "\t\"name\"\tTEXT,\n" +
                "\t\"gu\"\tTEXT,\n" +
                "\t\"address\"\tTEXT,\n" +
                "\t\"phoneNo\"\tTEXT,\n" +
                "\t\"ramp\"\tTEXT,\n" +
                "\t\"heightDiffer\"\tTEXT,\n" +
                "\t\"elevator\"\tTEXT,\n" +
                "\t\"restroom\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"no\")\n" +
                ");\n"

        db?.execSQL(create)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun dbInit(){
        val wd=writableDatabase
        val initSql=
                "INSERT OR IGNORE INTO  \"restaurantDb\" VALUES ('1124','롯데리아','은평구','서울시 은평구 응암로 229','02-308-6681','Y','Y','N','N');\n"+
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1126','대창타운빌','구로구','서울시 구로구 개봉로23가길 70',NULL,'Y','Y','N','N');\n"+

                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1349','대원','성동구','서울시 성동구 고산자로26길 12','02-2295-5500','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1385','커피빈 압구정점(스마트 익스체인지 빌딩)','강남구','서울시 강남구 도산대로49길 13','02-543-5922','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1108','세종대왕숯불갈비','동작구','서울시 동작구 여의대방로 136','02-823-2517','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1174','가족천하','영등포구','서울시 영등포구 가마산로 330','02-847-4500','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1329','봉산집','강남구','서울시 강남구 삼성로 564','02-552-5898','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1310','하누소','도봉구','서울시 도봉구 노해로 327','02-900-9900','Y','Y','Y','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1345','근린생활시설(대게나라)','노원구','서울시 노원구 상계로 122','02-932-9981','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1116','두울빌딩','강동구','서울시 강동구 강동대로53길 22',NULL,'N','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1129','(주) 씨머스','강남구','서울시 강남구 학동로2길  56','02-546-7602','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1087','수원왕갈비','성동구','서울시 성동구 마장로   317','02-2299-8592','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1156','퍼쥬망 왕갈비전문점','종로구','서울시 종로구 삼일대로15길 18','02-732-8555','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1265','일식미진(일반음식점)','마포구','서울시 마포구 월드컵북로2길 37','02-324-4848','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1233','The만나','노원구','서울시 노원구 석계로 103','02-971-1100','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1179','대학로바탕골','종로구','서울시 종로구 대학로10길 5',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1236','정동진회집 하계점','노원구','서울시 노원구 한글비석로1길 61','02-976-4983','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1263','공룡고기','금천구','서울시 금천구 시흥대로  185',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1035','아웃백스테이크하우스 신촌점','서대문구','서울시 서대문구 연세로12길 33','02-3147-1871','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1259','효천공영-음악감상실','종로구','서울시 종로구 성균관로 87','02-3676-2352','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1019','브리꼴라쥬카페','은평구','서울시 은평구 진흥로 87','02-702-2688','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1117','금강수산','광진구','서울시 광진구 아차산로 230','02-461-4300','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1395','카페뎀셀브쥬','종로구','서울시 종로구 삼일대로 388','02-2266-5947','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1123','이춘복참치','노원구','서울시 노원구 노해로85길 10-7','02-951-4558','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1009','빕스 문정점','송파구','서울시 송파구 새말로5길 31','02-443-2997','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1364','일반음식점(삿뽀로)','마포구','서울시 마포구 월드컵북로 14','02-3144-4671','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1313','코스모','금천구','서울시 금천구 시흥대로123길  14',NULL,'N','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1176','타워차이','서초구','서울시 서초구 법원로1길 7','02-599-3507','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1050','수정궁(갈비탕 전문점)','강남구','서울시 강남구 도곡로63길  20',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1130','근린생활시설(천하뼈다귀감자탕)','노원구','서울시 노원구 동일로 1595','02-933-9897','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1031','옛골토성','성동구','서울시 성동구 고산자로10길  8','02-2282-5292','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1291','찰진고기(그랑프리 빌딩)','강남구','서울시 강남구 테헤란로10길 9','02-561-5171','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('991','갈비사랑','서초구','서울시 서초구 강남대로  204','02-3463-9800','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1200','별난횟집','서초구','서울시 서초구 마방로2길 26','02-571-3050','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1020','연일선지해장국','서대문구','서울시 서대문구 수색로  127',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1024','신토오리','송파구','서울시 송파구 문정로4길  14-38','02-430-5295','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1314','광양림','영등포구','서울시 영등포구 선유로9가길  16','02-2677-5775','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1239','대문한정식','도봉구','서울시 도봉구 시루봉로  139-6','02-956-0843','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1248','거북이집','서대문구','서울시 서대문구 연희로  12-1','02-322-8018','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('990','고기굼터','강서구','서울시 강서구 양천로 376','02-3663-8592','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1022','베누스타-뷔페','성북구','서울시 성북구 도봉로 1',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1352','빕스 상봉역점','중랑구','서울시 중랑구 망우로  263','02-491-1997','N','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1354','맑은바닷가의나루터','강서구','서울시 강서구 강서로54길 73','02-3663-0067','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1075','베아따빌딩신관','서초구','서울시 서초구 서초대로53길 8','02-535-9292','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1358','하림각','종로구','서울시 종로구 자하문로  255','02-396-2442','N','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1183','오발탄','강남구','서울시 강남구 논현로86길  12','02-2051-7775','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1111','동구밖 장작구이(단군의땅)','강동구','서울시 강동구 진황도로 227','02-488-5292','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1229','근린생활시설(진할매칼국수보쌈)','노원구','서울시 노원구 동일로242길 109','02-951-1507','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1205','논골집','강남구','서울시 강남구 압구정로79길 55','02-543-0135','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1230','근린생활시설(풍천민물장어)','노원구','서울시 노원구 노해로81길 12-26','02-935-5523','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1299','보름달','강남구','서울시 강남구 테헤란로37길 22','02-556-6777','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1367','역삼버드나무 집','강남구','서울시 강남구 언주로 522','02-2088-3392','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1092','미스터피자','도봉구','서울시 도봉구 노해로  285','02-900-2032','N','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1293','피자헛','노원구','서울시 노원구 동일로 1333','02-935-5143','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1142','미담','양천구','서울시 양천구 목동서로 133-4','02-2642-2300','Y','Y','Y','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1336','태능가든','중랑구','서울시 중랑구 신내로14길 13','02-3422-2800','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1381','파리크라상','중구','서울시 중구 덕수궁길 7','02-773-8208','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1391','양대박','송파구','서울시 송파구 백제고분로46길 44','02-415-3321','N','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1060','coffeesmith(휴게음식점)','마포구','서울시 마포구 와우산로  82','02-3143-6740','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1051','양촌리 화로 숯불구이','강남구','서울시 강남구 남부순환로  2720','02-2058-1245','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1271','쿼터백','강남구','서울시 강남구 테헤란로1길  29','02-567-7879','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1114','한일관','강남구','서울시 강남구 압구정로38길 14','1577-9963','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('992','화사랑화로구이','송파구','서울시 송파구 오금로 162','02-421-4554','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('982','초원웨딩홀뷔페','도봉구','서울시 도봉구 도봉산길 10','02-955-2233','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1153','강강술래','강남구','서울시 강남구 논현로  325','02-567-9233','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1027','메종르베이지-카페','용산구','서울시 용산구 이태원로  267','02-749-5667','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1196','이태원동 근린생활시설(휴게음식점)','용산구','서울시 용산구 이태원로  192',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1191','빕스 대방점','동작구','서울시 동작구 노량진로 2','02-3280-1997','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1212','정감어린','용산구','서울시 용산구 후암로 4','02-754-4389','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1292','태평(한식집)','강남구','서울시 강남구 테헤란로6길 14','02-564-5551','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('999','근린생활시설(황금오리농원)','노원구','서울시 노원구 동일로231길 17','02-935-5296','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1146','더캣츠','강서구','서울시 강서구 공항대로46길  90','02-2698-7898','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1312','봉피양마포점(오늘도안동한우)','마포구','서울시 마포구 토정로  308','02-715-2292','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1361','흑돈가','강남구','서울시 강남구 봉은사로86길 14','02-2051-0008','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1373','근린생활시설(배밭고을)','노원구','서울시 노원구 동일로 1611','02-938-9500','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1170','동굴과 화로구이(뉴명성)','은평구','서울시 은평구 은평로  185','02-353-8592','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1350','임고집한우','강남구','서울시 강남구 테헤란로104길 11','02-567-5620','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1242','일킬로칼국수','서초구','서울시 서초구 강남대로37길 59','02-586-1052','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1253','동원빌딩(근린생활시설)','마포구','서울시 마포구 어울마당로 147-1',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1281','본가','노원구','서울시 노원구 노해로83길 10-4','02-931-9291','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1303','타운플라자','서초구','서울시 서초구 신반포로47길 9-6',NULL,'Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1053','프로포즈야채과일&lt;간이장터&gt;','도봉구','서울시 도봉구 노해로63다길 25',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1232','근린생활시설(엉터리생고기)','노원구','서울시 노원구 상계로7길 39','02-938-3376','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1026','골든너겟','용산구','서울시 용산구 이태원로55가길  3',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1286','엔씨레이디스-백화점','영등포구','서울시 영등포구 양평로 47','02-2068-2001','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1289','신사면옥','강남구','서울시 강남구 도산대로 311','02-518-7228','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1335','민속촌(용강빌딩)','강남구','서울시 강남구 도산대로 535',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1127','새마을식당(덕당빌딩)','강남구','서울시 강남구 논현로150길  33','02-515-2251','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1210','지오브레스빌딩','용산구','서울시 용산구 대사관로34길 22',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1227','골방집','강북구','서울시 강북구 한천로 926','02-993-8200','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1323','호야','강남구','서울시 강남구 강남대로78길  22',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1342','쉐프케이엔알(송은아트 스페이스)','강남구','서울시 강남구 압구정로75길  6',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1355','온누림','노원구','서울시 노원구 덕릉로60길 293','02-906-7002','N','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1372','박미선 별난갈비','관악구','서울시 관악구 봉천로  535',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1089','서광폴리머','영등포구','서울시 영등포구 국회대로37길 5',NULL,'N','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1136','양촌리','강동구','서울시 강동구 양재대로 1444','02-485-9292','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1046','참치박사','노원구','서울시 노원구 노해로81길 12-33','02-933-9611','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1058','파스꾸찌신촌연대점','서대문구','서울시 서대문구 연세로 22','02-393-8004','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('989','강강술래','노원구','서울시 노원구 동일로 1628','02-935-9233','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1386','롯데리아','강동구','서울시 강동구 양재대로 1651','02-427-8463','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1362','(주)에도긴','강남구','서울시 강남구 테헤란로8길  30','02-568-5147','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1375','한우식당 마블스','영등포구','서울시 영등포구 신풍로  10','02-848-5292','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1393','커피스미스','강남구','서울시 강남구 도산대로13길 13','02-3445-3372','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1165','Amazing B/D','강남구','서울시 강남구 도산대로 306',NULL,'Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1368','영천 영화 고기집(상민빌딩)','강남구','서울시 강남구 도산대로90길 3','02-3442-0381','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1141','파리바게트','서대문구','서울시 서대문구 홍은중앙로 29','070-4116-4796','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1080','도봉산갈비','도봉구','서울시 도봉구 도봉로  915','02-955-1177','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1320','한국의집','중구','서울시 중구 청계천로 8','02-2266-9101','Y','Y','Y','Y');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1384','wellz-가구판매','강남구','서울시 강남구 삼성로 729','02-511-7911','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1241','삼수갑산','관악구','서울시 관악구 남현1길  38-9','02-521-0056','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1246','수상한포차','강북구','서울시 강북구 도봉로87길 46','02-903-2332','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('996','라부미텔','금천구','서울시 금천구 범안로  1203',NULL,'N','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1190','언더브릿지(일반음식점)','마포구','서울시 마포구 토정로  174','070-4146-0856','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1217','근린생활시설(봉평산골메밀촌)','노원구','서울시 노원구 동일로242길 54','02-931-3482','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1363','서울인삼토계촌(일반음식점)','마포구','서울시 마포구 모래내로 89','02-304-5060','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1351','투쉐 카페&amp;레스토랑(미산빌딩)','강남구','서울시 강남구 압구정로71길 4','02-3018-1002','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1074','서초동이남장','서초구','서울시 서초구 서초대로49길 4','02-592-0268','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1340','일반음식점(나주곰탕)','마포구','서울시 마포구 도화길 12',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1054','일반음식점(에덴)','노원구','서울시 노원구 중계로18길 9',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1056','미스터피자','서대문구','서울시 서대문구 연세로 10','02-363-9001','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1064','진미파라곤','영등포구','서울시 영등포구 국회대로 800',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1055','이화원','서대문구','서울시 서대문구 연희맛로 13','02-334-1888','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1185','쌍쌍포차','광진구','서울시 광진구 동일로22길 49','02-466-9545','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1219','빕스 등촌점','강서구','서울시 강서구 공항대로  311','02-3661-1997','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1169','바달비','관악구','서울시 관악구 봉천로12길  17','02-889-2600','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1178','오발탄','서초구','서울시 서초구 반포대로 154','02-591-6657','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1237','예소원','서대문구','서울시 서대문구 성산로 535','02-313-7676','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1270','보보리스-미용실','강남구','서울시 강남구 언주로154길  14','02-549-0988','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1164','실크로드','구로구','서울시 구로구 경인로 398','02-2066-6100','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1188','일파르코','노원구','서울시 노원구 노원로 240','02-949-1855','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1032','수상한포차','광진구','서울시 광진구 아차산로33길 33','02-499-2588','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1045','남원추어탕','노원구','서울시 노원구 한글비석로1길 69',NULL,'Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1249','벽제갈비','서대문구','서울시 서대문구 연세로 14','02-392-8308','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1222','초동집','서초구','서울시 서초구 서운로  135','02-585-2511','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('984','미스터피자 양재점(크리스탈빌딩)','강남구','서울시 강남구 강남대로  242','02-3463-1100','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1276','뢰벤호프','서초구','서울시 서초구 방배천로  21','02-585-6654','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1140','삼호복집','서대문구','서울시 서대문구 연세로5다길 10','02-337-9019','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1120','형제갈비','서대문구','서울시 서대문구 명물1길  2','02-365-0001','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1283','연신내부대찌개','은평구','서울시 은평구 연서로  187',NULL,'Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1063','옛골토성','은평구','서울시 은평구 대서문길  45-7','02-385-3064','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1308','코리아하우스(아름다운빌딩)','강남구','서울시 강남구 압구정로79길 56','02-543-8888','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1069','신라비빔밥샤브칼국수','강동구','서울시 강동구 양재대로85길 16','02-483-6879','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1072','황실떡','서초구','서울시 서초구 서초대로25길 37','02-533-5580','Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1002','한우정육식당(부경빌딩)','강남구','서울시 강남구 강남대로118길 12',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1016','엔젤리너스카페','중구','서울시 중구 명동7길 8','02-753-1769','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1145','씨제이푸드','은평구','서울시 은평구 서오릉로  4',NULL,'Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1279','봉추찜닭(신사빌딩)','강남구','서울시 강남구 도산대로13길 14-4','02-516-5687','Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1067','세븐몽키스(금원빌딩)','강남구','서울시 강남구 선릉로  425',NULL,'Y','N','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1195','프리미어플레이스','중구','서울시 중구 중림로 40',NULL,'Y','Y','N','N');\n" +
                "INSERT OR IGNORE INTO \"restaurantDb\" VALUES ('1309','경복궁','송파구','서울시 송파구 올림픽로  348','02-418-7767','Y','Y','N','N');"

        val initSqlArray=initSql.split("\n")
        for(index in 0 until initSqlArray.size){
            wd.execSQL(initSqlArray[index])
        }

        wd.close()
    }


    //주의사항 : ramp 등 4개의 필터링 옵션은 'Y','N' 의 대문자로만 표기해야 한다. 'y'와 'n'은 에러!
    //이름 기반 검색
    @SuppressLint("Range")
    fun selectName(nameChk :String, rampChk:String="N", heightDifferChk: String="N", elevatorChk: String="N", restroomChk: String="N"):MutableList<Restaurant>{
        val list = mutableListOf<Restaurant>()

        var select="select * " +
                "from restaurantDb " +
                "where name like '%${nameChk}%'"

        if (rampChk=="Y"||rampChk=="y") {
            var strTemp="\nand ramp='Y'"
            select=select+strTemp
        }
        if (heightDifferChk=="Y"||heightDifferChk=="y") {
            var strTemp="\nand heightDiffer='Y'"
            select=select+strTemp
        }
        if (elevatorChk=="Y"||elevatorChk=="y") {
            var strTemp="\nand elevator='Y'"
            select=select+strTemp
        }
        if (restroomChk=="Y"||restroomChk=="y") {
            var strTemp="\nand restroom='Y'"
            select=select+strTemp
        }

        val rd= readableDatabase
        val cursor=rd.rawQuery(select,null)

        while (cursor.moveToNext()){
            val no=cursor.getLong(cursor.getColumnIndex("no"))
            val name=cursor.getString(cursor.getColumnIndex("name"))
            val gu=cursor.getString(cursor.getColumnIndex("gu"))
            val address=cursor.getString(cursor.getColumnIndex("address"))
            val phoneNo=cursor.getString(cursor.getColumnIndex("phoneNo"))
            val ramp=cursor.getString(cursor.getColumnIndex("ramp"))
            val heightDiffer=cursor.getString(cursor.getColumnIndex("heightDiffer"))
            val elevator=cursor.getString(cursor.getColumnIndex("elevator"))
            val restroom=cursor.getString(cursor.getColumnIndex("restroom"))

            list.add(Restaurant(no,name,gu,address,phoneNo,ramp,heightDiffer,elevator,restroom))
        }

        cursor.close()
        rd.close()

        return list
    }

    //구 기반 검색
    @SuppressLint("Range")
    fun selectGu(guChk :String, rampChk:String="N", heightDifferChk: String="N", elevatorChk: String="N", restroomChk: String="N"):MutableList<Restaurant>{
        val list = mutableListOf<Restaurant>()

        var select="select * " +
                "from restaurantDb " +
                "where gu like '%${guChk}%'"

        if (rampChk=="Y"||rampChk=="y") {
            var strTemp="\nand ramp='Y'"
            select=select+strTemp
        }
        if (heightDifferChk=="Y"||heightDifferChk=="y") {
            var strTemp="\nand heightDiffer='Y'"
            select=select+strTemp
        }
        if (elevatorChk=="Y"||elevatorChk=="y") {
            var strTemp="\nand elevator='Y'"
            select=select+strTemp
        }
        if (restroomChk=="Y"||restroomChk=="y") {
            var strTemp="\nand restroom='Y'"
            select=select+strTemp
        }

        val rd= readableDatabase
        val cursor=rd.rawQuery(select,null)

        while (cursor.moveToNext()){
            val no=cursor.getLong(cursor.getColumnIndex("no"))
            val name=cursor.getString(cursor.getColumnIndex("name"))
            val gu=cursor.getString(cursor.getColumnIndex("gu"))
            val address=cursor.getString(cursor.getColumnIndex("address"))
            val phoneNo=cursor.getString(cursor.getColumnIndex("phoneNo"))
            val ramp=cursor.getString(cursor.getColumnIndex("ramp"))
            val heightDiffer=cursor.getString(cursor.getColumnIndex("heightDiffer"))
            val elevator=cursor.getString(cursor.getColumnIndex("elevator"))
            val restroom=cursor.getString(cursor.getColumnIndex("restroom"))

            list.add(Restaurant(no,name,gu,address,phoneNo,ramp,heightDiffer,elevator,restroom))
        }

        cursor.close()
        rd.close()

        return list
    }

    //최종 통합 검색
    fun search(nameChk:String?,guChk:String?,rampChk:String="N", heightDifferChk: String="N",
               elevatorChk: String="N", restroomChk: String="N"):MutableList<Restaurant>{

        val resultList=mutableListOf<Restaurant>()

        val listone:MutableList<Restaurant>
        val listtwo:MutableList<Restaurant>

        if (nameChk!=null&&guChk!=null) {

            listone = selectName(nameChk, rampChk, heightDifferChk, elevatorChk, restroomChk)
            listtwo = selectGu(guChk, rampChk, heightDifferChk, elevatorChk, restroomChk)
            resultList.addAll(listone)
            resultList.addAll(listtwo)
        }


        return resultList
    }
}

data class Restaurant(var no: Long?,var name:String, var gu:String, var address:
String,var phoneNo:String, var ramp:String, var heightDiffer:String, var elevator: String, var restroom: String)
