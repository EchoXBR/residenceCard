package com.speedata.residencecard;

import java.util.*;



public class GetSqdmByRight {

	public static String 流动人口受理连接池 ="proxool.oracle_stjzzj";
	public static String 居住证受理连接池 ="proxool.oracle_stjzzyw_sl";
	public static String 流动人口查询连接池 ="proxool.oracle_stjzzc";
	public static String 居住证查询连接池 ="proxool.oracle_stjzzyw_query";
	public static String 流动人口统计连接池 ="proxool.oracle_stjzzt";
	public static String 居住证统计连接池 ="proxool.oracle_stjzzyw_long";
	public static String 省厅流动人口连接池 ="proxool.oracle_stjzz_js";
	public static String 省厅居住证连接池 ="proxool.oracle_stjzzyw_js";
	public static String 标准地址连接池 ="proxool.oracle_dzmp";
	public static String 大平台连接池 ="proxool.oracle_dpt";

	public static Map zdrygkcfcs = new HashMap() {{
		put( "01" , "刑事处罚" );
		put( "02" , "行政处罚" );
		put( "03" , "其他处罚" );
	}};

	public static Map zdrygkcszl = new HashMap() {{
		put( "01" , "刑事强制措施" );
		put( "02" , "其他强制措施" );
		put( "03" , "其他侦察措施" );
		put( "04" , "派出所控制" );
		put( "05" , "治保会控制" );
		put( "06" , "保卫部门控制" );
		put( "07" , "积极分子控制" );
		put( "08" , "其他措施" );
	}};
	public static Map zdrygksahw = new HashMap() {{
		put( "01" , "涉稳案件" );
		put( "02" , "治安案件" );
		put( "03" , "涉恐案件" );
		put( "04" , "涉毒案件" );
		put( "05" , "刑事案件" );
		put( "06" , "经济案件" );
		put( "07" , "其他案件" );
	}};
	public static Map zdrygkgkjb = new HashMap() {{
		put( "01" , "一级（重大涉恐涉暴人员）" );
		put( "02" , "二级（立案侦控对象）" );
		put( "03" , "三级（立线侦查对象）" );
		put( "04" , "四级（其他违法犯罪活动嫌疑人员）" );
	}};
	public static Map zdrygkwkzt = new HashMap() {{
		put( "01" , "在控稳定" );
		put( "02" , "在控不稳定" );
		put( "03" , "下落不明" );
		put( "04" , "其他" );
	}};
	public static Map zdrygkhwfs = new HashMap() {{
		put( "01" , "民族分裂" );
		put( "02" , "暴力恐怖" );
		put( "03" , "宗教极端" );
		put( "04" , "涉恐宣传" );
		put( "05" , "刑事违法" );
		put( "06" , "涉毒贩毒" );
		put( "07" , "治安纠纷" );
		put( "08" , "其他" );
	}};
	public static Map zdrygkywlb = new HashMap() {{
		put( "01" , "国保" );
		put( "02" , "经文保" );
		put( "03" , "治安" );
		put( "04" , "刑侦" );
		put( "05" , "禁毒" );
		put( "06" , "网监" );
		put( "07" , "出入境" );
		put( "08" , "反恐" );
	}};
	public static Map zdrygkqtzjzl = new HashMap() {{
		put( "01" , "驾驶证" );
		put( "02" , "护照" );
		put( "03" , "边境通行证" );
		put( "04" , "银行帐号" );
		put( "05" , "社保证号" );
		put( "06" , "其他" );
	}};
	public static Map zdrygkqhgxr = new HashMap() {{
		put( "01" , "同案人员" );
		put( "02" , "群伙骨干" );
		put( "03" , "业务关系人" );
	}};
	public static Map zdrygkhysf = new HashMap() {{
		put( "01" , "头头" );
		put( "02" , "骨干" );
		put( "03" , "一般" );
	}};

	public static Map zdrygkrylb = new HashMap() {{
		put( "01" , "常住" );
		put( "02" , "暂住" );
		put( "03" , "流动" );
		put( "04" , "不明" );
	}};

	public static Map zdrygkjszl = new HashMap() {{
		put( "01" , "玉石" );
		put( "02" , "餐饮" );
		put( "03" , "纺织品" );
		put( "04" , "托运货物" );
		put( "05" , "小商品批零" );
		put( "06" , "打馕" );
		put( "07" , "切糕" );
		put( "08" , "干果" );
		put( "09" , "烧烤" );
		put( "10" , "其他" );
	}};

	public static Map zdrygkzy = new HashMap() {{
		put( "01" , "经商人员" );
		put( "02" , "厂企打工人员" );
		put( "03" , "餐饮打工人员" );
		put( "04" , "流动摊贩" );
		put( "05" , "教师" );
		put( "06" , "学生" );
		put( "07" , "无业人员" );
		put( "08" , "其它" );
	}};

	public static Map zdrygkwhcd = new HashMap() {{
		put( "01" , "本科以上" );
		put( "02" , "专科" );
		put( "03" , "中专" );
		put( "04" , "高中" );
		put( "05" , "初中" );
		put( "06" , "小学" );
		put( "07" , "文盲" );
	}};

	public static Map zdrygkzzmm = new HashMap() {{
		put( "01" , "中共党员" );
		put( "02" , "共青团员" );
		put( "03" , "群众" );
	}};


	public static Map sqdm = new HashMap() {{
		put( "320100000000" , "南京市" );
		put( "320200000000" , "无锡市" );
		put( "320300000000" , "徐州市" );
		put( "320400000000" , "常州市" );
		put( "320600000000" , "南通市" );
		put( "320700000000" , "连云港市" );
		put( "320800000000" , "淮安市" );
		put( "3205000000" , "苏州市" );
		put( "320900000000" , "盐城市" );
		put( "321000000000" , "扬州市" );
		put( "321100000000" , "镇江市" );
		put( "321200000000" , "泰州市" );
		put( "321300000000" , "宿迁市" );
	}};


	public static Map qfjg = new HashMap() {{
		put( "3201" , "江苏省南京市公安局" );
		put( "3202" , "江苏省无锡市公安局" );
		put( "3203" , "江苏省徐州市公安局" );
		put( "3204" , "江苏省常州市公安局" );
		put( "3205" , "江苏省苏州市公安局" );
		put( "3206" , "江苏省南通市公安局" );
		put( "3207" , "江苏省连云港市公安局" );
		put( "3208" , "江苏省淮安市公安局" );
		put( "3209" , "江苏省盐城市公安局" );
		put( "3210" , "江苏省扬州市公安局" );
		put( "3211" , "江苏省镇江市公安局" );
		put( "3212" , "江苏省泰州市公安局" );
		put( "3213" , "江苏省宿迁市公安局" );
	}};

	public static Map xb = new HashMap() {{
		put( "1" , "男" );
		put( "2" , "女" );
	}};


