package Enum응용실습;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum PayGrop {
	CASH("현금", Arrays.asList("계좌이체", "무통장입금", "현장결제", "토스")),
	CARD("카드", Arrays.asList("페이코", "신용카드", "카카오페이", "배민페이")),
	ETC("기타", Arrays.asList("포인트", "쿠폰")),
	EMPTY("결제종류없음", Collections.EMPTY_LIST);
	


	private String title;
	private List<String> payList;
	
	PayGrop(String title, List<String> payList) {
		this.title = title;
		this.payList = payList;
	}
	
	public static PayGrop findByPayCode(String code) {
		return Arrays.stream(PayGrop.values())
					 .filter(payGroup -> payGroup.hasPaycode(code))
					 .findAny()
					 .orElse(EMPTY);
	}
	
	// 사용자 정의 메소드 구현
	public boolean hasPaycode(String code) {
		return payList.stream().anyMatch(pay -> pay.equals(code));
	}
	
	public String getTitle() {
		return title;
	}

	public List<String> getPayList() {
		return payList;
	}
}
