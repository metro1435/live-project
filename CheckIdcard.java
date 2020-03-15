/**
 *  
 * �������֤���ɵ����롢���������롢˳���뼰У������ɵġ� 
 * ��1��2λ���ֱ�ʾ�������ڵ�ʡ�ݣ�������������
 * ��3��4λ��ʾ�������ڵص��У����ݣ���
 * ��5��6λ��ʾ�������ڵص��أ����ؼ��У�����GB/T2260�Ĺ涨ִ�С�
 * ��7λ����14λ��ʾ����ĳ����������ʾ����������ꡢ�¡��գ��ꡢ�¡��մ���֮�䲻�÷ָ��������磬ĳ����ĳ���������1984��11��3�գ������������Ϊ19841103����GB/T7408�Ĺ涨ִ�С�
 * ˳�����ʾ��ͬһ����������ʶ�ķ�Χ�ڣ���ͬ�ꡢͬ�¡�ͬ�ճ������˹涨��˳��ţ�������������ԣ�ż�������Ů�ԡ�У�������ISO7064��1983��MOD11-2У����ϵͳ��
 * 
 * ��ʵ���Ĺؼ��������ڼ���У���룬��ʽ���£�
 * 
 * ��(ai * wi)(mod 11)
 * 
 * ��ai * wi��ӵĽ����11ȡģ��
 * 
 * i����ʾ���֤����������Ұ���У�������ڵ�λ����š�
 * 
 * ai����ʾ��iλ���ϵĺ����ַ�ֵ�����磬ĳ�˵����֤����Ϊ"220183********2626"��*�Ų��ִ���������ں��룩����ai����"2��2��0��1��8��3��*��*��*��*��*��*��*��*��2��6��2��6"��
 * 
 * wi����ʾiλ���ϵļ�Ȩ���ӣ���Ȩ���ӵ�ֵ�ӵ�1λ����17λ�ֱ�Ϊ"7��9��10��5��8��4��2��1��6��3��7��9��10��5��8��4��2"��
 * 
 * ͨ������(ai *
 * wi)��������11ȡģ��ȡУ���룬�������Ϊ0�����ȡ��У����Ϊ1������Ϊ1����У����Ϊ0����Ӧ��ϵΪ��0��1������1��0������2��X������3��9������4��8������5��7������6��6������7��5������8��4������9��3������10��2����
 * 
 * ע �� ����15λ���֤����֤��Ҫ�Ƚ�����չΪ18λ����Ҫ��������������չΪ4λ��Ҳ�����ڳ�������ǰ��һ��"19"��
 * 
 */

public class CheckIdcard {
	private final int[] weightNumber = new int[] { 7, 9, 10, 5, 8, 4, 2, 1, 6,
			3, 7, 9, 10, 5, 8, 4, 2, 1 };

	private final int[] checknumber = new int[] { 1, 0, 'X', 9, 8, 7, 6, 5, 4,
			3, 2 };

	// �ж�ָ�����֤��ʽ�Ƿ���ȷ
	public String verify(String cardNumber) {
		String str = "��֤�ɹ�";
		String regx ="\\d{15}|\\d{17}[\\d,X]";
		if(!cardNumber.matches(regx)){
			return "1-��֤ʧ��";
		}
		if (cardNumber.length() == 15) { // ���Ҫ������֤�����֤����Ϊ15λ
			cardNumber = this.fiveteenToeighteen(cardNumber); // ����ת��Ϊ18λ
		}
		if (cardNumber.length() != 18) {
			return "2-��֤ʧ��";
		}
		
		String checkDight = cardNumber.substring(17, 18); // ��ȡҪ������֤���֤�����У���
		if (checkDight.equals(this.getCheckDigit(cardNumber))) { // �ж�У�����Ƿ���ȷ
			return str;
		}
		return "3-��֤ʧ��";
	}

	// ��ȡ���֤�����е�У����
	private String getCheckDigit(String cardNumber) {
		int verify = 0;
		cardNumber = cardNumber.substring(0, 17); // ��ȡ���֤�����е�ǰ17λ
		int sum = 0;
		int[] wi = new int[17]; // ����int������
		for (int i = 0; i < 17; i++) { // ѭ�������鸳ֵ
			String strid = cardNumber.substring(i, i + 1);
			wi[i] = Integer.parseInt(strid);
		}
		for (int i = 0; i < 17; i++) { // ѭ����������
			sum = sum + weightNumber[i] * wi[i]; // ��17λ�������Ȩ���
		}
		verify = sum % 11; // ȡģ
		if (verify == 2) { // ���ģΪ2���򷵻�"X"
			return "X";
		} else {
			return String.valueOf(checknumber[verify]); // ���򷵻ض�Ӧ��У����
		}
	}

	// ��15λ���֤����תΪ18λ���֤����
	public String fiveteenToeighteen(String fifteenNumber) {
		String eighteenNumberBefore = fifteenNumber.substring(0, 6); // ��ȡ�������֤�����еĵ�����
		String eightNumberAfter = fifteenNumber.substring(6, 15); // ��ȡ�������֤�����еĳ���������
		String eighteenNumber;
		eighteenNumber = eighteenNumberBefore + "19"; // ������������"19"
		eighteenNumber = eighteenNumber + eightNumberAfter; // ��ȡ������ӳ���������
		eighteenNumber = eighteenNumber + this.getCheckDigit(eighteenNumber);// ��ȡ���֤��У����
		return eighteenNumber; // ��ת��������֤���뷵��
	}

	public static void main(String[] args) {
		CheckIdcard idcard = new CheckIdcard();
		String idCardStr = "330682198312102"; // ��Ҫ������֤�����֤����
		System.out.println("���֤�ţ�" + idCardStr + "\n"
				+ idcard.verify(idCardStr));
	}

}
