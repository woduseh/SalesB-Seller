package handong.capstone2019s.salesb.domain.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestToSeller implements Serializable {
	private static final long serialVersionUID = 2L;
	
	private Integer seq;
	
	private String customerName;
	
	private String customerCode;
	
	private String requestContent;
	
	private String customerMail;
	
	private Date addDate;
	
	private Date updateDate;
	
	private Date deleteDate;
	
	public RequestToSeller(Integer seq) {
		this.seq= seq;
	}
	
}
