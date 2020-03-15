/**
 *  
 * 居民身份证是由地区码、出生日期码、顺序码及校验码组成的。 
 * 第1、2位数字表示公民所在的省份（或自治区）。
 * 第3、4位表示公民所在地的市（或州）。
 * 第5、6位表示公民所在地的县（或县级市），按GB/T2260的规定执行。
 * 第7位～第14位表示公民的出生日期码表示居民出生的年、月、日，年、月、日代码之间不用分隔符，例如，某公民的出生日期是1984年11月3日，其出生日期码为19841103，按GB/T7408的规定执行。
 * 顺序码表示在同一地区码所标识的范围内，对同年、同月、同日出生的人规定的顺序号，奇数分配给男性，偶数分配给女性。校验码采用ISO7064：1983，MOD11-2校验码系统。
 * 
 * 本实例的关键技术在于计算校验码，公式如下：
 * 
 * ∑(ai * wi)(mod 11)
 * 
 * 将ai * wi相加的结果对11取模。
 * 
 * i：表示身份证号码从左向右包括校验码在内的位置序号。
 * 
 * ai：表示第i位置上的号码字符值，例如，某人的身份证号码为"220183********2626"（*号部分代表出生日期号码），则ai代表"2、2、0、1、8、3、*、*、*、*、*、*、*、*、2、6、2、6"。
 * 
 * wi：表示i位置上的加权因子，加权因子的值从第1位～第17位分别为"7、9、10、5、8、4、2、1、6、3、7、9、10、5、8、4、2"。
 * 
 * 通过将∑(ai *
 * wi)计算结果对11取模获取校验码，如果余数为0，则获取的校验码为1；余数为1，则校验码为0。对应关系为（0，1）、（1，0）、（2，X）、（3，9）、（4，8）、（5，7）、（6，6）、（7，5）、（8，4）、（9，3）、（10，2）。
 * 
 * 注 意 对于15位身份证的验证，要先将其扩展为18位。需要将出生日期码扩展为4位。也就是在出生日期前加一个"19"。
 * 
 */

public class CheckIdcard {
	private final int[] weightNumber = new int[] { 7, 9, 10, 5, 8, 4, 2, 1, 6,
			3, 7, 9, 10, 5, 8, 4, 2, 1 };

	private final int[] checknumber = new int[] { 1, 0, 'X', 9, 8, 7, 6, 5, 4,
			3, 2 };

	// 判断指定身份证格式是否正确
	public String verify(String cardNumber) {
		String str = "验证成功";
		String regx ="\\d{15}|\\d{17}[\\d,X]";
		if(!cardNumber.matches(regx)){
			return "1-验证失败";
		}
		if (cardNumber.length() == 15) { // 如果要进行验证的身份证号码为15位
			cardNumber = this.fiveteenToeighteen(cardNumber); // 将其转换为18位
		}
		if (cardNumber.length() != 18) {
			return "2-验证失败";
		}
		
		String checkDight = cardNumber.substring(17, 18); // 获取要进行验证身份证号码的校验号
		if (checkDight.equals(this.getCheckDigit(cardNumber))) { // 判断校验码是否正确
			return str;
		}
		return "3-验证失败";
	}

	// 获取身份证号码中的校验码
	private String getCheckDigit(String cardNumber) {
		int verify = 0;
		cardNumber = cardNumber.substring(0, 17); // 获取身份证号码中的前17位
		int sum = 0;
		int[] wi = new int[17]; // 创建int型数组
		for (int i = 0; i < 17; i++) { // 循环向数组赋值
			String strid = cardNumber.substring(i, i + 1);
			wi[i] = Integer.parseInt(strid);
		}
		for (int i = 0; i < 17; i++) { // 循环遍历数组
			sum = sum + weightNumber[i] * wi[i]; // 对17位本利码加权求和
		}
		verify = sum % 11; // 取模
		if (verify == 2) { // 如果模为2，则返回"X"
			return "X";
		} else {
			return String.valueOf(checknumber[verify]); // 否则返回对应的校验码
		}
	}

	// 将15位身份证号码转为18位身份证号码
	public String fiveteenToeighteen(String fifteenNumber) {
		String eighteenNumberBefore = fifteenNumber.substring(0, 6); // 获取参数身份证号码中的地区码
		String eightNumberAfter = fifteenNumber.substring(6, 15); // 获取参数身份证号码中的出生日期码
		String eighteenNumber;
		eighteenNumber = eighteenNumberBefore + "19"; // 将地区码后面加"19"
		eighteenNumber = eighteenNumber + eightNumberAfter; // 获取地区码加出生日期码
		eighteenNumber = eighteenNumber + this.getCheckDigit(eighteenNumber);// 获取身份证的校验码
		return eighteenNumber; // 将转换后的身份证号码返回
	}

	public static void main(String[] args) {
		CheckIdcard idcard = new CheckIdcard();
		String idCardStr = "330682198312102"; // 需要进行验证的身份证号码
		System.out.println("身份证号：" + idCardStr + "\n"
				+ idcard.verify(idCardStr));
	}

}
