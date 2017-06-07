package com.speedata.residencecard;

//import com.cyber.tools.GetSqdmByRight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ParseIdinfor {
	public IDInfor parseResidence(byte[] bytes){
		IDInfor idInfor=new IDInfor();
		try {
			String data = readFile();//new String(DataConversionUtils.byteArrayToString(bytes));
			System.out.println("---data" + data.length() + "  " + data);
			String xm = CodedConversion.decode1(cutCode(data.substring(0, 60))).trim();
			System.out.println("---name" + xm);
			System.out.println("---name" + JSEscape.unescape(xm));
			idInfor.setName(JSEscape.unescape(xm));

			//sex_temp
			String sex_temp = stringFilter(cutCode(data.substring(60, 61))).trim();
			System.out.println("---sex_temp" + sex_temp);
			//翻译性别
			String sex = GetSqdmByRight.praseNULL(GetSqdmByRight.xb.get(sex_temp));
			System.out.println(sex);
			idInfor.setSex(sex);

			//nation 民族
			String mz = stringFilter(cutCode(data.substring(61, 63))).trim();
			System.out.println("---nation" + mz);
			//翻译民族
			String nation = GetSqdmByRight.praseNULL(GetSqdmByRight.mz.get(mz));
			System.out.println("---nation" + nation);
			idInfor.setNation(nation);

			//出生年月日
			String csrq = stringFilter(cutCode(data.substring(63, 71))).trim();
			System.out.println("---csrq" + csrq);
			idInfor.setBirthday(csrq);

			//居住证号
			String gmsfhm = stringFilter(cutCode(data.substring(71, 89))).trim();
			System.out.println("---gmsfhm" + gmsfhm);
			idInfor.setIdnum(gmsfhm);

			//地址
			String hjdz = CodedConversion.decode1(cutCode(data.substring(89, 389))).trim();
			String unescape = JSEscape.unescape(hjdz);
			System.out.println("---unescape" + unescape);
			idInfor.setAddress(unescape);


			//身高
			System.out.println("shengao=" + data.substring(389, 392).trim());
			String sg = stringFilter(cutCode(data.substring(389, 392))).trim();
			System.out.println("---sg" + sg);

			String zzmm = stringFilter(cutCode1(data.substring(392, 394))).trim();
			System.out.println("---zzmm" + zzmm);
			//翻译政治面貌
			System.out.println("polity:" + GetSqdmByRight.praseNULL(GetSqdmByRight.zzmm.get(zzmm)));

			//婚姻状况
			String hyzk = stringFilter(cutCode1(data.substring(394, 396))).trim();
			System.out.println("---marriage-" + hyzk);
			idInfor.setPolitics(hyzk);

			//文化程度
			System.out.println(GetSqdmByRight.praseNULL(GetSqdmByRight.hyzk.get(hyzk)));
			String whcd = stringFilter(cutCode(data.substring(396, 398))).trim();
			idInfor.setMarriage_status(whcd);
			System.out.println("---educational_level=" + whcd);
			//翻译文化程度
			String educational = GetSqdmByRight.praseNULL(GetSqdmByRight.whcd.get(whcd));
			System.out.println(educational);
			idInfor.setEducational_level(educational);

			//服兵役情况
			String fbyqk = stringFilter(cutCode1(data.substring(398, 400))).trim();
			System.out.println("arm_service---" + fbyqk);
			//翻译服兵役情况
			String arm_service = GetSqdmByRight.praseNULL(GetSqdmByRight.fbyqk.get(fbyqk));
			idInfor.setArmy_service(arm_service);
			System.out.println("---arm_service" + arm_service);
			System.out.println(idInfor.toString());
			idInfor.setSuccess(true);
		}catch (Exception e){
			idInfor.setSuccess(false);
			idInfor.setErrorMsg(""+e.getMessage());
		}
		return idInfor;
	}
	public static void main(String[] args) {
		test();



	}

	public static void test() {
		IDInfor idInfor=new IDInfor();
		//String bytes="4E8E78CAFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF101197012054205251970120500356E56531777018FDC5B8953BF6B666C49785A53E3533A53E475304E8C8DEF822A592957CEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF4E8E78CAFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF101197012054205251970120500356E56531777018FDC5B8953BF6B666C49785A53E3533A53E475304E8C8DEF822A592957CEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF";
//		String bytes="551097596021FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF201199510293206211995102961216C5F82CF77016D775B8953BF6D775B8995479EC467EF675156DB7EC4003653F7FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF1504F1F802F";
		String bytes="4E8E78CAFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF101197012054205251970120500356E56531777018FDC5B8953BF6B666C49785A53E3533A53E475304E8C8DEF822A592957CEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF4E8E78CAFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF101197012054205251970120500356E56531777018FDC5B8953BF6B666C49785A53E3533A53E475304E8C8DEF822A592957CEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF";
		String data = new String(bytes.getBytes());
		String xm= CodedConversion.decode1(cutCode(data.substring(0, 60))).trim();
		System.out.println("---xm"+ JSEscape.unescape(xm));

		String xb=stringFilter(cutCode(data.substring(60, 61))).trim();
		System.out.println("---xb"+xb);
		//翻译性别
		System.out.println(GetSqdmByRight.praseNULL(GetSqdmByRight.xb.get(xb)));
		String mz=stringFilter(cutCode(data.substring(61, 63))).trim();
		System.out.println("---mz"+mz);
		//翻译民族
		String x = GetSqdmByRight.praseNULL(GetSqdmByRight.mz.get(mz));
		System.out.println("---x"+x);

		String csrq=stringFilter(cutCode(data.substring(63, 71))).trim();
		System.out.println("---csrq"+csrq);

		String gmsfhm=stringFilter(cutCode(data.substring(71, 89))).trim();
		System.out.println("---gmsfhm"+gmsfhm);

		String hjdz=CodedConversion.decode1(cutCode(data.substring(89, 389))).trim();
		String unescape = JSEscape.unescape(hjdz);
		System.out.println("---unescape"+unescape);


		String sg=stringFilter(cutCode(data.substring(389, 392))).trim();
		System.out.println("---sg"+sg);
		String zzmm=stringFilter(cutCode1(data.substring(392, 394))).trim();
		System.out.println("---zzmm"+zzmm);
		//翻译政治面貌
		System.out.println(GetSqdmByRight.praseNULL(GetSqdmByRight.zzmm.get(zzmm)));
		String hyzk=stringFilter(cutCode1(data.substring(394, 396))).trim();
		System.out.println("---hyzk"+hyzk);
		idInfor.setPolitics(hyzk);
		//翻译婚姻状况
		System.out.println(GetSqdmByRight.praseNULL(GetSqdmByRight.hyzk.get(hyzk)));
		String whcd=stringFilter(cutCode(data.substring(396, 398))).trim();
		idInfor.setMarriage_status(whcd);
		System.out.println("---whcd"+whcd);
		//翻译文化程度
		String educational = GetSqdmByRight.praseNULL(GetSqdmByRight.whcd.get(whcd));
		System.out.println(educational);
		idInfor.setEducational_level(educational);
		String fbyqk=stringFilter(cutCode1(data.substring(398, 400))).trim();
		System.out.println("---fbyqk"+fbyqk);
		//翻译服兵役情况
		String arm_service = GetSqdmByRight.praseNULL(GetSqdmByRight.fbyqk.get(fbyqk));
		idInfor.setArmy_service(arm_service);
		System.out.println("---arm_service"+arm_service);
		System.out.println(idInfor.toString());
	}

	/**
	 * 替换字符串空白部分为空格
	 *
	 * @param code
	 * @return
	 */
	public static String cutCode(String code) {
		String result = code;
		String temporary;
		for (int i = 0; i < code.length() / 4; i++) {
			temporary = code.substring(i * 4, (i + 1) * 4).replace("FFFF",
					"2020").replace("20FF", "2020").replace("FF20", "2020")
					.replace("F20F", "2020").replace("\uF8F5\uF8F5\uF8F5\uF8F5","2020");
			result = result.substring(0, i * 4) + temporary
					+ result.substring((i + 1) * 4);
		}
		return result;

	}

	/**
	 * 替换字符串FF部分为空格
	 * 适用于CPU卡
	 * @param code
	 * @return
	 */
	public static String cutCode1(String code) {
		String result = "";
		String temporary;
		for (int i = 0; i < code.length();i++) {
			if(String.valueOf(code.charAt(i)).equalsIgnoreCase("F") ){
				temporary = code.substring(i ,i+1).replace("F","");
				result += temporary;
			}else{
				temporary = code.substring(i ,i+1);
				result += temporary;
			}
//			if(String.valueOf(code.charAt(i)).equalsIgnoreCase("F") &&String.valueOf(code.charAt(i+1)).equalsIgnoreCase("F")){
//				temporary = code.substring(i , i + 2).replace("FF","").replace("20", "");
//				result += temporary;
//			}else{
//				temporary = code.substring(i , i + 2).trim();
//				result += temporary;
//			}
//			i+=2;
		}
//		System.out.println(result);
		return result;

	}

	/**
	 * 过滤字符串乱码
	 *
	 * @param str
	 * @return
	 */
	public static String stringFilter(String str) {
		str = str
				.replaceAll(
						"[^(\u4e00-\u9fa5)|(\u0030-\u0039)|(\u0061-\u007a)|(\u0041-\u005a)|(\u0028-\u003A)]",
						"");// 过滤
		return str;
	}
	public String readFile(){
		StringBuffer stringBuffer=new StringBuffer();
		try {
			String encoding="GBK";
			String pathName="/sdcard/test/";
			String fileName="file.txt";
			File file=new File(pathName+fileName);
			if(file.isFile() && file.exists()){ //判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file),encoding);//考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while((lineTxt = bufferedReader.readLine()) != null){
					System.out.println(lineTxt);
					stringBuffer.append(lineTxt);
				}
				read.close();
			}else{
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return stringBuffer.toString();
	}
}