	public static Map mz = new HashMap() {{
		put( "01" , "汉" );
		put( "02" , "蒙古" );
		put( "03" , "回" );
		put( "04" , "藏" );
		put( "05" , "维吾尔" );
		put( "06" , "苗" );
		put( "07" , "彝" );
		put( "08" , "壮" );
		put( "09" , "布依" );
		put( "10" , "朝鲜" );
		put( "11" , "满" );
		put( "12" , "侗" );
		put( "13" , "瑶" );
		put( "14" , "白" );
		put( "15" , "土家" );
		put( "16" , "哈尼" );
		put( "17" , "哈萨克" );
		put( "18" , "傣" );
		put( "19" , "黎" );
		put( "20" , "傈僳" );
		put( "21" , "佤" );
		put( "22" , "畲" );
		put( "23" , "高山" );
		put( "24" , "拉祜" );
		put( "25" , "水" );
		put( "26" , "东乡" );
		put( "27" , "纳西" );
		put( "28" , "景颇" );
		put( "29" , "柯尔克孜" );
		put( "30" , "土" );
		put( "31" , "达斡尔" );
		put( "32" , "仫佬" );
		put( "33" , "羌" );
		put( "34" , "布朗" );
		put( "35" , "撒拉" );
		put( "36" , "毛难" );
		put( "37" , "仡佬" );
		put( "38" , "锡伯" );
		put( "39" , "阿昌" );
		put( "40" , "普米" );
		put( "41" , "塔吉克" );
		put( "42" , "怒" );
		put( "43" , "乌孜别克" );
		put( "44" , "俄罗斯" );
		put( "45" , "鄂温克" );
		put( "46" , "崩龙" );
		put( "47" , "保安" );
		put( "48" , "裕固" );
		put( "49" , "京" );
		put( "50" , "塔塔尔" );
		put( "51" , "独龙" );
		put( "52" , "鄂伦春" );
		put( "53" , "赫哲" );
		put( "54" , "门巴" );
		put( "55" , "珞巴" );
		put( "56" , "基诺" );
		put( "57" , "其它" );
		put( "58" , "入籍" );
		put( "61" , "穿青人" );
		put( "62" , "革家人" );

	}};


	public static Map zzmm = new HashMap() {{
		put( "1" , "中共党员" );
		put( "2" , "团员" );
		put( "3" , "民主党派" );
		put( "4" , "群众" );
	}};


	public static Map whcd = new HashMap() {{
		put( "10" , "研究生" );
		put( "20" , "大学本科" );
		put( "25" , "上大学" );
		put( "30" , "大学专科" );
		put( "40" , "中专（中技）" );
		put( "60" , "高中" );
		put( "70" , "初中" );
		put( "75" , "上中学" );
		put( "80" , "小学" );
		put( "85" , "上小学" );
		put( "98" , "其他" );
	}};
	public static Map hyzk = new HashMap() {{
		put( "1" , "未婚" );
		put( "2" , "已婚" );
		put( "3" , "丧偶" );
		put( "4" , "离婚" );
	}};

	public static Map fbyqk = new HashMap() {{
		put( "2" , "未服兵役" );
		put( "3" , "退出现役" );
		put( "4" , "预备役" );
		put( "5" , "服现役" );
	}};

	public static Map jzzjzlx = new HashMap() {{
		put( "1" , "单人居住" );
		put( "2" , "家庭居住" );
		put( "3" , "多人居住" );
		put( "99" , "其他" );
	}};

	public static Map jzznjzsj = new HashMap() {{
		put( "2" , "半年以下" );
		put( "3" , "半年至五年" );
		put( "4" , "五年以上" );

	}};

	public static Map zzsy = new HashMap() {{
		put( "01" , "务工" );
		put( "06" , "务农" );
		put( "11" , "投资经商" );
		put( "39" , "服务业" );
		put( "53" , "就学" );
		put( "55" , "探亲访友" );
		put( "99" , "其他" );


	}};

	public static Map jzzcslx = new HashMap() {{
		put( "01" , "居民住宅" );
		put( "04" , "集中式住房" );
		put( "05" , "单位宿舍" );
		put( "11" , "建筑工地" );
		put( "17" , "旅馆式住房" );
		put( "99" , "其他" );


	}};


	public static Map jzzfzgx = new HashMap() {{
		put( "1" , "租住" );
		put( "3" , "借住" );
		put( "5" , "自有" );
		put( "99" , "其他" );



	}};

	public static Map bzqk = new HashMap() {{
		put( "0" , "不领证" );
		put( "1" , "首次领证" );
		put( "2" , "换领补领" );
		put( "3" , "持证变更" );



	}};

	public static Map sf = new HashMap() {{

		put( "1" , "是" );
		put( "2" , "否" );




	}};
	public static Map cylx = new HashMap() {{

		put( "1" , "农业" );
		put( "2" , "工业" );

		put( "3" , "服务业" );
		put( "5" , "其他" );


	}};

	public static Map jzzjtgj = new HashMap() {{

		put( "0" , "无" );
		put( "3" , "电动车" );

		put( "5" , "摩托车" );
		put( "6" , "汽车" );
		put( "7" , "其他" );


	}};

	public static Map jzzgxr = new HashMap() {{

		put( "0" , "配偶" );
		put( "2" , "父母" );

		put( "3" , "兄弟姐妹" );
		put( "4" , "其他" );
		put( "5" , "子女" );
		put( "6" , "同事" );
		put( "7" , "同乡" );


	}};

	public static Map xd = new HashMap() {{

		put( "1" , "幼儿园" );
		put( "2" , "小学" );

		put( "3" , "初中" );
		put( "4" , "高中" );
		put( "5" , "其他" );



	}};

	public static Map zdjbqk = new HashMap() {{


		put( "0" , "无" );
		put( "1" , "白血病" );

		put( "2" , "先天性心脏病" );
		put( "3" , "尿毒症" );
		put( "4" , "恶性肿瘤" );
		put( "5" , "其他" );


	}};

	public static Map zxyy = new HashMap() {{


		put( "1" , "原证有效期满" );
		put( "2" , "离开本地" );

		put( "3" , "转为常住户口" );
		put( "4" , "强制遣返" );
		put( "5" , "打击处理" );
		put( "6" , "畏罪潜逃" );
		put( "7" , "死亡" );
		put( "8" , "丢失" );
		put( "9" , "其他" );
		put( "a" , "跨市注销" );


	}};

	public static Map jhr = new HashMap() {{



		put( "1" , "父亲" );

		put( "2" , "母亲" );
		put( "3" , "其他" );
		put( "4" , "祖父母" );
		put( "5" , "外祖父母" );


	}};

	public static Map jzzsblb = new HashMap() {{

		put( "1" , "居住证" );
		put( "2" , "短期居住证" );





	}};

	public static Map jzzlqfs = new HashMap() {{

		put( "1" , "单位领取" );
		put( "2" , "本人领取" );





	}};

	public static Map sflz = new HashMap() {{

		put( "0" , "否" );
		put( "1" , "是" );




	}};

	public static Map mphhz = new HashMap() {{
		put( "1" , "号" );
		put( "2" , "－" );
	}};

	public static Map mphfz = new HashMap() {{
		put( "1" , "号" );
		put( "2" , "座" );
	}};



	public static Map lhqz = new HashMap() {{
		put( "1" , "东楼" );
		put( "2" , "西楼" );
		put( "3" , "南楼" );
		put( "4" , "北楼" );
		put( "5" , "前楼" );
		put( "6" , "后楼" );
	}};

