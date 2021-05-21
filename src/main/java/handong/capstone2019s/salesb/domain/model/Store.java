package handong.capstone2019s.salesb.domain.model;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.data.annotation.Version;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Store implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1963073905840141910L;

	private String storeCode;
	
	private String storeName;
	
	@Version
	private Integer ver;

	private Date addTime;

	private Date updateTime;

	private Date deleteTime;
	
	private Seller seller;
}
