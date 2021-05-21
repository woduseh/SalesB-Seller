package handong.capstone2019s.salesb.domain.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Request implements Serializable {
	
	private static final long serialVersionUID = -4669656154489141698L;

	private int seq;
	
	private String ver;

	private String client; // 요청을 보낸 Seller

	private String thePersonInCharge; // 요청을 담당하는 Admin

	private String requestName; // 요청 제목

	private String requestContents; // 요청 내용

	private Date addTime;

	private Date updateTime;

	private Date deleteTime;

}