	public static Map dy = new HashMap() {{
		put( "01" , "一单元" );
		put( "02" , "二单元" );
		put( "03" , "三单元" );
		put( "04" , "四单元" );
		put( "05" , "五单元" );
		put( "06" , "六单元 " );
		put( "07" , "七单元" );
		put( "08" , "八单元" );
		put( "09" , "九单元" );
		put( "10" , "十单元" );
		put( "11" , "十一单元" );
		put( "12" , "十二单元" );
		put( "13" , "十三单元 " );
		put( "14" , "十四单元 " );
		put( "15" , "十五单元 " );
		put( "16" , "十六单元" );
		put( "17" , "十七单元 " );
		put( "18" , "十八单元 " );
		put( "19" , "十九单元 " );
		put( "20" , "二十单元" );

		put( "61" , "一组" );
		put( "62" , "二组" );
		put( "63" , "三组" );
		put( "64" , "四组" );
		put( "65" , "五组" );
		put( "66" , "六组" );
		put( "67" , "七组 " );
		put( "68" , "八组" );
		put( "69" , "九组" );
		put( "70" , "十组" );
		put( "71" , "十一组 " );
		put( "72" , "十二组" );
		put( "73" , "十三组" );
		put( "74" , "十四组" );
		put( "75" , "十五组" );
		put( "76" , "十六组" );
		put( "77" , "十七组" );
		put( "78" , "十八组" );
		put( "79" , "十九组" );
		put( "80" , "二十组" );
		put( "81" , "东门" );
		put( "82" , "南门" );
		put( "83" , "西门" );
		put( "84" , "北门 " );
		put( "85" , "中门 " );
		put( "86" , "边门 " );
		put( "87" , "后门" );
		put( "88" , "付门" );
		put( "89" , "前门" );
		put( "90" , "甲单元" );
		put( "91" , "乙单元" );
		put( "92" , "丙单元" );
		put( "93" , "丁单元" );
		put( "94" , "戊单元" );
		put( "95" , "己单元" );
		put( "96" , "庚单元" );
		put( "97" , "辛单元 " );
		put( "98" , "壬单元" );

	}};


	public static Map lhhz = new HashMap() {{
		put( "1" , "幢" );
		put( "2" , "栋" );
		put( "3" , "排" );
		put( "4" , "舍" );
		put( "5" , "楼" );
		put( "6" , "号楼" );
	}};

	public static Map shhz = new HashMap() {{
		put( "1" , "室" );
		put( "2" , "号" );

	}};


	public static Map zjlx = new HashMap() {{
		put( "0" , "公民身份号码" );
		put( "1" , "其他" );
		put( "2" , "港澳来往内地通行证" );
		put( "3" , "台湾来往内地通行证" );
		put( "4" , "护照" );

	}};

	public static Map fwzt = new HashMap() {{
		put( "0" , "居住" );
		put( "1" , "注销" );
		put( "2" , "空置" );
		put( "9" , "其他" );


	}};

	public static Map cbqk = new HashMap() {{
		put( "0" , "养老" );
		put( "1" , "医疗" );
		put( "2" , "失业" );
		put( "3" , "工伤" );
		put( "4" , "生育" );
		put( "5" , "农保" );
		put( "6" , "没有参保" );
		put( "7" , "备用" );


	}};

	//参保情况翻译

	public  static String   getCBQK(Object obj)
	{

		String returnString ="";
		String cbqk=GetSqdmByRight.praseNULL(obj);

		if(cbqk.length()==8)
		{
			for(int i=0;i<cbqk.length();i++)
			{


				if(cbqk.charAt(i)=='1')
				{

					returnString=returnString+GetSqdmByRight.praseNULL(GetSqdmByRight.cbqk.get(i+""))+",";
				}

			}

		}
		if(!returnString.equals(""))
		{
			returnString=returnString.substring(0,returnString.length()-1);

		}

		return returnString;
	}



	//加载字典

	public  static String   getDictString(String  dictname,String table ,String bm)
	{
		String returnString ="";

		if(dictname.equals("门楼牌地址状态"))
		{

			returnString= "         decode("+table+", "
					+"               '1', "
					+"          '新建', "
					+"          '2', "
					+"          '冻结',                                       "
					+"          '3',                                 "
					+"          '替换',                                 "
					+"          '4',                                 "
					+"          '消亡',                                 "
					+"          '5',                                 "
					+"          '注销',                                 "
					+"          '6',                                 "
					+"          '更正',                                 "
					+"          '7',                                 "
					+"          '被替换') "+bm    ;

		}
		else if(dictname.equals("门楼牌是否有效"))
		{

			returnString= "         decode("+table+",'0', '有效', '1', '无效') "+bm    ;


		}
		else if(dictname.equals("出租屋地址门牌号后缀"))
		{

			returnString= "         decode("+table+", '1', '号', '2', '-') "    ;


		}
		else if(dictname.equals("出租屋地址副号后缀"))
		{

			returnString= "         decode("+table+",'1', '号', '2', '座') "    ;


		}
		else if(dictname.equals("出租屋地址幢楼前缀"))
		{

			returnString= "         decode("+table+",'1', '东楼', '2', '西楼','3','南楼','4','北楼','5','前楼','6','后楼'  ) "    ;


		}
		else if(dictname.equals("出租屋地址幢楼后缀"))
		{

			returnString= "         decode("+table+",'1', '幢', '2', '栋','3','排','4','舍','5','楼','6','号楼'  ) "    ;


		}
		else if(dictname.equals("出租屋地址室号后缀"))
		{

			returnString= "         decode("+table+",'1', '室', '2', '号'  ) "    ;


		}


		return   returnString  ;

	}


