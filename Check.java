/*
*String verify(String cardNumber); 
*判断指定身份证格式是否正确
*
*validPhoneNum(String checkType,String phoneNum);
*checktype:0校验手机号码，1校验座机号码，2两者都校验满足其一就可 
*
*boolean LengthIs8(String str)
*判断order长度是否为8
*/


import java.util.regex.Matcher;  
import java.util.regex.Pattern;  

public class Check
{
	private final int[] weightNumber = new int[] { 7, 9, 10, 5, 8, 4, 2, 1, 6,
			3, 7, 9, 10, 5, 8, 4, 2, 1 };

	private final int[] checknumber = new int[] { 1, 0, 'X', 9, 8, 7, 6, 5, 4,
			3, 2 };

	// 判断指定身份证格式是否正确
	public String verify(String cardNumber) {
		String str = "验证成功";
		String regx ="\\d{17}[\\d,X]";
		if(!cardNumber.matches(regx)){
			return "1-验证失败";
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
//=================================================================================
    	/** 
     * @param checkType 校验类型：0校验手机号码，1校验座机号码，2两者都校验满足其一就可 
     * @param phoneNum 
     * */  
    public static boolean validPhoneNum(String checkType,String phoneNum){  
        boolean flag=false;  
        Pattern p1 = null;  
        Pattern p2 = null;  
        Matcher m = null;  
        p1 = Pattern.compile("^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\\d{8})?$");  
        p2 = Pattern.compile("^(0[0-9]{2,3}\\-)?([1-9][0-9]{6,7})$");  
        if("0".equals(checkType)){  
            System.out.println(phoneNum.length());  
            if(phoneNum.length()!=11){  
                return false;  
            }else{  
                m = p1.matcher(phoneNum);  
                flag = m.matches();  
            }  
        }else if("1".equals(checkType)){  
            if(phoneNum.length()<11||phoneNum.length()>=16){  
                return false;  
            }else{  
                m = p2.matcher(phoneNum);  
                flag = m.matches();  
            }  
        }else if("2".equals(checkType)){  
            if(!((phoneNum.length() == 11 && p1.matcher(phoneNum).matches())||(phoneNum.length()<16&&p2.matcher(phoneNum).matches()))){  
                return false;  
            }else{  
                flag = true;  
            }  
        }  
        return flag;  
    }  
	
//=====================================================================
	public static boolean LengthIs8(String str)
    {
        if (str.length() == 8)
        {
        	return true;
        }
        else
        	return false;    
    }
}