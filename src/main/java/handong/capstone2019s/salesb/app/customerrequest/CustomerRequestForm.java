package handong.capstone2019s.salesb.app.customerrequest;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerRequestForm {

	private Integer seq;
	
	private Integer ver;

	private String client;

	private String thePersonInCharge;

	private String requestName;

	private String requestContents;
	
	private String searchOptions;
	
	private String searchKeywords;

	private Date addTime;

	private Date updateTime;

	private Date deleteTime;

    @Override
    public String toString() {
        return "&seq=" + seq
                + "&client=" + client
                + "&thePersonInCharge=" + thePersonInCharge + "&requestName=" + requestName  
                + "&requestContents=" + requestContents + "&addTime=" + addTime
                + "&updateTime=" + updateTime
                + "&deleteTime=" + deleteTime;
    }
}