	//传用户编码
	public  static String   getSqdmByRight0(String  sqdm,String table )
	{

		String returnString ="";

		if(!sqdm.equals("")){

			if(sqdm.length()==14)
			{
				if (sqdm.endsWith("000000000000")) {
					returnString=" and  substr("+table+",0,2) = substr('"+ sqdm+ "',0,2)  ";
				}
				else if (sqdm.endsWith("0000000000")) {
					returnString=" and  substr("+table+",0,4) = substr('"+ sqdm+ "',0,4)  ";
				}
				else if (sqdm.endsWith("00000000")) {
					returnString="  and  substr("+table+",0,6) = substr('"+ sqdm+ "',0,6)  ";
				}
				else if (sqdm.endsWith("00000")) {
					returnString="  and  substr("+table+",0,9) = substr('"+ sqdm+ "',0,9)  ";
				}
				else if (sqdm.endsWith("00")) {
					returnString="  and  substr("+table+",0,12) = substr('"+ sqdm+ "',0,12)  ";
				}
				else {
					returnString="  and  substr("+table+",0,14) = substr('"+ sqdm+ "',0,14)  ";
				}

			}

			else if(sqdm.length()==12)
			{

				if (sqdm.endsWith("0000000000")) {
					returnString=" and  substr("+table+",0,2) = substr('"+ sqdm+ "',0,2)  ";
				}
				else if (sqdm.endsWith("00000000")) {
					returnString=" and  substr("+table+",0,4) = substr('"+ sqdm+ "',0,4)  ";
				}
				else if (sqdm.endsWith("000000")) {
					returnString="  and  substr("+table+",0,6) = substr('"+ sqdm+ "',0,6)  ";
				}
				else if (sqdm.endsWith("000")) {
					returnString="  and  substr("+table+",0,9) = substr('"+ sqdm+ "',0,9)  ";
				}

				else if (sqdm.endsWith("00")) {
					returnString="  and  substr("+table+",0,10) = substr('"+ sqdm+ "',0,10)  ";
				}
				else {
					returnString="  and  substr("+table+",0,12) = substr('"+ sqdm+ "',0,12)  ";
				}




			}
		}

		return   returnString  ;






	}
	public  static String   getSqdmByRight(String  sqdm,String table )
	{

		String returnString ="";

		if(!sqdm.equals("")){

			if(sqdm.length()==12)
			{
				if (sqdm.endsWith("0000000000")) {
					returnString=" and  substr("+table+",0,2) = substr('"+ sqdm+ "',0,2)  ";
				}
				else if (sqdm.endsWith("00000000")) {
					returnString=" and  substr("+table+",0,4) = substr('"+ sqdm+ "',0,4)  ";
				}
				else if (sqdm.endsWith("000000")) {
					returnString="  and  substr("+table+",0,6) = substr('"+ sqdm+ "',0,6)  ";
				}
				else if (sqdm.endsWith("000")) {
					returnString="  and  substr("+table+",0,9) = substr('"+ sqdm+ "',0,9)  ";
				}
				else {
					returnString="  and  substr("+table+",0,12) = substr('"+ sqdm+ "',0,12)  ";
				}

			}

			else if(sqdm.length()==10)
			{

				if (sqdm.endsWith("00000000")) {
					returnString=" and  substr("+table+",0,2) = substr('"+ sqdm+ "',0,2)  ";
				}
				else if (sqdm.endsWith("000000")) {
					returnString=" and  substr("+table+",0,4) = substr('"+ sqdm+ "',0,4)  ";
				}
				else if (sqdm.endsWith("0000")) {
					returnString="  and  substr("+table+",0,6) = substr('"+ sqdm+ "',0,6)  ";
				}
				else if (sqdm.endsWith("0")) {
					returnString="  and  substr("+table+",0,9) = substr('"+ sqdm+ "',0,9)  ";
				}
				else {
					returnString="  and  substr("+table+",0,10) = substr('"+ sqdm+ "',0,10)  ";
				}




			}
		}

		return   returnString  ;






	}

	public  static  String   getSqdmByRight1(String  sqdm,String table1,String table2 )
	{

		String returnString ="";

		if(!sqdm.equals("")){

			if(sqdm.length()==12)
			{


				if (sqdm.endsWith("0000000000")) {
					returnString = " and substr("+table1+",0,2) = substr('"
							+ sqdm
							+ "',0,2) and substr("+table2+",5) = '00000000' and substr("+table2+",3) <> '0000000000' ";

				}

				else if (sqdm.endsWith("00000000")) {

					returnString = " and substr("+table1+",0,4) = substr('"
							+ sqdm
							+ "',0,4) and substr("+table2+",7) = '000000' and substr("+table2+",5) <> '00000000' ";
				}

				else if (sqdm.endsWith("000000")) {
					returnString = " and substr("+table1+",0,6) = substr('"
							+ sqdm
							+ "',0,6) and substr("+table2+",10) = '000' and substr("+table2+",7) <> '000000' ";

				} else if (sqdm.endsWith("000")) {



					returnString = " and "+table1+" = '" + sqdm + "'  and "+table2+" <> '"
							+ sqdm + "'";

				} else {
					returnString = "   and "+table2+" = '"
							+ sqdm + "'";

				}


			}

			else if(sqdm.length()==10)
			{




				if (sqdm.endsWith("00000000")) {
					returnString = " and substr("+table1+",0,2) = substr('"
							+ sqdm
							+ "',0,2) and substr("+table2+",5) = '000000' and substr("+table2+",3) <> '00000000' ";

				}

				else if (sqdm.endsWith("000000")) {

					returnString = " and substr("+table1+",0,4) = substr('"
							+ sqdm
							+ "',0,4) and substr("+table2+",7) = '0000' and substr("+table2+",5) <> '000000' ";
				}

				else if (sqdm.endsWith("0000")) {
					returnString = " and substr("+table1+",0,6) = substr('"
							+ sqdm
							+ "',0,6) and substr("+table2+",10) = '0' and substr("+table2+",7) <> '0000' ";

				} else if (sqdm.endsWith("0")) {



					returnString = " and "+table1+" = '" + sqdm + "'  and "+table2+" <> '"
							+ sqdm + "'";

				} else {
					returnString = "   and "+table2+" = '"
							+ sqdm + "'";

				}




			}
		}

		return   returnString  ;






	}
	public  static  String   getSqdmByRight11(String  sqdm,String table1,String table2 )
	{

		String returnString ="";

		if(!sqdm.equals("")){

			if(sqdm.length()==12)
			{


				if (sqdm.endsWith("0000000000")) {
					returnString = " and substr("+table1+",0,2) = substr('"
							+ sqdm
							+ "',0,2) and substr("+table2+",5) = '00000000' and substr("+table2+",3) <> '0000000000' ";

				}

				else if (sqdm.endsWith("00000000")) {

					returnString = " and substr("+table1+",0,4) = substr('"
							+ sqdm
							+ "',0,4) and substr("+table2+",7) = '000000' and substr("+table2+",5) <> '00000000' ";
				}

				else if (sqdm.endsWith("000000")) {
					returnString = " and substr("+table1+",0,6) = substr('"
							+ sqdm
							+ "',0,6) and substr("+table2+",10) = '000' and substr("+table2+",7) <> '000000' ";

				} else if (sqdm.endsWith("000")) {

					returnString = " and substr("+table1+",0,9) = substr('"
							+ sqdm
							+ "',0,9)  and substr("+table2+",10) <> '000' ";



				} else {
					returnString = "   and "+table2+" = '"
							+ sqdm + "'";

				}


			}

			else if(sqdm.length()==10)
			{




				if (sqdm.endsWith("00000000")) {
					returnString = " and substr("+table1+",0,2) = substr('"
							+ sqdm
							+ "',0,2) and substr("+table2+",5) = '000000' and substr("+table2+",3) <> '00000000' ";

				}

				else if (sqdm.endsWith("000000")) {

					returnString = " and substr("+table1+",0,4) = substr('"
							+ sqdm
							+ "',0,4) and substr("+table2+",7) = '0000' and substr("+table2+",5) <> '000000' ";
				}

				else if (sqdm.endsWith("0000")) {
					returnString = " and substr("+table1+",0,6) = substr('"
							+ sqdm
							+ "',0,6) and substr("+table2+",10) = '0' and substr("+table2+",7) <> '0000' ";

				} else if (sqdm.endsWith("0")) {

					returnString = " and substr("+table1+",0,9) = substr('"
							+ sqdm
							+ "',0,9)  and substr("+table2+",10) <> '0' ";



				} else {
					returnString = "   and "+table2+" = '"
							+ sqdm + "'";

				}




			}
		}

		return   returnString  ;






	}

	/**
	 根据checkbox 选择 是否包含条件
	 */
	public  static  String   getSqdmByRight11(String  sqdm,String table1,String table2,String checkbox1,String checkbox2,String checkbox3,String checkbox4 )
	{

		String returnString ="";
		String returnString1 ="";
		String returnString2 ="";

		String join ="";











		if(!sqdm.equals("")){

			if(sqdm.length()==12)
			{


				if (sqdm.endsWith("00000000")) {

					returnString = " and substr("+table1+",0,4) = substr('"
							+ sqdm
							+ "',0,4) and substr("+table2+",7) = '000000' and substr("+table2+",5) <> '00000000' ";

					returnString2=" and substr("+table1+",0,4) = substr('"
							+ sqdm
							+ "',0,4) ";
				}

				else if (sqdm.endsWith("000000")) {
					checkbox1="0";
					returnString = " and substr("+table1+",0,6) = substr('"
							+ sqdm
							+ "',0,6) and substr("+table2+",10) = '000' and substr("+table2+",7) <> '000000' ";
					returnString2=" and substr("+table1+",0,6) = substr('"
							+ sqdm
							+ "',0,6)  ";

				} else if (sqdm.endsWith("000")) {
					checkbox1="0";
					checkbox2="0";

					returnString = " and substr("+table1+",0,9) = substr('"
							+ sqdm
							+ "',0,9)  and substr("+table2+",10) <> '000' ";
					returnString2="  and substr("+table1+",0,9) = substr('"
							+ sqdm
							+ "',0,9)  ";



				} else {
					checkbox1="0";
					checkbox2="0";
					checkbox3="0";
					returnString = "   and "+table2+" = '"
							+ sqdm + "'";

					returnString2="  and "+table2+" = '"
							+ sqdm + "'  ";

				}

				if(checkbox1.equals("1"))


				{


					returnString1 = "   (substr("+table2+",3) <> '0000000000' and substr("+table2+",5) = '00000000') ";

				}
				if(checkbox2.equals("1"))
				{
					if(!returnString1.equals(""))
					{
						join="  or   ";

					}
					else
					{
						join="  ";

					}
					returnString1=returnString1+join+" ( substr("+table2+",5) <> '00000000' and substr("+table2+",7) = '000000') ";


				}
				if(checkbox3.equals("1"))
				{

					if(!returnString1.equals(""))
					{
						join="  or   ";

					}
					else
					{
						join="  ";

					}
					returnString1=returnString1+join+"  ( substr("+table2+",7) <> '000000' and substr("+table2+",10) = '000')   ";

				}

				if(checkbox4.equals("1"))
				{

					if(!returnString1.equals(""))
					{
						join="  or   ";

					}
					else
					{
						join="  ";

					}
					returnString1=returnString1+join+"  ( substr("+table2+",10) <> '000')  ";

				}


			}


		}




		if(checkbox1.equals("0")&&checkbox2.equals("0")&&checkbox3.equals("0")&&checkbox4.equals("0"))
		{
			return   returnString ;
		}
		else
		{
			return   returnString2+ "and ("+returnString1+")";

		}







	}

	public  static  String   getSqdmByRight11(String  sqdm,String table1,String table2,String checkbox0,String checkbox1,String checkbox2,String checkbox3,String checkbox4 )
	{


		String returnString ="";
		String returnString1 ="";
		String returnString2 ="";

		String join ="";











		if(!sqdm.equals("")){

			if(sqdm.length()==12)
			{

				if (sqdm.endsWith("0000000000")) {

					returnString = " and substr("+table1+",0,2) = substr('"
							+ sqdm
							+ "',0,2) and substr("+table2+",5) = '00000000' and substr("+table2+",3) <> '0000000000' ";

					returnString2=" and substr("+table1+",0,2) = substr('"
							+ sqdm
							+ "',0,2) ";
				}

				else if (sqdm.endsWith("00000000")) {
					checkbox0="0";

					returnString = " and substr("+table1+",0,4) = substr('"
							+ sqdm
							+ "',0,4) and substr("+table2+",7) = '000000' and substr("+table2+",5) <> '00000000' ";

					returnString2=" and substr("+table1+",0,4) = substr('"
							+ sqdm
							+ "',0,4) ";
				}

				else if (sqdm.endsWith("000000")) {
					checkbox0="0";
					checkbox1="0";
					returnString = " and substr("+table1+",0,6) = substr('"
							+ sqdm
							+ "',0,6) and substr("+table2+",10) = '000' and substr("+table2+",7) <> '000000' ";
					returnString2=" and substr("+table1+",0,6) = substr('"
							+ sqdm
							+ "',0,6)  ";

				} else if (sqdm.endsWith("000")) {
					checkbox0="0";
					checkbox1="0";
					checkbox2="0";

					returnString = " and substr("+table1+",0,9) = substr('"
							+ sqdm
							+ "',0,9)  and substr("+table2+",10) <> '000' ";
					returnString2="  and substr("+table1+",0,9) = substr('"
							+ sqdm
							+ "',0,9)  ";



				} else {
					checkbox0="0";
					checkbox1="0";
					checkbox2="0";
					checkbox3="0";
					returnString = "   and "+table2+" = '"
							+ sqdm + "'";

					returnString2="  and "+table2+" = '"
							+ sqdm + "'  ";

				}

				if(checkbox0.equals("1"))


				{


					returnString1 = "   ( substr("+table2+",3) = '0000000000') ";

				}

				if(checkbox1.equals("1"))


				{
					if(!returnString1.equals(""))
					{
						join="  or   ";

					}
					else
					{
						join="  ";

					}
					returnString1=returnString1+join+" (substr("+table2+",3) <> '0000000000' and substr("+table2+",5) = '00000000') ";



				}
				if(checkbox2.equals("1"))
				{
					if(!returnString1.equals(""))
					{
						join="  or   ";

					}
					else
					{
						join="  ";

					}
					returnString1=returnString1+join+" ( substr("+table2+",5) <> '00000000' and substr("+table2+",7) = '000000') ";


				}
				if(checkbox3.equals("1"))
				{

					if(!returnString1.equals(""))
					{
						join="  or   ";

					}
					else
					{
						join="  ";

					}
					returnString1=returnString1+join+"  ( substr("+table2+",7) <> '000000' and substr("+table2+",10) = '000')   ";

				}

				if(checkbox4.equals("1"))
				{

					if(!returnString1.equals(""))
					{
						join="  or   ";

					}
					else
					{
						join="  ";

					}
					returnString1=returnString1+join+"  ( substr("+table2+",10) <> '000')  ";

				}


			}
			else if(sqdm.length()==10)
			{


				if (sqdm.endsWith("00000000")) {

					returnString = " and substr("+table1+",0,2) = substr('"
							+ sqdm
							+ "',0,2) and substr("+table2+",5) = '000000' and substr("+table2+",3) <> '00000000' ";

					returnString2=" and substr("+table1+",0,2) = substr('"
							+ sqdm
							+ "',0,2) ";
				}

				else if (sqdm.endsWith("000000")) {
					checkbox0="0";

					returnString = " and substr("+table1+",0,4) = substr('"
							+ sqdm
							+ "',0,4) and substr("+table2+",7) = '0000' and substr("+table2+",5) <> '000000' ";

					returnString2=" and substr("+table1+",0,4) = substr('"
							+ sqdm
							+ "',0,4) ";
				}

				else if (sqdm.endsWith("0000")) {
					checkbox0="0";
					checkbox1="0";
					returnString = " and substr("+table1+",0,6) = substr('"
							+ sqdm
							+ "',0,6) and substr("+table2+",10) = '0' and substr("+table2+",7) <> '0000' ";
					returnString2=" and substr("+table1+",0,6) = substr('"
							+ sqdm
							+ "',0,6)  ";

				} else if (sqdm.endsWith("0")) {
					checkbox0="0";
					checkbox1="0";
					checkbox2="0";

					returnString = " and substr("+table1+",0,9) = substr('"
							+ sqdm
							+ "',0,9)  and substr("+table2+",10) <> '0' ";
					returnString2="  and substr("+table1+",0,9) = substr('"
							+ sqdm
							+ "',0,9)  ";



				} else {
					checkbox0="0";
					checkbox1="0";
					checkbox2="0";
					checkbox3="0";
					returnString = "   and "+table2+" = '"
							+ sqdm + "'";

					returnString2="  and "+table2+" = '"
							+ sqdm + "'  ";

				}

				if(checkbox0.equals("1"))


				{


					returnString1 = "   ( substr("+table2+",3) = '00000000') ";

				}

				if(checkbox1.equals("1"))


				{

					if(!returnString1.equals(""))
					{
						join="  or   ";

					}
					else
					{
						join="  ";

					}
					returnString1=returnString1+join+" (substr("+table2+",3) <> '00000000' and substr("+table2+",5) = '000000') ";



				}
				if(checkbox2.equals("1"))
				{
					if(!returnString1.equals(""))
					{
						join="  or   ";

					}
					else
					{
						join="  ";

					}
					returnString1=returnString1+join+" ( substr("+table2+",5) <> '000000' and substr("+table2+",7) = '0000') ";


				}
				if(checkbox3.equals("1"))
				{

					if(!returnString1.equals(""))
					{
						join="  or   ";

					}
					else
					{
						join="  ";

					}
					returnString1=returnString1+join+"  ( substr("+table2+",7) <> '0000' and substr("+table2+",10) = '0')   ";

				}

				if(checkbox4.equals("1"))
				{

					if(!returnString1.equals(""))
					{
						join="  or   ";

					}
					else
					{
						join="  ";

					}
					returnString1=returnString1+join+"  ( substr("+table2+",10) <> '0')  ";

				}





			}

		}




		if(checkbox0.equals("0")&&checkbox1.equals("0")&&checkbox2.equals("0")&&checkbox3.equals("0")&&checkbox4.equals("0"))
		{
			return   returnString ;
		}
		else
		{
			return   returnString2+ "and ("+returnString1+")";

		}








	}

	public   static  String   getSqdmByRight5(String  sqdm,String table1,String table2 )
	{

		String returnString ="";

		if(!sqdm.equals("")){

			if(sqdm.length()==12)
			{


				if (sqdm.endsWith("0000000000")) {
					returnString = " substr("+table1+", 0, 4) =  substr("+table2+", 0, 4) ";

				}

				else if (sqdm.endsWith("00000000")) {

					returnString = " substr("+table1+", 0, 6) =  substr("+table2+", 0, 6) ";
				}

				else if (sqdm.endsWith("000000")) {
					returnString = " substr("+table1+", 0, 9) =  substr("+table2+", 0, 9) ";

				} else if (sqdm.endsWith("000")) {
					returnString = " substr("+table1+", 0, 12) =  substr("+table2+", 0, 12) ";

				} else {
					returnString = " substr("+table1+", 0, 12) =  substr("+table2+", 0, 12) ";

				}


			}

			else if(sqdm.length()==10)
			{



				if (sqdm.endsWith("00000000")) {
					returnString = " substr("+table1+", 0, 4) =  substr("+table2+", 0, 4) ";

				}

				else if (sqdm.endsWith("000000")) {

					returnString = " substr("+table1+", 0, 6) =  substr("+table2+", 0, 6) ";
				}

				else if (sqdm.endsWith("0000")) {
					returnString = " substr("+table1+", 0, 9) =  substr("+table2+", 0, 9) ";

				} else if (sqdm.endsWith("0")) {

					returnString = " substr("+table1+", 0, 10) =  substr("+table2+", 0, 10) ";

				} else {

					returnString = " substr("+table1+", 0, 10) =  substr("+table2+", 0, 10) ";

				}






			}
		}

		return   returnString  ;






	}


	public   static  String   getSqdmByRight2(String  sqdm,String table1 )
	{

		String returnString ="";

		if(!sqdm.equals("")){

			if(sqdm.length()==12)
			{


				if (sqdm.endsWith("0000000000")) {
					returnString = "   substr("+table1+", 0, 4)    ";

				}

				else if (sqdm.endsWith("00000000")) {

					returnString = " substr("+table1+", 0, 6) ";
				}

				else if (sqdm.endsWith("000000")) {
					returnString = " substr("+table1+", 0, 9) ";

				} else if (sqdm.endsWith("000")) {
					returnString = table1;

				} else {
					returnString =table1;

				}


			}

			else if(sqdm.length()==10)
			{




				if (sqdm.endsWith("00000000")) {
					returnString = "   substr("+table1+", 0, 4)    ";

				}

				else if (sqdm.endsWith("000000")) {

					returnString = " substr("+table1+", 0, 6) ";
				}

				else if (sqdm.endsWith("0000")) {
					returnString = " substr("+table1+", 0, 9) ";

				} else if (sqdm.endsWith("0")) {
					returnString = table1;

				} else {
					returnString =table1;

				}










			}
		}

		return   returnString  ;






	}


	public   static  String   getSqdmByRight4(String  sqdm,String table1 )
	{

		String returnString ="";

		if(!sqdm.equals("")){

			if(sqdm.length()==12)
			{


				if (sqdm.endsWith("0000000000")) {
					returnString = "   substr("+table1+", 0, 4)||'00000000'    ";

				}

				else if (sqdm.endsWith("00000000")) {

					returnString = " substr("+table1+", 0, 6)||'000000' ";
				}

				else if (sqdm.endsWith("000000")) {
					returnString = " substr("+table1+", 0, 9)||'000' ";

				} else if (sqdm.endsWith("000")) {
					returnString = table1;

				} else {
					returnString =table1;

				}


			}

			else if(sqdm.length()==10)
			{


				if (sqdm.endsWith("00000000")) {
					returnString = "   substr("+table1+", 0, 4)||'000000'    ";

				}

				else if (sqdm.endsWith("000000")) {

					returnString = " substr("+table1+", 0, 6)||'0000' ";
				}

				else if (sqdm.endsWith("0000")) {
					returnString = " substr("+table1+", 0, 9)||'0' ";

				} else if (sqdm.endsWith("0")) {
					returnString = table1;

				} else {
					returnString =table1;

				}


			}
		}

		return   returnString  ;






	}
	public   static  String   getSqdmByRight3(String  sqdm,String table1,String table2 )
	{

		String returnString ="";

		if(!sqdm.equals("")){

			if(sqdm.length()==12)
			{


				if (sqdm.endsWith("0000000000")) {
					returnString = table1+" = substr("+table2+", 0, 4)"   ;



				}

				else if (sqdm.endsWith("00000000")) {

					returnString = table1+" = substr("+table2+", 0, 6)"   ;
				}

				else if (sqdm.endsWith("000000")) {
					returnString = table1+" = substr("+table2+", 0, 9)"   ;

				} else if (sqdm.endsWith("000")) {
					returnString = table1+" = "+ table2   ;

				} else {
					returnString = table1+" = "+ table2   ;

				}


			}

			else if(sqdm.length()==10)
			{




				if (sqdm.endsWith("00000000")) {
					returnString = table1+" = substr("+table2+", 0, 4)"   ;



				}

				else if (sqdm.endsWith("000000")) {

					returnString = table1+" = substr("+table2+", 0, 6)"   ;
				}

				else if (sqdm.endsWith("0000")) {
					returnString = table1+" = substr("+table2+", 0, 9)"   ;

				} else if (sqdm.endsWith("0")) {
					returnString = table1+" = "+ table2   ;

				} else {
					returnString = table1+" = "+ table2   ;

				}





			}
		}

		return   returnString  ;






	}

	public  static String getWhere(String sqdm,String lx) {

		String 社区代码类型 = " t.社区代码 ";

		String w1 = " t.社区代码 ";
		String 社区代码=sqdm;
		String h1="";
		String h2="";

		String h3="";
		String h4="";
		String h5="  order by 单位代码 desc ";

		String h11="";
		String h21=" ";


		if(lx.equals("dcwjbz"))
		{
			社区代码类型=" t.被访人所在社区 ";

		}
		else if(lx.equals("gzl")||lx.equals("tjfx1"))
		{
			if(社区代码.length()==12)
			{
				社区代码类型=" SUBSTR(t.卡号,0,12) ";

			}

			else if(社区代码.length()==10)
			{
				社区代码类型=" SUBSTR(t.卡号,0,10) ";

			}



		}
		else
		{

			社区代码类型=" t.社区代码 ";
		}

		if(社区代码.length()==12)
		{
			if(社区代码.endsWith("0000000000")) {




				h1="   substr("+社区代码类型+",0,4)  ";



				h3=" substr(h.单位代码1,0, 4)  ";
				h4=  "         (select t.name 单位名称,"
						+ "  t.url  "
						+ "   单位代码1 ,"
						+ "  t.url  "
						+ "   单位代码,t.icon  "
						+ "            from sq_tree t   "
						+ "           where   substr(t.url,5,8) = '00000000' and  substr(t.url,3,10)!='0000000000'   "
						+ "       order by  t.icon    ) h "    ;
				h5="  order by   h.icon  ";

				h11="  substr(t.操作人,0,4)     ";

			}

			else if(社区代码.endsWith("00000000")) {




				h1="   substr("+社区代码类型+",0,6)  ";



				h3=" substr(h.单位代码1,0, 6)  ";
				h4=  "         (select t.name 单位名称,"
						+ "  t.url  "
						+ "   单位代码1 ,"
						+ "  t.url  "
						+ "   单位代码,t.icon  "
						+ "            from sq_tree t   "
						+ "           where    substr(t.url,7,6) = '000000' and  substr(t.url,5,8)!='00000000'   and   substr(t.url,1,4) =substr('"+ 社区代码+"',0,4)  "
						+ "       order by  t.icon    ) h "    ;
				h5="  order by   h.icon  ";
				h11="  substr(t.操作人,0,6)     ";


			}
			else if (社区代码.endsWith("000000")) {




				h1="   substr("+社区代码类型+",0,9)  ";

				h2="  and  substr("+社区代码类型+",0,6) = substr('"
						+ 社区代码
						+ "',0,6)   and  substr("+社区代码类型+",7,6)!='000000'    ";

				h3=" substr(h.单位代码1,0, 9)  ";
				h4= "         (select t.社区名称 单位名称,"
						+ w1
						+ "   单位代码1 ,"
						+ w1
						+ "   单位代码 "
						+ "            from sq_sqxx_all t "
						+ "           where  substr(t.社区代码,0, 6) = substr('"
						+ 社区代码
						+ "',0,6) and   substr(t.社区代码,7,6)!='000000'  and   substr(t.社区代码,10,3)='000' "
						+ "           ) h "    ;

				h11="  substr(t.操作人,0,9)     ";
				h21="  and substr(t.操作人,0,6) = substr('"
						+ 社区代码
						+ "',0,6)   and  substr(t.操作人,7,6)!='000000'   ";

			}
			else if(社区代码.endsWith("000"))
			{



				h1="   "+社区代码类型+"  ";

				h2="  and  substr("+社区代码类型+",0,9) = substr('"
						+ 社区代码
						+ "',0,9)   and substr("+社区代码类型+",10,3)!='000'   ";

				h3="   h.单位代码1  ";
				h4=  "         (select t.社区名称 单位名称,"
						+ w1
						+ "   单位代码1 ,"
						+ w1
						+ "   单位代码 "
						+ "            from sq_sqxx_all t "
						+ "           where    substr(t.社区代码,0,9) = substr('"
						+ 社区代码
						+ "',0,9) and    substr(t.社区代码,10,3)!='000' "
						+ "           ) h "   ;
				h11=" t.操作人     ";
				h21="  and substr(t.操作人,0,9) = substr('"
						+ 社区代码
						+ "',0,9)   and  substr(t.操作人,10,3)!='000' ";


			}
			else
			{



				h1="   "+社区代码类型+"  ";

				h2="  and  "+社区代码类型+" = '"
						+ 社区代码
						+ "'      ";

				h3=" h.单位代码1  ";
				h4=  "         (select t.社区名称 单位名称,"
						+ w1
						+ "   单位代码1 ,"
						+ w1
						+ "   单位代码 "
						+ "            from sq_sqxx_all t "
						+ "           where   t.社区代码  ='"
						+ 社区代码
						+ "'  "
						+ "           ) h "   ;

				h11=" t.操作人     ";
				h21="  and t.操作人 = '"
						+ 社区代码
						+ "'    ";


			}

		}

		else if(社区代码.length()==10)
		{
			if(社区代码.endsWith("00000000")) {




				h1="   substr("+社区代码类型+",0,4)  ";



				h3=" substr(h.单位代码1,0, 4)  ";
				h4=  "         (select t.name 单位名称,"
						+ "  t.url  "
						+ "   单位代码1 ,"
						+ "  t.url  "
						+ "   单位代码,t.icon  "
						+ "            from sq_tree t   "
						+ "           where   substr(t.url,5,6) = '000000' and  substr(t.url,3,8)!='00000000'   "
						+ "       order by  t.icon    ) h "    ;
				h5="  order by   h.icon  ";

				h11="  substr(t.操作人,0,4)     ";

			}

			else if(社区代码.endsWith("000000")) {




				h1="   substr("+社区代码类型+",0,6)  ";



				h3=" substr(h.单位代码1,0, 6)  ";
				h4=  "         (select t.name 单位名称,"
						+ "  t.url  "
						+ "   单位代码1 ,"
						+ "  t.url  "
						+ "   单位代码,t.icon  "
						+ "            from sq_tree t   "
						+ "           where    substr(t.url,7,4) = '0000' and  substr(t.url,5,6)!='000000'   and   substr(t.url,1,4) =substr('"+ 社区代码+"',0,4)  "
						+ "       order by  t.icon    ) h "    ;
				h5="  order by   h.icon  ";
				h11="  substr(t.操作人,0,6)     ";


			}
			else if (社区代码.endsWith("0000")) {




				h1="   substr("+社区代码类型+",0,9)  ";

				h2="  and  substr("+社区代码类型+",0,6) = substr('"
						+ 社区代码
						+ "',0,6)   and  substr("+社区代码类型+",7,4)!='0000'  ";

				h3=" substr(h.单位代码1,0, 9)  ";
				h4= "         (select t.社区名称 单位名称,"
						+ w1
						+ "   单位代码1 ,"
						+ w1
						+ "   单位代码 "
						+ "            from sq_sqxx_all t "
						+ "           where  substr(t.社区代码,0, 6) = substr('"
						+ 社区代码
						+ "',0,6) and   substr(t.社区代码,7,4)!='0000'  and   substr(t.社区代码,10,1)='0' "
						+ "           ) h "    ;

				h11="  substr(t.操作人,0,9)     ";
				h21="  and substr(t.操作人,0,6) = substr('"
						+ 社区代码
						+ "',0,6)   and  substr(t.操作人,7,4)!='0000'   ";

			}
			else if(社区代码.endsWith("0"))
			{



				h1="   "+社区代码类型+"  ";

				h2="  and  substr("+社区代码类型+",0,9) = substr('"
						+ 社区代码
						+ "',0,9)   and substr("+社区代码类型+",10,1)!='0'   ";

				h3="   h.单位代码1  ";
				h4=  "         (select t.社区名称 单位名称,"
						+ w1
						+ "   单位代码1 ,"
						+ w1
						+ "   单位代码 "
						+ "            from sq_sqxx_all t "
						+ "           where    substr(t.社区代码,0,9) = substr('"
						+ 社区代码
						+ "',0,9) and    substr(t.社区代码,10,1)!='0' "
						+ "           ) h "   ;
				h11=" t.操作人     ";
				h21="  and substr(t.操作人,0,9) = substr('"
						+ 社区代码
						+ "',0,9)   and  substr(t.操作人,10,1)!='0' ";


			}
			else
			{



				h1="   "+社区代码类型+"  ";

				h2="  and  "+社区代码类型+" = '"
						+ 社区代码
						+ "'      ";

				h3=" h.单位代码1  ";
				h4=  "         (select t.社区名称 单位名称,"
						+ w1
						+ "   单位代码1 ,"
						+ w1
						+ "   单位代码 "
						+ "            from sq_sqxx_all t "
						+ "           where   t.社区代码  ='"
						+ 社区代码
						+ "'  "
						+ "           ) h "   ;

				h11=" t.操作人     ";
				h21="  and t.操作人 = '"
						+ 社区代码
						+ "'    ";


			}

		}



		return h1+"&"+h2+"&"+h3+"&"+h4+"&"+h5+"&"+h11+"&"+h21;
	}


	public  static String   getSqdmByRight6(String  sqdm )
	{

		String returnString ="";

		if(!sqdm.equals("")){

			if(sqdm.length()==12)
			{
				if (sqdm.endsWith("0000000000")) {
					returnString="1023";
				}
				else if (sqdm.endsWith("00000000")) {
					returnString="255";
				}
				else if (sqdm.endsWith("000000")) {
					returnString="63";
				}
				else if (sqdm.endsWith("000")) {
					returnString="15";
				}
				else {
					returnString="3";
				}

			}

			else if(sqdm.length()==10)
			{

				if (sqdm.endsWith("00000000")) {
					returnString="1023";
				}
				else if (sqdm.endsWith("000000")) {
					returnString="255";
				}
				else if (sqdm.endsWith("0000")) {
					returnString="63";
				}
				else if (sqdm.endsWith("0")) {
					returnString="15";
				}
				else {
					returnString="3";
				}




			}
		}

		return   returnString  ;






	}

	public  static String   getSqdmByRight6(String  sqdm,String mjlx )
	{

		String returnString ="";

		if(!sqdm.equals("")){

			if(sqdm.length()==12)
			{
				if (sqdm.endsWith("0000000000")) {
					returnString="776";
				}
				else if (sqdm.endsWith("00000000")) {
					returnString="777";
				}
				else if (sqdm.endsWith("000000")) {
					returnString="778";
				}
				else if (sqdm.endsWith("000")) {
					returnString="779";
				}
				else {
					returnString="780";
				}

			}

			else if(sqdm.length()==10)
			{

				if (sqdm.endsWith("00000000")) {
					returnString="776";
				}
				else if (sqdm.endsWith("000000")) {
					returnString="777";
				}
				else if (sqdm.endsWith("0000")) {
					returnString="778";
				}
				else if (sqdm.endsWith("0")) {
					returnString="779";
				}
				else {
					returnString="780";
				}




			}
		}


		if(mjlx.equals("2"))
		{

			returnString="779";
		}
		return   returnString  ;






	}

	public  static  String   getSqdmByRight7(String  sqdm,String table1,String table2 )
	{


		String returnString ="";

		if(!sqdm.equals("")){

			if(sqdm.length()==12)
			{


				if (sqdm.endsWith("0000000000")) {
					returnString = " and substr("+table1+",0,2) = substr('"
							+ sqdm
							+ "',0,2)  and substr("+table2+",3) <> '0000000000' ";

				}

				else if (sqdm.endsWith("00000000")) {

					returnString = " and substr("+table1+",0,4) = substr('"
							+ sqdm
							+ "',0,4)  and substr("+table2+",5) <> '00000000' ";
				}

				else if (sqdm.endsWith("000000")) {
					returnString = " and substr("+table1+",0,6) = substr('"
							+ sqdm
							+ "',0,6)  and substr("+table2+",7) <> '000000' ";

				} else if (sqdm.endsWith("000")) {



					returnString = " and substr("+table1+",0,9) = substr('"
							+ sqdm
							+ "',0,9)  and substr("+table2+",10) <> '000' ";

				} else {
					returnString = "   and substr("+table1+",0,12) = substr('"
							+ sqdm + "',0,12)  ";

				}


			}

			else if(sqdm.length()==10)
			{




				if (sqdm.endsWith("00000000")) {
					returnString = " and substr("+table1+",0,2) = substr('"
							+ sqdm
							+ "',0,2)  and substr("+table2+",3) <> '00000000' ";

				}

				else if (sqdm.endsWith("000000")) {

					returnString = " and substr("+table1+",0,4) = substr('"
							+ sqdm
							+ "',0,4)  and substr("+table2+",5) <> '000000' ";
				}

				else if (sqdm.endsWith("0000")) {
					returnString = " and substr("+table1+",0,6) = substr('"
							+ sqdm
							+ "',0,6)  and substr("+table2+",7) <> '0000' ";

				} else if (sqdm.endsWith("0")) {



					returnString = " and substr("+table1+",0,9) = substr('"
							+ sqdm
							+ "',0,9)  and substr("+table2+",10) <> '0' ";

				} else {
					returnString = "   and substr("+table1+",0,10) = substr('"
							+ sqdm + "',0,10)  ";

				}




			}
		}

		return   returnString  ;








	}

	public  static String getKeyByValue(Map map, String name) {

		String key="";
		Set  keySet= map.keySet();

		Iterator  iterator = keySet.iterator();

		while(iterator.hasNext()) {

			Object ikey = iterator.next();

			Object ivalue = map.get(ikey);
			if(ivalue.toString().equals(name))
			{
				key=ikey.toString();
				break;

			}



		}


		return key;
	}

	public static String praseNULL(Object obj)
	{
		if(obj==null)
			return "";
		else
			return obj.toString().trim();
	}

	public static void main(String[] args) {
		System.out.println(dy.get("11"));
		System.out.println(getKeyByValue(dy,"一单元"));
	}

}
